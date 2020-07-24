import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class uservieworders extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");

pw.println("<h2 align='right'>Welcome Customer,&nbsp;&nbsp;&nbsp;&nbsp;<a href='customerhome.html'>Back</a></h4>");
pw.println("<br><br>");

pw.println("<table align='center' style='font-size:16px;' border=2 width=100% height=50%>");
pw.println("<tr><th colspan=9><h3 style='font-size:15px;'>Customer Orders</h3></th></tr>");
pw.println("<tr><th>Order Id</th><th>Name</th>");
pw.println("<th>Model</th><th>Price</th>");
pw.println("<th>Number Of Products </th>");
pw.println("<th>Total Price</th>");
pw.println("<th>Card Number</th>");
pw.println("<th>Date</th></tr>");
HttpSession hs=request.getSession();
String user=(String)hs.getAttribute("UserName");
  PreparedStatement pst=con.prepareStatement("select * from orders where username=?");
  pst.setString(1,user);
  ResultSet rs=pst.executeQuery();
  while(rs.next())
  {
pw.println("<tr><th>"+rs.getString(1)+"</th>");
pw.println("<th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</th><th>"+rs.getString(6)+"</th><th>"+rs.getString(7)+"</th><th>"+rs.getString(8)+"</th><th>"+rs.getString(9)+"</th><th>"+rs.getString(11)+"</th></tr>");
  }

pw.println("</table>");
  
	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


