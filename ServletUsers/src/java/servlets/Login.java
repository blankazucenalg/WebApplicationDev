/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.User;
import classes.UserDelegate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azu
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Inicio de sesi&oacute;n</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"styles/principal.css\" title=\"Estilo principal\"/>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div id=\"menubar\">\n" +
"            \n" +
"        </div>\n" +
"        <div id=\"title\">\n" +
"            <h1>Sistema de administración de usuarios</h1>\n" +
"        </div>\n" +
"        <div id=\"content\">\n" +
"            <h1>Inicio de sesi&oacute;n</h1>\n" +
"            <form id=\"login\" name=\"login\" method=\"post\" action=\"login\">\n" +
"                <label for=\"username\">Nombre de usuario</label>\n" +
"                <input type=\"text\" name=\"username\" maxlength=\"40\"><br>\n" +
"                <label for=\"password\">Contrase&ntilde;a</label>\n" +
"                <input type=\"password\" name=\"password\"><br>\n" +
"                <input id=\"enviar\" type=\"submit\" class=\"button\" value=\"Iniciar sesión\"/>\n" +
"            </form>            \n" +
"            <p>Usuario o contraseña incorrectos</p>" +                    
"        </div>\n" +
"    </body>\n" +
"</html>");
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
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDelegate manager = new UserDelegate();
        try {
            if(manager.login(user)){
                response.sendRedirect("ManageUsers");
            } else {
                processRequest(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "User login";
    }// </editor-fold>

}
