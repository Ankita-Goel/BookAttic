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

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id=null; 
		String	bId=null; 
		Cookie[] cookies = request.getCookies();
	//	String b_id = request.getParameter("book_id");
		//Cookie type_cookie = new Cookie("book",b_id);
		//response.addCookie(type_cookie);
		String name = request.getParameter("search");
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("bookId"))
			{
				bId = cookie.getValue();
				System.out.println("book id:"+bId);
			}
		}
		try
		{
				System.out.println("Entered display section");
				Class.forName("com.mysql.jdbc.Driver");

				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlinestore", "root",
				"root");
				Statement mystmt = myConn.createStatement();
				//String query1 = "select * from `bookvendor` where bookid="+b_id+" and vid="+user_id;
			//	System.out.println(query1);
			//	ResultSet myRs1 = mystmt.executeQuery(query1); 
				
				
				
				String Name = "\"" + name + "\"";  
				String query_getall = "SELECT * FROM `book` WHERE booktitle="+Name;
				System.out.println(query_getall);
				ResultSet myRs = mystmt.executeQuery(query_getall);
				//4. process the result set
				while (myRs.next()) 
				{
					bId = myRs.getString("bookid");
					System.out.println(bId);
				}   
				
				RequestDispatcher view=request.getRequestDispatcher("display.jsp");
				String query2 = "select * from `book` where bookid="+bId;
				 System.out.println(query2);
				ResultSet myRs3 = mystmt.executeQuery(query2);
	
				while (myRs3.next())
				{		
					 request.setAttribute("a1",myRs3.getInt(1));
					 request.setAttribute("a2",myRs3.getString(2));
					 request.setAttribute("a3",myRs3.getString(3));
					 request.setAttribute("a4",myRs3.getString(4));
					 request.setAttribute("a5",myRs3.getInt(5));
					 request.setAttribute("a6",myRs3.getString(6));
		    		view.include(request, response);
				}
				
				String query1 = "select * from `bookvendor` where bookid=" + bId;
				System.out.println(query1);
				ResultSet myRs1 = mystmt.executeQuery(query1); 
				
				int count = 0;
			    myRs1.last();
		        count = myRs1.getRow();
		        myRs1.beforeFirst();
		        if(count>0)
		        {
		        System.out.println("vendor id: "+count);
		        int[] arr = new int[count];
		        while(myRs1.next())
		        {
		        	arr[count-1]=myRs1.getInt(1);
		        	count--;
		        	System.out.println(count);
		        }
		       // System.out.print(count);
		        ResultSet myRs4=null;
		        
				String s = "<p><u>Steal the Deal</u></p><br><table class=\"vdetail\">";
				
				for(int i=0;i<arr.length;i++) 
				{		
					String query3="select bv.vid,v.vfirst_name,bv.bookrate,bv.stock from `vendor` as `v`,`bookvendor` as `bv` where bv.vid=v.vid and bv.bookid="+bId+" and bv.vid="+arr[i];
			//		 String query2 = "select * from `book` where bookid="+arr[i];
					 System.out.println(query3);
					 myRs4 = mystmt.executeQuery(query3);
					 int counts = 0;
					    myRs4.last();
				        counts = myRs4.getRow();
				        myRs4.beforeFirst();
				        System.out.println("no.of bookid"+counts);
					 while (myRs4.next())
					 {	String vName=myRs4.getString(2);
					 	int vPrice=myRs4.getInt(3);
					 	int vStock=myRs4.getInt(4);
						s +=	"<tr>"	
								+"<td>Vendor Name: "+vName+"&ensp;&ensp;&ensp;"
								+"Price:"+vPrice+"&ensp;&ensp;&ensp;"
								+"Stock:"+vStock+"&ensp;&ensp;&ensp;</td>"
								+"<td><button onclick=\"vendorCookie("+myRs4.getInt(1)+")\"  id=\"btn\">BUY NOW</button></td>"
								+"</tr>";
						System.out.println(s);
					 }
					 myRs4.close();
					
				}
				s+="</table>";
				request.setAttribute("b8",s);
		        }
		        else
		        {
					request.setAttribute("b8","<p><u>Sorry no deals available at the moment</u></p><br>");

		        }
				view.include(request, response);
				view.forward(request,response);
		        	
	//		view.include(request, response);
		//	view.forward(request,response);
			 myRs3.close();
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
