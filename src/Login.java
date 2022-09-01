import javax.swing.*;                       //package for frame
import java.awt.*;                          // package for using image class
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{         // JFrame is the function for making frame
                                                                     //ActionListener if for making button getting into action

    JButton login, signup, clear;            //Defined globally to use them outside the constructor also
    JTextField cardtextField;
    JPasswordField pintextField;            //Used to hide what PIN is entered

    Login() {                               //Constructor (called when "Login" object is created)
        setTitle("ATM");

        setLayout(null);                    // Making the border layout null

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg")) ; //Class for using image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //Setting image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);          // Function for setting img on frame
        lable.setBounds(70, 10, 100,100);          //For making custom layout for img
        add(lable);                                                  //Function for placing any component on Frame

        JLabel text = new JLabel("Welcome To ATM");             //Func. for setting up text on layout
        text.setFont(new Font("Oswald", Font.BOLD, 38));   //Font setting
        text.setBounds(200, 40, 400, 40);           //For making custom layout for text
        add(text);

        JLabel cardno = new JLabel("Card No:");             //Func. for setting up text on layout
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));   //Font setting
        cardno.setBounds(120, 150, 150, 30);           //For making custom layout for text
        add(cardno);

                //for making an area to input card no.
        cardtextField = new JTextField();
        cardtextField.setBounds(300, 150, 230, 30); //setting layout
        cardtextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextField);

        JLabel pin = new JLabel("PIN:");             //Func. for setting up text on layout
        pin.setFont(new Font("Raleway", Font.BOLD, 28));   //Font setting
        pin.setBounds(120, 220, 400, 30);           //For making custom layout for text
        add(pin);

            //for making an area to input PIN
        pintextField = new JPasswordField();
        pintextField.setBounds(300, 220, 230, 30); //setting layout
        pintextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pintextField);

                //Sign In Button
        login = new JButton("SIGN IN");         // Function for button
        login.setBounds(300, 300, 100, 30);  //layout
        login.setBackground(Color.BLACK);                      //background colour of button
        login.setForeground(Color.white);                      //font colour of button
        login.addActionListener(this);                      //for making button in action
        add(login);

                //Clear Button
        clear = new JButton("CLEAR");         // Function for button
        clear.setBounds(430, 300, 100, 30);  //layout
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

               //Sign Up Button
        signup = new JButton("SIGN UP");         // Function for button
        signup.setBounds(300, 350, 230, 30);  //layout
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);                // Changing background colour


        setSize(800, 480);      //Function for Size of frame
        setVisible(true);                   //Function to make frame visible
        setLocation(350, 200);        //Function for location...350 from left & 200 from top
    }

            //Tells which button is pressed
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {         // If this button is pressed
            cardtextField.setText("");         // It'll clear everything when "clear" button is pressed
            pintextField.setText("");
        }

        else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardtextField.getText();
            String pinnumber = pintextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else if (ae.getSource() == signup) {
            setVisible(false);                  //to close current frame
            new Signup1().setVisible(true);

        }
    }

    public static void main(String args[]) {

        new Login();                        //Object of class
    }
}
