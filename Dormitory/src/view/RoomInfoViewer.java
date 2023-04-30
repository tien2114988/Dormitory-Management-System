package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import model.Student;



public class RoomInfoViewer extends JFrame {
	private JPanel contentPane;
	
	private SignInViewer signInViewer;
	
	private JLabel zoneLabel;
	private JLabel clusterLabel;
	private JLabel buildingLabel;
	private JLabel genderLabel;
	private JLabel roomLabel;
	private JLabel roomTypeLabel;
	private JLabel studentListLabel;
	private JTable studentListTable;

	private List<Student> studentList;


	
	public RoomInfoViewer(SignInViewer forStudentViewer) {
		this.signInViewer = forStudentViewer;
		
		this.init();
		this.initLabel();
		this.initStudentListTable();
		this.initBackButton();
		this.initBackground();
	}
	
	
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Save object to file here
		    	signInViewer.setVisible(true);
				dispose();
		    }
		});
		this.setBounds(100, 100, 960, 520);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		this.setTitle("Thông tin phòng");
	}
	
	
	
	public void initLabel() {
		//ZONE
		this.zoneLabel = new JLabel("Khu : ");
		this.zoneLabel.setForeground(new Color(0, 0, 0));
		this.zoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.zoneLabel.setBounds(10, 103, 61, 21);
		this.contentPane.add(this.zoneLabel);
		
		//CLUSTER
		this.clusterLabel = new JLabel("Cụm : ");
		this.clusterLabel.setForeground(new Color(0, 0, 0));
		this.clusterLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.clusterLabel.setBounds(114, 103, 85, 21);
		this.contentPane.add(this.clusterLabel);
		
		//BUILDING
		this.buildingLabel = new JLabel("Tòa : ");
		this.buildingLabel.setForeground(new Color(0, 0, 0));
		this.buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.buildingLabel.setBounds(239, 103, 68, 21);
		this.contentPane.add(this.buildingLabel);
		
		//GENDER
		this.genderLabel = new JLabel("Giới tính : ");
		this.genderLabel.setForeground(new Color(0, 0, 0));
		this.genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.genderLabel.setBounds(352, 103, 107, 21);
		this.contentPane.add(this.genderLabel);
		
		//ROOM
		this.roomLabel = new JLabel("Phòng : ");
		this.roomLabel.setForeground(new Color(0, 0, 0));
		this.roomLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomLabel.setBounds(515, 103, 101, 21);
		this.contentPane.add(this.roomLabel);
		
		//ROOM TYPE
		this.roomTypeLabel = new JLabel("Loại phòng : ");
		this.roomTypeLabel.setForeground(new Color(0, 0, 0));
		this.roomTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.roomTypeLabel.setBounds(657, 103, 289, 21);
		this.contentPane.add(this.roomTypeLabel);
		
		// STUDENT LIST
		this.studentListLabel = new JLabel("Danh sách sinh viên");
		this.studentListLabel.setForeground(new Color(128, 0, 64));
		this.studentListLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		this.studentListLabel.setBounds(128, 168, 143, 21);
		this.contentPane.add(this.studentListLabel);
	}
	
	
	
	public void initStudentListTable() {
		// TABLE
		this.studentListTable = new JTable() {
            DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
            {
            	renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
            }
            @Override
            public TableCellRenderer getCellRenderer(int arg0, int arg1) {
                return renderCenter;
            }
        };
        this.studentListTable.setEnabled(false);
        this.studentListTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        this.studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên", "Trường", "MSSV"
			}
		));
        this.studentListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.studentListTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.studentListTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.studentListTable.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.studentListTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        // SCROLL PANE
		JScrollPane scrollPane = new JScrollPane(studentListTable);
		scrollPane.setBounds(128, 199, 693, 154);
		contentPane.add(scrollPane);
	}
	
	
	
	public void initBackButton() {
		JButton backButton = new JButton("Thoát");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 128, 0));
		backButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signInViewer.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(861, 462, 85, 21);
		this.contentPane.add(backButton);
	}
	
	
	
	public void initBackground() {
		//logo
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(RoomInfoViewer.class.getResource("/picture/logo.png")));
		logoLabel.setBounds(360, 10, 87, 60);
		this.contentPane.add(logoLabel);
		
		//title
		JLabel titleLabel = new JLabel("Thông tin phòng");
		titleLabel.setForeground(new Color(128, 0, 0));
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(456, 10, 134, 60);
		this.contentPane.add(titleLabel);
		
		//background
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(RoomInfoViewer.class.getResource("/picture/istockphoto-1464946390-612x612.jpg")));
		backgroundLabel.setBounds(0, 0, 946, 483);
		this.contentPane.add(backgroundLabel);
	}
	
	
	
	public void updateStudentList(List<Student> studentList,String zoneName, String clusterName, String buildingName, String gender, short roomNumber, String roomType) {
		// set table
		this.studentList = studentList;
		DefaultTableModel studentListModel = (DefaultTableModel)studentListTable.getModel();
		studentListModel.getDataVector().removeAllElements();
		int i = 1;
		for (Student student : studentList) {
			studentListModel.addRow(new Object[] {
						i+"",student.getName(),student.getUniversityName(),student.getStudentID()
				});
			i++;
		}
		
		// set label
		this.zoneLabel.setText("Khu : "+zoneName);
		this.clusterLabel.setText("Cụm : "+clusterName);
		this.buildingLabel.setText("Tòa : "+buildingName);
		this.genderLabel.setText("Giới tính : "+gender);
		this.roomLabel.setText("Phòng  : "+roomNumber);
		this.roomTypeLabel.setText("Loại phòng : "+roomType);
	}
}
