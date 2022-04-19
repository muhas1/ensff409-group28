package edu.ucalgary.ensf409;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class GUIHamperNumber extends JFrame implements ActionListener, MouseListener{

    private static int hampers;
    private String name;
    private JLabel nameLabel;
	private JTextField nameInput;
    
    private JLabel instructions;  					//initialize variables
    private JLabel hampLabel;
    
    private JTextField hampInput;
    
    public GUIHamperNumber(){
        super("Fill out the form for hampers");			
        setupGUI();
        setSize(800,800);					//window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        	//close window on exit
        
    }
    
    public void setupGUI() {
        
        instructions = new JLabel("Please enter your name and the number of hampers you require.");			//Instruction for what to do
        nameLabel = new JLabel("Name:");
        hampLabel = new JLabel("Number of Hampers:");				//label describing 
        
        
        nameInput = new JTextField("e.g. Bill", 15);
        hampInput = new JTextField("e.g. 2", 15);    		//Example of what to enter
        
        
        nameInput.addMouseListener(this);
        hampInput.addMouseListener(this);					//check for mouse click
        
        JButton submitInfo = new JButton("Submit");			//button for submit
        submitInfo.addActionListener(this);					//check for mouse click
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());			//layout setup
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        clientPanel.add(nameLabel);
        clientPanel.add(nameInput);
        clientPanel.add(hampLabel);
        clientPanel.add(hampInput);
        submitPanel.add(submitInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    
    public void actionPerformed(ActionEvent event){
    	 hampers = Integer.parseInt(hampInput.getText());			//saving and validating info
        
        if(validateInput()){
            String hampNum = idProcessing();
            JOptionPane.showMessageDialog(this, "Your number of hampers is " + hampNum);
            this.dispose();													//Closes the window after process is done
            for (int i = 1; i <= Integer.valueOf(hampNum); i++) {			//Calls hampers multiple hampers when required
            	new GUIHamper();
            	EventQueue.invokeLater(() -> {							//calling next GUI
            		new GUIHamper().setVisible(true);        
            });
            
            }
            
        }
    }
    
    public void mouseClicked(MouseEvent event){					///mouse checks
        if(event.getSource().equals(hampInput))
        	hampInput.setText("");
        if(event.getSource().equals(nameInput))
        	nameInput.setText("");
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

        String ham = new String(String.valueOf(hampers));				//Saving hampers
        
        return ham;
    }    
    
    private boolean validateInput(){				//Validates if input is working
        
        boolean allInputValid = true;

        if(hampers < 1){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, hampers + " Invalid number of hampers must be greater than 1.");			//dialogue of working message
        }
        
        return allInputValid;
        
    }
    
    
    public String getName() {
    	return this.name;
    }

    
    public static void guiCaller() {
        
        EventQueue.invokeLater(() -> {						//calls GUI
            new GUIHamperNumber().setVisible(true);        
        });
    }

	public static void main(String[] args) {
        guiCaller();
    }
        
}

