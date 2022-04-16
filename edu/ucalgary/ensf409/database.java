package edu.ucalgary.ensf409;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

public class database {

    private String DBURL = "";
    private NutritionInfo[] daily_client_needs = new NutritionInfo[4];
    private ArrayList<Food> availabe_food = new ArrayList<Food>();

    private static Connection dbConnect;
    private static ResultSet results;

    public database(String db_URL) {
        this.DBURL = db_URL;
    }
    
    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection(DBURL, "student", "ensf409");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDBURL() {
         return this.DBURL;
    }

    public void fillClientNeeds() {

        NutritionInfo temporaryStorage[] = new NutritionInfo[4];

        try {
            Statement mySmt = dbConnect.createStatement();
            results = mySmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");
            int i = 0;

            while (results.next()) {
                temporaryStorage[i] = new NutritionInfo(results.getString("FruitVeggies"), results.getString("Calories"), results.getString("WholeGrains"), results.getString("Protein"), results.getString("Other"));
                i++;
            }
            mySmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.daily_client_needs = temporaryStorage;
    }

    public void fillFoodList() {

        try {
            Statement mySmt = dbConnect.createStatement();
            results = mySmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            int i = 0;
            while (results.next()) {
                NutritionInfo tempInfo = new NutritionInfo(results.getString("FVContent"), results.getString("Calories"), results.getString("GrainContent"), results.getString("ProContent"), results.getString("Other"));
                String[] tempString = new String[2];
                tempString[0] = results.getString("ItemID");
                tempString[1] = results.getString("Name");
                Food tempFoodItem = new Food(tempString, tempInfo);
                this.availabe_food.add(tempFoodItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public NutritionInfo[] getClients() {
        return this.daily_client_needs;
    }

    public ArrayList<Food> getFoodItems() {
        return this.availabe_food;
    }

    public Food returnFoodItem(int id) {
        return this.availabe_food.get(id-1);
    }

    // Simply for testing purposes
    // public static void main(String[] args) {
    //     database myInventory = new database("jdbc:mysql://localhost/food_inventory");
    //     myInventory.createConnection();
    //     myInventory.fillClientNeeds();
    //     System.out.println(myInventory.daily_client_needs[1].getCalories());
    //     myInventory.fillFoodList();
    //     Food newItem = myInventory.availabe_food.get(154);
    //     System.out.println(newItem.getFoodID());
    // }
}
