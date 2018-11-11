package user;

import java.io.IOException;
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
 * Servlet implementation class Vremovestock
 */
@WebServlet("/Vremovestock")
public class Vremovestock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vremovestock() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entered remove stock section");
		response.setContentType("text/html");

		Cookie[] cookies = request.getCookies();

		String user_id = null;
		String b_id = null;
		String b_stock = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				user_id = cookie.getValue();
				System.out.println("id in vbook" + user_id);
			}
			if (cookie.getName().equals("bookid")) {
				b_id = cookie.getValue();
				System.out.println("id in vbook" + b_id);
			}
			if (cookie.getName().equals("bookstock")) {
				b_stock = cookie.getValue();
				System.out.println("id in stock" + b_stock);
			}
		}

		try {
			// 1. get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root", "root");
			Statement mystmt = myConn.createStatement();
			Statement mystmt1 = myConn.createStatement();

			String query_getall = "select * from `bookvendor` where vid=" + user_id + " and bookid=" + b_id;
			System.out.println(query_getall);
			ResultSet myRs = mystmt.executeQuery(query_getall);
			// 4. process the result set

			String query1 = "select booktitle from `book` where bookid=" + b_id;
			System.out.println(query1);
			ResultSet myRs1 = mystmt1.executeQuery(query1);
			while (myRs1.next()) {
				// int Id = myRs.getInt("id");
				String bookName = myRs1.getString("booktitle");
				System.out.println("book name in table: " + bookName);

				while (myRs.next()) {
					// int Id = myRs.getInt("id");
					String STOCK = myRs.getString("stock");
					System.out.println("stock in table" + STOCK);
					int S = Integer.parseInt(STOCK);
					int s = Integer.parseInt(b_stock);
					// if password matches the password in database
					if (S > s) {
						String query3 = "update bookvendor set stock=stock-" + b_stock + " where bookid=" + b_id
								+ " and vid=" + user_id;
						System.out.println(query3);
						PreparedStatement ps2 = myConn.prepareStatement(query3);

						ps2.executeUpdate();
						System.out.println("successfuly updated bookstock in bookvendor");
						RequestDispatcher rd = request.getRequestDispatcher("membervendor.jsp");
						rd.include(request, response);

						ps2.close();
					} else {
					//	JOptionPane.showMessageDialog(null,
						//		"<font size=5 color=red>There are less books existing in the stock, so you cannot remove this much books\n Please enter stock again </font>");
						RequestDispatcher rd = request.getRequestDispatcher("membervendor.jsp");
						 //request.setAttribute("error", "<font size=5 color=red>There are less books"
						 	//	+ " existing in the stock, so you cannot remove this much books\n Please enter"
						 		//+ "stock again </font>");
						// JOptionPane.showMessageDialog(null, "Wrong User ID Entered !!!!");
						response.getWriter().print(	"<script>alert(\"OOPS!! The stock entered is more than the existing...\");</script>");
						System.out.println("entered stock is greater than existing stock");
						rd.include(request, response);
					}
				}
			}

			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	// TODO Auto-generated method stub
	// doGet(request, response);
}
