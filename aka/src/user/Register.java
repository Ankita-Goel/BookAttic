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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String u_fname = request.getParameter("first_name");
		String u_lname = request.getParameter("last_name");
		String u_email = request.getParameter("email");
		String u_password = request.getParameter("password");
		String u_phoneno = request.getParameter("phoneno");
		String u_address = request.getParameter("address");
		String u_state = request.getParameter("state");
		String u_country = request.getParameter("country");
		String u_category = request.getParameter("category");
		
		// validate given input
		if (u_fname.isEmpty() || u_lname.isEmpty() || u_email.isEmpty() || u_password.isEmpty() || u_phoneno.isEmpty()
				|| u_address.isEmpty() || u_state.isEmpty() || u_country.isEmpty() || u_category.isEmpty() ) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			request.setAttribute("error", "<font color=red>Please fill all the fields</font>");

			//out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		} 
		else
		{	
			
			try {
				
				if(request.getParameter("category").equals("Vendor")) 
				{
				// 1. get a connection to database
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
						"root");
				// 2.create a statement allow to issue SQL queries to the database
				Statement mystmt = myConn.createStatement();
				// 3. execute sql query
				String query = "INSERT INTO `vendor` (`vfirst_name`, `vlast_name`, `vemail`, `vpassword`, `vphone_no`, `vaddress`, `vstate`, `vcountry`) VALUES (?,?,?,?,?,?,?,?);";
				PreparedStatement ps = myConn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); // generates sql query

				ps.setString(1, u_fname);
				ps.setString(2, u_lname);
				ps.setString(3, u_email);
				ps.setString(4, u_password);
				ps.setString(5, u_phoneno);
				ps.setString(6, u_address);
				ps.setString(7, u_state);
				ps.setString(8, u_country);

				ps.executeUpdate(); // execute it on onlinestore database
				System.out.println("successfuly inserted");
			//	response.sendRedirect("thank.jsp");
				ResultSet generatedKeys = ps.getGeneratedKeys();
		            if (generatedKeys.next()) {
		            	long key = generatedKeys.getLong(1);
		                System.out.println(key);
		                RequestDispatcher rd = request.getRequestDispatcher("thank.jsp");
		                request.setAttribute("id", "<font color=red>Your Vendor ID is :"+key+"</font>");
		    			rd.include(request, response);
		            }
		         
				ps.close();
				myConn.close();
				}
				else if(request.getParameter("category").equals("Customer"))
				{
					// 1. get a connection to database
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
							"root");
					// 2.create a statement allow to issue SQL queries to the database
					Statement mystmt = myConn.createStatement();
					// 3. execute sql query
					String query = "INSERT INTO `customer` (`cfirst_name`, `clast_name`, `cemail`, `cpassword`, `cphone_no`, `caddress`, `cstate`, `ccountry`) VALUES (?,?,?,?,?,?,?,?);";
					PreparedStatement ps = myConn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); // generates sql query

					ps.setString(1, u_fname);
					ps.setString(2, u_lname);
					ps.setString(3, u_email);
					ps.setString(4, u_password);
					ps.setString(5, u_phoneno);
					ps.setString(6, u_address);
					ps.setString(7, u_state);
					ps.setString(8, u_country);

					ps.executeUpdate(); // execute it on onlinestore database
					System.out.println("successfuly inserted");
				//	response.sendRedirect("thank.jsp");
					ResultSet generatedKeys = ps.getGeneratedKeys();
			            if (generatedKeys.next()) {
			            	long key = generatedKeys.getLong(1);
			                System.out.println(key);
			                RequestDispatcher rd = request.getRequestDispatcher("thank.jsp");
			                request.setAttribute("id", "<font color=red>Your Customer ID is :"+key+"</font>");
			    			rd.include(request, response);
			            }
			         
					ps.close();
					myConn.close();
				}

			} 
			catch (Exception exc)
			{
				exc.printStackTrace();
			}

		}
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
