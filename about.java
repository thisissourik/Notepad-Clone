import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    JButton b1;

    About() {
        setBounds(600, 200, 500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel l3 = new JLabel(
            "<html><div style='text-align: center;'>Developer: Sourik Karmakar<br>Contact No: 7810964148<br>Gmail: <a href='mailto:sourikkarmakar2018@gmail.com'>sourikkarmakar2018@gmail.com</a><br>Linkedin: <a href='https://www.linkedin.com/in/sourikkarmakar/'>https://www.linkedin.com/in/sourikkarmakar/</a><br>Github: <a href='https://github.com/thisissourik'>https://github.com/thisissourik</a></div></html>"
        );

        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        l3.setBounds(50, 40, 400, 200);
        add(l3);

        b1 = new JButton("OK");
        b1.setBounds(200, 280, 80, 25);
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.dispose(); // Close the window when "OK" is clicked
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            About about = new About();
            about.setVisible(true);
        });
    }
}
