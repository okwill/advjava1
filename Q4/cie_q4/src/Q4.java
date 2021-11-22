import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cie_q4.DBconnection;

@WebServlet("/Q4")
public class Q4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Q4() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
		int Emp_ID = Integer.parseInt(request.getParameter("emp_id"));
		String Employee_Name = request.getParameter("emp_name");
		String Address = request.getParameter("address");
		String dob =  request.getParameter("dob");
		response.setContentType("text/html");
		try {
			Connection con = DBconnection.initialize("Department");
			String query1 = "INSERT INTO `Employee` (`emp_id`, `employee_name`, `address`, `dob`) VALUES (?, ?, ?, ?) ";
		//	String query1 = "INSERT INTO `Employee` (`Emp_ID`, `Employee_Name`, `Address`) VALUES (?, ?, ?) ";
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setInt(1, Emp_ID);
			ps.setString(2, Employee_Name);
			ps.setString(3, Address);
			ps.setString(4, dob);
			ps.execute();
		
			String query2 = "SELECT * FROM Employee";
			
			//table
			
			
			
			
			ResultSet rs = ps.executeQuery(query2);
			PrintWriter out = response.getWriter();
			
			out.println("<TABLE CELLSPACING=\"0\" CELLPADDING=\"4\" BORDER=\"1\">");
			out.println("<TR><TH>ID</TH><TH>Name</TH><TH>address</TH><TH>Date</TH></TR>");
			
			while(rs.next()) {
				out.println("<TR>");
			  	out.println("  <TD>" + rs.getString("Emp_ID") + "</TD>");
			  	out.println("  <TD>" + rs.getString("Employee_Name") + "</TD>");
			  	out.println("  <TD>" + rs.getString("Address") + "</TD>");
			  	out.println("  <TD>" + rs.getString("dob") + "</TD>");
			  	out.println("</TR>");
				}
			out.println("</TABLE>");
			}
		 catch(Exception e) {
			e.printStackTrace();
		}
	}
}