import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class GraphicInterface implements ActionListener {

    private User user;
    private String pp;
    private JLabel label;
    private JFrame frame1;
    private JFrame frame2;
    private JPanel panel;
    private JPanel panel2;
    private JLabel balanceNotice;
    int balance = 0;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JTextField userText;

    public GraphicInterface() {
        
        user = new User();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What's Your Name?");
        String name = scan.next();
        name += scan.nextLine();
        user.setName(name);
        
        System.out.println("Set A Pin: ");
        String pin = scan.next();
        user.setPin(pin);
        
        
        
        pp = pin;
        
        frame1 = new JFrame();
        frame2 = new JFrame();

        
        JLabel welcome = new JLabel("Hello, " + user.getName());
        
        button = new JButton("Open Bank");
        button.addActionListener(this);

        label = new JLabel("Pin: ");
        userText = new JTextField(10);
        userText.setBounds(50,50,10,10);
        

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(welcome);
        panel.add(label);
        panel.add(userText);
        panel.add(button);
        panel.setBackground(Color.green);

        frame1.add(panel, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("EBank");
        frame1.pack();
        frame1.setVisible(true);
        //--------------------------------------------------frame 2
        
        
        JLabel welcome2 = new JLabel("Hello, " + user.getName());
        balanceNotice = new JLabel("Your balance is: ");
        
        button2 = new JButton("$5");
        button2.addActionListener(this);
        button3 = new JButton("$10");
        button3.addActionListener(this);
        
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel2.setLayout(new GridLayout(0, 1));
        
        panel2.add(welcome2);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(balanceNotice);
        panel2.setBackground(Color.magenta);
        
        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Money Generator");
        frame2.pack();
        frame2.setVisible(false);
       // ------------------------------------------------
        ImageIcon example = new ImageIcon("filename.jpg");
        JLabel pic = new JLabel(example);
        panel2.add(pic);
        
        
    }


    public static void main(String args[]) {
        
        new GraphicInterface();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == button)
        {
            String pin = userText.getText();
            
            if(pin.equals(pp)) {
            label.setText("Login succesfull");
            frame1.setVisible(false);
            frame2.setVisible(true);
            }
            else {
                label.setText("Incorrect PIN");
                userText.setText("");
            }
            
            if(frame2.isActive())
            {
                if(balance % 2 == 0) {
                    
                    panel2.setBackground(Color.yellow);
                }
                else {
                    panel2.setBackground(Color.cyan);
                }
            balance++;
            balanceNotice.setText("Balance is: $" + balance);  
        }
        
        }
        else if(e.getSource() == button2)
        {
            balance = balance + 5;
            balanceNotice.setText("Balance is: $" + balance); 
        }
        else if(e.getSource() == button3)
        {
            balance = balance + 10;
            balanceNotice.setText("Balance is: $" + balance); 
        }
        }
}
