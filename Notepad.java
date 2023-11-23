import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.util.EventListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
    private JTextArea textarea;

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
        newdoc.addActionListener(this);
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        file.add(newdoc);

        JMenuItem open = new JMenuItem("Open File");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open);

        JMenuItem save = new JMenuItem("Save File");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save);

        JMenuItem print = new JMenuItem("Print File");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);
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
        textarea = new JTextArea();
        textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);

        // !Adding Scroll Bar
        JScrollPane pane = new JScrollPane(textarea);

        add(pane);// ^ScrollBar + TextArea

        setVisible(true);// Should be visivle abfter all other components are rendered
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ^New File Action
        if (e.getActionCommand().equals("New File"))
            textarea.setText("");
        // ^Open File Action
        else if (e.getActionCommand().equals("Open File")) {
            // & Opening File Manager to choose the file
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
            chooser.addChoosableFileFilter(restrict);
            int action = chooser.showOpenDialog(this);

            // & If No File is choosen , Close the dialogebox and return
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }
            // & Else Read the selected File
            else {
                File file = chooser.getSelectedFile();
                try {
                    BufferedReader read = new BufferedReader(new FileReader(file));

                    textarea.read(read, null);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equals("Save File")) {
            JFileChooser saveas = new JFileChooser();
            // Saving the file
            saveas.setApproveButtonText("Save");
            int action = saveas.showOpenDialog(this);

            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                File filename = new File(saveas.getSelectedFile() + ".txt");
                BufferedWriter outfile = null;
                try {
                    outfile = new BufferedWriter(new FileWriter(filename));
                    textarea.write(outfile);

                } catch (Exception ae) {
                    ae.printStackTrace();

                }
            }
        } else if (e.getActionCommand().equals("Print File")) {
            try {
                textarea.print();
            } catch (PrinterException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Notepad(); // Anonymous Object

    }
}