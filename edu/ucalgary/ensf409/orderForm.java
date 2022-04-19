package edu.ucalgary.ensf409;
import java.io.FileWriter;
import java.io.IOException;

public class orderForm {
    
    //adds the family info and food info into a hamper
    public String createFoodString(Hamper hamper) {
        String temp = "";
        temp += hamper.stringFamilyDetails();
        temp += hamper.returnFoodString();
        return temp;
    }

    public void printToText(Hamper hamper) {
        
        //Prints the orderform to a text file
        try {
            FileWriter myWriter = new FileWriter("ClientOrder.txt");
            myWriter.write(createFoodString(hamper));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

}
