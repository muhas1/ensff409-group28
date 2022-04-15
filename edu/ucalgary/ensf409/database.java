package edu.ucalgary.ensf409;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

public class database {

    private String DBURL = "";
    private static NutritionInfo[] daily_client_needs = new NutritionInfo[4];
    private ArrayList<Food> availabe_food = new ArrayList<Food>();

    private Connection dbConnect;
    private ResultSet results;

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

    public static void main(String[] args) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        daily_client_needs = myInventory.fillClientNeeds();
        System.out.println(daily_client_needs[1].getCalories());
    }
}
