package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import model.Building;
import model.Cluster;
import model.Room;
import model.Student;
import model.Zone;



public class SignInViewer extends JFrame{
	private JPanel contentPane;
	
	private HomePageViewer homePageViewer;
	
	private RoomInfoViewer roomInfoViewer;
	private SignInFormViewer signInFormViewer;
	
	private JComboBox zoneComboBox;
	private JComboBox clusterComboBox;
	private JComboBox buildingComboBox;
	private JComboBox genderComboBox;
	private JComboBox roomTypeComboBox;
	private JTable vacancyRoomListTable;
	
	private List<Room> vacancyRoomList;

	
	
	
	public SignInViewer(HomePageViewer homePageViewer) {
		this.homePageViewer = homePageViewer;
		this.roomInfoViewer = new RoomInfoViewer(this);
		this.signInFormViewer = new SignInFormViewer(this);
		
		this.init();
		this.initZoneField();
		this.initClusterField();
		this.initGenderField();
		this.initBuildingField();
		this.initRoomTypeField();
		this.initVacancyRoomListTable();
		this.initRoomInfoButton();
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
		    	homePageViewer.setVisible(true);
				dispose();
		    }
		});
		this.setBounds(100, 100, 975, 520);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("src\\picture\\logo.png");
		this.setIconImage(img.getImage());
		this.setTitle("Đăng ký");
	}
	
	
	
	public void initZoneField() {
		//zone label
		JLabel zoneLabel = new JLabel("Khu");
		zoneLabel.setForeground(new Color(0, 0, 0));
		zoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		zoneLabel.setBounds(10, 97, 26, 23);
		this.contentPane.add(zoneLabel);
		
		//zone combobox
		this.zoneComboBox = new JComboBox();
		this.zoneComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.zoneComboBox.addItem("Chọn Khu");
		List<Zone> zoneList = homePageViewer.getDormitory().getZoneList();
		for (Zone zone : zoneList) {
			zoneComboBox.addItem(zone.getName());
		}
		
		this.zoneComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateClusterComboBox();
			}
		});
		
		this.zoneComboBox.setBounds(40, 97, 88, 23);
		this.contentPane.add(zoneComboBox);
	}
	
	
	
	public void initClusterField() {
		//cluster label
		JLabel clusterLabel = new JLabel("Cụm");
		clusterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		clusterLabel.setBounds(161, 97, 34, 23);
		this.contentPane.add(clusterLabel);
		
		//cluster combobox
		this.clusterComboBox = new JComboBox();
		this.clusterComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.clusterComboBox.addItem("Chọn Cụm");
		
		this.clusterComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateBuildingComboBox();
			}
		});
		
		this.clusterComboBox.setBounds(195, 97, 96, 23);
		this.contentPane.add(clusterComboBox);
	}
	
	
	
	public void initGenderField() {
		//gender label
		JLabel genderLabel = new JLabel("Giới tính");
		genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		genderLabel.setBounds(316, 97, 53, 23);
		this.contentPane.add(genderLabel);
				
		//gender combobox
		this.genderComboBox = new JComboBox();
		this.genderComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.genderComboBox.addItem("Chọn Giới tính");
		
		this.genderComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateBuildingComboBox();
			}
		});
		
		this.genderComboBox.setBounds(373, 97, 120, 23);
		this.contentPane.add(genderComboBox);
	}
	
	
	
	public void initBuildingField() {
		//building label
		JLabel buildingLabel = new JLabel("Tòa");
		buildingLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buildingLabel.setBounds(525, 97, 34, 23);
		this.contentPane.add(buildingLabel);
		
		//building combobox
		this.buildingComboBox = new JComboBox();
		this.buildingComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.buildingComboBox.addItem("Chọn Tòa");
		
		this.buildingComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateRoomTypeComboBox();
			}		
		});
		
		this.buildingComboBox.setBounds(554, 97, 91, 23);
		this.contentPane.add(buildingComboBox);
	}
	
	
	
	public void initRoomTypeField() {
		//room type label
		JLabel roomTypeLabel = new JLabel("Loại phòng");
		roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		roomTypeLabel.setBounds(676, 97, 70, 23);
		this.contentPane.add(roomTypeLabel);
		
		//room type combobox
		this.roomTypeComboBox = new JComboBox();
		this.roomTypeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.roomTypeComboBox.addItem("Chọn Loại phòng");
		
		this.roomTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateVacancyRoomListTable();
			}
		});
		
		this.roomTypeComboBox.setBounds(745, 97, 213, 23);
		this.contentPane.add(roomTypeComboBox);
	}
	
	
	
	public void initVacancyRoomListTable() {
		// label
		JLabel roomListLabel = new JLabel("Danh sách phòng trống");
		roomListLabel.setForeground(new Color(128, 0, 64));
		roomListLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		roomListLabel.setBounds(308, 155, 188, 31);
		this.contentPane.add(roomListLabel);
		
		// table
		this.vacancyRoomListTable = new JTable() {
            DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
            {
            	renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
            }
            @Override
            public TableCellRenderer getCellRenderer(int arg0, int arg1) {
                return renderCenter;
            }
        };
        this.vacancyRoomListTable.setForeground(new Color(0, 0, 0));
        this.vacancyRoomListTable.setBackground(new Color(255, 255, 255));
		this.vacancyRoomListTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.vacancyRoomListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.vacancyRoomListTable.setFillsViewportHeight(true);
		this.vacancyRoomListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Phòng", "S\u1ED1 ch\u1ED7 tr\u1ED1ng"
			}
		));
		this.vacancyRoomListTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		
		//scroll
		JScrollPane scrollPane = new JScrollPane(vacancyRoomListTable);
		scrollPane.setBounds(308, 200, 351, 183);
		this.contentPane.add(scrollPane);
	}
	
	
	
	public void initRoomInfoButton() {
		JButton roomInfoButton = new JButton("Xem thông tin phòng");
		roomInfoButton.setForeground(new Color(255, 255, 255));
		roomInfoButton.setBackground(new Color(0, 128, 192));
		roomInfoButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		roomInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewRoomInfo();
			}
		});
		
		roomInfoButton.setBounds(308, 403, 174, 21);
		contentPane.add(roomInfoButton);
	}
	
	
	
	public void initSignInButton() {
		JButton signInButton = new JButton("Đăng ký");
		signInButton.setForeground(new Color(255, 255, 255));
		signInButton.setBackground(new Color(0, 128, 192));
		signInButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewSignInForm();
			}
		
		});
		
		signInButton.setBounds(510, 403, 149, 21);
		this.contentPane.add(signInButton);
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
				homePageViewer.setVisible(true);
				dispose();
			}
		});
		
		backButton.setBounds(876, 462, 85, 21);
		this.contentPane.add(backButton);
	}
	
	
	
	public void initBackground() {
		//logo
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(SignInViewer.class.getResource("/picture/logo.png")));
		logoLabel.setBounds(362, 10, 80, 50);
		this.contentPane.add(logoLabel);
		
		//title
		JLabel titleLabel = new JLabel("Thông tin đăng ký");
		titleLabel.setForeground(new Color(128, 0, 0));
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(460, 14, 195, 46);
		this.contentPane.add(titleLabel);
		
		//background
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(SignInViewer.class.getResource("/picture/rm222batch5-kul-03.jpg")));
		backgroundLabel.setBounds(0, 0, 961, 483);
		this.contentPane.add(backgroundLabel);
	}
	
	
	
	public void updateClusterComboBox() {
		//cluster
		DefaultComboBoxModel clusterModel = new DefaultComboBoxModel();
		List<Cluster> clusterList = this.homePageViewer.getDormitory().getClusterList(zoneComboBox.getSelectedItem().toString());
		clusterModel.addElement("Chọn Cụm");
		if(clusterList!=null) {
			for (Cluster cluster : clusterList) {
				clusterModel.addElement(cluster.getName());
			}
		}
		this.clusterComboBox.setModel(clusterModel);
		
		//gender
		DefaultComboBoxModel genderModel = new DefaultComboBoxModel();
		genderModel.addElement("Chọn Giới tính");
		genderModel.addElement("Nam");
		genderModel.addElement("Nữ");
		this.genderComboBox.setModel(genderModel);
		
		//update building
		this.updateBuildingComboBox();
	}
	
	
	
	public void updateBuildingComboBox() {
		//building
		DefaultComboBoxModel buildingModel = new DefaultComboBoxModel();
		buildingModel.addElement("Chọn Tòa");
		
		String gender = genderComboBox.getSelectedItem().toString();
		List<Building> buildingList = null;
		if (gender.equals("Nam")) {
			buildingList = this.homePageViewer.getDormitory().getBuildingListByGender(zoneComboBox.getSelectedItem().toString(),clusterComboBox.getSelectedItem().toString(),true);
			
		} else if(gender.equals("Nữ")){
			buildingList = this.homePageViewer.getDormitory().getBuildingListByGender(zoneComboBox.getSelectedItem().toString(),clusterComboBox.getSelectedItem().toString(),false);
		}
		
		if(buildingList!=null) {
			for (Building building : buildingList) {
				buildingModel.addElement(building.getName());
			}
		}
		
		this.buildingComboBox.setModel(buildingModel);
		
		//update room type
		this.updateRoomTypeComboBox();
	}
	
	
	
	public void updateRoomTypeComboBox() {
		//room type
		DefaultComboBoxModel roomTypeModel = new DefaultComboBoxModel();
		roomTypeModel.addElement("Chọn Loại phòng");
		if(!this.buildingComboBox.getSelectedItem().toString().equals("Chọn Tòa")) {
			List<String> roomTypeList = Room.getRoomTypeList(zoneComboBox.getSelectedItem().toString());
			for (String roomType : roomTypeList) {
				roomTypeModel.addElement(roomType);
			}
		}
		this.roomTypeComboBox.setModel(roomTypeModel);
		
		//update vacancy room list
		this.updateVacancyRoomListTable();
	}
	
	
	
	public void updateVacancyRoomListTable() {
		//vacancy room list
		DefaultTableModel vacancyRoomModel = (DefaultTableModel)this.vacancyRoomListTable.getModel();
		vacancyRoomModel.getDataVector().removeAllElements();
		if(!this.roomTypeComboBox.getSelectedItem().toString().equals("Chọn Loại phòng")) {
			this.vacancyRoomList = this.homePageViewer.getDormitory().getVacancyRoomList(zoneComboBox.getSelectedItem().toString(),clusterComboBox.getSelectedItem().toString(),buildingComboBox.getSelectedItem().toString(),roomTypeComboBox.getSelectedItem().toString());
			for (Room vacancyRoomName : vacancyRoomList) {
				vacancyRoomModel.addRow(new Object[] {
						vacancyRoomName.getRoomNumber()+"",vacancyRoomName.getVacancy()+""
				});
			}
		}
		vacancyRoomModel.fireTableDataChanged();
		vacancyRoomModel.fireTableStructureChanged();
	}
	
	
	
	public void viewRoomInfo() {
		DefaultTableModel vacancyRoomModel = (DefaultTableModel)this.vacancyRoomListTable.getModel();
		int row = this.vacancyRoomListTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng");
		}else {
			short roomNumber = Short.valueOf(vacancyRoomModel.getValueAt(this.vacancyRoomListTable.getSelectedRow(), 0)+"");
			List<Student> studentList = null;
			for (Room room : this.vacancyRoomList) {
				if(room.getRoomNumber()==roomNumber) {
					studentList = room.getStudentList();
				}
			}
			this.roomInfoViewer.updateStudentList(studentList,zoneComboBox.getSelectedItem().toString(),clusterComboBox.getSelectedItem().toString(),buildingComboBox.getSelectedItem().toString(),genderComboBox.getSelectedItem().toString(),roomNumber,roomTypeComboBox.getSelectedItem().toString());
			this.roomInfoViewer.setVisible(true);
			this.dispose();
		}
	}
	
	
	
	public void viewSignInForm() {
		int row = this.vacancyRoomListTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng");
		}else {
			DefaultTableModel vacancyRoomModel = (DefaultTableModel)this.vacancyRoomListTable.getModel();
			short roomNumber = Short.valueOf(vacancyRoomModel.getValueAt(this.vacancyRoomListTable.getSelectedRow(), 0)+"");
			Room signInRoom = null;
			for (Room room : this.vacancyRoomList) {
				if(room.getRoomNumber()==roomNumber) {
					signInRoom=room;
				}
			}
			this.signInFormViewer.setSignInForm(homePageViewer.getDormitory(),signInRoom,zoneComboBox.getSelectedItem().toString(),clusterComboBox.getSelectedItem().toString(),buildingComboBox.getSelectedItem().toString(),genderComboBox.getSelectedItem().toString(),roomNumber,roomTypeComboBox.getSelectedItem().toString());
			this.signInFormViewer.setVisible(true);
			this.dispose();
		}
	}
	
	
	
	public void clear() {
		this.zoneComboBox.setSelectedIndex(0);
		this.updateClusterComboBox();
	}
}
