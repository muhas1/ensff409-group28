package edu.ucalgary.ensf409;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

public class database {

    private String DBURL = "";
    private static NutritionInfo[] daily_client_needs = new NutritionInfo[4];
    private static ArrayList<Food> availabe_food = new ArrayList<Food>();

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

    public NutritionInfo[] fillClientNeeds() {

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

        return temporaryStorage;
    }

    public static void fillFoodList() {

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
                availabe_food.add(tempFoodItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Simply for testing purposes
    public static void main(String[] args) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        daily_client_needs = myInventory.fillClientNeeds();
        System.out.println(daily_client_needs[1].getCalories());
        fillFoodList();
        Food newItem = availabe_food.get(1);
        System.out.println(newItem.getFoodID());
    }
}
