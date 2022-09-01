import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.awt.event.*;                            //for action Listener

public class Signup2 extends JFrame implements ActionListener {


    JTextField panTextField, aadharTextField;
    JButton next;
    JComboBox income, education, occupation;
    JRadioButton eYes, eNo, sYes, sNo;
    String formno;

    Signup2(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //Page 1 : Additional details
        JLabel additionalDetail = new JLabel("Page 1: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(290, 80, 400, 30);
        add(additionalDetail);



        //Income
        JLabel Salary = new JLabel("Income");
        Salary.setFont(new Font("Raleway", Font.BOLD, 20));
        Salary.setBounds(100, 240, 200, 30);
        add(Salary);

        String incomecategory[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        //Qualification
        JLabel gender = new JLabel("Qualification");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        String educationalvalues[] = {"Under Graduate", "Graduate", "Post Graduate", "PHd", "Others"};
        education = new JComboBox(educationalvalues);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.white);
        add(education);


        //Occupation
        JLabel marital = new JLabel("Occupation");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 340, 200, 30);
        add( marital);

        String occupationvalues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);




        //PAN Number
        JLabel pan = new JLabel("PAN Number");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        //Aadhar Number
        JLabel city = new JLabel("Aadhar Number");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 440, 200, 30);
        add(city);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        //Senior Citizen
        JLabel senior = new JLabel("Senior Citizen");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 490, 100, 30);
        eYes.setBackground(Color.white);
        add(eYes);
        eNo = new JRadioButton("No");
        eNo.setBounds(450, 490, 100, 30);
        eNo.setBackground(Color.white);
        add(eNo);


        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(eYes);
        seniorgroup.add(eNo);



        //Existing Account
        JLabel acc = new JLabel("Existing Account");
        acc.setFont(new Font("Raleway", Font.BOLD, 20));
        acc.setBounds(100, 540, 200, 30);
        add(acc);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 100, 30);
        sYes.setBackground(Color.white);
        add(sYes);
        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 100, 30);
        sNo.setBackground(Color.white);
        add(sNo);


        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(sYes);
        accountgroup.add(sNo);

        //Next Button for next page
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);


    }
    // Saving Sign Up info from user in Text format
    public void actionPerformed(ActionEvent ae) {

        String sincome = (String) income.getSelectedItem();
        String edu = (String) education.getSelectedItem();
        String occ = (String) occupation.getSelectedItem();

        String senior = null;
        if (eYes.isSelected()) {
            senior = "Yes";
        } else if (eNo.isSelected()) {
            senior = "No";
        }


        String acc = null;
        if (sYes.isSelected()) {
            acc = "Yes";
        } else if (sNo.isSelected()) {
            acc = "No";
        }

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();


        try{
            Conn c = new Conn();
            String query = "insert into signup2 values('"+formno+"', '"+sincome+"', '"+edu+"', '"+occ+"', '"+span+"','"+saadhar+"', '"+senior+"', '"+acc+"')";
            c.s.executeUpdate(query);

            //Signup3
            setVisible(false);
            new Signup3(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }



    }

    public static void main(String args[]){

        new Signup2("");

    }
}
