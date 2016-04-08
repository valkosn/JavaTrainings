/*
 * Copyright (c) 2016.
 */

package crud;

/**
 * Created by Valko Serhii on 29.03.2016.
 */
public class Record
{
    private int id;
    private String productName;
    private double price;
    private int quantity;

    public Record(int id, String productName, double price, int quantity)
    {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return id + " " + productName + " " + price + " " + quantity;
    }
}
