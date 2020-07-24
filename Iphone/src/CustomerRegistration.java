import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CustomerRegistration extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");
  String name=request.getParameter("user");
String pwd=request.getParameter("pwd");
String email=request.getParameter("email");
String mno=request.getParameter("mno");
String dept=request.getParameter("addr");
PreparedStatement pst=con.prepareStatement("insert into customer values(?,?,?,?,?)");
pst.setString(1,name);
pst.setString(2,pwd);
pst.setString(3,email);
pst.setString(4,mno);
pst.setString(5,dept);
int i=pst.executeUpdate();
pw.println("<center><h1>Registered Successfully,Please Login to Continue<br>");
pw.println("<a href=customer.html>Click here to login</a>");
	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}