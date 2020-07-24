import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class userviewproducts extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");

pw.println("<h2 align='right'>Welcome Customer,&nbsp;&nbsp;&nbsp;&nbsp;<a href='customerhome.html'>Back</a></h4>");
pw.println("<br><br>");

pw.println("<table align=center style='font-size:20px;' border=2 width=100% height=50%>");
pw.println("<tr><th colspan=6><h3 style='font-size:20px;'>Mobile Phone Details</h3></th></tr><tr><th>Product Id</th> <th>Name</th><th>Model</th><th>Price</th><th>Description</th><th>Operation</th></tr>");
PreparedStatement pst=con.prepareStatement("select * from product_details");
 ResultSet rs=pst.executeQuery();
  while(rs.next())
  {
pw.println("<tr><th>"+rs.getString(1)+"</th><th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</th><th><a href='sendreqtid?tid="+rs.getString(1)+"'>Buy Product</a></th></tr>");
}

		



	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


