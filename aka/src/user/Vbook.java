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
 * Servlet implementation class Vbook
 */
@WebServlet("/Vbook")
public class Vbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vbook() {
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
					System.out.println("In Vbook.java");
					String query1 = "select * from `bookvendor` where vid=" + user_id;
					System.out.println(query1);
					ResultSet myRs1 = mystmt.executeQuery(query1); 
					
					int count = 0;
				    myRs1.last();
			        count = myRs1.getRow();
			        myRs1.beforeFirst();
			        System.out.println("no.of bookid"+count);
			        int[] arr = new int[count];
			        while(myRs1.next())
			        {
			        	arr[count-1]=myRs1.getInt(2);
			        	count--;
			        	System.out.println(count);
			        }
			       // System.out.print(count);
			        
			        myRs1.close();
			        RequestDispatcher view=request.getRequestDispatcher("vbook.jsp");
					ResultSet myRs3 = null;
					String s = "";
					for(int i=0;i<arr.length;i++) 
					{		
						String query2="select b.bookid,b.booktitle,b.bookauthor,b.bookpublisher,b.bookpublishyr,b.bookgenre,bv.bookrate,bv.stock from `book` as `b`,`bookvendor` as `bv` where b.bookid=bv.bookid and bv.bookid="+arr[i]+" and bv.vid="+user_id;
				//		 String query2 = "select * from `book` where bookid="+arr[i];
						 System.out.println(query2);
						 myRs3 = mystmt.executeQuery(query2);
						 while (myRs3.next())
						 {	
							s = s+" <TR>"
									+"<TD>"+myRs3.getInt(1)+"</TD>"
									+"<TD>"+myRs3.getString(2)+"</TD>"
									+"<TD>"+myRs3.getString(3)+"</TD>"
									+"<TD>"+myRs3.getString(4)+"</TD>"
									+"<TD>"+myRs3.getInt(5)+"</TD>"
									+"<TD>"+myRs3.getString(6)+"</TD>"
									+"<TD>"+myRs3.getInt(7)+"</TD>"
									+"<TD>"+myRs3.getInt(8)+"</TD>"
											+createPopAdd(myRs3.getInt(1))
											+createPopRemove(myRs3.getInt(1))
											+createPopDelete(myRs3.getInt(1))
									//+"<TD><form action=\"Vaddstock\" method=post><button onclick=\"setCookie("+myRs3.getInt(1)+")\"  id=\"btn\">Add Stock</button></form></TD>"
									//+"<TD><form action=\"Vremovestock\" method=post><button onclick=\"setCookie("+myRs3.getInt(1)+")\"  id=\"btn\">Remove Stock</button></form></TD>"
									//+"<TD><form action=\"Vdeletebook\" method=post><button onclick=\"setCookie("+myRs3.getInt(1)+")\"  id=\"btn\">Remove Book</button></form></TD>"
									+"</TR>";
						 }
						 myRs3.close();
						
					}
					request.setAttribute("b8",s);
					 
					view.include(request, response);
					view.forward(request,response);
					
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


	private String createPopAdd(int i) {
		String s = "<TD><div id=\"pb"+i+"a\" class=\"abc\">" + 
				"<div id=\"abc\">"+
				"<form class=\"form\" action=\"Vaddstock\" id=\"form"+i+"a\" method=\"post\" name=\"form\">" + 
				"<h2>Add Stock</h2>" + 
				"<hr>" + 
				"<input id=\"name"+i+"a\" name=\"name\" class=\"number\" placeholder=\"StockValue\" type=\"number\"><br>" +  
				"<a href=\"javascript:%20check_empty("+i+",'a')\" id=\"submit\">Add Stock</a>" + 
				"<a href=\"javascript:%20div_hide("+i+",'a')\" id=\"cancel\">Cancel</a>" + 
				"</form></div>" + 
				"</div><button onclick=\"setCookie("+i+",'a')\"  id=\"btn\">Add Stock</button></TD>";
		return s;
	}
	
	private String createPopRemove(int i) {
		String s = "<TD><div id=\"pb"+i+"r\" class=\"abc\">" + 
				"<div id=\"abc\">"+ 
				"<form class=\"form\" action=\"Vremovestock\" id=\"form"+i+"r\" method=\"post\" name=\"form\">" + 
				"<h2>Remove Stock</h2>" + 
				"<hr>" + 
				"<input id=\"name"+i+"r\" name=\"name\" class=\"number\" placeholder=\"StockValue\" type=\"number\"><br>" +  
				"<a href=\"javascript:%20check_empty("+i+",'r')\" id=\"submit\">Remove Stock</a>" + 
				"<a href=\"javascript:%20div_hide("+i+",'r')\" id=\"cancel\">Cancel</a>" + 
				"</form></div>" + 
				"</div><button onclick=\"setCookie("+i+",'r')\"  id=\"btn\">Remove Stock</button></TD>";
		return s;
	}
	private String createPopDelete(int i) {
		String s = "<TD><div id=\"pb"+i+"d\" class=\"abc\">" + 
				"<div id=\"abc\">"+
				"<form class=\"form\" action=\"Vdeletebook\" id=\"form"+i+"d\" method=\"post\" name=\"form\">" + 
				"<h2>Remove Book</h2>" + 
				"<hr>" + 
				"<textarea id=\"msg\" name=\"message\" placeholder=\"Are You Sure You Want To Discontinue This Book?\">"
				+ "</textarea><input  value=\"10\" type=\"number\" id=\"name"+i+"d\" class=\"named\" disabled>" +  
				"<a href=\"javascript:%20check_empty("+i+",'d')\" id=\"submit\">Remove Book</a>" + 
				"<a href=\"javascript:%20div_hide("+i+",'d')\" id=\"cancel\">Cancel</a>" + 
				"</form></div>" + 
				"</div><button onclick=\"setCookie("+i+",'d')\"  id=\"btn\">Discontinue Book</button></TD>";
		return s;
	}


}
