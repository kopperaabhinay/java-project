import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class UpdateProduct1 extends HttpServlet
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
String pname=request.getParameter("pname");
String model=request.getParameter("model");
String price=request.getParameter("price");
String desc=request.getParameter("desc");
PreparedStatement pst=con.prepareStatement("update product_details set pname=?,model=?,price=?,descp=? where pid=?");
pst.setString(1,pname);
pst.setString(2,model);
pst.setString(3,price);
pst.setString(4,desc);
pst.setString(5,pid);
int i=pst.executeUpdate();
pw.println("<center><h1>Product Details Updated Successfully");
	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


