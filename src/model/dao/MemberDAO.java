package model.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.bean.Member;
import utils.ConnectDB;

public class MemberDAO {
	ConnectDB connect = new ConnectDB();

	public boolean addStudent(Member student) {
		boolean check = false;	
		try {
				
				Statement stm = connect.getConnection().createStatement();
				String id = student.getId();
				String checkDuplicateSQL = "Select * from SINHVIEN where ID='"+id+"'";
				System.out.println(checkDuplicateSQL);
				ResultSet rs = stm.executeQuery(checkDuplicateSQL);
				System.out.println(rs.next());
				if (rs.next()==true)
				{
				}
				else{
					String insertSQL = "insert into SINHVIEN values (?,?,?,?,?,?,?)";
					PreparedStatement ps = connect.getConnection().prepareStatement(insertSQL);
					ps.setString(1, student.getId());
					ps.setString(2, student.getAvatar());
					ps.setString(3, student.getFullName());
					ps.setString(4, student.getNationalId());
					ps.setString(5, student.getBirthday());
					ps.setString(6, student.getAddress());
					ps.setString(7, student.getPhone());
					ps.executeUpdate();
					return check = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return check;
	}

	public Member getStudent(String studentID) {
		String sql = "SELECT * FROM SINHVIEN WHERE ID=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = connect.getConnection().prepareStatement(sql);
			ps.setString(1, studentID);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Member student = new Member();
		try {
			while (rs.next()) {
				student.setId(rs.getString(1));
				student.setAvatar(rs.getString(2));
				student.setFullName(rs.getString(3));
				student.setNationalId(rs.getString(4));
				student.setBirthday(rs.getString(5));
				student.setAddress(rs.getString(6));
				student.setPhone(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public boolean editStudent(Member student) {
		String sql = "UPDATE SINHVIEN " + "SET Avatar = ?, " + "FullName = ?, " + "NationalID =?, " + "Birthday =?, "
				+ "Address =?, " + "Phone = ? " + "WHERE ID = ? ";
		PreparedStatement ps;
		try {
			ps = connect.getConnection().prepareStatement(sql);
			ps.setString(1, student.getAvatar());
			ps.setString(2, student.getFullName());
			ps.setString(3, student.getNationalId());
			ps.setString(4, student.getBirthday());
			ps.setString(5, student.getAddress());
			ps.setString(6, student.getPhone());
			ps.setString(7, student.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteStudent(String studentID) {
		String sql = "DELETE FROM SINHVIEN WHERE ID = ?";
		try {
			PreparedStatement ps = connect.getConnection().prepareStatement(sql);
			ps.setString(1, studentID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Member> getListStudent() {
		String sql = "SELECT * FROM SINHVIEN";
		ResultSet rs = null;
		try {
			PreparedStatement ps = connect.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Member student;
		ArrayList<Member> listStudent = new ArrayList<>();
		try {
			while (rs.next()) {
				student = new Member();
				student.setId(rs.getString(1));
				student.setAvatar(rs.getString(2));
				student.setFullName(rs.getString(3));
				student.setNationalId(rs.getString(4));
				student.setBirthday(rs.getString(5));
				student.setAddress(rs.getString(6));
				student.setPhone(rs.getString(7));
				listStudent.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStudent;

	}

	public DefaultListModel<String> getListStudent(String searchData) {
		String sql = "Select Id From SINHVIEN where Id like '%?%'";
		ResultSet rs = null;
		try {
			PreparedStatement ps = connect.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DefaultListModel<String> listId = new DefaultListModel<>();
		try {
			while (rs.next()) {
				String id = rs.getString(1);
				listId.addElement(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listId;
	}

}
