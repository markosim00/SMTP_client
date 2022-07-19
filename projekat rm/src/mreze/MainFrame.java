package mreze;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame{

	private JTextField toEmail;
	private JTextField subject;
	private JTextArea body;
	private JButton send;
	private JLabel lblToEmail;
	private JLabel lblSubject;
	private JButton btnCancel;
	
	private static MainFrame instance;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private JScrollPane scrollPane;
	
	public static MainFrame getInstance() {
		
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}
	
	private MainFrame() {
		initElements();
		addElements();
	}
	
	private void initElements() {
		toEmail = new JTextField(15);
		subject = new JTextField(15);
		body = new JTextArea(10,10);
		send = new JButton("Send");
		panel1 = new JPanel(new GridLayout(2,1));
		panel2 = new JPanel(new GridLayout(2,1));
		panel3 = new JPanel(new GridLayout(2,1));
		panel4 = new JPanel();
		panel5 = new JPanel();
		lblToEmail = new JLabel("To: ");
		lblSubject = new JLabel("Subject: ");
		btnCancel = new JButton("Cancel");
		
	}
	
	private void addElements() {
		setTitle("Mail sender app");
		setSize(400,400);
		
		panel1.add(lblToEmail);
		panel1.add(toEmail);
		panel2.add(lblSubject);
		panel2.add(subject);
		panel3.add(body);
		panel4.add(panel1);
		panel4.add(panel2);
		panel5.add(send);
		panel5.add(btnCancel);
		
		btnCancel.addActionListener(e->{
			MainFrame.getInstance().hide();
		});
		
		setLayout(new BorderLayout());
		add(panel4,BorderLayout.NORTH);
		add(panel3,BorderLayout.CENTER);
		add(panel5,BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(body,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);;
		add(scrollPane);
		
		
		send.addActionListener(e->{
			SimpleEmail.send();
		});
	}

	public JTextField getToEmail() {
		return toEmail;
	}

	public void setToEmail(JTextField toEmail) {
		this.toEmail = toEmail;
	}

	public JTextField getSubject() {
		return subject;
	}

	public void setSubject(JTextField subject) {
		this.subject = subject;
	}

	public JTextArea getBody() {
		return body;
	}

	public void setBody(JTextArea body) {
		this.body = body;
	}

	public JButton getSend() {
		return send;
	}

	public void setSend(JButton send) {
		this.send = send;
	}

	public JLabel getLblToEmail() {
		return lblToEmail;
	}

	public void setLblToEmail(JLabel lblToEmail) {
		this.lblToEmail = lblToEmail;
	}

	public JLabel getLblSubject() {
		return lblSubject;
	}

	public void setLblSubject(JLabel lblSubject) {
		this.lblSubject = lblSubject;
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

	public JPanel getPanel5() {
		return panel5;
	}

	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	
	
	
	
}
