package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /*@Before
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }
    */
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); // now it's 4
        list.addCity(new City("Estevan", "SK"));
        assertEquals(listSize + 1, list.getCount()); // now it's 5
    }

    /**
     * Tests if CustomList.hasCity() method returns true for cities that have been added
     * to the CustomList, and false for cities that have not been added.
     */
    @Test
    public void testHasCity() {
        CustomList list = new CustomList(null, new ArrayList<>());

        City city1 = new City("ZhuHai", "GuangDong");
        City city2 = new City("Canmore", "AB");

        list.addCity(city1);
        list.addCity(city2);

        Assert.assertTrue(list.hasCity(city1));
        Assert.assertTrue(list.hasCity(city2));
        Assert.assertFalse(list.hasCity(new City("Toronto", "ON")));
    }


    /**
     * Tests if CustomList.deleteCity() method correctly removes a city from the CustomList
     * and updates the count of cities in the list.
     */
    @Test
    public void testDeleteCity() {
        CustomList list = new CustomList(null, new ArrayList<>());

        City city1 = new City("Edmonton", "AB");
        City city2 = new City("Vancouver", "BC");
        City city3 = new City("Toronto", "ON");

        list.addCity(city1);
        list.addCity(city2);
        list.addCity(city3);

        Assert.assertEquals(3, list.getCount());

        list.deleteCity(city1);

        Assert.assertEquals(2, list.getCount());
        Assert.assertFalse(list.hasCity(city1));
        Assert.assertTrue(list.hasCity(city2));
        Assert.assertTrue(list.hasCity(city3));
    }

    

}
