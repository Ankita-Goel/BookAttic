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
 * Servlet implementation class OrderDetail
 */
@WebServlet("/OrderDetail")
public class OrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetail() {
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
		String oId=null;
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
				if(cookie.getName().equals("orderid"))
	  			{
	  				oId = cookie.getValue();
	  				System.out.println("order id:"+oId);
	  			}
			}
				System.out.println("entered vsales detail section");
				
				RequestDispatcher view=request.getRequestDispatcher("vsalesdetail.jsp");
				String query2 ="select o.orderid,c.cfirst_name,c.clast_name,c.cemail,c.cphone_no,c.caddress,c.cstate,c.ccountry,o.bookid,b.booktitle,b.bookauthor,b.bookpublisher,b.bookpublishyr,b.bookgenre,o.quantity,o.amount,s.statusname from  corder as o,book as b,status as s,customer as c where o.vid="+user_id+" and o.bookid=b.bookid and o.statusno=s.statusno and o.orderid="+oId+" and o.cid=c.cid";
				System.out.println(query2);
				String s = "";
				ResultSet myRs3 = mystmt.executeQuery(query2);
				while(myRs3.next())
				{
					request.setAttribute("b7", "ORDER ID:" + myRs3.getInt(1));
					s = "<h3>Customer Details Details</h3>"
							+ "<div><p>CUSTOMER NAME:" + myRs3.getString(2) + "&ensp;&ensp;" + myRs3.getString(3)
							+"<br>CUSTOMER EMAIL:" + myRs3.getString(4) 
							+ "<br>CUSTOMER PHONE NO.:"+ myRs3.getInt(5)
							+ "<br>CUSTOMER ADDRESS:" + myRs3.getString(6) + "&ensp;," + myRs3.getString(7)+ "&ensp;," + myRs3.getString(8) 
							+ "</p></div>"
							+"<h3>Book Details</h3>"
							+ "<div><p>BOOK ID:" + myRs3.getInt(9)+"<br>BOOK TITLE:" + myRs3.getString(10) + "<br>BOOK AUTHOR:"
							+ myRs3.getString(11) + "<br>BOOK PUBLISHER:" + myRs3.getString(12) + "<br>BOOK PUBLISH YEAR:"
							+ myRs3.getInt(13) + "<br>BOOK GENRE:" + myRs3.getString(14)
							+ "</p></div><h3>Financial Details</h3><div><p>QUANTITY:" + myRs3.getInt(15) + "<br>AMOUNT:"
							+ myRs3.getInt(16) + "</p></div><h3>STATUS</h3><div><p><font color=\"red\">"
							+ myRs3.getString(17) + "</font></p></div>";
						 
				}
				request.setAttribute("b8",s);	
					myRs3.close();
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
		//doGet(request, response);
	}

}
