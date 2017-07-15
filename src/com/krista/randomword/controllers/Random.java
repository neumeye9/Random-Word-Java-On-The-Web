package com.krista.randomword.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session1 = request.getSession();
		String counter = (String) session1.getAttribute("counter");
		Integer number = 0;
		
		if(counter != null){
			number = Integer.parseInt(counter);
			number += 1;
			counter = number.toString();
			session1.setAttribute("counter",counter);
		}
		else{
			session1.setAttribute("counter","0");
		}
		
		
		HttpSession session2 = request.getSession();
		
		String[] letters = {"A","B","C","D","E","F","G",
		        "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9"};
		
		Collections.shuffle(Arrays.asList(letters));
		ArrayList<String> newArray = new ArrayList<>();
		
		for(int i = 0; i < 11; i++){
			newArray.add(letters[i]); 
		}
		
		session2.setAttribute("word", newArray);
	
		HttpSession session3 = request.getSession();
		String current = "";
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, y - HH:mm a");
		current = dateFormat.format(date).toString();
		
		session3.setAttribute("current", current);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/random.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
