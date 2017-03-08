/**
 * Created by XI Wang on 3/5/17.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by guoyiruan on 3/5/17.
 */
public class mainScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel spendingPanel;
    private ArrayList<JPanel> panels;
    private int step;
    Container c = getContentPane();
    JButton spending, income, tracking;
    private spendBoard toSpend;
    private incomeBoard toIncome;
    private trackBoard toTrack;
    //Constructor
    public mainScreen() {
        this.panels = new ArrayList<>();
        drawAll();
        display();
        for(JPanel each:panels) {
            c.add(each);
        }
        pack();
        setResizable(false);

    }

    public void drawMainScreen(JPanel mainPanel) {
        JPanel mainScreen = new JPanel();
        mainScreen.setLayout(new GridLayout(3,1));

        JPanel panel1 = new JPanel();
        spending = new JButton("Add Spending");
        panel1.add(spending);
        spending.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                toSpend = new spendBoard();
                dispose();
            }
        });
        JPanel panel2 = new JPanel();
        panel2.add(this.income = new JButton("Add income"));

        income.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //add(spendingPanel);
                System.out.print("income");
                //spendingPanel.setVisible(true);
                toIncome = new incomeBoard();
                dispose();
            }
        });


        JPanel panel3 = new JPanel();
        panel3.add(this.tracking =new JButton("Tracking"));

        tracking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //add(spendingPanel);
                System.out.print("tracking");
                //spendingPanel.setVisible(true);
                toTrack = new trackBoard();
                dispose();
            }
        });

        mainScreen.add(panel1);
        mainScreen.add(panel2);
        mainScreen.add(panel3);
        setSize(300, 200);
        mainPanel.add(mainScreen);
        pack();
        setVisible(true);
    }


    public JPanel getPanels() {
        if (this.step < 0 || this.step >= this.panels.size()) {
            System.out.println("step " + step );
            return null;
        }
        return panels.get(this.step);
    }

    public void display() {
        c.add(this.getPanels());
        pack();

    }


    public void drawAll() {
        this.mainPanel = new JPanel();
        drawMainScreen(mainPanel);
        panels.add(mainPanel);

    }

    //Main Program that starts Execution
    public static void main(String args[]) {
        mainScreen test = new mainScreen();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

