package com.ajax.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[]args) {
		
		List<String> strList = new ArrayList<>();
		strList.add("가나다");
		strList.add("나다");
		strList.add("가다");
		strList.add("오라");
		
		String searchStr = "가";
		
		for(int i=0;i<strList.size();i++) {
			if(strList.get(i).indexOf(searchStr)==-1) {
				strList.remove(i);
			}
		}
		System.out.println(strList);

		/*
		 * int idx = strList.indexOf("c"); 
		 * strList.remove(idx);//삭제
		 * System.out.println(strList);
		 */
	}

}
