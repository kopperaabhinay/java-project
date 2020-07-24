import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AddProducts extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");
String name=request.getParameter("pname");
String model=request.getParameter("model");
int price=Integer.parseInt(request.getParameter("price"));
String desc=request.getParameter("desc");
PreparedStatement pst=con.prepareStatement("insert into product_details values(?,?,?,?,?)");
String pid="PID"+(int)(Math.random()*10000);
pst.setString(1,pid);
pst.setString(2,name);
pst.setString(3,model);
pst.setInt(4,price);
pst.setString(5,desc);
int i=pst.executeUpdate();
pw.println("<center><h1>Product Added Successfully<br>");
pw.println("<a href='AdminHome.html'>Back</a>");
	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}