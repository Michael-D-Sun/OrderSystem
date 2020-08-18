package cn.michael.entity;

public class Order {
    private int id;
    private int deskId;
    private int totalPrice;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deskId=" + deskId +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
