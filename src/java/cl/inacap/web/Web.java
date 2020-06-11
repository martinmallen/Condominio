/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.web;

import cl.inacap.modelo.Producto;
import cl.inacap.modelo.Usuario;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Cartajena-Solar
 */
@WebListener()
public class Web implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Se construye una lista de usuarios
        ArrayList<Usuario> listaUsers = new ArrayList();
        ArrayList<Producto> listaProds = new ArrayList();
        //Se le agregan usuarios por defecto.
        listaUsers.add(new Usuario("Usuario", "Administrador", "admin", "admin"));
        listaUsers.add(new Usuario("Pepito", "Rojas", "projas", "1234"));
        listaUsers.add(new Usuario("Mary", "Villa", "mvilla", "1234"));
        //Se agregan productos a la lista.
        listaProds.add(new Producto(1, "Memoria 64Gb", 7990, 5));
        listaProds.add(new Producto(2, "Samsung S20", 590000, 5));
        listaProds.add(new Producto(3, "Parlante USB", 10990, 5));
        listaProds.add(new Producto(4, "Pack Pilas Recargables", 7990, 5));
        //Se disponibiliza en el contexto de la aplicación (servidor)el recurso de la lista.
        sce.getServletContext().setAttribute("lstUsers", listaUsers);
        sce.getServletContext().setAttribute("lstProds", listaProds);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
}
