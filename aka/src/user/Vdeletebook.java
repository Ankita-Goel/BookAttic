package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class vdeletebook
 */
@WebServlet("/Vdeletebook")
public class Vdeletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vdeletebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete section entered");
		String user_id=null;
		String Book_id=null;
		Cookie[] cookies = request.getCookies();

		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("user"))
			{
				user_id = cookie.getValue();
				System.out.println("id in Vdeletebook"+user_id);
			}
			if(cookie.getName().equals("bookid"))
			{
				Book_id = cookie.getValue();
				System.out.println("id in vbook"+Book_id);
			}
		}
		try
		{
				System.out.println("Entered delete book section");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
				"root");
				Statement mystmt = myConn.createStatement();
				
				
					
					mystmt.executeUpdate("DELETE FROM `bookvendor` WHERE bookid="+Book_id+" AND vid="+user_id);
					System.out.println("Data Deleted Successfully!");
					System.out.println("Yes button clicked");
					RequestDispatcher view=request.getRequestDispatcher("membervendor.jsp");
					view.include(request, response);
					 view.forward(request,response);
				mystmt.close();
				myConn.close();
		}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
