/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import modelos.Producto;
import modelos.Tienda;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class ControladorTiendas {
    
    //Atributos ControladorTiendas
    private Servicio servicioTiendas;

    // Método constructor clase ControladorTiendas
    public ControladorTiendas(Servicio servicioTiendas) {
        this.servicioTiendas = servicioTiendas;
    }
    
    public boolean crear(Tienda laTienda) {
        boolean creado = false;
        String respuesta = servicioTiendas.POST("tiendas", laTienda.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject tiendaJSON = (JSONObject) parser.parse(respuesta);
            laTienda = new Tienda();
            laTienda.toObject(tiendaJSON);
            creado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return creado;
    }
    
    /**
     * Devuelve una instancia de administrador seleccionada por el usuario
     * @param id - id del administrador
     * @return El objeto, si es que lo encuentra en el proceso
     */
    public Tienda ver(String id) {
        Tienda laTienda = null;
        String respuesta = servicioTiendas.GET("tiendas/" + id);
        try {
            JSONParser parser = new JSONParser();
            JSONObject tiendaJSON = (JSONObject) parser.parse(respuesta);
            laTienda = new Tienda();
            laTienda.toObject(tiendaJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return laTienda;
    }
    
    /**
     * Método encargado de traer todos los datos de la ruta 'tiendas'
     * @return LinkedList con los objetos
     */
    public LinkedList<Tienda> listar() {
        LinkedList<Tienda> lasTiendas = new LinkedList<>();
        String respuesta =  this.servicioTiendas.GET("tiendas");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray productosJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : productosJSON) {
                Tienda tiendaTemporal = new Tienda();
                tiendaTemporal.toObject((JSONObject) actual);
                lasTiendas.add(tiendaTemporal);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return lasTiendas;
    }
    
    public boolean editar(Tienda laTienda) {
        boolean editado = false;
        String respuesta = servicioTiendas.PUT("tiendas/"+laTienda.getId(), laTienda.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject tiendaJSON = (JSONObject) parser.parse(respuesta);
            laTienda = new Tienda();
            laTienda.toObject(tiendaJSON);
            editado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return editado;
    }
    
    /**
     * Elimina una instancia de administrado querida por el usuario
     * @return validacion de si se elimino o no
     */
    public boolean eliminar(Tienda laTienda) {
        boolean eliminado =false;
        String respuesta = servicioTiendas.DELETE("tiendas/" + laTienda.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }
    
    // Setters and Getters

    /**
     * @return the servicioTiendas
     */
    public Servicio getServicioTiendas() {
        return servicioTiendas;
    }

    /**
     * @param servicioTiendas the servicioTiendas to set
     */
    public void setServicioTiendas(Servicio servicioTiendas) {
        this.servicioTiendas = servicioTiendas;
    }
    
    
}
