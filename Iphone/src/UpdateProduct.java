import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class UpdateProduct extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");

pw.println("<h2 align='right'>Welcome Adminstrator,&nbsp;&nbsp;&nbsp;&nbsp;<a href='AdminHome.html'>Back</a></h4>");
pw.println("<br><br>");
String pid=request.getParameter("pid");
PreparedStatement pst=con.prepareStatement("select * from Product_Details where pid=?");
pst.setString(1,pid);
ResultSet rs=pst.executeQuery();
  rs.next();
pw.println("<h1><center><form action='UpdateProduct1'>");
pw.println("Product Id  : <input type='text' name='pid' value="+rs.getString(1)+" ><br>");
pw.println("Product Name:<input type='text' name='pname' value="+rs.getString(2)+"><br>");
pw.println("Model		:<input type='text' name='model' value="+rs.getString(3)+"><br>");
pw.println("Price		:<input type='text' name='price' value="+rs.getString(4)+"><br>");
pw.println("Description	:<textarea rows=10 cols=20 name='desc'>"+rs.getString(5)+"</textarea><br>");
pw.println("<input type='submit' value='Update' /><input type='reset' value='reset'/>");
pw.println("</form>");
	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


