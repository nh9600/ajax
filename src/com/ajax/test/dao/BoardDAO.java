package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	Map<String,String> selectBoard(Map<String,String> board);
	List<Map<String,String>> selectBoardList(Map<String,String> board);
	int insertBoard(Map<String,String> board);
	int updateBoard(Map<String,String> board);
	int deleteBoard(Map<String,String> board);

}
