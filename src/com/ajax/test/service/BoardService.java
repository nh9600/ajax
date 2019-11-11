package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	Map<String,String> selectBoard(Map<String,String> board);
	List<Map<String,String>> selectBoardList(Map<String,String> board);
	Map<String,String> insertBoard(Map<String,String> board);
	Map<String,String> updateBoard(Map<String,String> board);
	Map<String,String> deleteBoard(Map<String,String> board);

	

}
