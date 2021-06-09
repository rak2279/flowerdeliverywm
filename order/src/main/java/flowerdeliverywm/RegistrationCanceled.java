package flowerdeliverywm;

public class RegistrationCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String ordermanagementStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrdermanagementId() {
        return orderId;
    }

    public void setOrdermanagementId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrdermanagementStatus() {
        return ordermanagementStatus;
    }

    public void setOrdermanagementStatus(String ordermanagementStatus) {
        this.ordermanagementStatus = ordermanagementStatus;
    }
}