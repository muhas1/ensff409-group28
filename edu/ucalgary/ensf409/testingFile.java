package edu.ucalgary.ensf409;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

import java.util.ArrayList;

import org.junit.Test;

public class testingFile {
    
    /**
     * Food CLass Testing: Getters, Setters, Constructors
     */

    @Test
    public void testingFoodConstructor() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        assertNotNull("Constructor using Strings did not work!",tempFood);
    }

    @Test
    public void testingCaloriesGetter() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        double actual = tempFood.getCalories();
        double expected = 838.0;
        assertEquals("Items are not equal", expected, actual,1);
    }

    @Test
    public void testingFVGetter() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        double actual = tempFood.getFruitsVeggies();
        double expected = 737.44;
        assertEquals("Items are not equal", expected, actual,1);
    }

    @Test
    public void testingProteinGetter() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        double actual = tempFood.getProtein();
        double expected = 0;
        assertEquals("Items are not equal", expected, actual,1);
    }

    @Test
    public void testingOtherGetter() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        double actual = tempFood.getOther();
        double expected = 100.56;
        assertEquals("Items are not equal", expected, actual,1);
    }

    @Test
    public void testingGrainsGetter() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        double actual = tempFood.getGrains();
        double expected = 0;
        assertEquals("Items are not equal", expected, actual,1);
    }

    @Test
    public void testingFoodID() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        String actual = tempFood.getFoodID();
        String expected = "123";
        assertEquals("Items are not equal", expected, actual);
    }

    @Test
    public void testingFoodName() {
        String[] stringInfo = new String[2];
        stringInfo[0] = "123";
        stringInfo[1] = "Dried figs, 500g";
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        Food tempFood = new Food(stringInfo, nInfo);
        String actual = tempFood.getFoodName();
        String expected = "Dried figs, 500g";
        assertEquals("Items are not equal", expected, actual);
    }


    /**
     * Testing People Class: Constructor, Getters
     */

    @Test
    public void testingPeopleConstructor() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillClientNeeds();
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        assertNotNull(testPerson);
    }

    @Test
    public void testingPeopleAgeGetter() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillClientNeeds();
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        String actual = testPerson.returnAge();
        String expected = "AdultM";
        assertEquals("Names are not equal", expected, actual);
    }

    @Test
    public void testingPeopleIDGetter() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillClientNeeds();
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        int actual = testPerson.returnID();
        int expected = 1;
        assertEquals("ID are not equal", expected, actual);
    }

    @Test
    public void testingPeopleNeedsGetter() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillClientNeeds();
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        NutritionInfo actual = testPerson.returnNeeds();
        NutritionInfo expected = tempDatabase.getClient(1);
        assertEquals("Names are not equal", expected, actual);
    }

    /**
     * Hamper Tests: Constructors, Getters, Setters
     */

    @Test
    public void testHamperConstructor() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillFoodList();
        tempDatabase.fillClientNeeds();
        // Creating testing Person Array
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        People[] testArray = new People[2];
        testArray[0] = testPerson;
        testArray[1] = testPerson;
        // Creating a test list
        Food[] newFoodList = new Food[10];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = tempDatabase.returnFoodItem(i+1);
        }
        Hamper testHamper = new Hamper(testArray, newFoodList);
        assertNotNull("Constructor did not work",testHamper);
    }

    @Test
    public void testGetActualNutrition() {
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillFoodList();
        tempDatabase.fillClientNeeds();
        // Creating testing Person Array
        People testPerson = new People(1, "AdultM", tempDatabase.getClient(1));
        People[] testArray = new People[2];
        testArray[0] = testPerson;
        testArray[1] = testPerson;
        // Creating a test list
        Food[] newFoodList = new Food[3];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = tempDatabase.returnFoodItem(i+1);
        }
        Hamper testHamper = new Hamper(testArray, newFoodList);
        double[] expected = new double[]{360,288,0,36,36};
        double[] actual = testHamper.getActualNutrition().getNutArray();
        assertArrayEquals("Arrays are not equal", expected, actual,1);

    }


    @Test
    public void testGetRequiredNutrition() {

        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
        Food[] emptyFoodList = new Food[1];
        emptyFoodList[0] = newItem;
        database tempInventory = new database("jdbc:mysql://localhost/food_inventory");
        tempInventory.createConnection();
        tempInventory.fillClientNeeds();
        People[] newF = new People[1];
        newF[0] = new People(1, "M", tempInventory.getClient(0));

        Hamper newHamper = new Hamper(newF, emptyFoodList);

        double[] expected = new double[]{2500, 700, 400, 650, 750}; 
        double[] actual = newHamper.getRequiredNutrition().getNutArray();
        assertArrayEquals("Error get Required Nutrition",expected, actual,1);

    }
    

}
