import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class sendreqtid extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  HttpSession hs=request.getSession();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");
pw.println("<h2 class='text-white text-uppercase' style='float:right;'>Welcome "+ hs.getAttribute("UserName") +"&nbsp;&nbsp;&nbsp;&nbsp;<a href='customerhome.html'>Back</a></h4>");
pw.println("<br><br>");
pw.println("<table align=center style='font-size:20px;' width=40%>");
pw.println("<form action='sendreq1' method='post'>");
String user=(String)hs.getAttribute("UserName");
String tid=request.getParameter("tid");

pw.println("<tr><th colspan=2>Enter Product Details</th></tr>	");
pw.println("<tr><th>ProductId</th><th><input type='text' name='tid' value="+tid+"></th></tr>");
pw.println("<tr><th>Number of Products</th><th><input type='number' name='nproducts'  required /></th></tr>");
pw.println("<tr><th><input type='submit' value='Proceed To Payment' /></th>");
pw.println("<th><input type='reset' value='reset' /></th></tr>");
pw.println("</form></table>");

	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


