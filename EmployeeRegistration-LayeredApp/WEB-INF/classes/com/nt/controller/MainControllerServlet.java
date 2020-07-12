package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private EmployeeMgmtService  service;
	
	public  void init() {
		 service=new  EmployeeMgmtServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String  ename=null,eadd=null,deptNo=null,esalary=null;
        EmployeeVO vo=null;
        EmployeeDTO dto=null;
        PrintWriter pw=null;
        String resultMsg=null;
        //get PrintWriter
        pw=res.getWriter();
        res.setContentType("text/html");
		//read form data
        ename=req.getParameter("ename");
        eadd=req.getParameter("eadd");
        deptNo=req.getParameter("deptNo");
        esalary=req.getParameter("esalary");
        //Store form data into VO class object
        vo=new EmployeeVO();
        vo.setEname(ename);
        vo.setEadd(eadd);
        vo.setSalary(esalary);
        vo.setDeptno(deptNo);
        //convert VO class object to DTO class object
        dto=new EmployeeDTO();
        dto.setDeptno(Integer.parseInt(vo.getDeptno()));
        dto.setEname(vo.getEname());
        dto.setEadd(vo.getEadd());
        dto.setSalary(Float.parseFloat(vo.getSalary()));
        //use Service class
        try {
        	resultMsg=service.registerEmployee(dto);
        	pw.println("<h1 style='color:red;text-align:center'>"+resultMsg+"</h1>");
        }
        catch(Exception e) {
        	e.printStackTrace();
        	pw.println("<h1 style='color:red;text-align:center'>Internal Problem--Try Again</h1>");
        	
        }
        pw.println("<br> <a href='employee_register.html'>home</a>");
        //close stream
        pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}
	
	public void destroy() {
		service=null;
	}

}
