package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Validation;
import model.bean.Member;
import model.bo.MemberBO;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SearchPanel searchPanel;
	StudentInfoPanel studentInfoPanel;
	JMenuBar menuBar;
	JMenu mnFile;
	JMenu mnAbout;
	JMenuItem mtExit;
	
	
	public MainFrame() throws HeadlessException {
		super();
		addControls();
		addEvents();
		setting();
	}
	//Sự kiện thì chỉ được code trong addEvent
	private void addEvents() {
		MemberBO studentBO = new MemberBO();
		searchPanel.listStudentId.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				for (Component c: studentInfoPanel.getComponents()){
					c.setVisible(true);
				}
				String studentId = searchPanel.listStudentId.getSelectedValue();
				Member student = studentBO.getStudent(studentId);
				
				studentInfoPanel.id.setEnabled(false);
				studentInfoPanel.id.setDisabledTextColor(Color.BLACK);
				studentInfoPanel.id.setBackground(getBackground());
				studentInfoPanel.id.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.id.setText(" "+student.getId());
				
				studentInfoPanel.fullName.setEnabled(false);
				studentInfoPanel.fullName.setDisabledTextColor(Color.BLACK);
				studentInfoPanel.fullName.setBackground(getBackground());
				studentInfoPanel.fullName.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.fullName.setText(student.getFullName());
				
				studentInfoPanel.nationalId.setEnabled(false);
				studentInfoPanel.nationalId.setDisabledTextColor(Color.BLACK);
				studentInfoPanel.nationalId.setBackground(getBackground());
				studentInfoPanel.nationalId.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.nationalId.setText(" "+student.getNationalId());
				if (student.getBirthday()!=null){
				String[] birthdayTemp = student.getBirthday().split("-");
				int year = Integer.parseInt(birthdayTemp[0]);
				int month = Integer.parseInt(birthdayTemp[1]);
				int day = Integer.parseInt(birthdayTemp[2]);
				studentInfoPanel.birthday.setEnabled(false);
				studentInfoPanel.birthday.setBackground(getBackground());
				studentInfoPanel.birthday.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.model.setDate(year, month, day);
				studentInfoPanel.model.setSelected(true);
				studentInfoPanel.birthday.getComponent(1).setEnabled(false);
				}
				
				studentInfoPanel.address.setEnabled(false);
				studentInfoPanel.address.setDisabledTextColor(Color.BLACK);
				studentInfoPanel.address.setBackground(getBackground());
				studentInfoPanel.address.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.address.setText(" "+student.getAddress());
				
				studentInfoPanel.phone.setEnabled(false);
				studentInfoPanel.phone.setDisabledTextColor(Color.BLACK);
				studentInfoPanel.phone.setBackground(getBackground());
				studentInfoPanel.phone.setBorder(BorderFactory.createEmptyBorder());
				studentInfoPanel.phone.setText(" "+student.getPhone());
			}
		});
		//Đây sự kiện của nút Edit
			studentInfoPanel.btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Đã vô đây!");
					FormInfoFrame editFrame = new FormInfoFrame();
					editFrame.setVisible(true);
					editFrame.setTitle("Edit student information!");
					editFrame.inforForm.btn3.setVisible(false);
					String studentId = searchPanel.listStudentId.getSelectedValue();
					System.out.println(studentId);
					Member student = studentBO.getStudent(studentId);
					//Hiển thị thông tin cũ
					editFrame.inforForm.setIdText(student.getId());
					editFrame.inforForm.getId().setEditable(false);;
					editFrame.inforForm.getId().setBorder(BorderFactory.createEmptyBorder());
					
					editFrame.inforForm.setFullNameText(student.getFullName());
					editFrame.inforForm.setNationalIdText(student.getNationalId());
					editFrame.inforForm.setBirthday(student.getBirthday());
					editFrame.inforForm.birthday.setBackground(Color.WHITE);
					editFrame.inforForm.setAddressText(student.getAddress());
					editFrame.inforForm.setPhoneText(student.getPhone());
					
					//Nút Save ở đây
					editFrame.inforForm.btn1.setText("Save");
					//Nút Cancel ở đây						
					editFrame.inforForm.btn2.setText("Cancel");
					
					//Sự kiện của nút Save ở đây
					editFrame.inforForm.btn1.addActionListener(new ActionListener() {
			
							@Override
							public void actionPerformed(ActionEvent e) {
								Validation validate = new Validation();
								String studentId = editFrame.inforForm.getId().getText();
								String avatar = "";
								String fullName = editFrame.inforForm.getFullName().getText();
								String nationalId = editFrame.inforForm.getNationalId().getText();
								DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
								String birthday= 	 df.format(editFrame.inforForm.birthday.getModel().getValue());
								String address = editFrame.inforForm.getAddress().getText();
								String phone  = editFrame.inforForm.getPhone().getText();
								
								if (!validate.isValidName(fullName)) {
									JOptionPane.showMessageDialog(null, "Invalid Fullname . Please try again!");
								} else if (!validate.isValidId(nationalId)) {
									JOptionPane.showMessageDialog(null, "Invalid National ID. Please try again!");
								} else if (birthday == null) {
									JOptionPane.showMessageDialog(null, "You haven't entered the birthday!");
								} else if (!validate.isValidAddress(address)) {
									JOptionPane.showMessageDialog(null, "Invalid Address . Please try again!");
								} else if (!validate.isValidPhoneNumber(phone)) {
									JOptionPane.showMessageDialog(null,
											"Invalid Phone(Note: The valid phone number must has 9-10 digits). Please try again");
								} else 
									{
										Member studentEditData  = new Member(studentId, avatar, fullName, nationalId, birthday, address, phone);
										if (studentBO.editStudent(studentEditData)){
											studentInfoPanel.setFullNameText(" "+studentEditData.getFullName());
											studentInfoPanel.setNationalIdText(" "+studentEditData.getNationalId());
											studentInfoPanel.setBirthday(studentEditData.getBirthday());
											studentInfoPanel.setAddressText(" "+studentEditData.getAddress());
											studentInfoPanel.setPhoneText(" "+studentEditData.getPhone());
											JOptionPane.showMessageDialog(null, "Edited successfull!");
											editFrame.setVisible(false);
										}
								}
								
								
							}
						});
						
						//Sự kiện của nút Cancel ở đây
						editFrame.inforForm.btn2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								editFrame.setVisible(false);
							}
						});
					}
				});
				//Đây là sự kiện bút Delete
				studentInfoPanel.btn2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete this student???", "Warning", JOptionPane.YES_NO_OPTION);
						if (dialogResult == JOptionPane.YES_OPTION){
							String studentId = searchPanel.listStudentId.getSelectedValue();
							int removeIndex = searchPanel.listStudentId.getSelectedIndex();
							searchPanel.lmStudentId.remove(removeIndex);
							for (Component c: studentInfoPanel.getComponents()){
								c.setVisible(false);
							}
							studentBO.deleteStudent(studentId);
							JOptionPane.showMessageDialog(null, "Deleted successfull!");
						}
					}
				});
				//Đây là sự kiện nút Print
				studentInfoPanel.btn3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						studentInfoPanel.btn1.setVisible(false);
						studentInfoPanel.btn2.setVisible(false);
						studentInfoPanel.btn3.setVisible(false);
						new PrintUIWindow(studentInfoPanel).actionPerformed(e);
						studentInfoPanel.btn1.setVisible(true);
						studentInfoPanel.btn2.setVisible(true);
						studentInfoPanel.btn3.setVisible(true);
					}
				});
	}
	
	private void addControls() {
		searchPanel = new SearchPanel();
		studentInfoPanel = new StudentInfoPanel();
//		studentInfoPanel.id.setVisible(false);;
//		studentInfoPanel.fullName.setVisible(false);;
//		studentInfoPanel.nationalId.setVisible(false);;
//		studentInfoPanel.birthday.setVisible(false);;
//		studentInfoPanel.address.setVisible(false);;
//		studentInfoPanel.phone.setVisible(false);;
//		studentInfoPanel.avatar.setVisible(false);;
//		studentInfoPanel.avatarPanel.setVisible(false);;
		for (Component c: studentInfoPanel.getComponents()){
			c.setVisible(false);
		}
		
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mtExit = new JMenuItem("Exit");
		mtExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mtExit);
		mnAbout = new JMenu("About");
		menuBar.add(mnFile);
		menuBar.add(mnAbout);
		
		
	}

	private void setting() {
		this.setTitle("Quản lí thông tin sinh viên");
		this.setVisible(true);
		this.setSize(new Dimension(800, 700));
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// add component
		//this.add(new JButton("Khu vuc nut bam"), BorderLayout.PAGE_START);
		//this.add(new JButton("Khu vuc hinh"),BorderLayout.LINE_END);
		this.add(new JLabel("Ngô Thế Linh - Võ Ngọc Rơ - Nguyễn Anh Nguyên - Trần Hồng Phúc"), BorderLayout.PAGE_END);
		this.add(searchPanel, BorderLayout.LINE_START);
		this.setJMenuBar(menuBar);
//		studentInfoPanel.setVisible(false);
		this.add(studentInfoPanel, BorderLayout.CENTER);
		this.pack();
	}
	
}
