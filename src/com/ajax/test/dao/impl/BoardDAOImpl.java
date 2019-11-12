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
import com.ajax.test.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from board_info where bi_num=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("biContent", rs.getString("bi_content"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("cretim", rs.getString("cretim"));
				b.put("credat", rs.getString("credat"));
				b.put("moddat", rs.getString("moddat"));
				b.put("modtim", rs.getString("modtim"));
				b.put("active", rs.getString("active"));
				return b;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {//순서대로 나오게 하기 위해 list? 
		Connection con = null;//String은 자바가 알아서 null을 넣어주지만 정해지지 않은 다른 데이터타입은 자바가 모르니까 우리가 넣어줘야함 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from board_info order by bi_num desc";//
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, String>> boardList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				boardList.add(b);
			}
			return boardList;
		} catch (SQLException e) {

		} finally {

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

	@Override
	public int insertBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "insert into board_info(bi_num,bi_title,bi_content,ui_num,credat,cretim,moddat,modtim)";
			sql += "values(seq_bi_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'))";
			ps=con.prepareStatement(sql);
			ps.setString(1,board.get("biTitle"));
			ps.setString(2,board.get("biContent"));
			ps.setString(3,board.get("uiNum"));
			return ps.executeUpdate();
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
		return 0;
	}

	

	@Override
	public int updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "delete from board_info where bi_num=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1,board.get("biNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[]args) {
		BoardDAO bdao = new BoardDAOImpl();
		System.out.println(bdao.selectBoardList(null));
	}

}
