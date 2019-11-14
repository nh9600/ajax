package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressSerivice;
import com.ajax.test.service.impl.AddressServiceImpl;
import com.google.gson.Gson;

@WebServlet(name="/TestController",urlPatterns= {"/test/*"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressSerivice as = new AddressServiceImpl();
    private Gson g = new Gson(); //이것을 통해서 바꿔줌 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();//응답객체에서 writer받아와서 
		String json = "";
		json = g.toJson(as.selectSidoList(null));//이 객체를 toJson형태로 
		pw.print(json);//찍어줌
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
