/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerfront.servlet;

import com.mycompany.customerfront.service.customerClient;
import com.mycompany.customermp.entity.Tblcustomer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
public class customerServlet extends HttpServlet {

    @Inject @RestClient customerClient cc;
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerServlet at " + request.getContextPath() + "</h1>");
            
            out.print("<form>");
            out.print("Condition: <select name=con>");
            out.print("<option value='lessthan'>lessthan</option>");
            out.print("<option value='greaterthan'>greaterthan</option>");
            out.print("<option value='lte'>lte</option>");
            out.print("<option value='gte'>gte</option>");
            out.print("<option value='equal'>equal</option>");
            out.print("</select>");
            out.print("<br>");
            out.print("Rating: <input type=test name=txtrating>");
            out.print("<br>");
            out.print("<input type=submit value=Submit>");
            out.print("</form>");
            
            if(request.getParameter("con")!=null && request.getParameter("txtrating")!=null)
            {
                try
                {
                    Collection<Tblcustomer> c = cc.getCustomers(request.getParameter("con"),Integer.parseInt(request.getParameter("txtrating")));
                    for (Tblcustomer tblcustomer : c) {
                        out.println("Name= " + tblcustomer.getName()+"\n Rating: " + tblcustomer.getRating()+ "\n email: "+tblcustomer.getEmail());
                    }
                }
                catch(Exception e)
                {
                    out.println("not authorize");
                }
            }
            else
            {
                out.println("no data");
            }
                
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
