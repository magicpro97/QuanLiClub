package model.bo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.bean.Member;
import model.dao.MemberDAO;

public class MemberBO {
	MemberDAO memberDAO = new MemberDAO();
	public boolean addMember(Member student){
		return memberDAO.addStudent(student);
	}
	public Member getStudent(String studentID){
		return memberDAO.getStudent(studentID);
	}
	public boolean editStudent(Member student){
		return memberDAO.editStudent(student);
	}
	public void deleteStudent(String studentID){
		memberDAO.deleteStudent(studentID);
	}
	public ArrayList<Member> getListStudent(){
		return memberDAO.getListStudent();
	}
	public DefaultListModel<String> getListStudent(String searchData) {
		// TODO Auto-generated method stub
		return memberDAO.getListStudent(searchData);
	}
}
