package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import common.Validation;
import model.bean.Member;
import model.bo.MemberBO;

public class SearchPanel extends JPanel {

	/**
	 * Đây là phần panel bao gồm search field, student list và nút Add
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtSearch;
	JPanel searchPanel;
	JButton btnAdd;
	JLabel lbSearch;
	JLabel lbStudentId;
	JScrollPane spStudentId;
	DefaultListModel<String> lmStudentId;
	JList<String> listStudentId;

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}

	public JPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(JPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JLabel getLbSearch() {
		return lbSearch;
	}

	public void setLbSearch(JLabel lbSearch) {
		this.lbSearch = lbSearch;
	}

	public JLabel getLbStudentId() {
		return lbStudentId;
	}

	public void setLbStudentId(JLabel lbStudentId) {
		this.lbStudentId = lbStudentId;
	}

	public JScrollPane getSpStudentId() {
		return spStudentId;
	}

	public void setSpStudentId(JScrollPane spStudentId) {
		this.spStudentId = spStudentId;
	}

	public DefaultListModel<String> getLmStudentId() {
		return lmStudentId;
	}

	public void setLmStudentId(DefaultListModel<String> lmStudentId) {
		this.lmStudentId = lmStudentId;
	}

	public JList<String> getListStudentId() {
		return listStudentId;
	}

	public void setListStudentId(JList<String> listStudentId) {
		this.listStudentId = listStudentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SearchPanel() {
		this.setLayout(new BorderLayout());
		addControls();
		addEvents();
		setting();
	}

	private void setting() {
		this.add(txtSearch, BorderLayout.PAGE_START);
		this.add(spStudentId, BorderLayout.CENTER);
		this.add(btnAdd, BorderLayout.PAGE_END);
	}

	// Sự kiện thì chỉ được code trong addEvent
	private void addEvents() {
		MemberBO studentBO = new MemberBO();
		// Tìm kiếm
		txtSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				String searchData = txtSearch.getText();
				System.out.println(searchData);
				lmStudentId = new DefaultListModel<>();
				lmStudentId = studentBO.getListStudent(searchData);
				listStudentId = new JList<>(lmStudentId);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String searchData = txtSearch.getText();
				System.out.println(searchData);
				lmStudentId = new DefaultListModel<>();
				lmStudentId = studentBO.getListStudent(searchData);
				listStudentId = new JList<>(lmStudentId);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				String searchData = txtSearch.getText();
				System.out.println(searchData);
				lmStudentId = new DefaultListModel<>();
				lmStudentId = studentBO.getListStudent(searchData);
				listStudentId = new JList<>(lmStudentId);
			}
		});

		// Sự kiện của nút Add ở đây
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormInfoFrame addFrame = new FormInfoFrame();
				addFrame.setVisible(true);
				addFrame.setTitle("Add student information");
				addFrame.setResizable(false);
				addFrame.inforForm.btn3.setVisible(false);
				// Nút add
				addFrame.inforForm.btn1.setText("Add");

				// Nút cancel
				addFrame.inforForm.btn2.setText("Cancel");

				// Sự kiện của nút Add ở đây
				addFrame.inforForm.btn1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Validation validate = new Validation();
						String id = addFrame.inforForm.id.getText();
						;
						// while (true){
						// id = addFrame.inforForm.id.getText();
						// if (!validate.isValidId(id)){
						// addFrame.inforForm.id.setText("");
						// JOptionPane.showMessageDialog(null, "Invalid Data.
						// Please try again!");
						// addFrame.inforForm.id.isFocusable();
						// }
						// else break;
						// }
						String fullNameTemp = addFrame.inforForm.fullName.getText();
						String fullName = fullNameTemp.trim();
						;
						String nationalId = addFrame.inforForm.nationalId.getText();
						// while (true){
						// nationalId = addFrame.inforForm.nationalId.getText();
						// if (!validate.isValidId(nationalId)){
						// addFrame.inforForm.nationalId.setText("");
						// JOptionPane.showMessageDialog(null, "Invalid Data.
						// Please try again!");
						// addFrame.inforForm.nationalId.isFocusable();
						// }
						// else break;
						// }
						String birthday = null;
						try {
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							birthday = df.format(addFrame.inforForm.birthday.getModel().getValue());
						} catch (Exception e1) {

						}
						String address = addFrame.inforForm.address.getText();
						String phone = addFrame.inforForm.phone.getText();
						// while (true){
						// phone = addFrame.inforForm.phone.getText();
						// if (!validate.isValidPhoneNumber(phone)){
						// addFrame.inforForm.phone.setText("");
						// JOptionPane.showMessageDialog(null, "Invalid Data.
						// Please try again!");
						// addFrame.inforForm.phone.isFocusable();
						// }
						// else break;
						// }
						if (!validate.isValidId(id)) {
							JOptionPane.showMessageDialog(null, "Invalid ID . Please try again!");
						} else if (!validate.isValidName(fullName)) {
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
						} else {
							Member member = new Member(id, "", fullName, nationalId, birthday, address, phone);
							if (studentBO.addMember(member)==true) {
								lmStudentId.addElement(id);
								JOptionPane.showMessageDialog(null, "Added member's data successful!");
								addFrame.setVisible(false);
							} else
								JOptionPane.showMessageDialog(null, "Already ID. Please enter the other ID");
						}
					}
				});

				// Sự kiện của nút Cancel ở đây
				addFrame.inforForm.btn2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						addFrame.setVisible(false);
					}
				});

			}
		});
	}

	private void addControls() {
		txtSearch = new JTextField();
		btnAdd = new JButton("Add");
		lbSearch = new JLabel("Search:");
		lbStudentId = new JLabel("Student id:");

		lmStudentId = new DefaultListModel<>();

		MemberBO studentBO = new MemberBO();
		ArrayList<Member> listStudent = studentBO.getListStudent();
		for (int i = 0; i < listStudent.size(); i++) {
			lmStudentId.addElement(listStudent.get(i).getId());
		}

		listStudentId = new JList<>(lmStudentId);
		listStudentId.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listStudentId.setLayoutOrientation(JList.VERTICAL);
		listStudentId.setVisibleRowCount(-1);

		spStudentId = new JScrollPane(listStudentId);
		spStudentId.setPreferredSize(new Dimension(150, 50));

	}
}
