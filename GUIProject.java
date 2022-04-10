import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class GUIProject extends JFrame implements ActionListener, MouseListener{

    private int hampers;
    
    private JLabel instructions;
    private JLabel hampLabel;
    
    private JTextField hampInput;
    
    public GUIProject(){
        super("Fill out the form for hampers");
        setupGUI();
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    
    public void setupGUI(){
        
        instructions = new JLabel("Please enter the number of hampers you require.");
        hampLabel = new JLabel("Number of Hampers:");
        
        hampInput = new JTextField("e.g. 2", 15);    
        
        hampInput.addMouseListener(this);
        
        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        clientPanel.add(hampLabel);
        clientPanel.add(hampInput);
        submitPanel.add(submitInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    
    public void actionPerformed(ActionEvent event){
    	 hampers = Integer.parseInt(hampInput.getText());
        
        if(validateInput()){
            String hampNum = idProcessing();
            JOptionPane.showMessageDialog(this, "Your pet's clinic ID is " + hampNum);
        }
    }
    
    public void mouseClicked(MouseEvent event){
        if(event.getSource().equals(hampInput))
        	hampInput.setText("");
                
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

        String petID = new String(String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + String.valueOf(petName.charAt(0)) + String.valueOf(birthYear));
        
        return petID;
    }    
    
    private boolean validateInput(){
        
        boolean allInputValid = true;

        if(hampers < 1){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, hampers + " is an invalid birth year. Pets must be born between 1922 and 2022.");
        }
        
        return allInputValid;
        
    }

    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new GUIProject().setVisible(true);        
        });
    }
        
}
      