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
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	String bId=null;
	String vId=null;
	int bookStock=0;
			
			// Set refresh, autoload time as 5 seconds
		    //  response.setIntHeader("Refresh", 0);
		      Cookie[] cookies = request.getCookies();
		  		for(Cookie cookie : cookies)
		  		{
		  			if(cookie.getName().equals("vendorid"))
		  			{
		  				vId = cookie.getValue();
		  				System.out.println("vendor id:"+vId);
		  			}
		  			if(cookie.getName().equals("bookId"))
					{
						bId = cookie.getValue();
						System.out.println("book id:"+bId);
					}
		  		}
			
			PrintWriter out = response.getWriter();
			String us_id = request.getParameter("uid");
			String u_password = request.getParameter("upassword");
			System.out.println(us_id);
			System.out.println(u_password);
	
			int u_id = 0;
			if (us_id.isEmpty() || u_password.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("buyLogin.jsp");
				request.setAttribute("error", "<font face=\"Comic sans MS\" color=red>Please fill all the fields</font>");
				rd.include(request, response);
			}
			else
			{
				u_id = Integer.parseInt(us_id);
				try
				{
					System.out.println("entered buy.java");
					// 1. get a connection to database
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
							"root");
					// 2.create a statement allow to issue SQL queries to the database
					Statement mystmt = myConn.createStatement();
	
					// __________________________________________________________________________________________________
						// 3. execute sql query
						String query_getall = "select cpassword from `customer` where cid=" + u_id;
						System.out.println(query_getall);
						ResultSet myRs = mystmt.executeQuery(query_getall);
						// 4. process the result set
	
						//if wrong user id entered 
						if (!myRs.isBeforeFirst())
						{
							RequestDispatcher rd = request.getRequestDispatcher("buyLogin.jsp");
							request.setAttribute("error", "<font size=20 color=red>Please fill the correct User ID</font>");
							JOptionPane.showMessageDialog(null, "Wrong User ID Entered !!!!");
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
								System.out.println("password matched");
								
								String getall = "select * from `bookvendor` where vid="+vId+" and bookid="+bId;
								System.out.println(getall);
								ResultSet myRs1 = mystmt.executeQuery(getall);
								while(myRs1.next())
								{	
									bookStock=myRs1.getInt(3);
									System.out.println(bookStock);
									if(bookStock>=1)
									{
										String query1 = "INSERT INTO `corder` (`cid`, `vid`, `bookid`, `quantity`, `statusno`, `amount`) VALUES (?,?,?,?,?,?)";
										PreparedStatement ps = myConn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS); // generates
																																// sql query
										ps.setString(1, us_id);
										ps.setString(2, vId);
										ps.setString(3, bId);
										ps.setInt(4, 1);
										ps.setInt(5, 0);
										ps.setInt(6, myRs1.getInt(4));

										ps.executeUpdate(); // execute it on onlinestore database
										System.out.println("successfuly inserted in order");
										// response.sendRedirect("thank.jsp");

										ResultSet generatedKeys = ps.getGeneratedKeys();
										if (generatedKeys.next())
										{
											String key = generatedKeys.getString(1);
											System.out.println(key);
											RequestDispatcher rd = request.getRequestDispatcher("orderplace.jsp");
											request.setAttribute("id", "<font color=red size=20>Order ID is :" + key + "</font>");
											rd.include(request, response);
											rd.forward(request, response);
										}
										String query3 = "update bookvendor set stock=stock-"+1+" where bookid="+bId+" and vid="+vId;
										System.out.println(query3);
										PreparedStatement ps2 = myConn.prepareStatement(query3); 

										ps2.executeUpdate(); 
										System.out.println("successfuly updated bookstock in bookvendor");   
									}
									else
									{
										System.out.println("out of stock");
									}
									
								}
								myRs1.close();	
								
								
								
								
							} 
							else 
							{
								RequestDispatcher rd = request.getRequestDispatcher("buyLogin.jsp");
								request.setAttribute("error", "<font color=red>Please fill the correct Password</font>");
								
								JOptionPane.showMessageDialog(null, "Wrong password entered !! Please enter again.");
								rd.include(request, response);
							}
						}
					myRs.close();
					mystmt.close();
					myConn.close();
				} 
				catch (Exception exc)
				{
					exc.printStackTrace();
				}
		// TODO Auto-generated method stub
		//doGet(request, response);
			}
	}
}
