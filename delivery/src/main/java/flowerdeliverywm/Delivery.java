package flowerdeliverywm;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long ordermanagementId;
    private Long orderId;
    private String storeName;
    private String itemName;
    private Integer qty;
    private String deliverryStatus;
    private String userName;
    private String ordermanagementStatus;
    private String deliveryStatus;

    @PostPersist
    public void onPostPersist(){
    	if(this.deliveryStatus.equals("departed")) {
            DepartedForDelivery departedForDelivery = new DepartedForDelivery();
            BeanUtils.copyProperties(this, departedForDelivery);
            departedForDelivery.publishAfterCommit();
       }
       if(this.deliveryStatus.equals("completed")) {
           DeliveryCompleted deliveryCompleted = new DeliveryCompleted();
           BeanUtils.copyProperties(this, deliveryCompleted);
           deliveryCompleted.publishAfterCommit();
       }


    }

    @PreRemove
    public void onPreRemove(){
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled();
        BeanUtils.copyProperties(this, deliveryCanceled);
        deliveryCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrdermanagementId() {
        return ordermanagementId;
    }

    public void setOrdermanagementId(Long ordermanagementId) {
        this.ordermanagementId = ordermanagementId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    public String getDeliverryStatus() {
        return deliverryStatus;
    }

    public void setDeliverryStatus(String deliverryStatus) {
        this.deliverryStatus = deliverryStatus;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getOrdermanagementStatus() {
        return ordermanagementStatus;
    }

    public void setOrdermanagementStatus(String ordermanagementStatus) {
        this.ordermanagementStatus = ordermanagementStatus;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }




}
