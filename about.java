import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class about extends JFrame {
    about() {
        setTitle("About Developer");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Images/notepad.png"));
        Image logo = icon.getImage();
        setIconImage(logo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new about();
    }
}
