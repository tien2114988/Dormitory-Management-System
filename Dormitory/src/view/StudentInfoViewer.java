package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import model.Student;




public class StudentInfoViewer extends JFrame {
	private JPanel contentPane;
	
	private JTabbedPane tabbedPane;
	
	private JPanel studentInfoPanel;
	private JPanel roomInfoPanel;
	private JPanel passwordChangingPanel;
	
	private JLabel logoLabel;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel IDLabel;
	private JLabel universityLabel;
	private JLabel studentIDLabel;
	private JLabel birthdayLabel;
	private JLabel provinceLabel;
	private JLabel emailLabel;
	private JLabel phoneNumberLabel;
	private JLabel genderLabel;
	private JLabel zoneLabel;
	private JLabel clusterLabel;
	private JLabel buildingLabel;
	private JLabel roomLabel;
	private JLabel roomTypeLabel;
	private JLabel personalLabel;
	private JLabel universityInfoLabel;
	private JLabel contactInfoLabel;
	private JLabel backgroundLabel;
	
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmedPasswordField;
	
	private LogInViewer logInViewer;
	private Student student;

	private Pattern pattern;
	private SimpleDateFormat simpleDateFormat;

	
	
	
	public StudentInfoViewer(LogInViewer logInViewer) {
		this.simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.pattern = Pattern.compile("^.{8,31}$");
		this.logInViewer = logInViewer;
		
		this.init();
		this.initStudentInfo();
		this.initRoomInfo();
		this.initPasswordChanging();
		this.initSignOutButton();
		this.initBackground();
	}
	
	
	
	public void init() {
		//init
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Save object to file here
		    	out();
		    }
		});
		this.setBounds(100, 100, 813, 444);
		
		//content pane
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//icon
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		this.setTitle("Trang thông tin sinh viên");
		
		//tabbed Pane
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBackground(new Color(0,0,0,0));
		this.tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.tabbedPane.setBounds(0, 77, 801, 307);
		this.contentPane.add(this.tabbedPane);
	}
	
	
	
	public void initStudentInfo() {
		//pane
		this.studentInfoPanel = new JPanel();
		this.studentInfoPanel.setBackground(new Color(0, 0, 0,0));
		this.tabbedPane.addTab("Thông tin sinh viên", null, this.studentInfoPanel, null);
		this.studentInfoPanel.setLayout(null);
		
		// personal info
		this.personalLabel = new JLabel("Thông tin cá nhân");
		this.personalLabel.setForeground(new Color(128, 0, 0));
		this.personalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		this.personalLabel.setBounds(58, 21, 121, 20);
		this.studentInfoPanel.add(this.personalLabel);
		
		//university info
		this.universityInfoLabel = new JLabel("Thông tin trường");
		this.universityInfoLabel.setForeground(new Color(128, 0, 0));
		this.universityInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		this.universityInfoLabel.setBounds(403, 21, 121, 20);
		this.studentInfoPanel.add(this.universityInfoLabel);
		
		//contact info
		this.contactInfoLabel = new JLabel("Thông tin liên hệ");
		this.contactInfoLabel.setForeground(new Color(128, 0, 0));
		this.contactInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		this.contactInfoLabel.setBounds(403, 150, 121, 20);
		this.studentInfoPanel.add(this.contactInfoLabel);

		//Name
		this.nameLabel = new JLabel("Tên");
		this.nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.nameLabel.setBounds(60, 60, 260, 20);
		this.studentInfoPanel.add(this.nameLabel);

		//ID
		this.IDLabel = new JLabel("CCCD");
		this.IDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.IDLabel.setBounds(60, 100, 260, 20);
		this.studentInfoPanel.add(this.IDLabel);

		//university
		this.universityLabel = new JLabel("Trường");
		this.universityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.universityLabel.setBounds(403, 60, 375, 20);
		this.studentInfoPanel.add(this.universityLabel);

		//student ID
		this.studentIDLabel = new JLabel("MSSV");
		this.studentIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.studentIDLabel.setBounds(403, 100, 375, 20);
		this.studentInfoPanel.add(this.studentIDLabel);

		//birthday
		this.birthdayLabel = new JLabel("Ngày sinh");
		this.birthdayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.birthdayLabel.setBounds(60, 180, 260, 20);
		this.studentInfoPanel.add(this.birthdayLabel);

		//province
		this.provinceLabel = new JLabel("Tỉnh");
		this.provinceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.provinceLabel.setBounds(60, 220, 260, 20);
		this.studentInfoPanel.add(this.provinceLabel);

		//email
		this.emailLabel = new JLabel("Email");
		this.emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.emailLabel.setBounds(403, 230, 375, 20);
		this.studentInfoPanel.add(this.emailLabel);
		
		//phone number
		this.phoneNumberLabel = new JLabel("Số điện thoại");
		this.phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.phoneNumberLabel.setBounds(403, 190, 375, 20);
		this.studentInfoPanel.add(this.phoneNumberLabel);
		
		//gender
		this.genderLabel = new JLabel("Giới tính");
		this.genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.genderLabel.setBounds(60, 140, 260, 20);
		this.studentInfoPanel.add(this.genderLabel);
	}
	
	
	
	public void initRoomInfo() {
		// room info
		this.roomInfoPanel = new JPanel();
		this.roomInfoPanel.setBackground(new Color(0, 0, 0,0));
		this.tabbedPane.addTab("Thông tin phòng", null, this.roomInfoPanel, null);
		this.roomInfoPanel.setLayout(null);

		//Zone
		this.zoneLabel = new JLabel("Khu");
		this.zoneLabel.setForeground(new Color(128, 0, 0));
		this.zoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		this.zoneLabel.setBounds(190, 21, 446, 25);
		this.roomInfoPanel.add(this.zoneLabel);

		//Cluster
		this.clusterLabel = new JLabel("Cụm");
		this.clusterLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.clusterLabel.setBounds(30, 93, 73, 20);
		this.roomInfoPanel.add(this.clusterLabel);

		//Building
		this.buildingLabel = new JLabel("Tòa");
		this.buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.buildingLabel.setBounds(170, 93, 67, 20);
		this.roomInfoPanel.add(this.buildingLabel);

		//Room
		this.roomLabel = new JLabel("Phòng");
		this.roomLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomLabel.setBounds(316, 93, 96, 20);
		this.roomInfoPanel.add(this.roomLabel);

		//Room Type
		this.roomTypeLabel = new JLabel("Loại phòng");
		this.roomTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomTypeLabel.setBounds(479, 93, 307, 20);
		this.roomInfoPanel.add(this.roomTypeLabel);

		//out
		JButton checkOutButton = new JButton("Trả phòng");
		checkOutButton.setBackground(new Color(0, 128, 192));
		checkOutButton.setForeground(new Color(255, 255, 255));
		checkOutButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		checkOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkout();
			}
		});
		checkOutButton.setBounds(532, 171, 104, 21);
		this.roomInfoPanel.add(checkOutButton);
	}
	
	
	
	public void initPasswordChanging() {
		this.passwordChangingPanel = new JPanel();
		this.passwordChangingPanel.setBackground(new Color(0, 0, 0,0));
		this.tabbedPane.addTab("Đổi mật khẩu", null, this.passwordChangingPanel, null);
		this.passwordChangingPanel.setLayout(null);
		
		//old password
		JLabel oldPasswordLabel = new JLabel("Mật khẩu cũ");
		oldPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		oldPasswordLabel.setBounds(208, 60, 99, 20);
		this.passwordChangingPanel.add(oldPasswordLabel);
		
		this.oldPasswordField = new JPasswordField();
		this.oldPasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.oldPasswordField.setBounds(379, 60, 165, 20);
		this.passwordChangingPanel.add(this.oldPasswordField);
		
		
		//new password
		JLabel newPasswordLabel = new JLabel("Mật khẩu mới");
		newPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newPasswordLabel.setBounds(208, 100, 99, 20);
		this.passwordChangingPanel.add(newPasswordLabel);
		
		this.newPasswordField = new JPasswordField();
		this.newPasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.newPasswordField.setBounds(379, 100, 165, 20);
		this.passwordChangingPanel.add(this.newPasswordField);
		
		
		//confirm password
		JLabel confirmedPasswordLabel = new JLabel("Xác nhận mật khẩu mới");
		confirmedPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		confirmedPasswordLabel.setBounds(208, 140, 160, 20);
		this.passwordChangingPanel.add(confirmedPasswordLabel);
		
		this.confirmedPasswordField = new JPasswordField();
		this.confirmedPasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.confirmedPasswordField.setBounds(379, 140, 165, 20);
		this.passwordChangingPanel.add(this.confirmedPasswordField);
		
		//save
		JButton saveButton = new JButton("Lưu");
		saveButton.setForeground(new Color(255, 255, 255));
		saveButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		saveButton.setBackground(new Color(0, 128, 192));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				savePassword();
			}
		});
		saveButton.setBounds(459, 190, 85, 21);
		this.passwordChangingPanel.add(saveButton);
	}
	
	
	
	public void initSignOutButton() {
		JButton signOutButton = new JButton("Đăng xuất");
		signOutButton.setBounds(703, 385, 96, 21);
		signOutButton.setForeground(new Color(255, 255, 255));
		signOutButton.setBackground(new Color(0, 128, 0));
		signOutButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		signOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = {"Có", "Không"};
		        int x = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn đăng xuất khỏi tài khoản",
		                null,
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		        if(x==0) {
		        	out();
		        }
			}
		});
		this.contentPane.add(signOutButton);
	}
	
	
	
	public void initBackground() {
		//logo
		this.logoLabel = new JLabel("");
		this.logoLabel.setIcon(new ImageIcon(StudentInfoViewer.class.getResource("/picture/logo.png")));
		this.logoLabel.setBounds(239, 10, 87, 60);
		this.contentPane.add(this.logoLabel);
		
		//title
		this.titleLabel = new JLabel("Trang thông tin sinh viên");
		this.titleLabel.setForeground(new Color(128, 0, 0));
		this.titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		this.titleLabel.setBackground(Color.WHITE);
		this.titleLabel.setBounds(335, 10, 200, 60);
		this.contentPane.add(this.titleLabel);
		
		//background
		this.backgroundLabel = new JLabel("");
		this.backgroundLabel.setIcon(new ImageIcon(StudentInfoViewer.class.getResource("/picture/istockphoto-1323143709-612x612.jpg")));
		this.backgroundLabel.setBounds(0, 10, 801, 396);
		this.contentPane.add(this.backgroundLabel);
	}
	
	
	
	public void savePassword() {
		if(!String.valueOf(oldPasswordField.getPassword()).equals(String.valueOf(student.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu cũ nhập chưa chính xác");
		}else if(!pattern.matcher(String.valueOf(newPasswordField.getPassword())).find()) {
			JOptionPane.showMessageDialog(null, "Mật khẩu mới phải từ 8 đến 31 kí tự");
		}else if(!String.valueOf(newPasswordField.getPassword()).equals(String.valueOf(confirmedPasswordField.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp");
		}else {
			String[] options = {"Có", "Không"};
	        int x = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn đổi mật khẩu",
	                null,
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        if(x==0) {
	        	student.setPassword(String.valueOf(newPasswordField.getPassword()));
	        	clearPassword();
	        	JOptionPane.showMessageDialog(null,"Đổi mật khẩu thành công");
	        }
		}
	}
	
	
	
	public void out() {
		this.logInViewer.clear();
		this.logInViewer.setVisible(true);
		dispose();
	}
	
	
	
	public void checkout() {
		String[] options = {"Có", "Không"};
        int x = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn trả phòng",
                null,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(x==0) {
    		this.logInViewer.getDormitory().removeStudent(student,student.getRoom());
    		out();
        }
	}
	
	
	
	public void clearPassword() {
		this.oldPasswordField.setText("");
		this.newPasswordField.setText("");
		this.confirmedPasswordField.setText("");
	}
	
	
	
	public void setStudentInfo(Student student) {
		this.tabbedPane.setSelectedIndex(0);
		clearPassword();
		
		this.student = student;
		this.nameLabel.setText("Tên : "+student.getName());
		this.IDLabel.setText("CCCD : "+student.getID());
		this.birthdayLabel.setText("Ngày sinh : "+simpleDateFormat.format(student.getBirthday()));
		this.emailLabel.setText("Email : "+student.getEmail());
		this.phoneNumberLabel.setText("Số điện thoại : "+student.getPhoneNumber());
		this.provinceLabel.setText("Tỉnh : "+student.getProvince());
		this.studentIDLabel.setText("MSSV : "+student.getStudentID());
		this.universityLabel.setText("Trường : "+student.getUniversityName());
		this.genderLabel.setText("Giới tính : "+(student.isMale()?"Nam":"Nữ"));		
		this.zoneLabel.setText("Kí túc xá Khu "+student.getRoom().getBuilding().getCluster().getZone().getName()+" Đại học Quốc gia Thành phố Hồ Chí Minh");
		this.clusterLabel.setText("Cụm : "+student.getRoom().getBuilding().getCluster().getName());
		this.buildingLabel.setText("Tòa : "+student.getRoom().getBuilding().getName());
		this.roomLabel.setText("Phòng : "+student.getRoom().getRoomNumber()+"");
		this.roomTypeLabel.setText("Loại phòng : "+student.getRoom().getTypeName());
	}
}
