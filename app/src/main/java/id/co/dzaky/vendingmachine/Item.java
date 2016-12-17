package id.co.dzaky.vendingmachine;

import android.graphics.drawable.Drawable;

/**
 * Created by Zaki on 17/12/2016.
 */

public class Item {
    private String name;
    private int price;
    private int quantity;
    private int image;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
