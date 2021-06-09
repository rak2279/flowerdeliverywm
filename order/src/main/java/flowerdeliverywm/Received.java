package flowerdeliverywm;

public class Received extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String paymentStatus;
    private String ordermanagementStatus;

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
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getOrdermanagementStatus() {
        return ordermanagementStatus;
    }

    public void setOrdermanagementStatus(String ordermanagementStatus) {
        this.ordermanagementStatus = ordermanagementStatus;
    }
}