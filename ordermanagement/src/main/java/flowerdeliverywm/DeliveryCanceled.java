package flowerdeliverywm;

public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long ordermanagementId;
    private String deliveryStatus;

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
    public Long getOrdermanagementId() {
        return ordermanagementId;
    }

    public void setOrdermanagementId(Long ordermanagementId) {
        this.ordermanagementId = ordermanagementId;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}