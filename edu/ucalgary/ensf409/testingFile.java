package edu.ucalgary.ensf409;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testAddingFoodItem() {
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
        Food[] newFoodList = new Food[1];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = tempDatabase.returnFoodItem(i+1);
        }
        Hamper testHamper = new Hamper(testArray, newFoodList);
        testHamper.addFoodItem(tempDatabase.returnFoodItem(2));
        double[] expected = new double[]{240,192,0,24,24};
        double[] actual = testHamper.getActualNutrition().getNutArray();
        assertArrayEquals("Arrays are not equal", expected, actual,1);
    }

    @Test
    public void testReturnClients() {
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
        Food[] newFoodList = new Food[1];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = tempDatabase.returnFoodItem(i+1);
        }
        Hamper testHamper = new Hamper(testArray, newFoodList);
        People[] expected = testArray;
        People[] actual = testHamper.getPeopleArray();
        assertArrayEquals("Arrays are not equal",expected, actual);
    }

    /**
     * NutritionInfo tests
     */

    @Test
    public void testConstructorNutInfo() {
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        assertNotNull("Constructor did not work",nInfo);
    }
    
    @Test
    public void testNutritionInfoGetters() {
        NutritionInfo nInfo = new NutritionInfo("88", "838", "0", "0", "12");
        double expected = 838.0;
        double actual = nInfo.getCalories();
        assertEquals("Calories are not Equal",expected, actual,1);
        expected = 737.44;
        actual = nInfo.getFV();
        assertEquals("Calories are not Equal",expected, actual,1);
        expected = 0;
        actual = nInfo.getGrains();
        assertEquals("Calories are not Equal",expected, actual,1);
        expected = 0;
        actual = nInfo.getProtein();
        assertEquals("Calories are not Equal",expected, actual,1);
        expected = 100.56;
        actual = nInfo.getOther();
        assertEquals("Calories are not Equal",expected, actual,1);
        
    }

    @Test
    public void testNutrInfoArray() {
        NutritionInfo nInfo = new NutritionInfo(120.0, 420.0, 0.0, 0.0, 300.0);
        double[] expected = new double[]{420.0,120.0,0.0,0.0,300.0}; 
        double[] actual = nInfo.getNutArray();
        assertArrayEquals("Arrays are not equal to eachother",expected, actual,1);
    }

    /**
     * Caloric Calculator Tests
     */

    @Test
    public void testCaloricCalcConstructor() {
        // Creating testing Person Array with Random values that make up the first 4 items in the Database
        People testPerson = new People(1, "Test", new NutritionInfo(288.0, 984.0, 0.0, 36.0, 536.0));
        People[] testArray = new People[2];
        testArray[0] = testPerson;
        testArray[1] = testPerson;
        // Creating a Foodlist with 10 items
        database tempDatabase = new database("jdbc:mysql://localhost/food_inventory");
        tempDatabase.createConnection();
        tempDatabase.fillFoodList();
        tempDatabase.fillClientNeeds();
        // Creating a test list
        Food[] newFoodList = new Food[10];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = tempDatabase.returnFoodItem(i+1);
        }
        ArrayList<Food> tempInventory = new ArrayList<>();
        for(int a = 0; a < newFoodList.length; a++) {
            tempInventory.add(newFoodList[a]);
        }
        
        // Creating a Hamper 
        Hamper testHamper = new Hamper(testArray, newFoodList);
        CaloricCalc testCaloricCalc = new CaloricCalc(tempInventory, testHamper);
        assertNotNull("Constructor did not initialize properly",testCaloricCalc);
    }

    @Test
    public void testCaloricCalculator() {

        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
        ArrayList<Food> newList = myInventory.getFoodItems();
        People tempPerson = new People(1, "Fake", myInventory.getClient(0));
        People tempPerson2 = new People(2, "Fake", myInventory.getClient(1));
        People[] newF = new People[]{tempPerson,tempPerson2,tempPerson,tempPerson};
        Food[] emptyFoodList = new Food[1];
        emptyFoodList[0] = newItem;

        Hamper newHamper = new Hamper(newF, emptyFoodList);
        CaloricCalc newCalculator = new CaloricCalc(newList, newHamper);

        Hamper hamper = new Hamper(newF, newCalculator.calculateOptimalHamper());
        double expecteds = hamper.getRequiredNutrition().getCalories();
        double actuals = hamper.getActualNutrition().getCalories();
        //Testing 
        assertTrue("Number is not within the range of: ", actuals <= expecteds+750 && actuals >= expecteds-750);
    }
}
