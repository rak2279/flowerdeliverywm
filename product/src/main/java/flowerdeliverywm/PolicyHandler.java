package flowerdeliverywm;

import flowerdeliverywm.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired ProductRepository productRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted_ModifyStock(@Payload DeliveryCompleted deliveryCompleted){


        if(deliveryCompleted.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + deliveryCompleted.toJson());
            System.out.println("출하 완료 주문 발생");
            System.out.println("주문 번호 : "+ deliveryCompleted.getOrderId());
            Product product= new Product();
            product.setOrderId(deliveryCompleted.getOrderId());
            product.setProductStatus("Loading Confirm!");
            productRepository.save(product);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
