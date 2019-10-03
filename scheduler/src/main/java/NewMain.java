import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List; 
import java.util.ArrayList; 

public class NewMain {

    JComponent ui = null;

    NewMain() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new TitledBorder("Scheduler"));
        
        //CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel();
        Box b = Box.createVerticalBox(); 
        cards.add(b);
        cards.setBorder(new TitledBorder("Tasks to complete"));
        List<String> l = new ArrayList(); 
        l.add("Assignment 1, 80 min");
        l.add("Assignment 2, 100 min");
        l.add("Assignment 3, 40 min");
        for (int i=0; i< l.size();i++) {
             b.add(new JLabel(l.get(i)), BorderLayout.NORTH);
        }
        ui.add(cards);

        JPanel lineStart = new JPanel(new GridBagLayout());
        lineStart.setBorder(new TitledBorder("Add Tasks"));
        Box box = Box.createVerticalBox();
        JTextField t1 = new JTextField("Task Name    ");  
        JTextField t2 = new JTextField("Duration (min)");   
        JButton ad = new JButton("Schedule Task");
            
        box.add(t1); box.add(t2);
        box.add(ad);
        ad.addActionListener((ActionEvent e) -> {
            // display/center the jdialog when the button is pressed
            JDialog d = new JDialog();
            String s1 = t1.getText();
            String s2 = t2.getText();
            d.add( new JLabel ("<html>The task " + s1 +
                    " has been added.<br/>It should take around " +
                    s2 + " minutes.</html>"));
            
            //l.add(s1);
            b.add(new JLabel(s1 + ", " + s2 + " min"), BorderLayout.NORTH);
            cards.setVisible(false);
            cards.setVisible(true);
            
            d.setLayout( new FlowLayout() );
            d.setSize(400,80);
            d.setLocationRelativeTo(null);
            d.setVisible(true);
            
        });

        
        // will appear on the left, in a LTR text orientation locale
        ui.add(lineStart, BorderLayout.LINE_START);

        JPanel buttonsCentered = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonsCentered.setBorder(new TitledBorder("Other Options"));
        // as single component added w/no constraint, will be centered
        box.add(buttonsCentered); 
        buttonsCentered.add(new JButton("Tutorial"));
        buttonsCentered.add(new JButton("FAQ"));
        buttonsCentered.add(new JButton("Contact"));
        
        lineStart.add(box);   
    
    
    }


    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                NewMain o = new NewMain();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setSize(500, 300);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}