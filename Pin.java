package src;

import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
  String pin;
  JButton b1, b2;
  JPasswordField p1, p2;

  Pin(String pin) {
    this.pin = pin;
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
    Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(0, 0, 1550, 830);
    add(l3);

    JLabel label1 = new JLabel("CHANGE YOUR PIN");
    label1.setForeground(Color.WHITE);
    label1.setFont(new Font("System", Font.BOLD, 16));
    label1.setBounds(430, 180, 400, 35);
    l3.add(label1);

    JLabel label2 = new JLabel("NEW  PIN:");
    label2.setForeground(Color.WHITE);
    label2.setFont(new Font("System", Font.BOLD, 16));
    label2.setBounds(430, 220, 150, 35);
    l3.add(label2);

    p1 = new JPasswordField();
    p1.setBackground(new Color(65, 125, 128));
    p1.setForeground(Color.WHITE);
    p1.setBounds(600, 220, 180, 25);
    p1.setFont(new Font("Raleway", Font.BOLD, 22));
    l3.add(p1);

    JLabel label3 = new JLabel("Re-Enter NEW  PIN:");
    label3.setForeground(Color.WHITE);
    label3.setFont(new Font("System", Font.BOLD, 16));
    label3.setBounds(430, 250, 400, 35);
    l3.add(label3);

    p2 = new JPasswordField();
    p2.setBackground(new Color(65, 125, 128));
    p2.setForeground(Color.WHITE);
    p2.setBounds(600, 255, 180, 25);
    p2.setFont(new Font("Raleway", Font.BOLD, 22));
    l3.add(p2);

    b1 = new JButton("CHANGE");
    b1.setBounds(700, 362, 150, 35);
    b1.setBackground(new Color(65, 125, 128));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    l3.add(b1);

    b2 = new JButton("BACK");
    b2.setBounds(700, 406, 150, 35);
    b2.setBackground(new Color(65, 125, 128));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    l3.add(b2);

    setSize(1550, 1000);
    setLayout(null);
    setLocation(0, 0);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

    try {
      String pin1 = new String(p1.getPassword());

      String pin2 = new String(p2.getPassword());
      if (!pin1.equals(pin2)) {
        JOptionPane.showMessageDialog(null, "Enter Pin Doesnot Match ");
        return;
      }
      if (e.getSource() == b1) {
        if (p1.getPassword().equals("")) {
          JOptionPane.showMessageDialog(null, "Enter New  Pin  ");
          return;
        }

        if (p2.getPassword().equals("")) {
          JOptionPane.showMessageDialog(null, "Re-Enter New  Pin  ");
          return;
        }
        Conn c = new Conn();
        String q1 = "Update bank set pin = '" + pin1 + "' where pin= '" + pin + "'";
        String q2 = "Update login set pin = '" + pin1 + "' where pin= '" + pin + "'";
        String q3 = "Update signupthree set pin = '" + pin1 + "' where pin= '" + pin + "'";

        c.statement.executeUpdate(q1);

        c.statement.executeUpdate(q2);
        c.statement.executeUpdate(q3);
        JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
        setVisible(false);
        new Main1(pin);
      } else if (e.getSource() == b2) {
        new Main1(pin);
        setVisible(false);
      }
    } catch (Exception E) {
      E.printStackTrace();
    }

  }

  public static void main(String[] args) {
    new Pin("");
  }
}
