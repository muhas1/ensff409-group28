//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah

package edu.ucalgary.ensf409;
import java.io.FileWriter;
import java.io.IOException;

public class orderForm {
    
    /**
     * createFoodString will receive the hamper, within the hamper there exists a function that will return
     * every food item that has been created by Caloric Calc. 
     * OrderForm then also contains PrintToText which uses FileWriter to output a Text file with the name of ClientOrder
     * which will contain all the neccesary items and also the Clients that make up the hamper.
     */

    public String createFoodString(Hamper hamper) {     //used to grab the string from hamper so it came be used sent to the GUI to display information
        String temp = "";
        temp += hamper.stringFamilyDetails();
        temp += hamper.returnFoodString();
        return temp;
    }

    public void printToText(Hamper hamper) {        //This is used to print the hamper order along with client information to a text file called "ClientOrder.txt"
        
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
