package flowerdeliverywm;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long itemPrice;
    private String paymentStatus;
    private String storeName;
    private String itemName;
    private Integer qty;

    @PostPersist
    public void onPostPersist(){

        Paid paid = new Paid();
        BeanUtils.copyProperties(this, paid);
        paid.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
    	System.out.println("Forcibly Canceling Order!!!"+this.getOrderId());
//        PaymentCanceled paymentCanceled = new PaymentCanceled();
//        BeanUtils.copyProperties(this, paymentCanceled);
//        paymentCanceled.publishAfterCommit();


        ForciblyCanceled forciblyCanceled = new ForciblyCanceled();
        BeanUtils.copyProperties(this, forciblyCanceled);
        forciblyCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
