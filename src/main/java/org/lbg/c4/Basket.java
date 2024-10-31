package org.lbg.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Basket
{
    private ArrayList<Item> itsItems = new ArrayList<>();

    public Basket(Basket other){
      itsItems = new ArrayList<>(other.itsItems);
    }

    public Basket(){}

    public void addItem( Item item )
    {
        itsItems.add( item );
    }

    public double getTotal()
    {
        double total = 0;

        for( Item item : itsItems )
        {
            total += item.getTotalPrice();
        }
        return total;
    }

    public Item getLastItem() {
        return itsItems.get(itsItems.size() -1);
    }

}
