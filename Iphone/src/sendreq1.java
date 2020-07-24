import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class sendreq1 extends HttpServlet
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
pw.println("<form action='sendreq2' method='post'>");

String tid=request.getParameter("tid");
int noproducts=Integer.parseInt(request.getParameter("nproducts"));
PreparedStatement pst=con.prepareStatement("select * from product_details where pid=?");
pst.setString(1,tid);
ResultSet rs=pst.executeQuery();
rs.next();
String pname=rs.getString(2);
String model=rs.getString(3);
int price=rs.getInt(4);
int totalprice=price * noproducts;
pw.println("<tr><th>ProductId</th><th><input type='text' name='tid' value='"+tid+"' /></th></tr>");
pw.println("<tr><th>Product Name</th><th><input type='text' name='pname' value='"+pname+"' /></th></tr>");
pw.println("<tr><th>Model</th><th><input type='text' name='model' value='"+model+"'  /></th></tr>");
pw.println("<tr><th>Price of Each Product</th><th><input type='number' name='price' value='"+price +"'/></th></tr>");
pw.println("<tr><th>Number of Products</th><th><input type='number' name='nproducts'  value='"+noproducts+"'/></th></tr>");
pw.println("<tr><th>Total Price</th><th><input type='number' name='total'  value='"+totalprice +"'/></th></tr>");
pw.println("<tr><th>Credit/Debit Card Number</th><th><input type='number' name='cno' required /></th></tr>");
pw.println("<tr><th>CVV</th><th><input type='number' name='cvv'  required /></th></tr>");
pw.println("<tr><th><input type='submit' value='Submit' /></th><th><input type='reset' value='reset' /></th></tr></form></table>");

	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


