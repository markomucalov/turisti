import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;;

public class LoginWindow extends JDialog{
	JLabel username;
	JLabel password;
	JTextField user;
	JPasswordField pass;
	JButton ok;
	JButton cancel;
	
	public LoginWindow(){
		super();
		setSize(200,200);
		setTitle("PRIJAVA");
		setLocation(600, 250);
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		
		username = new JLabel("Username");
		cs.gridx = 0;
	    cs.gridy = 0;
	    cs.gridwidth = 1;
	    p.add(username,cs);
		
	    user = new JTextField(11);
	    cs.gridx = 1;
	    cs.gridy = 0;
	    cs.gridwidth = 2;
	    p.add(user,cs);
	    
	    password = new JLabel("Password");
	    cs.gridx = 0;
	    cs.gridy = 1;
	    cs.gridwidth = 1;
	    p.add(password,cs);
	    
	    pass = new JPasswordField(11);
	    cs.gridx = 1;
	    cs.gridy = 1;
	    cs.gridwidth = 2;
	    p.add(pass,cs);
	    
	    this.add(p);

		setVisible(true);
		setResizable(false);
		
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
	    JPanel oc = new JPanel();
	    oc.add(ok);
	    oc.add(cancel);
	    
	    getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(oc, BorderLayout.PAGE_END);
	    
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (Korisnik.provjera_korisnika(getUsername(), getPassword())){
						JOptionPane.showMessageDialog(LoginWindow.this, "Uspjesna registracija :)");
					}else{
						JOptionPane.showMessageDialog(LoginWindow.this, "Kombinacija unijetog korisnickog imena i sifre ne postoji!!!");
						user.setText("");
						pass.setText("");
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		
	
	}
	
	public String getUsername() {
        return user.getText().trim();
    }
 
    public String getPassword() {
        return new String(pass.getPassword());
    }
	
	
	public static void main(String[] args) {
		new LoginWindow();

	}

}
