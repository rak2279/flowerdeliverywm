package flowerdeliverywm;

public class Decorated extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String storeName;
    private String itemName;
    private Integer qty;
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
    public String getOrdermanagementStatus() {
        return ordermanagementStatus;
    }

    public void setOrdermanagementStatus(String ordermanagementStatus) {
        this.ordermanagementStatus = ordermanagementStatus;
    }
}