package mapRenderer.utils;

import mapRenderer.Street;

public class StreetQuantity {
    private Number quantity;
    private Number time;

    public StreetQuantity(Number quantity, Number time) {
        this.quantity = quantity;
        this.time = time;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Number getTime() {
        return time;
    }

    public void setTime(Number time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StreetQuantity{" +
                "quantity=" + quantity +
                ", time=" + time +
                '}';
    }
}
