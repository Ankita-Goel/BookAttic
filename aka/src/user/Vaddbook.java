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
 * Servlet implementation class Vaddbook
 */
@WebServlet("/Vaddbook")
public class Vaddbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vaddbook() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = null;
		String key = null;
		String key_id = null;
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				user_id = cookie.getValue();
				System.out.println("id in vbook" + user_id);
			}
		}

		
		System.out.println("Entered add book section");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String b_title = request.getParameter("book_title");
		String b_author = request.getParameter("book_author");
		String b_publisher = request.getParameter("book_publisher");
		String b_publishyr = request.getParameter("book_publishyr");
		String b_genre = request.getParameter("book_genre");
		String b_rate = request.getParameter("book_rate");
		String b_stock = request.getParameter("stock");

		// validate given input
		if (b_title.isEmpty() || b_author.isEmpty() || b_publisher.isEmpty() || b_publishyr.isEmpty()
				|| b_genre.isEmpty() || b_rate.isEmpty() || b_stock.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("vaddbook.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		} else {
			try {
				// 1. get a connection to database
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
						"root");
				// 2.create a statement allow to issue SQL queries to the database
				Statement mystmt = myConn.createStatement();
				// 3. execute sql query
				boolean recordAdded = false;
				String b_author1 = "\"" + b_author + "\"";
				String b_title1 = "\"" + b_title + "\"";
				String b_publisher1 = "\"" + b_publisher + "\"";
				String b_genre1 = "\"" + b_genre + "\"";

				String query2 = "select * from `book` where `booktitle`=" + b_title1 + " and `bookauthor`=" + b_author1
						+ " and `bookpublisher`=" + b_publisher1 + " and `bookpublishyr`=" + b_publishyr
						+ " and `bookgenre`=" + b_genre1 ;
				
				System.out.println(query2);
				ResultSet rs = mystmt.executeQuery(query2);

				int count = 0;
				rs.last();
				count = rs.getRow();
				rs.beforeFirst();
				System.out.println("no.of book" + count);
				if (count <= 0) 
				{
					/// Do your insertion of new records
					String query = "INSERT INTO `book` (`booktitle`, `bookauthor`, `bookpublisher`, `bookpublishyr`, `bookgenre`) VALUES (?,?,?,?,?)";
					PreparedStatement ps = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // generates
																											// sql query
					ps.setString(1, b_title);
					ps.setString(2, b_author);
					ps.setString(3, b_publisher);
					ps.setString(4, b_publishyr);
					ps.setString(5, b_genre);

					ps.executeUpdate(); // execute it on onlinestore database
					System.out.println("successfuly inserted in book");
					// response.sendRedirect("thank.jsp");

					ResultSet generatedKeys = ps.getGeneratedKeys();
					if (generatedKeys.next())
					{
						key = generatedKeys.getString(1);
						System.out.println(key);
						RequestDispatcher rd = request.getRequestDispatcher("addbookconfirmation.jsp");
						request.setAttribute("id", "<font color=red>Book ID is :" + key + "</font>");
						rd.include(request, response);
						rd.forward(request, response);
					}

					String query1 = "INSERT INTO `bookvendor` (`vid`, `bookid`,`stock`,`bookrate`) VALUES (?,?,?,?);";
					PreparedStatement ps1 = myConn.prepareStatement(query1); // generates sql query

					ps1.setString(1, user_id);
					ps1.setString(2, key);
					ps1.setString(3, b_stock);
					ps1.setString(4, b_rate);
					

					ps1.executeUpdate(); // execute it on onlinestore database
					System.out.println("successfuly inserted in bookvendor");

				/*	String query3 = "update book as t1 set  t1.bookstock= (select * from (select sum(bv.stock) as stock from book as b,bookvendor as bv where b.bookid=bv.bookid and b.bookid="
							+ key + ") as t) where t1.bookid=" + key;
					System.out.println(query3);
					PreparedStatement ps2 = myConn.prepareStatement(query3); // generates sql query

					ps2.executeUpdate(); // execute it on onlinestore database
					// execute it on onlinestore database
					System.out.println("successfuly updated bookstock in book");    */

					recordAdded = true;

					ps1.close();
					ps.close();
				}
				if (recordAdded) 
				{
					JOptionPane.showMessageDialog(null, "Record added");
				}
				else 
				{

					String bid = null;
					while (rs.next()) 
					{
						bid = rs.getString(1);
						System.out.printf("book id:" + bid);
					}
				
					String query4 = "select * from `bookvendor` where `bookid`=" +bid + " and `vid`=" +user_id;
					System.out.println(query4);
					ResultSet rs4 = mystmt.executeQuery(query4);

					int count4 = 0;
					rs4.last();
					count4 = rs4.getRow();
					rs4.beforeFirst();
					System.out.println("no.of vendor:"+ count4);
					
					if (count4<=0)
					{
						String query1 = "INSERT INTO `bookvendor` (`vid`, `bookid`,`stock`,`bookrate`) VALUES (?,?,?,?);";
						PreparedStatement ps1 = myConn.prepareStatement(query1); // generates sql query

						ps1.setString(1, user_id);
						ps1.setString(2, bid);
						ps1.setString(3, b_stock);
						ps1.setString(4, b_rate);

						ps1.executeUpdate(); // execute it on onlinestore database
						System.out.println("\nsuccessfuly inserted in bookvendor");
					}
					else
					{
						String query3 = "update bookvendor set stock=stock+"+b_stock+" where bookid="+bid+" and vid="+user_id;
						System.out.println(query3);
						PreparedStatement ps2 = myConn.prepareStatement(query3); // generates sql query

						ps2.executeUpdate(); // execute it on onlinestore database
						// execute it on onlinestore database
						System.out.println("successfuly updated bookstock in bookvendor");    

					}
					JOptionPane.showMessageDialog(null, "Book has been successfully added.");
					RequestDispatcher view = request.getRequestDispatcher("membervendor.jsp");
					System.out.println("already exists");
					rs4.close();
					view.include(request, response);
				}
				rs.close();
				myConn.close();
			}
			catch (Exception exc) 
			{
				exc.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		// doGet(request, response);
	}
}
