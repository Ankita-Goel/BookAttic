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
 * Servlet implementation class Trackorder
 */
@WebServlet("/Trackorder")
public class Trackorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trackorder() {
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
			int bid=0;
			
			try 
			{	
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root","root");
				Statement mystmt = myConn.createStatement();
				Statement mystmt1 = myConn.createStatement();
				Cookie[] cookies = request.getCookies();
				
				for(Cookie cookie : cookies)
				{
					if(cookie.getName().equals("user"))
					{
						user_id = cookie.getValue();
						System.out.println(user_id);
					}
				}
				
					System.out.println("Entered track order section");
					String getall = "select * from `Corder` where cid=" +user_id+" and (statusno="+0+" or statusno="+1+")";
					System.out.println(getall);
					
					RequestDispatcher view=request.getRequestDispatcher("trackorder.jsp");
					ResultSet myRs1 = mystmt.executeQuery(getall);
					
					int count = 0;
				    myRs1.last();
			        count = myRs1.getRow();
			        myRs1.beforeFirst();
			        System.out.println("no.of orders:"+count);
			        int totalcount=count;
			        int[] arr = new int[count];
			        while(myRs1.next())
			        {
			        	arr[count-1]=myRs1.getInt(1);
			        	count--;
			        	System.out.println(count);
			        }
			       // System.out.print(count);
					myRs1.close();
					if(totalcount>=1)
					{
					ResultSet myRs3 = null;
						String s = "";
						String r = "";
						for(int i=0;i<arr.length;i++) 
						{	String query2 ="select o.orderid,o.bookid,b.booktitle from  corder as o,book as b where o.bookid=b.bookid and o.orderid="+arr[i]+" and o.cid="+user_id;
							 System.out.println(query2);
							 myRs3 = mystmt.executeQuery(query2);
							r= "<th>ORDER ID</th><th>BOOK ID</th><th>   </th>";
							 while(myRs3.next())
							 {
								 s = s+" <TR>"
											+"<TD>"+myRs3.getInt(1)+"</TD>"
													+"<TD>"+myRs3.getString(3)+"</TD>"
													+"<TD><form action=\"TrackorderDetail\" method=\"post\"><button onclick=\"orderCookie("+myRs3.getInt(1)+")\"  id=\"btn\">TRACK ORDER</button></form></TD>"
											+"</TR> ";
							 }
						}
						request.setAttribute("a1",r);
						request.setAttribute("b8",s);
					
						myRs3.close();
					}
					else
					{
						System.out.println("no order to track");
						request.setAttribute("error", "<font face=\"Comic sans MS\" color=red>NO ORDERS TO TRACK</font>");
					}
						mystmt.close();
						myConn.close();
						view.include(request, response);
						view.forward(request,response);  
					
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
