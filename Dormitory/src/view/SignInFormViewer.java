package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import com.toedter.calendar.JDateChooser;

import model.Dormitory;
import model.Room;
import model.Student;



public class SignInFormViewer extends JFrame {
	private JPanel contentPane;
	
	private SignInViewer signInViewer;
	
	private JLabel roomTypeLabel;
	private JLabel roomLabel;
	private JLabel genderLabel;
	private JLabel buildingLabel;
	private JLabel clusterLabel;
	private JLabel zoneLabel;
	
	private JTextField nameTextField;
	private JTextField studentIDTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JComboBox universityComboBox;
	private JComboBox provinceComboBox;
	private JDateChooser birthdayDateChooser;
	private JTextField IDTextField;
	private JCheckBox verifyCheckBox;
	
	
	private String gender;
	private Room signInRoom;
	private Date date;
	private Pattern pattern;
	private Dormitory dormitory;
	
	
	
	public SignInFormViewer(SignInViewer forStudentViewer) {
		this.pattern = Pattern.compile("^[0-9]{12}$");
		this.signInViewer = forStudentViewer;
		
		this.init();
		this.initLabel();
		this.initPersonalInfo();;
		this.initUniversityInfo();
		this.initContactInfo();
		this.initVerifyCheckBox();
		this.initButton();
		this.initBackground();
	}
	
	
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Save object to file here
		    	back();
		    }
		});
		this.setBounds(100, 100, 960, 520);
		
		//contentPane
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//icon
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		this.setTitle("Biểu mẫu đăng ký");
	}
	
	
	
	public void initLabel() {
		//ZONE
		this.zoneLabel = new JLabel("Khu : ");
		this.zoneLabel.setForeground(Color.BLACK);
		this.zoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.zoneLabel.setBounds(10, 93, 61, 21);
		this.contentPane.add(this.zoneLabel);
		
		//CLUSTER
		this.clusterLabel = new JLabel("Cụm : ");
		this.clusterLabel.setForeground(Color.BLACK);
		this.clusterLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.clusterLabel.setBounds(114, 93, 85, 21);
		this.contentPane.add(this.clusterLabel);
		
		//BUILDING
		this.buildingLabel = new JLabel("Tòa : ");
		this.buildingLabel.setForeground(Color.BLACK);
		this.buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.buildingLabel.setBounds(239, 93, 68, 21);
		this.contentPane.add(this.buildingLabel);
		
		//GENDER
		this.genderLabel = new JLabel("Giới tính : ");
		this.genderLabel.setForeground(Color.BLACK);
		this.genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.genderLabel.setBounds(352, 93, 107, 21);
		this.contentPane.add(this.genderLabel);
		
		//ROOM
		this.roomLabel = new JLabel("Phòng : ");
		this.roomLabel.setForeground(Color.BLACK);
		this.roomLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomLabel.setBounds(515, 93, 101, 21);
		this.contentPane.add(this.roomLabel);
		
		//ROOM TYPE
		this.roomTypeLabel = new JLabel("Loại phòng : ");
		this.roomTypeLabel.setForeground(Color.BLACK);
		this.roomTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomTypeLabel.setBounds(657, 93, 289, 21);
		this.contentPane.add(this.roomTypeLabel);
	}
	
	
	
	public void initPersonalInfo() {
		//LABEL
		JLabel personalLabel = new JLabel("Thông tin cá nhân");
		personalLabel.setForeground(new Color(128, 0, 0));
		personalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		personalLabel.setBounds(69, 146, 121, 20);
		this.contentPane.add(personalLabel);
		
		//NAME
		JLabel nameLabel = new JLabel("Tên");
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nameLabel.setBounds(69, 183, 45, 20);
		this.contentPane.add(nameLabel);
		
		this.nameTextField = new JTextField();
		this.nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.nameTextField.setBounds(157, 183, 217, 20);
		this.contentPane.add(this.nameTextField);
		this.nameTextField.setColumns(10);
		
		//ID
		JLabel IDLabel = new JLabel("CCCD");
		IDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		IDLabel.setBounds(69, 228, 45, 20);
		this.contentPane.add(IDLabel);
		
		this.IDTextField = new JTextField();
		this.IDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.IDTextField.setColumns(10);
		this.IDTextField.setBounds(157, 228, 157, 20);
		this.contentPane.add(this.IDTextField);	
		
		//BIRTHDAY
		JLabel birthdayLabel = new JLabel("Ngày sinh");
		birthdayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		birthdayLabel.setBounds(69, 273, 78, 20);
		this.contentPane.add(birthdayLabel);
		
		this.birthdayDateChooser = new JDateChooser();
		this.date = birthdayDateChooser.getDate();
		this.birthdayDateChooser.setBounds(157, 273, 157, 20);
		this.contentPane.add(this.birthdayDateChooser);
		
		//PROVINCE
		JLabel provinceLabel = new JLabel("Tỉnh");
		provinceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		provinceLabel.setBounds(69, 318, 45, 20);
		this.contentPane.add(provinceLabel);
		
		this.provinceComboBox = new JComboBox();
		this.provinceComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		List<String> provinceList = Dormitory.getProvinceList();
		for (String province : provinceList) {
			this.provinceComboBox.addItem(province);
		}
		this.provinceComboBox.setBounds(157, 318, 157, 20);
		this.contentPane.add(this.provinceComboBox);
	}
	
	
	public void initUniversityInfo() {
		//LABEL
		JLabel universityInfoLabel = new JLabel("Thông tin trường");
		universityInfoLabel.setForeground(new Color(128, 0, 0));
		universityInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		universityInfoLabel.setBounds(469, 146, 121, 20);
		this.contentPane.add(universityInfoLabel);
		
		//UNIVERSITY
		JLabel universityLabel = new JLabel("Trường");
		universityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		universityLabel.setBounds(469, 183, 59, 20);
		this.contentPane.add(universityLabel);
		
		this.universityComboBox = new JComboBox();
		this.universityComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		List<String> universityList = Dormitory.getUniversityList();
		for (String university : universityList) {
			this.universityComboBox.addItem(university);
		}
		this.universityComboBox.setBounds(538, 183, 349, 20);
		this.contentPane.add(this.universityComboBox);
		
		//STUDENT ID
		JLabel studentIDLabel = new JLabel("MSSV");
		studentIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		studentIDLabel.setBounds(469, 228, 59, 20);
		this.contentPane.add(studentIDLabel);
		
		this.studentIDTextField = new JTextField();
		this.studentIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.studentIDTextField.setColumns(10);
		this.studentIDTextField.setBounds(538, 228, 141, 20);
		this.contentPane.add(this.studentIDTextField);
	}
	
	
	
	public void initContactInfo() {
		//LABEL
		JLabel contactInfoLabel = new JLabel("Thông tin liên hệ");
		contactInfoLabel.setForeground(new Color(128, 0, 0));
		contactInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contactInfoLabel.setBounds(469, 280, 121, 20);
		this.contentPane.add(contactInfoLabel);
		
		//EMAIL
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		emailLabel.setBounds(469, 315, 45, 20);
		this.contentPane.add(emailLabel);
		
		this.emailTextField = new JTextField();
		this.emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.emailTextField.setColumns(10);
		this.emailTextField.setBounds(567, 315, 278, 20);
		this.contentPane.add(this.emailTextField);
		
		//PHONE NUMBER
		JLabel phoneNumberLabel = new JLabel("Số điện thoại");
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		phoneNumberLabel.setBounds(469, 358, 88, 20);
		this.contentPane.add(phoneNumberLabel);
		
		this.phoneNumberTextField = new JTextField();
		this.phoneNumberTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.phoneNumberTextField.setColumns(10);
		this.phoneNumberTextField.setBounds(567, 358, 112, 20);
		this.contentPane.add(this.phoneNumberTextField);
	}
	
	
	
	public void initVerifyCheckBox() {
		this.verifyCheckBox = new JCheckBox("Tôi xin cam kết tất cả nội dung khai báo trên là đúng sự thật");
		this.verifyCheckBox.setBackground(new Color(0, 0, 0,0));
		this.verifyCheckBox.setForeground(new Color(128, 0, 0));
		this.verifyCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.verifyCheckBox.setBounds(469, 400, 418, 27);
		this.verifyCheckBox.setOpaque(false);
		this.contentPane.add(this.verifyCheckBox);
	}
	
	
	
	public void initButton() {
		//BACK
		JButton backButton = new JButton("Thoát");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 128, 0));
		backButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				back();
				
			}
		});
		backButton.setBounds(861, 462, 85, 21);
		this.contentPane.add(backButton);
		
		//SIGN IN
		JButton signInButton = new JButton("Đăng ký");
		signInButton.setBackground(new Color(0, 128, 192));
		signInButton.setForeground(new Color(255, 255, 255));
		signInButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				register();
			}
		});
		
		signInButton.setBounds(760, 462, 85, 21);
		this.contentPane.add(signInButton);
	}
	
	
	
	public void initBackground() {
		//LOGO
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(SignInFormViewer.class.getResource("/picture/logo.png")));
		logoLabel.setBounds(352, 10, 87, 60);
		this.contentPane.add(logoLabel);
		
		//TITLE
		JLabel titleLabel = new JLabel("Biểu mẫu đăng ký");
		titleLabel.setForeground(new Color(128, 0, 0));
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(448, 10, 157, 60);
		this.contentPane.add(titleLabel);
		
		//BACKGROUND
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(SignInFormViewer.class.getResource("/picture/kk.jpg")));
		backgroundLabel.setBounds(0, 0, 946, 483);
		this.contentPane.add(backgroundLabel);
	}
	
	
	
	public void back() {
		String[] options = {"Có", "Không"};
        int x = JOptionPane.showOptionDialog(null, "Bạn có chắc chắn muốn thoát khỏi biểu mẫu đăng ký",
                "Bạn vẫn chưa gửi đăng ký",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(x==0) {
        	signInViewer.setVisible(true);
			dispose();
        }
	}
	
	
	
	public void setSignInForm(Dormitory dormitory,Room room,String zoneName, String clusterName, String buildingName, String gender, short roomNumber, String roomType) {
		this.zoneLabel.setText("Khu : "+zoneName);
		this.clusterLabel.setText("Cụm : "+clusterName);
		this.buildingLabel.setText("Tòa : "+buildingName);
		this.genderLabel.setText("Giới tính : "+gender);
		this.roomLabel.setText("Phòng  : "+roomNumber);
		this.roomTypeLabel.setText("Loại phòng : "+roomType);
		
		this.nameTextField.setText("");
		this.universityComboBox.setSelectedIndex(-1);
		this.studentIDTextField.setText("");
		this.birthdayDateChooser.setDate(null);
		this.provinceComboBox.setSelectedIndex(-1);
		this.phoneNumberTextField.setText("");
		this.emailTextField.setText("");
		this.IDTextField.setText("");
		this.verifyCheckBox.setSelected(false);
		
		this.gender = gender;
		this.signInRoom = room;
		this.dormitory = dormitory;
	}
	
	
	
	public void register() {
		if(nameTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên");
		}else if(!pattern.matcher(IDTextField.getText()).find()) {
			JOptionPane.showMessageDialog(null, "Căn cước công dân không hợp lệ");
		}else if(dormitory.containID(IDTextField.getText())) {
			JOptionPane.showMessageDialog(null, "Căn cước công dân đã được sử dụng");
		}else if(universityComboBox.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường đại học");
		}else if(studentIDTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã số sinh viên");
		}else if(birthdayDateChooser.getDate()==null) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngày sinh");
		}else if(provinceComboBox.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn tỉnh");
		}else if(emailTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập email");
		}else if(phoneNumberTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại");
		}else if(!this.verifyCheckBox.isSelected()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa xác thực thông tin ở trên");
		}
		else {
			Student student = new Student(nameTextField.getText(),IDTextField.getText(),gender.equals("Nam")?true:false,universityComboBox.getSelectedItem().toString(),studentIDTextField.getText(),birthdayDateChooser.getDate(),emailTextField.getText(),phoneNumberTextField.getText(),provinceComboBox.getSelectedItem().toString(),signInRoom);
			
			dormitory.addStudent(student);
			signInViewer.updateVacancyRoomListTable();
			signInViewer.setVisible(true);
			dispose();
		}
	}
}
