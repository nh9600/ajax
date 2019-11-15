package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name="/TController",urlPatterns= {"/color/*"})
public class ColorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<String> strList = new ArrayList<>();

		strList.add("red");
		strList.add("orange");
		strList.add("yellow");
		strList.add("green");
		strList.add("blue");
		strList.add("pupple");
		strList.add("black");
		
		
		String id = request.getParameter("id");
		Gson g = new Gson();
		PrintWriter pw = response.getWriter();
		List<String> tmp = new ArrayList<>();
		if(id==null) {
			pw.print(g.toJson(strList)); 
		}else {	
			for(int i=0;i<strList.size();i++) {
				if(strList.get(i).indexOf(id)!=-1) {
					tmp.add(strList.get(i));
				}
			}
			pw.print(g.toJson(tmp));
		}	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
