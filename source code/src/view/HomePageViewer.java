package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import file.FileManagement;
import model.Dormitory;



public class HomePageViewer extends JFrame {
	private JPanel contentPane;
	
	private SignInViewer signInViewer;
	private LogInViewer logInViewer;
	
	private Dormitory dormitory;
	
	private FileManagement fileManagement;

	
	
	public HomePageViewer() {
		this.fileManagement = new FileManagement(new File("dormitory.txt"));
		this.dormitory = this.fileManagement.read();
		
		this.init();
		this.initLogInButton();
		this.initSignInButton();
		this.initBackButton();
		this.initBackground();
	}
	
	
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Save object to file here
		    	fileManagement.write(dormitory);
		        System.exit(0);
		    }
		});
		this.setBounds(100, 100, 559, 393);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.setTitle("Hệ thống quản lý Ký túc xá");
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		
		this.setLocationRelativeTo(null);
	}
	
	
	
	public void initLogInButton() {
		this.logInViewer = new LogInViewer(this);
		
		JButton logInButton = new JButton("Đăng Nhập");
		logInButton.setForeground(new Color(255, 255, 255));
		logInButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		logInButton.setBackground(new Color(0, 128, 192));
		
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logInViewer.clear();
				logInViewer.setVisible(true);
				dispose();
			}		
		});
		
		logInButton.setBounds(225, 118, 112, 25);
		this.contentPane.add(logInButton);
	}
	
	
	
	public void initSignInButton() {
		this.signInViewer = new SignInViewer(this);
		
		JButton signInButton = new JButton("Đăng Ký");
		signInButton.setForeground(new Color(255, 255, 255));
		signInButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		signInButton.setBackground(new Color(0, 128, 192));
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signInViewer.clear();
				signInViewer.setVisible(true);
				dispose();
			}
		});
		
		signInButton.setBounds(225, 172, 112, 25);
		this.contentPane.add(signInButton);
	}
	
	
	
	public void initBackButton() {
		JButton backButton = new JButton("Thoát");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backButton.setBackground(new Color(0, 128, 0));
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fileManagement.write(dormitory);
				System.exit(0);
			}
		});
		
		backButton.setBounds(225, 229, 112, 25);
		this.contentPane.add(backButton);
	}
	
	
	
	public void initBackground() {
		//title
		JLabel titleLabel = new JLabel("<html><center>Hệ thống quản lý Ký túc xá<br/>Đại học Quốc gia Thành phố Hồ Chí Minh</center></html>");
		titleLabel.setForeground(new Color(128, 0, 0));
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleLabel.setBackground(new Color(255, 255, 255));
		titleLabel.setBounds(146, 1, 389, 70);
		this.contentPane.add(titleLabel);
		
		//logo
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(HomePageViewer.class.getResource("/picture/logo.png")));
		logoLabel.setBounds(58, 1, 87, 60);
		this.contentPane.add(logoLabel);
		
		//background
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setForeground(new Color(0, 0, 0));
		backgroundLabel.setIcon(new ImageIcon(HomePageViewer.class.getResource("/picture/istockphoto-1338579925-612x612.jpg")));
		backgroundLabel.setBounds(0, 0, 547, 356);
		this.contentPane.add(backgroundLabel);
	}
	
	
	
	public Dormitory getDormitory() {
		return dormitory;
	}
}
