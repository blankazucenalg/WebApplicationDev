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
import java.util.LinkedList;
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
@WebServlet(name = "ManageUsers", urlPatterns = {"/ManageUsers"})
public class ManageUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    UserDelegate manager;
    LinkedList<User> results;
    String userTypes[] = {"Administrador", "Estándar"};

    public ManageUsers() throws SQLException {
        manager = new UserDelegate();
        this.results = manager.selectAllUsers();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>Búsqueda de usuarios</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" href=\"styles/principal.css\" title=\"Estilo principal\"/>\n"
                    + "<script>"
                    + "function confirmDeleteUser(idUser){"
                    + "     if(confirm(\"El usuario será eliminado. ¿Desea continuar?\")) {"
                    + "         window.location = \"DeleteUser?idUser=\"+idUser;   "
                    + "     } else {"
                    + "         return false;"
                    + "     } return true;"
                    + "}"
                    + "function editUser(idUser) {"
                    + "     window.location = \"EditUser?idUser=\"+idUser; "
                    + "}"
                    + "</script>"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div id=\"menubar\">\n"
                    + "            <ul>\n"
                    + "                <li><a href=\"ManageUsers?search=\">Búsqueda de usuarios</a></li>\n"
                    + "                <li><a href=\"SignUp.jsp\">Registrar nuevo usuario</a></li>\n"
                    + "                <li><a href=\"index.jsp\">Cerrar sesión</a></li>\n"
                    + "            </ul>\n"
                    + "        </div>\n"
                    + "        <div id=\"content\">\n"
                    + "            <h1>Usuarios del sistema</h1>\n"
                    + "            <form class=\"formulario\" id=\"searchForm\" name=\"searchForm\" method=\"get\" action=\"ManageUsers\">\n"
                    + "                <label for=\"search\">Buscar usuario</label>\n"
                    + "                <input type=\"text\" id=\"search\" name=\"search\"/>\n"
                    + "                <input id=\"search-button\" type=\"submit\" value=\"Buscar\"/>\n"
                    + "            </form><br>\n"
                    + "            <table id=\"users\">\n"
                    + "                <tr id=\"header-table\">\n"
                    + "                    <th>Apellido paterno</th>\n"
                    + "                    <th>Apellido materno</th>\n"
                    + "                    <th>Nombre(s)</th>\n"
                    + "                    <th>Correo electrónico</th>\n"
                    + "                    <th>Nombre de usuario</th>\n"
                    + "                    <th>Tipo de usuario</th>\n");
            
                    out.println("<th class=\"actions\">Acciones</th>\n </tr>\n");
            manager = new UserDelegate();
            for (User result : results) {
                out.println("<tr>\n "
                        + "<td>" + result.getLastname() + "</td>\n"
                        + "<td>" + result.getSurname() + "</td>\n"
                        + "<td>" + result.getName() + "</td>\n"
                        + "<td>" + result.getEmail() + "</td>\n"
                        + "<td>" + result.getUsername() + "</td>\n"
                        + "<td>" + userTypes[result.getUserType() - 1] + "</td>\n"
                        + "<td class=\"actions\">"
                        + "<button id=\"EditUser\" type=\"submit\" value=\"\" onclick=\"editUser("+result.getIdUser()+")\"/> "
                        + "<button id=\"DeleteUser\" type=\"submit\" value=\"\" onclick=\"confirmDeleteUser("+result.getIdUser()+")\"/> "
                        + "</td>\n"
                        + "</tr>\n");
            }
            out.println(
                    "            </table>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
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
        if (request.getParameter("search") != null) {
            String search = request.getParameter("search");
            manager = new UserDelegate();
            try {
                results = manager.searchUser(search);
            } catch (SQLException ex) {
                Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
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
