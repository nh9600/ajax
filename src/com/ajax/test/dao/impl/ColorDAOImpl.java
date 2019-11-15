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
import com.ajax.test.dao.ColorDAO;

public class ColorDAOImpl implements ColorDAO {

	@Override
	public List<Map<String, String>> selectColorList(Map<String, String> color) {
		Connection con = null; 
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql="select * from color order by c_num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String,String>> colorList = new ArrayList<>();
			while (rs.next()) {
				Map<String,String> c = new HashMap<>();
				c.put("cNum", rs.getString("c_num"));
				c.put("cName", rs.getString("c_name"));
				colorList.add(c);
			}
			return colorList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ColorDAO sc = new ColorDAOImpl();
		System.out.println(sc.selectColorList(null));
		
	}

}
