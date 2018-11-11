package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.sql.*;
/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object NULL = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
		
		PrintWriter out = response.getWriter();
		String us_id = request.getParameter("uid");
		String u_password = request.getParameter("upassword");
		String dbName = "customer";
		System.out.println(us_id);
		System.out.println(u_password);

		if(request.getParameter("category").equals("Vendor"))
		{
		dbName = "vendor";
		}
		int u_id = 0;
		if (us_id.isEmpty() || u_password.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "<font face=\"Comic sans MS\" color=red>Please fill all the fields</font>");
			rd.include(request, response);
			rd.forward(request,response);

		}
		else
		{	//response.setIntHeader("Refresh", 0);
			u_id = Integer.parseInt(us_id);
			try
			{
				// 1. get a connection to database
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
						"root");
				// 2.create a statement allow to issue SQL queries to the database
				Statement mystmt = myConn.createStatement();
				Statement mystmt1 = myConn.createStatement();

				// __________________________________________________________________________________________________
				if (request.getParameter("category").equals("Customer")) 
				{
					//Cookie type_cookie = new Cookie("type", "Customer");
					//response.addCookie(type_cookie);
					// 3. execute sql query
					String query_getall = "select cpassword from `customer` where cid=" + u_id;
					System.out.println(query_getall);
					ResultSet myRs = mystmt.executeQuery(query_getall);
					// 4. process the result set

					//if wrong user id entered 
					if (!myRs.isBeforeFirst())
					{
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						request.setAttribute("error", "<font size=20 color=red>Please fill the correct User ID</font>");
					//	JOptionPane.showMessageDialog(null, "Wrong User ID Entered !!!!");
						System.out.println("No data");
						rd.include(request, response);
					}
					while (myRs.next())
					{
						// int Id = myRs.getInt("id");
						String password1 = myRs.getString("cpassword");
						System.out.println("password in table" + password1);
						
						//if password matches the password in database
						if (password1.equals(u_password))
						{
							System.out.println(u_password+password1+"password matched");
							Cookie user_cookie = new Cookie("user",us_id);
							response.addCookie(user_cookie);
							//doGet(request, response);
							String getall = "select * from `customer` where cid=" + us_id;
							System.out.println(getall);
							ResultSet myRs1 = mystmt1.executeQuery(getall);
							while (myRs1.next()) {
								RequestDispatcher view = request.getRequestDispatcher("membercustomer.jsp");
								request.setAttribute("a2", myRs1.getString(2));
								Cookie username_cookie = new Cookie("name", myRs1.getString(2));
								response.addCookie(username_cookie);
								view.include(request, response);
								view.forward(request, response);
							}
							myRs1.close();	
						} 
						else 
						{
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							request.setAttribute("error", "<font color=red>Please fill the correct Password</font>");
							
						//	JOptionPane.showMessageDialog(null, "Wrong password entered !! Please enter again.");
							rd.include(request, response);
						}
					}
					myRs.close();
				} 
				else if (request.getParameter("category").equals("Vendor")) 
				{
					//Cookie type_cookie = new Cookie("type", "Vendor");
					//response.addCookie(type_cookie);
					// 3. execute sql query
					String query_getall = "select vpassword,vfirst_name from `vendor` where vid=" + u_id;
					System.out.println(query_getall);
					ResultSet myRs = mystmt.executeQuery(query_getall);
					// 4. process the result set

					//if wrong user id entered 
					if (!myRs.isBeforeFirst())
					{
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						request.setAttribute("error", "<font size=20 color=red>Please fill the correct User ID</font>");
						
					//	JOptionPane.showMessageDialog(null, "Wrong User ID Entered !!!!");
						System.out.println("No data");
						rd.include(request, response);
					}
					while (myRs.next())
					{
						// int Id = myRs.getInt("id");
						String password1 = myRs.getString("vpassword");
						System.out.println("password in table" + password1);
						
						//if password matches the password in database
						if (password1.equals(u_password))
						{
							System.out.println("password matched");
							Cookie user_cookie = new Cookie("user",us_id);
							response.addCookie(user_cookie);
							//Cookie username_cookie = new Cookie("name",myRs.getString("vfirst_name"));
							//System.out.println(username_cookie.getValue());
							//response.addCookie(username_cookie);
							//doGet(request, response);
							
							String getall = "select * from `vendor` where vid=" + us_id;
							System.out.println(getall);
							ResultSet myRs1 = mystmt1.executeQuery(getall);
							while (myRs1.next()) {	
							RequestDispatcher view = request.getRequestDispatcher("membervendor.jsp");
								 request.setAttribute("a2",myRs1.getString(2));

								view.include(request, response);
								view.forward(request, response);
							}
							myRs1.close();
						} 
						else 
						{
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							request.setAttribute("error", "<font color=red>Please fill the correct Password</font>");
							
						//	JOptionPane.showMessageDialog(null, "Wrong password entered !! Please enter again.");
							rd.include(request, response);
						}
					}
					myRs.close();
				}
				mystmt.close();
				myConn.close();
			} 
			catch (Exception exc)
			{
				exc.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
	}

}
