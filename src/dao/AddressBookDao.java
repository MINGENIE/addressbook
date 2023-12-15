package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.AddressBookDto;

public class AddressBookDao {
	
	private static AddressBookDao abd = null;
	// Database와 통신, singleton

	public AddressBookDao() {
		// 기본생성자
	}
	
	public static AddressBookDao getInstance() {
		if(abd == null) {
			abd = new AddressBookDao();
		}
		return abd;
	}
	
	public boolean insert(AddressBookDto dto) {
		String sql = " insert into addressbook(name, age, phone, address, memo) "
				+ " values( '" + dto.getName() + "' ," + dto.getAge() + ", '" + dto.getPhone() + "' , '" + dto.getAddress() + "', '" + dto.getMemo() + "') ";
		
		Connection conn = null;
		Statement stmt = null;
		
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
			
			System.out.println("정상적 처리되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
		
		return count>0 ? true : false;
	}
	
	
	public boolean delete(String name) {
		String sql = " delete from addressbook "
				+ "where name = '" + name + "' ";
		
		Connection conn = null;
		Statement stmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
		
		return count>0 ? true : false;
	}
	
	public List<AddressBookDto> select(String word, int num) {
		String sql = " select * from addressbook where "; 
		
		switch (num) {
		case 3:
			sql += " name = '" + word + "' ";
			break;
		case 4:
			sql += " address like '%"+ word +"%';";
			break;
		case 5:
			sql += " memo like '%"+ word +"%';";
			break;
		}
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<AddressBookDto> list = new ArrayList<AddressBookDto>();
		
		try {
			
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String memo = rs.getString("memo");
				
				AddressBookDto dto = new AddressBookDto(name, age, phone, address, memo);
				
				list.add(dto);
			}
			
			System.out.println("정상적으로 처리되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public boolean update(String name, String phone) {
		String sql = "update addressbook"
				+ " set phone = '"+ phone +"'"
				+ " where name = '"+ name +"'";
		
		Connection conn = null;
		Statement stmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
		
		return count>0 ? true : false;
	}
	
	
}
