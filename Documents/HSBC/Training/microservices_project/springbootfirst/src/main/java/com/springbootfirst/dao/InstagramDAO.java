package com.springbootfirst.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springbootfirst.entity.InstagramUser;

@Repository
public class InstagramDAO implements InstagramDAOInterface {

	@Override
	public int createProfile(InstagramUser Ig) {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("insert into instagramuser values(?,?,?,?)");
		ps.setString(1, Ig.getName()); 
		ps.setString(2, Ig.getPwd()); 
		ps.setString(3,Ig.getEmailid()); 
		ps.setString(4, Ig.getAddress());
		
		int i=ps.executeUpdate(); 
		
		return i;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public InstagramUser viewProfile(InstagramUser Ig) {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name = ? and password=?");
		ps.setString(1, Ig.getName());
		ps.setString(2, Ig.getPwd());
		
		ResultSet rs = ps.executeQuery(); 
		
		InstagramUser I = new InstagramUser();
		if(!rs.wasNull()) {
			while(rs.next()) {
				I.setName(rs.getString("NAME"));
				I.setPwd(rs.getString("PASSWORD"));
				I.setEmailid(rs.getString("EMAIL"));
				I.setAddress(rs.getString("ADDRESS"));
			}

			return I;
		}
		else {
			return null;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<InstagramUser> viewAllProfile() {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("select * from instagramuser");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<InstagramUser> IgList = new ArrayList<InstagramUser>();
		
		while(rs.next()) {
			InstagramUser Ig = new InstagramUser();
			Ig.setName(rs.getString("NAME"));
			Ig.setPwd(rs.getString("PASSWORD"));
			Ig.setEmailid(rs.getString("EMAIL"));
			Ig.setAddress(rs.getString("ADDRESS"));
			
			IgList.add(Ig);
		}
		
		return IgList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<InstagramUser> searchProfile(InstagramUser Ig) {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name=?");
		ps.setString(1, Ig.getName());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<InstagramUser> IgList = new ArrayList<InstagramUser>();
		
		while(rs.next()) {
			InstagramUser I= new InstagramUser();
			I.setName(rs.getString("NAME"));
			I.setPwd(rs.getString("PASSWORD"));
			I.setEmailid(rs.getString("EMAIL"));
			I.setAddress(rs.getString("ADDRESS"));
			
			IgList.add(I);
		}
		
		return IgList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int deleteProfile(InstagramUser Ig) {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name = ? and password=?");
		ps.setString(1, Ig.getName());
		ps.setString(2, Ig.getPwd());
		
		int i=ps.executeUpdate(); 
		
		
		return i; 
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateProfile(InstagramUser Ig, InstagramUser up_I) {
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:/home/ashutosh/derby_data/testdbInsta;create=true","ashu","ashu");
		
		PreparedStatement ps=con.prepareStatement("update instagramuser set name =?, password = ?, email = ?, address = ? where name=? and password=?");
		ps.setString(1, up_I.getName());
		ps.setString(2, up_I.getPwd());
		ps.setString(3, up_I.getEmailid());
		ps.setString(4, up_I.getAddress());
		ps.setString(5, Ig.getName()); 
		ps.setString(6, Ig.getPwd()); 
		
		int i=ps.executeUpdate(); 
		
		
		return i; 
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
