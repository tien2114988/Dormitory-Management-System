package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Dormitory;
import model.Student;




public class LogInViewer extends JFrame {
	private JPanel contentPane;
	
	private HomePageViewer homePageViewer;

	private StudentInfoViewer studentInfoViewer;
	
	private JTextField IDTextField;
	private JPasswordField passwordField;
	
	private Dormitory dormitory;

	
	
	public LogInViewer(HomePageViewer homePageViewer) {
		this.homePageViewer = homePageViewer;
		this.studentInfoViewer = new StudentInfoViewer(this);
		this.dormitory= homePageViewer.getDormitory();
		
		this.init();
		this.initIDField();
		this.initPasswordField();
		this.initLogInButton();
		this.initBackButton();
		this.initBackground();
	}
	
	
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Save object to file here
		    	homePageViewer.setVisible(true);
				dispose();
		    }
		});
		this.setBounds(100, 100, 450, 300);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		this.setTitle("Đăng nhập");
	}
	
	
	
	public void initIDField() {
		JLabel IDLabel = new JLabel("CCCD");
		IDLabel.setForeground(new Color(0, 128, 192));
		IDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		IDLabel.setBounds(103, 95, 68, 24);
		this.contentPane.add(IDLabel);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(175, 95, 137, 24);
		this.contentPane.add(IDTextField);
	}
	
	
	
	public void initPasswordField() {
		JLabel passwordLabel = new JLabel("Mật khẩu");
		passwordLabel.setForeground(new Color(0, 128, 192));
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordLabel.setBounds(103, 135, 68, 24);
		this.contentPane.add(passwordLabel);
		
		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(175, 135, 137, 24);
		this.contentPane.add(passwordField);
	}
	
	
	
	public void initLogInButton() {
		JButton logInButton = new JButton("Đăng nhập");
		logInButton.setForeground(new Color(255, 255, 255));
		logInButton.setBackground(new Color(0, 128, 192));
		logInButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewStudentInfo();
			}
		});
		
		logInButton.setBounds(175, 180, 137, 24);
		this.contentPane.add(logInButton);
	}
	
	
	
	public void initBackButton() {
		JButton backButton = new JButton("Thoát");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 128, 64));
		backButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				homePageViewer.setVisible(true);
				dispose();
			}
		});
		
		backButton.setBounds(351, 242, 85, 21);
		this.contentPane.add(backButton);
	}
	
	
	
	public void initBackground() {
		//logo
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(LogInViewer.class.getResource("/picture/logo.png")));
		logoLabel.setBounds(77, 10, 80, 50);
		this.contentPane.add(logoLabel);
		
		//title
		JLabel titleLabel = new JLabel("Thông tin đăng nhập");
		titleLabel.setForeground(new Color(128, 0, 0));
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(175, 14, 172, 46);
		this.contentPane.add(titleLabel);
		
		//background
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(LogInViewer.class.getResource("/picture/360_F_355607062_zYMS8jaz4SfoykpWz5oViRVKL32IabTP.jpg")));
		backgroundLabel.setBounds(0, 0, 436, 263);
		this.contentPane.add(backgroundLabel);
	}
	
	
	
	public Dormitory getDormitory() {
		return dormitory;
	}



	public void viewStudentInfo() {
		Student student = dormitory.getStudent(IDTextField.getText(),String.valueOf(passwordField.getPassword()));
		if(student==null) {
			JOptionPane.showMessageDialog(null, "Căn cước công dân hoặc mật khẩu không chính xác");
			clear();
		}else {
			studentInfoViewer.setStudentInfo(student);
			studentInfoViewer.setVisible(true);
			dispose();
		}
	}
	
	
	
	public void clear() {
		IDTextField.setText("");
		passwordField.setText("");
	}
}
