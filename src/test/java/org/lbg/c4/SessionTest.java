package org.lbg.c4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class SessionTest {

    @Test
    public void how_mocks_work() {
        // Arrange
        ArrayList<String> names = mock(ArrayList.class);
        names.add("Selvyn");
        names.add("Samuel");
        names.add("Ligia");
        int expectedResult = 3;
        when(names.size()).thenReturn(3);

        // Act
        int actualResult = names.size();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_if_basket_has_correct_items() {
        // Arrange
        Basket basket = new Basket();
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try {
            expectedResult = objectMapper.writeValueAsString(basket);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        DataStore dataStore = new DataStore();
        Session cut = new Session(dataStore);

        // Act
        String actualResult = cut.getItems();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    interface IRegister {
        String getDelegate(int idx);
        int getNumberRegistered();
    }

    class Register implements IRegister {
        private ArrayList<String> delegates = new ArrayList<>(); // Simulates a DB table

        public Register() {
            delegates.add("Selvyn");
            delegates.add("Lonyin");
            delegates.add("Mish");
        }

        public String getDelegate(int idx) {
            return delegates.get(idx - 1);
        }

        public int getNumberRegistered() {
            return delegates.size();
        }
    }

    class Course {
        private IRegister reg;

        // Constructor to accept a Register (or IRegister)
        public Course(IRegister reg) {
            this.reg = reg;
        }

        public String getLastPersonRegistered() {
            String result = reg.getDelegate(reg.getNumberRegistered());
            return result;
        }
    }

    @Test
    public void verify_lastname_returned_is_lastname_in_register() {
        // Arrange
        IRegister reg = mock(IRegister.class); // Use the interface
        Course cut = new Course(reg);
        String expectedResult = "Mish";
        when(reg.getNumberRegistered()).thenReturn(3); // Return an int
        when(reg.getDelegate(3)).thenReturn("Mish"); // Use 3 to get the last delegate

        // Act
        String actualResult = cut.getLastPersonRegistered();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_basket_total_is_correct(){
        //Arrange
        Basket basket = new Basket();
        Item item1 = new Item("Palak", 2, 0.19); // 1.14


        basket.addItem(item1);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try {
            expectedResult = objectMapper.writeValueAsString(0.38);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);
        Session cut = new Session(dataStore);

        // Act
        String actualResult = cut.getTotalPrice();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_last_item() {
        //Arrange
        Basket basket = mock(Basket.class);
        Item item3 = new Item("Paneer", 1, 1.27); // 1.27
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try {
            expectedResult = objectMapper.writeValueAsString(item3);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);
        when(basket.getLastItem()).thenReturn(item3);
        Session cut = new Session(dataStore);

        // Act
        String actualResult = cut.getLastItemSold();

        // Assert
        assertEquals(expectedResult, actualResult);

    }

}
