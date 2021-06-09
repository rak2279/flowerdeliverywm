package flowerdeliverywm;

import flowerdeliverywm.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
	
	@Autowired(required=true)
	private PaymentRepository paymentRepository;
	
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverChecked_Pay(@Payload Checked checked){

        if(checked.isMe()){
            System.out.println("##### listener Checked : " + checked.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(checked.getOrderId());
            payment.setItemName(checked.getItemName());
            payment.setItemPrice(checked.getItemPrice());
            payment.setQty(checked.getQty());
            payment.setPaymentStatus("paid");
            payment.setStoreName(checked.getStoreName());
            paymentRepository.save(payment);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_PaymentCancelRequest(@Payload OrderCancelled orderCancelled){

        if(orderCancelled.isMe()){
            System.out.println("##### listener PaymentCancelRequest : " + orderCancelled.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(orderCancelled.getId());
            payment.setPaymentStatus("paymentCanceled");
            paymentRepository.save(payment);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_OrderReject(@Payload Rejected rejected){

        if(rejected.isMe()){
            System.out.println("##### listener OrderReject : " + rejected.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(rejected.getId());
            payment.setPaymentStatus("rejected");
            paymentRepository.deleteById(rejected.getId());
            
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPrerejected_OrderReject(@Payload Prerejected prerejected){

        if(prerejected.isMe()){
            System.out.println("##### listener OrderPreReject : " + prerejected.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(prerejected.getId());
            payment.setPaymentStatus("prerejected");
            paymentRepository.deleteById(prerejected.getId());
            
            
        }
    }


}
