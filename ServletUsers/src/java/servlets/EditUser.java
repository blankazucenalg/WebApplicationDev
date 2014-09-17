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
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

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
        User user = (User) request.getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>Actualizar usuario</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" href=\"styles/principal.css\" title=\"Estilo principal\"/>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div id=\"menubar\">\n"
                    + "            <ul>\n"
                    + "                <li><a href=\"ManageUsers\">Búsqueda de usuarios</a></li>\n"
                    + "                <li><a href=\"SignUp.jsp\">Registrar nuevo usuario</a></li>\n"
                    + "                <li><a href=\"index.jsp\">Cerrar sesión</a></li>\n"
                    + "            </ul>\n"
                    + "        </div>\n"
                    + "        <div id=\"content\">\n"
                    + "            <h1>Datos del usuario</h1>\n"
                    + "            <form id=\"editForm\" name=\"editForm\" class=\"formulario\" method=\"post\" action=\"EditUser\" accept-charset=\"ISO-8859-1 UTF-8\">\n"
                    + "                <input type=\"hidden\" name=\"idUser\" value=\"" + user.getIdUser() + "\">"
                    + "                <label for=\"name\">Nombre(s)</label>\n"
                    + "                <input type=\"text\" name=\"name\" required=\"required\" value=\"" + user.getName() + "\" /><br>\n"
                    + "                <label for=\"lastname\">Apellido paterno</label>\n"
                    + "                <input type=\"text\" name=\"lastname\" required=\"required\" value=\"" + user.getLastname() + "\"/><br>\n"
                    + "                <label for=\"surname\">Apellido materno</label>\n"
                    + "                <input type=\"text\" name=\"surname\" required=\"required\" value=\"" + user.getSurname() + "\"/><br>\n"
                    + "                <label for=\"email\">Correo electr&oacute;nico</label>\n"
                    + "                <input type=\"email\" name=\"email\" required=\"required\" value=\"" + user.getEmail() + "\"/><br>\n"
                    + "                <label for=\"username\">Nombre de usuario</label>\n"
                    + "                <input type=\"text\" name=\"username\" maxlength=\"40\" required=\"required\" value=\"" + user.getUsername() + "\"/><br>\n"
                    + "                <input type=\"hidden\" name=\"password\" value=\"" + user.getPassword() + "\">"
                    + "                <label for=\"userType\">Tipo de usuario</label>\n"
                    + "                <select name=\"userType\" required=\"required\">\n");
            if (user.getUserType() == 1) {
                out.println("<option value=\"1\" selected=\"selected\">Administrador</option>\n"
                        + "                    <option value=\"2\" >Est&aacute;ndar</option>\n");
            } else if (user.getUserType() == 2) {
                out.println("<option value=\"1\" >Administrador</option>\n"
                        + "                    <option value=\"2\" selected=\"selected\">Est&aacute;ndar</option>\n");
            }
            out.println("                </select><br><br>\n"
                    + "<input type=\"submit\" class=\"button\" name=\"send\" value=\"Actualizar datos\"><br>\n"
                    + "           </form>\n"
                    + "           <br><h2>Cambio de contraseña</h2>\n"
                    + "           <form id=\"editPass\" name=\"editPass\" class=\"formulario\" method=\"post\" action=\"EditUser\" accept-charset=\"ISO-8859-1 UTF-8\">\n"
                    + "                <input type=\"hidden\" name=\"idUser\" value=\"" + user.getIdUser() + "\">\n"
                    + "                <label for=\"actual-password\">Contrase&ntilde;a actual</label>\n"
                    + "                <input type=\"password\" name=\"actualPassword\"><br>\n "
                    + "                <label for=\"actual-password\">Nueva contraseña</label>\n"
                    + "                <input type=\"password\" name=\"newPassword\"><br>\n "
                    + "                    <label for=\"actual-password\">Confirmar contraseña</label>\n"
                    + "                <input type=\"password\" name=\"confirmPassword\"><br>\n "
                    + "                <input type=\"submit\" class=\"button\" name=\"send\" value=\"Actualizar contraseña\"><br>\n"
                    + "            </form>\n"
                    + "        </div>\n");
            if(request.getAttribute("edited") != null){
                out.println("<script>"
                        + "window.alert(\"Usuario actualizado\");"
                        + "window.location = \"ManageUsers?search=\""
                        + "</script>");
            }
                out.println("    </body>\n"
                    + "</html>");
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
        User user = new User();
        try {
            if (request.getParameter("idUser") != null) {
                int idUser = Integer.parseInt(request.getParameter("idUser"));
                UserDelegate finder = new UserDelegate();
                UserDelegate manager = new UserDelegate();
                user = finder.selectUserById(idUser);
                request.setAttribute("user", user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        User user = new User();
        UserDelegate manager = new UserDelegate();
        if (request.getParameter("actualPassword") != null && request.getParameter("newPassword") != null
                && request.getParameter("confirmPassword") != null) {
            UserDelegate finder = new UserDelegate();

            try {
                user = finder.selectUserById(Integer.parseInt(request.getParameter("idUser")));
                if (request.getParameter("newPassword").equals(request.getParameter("confirmPassword"))) {
                    user.setPassword(request.getParameter("newPassword"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            user.setIdUser(Integer.parseInt(request.getParameter("idUser")));
            user.setName(request.getParameter("name"));
            user.setLastname(request.getParameter("lastname"));
            user.setSurname(request.getParameter("surname"));
            user.setEmail(request.getParameter("email"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setUserType(Integer.parseInt(request.getParameter("userType")));
        }
        try {
            if (manager.updateUser(user) == 0) {
                    request.setAttribute("user", user);
                    request.setAttribute("edited", 1);
                    processRequest(request, response); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
