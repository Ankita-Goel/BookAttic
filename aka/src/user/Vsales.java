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
 * Servlet implementation class Vsales
 */
@WebServlet("/Vsales")
public class Vsales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vsales() {
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
	
		String user_id=null;
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
					System.out.println("id in vbook"+user_id);
				}
			}
				System.out.println("In Vsales.java");
				String query1 = "select * from `Corder` where vid="+user_id;
				System.out.println(query1);
				ResultSet myRs1 = mystmt.executeQuery(query1); 
				
				int count = 0;
			    myRs1.last();
		        count = myRs1.getRow();
		        myRs1.beforeFirst();
		        if(count>=1)
		        {
			        System.out.println("no.of orders:"+count);
			        int[] arr = new int[count];
			        while(myRs1.next())
			        {
			        	arr[count-1]=myRs1.getInt(1);
			        	count--;
			        	System.out.println(count);
			        }
			       // System.out.print(count);
			        
			        myRs1.close();
			        RequestDispatcher view=request.getRequestDispatcher("vsales.jsp");
					ResultSet myRs3 = null;
					String s = "";
					String r = "";

					for(int i=0;i<arr.length;i++) 
					{		
						String query2 ="select o.orderid,o.bookid,b.booktitle from  corder as o,book as b where o.bookid=b.bookid and o.orderid="+arr[i]+" and o.vid="+user_id;
						 System.out.println(query2);
						 myRs3 = mystmt.executeQuery(query2);
						 r="	<th>ORDER ID</th>\r\n" + 
						 		"				<TH>BOOK TITLE</TH> ";
						 while(myRs3.next())
						 {
							 s = s+" <TR>"
										+"<TD>"+myRs3.getInt(1)+"</td>"
												+"<td>"+myRs3.getString(3)+"</td>"
												+"<td><form action=\"OrderDetail\" method=\"post\"><button onclick=\"orderCookie("+myRs3.getInt(1)+")\"  id=\"btn\">ORDER DETAIL</button></form></TD>"
										+"</TR>";
						 }
						 myRs3.close();
					}
					request.setAttribute("a1",r);
					request.setAttribute("b8",s);
			       
					view.include(request, response);
					view.forward(request,response);
		        }
		        else
		        {
		        	 RequestDispatcher view=request.getRequestDispatcher("vsales.jsp");
		        	System.out.println("no sales");
					request.setAttribute("error", "<font face=\"Comic sans MS\" color=red>NO sales</font>");
					view.include(request, response);
					view.forward(request,response);
		        }
		        
				mystmt.close();
				myConn.close();
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
