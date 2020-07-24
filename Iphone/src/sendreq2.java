import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class sendreq2 extends HttpServlet
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
String user=(String)hs.getAttribute("UserName");
String pid=request.getParameter("tid");
String pname=request.getParameter("pname");
String model=request.getParameter("model");
int price=Integer.parseInt(request.getParameter("price"));
int nproducts=Integer.parseInt(request.getParameter("nproducts"));
int total=Integer.parseInt(request.getParameter("total"));
String cno=request.getParameter("cno");
String cvv=request.getParameter("cvv");
Date d=new Date();
String odate=d.getDate()+"-"+(d.getMonth()+1)+"-"+(d.getYear()+1900);
PreparedStatement pst=con.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?,?,?,?)");
String oid=("OID")+(int)(Math.random() * 10000);
pst.setString(1,oid);pst.setString(2,user);
pst.setString(3,pid);pst.setString(4,pname);pst.setString(5,model);
pst.setInt(6,price);pst.setInt(7,nproducts);pst.setInt(8,total);
pst.setString(9,cno);pst.setString(10,cvv);pst.setString(11,odate);
int i=pst.executeUpdate();
pw.println("<h1><center>Your Order is Successfull,Thank you for Shopping With Us");
pw.println("<a href='customerhome.html'>Back</a>");

	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


