package com.mindtree.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Order;
import com.mindtree.util.ConnectionManager;


@Path("/")
public class JSONService {
Connection con;
PreparedStatement pr;
Statement st;
ResultSet rs,rs2;
	@GET
	@Path("/{table}/{names}")
	public Response getTrackInJSON(@PathParam("table")String table,@PathParam("names")String names) throws SQLException, JSONException {
	JSONObject json= new JSONObject();
	/*new DbVersioning().callflyway();*/
	con=ConnectionManager.getConnection();
	st=con.createStatement();
		if(table.equals("employee"))
		{
			rs=st.executeQuery("select * from employee where name='"+names+"';");
			while(rs.next())
			{		
			if(names.equals(rs.getString(1)))
			{
				json.put("name",rs.getString(1));
				json.put("age",rs.getString(2));
				json.put("gender",rs.getString(3));
				System.out.println(json);
				return Response.status(201).entity(json).build();
			}	
				
			}
		}
		if(table.equals("orders"))
		{
			rs2=st.executeQuery("select * from orders where name='"+names+"';");
			while(rs2.next())
			{		
			if(names.equals(rs2.getString(1)))
			{
				json.put("name",rs2.getString(1));
				json.put("description",rs2.getString(2));
				System.out.println(json);
				return Response.status(201).entity(json).build();
			}	
		}
		}
		return Response.status(201).entity(json).build();
	}
	

	@POST
	@Path("/post/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Employee employee) throws SQLException {
		System.out.println("Enabling Database integration...");
		/*new DbVersioning().callflyway();*/
		System.out.println("Database Integration completed!!!");
		String result = "Employee with name "+employee.getName()+" saved";
		con=ConnectionManager.getConnection();
		pr=con.prepareStatement("insert into employee values(?,?,?);");
		pr.setString(1, employee.getName());
		pr.setString(2, employee.getAge());
		pr.setString(3, employee.getGender());
		pr.executeUpdate();
		return Response.status(201).entity(result).build();
		
	}
	@POST
	@Path("/post/order")
	@Consumes(MediaType.APPLICATION_JSON)

	public Response createTrackInJSON(Order order) throws SQLException {
		System.out.println("Enabling Database integration...");
		/*new DbVersioning().callflyway();*/
		System.out.println("Database Integration completed!!!");
		String result = "Order with name "+order.getOrderName()+" saved";
		con=ConnectionManager.getConnection();
		pr=con.prepareStatement("insert into orders values(?,?);");
		pr.setString(1, order.getOrderName());
		pr.setString(2, order.getDescription());
		pr.executeUpdate();
		return Response.status(201).entity(result).build();
		
	}
	
	
}