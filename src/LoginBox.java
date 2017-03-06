/**
 * Created by raoyinchen on 3/5/17.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginBox extends JFrame {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnNewuser;
    private boolean succeeded;
    Container container = getContentPane();
    mainScreen test;

    public LoginBox(Frame parent) {
        //super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(btnLogin.getText().equals("register") ) {
                    if((getUsername() != null && !getUsername().isEmpty() &&  getPassword() != null && !getPassword().isEmpty())) {
                        Login.register(getUsername(), getPassword());
                        JOptionPane.showMessageDialog(LoginBox.this,
                                "Hi " + getUsername() + "! You have successfully registered.",
                                "Login",
                                JOptionPane.INFORMATION_MESSAGE);
                        succeeded = true;
                        btnLogin.setText("Login");
                        test = new mainScreen();
                        dispose();

                    }else {
                        JOptionPane.showMessageDialog(LoginBox.this,
                                "Invalid username or password",
                                "Login",
                                JOptionPane.ERROR_MESSAGE);
                        // reset username and password
                        tfUsername.setText("");
                        pfPassword.setText("");
                        succeeded = false;
                    }

                }
                else if (Login.authenticate(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(LoginBox.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);

                    succeeded = true;
                    test = new mainScreen();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginBox.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;

                }
            }
        });
        JPanel bp = new JPanel();
        btnCancel = new JButton("Cancel");


        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnNewuser = new JButton("newUser");
        btnNewuser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                btnLogin.setText("register");

            }
        });
        bp.add(btnLogin);
        bp.add(btnCancel);
        bp.add(btnNewuser);

        container.add(panel, BorderLayout.CENTER);
        container.add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}