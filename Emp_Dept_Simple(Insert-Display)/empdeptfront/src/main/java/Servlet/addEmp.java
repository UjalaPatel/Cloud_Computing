/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.mycompany.empdeptfront.service.employeeClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author ASUS
 */
public class addEmp extends HttpServlet {
    
    @Inject @RestClient employeeClient emp;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if (request.getParameter("txtname") != null) {
                String ename = request.getParameter("txtname");
                String gender = request.getParameter("txtgender");
                int esalary = Integer.parseInt(request.getParameter("txtsalary").toString());
                String jdate = request.getParameter("txtjdate");
                int deptid = Integer.parseInt(request.getParameter("txtdept"));
                System.out.println(ename + "  " + esalary + "  " + deptid);
                emp.addEmp(ename,gender, esalary,jdate, deptid);
                response.sendRedirect("AllEmp");
            }

            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addEmp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addEmp at " + request.getContextPath() + "</h1>");

            
            
            out.println("<form method='post'>");
            out.println("Name:<input type='text' name='txtname'><br/>");
            out.println("Gender:<input type='text' name='txtgender'><br/>");
            out.println("Salary:<input type='text' name='txtsalary'><br/>");
            out.println("JoiningDate:<input type='text' name='txtjdate'><br/>");
            out.println("deptit:<input type='text' name='txtdept'><br/>");
            out.println("<input type='submit' value='ADD'><br/>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
