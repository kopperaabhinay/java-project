import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class adminvieworder extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	  PrintWriter pw=response.getWriter();
	  response.setContentType("text/html");
      try{
  Class.forName("oracle.jdbc.OracleDriver");
  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","iphonestore","iphonestore");

pw.println("<h2 align='right'>Welcome Adminstrator,&nbsp;&nbsp;&nbsp;&nbsp;<a href='AdminHome.html'>Back</a></h4>");
pw.println("<br><br>");

pw.println("<table align='center' style='font-size:16px;' border=2 width=100% height=50%>");
pw.println("<tr><th colspan=9><h3 style='font-size:15px;'>Products Avaialbe </h3></th></tr>");
pw.println("<tr><th>Product Id</th><th>Name</th>");
pw.println("<th>Model </th>");
pw.println("<th>Price</th>");
pw.println("<th>Description</th>");
pw.println("<th>Operation</th></tr>");
  PreparedStatement pst=con.prepareStatement("select * from Product_Details");
  ResultSet rs=pst.executeQuery();
  while(rs.next())
  {
pw.println("<tr><th>"+rs.getString(1)+"</th>");
pw.println("<th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</th> <th><a href='DeleteProduct?pid="+rs.getString(1)+"'>Delete</a>/<a href='UpdateProduct?pid="+rs.getString(1)+"'>Update</a></th></tr>");
  }

pw.println("</table>");
  




	  }catch(Exception e){
		  pw.println(e);
	  }
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
   
}


