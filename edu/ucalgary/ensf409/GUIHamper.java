package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class GUIHamper extends JFrame implements ActionListener, MouseListener{

	private static int hNum = 1;
    private int mAdult;							//initialize variables needed 
    private int fAdult;
    private int overChild;
    private int underChild;
    
    private JLabel instructions;  					
    private JLabel mAdultLabel;
    private JLabel fAdultLabel;
    private JLabel overChildLabel;
    private JLabel underChildLabel;
    
    private JTextField mAdultInput;
    private JTextField fAdultInput;
    private JTextField overChildInput;
    private JTextField underChildInput;
    
    public GUIHamper(){
        super("Fill out the form for hampers");			
        setupGUI();
        setSize(1920,1080);					//window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        	//close window on exit
        
    }
    
    public void setupGUI(){
        
    	instructions = new JLabel("Please enter the number of hampers you require.");			//Instruction for what to do
        mAdultLabel = new JLabel("Number of adult males:");				//label describing 
        fAdultLabel = new JLabel("Number of adult females:");
        overChildLabel = new JLabel("Number of children older than 8:");
        underChildLabel = new JLabel("Number of children younger than 8:");
        
        
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
    
    public void actionPerformed(ActionEvent event){
    	 mAdult = Integer.parseInt(mAdultLabel.getText());			//saving and validating info
    	 fAdult = Integer.parseInt(fAdultLabel.getText());
    	 overChild = Integer.parseInt(overChildLabel.getText());
    	 underChild = Integer.parseInt(underChildLabel.getText());
        
        if(validateInput()){
            String hampNum = idProcessing();
            JOptionPane.showMessageDialog(this, "Your number of hampers is " + hampNum);
            
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
            JOptionPane.showMessageDialog(this, mAdult + " is an invalid birth year. Pets must be born between 1922 and 2022.");			//dialogue of failing message
        }
        if(fAdult < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, fAdult + " is an invalid birth year. Pets must be born between 1922 and 2022.");			//dialogue of failing message
        }
        if(overChild < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, overChild + " is an invalid birth year. Pets must be born between 1922 and 2022.");			//dialogue of failing message
        }
        if(underChild < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, underChild + " is an invalid birth year. Pets must be born between 1922 and 2022.");			//dialogue of failing message
        }
        
        return allInputValid;
        
    }

    
    public static void main(String[] args) {
        hNum = GUIHamperNumber.getHamperNumber();
        for(int i = 1; i <= hNum; i++) {
        	EventQueue.invokeLater(() -> {						//calls GUI
        		new GUIHamper().setVisible(true);      
        		
        });
        }
    }
        
}
