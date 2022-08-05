package com.webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBHandler;
import com.webservice.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean addCustomer(Customer c) {
		boolean result = false;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBHandler.getConnection();
			String query = "insert into customer(customerName,email) values(?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getEmail());

			int rows = ps.executeUpdate();
			// System.out.println(rows + "row inserted");
			result = true;
			// conn.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;

	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<>();
		Customer s = null;
		Connection conn = null;
		try {
			conn = DBHandler.getConnection();
			String query = "select * from customer";
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Customer();
				s.setCustomerId(rs.getInt("id"));
				s.setCustomerName(rs.getString("customerName"));
				s.setEmail(rs.getString("email"));

				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		boolean result=false;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBHandler.getConnection();
			String query = "update customer set email=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getEmail());
			ps.setInt(2, c.getCustomerId());
			int res = ps.executeUpdate();
		result=true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
