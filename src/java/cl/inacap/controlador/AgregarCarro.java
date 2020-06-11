/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.modelo.Producto;
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
@WebServlet(name = "AgregarCarro", urlPatterns = {"/agregar.do"})
public class AgregarCarro extends HttpServlet {

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
            out.println("<title>Servlet AgregarCarro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarCarro at " + request.getContextPath() + "</h1>");
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
        //Recuperar desde la nube o ambito de la aplicación, la lista de productos.
        ArrayList<Producto> lProds = (ArrayList) this.getServletContext().getAttribute("lstProds");
        //Obtención de los parametros desde la petición.
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String descripcion = request.getParameter("txtDescripcion");
        int precio = Integer.parseInt(request.getParameter("txtPrecio"));
        int cantidad = Integer.parseInt(request.getParameter("cboCantidad"));
        //Se encapsula la data en un objeto del modelo (Producto).
        Producto prod = new Producto(codigo, descripcion, precio, cantidad);
        //Obtener el carro de la sesión del usuario.
        ArrayList<Producto> carroProds = (ArrayList) request.getSession().getAttribute("carro");
        //Si la lista de productos del carro, está vacía.  Significa que
        //es la primera "compra" del usuario, por lo que es necesario crear la lista.
        if (carroProds == null){
            carroProds = new ArrayList();
        }
        //Se agrega el producto al carro del usuario.
        carroProds.add(prod);
        //Se agrega el carro de productos a la sesión.
        request.getSession().setAttribute("carro", carroProds);
        //Rebajar de la lista de productos, el stock del producto comprado.
        for (Producto p : lProds) {
            if (p.getCodigo() == codigo) {
                p.setStock(p.getStock() - cantidad);
                break;
            }
        }
        //Se actualiza la lista en la nube o ambito de la aplicación.
        this.getServletContext().setAttribute("lstProds", lProds);
        //se redirecciona hacia la lista de productos.
        response.sendRedirect("productos.jsp");
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
