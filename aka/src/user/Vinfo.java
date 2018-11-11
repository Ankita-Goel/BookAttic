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

/**
 * Servlet implementation class Vinfo
 */
@WebServlet("/Vinfo")
public class Vinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vinfo() {
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
		
		String user_id=null;
		//   String user_id = null;
			int flag=0;
			try 
			{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
						"root");
				Statement mystmt = myConn.createStatement();
				Cookie[] cookies = request.getCookies();
				
				for(Cookie cookie : cookies)
				{
					if(cookie.getName().equals("user"))
					{
						user_id = cookie.getValue();
						System.out.println(user_id);
					}
				}
					String getall = "select * from `vendor` where vid=" + user_id;
					System.out.println(getall);
					RequestDispatcher view=request.getRequestDispatcher("vinfo.jsp");
					ResultSet myRs2 = mystmt.executeQuery(getall);
					while (myRs2.next())
					{
						 request.setAttribute("a1",myRs2.getInt(1));
						 request.setAttribute("a2",myRs2.getString(2));
						 request.setAttribute("a3",myRs2.getString(3));
						 request.setAttribute("a4",myRs2.getString(4));
						 request.setAttribute("a5",myRs2.getString(5));
						 request.setAttribute("a6",myRs2.getInt(6));
						 request.setAttribute("a7",myRs2.getString(7));
						 request.setAttribute("a8",myRs2.getString(8));
						 request.setAttribute("a9",myRs2.getString(9));
						
			    		view.include(request, response);
					}
					myRs2.close();
					mystmt.close();
					myConn.close();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
