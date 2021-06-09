package flowerdeliverywm;

import flowerdeliverywm.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            //if (!ordered.validate()) return;
            System.out.println("Order Created");
            if(ordered.isMe()){
                // view 객체 생성
                MyPage myPage = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                myPage.setOrderId(ordered.getId());
                myPage.setStoreName(ordered.getStoreName());
                myPage.setItemName(ordered.getItemName());
                myPage.setOrderQty(ordered.getQty());
                myPage.setItemPrice(ordered.getItemPrice());
                myPage.setUserName(ordered.getUserName());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            //if (!paid.validate()) return;
                // view 객체 조회

                    Optional<MyPage> myPageOptional = myPageRepository.findById(paid.getOrderId());
                    if( myPageOptional.isPresent()) {
                        MyPage myPage = myPageOptional.get();
                        // view 객체에 이벤트의 eventDirectValue 를 set 함
                            myPage.setOrderStatus(paid.getPaymentStatus());
                        // view 레파지 토리에 save
                        myPageRepository.save(myPage);
                    }

           
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_2(@Payload OrderCancelled orderCancelled) {
        try {
            List<MyPage> myPageList = myPageRepository.findByOrderId(orderCancelled.getId());
            for(MyPage myPage : myPageList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setOrderStatus(orderCancelled.getOrderStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
               
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenForciblyCanceled_then_UPDATE_3(@Payload ForciblyCanceled forciblyCanceled) {
        try {
            //if (!forciblyCanceled.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(forciblyCanceled.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setOrderStatus(forciblyCanceled.getPaymentStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistrationCanceled_then_UPDATE_4(@Payload RegistrationCanceled registrationCanceled) {
        try {
            //if (!registrationCanceled.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(registrationCanceled.getOrdermanagementId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setOrderStatus(registrationCanceled.getOrdermanagementStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReceived_then_UPDATE_5(@Payload Received received) {
        try {
            //if (!received.validate()) return;
                // view 객체 조회
           
                List<MyPage> myPageList = myPageRepository.findByOrderId(received.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setOrderStatus(received.getOrdermanagementStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDecorated_then_UPDATE_6(@Payload Decorated decorated) {
        try {
            //if (!decorated.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(decorated.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setOrderStatus(decorated.getOrdermanagementStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_7(@Payload Rejected rejected) {
        try {
            //if (!rejected.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(rejected.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setOrderStatus(rejected.getOrdermanagementStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_8(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            //if (!deliveryCanceled.validate()) return;
                // view 객체 조회
            
                List<MyPage> myPageList = myPageRepository.findByOrderId(deliveryCanceled.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setDeliveryStatus(deliveryCanceled.getDeliveryStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDepartedForDelivery_then_UPDATE_9(@Payload DepartedForDelivery departedForDelivery) {
        try {
            //if (!departedForDelivery.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(departedForDelivery.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setDeliveryStatus(departedForDelivery.getDeliveryStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_10(@Payload DeliveryCompleted deliveryCompleted) {
        try {
            //if (!deliveryCompleted.validate()) return;
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByOrderId(deliveryCompleted.getOrderId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setDeliveryStatus(deliveryCompleted.getDeliveryStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }          
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenChecked_then_UPDATE_11(@Payload Checked checked) {
        try {
            // if (!checked.validate()) return;
                // view 객체 조회
                System.out.println("★★★★★★★★★★★★★★★★★★Checked★★★★★★★★★★★★★★★★★★★★★★"+ checked.getId());
                System.out.println(checked.toJson());
                List<MyPage> myPageList = myPageRepository.findByOrderId(checked.getId());
                for(MyPage myPage : myPageList){
                    myPage.setProductStatus("checked");
                    myPageRepository.save(myPage);
            }           
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_DELETE_1(@Payload OrderCancelled orderCancelled) {
        try {
            //if (!orderCancelled.validate()) return;
            System.out.println("★★★★★ : " + orderCancelled.getId());
            if(orderCancelled.isMe()){
                
                List<MyPage> myPageList = myPageRepository.findByOrderId(orderCancelled.getId());
                for(MyPage myPage : myPageList){
                    myPage.setOrderStatus("OrderCancelled");
                    myPageRepository.save(myPage);
                }

                //myPageRepository.deleteByOrderId(orderCancelled.getId());
            }
            // view 레파지 토리에 삭제 쿼리
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPrerejected_then_DELETE_2(@Payload Prerejected prerejected) {
        try {
            // if (!prerejected.validate()) return;
            System.out.println("★★★★★ : " + prerejected.getOrderId());
            if(prerejected.isMe()){
                
                List<MyPage> myPageList = myPageRepository.findByOrderId(prerejected.getOrderId());
                for(MyPage myPage : myPageList){
                    myPage.setOrderStatus("Prerejected");
                    myPageRepository.save(myPage);
                }
                //myPageRepository.deleteByOrderId(orderCancelled.getId());
            }
            // view 레파지 토리에 삭제 쿼리
            // myPageRepository.deleteByOrderId(prerejected.getOrderId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}