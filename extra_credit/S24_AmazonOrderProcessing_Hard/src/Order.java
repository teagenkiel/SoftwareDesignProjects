/**
 *
 *
 *
 */
public class Order {

    private final int orderNumber;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String name;
    private final String item;
    private final String category;
    private String shippingCenterNumber;
    private String deliveryTruckNumber;

    public Order(int orderNumber, String address, String city, String state, String zipCode, String name, String item, String category) {
        this.orderNumber = orderNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.name = name;
        this.item = item;
        this.category = category;
        this.shippingCenterNumber = "Not yet assigned";
        this.deliveryTruckNumber = "Not yet assigned";
    }

    public void setShippingCenterNumber(String shippingCenterNumber) {
        this.shippingCenterNumber = shippingCenterNumber;
    }

    public void setDeliveryTruckNumber(String deliveryTruckNumber) {
        this.deliveryTruckNumber = deliveryTruckNumber;
    }

    @Override
    public String toString() {
        return "Order #" + orderNumber + ": " +
                "Address = " + address +
                ", City = " + city +
                ", State = " + state +
                ", Zip Code = " + zipCode +
                ", Name = " + name +
                ", Item = " + item +
                ", Category = " + category +
                ", Shipping Center Number = " + shippingCenterNumber +
                ", Delivery Truck Number = " + deliveryTruckNumber;
    }
}
