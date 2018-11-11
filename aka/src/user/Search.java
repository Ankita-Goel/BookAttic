package user;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		
		
		String name = request.getParameter("search");
		System.out.println(name);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root","root");
			Statement mystmt = myConn.createStatement();
			ResultSet rs = null;
			if (name != null && name.length() > 0) 
			{	
				String Name = "\"" + name + "\"";    
			    String query_getall = "SELECT * FROM `book` WHERE booktitle="+Name;
				System.out.println(query_getall);
				ResultSet myRs = mystmt.executeQuery(query_getall);
				//4. process the result set
				while (myRs.next()) 
				{
					String Id = myRs.getString("bookid");
					System.out.println(Id);
					Cookie user_cookie = new Cookie("bookId",Id);
					response.addCookie(user_cookie);
					RequestDispatcher view=request.getRequestDispatcher("display.jsp");
					view.include(request, response);
	    			view.forward(request,response);
				}    
			}
			myConn.close();
			mystmt.close();
			rs.close();
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
