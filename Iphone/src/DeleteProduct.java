import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class DeleteProduct extends HttpServlet
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
PreparedStatement pst=con.prepareStatement("delete from product_details where pid=?");
pst.setString(1,pid);
int i=pst.executeUpdate();
pw.println("<h1><Center>Product with Id: "+pid+" is deleted"); 

	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


