import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CustomerLogin extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
	  HttpSession hs=request.getSession();
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");
String user=request.getParameter("user");
String pwd=request.getParameter("pwd");
PreparedStatement pst=con.prepareStatement("select * from customer where username=? and password=?");
pst.setString(1,user);
pst.setString(2,pwd);
ResultSet rs=pst.executeQuery();
if(rs.next())
{
	hs.setAttribute("UserName",user);
	response.sendRedirect("customerhome.html");
}
else {
pw.println("<h1><center>Wrong UserName/Password,Try again");
pw.println("<a href='customer.html'>Back</a></h1>");
		  }

	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}