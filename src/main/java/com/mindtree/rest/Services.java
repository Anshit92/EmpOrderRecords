package com.mindtree.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Order;
import com.mindtree.util.ConnectionManager;


@Path("/")
public class Services {
	private static final Logger logger = Logger.getLogger(Services.class);
Connection con;
PreparedStatement pr;
Statement stmt;
ResultSet rs,rs2;
	@GET
	@Path("/{table}/{names}")
	public Response getTrackInJSON(@PathParam("table")String table,@PathParam("names")String names) throws SQLException, JSONException {
	JSONObject jsonObject = new JSONObject();
	try {
	con=ConnectionManager.getConnection();
	stmt=con.createStatement();
	String query = "select * from "+table+" where name='"+names+"'";
    ResultSet rs =  stmt.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    
    while (rs.next()) {
        for (int i = 1;i <= columnsNumber; i++) {
            String columnValue = rs.getString(i);
            System.out.println(columnValue);
            jsonObject.put(rsmd.getColumnName(i), columnValue);
        }
    }} catch (SQLException e) {
		logger.error("SQL Exception");
	}
		return Response.status(201).entity(jsonObject).build();
	}
	

	@POST
	@Path("/post/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Employee employee) throws SQLException {
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
		String result = "Order with name "+order.getOrderName()+" saved";
		con=ConnectionManager.getConnection();
		pr=con.prepareStatement("insert into orders values(?,?);");
		pr.setString(1, order.getOrderName());
		pr.setString(2, order.getDescription());
		pr.executeUpdate();
		return Response.status(201).entity(result).build();
		
	}
	
	
}