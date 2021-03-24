package com.arun.tharak;
 import javax.servlet.*;
 import javax.servlet.http.*; 
 import java.io.*;
 import java.util.*;


 public class Image extends HttpServlet {
	
	@Override
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
// print Writer 

PrintWriter pw =null;
  String username=null;
   String password=null;
// general setting 

   pw=res.getWriter();
res.setContentType("text/html");   

// get req parameter values from data form

 username=req.getParameter("us");
 password=req.getParameter("ps");

 
// write req processing logic          
 if (username.equals("ArunTharak")&&password.equals("MyHeart")) {
	 
  /*	RequestDispatcher rd=req.getRequestDispatcher("Image.html");  
	    rd.forward(req, res); */
	 
	 pw.println("\r\n" + 
	 		"\r\n" + 
	 		"<body bgcolor='wheat' align=\"center\">\r\n" + 
	 		"\r\n" + 
	 		"<br><br><br>\r\n" + 
	 		"\r\n" + 
	 		"        <h1 style=\"color:red\"> <center> <b>*********** I Love You ************</b> </center></h1><br><br><br>\r\n" + 
	 		"        \r\n" + 
	 		"      <center> <h1>Butta bomma song.....</h1>\r\n" + 
	 		"<audio src=\"manoj3.mp3\" controls='controls'width='400px'height='400px'><br/><br/><br/>\r\n" + 
	 		"\r\n" + 
	 		"</center> \r\n" + 
	 		"\r\n" + 
	 		"<center>\r\n" + 
	 		"\r\n" + 
	 		"<br><br><br>\r\n" + 
	 		"<marquee  width='800px' height='55px' bgcolor='lightgreen' ><h1>******  Vedios ....  *****</h1></marquee><br/><br/><br/>\r\n" + 
	 		"\r\n" + 
	 		"<video src=\"arun1.mp4\" width=\"480\" height=\"300\" controls=\"controls\"></video><br/><br/>\r\n" + 
	 		"\r\n" + 
	 		"<iframe width=\"420\" height=\"315\"\r\n" + 
	 		"src=\"https://www.youtube.com/embed/XjJTtKTbR84? autoplay=1\">\r\n" + 
	 		"</iframe><br>\r\n" + 
	 		" <h3>Neeli Neeli Aakasam Lyrical Video Song | 30 Rojullo Preminchadam Ela | Pradeep Machiraju | Sid S</h3> <br><br/>\r\n" + 
	 		" \r\n" + 
	 		"</center>\r\n" + 
	 		"\r\n" + 
	 		"<center><marquee behavior='scroll' width='1000px' height='55px' bgcolor='pink'scrollamount=\"5\" ><h2>****** My lovely Pics  *****</h2></marquee></center><br/><br/><br/>\r\n" + 
	 		"        \r\n" + 
	 		" <marquee behavior='scroll'scrollamount=\"10\"><img src=\"arun10.jpg\" width=\"400\" height=\"400\"/></marquee><br/><br/><br/>\r\n" + 
	 		" \r\n" + 
	 		"<marquee behavior='alternate' scrollamount=\"20\" direction=\"left\" onmouseout=\"this.start()\" onmouseover=\"this.stop()\" > <img src=\"arun2.jpg\" width=\"300\" height=\"300\"/>&nbsp;\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"	  <img src=\"arun3.jpg\" width=\"300\" height=\"300\"/>&nbsp;\r\n" + 
	 		" \r\n" + 
	 		"\r\n" + 
	 		"  <img src=\"arun4.jpg\" width=\"300\" height=\"300\"/><br><br>&nbsp;</marquee>\r\n" + 
	 		"  \r\n" + 
	 		"  <marquee behavior='alternate' scrollamount=\"20\" direction=\"right\" onmouseout=\"this.start()\" onmouseover=\"this.stop()\" > <img src=\"arun8.jpg\" width=\"300\" height=\"300\"/>&nbsp;</marquee><br><br>\r\n" + 
	 		"\r\n" + 
	 		" <img src=\"arun5.jpg\" width=\"600\" height=\"600\"/> <br><br>\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"   <center> <img src=\"arun6.jpg\" width=\"600\" height=\"600\" align=\"middle\"/><br/><br/></center>\r\n" + 
	 		"\r\n" + 
	 		"<img src=\"arun7.jpg\" width=\"500\" height=\"500\"align=\"right\"/><br/><br/>\r\n" + 
	 		"<img src=\"arun8.jpg\" width=\"500\" height=\"500\"/><br/><br/>\r\n" + 
	 		" <center><img src=\"arun9.jpg\" width=\"500\" height=\"500\"align=\"middle\"/><br/><br/></center>\r\n" + 
	 		"<img src=\"arun1.jpg\" width=\"500\" height=\"500\"align=\"left\"/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"<img src=\"arun8.jpg\" width=\"500\" height=\"500\"/>\r\n" + 
	 		"<img src=\"arun2.jpg\" width=\"500\" height=\"500\"/>\r\n" + 
	 		"<img src=\"arun3.jpg\" width=\"500\" height=\"500\"/>\r\n" + 
	 		"<img src=\"arun4.jpg\" width=\"500\" height=\"500\"/>\r\n" + 
	 		"\r\n" + 
	 		"<img src=\"arun5.jpg\" width=\"500\" height=\"500\"/><center><br/><br/>\r\n" + 
	 		"<img src=\"arun6.jpg\" width=\"500\" height=\"500\"/><br/><br/>\r\n" + 
	 		"<img src=\"arun7.jpg\" width=\"500\" height=\"500\"/><br/><br/>\r\n" + 
	 		"<img src=\"arun8.jpg\" width=\"500\" height=\"500\"/><br/><br/>\r\n" + 
	 		"<img src=\"arun9.jpg\" width=\"500\" height=\"500\"/><br/><br/>\r\n" + 
	 		"<img src=\"arun10.jpg\" width=\"500\" height=\"500\"/><br/><br/></center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\r\n" + 
	 		"\r\n" + 
	 		"\r\n" + 
	 		"<img src=\"arun1.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun2.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun3.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun4.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun5.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun6.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun7.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun8.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun9.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun10.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun5.jpg\" width=\"300\" height=\"300\"/>\r\n" + 
	 		"<img src=\"arun4.jpg\" width=\"400\" height=\"400\"/>\r\n" + 
	 		"</body>\r\n" + 
	 		"	 \r\n" + 
	 		"\r\n" + 
	 		"	 ");
	 
	   
	 }
 else {
	 RequestDispatcher rd=req.getRequestDispatcher("Password.html");  
	    rd.include(req, res); 
	    
	 pw.println("<h1 style='color:red;text-align:center'><br><br><br><br><br><br>  Username and Password is Invalid......<br><br><img src='smilley2.jpg'></a>");	 
	 }
	 
	 
	pw.close();


	}// Service(-,-)

} //class

