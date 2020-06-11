/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cartajena-Solar
 */
@WebServlet(name = "RegistrarUser", urlPatterns = {"/registro.do"})
public class RegistrarUser extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarUser at " + request.getContextPath() + "</h1>");
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
        String msgExito="", msgError="", errores="";
        //Recuperar la lista de usuarios desde el ámbinto de la aplicación ("nube")
        ArrayList<Usuario> lUsers = (ArrayList) this.getServletContext().getAttribute("lstUsers");
        //Se recuperan los parámetros desde la petición.
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        //Validaciones
        if (nombre.isEmpty()){
            errores="Debes ingresar tu nombre.";
        }
        if (apellido.isEmpty()){
            errores+="Debes ingresar tu apellido.";
        }
        if (user.isEmpty()){
            errores+="Debes ingresar el nombre de usuario.";
        }
        if (pass.isEmpty()){
            errores+="Debes ingresar la password.";
        }
        if (errores.isEmpty()){
            //Se encapsula los datos en un objeto del modelo.
            Usuario usuario = new Usuario(nombre, apellido, user, pass);
            //Se agrega el objeto a la lista.
            lUsers.add(usuario);
            //Actualizamos el atributo que posee la lista.
            this.getServletContext().setAttribute("lstUsers", lUsers);
            //Se realizar el forwarding.
            msgExito="Registro insertado correctamente.";
            //Se genera un atributo en el request conm el mensaje de exito.
            request.setAttribute("msgExito", msgExito);
            
        } else {
            //Se genera un atributo en el request con el mensaje de error.
            request.setAttribute("msgError", errores);
            
        }
        //Se realizar el forwarding.
        request.getRequestDispatcher("saveuser.jsp").forward(request, response);
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
