package ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import common.DateLabelFormatter;
public class StudentInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] label ={"  ID: ","  Full name: ","  National ID: ","  Birthday: ","  Address: ","  Phone number:"};
	JPanel labelPanel;
	JPanel tfPanel;
	JPanel btnPanel;
	JPanel formPanel;
	JPanel avatarPanel;
	JPanel inforPanel;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JTextField 	id;
	JTextField avatar;
	JTextField fullName;
	JTextField nationalId;
	JDatePickerImpl birthday;
	JTextField birthdateF;
	JTextField address;
	JTextField phone;
	UtilDateModel model;
	
	
	

	public UtilDateModel getModel() {
		return model;
	}

	public void setModel(UtilDateModel model) {
		this.model = model;
	}

	public String[] getLabel() {
		return label;
	}

	public void setLabel(String[] label) {
		this.label = label;
	}

	public JPanel getLabelPanel() {
		return labelPanel;
	}

	public void setLabelPanel(JPanel labelPanel) {
		this.labelPanel = labelPanel;
	}

	public JPanel getTfPanel() {
		return tfPanel;
	}

	public void setTfPanel(JPanel tfPanel) {
		this.tfPanel = tfPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public JPanel getFormPanel() {
		return formPanel;
	}

	public void setFormPanel(JPanel formPanel) {
		this.formPanel = formPanel;
	}

	public JPanel getAvatarPanel() {
		return avatarPanel;
	}

	public void setAvatarPanel(JPanel avatarPanel) {
		this.avatarPanel = avatarPanel;
	}

	public JPanel getInforPanel() {
		return inforPanel;
	}

	public void setInforPanel(JPanel inforPanel) {
		this.inforPanel = inforPanel;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getAvatar() {
		return avatar;
	}

	public void setAvatar(JTextField avatar) {
		this.avatar = avatar;
	}

	public JTextField getFullName() {
		return fullName;
	}

	public void setFullName(JTextField fullName) {
		this.fullName = fullName;
	}

	public JTextField getNationalId() {
		return nationalId;
	}

	public void setNationalId(JTextField nationalId) {
		this.nationalId = nationalId;
	}

	public JDatePickerImpl getBirthday() {
		return birthday;
	}

	public void setBirthday(JDatePickerImpl birthday) {
		this.birthday = birthday;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPhone() {
		return phone;
	}

	public void setPhone(JTextField phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StudentInfoPanel() {
		this.setPreferredSize(new Dimension(800, 400));
		addControls();
		setting();
	}
	
	private void addControls() {
		inforPanel = new JPanel();
		inforPanel.setLayout(new BorderLayout());
		avatarPanel = new JPanel();
		avatarPanel.setLayout(new BorderLayout());
		
		BufferedImage img;
		try {
			img = ImageIO.read(new File("IMG_3575.jpg"));
			ImageIcon icon = new ImageIcon(img);
			JLabel labela = new JLabel(icon);
			labela.setMaximumSize(new Dimension(120, 90));
			avatarPanel.add(labela,BorderLayout.CENTER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout());

		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(label.length, 1));
		tfPanel = new JPanel();
		tfPanel.setLayout(new GridLayout(label.length, 1));
		for(int i = 0; i < label.length; i++)
		{
			labelPanel.add(new JLabel(label[i]));
			//tfPanel.add(new JTextField(50));
		}
		id = new JTextField("");
		id.setColumns(50);

		fullName = new JTextField(20);


		nationalId = new JTextField(20);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p );
		birthday = new JDatePickerImpl(datePanel,new DateLabelFormatter());


		address = new JTextField(20);


		phone = new JTextField(20);
		
		birthdateF = new JTextField(20);
		birthdateF.setVisible(false);
		
		tfPanel.add(id);
		tfPanel.add(fullName);
		tfPanel.add(nationalId);
		tfPanel.add(birthday);
		//tfPanel.add(birthdateF);
		tfPanel.add(address);
		tfPanel.add(phone);

		btnPanel = new JPanel();
		btn1 = new JButton("Edit");
		btn2 = new JButton("Delete");
		btn3 = new JButton("Print");
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		inforPanel.add(labelPanel, BorderLayout.LINE_START);
		inforPanel.add(tfPanel, BorderLayout.CENTER);
		formPanel.add(avatarPanel, BorderLayout.LINE_START);
		formPanel.add(inforPanel, BorderLayout.CENTER);
		formPanel.add(btnPanel, BorderLayout.PAGE_END);
	}

	private void setting() {
		this.add(formPanel);

	}

	public void setIdText(String id2) {
		this.id.setText(id2);
		
	}

	public void setFullNameText(String fullName2) {
		this.fullName.setText(fullName2);
		
	}

	public void setNationalIdText(String nationalId2) {
		this.nationalId.setText(nationalId2);
		
	}

	public void setAddressText(String address2) {
		this.address.setText(address2);
	}

	public void setPhoneText(String phone2) {
		this.phone.setText(phone2);
		
	}

	public void setBirthday(String birthday2) {
		String[] birthdayTemp = birthday2.split("-");
		int year = Integer.parseInt(birthdayTemp[0]);
		int month = Integer.parseInt(birthdayTemp[1]);
		int day = Integer.parseInt(birthdayTemp[2]);
		this.model.setDate(year, month, day);
		this.model.setSelected(true);
		
	}
}
