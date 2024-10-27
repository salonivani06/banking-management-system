package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

//action lister ko overrride krwana pdta  h for use of action listernr 
public class Login extends JFrame implements ActionListener {
  // variables declare globally
  // Jframe ko extend kiya tha label aurffield use krne k liye than for button ko
  // action me aane k liye action listerner ka use krteh

  JLabel label1, label2, label3;
  JTextField textField2;
  JPasswordField passwordField3;
  JButton button1, button2, button3;

  Login() {
    super("Bank Management System ");// header

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);// scale the image
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);// frame pr direct nhi le jaate h to label kee wajah se le jayege

    image.setBounds(350, 10, 100, 100);

    add(image);

    ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
    Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);// scale the image
    ImageIcon ii3 = new ImageIcon(ii2);
    JLabel iimage = new JLabel(ii3);// frame pr direct nhi le jaate h to label kee wajah se le jayege

    iimage.setBounds(630, 350, 100, 100);

    add(iimage);

    // jlabel ka main kaam fame pr text ko show krwana
    label1 = new JLabel("WELCOME TO ATM ");
    label1.setForeground(Color.WHITE);
    label1.setFont(new Font("AvantGarade", Font.BOLD, 38));
    label1.setBounds(230, 125, 450, 40);
    add(label1);

    label2 = new JLabel("Card No");
    label2.setFont(new Font("Raleway", Font.BOLD, 28));
    label2.setForeground(Color.WHITE);
    label2.setBounds(150, 190, 375, 30);
    add(label2);

    textField2 = new JTextField(15);
    textField2.setBounds(325, 190, 230, 30);
    textField2.setFont(new Font("Arial", Font.BOLD, 14));
    add(textField2);
    label3 = new JLabel("PIN No ");
    label3.setFont(new Font("Ralway", Font.BOLD, 28));
    label3.setForeground(Color.WHITE);
    label3.setBounds(150, 250, 375, 30);
    add(label3);

    passwordField3 = new JPasswordField(15);
    passwordField3.setBounds(325, 250, 230, 30);
    passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
    add(passwordField3);

    button1 = new JButton("SIGN IN");
    button1.setFont(new Font("Arial", Font.BOLD, 14));
    button1.setForeground(Color.WHITE);
    button1.setBackground(Color.BLACK);
    button1.setBounds(300, 300, 100, 30);

    button1.addActionListener(this);
    add(button1);

    button2 = new JButton("CLEAR ");
    button2.setFont(new Font("Arial", Font.BOLD, 14));
    button2.setForeground(Color.WHITE);
    button2.setBackground(Color.BLACK);
    button2.setBounds(430, 300, 100, 30);

    button2.addActionListener(this);
    add(button2);

    button3 = new JButton("SIGN UP");
    button3.setFont(new Font("Arial", Font.BOLD, 14));
    button3.setForeground(Color.WHITE);

    button3.setBounds(300, 350, 230, 30);
    button3.setBackground(Color.BLACK);
    button3.addActionListener(this);
    add(button3);

    ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
    Image iii2 = iii1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);// scale the image
    ImageIcon iii3 = new ImageIcon(iii2);
    JLabel iiimage = new JLabel(iii3);// frame pr direct nhi le jaate h to label kee wajah se le jayege

    iiimage.setBounds(0, 0, 850, 480);// setbound use to get the location and ajust

    add(iiimage);
    setLayout(null);
    setSize(850, 480);
    setLocation(450, 200);// isee window humarea x and y k usme khulegi
    // setUndecorated(true);
    setVisible(true); // jo bhi vsisible krwana h usse setvisible kupr likhna h
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    try {
      if (e.getSource() == button1) {
        // getsource hume btaou kiss button pr click houa h
        Conn c = new Conn();
        String cardno = textField2.getText();
        String pin = new String(passwordField3.getPassword());
        // String pin = passwordField3.getText();
        String q = "select * from login where card_number = '" + cardno + "' and pin='" + pin + "'";
        ResultSet resultSet = c.statement.executeQuery(q);
        if (resultSet.next()) {
          setVisible(false);
          new Main1(pin);
        } else {
          JOptionPane.showMessageDialog(null, "Incorrect Card No or Pin ");
        }

      } else if (e.getSource() == button2) {
        textField2.setText("");

        passwordField3.setText("");
      } else if (e.getSource() == button3) {
        new Signup();
        setVisible(false);
      }
    } catch (Exception E) {
      E.printStackTrace();

    }
  }

  public static void main(String[] args) {
    new Login();

  }
}