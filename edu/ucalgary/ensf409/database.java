package edu.ucalgary.ensf409;

import java.sql.DriverManager;
import java.util.ArrayList;

import java.sql.*;

//used to create a connect to the database and import information from the tables in the database so they can be used easily with the rest of the classes

public class database {

    private String DBURL = "";
    private NutritionInfo[] daily_client_needs = new NutritionInfo[4];
    private ArrayList<Food> availabe_food = new ArrayList<Food>();

    private static Connection dbConnect;
    private static ResultSet results;

    public database(String db_URL) {        //constructor to call the database
        this.DBURL = db_URL;
    }
    
    public void createConnection() {            //creates a connection from the code to the database
        try {
            dbConnect = DriverManager.getConnection(DBURL, "student", "ensf409");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDBURL() {          //gets the database URL
         return this.DBURL;
    }

    public void fillClientNeeds() {     //fills the needs of the client from the database

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

    public void fillFoodList() {            //fills the list of available food from the database

        try {
            Statement mySmt = dbConnect.createStatement();
            results = mySmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
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

    public void deleteFoodList(int id) {            //removes a food item from the available list
        try {
            
            String query = "DELETE FROM available_food WHERE ItemID = ?";
            
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setInt(1,  id);
            
            myStmt.executeUpdate();
            
            myStmt.close();
        
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }

    public NutritionInfo[] getClients() {           //returns the daily needs of the clients
        return this.daily_client_needs;
    }

    public NutritionInfo getClient(int id) {        //returns the daily needs of a specific client
        return this.daily_client_needs[id];
    }

    public ArrayList<Food> getFoodItems() {         //returns items of food from the available list
        return this.availabe_food;
    }

    public Food returnFoodItem(int id) {            //returns a specific food item from the available list
        return this.availabe_food.get(id-1);
    }
    
}
