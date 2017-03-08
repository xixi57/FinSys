/**
 * Created by Xi Wang on 3/5/17.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("JDialog Demo");
        final JFrame board = new JFrame("Financial Recommendar");
        final JButton btnLogin = new JButton("Click to login");

        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginBox loginDlg = new LoginBox(board);
                        loginDlg.setVisible(true);
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                        }
                    }
                });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(false);

        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(300, 100);
        board.setLayout(new FlowLayout());
        board.getContentPane().add(btnLogin);
        board.setVisible(true);
    }
}