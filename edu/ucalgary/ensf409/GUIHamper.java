package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class GUIHamper extends JFrame implements ActionListener, MouseListener{

    private int mAdult;
    private int fAdult;
    private int overChild;
    private int underChild;
    
    private JLabel instructions;  					//initialize variables
    private JLabel mAdultLabel;
    private JLabel fAdultLabel;
    private JLabel overChildLabel;
    private JLabel underChildLabel;
    
    private JTextField mAdultInput;
    private JTextField fAdultInput;
    private JTextField overChildInput;
    private JTextField underChildInput;
    private ArrayList<Integer> clients = new ArrayList<Integer>(); 
    
    public void setClients(int a, int f, int co, int cu) {
        clients.add(a);
        clients.add(f);
        clients.add(co);
        clients.add(cu);
    }

    public GUIHamper(){
        super("Fill out the form for hampers");			
        setupGUI();
        setSize(800,800);					//window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        	//close window on exit
        
    }
    
    public void setupGUI(){
        
        instructions = new JLabel("Please enter the number of hampers you require.");			//Instruction for what to do
        mAdultLabel = new JLabel("Number of adult males:");				//label describing 
        fAdultLabel = new JLabel("Number of adult females:");
        overChildLabel = new JLabel("Number of children older than eight:");
        underChildLabel = new JLabel("Number of children younger than eight:");
        
        
        mAdultInput = new JTextField("e.g. 1", 15);    		//Example of what to enter
        fAdultInput = new JTextField("e.g. 1", 15);
        overChildInput = new JTextField("e.g. 2", 15);
        underChildInput = new JTextField("e.g. 3", 15);
        
        mAdultInput.addMouseListener(this);					//check for mouse click
        fAdultInput.addMouseListener(this);
        overChildInput.addMouseListener(this);
        underChildInput.addMouseListener(this);
        
        JButton submitInfo = new JButton("Submit");			//button for submit
        submitInfo.addActionListener(this);					//check for mouse click
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());			//layout setup
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        clientPanel.add(mAdultLabel);
        clientPanel.add(mAdultInput);
        clientPanel.add(fAdultLabel);
        clientPanel.add(fAdultInput);
        clientPanel.add(overChildLabel);
        clientPanel.add(overChildInput);
        clientPanel.add(underChildLabel);
        clientPanel.add(underChildInput);
        submitPanel.add(submitInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    
    public void actionPerformed(ActionEvent event) throws NumberFormatException{
    	 mAdult = Integer.parseInt(mAdultInput.getText());			//saving and validating info
    	 fAdult = Integer.parseInt(fAdultInput.getText());
    	 overChild = Integer.parseInt(overChildInput.getText());
    	 underChild = Integer.parseInt(underChildInput.getText());
        
        if(validateInput()){
            setClients(mAdult, fAdult, overChild, underChild);
            int numHamp = GUIHamperNumber.getHamperNumber();
            
            database myInventory = new database("jdbc:mysql://localhost/food_inventory");
            myInventory.createConnection();
            myInventory.fillClientNeeds();
            myInventory.fillFoodList();
            Food newItem = myInventory.returnFoodItem(1);
            // ArrayList<Food> newList = myInventory.getFoodItems();
            System.out.println(newItem.getFruitsVeggies());
            People newPerson = new People(1, "AdultM", myInventory.getClient(1));
            People newPerson2 = new People(1, "AdultM", myInventory.getClient(1));
            //System.out.println(newPerson.returnNeeds().getGrains());
            Food[] newFoodList = new Food[10];
            for(int i = 0; i < newFoodList.length; i++) {
                newFoodList[i] = myInventory.returnFoodItem(i+1);
            }
            People[] newF = new People[2];
            newF[0] = newPerson;
            newF[1] = newPerson2;

            Hamper newHamper = new Hamper(newF, newFoodList);
            System.out.println(newHamper.getActualNutrition().getProtein());


            String hampVals = idProcessing();
            JOptionPane.showMessageDialog(this, "Hamper created with: " + "\n" + hampVals);
            this.dispose();
            
        }
    }
    
    public void mouseClicked(MouseEvent event){					///mouse checks
        if(event.getSource().equals(mAdultInput))
        	mAdultInput.setText("");
        if(event.getSource().equals(fAdultInput))
        	fAdultInput.setText("");
        if(event.getSource().equals(overChildInput))
        	overChildInput.setText("");
        if(event.getSource().equals(underChildInput))
        	underChildInput.setText("");
                
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    
     private String idProcessing(){

         String ham = new String("Number of adult males: " + String.valueOf(mAdult) + "\n");				//Saving hampers
         ham = ham + ("Number of adult females: " + String.valueOf(fAdult) + "\n");
         ham = ham + ("Number of children older than 8: " + String.valueOf(overChild) + "\n");
         ham = ham + ("Number of children younger than 8: " + String.valueOf(underChild) + "\n");
         return ham;
    }    
    
    private boolean validateInput(){				//Validates if input is working
        
        boolean allInputValid = true;

        if(mAdult < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, mAdult + " Invalid number of Adult males, must be at least 0.");			//dialogue of working message
        }
        if(fAdult < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, fAdult + " Invalid number of Adult females, must be at least 0.");			//dialogue of working message
        }
        if(overChild < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, overChild + " Invalid number of children over 8, must be at least 0.");			//dialogue of working message
        }
        if(underChild < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, underChild + " Invalid number of children under 8, must be at least 0.");			//dialogue of working message
        }
        
        if(mAdult == 0 && fAdult == 0 && overChild == 0 && underChild == 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, " There are no memebers inside the hamper");			//dialogue of working message
        }
        
        return allInputValid;
        
    }

    public ArrayList<Integer> returnClients() {
        return this.clients;
    }
        
}
