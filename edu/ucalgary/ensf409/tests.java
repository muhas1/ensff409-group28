package edu.ucalgary.ensf409;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class tests {
    
    // MUHAMMAD TESTS

    /*
    Food class tests
    */
    @Test
    public void testFoodConstructor() {
        Food newFood = Food(caloricList);
        assertNotNull("Food class constructor did not work properly", newFood);
    }

    @Test
    public void testVeggieReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	double actual = newItem.getFruitsVeggies();
        double expected = 96.0;
        assertEquals("Veggies did not return what was expected", expected, actual);
    }

    @Test
    public void testProteinReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	double actual = newItem.getProtein();
        double expected = 12.0;
        assertEquals("Protein did not return what was expected of protein",expected, actual);
    }

    @Test
    public void testOtherReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	double actual = newItem.getOther();
        double expected = 12.0;
        assertEquals("Veggies did not return what was expected", expected, actual);
    }

    @Test
    public void testGrainReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	double actual = newItem.getGrains();
        double expected = 0.0;
        assertEquals("Grain did not return what was expected",expected, actual);
    }
    
    @Test
    public void testFoodInfoReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	String actual = newItem.getFoodInfo();
        String expected = "";
        assertEquals("FoodInfo did not return what was expected ",expected, actual);
    }
    
    @Test
    public void testCalorieReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	double actual = newItem.getCalories();
        double expected = 120.0;
        assertEquals("Calories did not return what was expected ",expected, actual);
    }
    
    @Test
    public void testFoodIDReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	String actual = newItem.getFoodID();
        String expected = "";
        assertEquals("FoodID did not return what was expected ",expected, actual);
    }
    
    @Test
    public void testFoodNameReturnStatement() {
    	database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
    	String actual = newItem.getFoodName();
        String expected = "Tomato Sauce, jar";
        assertEquals("Food Name did not return what was expected ",expected, actual);
    }


    // Testing People Class
    @Test
    public void testPeopleConstructor() {
        People newPerson = new People(2, "AdultM", myInventory.getClient(1));
        assertNotNull("The constructor for People did not produce a correct response",newPerson);
    }

    @Test
    public void getPeopleNeeds() {
        People person = new People(2, "AdultM", myInventory.getClient(1));
        String actual = person.getPeopleNutritionalContents();
        String expected = "3210";
        assertEquals("The expected value for the return of the nutritional contents needed did not match the actual",expected, actual);
    }

    @Test
    public void returnPersonInfo() {
        People person = new People(2, "AdultM", myInventory.getClient(1));
        String expected = "18235";
        String actual = person.returnID();
        assertEquals("ID did not Match",expected, actual);
    }

    // Testing Hamper Class

    @Test
    public void testingHamperConstructor() {
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
        newF[0] = new People(1, "M", tempInventory.getClient(1));

        Hamper newHamper = new Hamper(newF, emptyFoodList);
        assertNotNull("Hamper Constructor returned a null value", newHamper);
    }

    @Test
    public void setterGetterNutritionTest() {
        Hamper newHamper = new Hamper(args);
        newHamper.setNutrition(args);
        String expected = "args"; // Arbitrary Argument
        String actual = newHamper.getNutrition();
        assertEquals("The setter for the nutrition was not set properly or the getter did not work",expected, actual);

    }

    // @Test
    // public void setterGetterNutritionTest() {
    //     Hamper newHamper = new Hamper(args);
    //     newHamper.setNutrition(args);
    //     String expected = "args"; // Arbitrary Argument
    //     String actual = newHamper.getNutrition();
    //     assertEquals("The setter for the nutrition was not set properly or the getter did not work",expected, actual);

    // }

    @Test 
    public void testCaloricCalcConstructor() {

        //1childO , 1 Female

        CaloricCalc test = new CaloricCalc(inventory, newHamper);
        assertNotNull("CaloricCalc class constructor did not work properly", test);   
    }
    
    @Test
    public void testOptimalHamper() {
    	
    	CaloricCalc test = new CaloricCalc(ivent, );
    	Food[] actual = test.calculateOptimalHamper();
    	Food[] expected = 
    	assertEquals("The Calculation for finding the optimal Hamper did not work.", expected, actual);
    }
    
    //400 grain
    //700 FruitsVeggies
    //650 Protein
   // 750 other
    


    @Test
    public void setterGetterContentTest() {
        Hamper newHamper = new Hamper(args);
        newHamper.setContent(args);
        String expected = "args"; // Arbitrary Argument
        String actual = newHamper.getContent();
        assertEquals("The setter for the nutrition was not set properly or the getter did not work",expected, actual);

    }

    @Test
    public void clientReturnFunction() {
        Hamper newHamper = new Hamper(args);
        String[] actual = newHamper.returnClientInfo();
        String[] expected = newHamper.returnClientArray();


        assertArrayEquals("Arrays did not match for the client information", expected, actual);

    }

    // Testing Order Form

    @Test 
    public void orderConstructorTest() {
        Order newOrder = new Order(ArrayContainingInventory);
        assertNotNull("Constructor did not work properly in creating a new order form", newOrder);
    }


    // ARUSH TESTS
    @test
	public void testDeleteFromDataBase() {
		
		Order  myJDBC = new Order("jdbc:mysql://localhost/inventory","student","ensf");
		myJDBC.initializeConnection();
		myJDBC.deleteAvaliableFood("0");
        System.out.println("Tomato Sauce jar should now be deleted.");
	}
	
	
	
	@test
	public void testFormatOutput() {
		String [] fmtTestData = getFmtTestData();
		Order fmtTest = new Order(fmtTestData);
		String [] expectedOutput = {
				"Name: Bill",
				"Date: 1/03/2022",
				"Original Request",
				"Hamper 1: 1 Adult Male, 1 Adult Female, 1 Child over 8, 1 Child under 8",
				"Hamper 1 Items:"
				
		};
		for(int i = 0; i < expectedOutput[i].length(); i++) {
			if (fmtTest.getFormat[i] != expectedOutput[i]) {
				System.out.print("Test Failed");
			}
		}
		
	}


	public static String[] getFmtTestData() {
		String [] datalog = {
				"Bill",
				"1/03/2022",
				"1",
				"1",
				"1",
				"1",
				"1"
		};
		return datalog;
	}
    
    // JASON TESTS

    // @Test
    // public void setNutritionInfoConstructor() {
    //     NutritionalInfo newNutrition = new NutrionalInfo(grains,protein,veggies,other,total);
    //     assertNotNull("The constructor returned an incorrect object", newNutrition);
    // }

    //     //Test total number of calories for each person and total family
    //     @Test
    //     public void testCaloricCalc() {
    
    //         int expectedMA = 2500;
    //         int actualMA = CaloricCalc.getadultMale;
    //         assertEquals("Error CaloricCal getadultMale", expectedMA, actualMA);
           
    //         int expectedFA = 2000;
    //         int actualFA = CaloricCalc.getadultFemale;
    //         assertEquals("Error CaloricCal getadultMale", expectedFA, actualFA);
           
    //         int expectedKO = 1500;
    //         int actualKO = CaloricCalc.getChildOver;
    //         assertEquals("Error CaloricCal getadultMale", expectedKO, actualKO);
    
    //         int expectedKY = 1000;
    //         int actualKY = CaloricCalc.getChildUnder;
    //         assertEquals("Error CaloricCal getadultMale", expectedKY, actualKY);
            
    //     }
    
        @Test
        public void testOrderForm() {
    
            String expectedAdult = "maurice";
            String expectedchildUnder = "mort";
    
            String actualAdult = orderForm.adultName;
            String actualchildUnder = orderForm.childUnder;
    
            actualAdult = actualAdult.toLowerCase();
            actualAdult = actualAdult.replaceAll("[^\\w]", "");
    
            actualchildUnder = actualchildUnder.toLowerCase();
            actualchildUnder = actualchildUnder.replaceAll("[^\\w]", "");
    
            assertEquals("Error orderForm Adult", expectedAdult, actualAdult);
            assertEquals("Error orderForm Adult", expectedchildUnder, actualchildUnder);
    
        }
    
        @Test 
        public void testGetProtein(){
    
            NuritionalInfo newNutrition = new NutritionalInfo(2,2,2,2,8);
            
            int expected = 2;
            int actual = newNutrition.getProtein();
    
            assertEquals("Error getProtein", expected, actual);
    
        }
    
        public void testGetGrains(){
    
            NuritionalInfo newNutrition = new NutritionalInfo(2,2,2,2,8);
            
            int expected = 2;
            int actual = newNutrition.getGrains();
    
            assertEquals("Error getGrains", expected, actual);
    
        }
    
        public void testGetFruitVeggies(){
    
            NuritionalInfo newNutrition = new NutritionalInfo(2,2,2,2,8);
            
            int expected = 2;
            int actual = newNutrition.getFruitVeggies();
    
            assertEquals("Error getFruitVeggies", expected, actual);
    
        }
    
        public void testGetOther(){
    
            NuritionalInfo newNutrition = new NutritionalInfo(2,2,2,2,8);
            
            int expected = 8;
            int actual = newNutrition.getOther();
    
            assertEquals("Error getOther", expected, actual);
    
        }
    
        public void testGetCalories(){
    
            NuritionalInfo newNutrition = new NutritionalInfo(2,2,2,2,8);
            
            int expected = 2;
            int actual = newNutrition.getCalories();
    
            assertEquals("Error getCalories", expected, actual);
    
        }
    
        @Test
        public void setNutritionInfoConstructor() {
    
            NutritionalInfo newNutrition = new NutrionalInfo(2,2,2,2,8);
          
            assertEquals("The constructor returned an incorrect object", newNutrition);
    
        }
        
        
        @Test
        public void testIllegalArgumentException() {
            boolean correctException = false;
            try{
                People person = new People(1, "Adult", myInventory.getClient(1));
            }
            catch(IllegalArgumentException e){
                correctException = true;
            }
            assertEquals("People did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
        }
        
        
        //database tests
        
        
        
        
        
 
    }



