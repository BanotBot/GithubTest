package com.besere;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * doPost() - will only works for post
 * doGet() - will only works for get
*/

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet
{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		try {
			
			int i = Integer.parseInt(req.getParameter("num1"));
			int j = Integer.parseInt(req.getParameter("num2"));

		    int addResult = i + j;
			 int minusResult = i - j;
			 
			  
			/*
			 * PrintWriter display = res.getWriter();
			 * req.setAttribute("addResult", addResult);
			 * RequestDispatcher rq = req.getRequestDispatcher("sq"); rq.forward(req,res);
		     */
		    
		    System.out.println("Num1 " + i);
		    System.out.println("Num2 " + j);
			 System.out.println("Minus Result => " + minusResult);
		    
			//res.sendRedirect("sq?addResult=" + addResult); // SESSION MANAGEMENT where you can transfer data from another to another  
			
			/*
			 * //Using Session Management HttpSession session = req.getSession();
			 * session.setAttribute("addResult", addResult); res.sendRedirect("sq");
			 */
		    
		    Cookie cookie = new Cookie("addResult", addResult + "");
		    res.addCookie(cookie);
		    
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	 * IOException { try { int i = Integer.parseInt(req.getParameter("num1")); int j
	 * = Integer.parseInt(req.getParameter("num2"));
	 * 
	 * int addResult = i + j; PrintWriter display = res.getWriter();
	 * display.println("Result is : " + addResult); } catch (NumberFormatException
	 * e) { e.printStackTrace(); } }
	 */
	
}
