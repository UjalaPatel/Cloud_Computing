/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import static javax.security.auth.message.AuthStatus.SEND_FAILURE;
import static javax.security.auth.message.AuthStatus.SUCCESS;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@Named(value = "loginBean")
@RequestScoped
public class loginBean {
    @Inject SecurityContext sc;
    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            Credential credential = new UsernamePasswordCredential(getUserName(), new Password(getPassword()));
            AuthenticationStatus status = sc.authenticate(request, response, withParams().credential(credential));
            request.getSession().setAttribute("role", "");

            if (status.equals(SUCCESS)) {
                if (sc.isCallerInRole("Admin")) {
                    System.out.println("Admin");
                    request.getSession().setAttribute("role", "Admin");
                    request.getSession().setAttribute("username", getUserName());
                    RequestDispatcher rd = request.getRequestDispatcher("CustomerServlet");
                    rd.forward(request, response);
                } else if (sc.isCallerInRole("Student")) {
                    System.out.println("Student");
                    request.getSession().setAttribute("role", "Student");
                    request.getSession().setAttribute("username", getUserName());
                    RequestDispatcher rd = request.getRequestDispatcher("NewServlet");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("login.xhtml");
                }
            } else if (status.equals(SEND_FAILURE)) {
                response.sendRedirect("login.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
