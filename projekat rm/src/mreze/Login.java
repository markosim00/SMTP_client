package mreze;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JDialog{
	
	private static Login instance;
	
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JTextField tfEmail;
	private JPasswordField tfPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	public static Login getInstance() {
		if(instance == null)
			instance = new Login();
		return instance;
	}
	
	private Login(){
		initElements();
		addElements();
	}
	
	private void initElements() {
		lblEmail = new JLabel("Email");
		lblPassword = new JLabel("Password");
		tfEmail = new JTextField(15);
		tfPassword = new JPasswordField(15);
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(e->{
			if(isValidEmail(Login.getInstance().getTfEmail().getText())) {
				MainFrame.getInstance().setVisible(true);
				Login.getInstance().hide();
			}
			else {
				JOptionPane.showMessageDialog(this, "Unesite validan email i password");
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e->{
			Login.getInstance().hide();
			MainFrame.getInstance().hide();
		});
		panel1 = new JPanel(new GridLayout(2,1));
		panel2 = new JPanel(new GridLayout(2,1));
		panel3 = new JPanel();
		panel4 = new JPanel();
	}
	
	private void addElements() {
		setTitle("Login");
		setSize(300,150);
		
		panel1.add(lblEmail);
		panel1.add(lblPassword);
		panel2.add(tfEmail);
		panel2.add(tfPassword);
		panel3.add(btnLogin);
		panel3.add(btnCancel);
		panel4.add(panel1);
		panel4.add(panel2);
		
		setLayout(new BorderLayout());
		add(panel4,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JPasswordField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JPasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JPanel getPanel4() {
		return panel4;
	}

	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}
	
	private boolean isValidEmail(String email) {
		if(email.equals("") || email == null || !email.contains("@") || !email.contains("."))
			return false;
		return true;
	}

	
}
