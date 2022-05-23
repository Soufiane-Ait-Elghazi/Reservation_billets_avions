package Présentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField login;
	private JPasswordField password;
	

	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}

	public JTextField getLogin() {
		return login;
	}

	public void setLogin(JTextField login) {
		this.login = login;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin frame = new AddAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddAdmin() {
		 setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Ajouter Admin");
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("Nom");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblPrenom = new JLabel("Prenom");
		
		JLabel lblPassword = new JLabel("Password");
		
		nom = new JTextField();
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		
		login = new JTextField();
		login.setColumns(10);
		
		password = new JPasswordField();
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add Admin 
				
				String Nom,Prenom,Login,Password;
		        Métier.Admin A = new Métier.Admin();
		        Nom = nom.getText();
		        Prenom = prenom.getText();
		        Login = login.getText();
		        Password = password.getText();
		        if(Nom.equals("")||Prenom.equals("")||Login.equals("")||Password.equals("")) {
		       JOptionPane.showMessageDialog(null, "Attention un ou plusieurs champs sont vides !!","Champs Vide",JOptionPane.OK_OPTION);
		        }
		        else {
		        try {
					A.ajouterAdmin(new Métier.Admin(Nom,Prenom,Login,Password));
					JOptionPane.showMessageDialog(null, "Bien Ajouter","Nouveau Admin",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        System.exit(0);
		        }
		        
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter Admin");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(prenom, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(login, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addGap(44))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
