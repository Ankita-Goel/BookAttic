package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Vaddstock
 */
@WebServlet("/Vaddstock")
public class Vaddstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vaddstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered add stock section");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();

		String user_id=null;
		String b_id=null;
		String b_stock=null;
	
		for (Cookie cookie : cookies) 
		{
			if (cookie.getName().equals("user")) {
				user_id = cookie.getValue();
				System.out.println("id in vbook" + user_id);
			}
			if(cookie.getName().equals("bookid"))
			{
				b_id = cookie.getValue();
				System.out.println("id in vbook"+b_id);
			}
			if(cookie.getName().equals("bookstock"))
			{
				b_stock = cookie.getValue();
				System.out.println("id in stock"+b_stock);
			}
		}
			try {
				// 1. get a connection to database
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
						"root");
				Statement mystmt = myConn.createStatement();
				
				String query_getall = "select * from `bookvendor` where vid=" +user_id+" and bookid="+b_id;
				System.out.println(query_getall);
				ResultSet myRs = mystmt.executeQuery(query_getall);
				// 4. process the result set
				
				String query1= "select booktitle from `book` where bookid="+b_id;
				System.out.println(query1);
				ResultSet myRs1= mystmt.executeQuery(query1);
				while (myRs1.next())
				{
					// int Id = myRs.getInt("id");
					String bookName = myRs1.getString("booktitle");
					System.out.println("Book name in table: " + bookName);
					
					
				//	String b_stock = JOptionPane.showInputDialog("Enter stock for "+bookName);
						String query3 = "update bookvendor set stock=stock+"+b_stock+" where bookid="+b_id+" and vid="+user_id;
						System.out.println(query3);
						PreparedStatement ps2 = myConn.prepareStatement(query3); 

						ps2.executeUpdate(); 
						System.out.println("successfuly updated bookstock in bookvendor");   
						RequestDispatcher rd = request.getRequestDispatcher("membervendor.jsp");
						rd.include(request, response);

						ps2.close();
					} 
				myConn.close();
			} 
			catch (Exception exc) 
			{
				exc.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

