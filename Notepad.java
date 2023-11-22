import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Notepad extends JFrame {
    public Notepad() {

        setTitle("Notepad");
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Images/notepad.png"));
        // Converting ImageIcon to Image Object Becase setIconImage takes only Image
        // Object
        Image icon = logo.getImage();
        setIconImage(icon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);

        // ! Creating the Menu
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        // Editing the Menubar
        // file.setFont(new Font("AERIAL", Font.PLAIN, 14));
        /*
         * Creating the File with Options - NEW , OPEN , SAVE, PRINT, EXIT
         */
        JMenu file = new JMenu("File");
        JMenuItem newdoc = new JMenuItem("New File");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        file.add(newdoc);
        JMenuItem open = new JMenuItem("Open File");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        file.add(open);
        JMenuItem save = new JMenuItem("Save File");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        file.add(save);
        JMenuItem print = new JMenuItem("Print File");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        file.add(print);
        JMenuItem exit = new JMenuItem("Exit File");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        file.add(exit);

        // file.add(newdoc);

        menubar.add(file);

        /*
         * Edit Button
         * Options - Copy, Cut, Paste, SelectAll
         */
        JMenu edit = new JMenu("Edit");
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        edit.add(copy);
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        edit.add(cut);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        edit.add(paste);
        JMenuItem selectall = new JMenuItem("Select All");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        edit.add(selectall);

        menubar.add(edit);
        /*
         * Help Button
         * Options - Help
         */
        JMenu help = new JMenu("Help");
        menubar.add(help);
        JMenuItem hlp = new JMenuItem("Help");
        hlp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        help.add(hlp);
        setJMenuBar(menubar);

        // !Creating the text area
        JTextArea textarea = new JTextArea();
        textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);

        // !Adding Scroll Bar
        JScrollPane pane = new JScrollPane(textarea);

        add(pane);// ^ScrollBar + TextArea

        setVisible(true);// Should be visivle abfter all other components are rendered
    }

    public static void main(String[] args) {
        new Notepad(); // Anonymous Object

    }
}