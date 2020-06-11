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
@WebServlet(name = "ValidaLogin", urlPatterns = {"/login.do"})
public class ValidaLogin extends HttpServlet {

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
            out.println("<title>Servlet ValidaLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaLogin at " + request.getContextPath() + "</h1>");
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
        String msg="", errores="";
        //Recuperar la lista de usuarios desde el ámbinto de la aplicación ("nube")
        ArrayList<Usuario> lUsers = (ArrayList) this.getServletContext().getAttribute("lstUsers");
        //Se recuperan los parámetros desde la petición.
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        //Validaciones
        if (user.isEmpty()){
            errores="<li>Debes ingresar el nombre de usuario.</li>";
        }
        if (pass.isEmpty()){
            errores+="<li>Debes ingresar la password.</li>";
        }
        if (errores.isEmpty()){ //Ingreso OK.
            //Se veirifica si el usuario y password se encuentran en la lista.
            Usuario usuarioValido = null;
            for (Usuario usu : lUsers) {
                if (usu.getUser().equals(user) &&
                    usu.getPass().equals(pass)){
                    usuarioValido = usu;
                    break;
                }
            }
            //Verificar si el usuaio es válido.
            if (usuarioValido != null){ //Tiene acceso a la aplicación de compra.
                //Se define un atributo en el objeto de sesión.
                request.getSession().setAttribute("user", usuarioValido);
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                
            } else { //Devolver al usuario al login.
                msg="Usuario y/o Password invalido.";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
        } else { //Devolver al usuario hacia el login.
            request.setAttribute("msg", errores);
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
