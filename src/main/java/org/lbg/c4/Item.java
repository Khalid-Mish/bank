package org.lbg.c4;


public class Item
{
    private String description;
    private int quantity;
    private double price;

    public Item( String desc, int qty, double prc )
    {
        description = desc;
        quantity = qty;
        price = prc;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int qty )
    {
        quantity = qty;
    }

    public double   getPrice()
    {
        return price;
    }

    public double getTotalPrice()
    {
        return price * quantity;
    }

    public String getDescription(){
        return this.description;
    }
}
