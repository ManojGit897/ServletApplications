package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private  static final String  INSERT_EMPLOYEE="INSERT INTO LAYERED_EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?,?,?,?)";
	
	/*  private  Connection  getPooledConnection()throws Exception {
		  InitialContext ic=null;
		  DataSource ds=null;
		  Connection con=null;
		  //create InitialContext obj
		  ic=new InitialContext();
		  //get DataSource obj throuhg lookup opeation
		  ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		  //get pooled jdbc con object
		  con=ds.getConnection();
		  return con;  */
public void init(){
		
     try{
	// register jdbc driver

	Class.forName("oracle.JDBC.driver.OracleDriver");
	//Establish the connection
	
	con=DriverManager.getConnection("JDBC:oracle:thin:@localhost:1521:ORCL","system","manager");

	// create JDBC prepared statement
	ps=con.prepareStatement(" select empno,ename,job,sal from emp where empno=?");
   }

   catch (Exception e){
	e.printStackTrace();
   }

	}//init()
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int  count=0;
		//get pooled jdbc con object
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_EMPLOYEE);
		//set values to query params
		ps.setString(1, bo.getEname());
		ps.setString(2,bo.getEadd());
		ps.setFloat(3,bo.getSalary());
		ps.setFloat(4,bo.getGrossSalary());
		ps.setFloat(5,bo.getNetSalary());
		//execute the Query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}