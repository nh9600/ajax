package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.common.DBCon;
import com.ajax.test.dao.AddressDAO;

public class AddressDAOImpl implements AddressDAO {

	@Override
	public List<Map<String, String>> selectSidoList(Map<String, String> sido) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sido";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String,String>> sidoList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> map = new HashMap<>();
				map.put("sNum",rs.getString("s_num"));
				map.put("sName",rs.getString("s_name"));
				sidoList.add(map);//리스트에 추가해주고 
			}
			return sidoList;//리스트를 리턴시킴
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return null;
	}

	@Override
	public Map<String, String> selectSido(Map<String, String> sido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[]args) {
		AddressDAO adao = new AddressDAOImpl();
		System.out.println(adao.selectSidoList(null));
	}

}
