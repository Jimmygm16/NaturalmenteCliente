/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import modelos.Compra;
import modelos.Planta;
import modelos.Producto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class ControladorProductos {
    
    // Atributos ControladorPlantas
    private Servicio servicioProductos;

    // Método constructor ControladorPlantas
    public ControladorProductos(Servicio servicioProductos) {
        this.servicioProductos = servicioProductos;
    }
    
    public boolean crear(Producto elProducto) {
        boolean creado = false;
        String respuesta = servicioProductos.POST("productos", elProducto.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject elProductoJSON = (JSONObject) parser.parse(respuesta);
            elProducto = new Producto();
            elProducto.toObject(elProductoJSON);
            creado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return creado;
    }
    
    public boolean agregarProductoAcompra(Producto p, Compra c){
        boolean agregado = false;
        String respuesta = servicioProductos.PUT("productos/"+p.getId()+"/compras/"+c.getId(), c.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            p = new Producto();
            p.toObject(plantaJSON);
            agregado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return agregado;
    }
    /**
     * Devuelve una instancia de administrador seleccionada por el usuario
     * @param id - id del administrador
     * @return El objeto, si es que lo encuentra en el proceso
     */
    public Producto ver(String id) {
        Producto elProducto = null;
        String respuesta = servicioProductos.GET("productos/" + id);
        try {
            JSONParser parser = new JSONParser();
            JSONObject productoJSON = (JSONObject) parser.parse(respuesta);
            elProducto = new Producto();
            elProducto.toObject(productoJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return elProducto;
    }
    
    public LinkedList<Producto> produtosEncompra(String idCompra){
        LinkedList<Producto> productos = new LinkedList<>();
        String res = servicioProductos.GET("productos/compras/" + idCompra);
        try {
            JSONParser parser = new JSONParser();
            JSONArray productoJSON = (JSONArray) parser.parse(res);
            for (Object object : productoJSON) {
                Producto aux = new Producto();
                aux.toObject((JSONObject)object);
                productos.add(aux);
            }
        } catch (Exception e) {
            System.err.println("error");
        }
        return productos;
    }
 
    /**
     * Método encargado de traer todos los datos de la ruta 'productos'
     * @return LinkedList con los objetos
     */
    public LinkedList<Producto> listar() {
        LinkedList<Producto> losProductos= new LinkedList<>();
        String respuesta =  this.servicioProductos.GET("productos");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray productosJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : productosJSON) {
                Producto productoTemporal = new Producto();
                productoTemporal.toObject((JSONObject) actual);
                losProductos.add(productoTemporal);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return losProductos;
    }
    
    public boolean editar(Producto elProducto) {
        boolean editado = false;
        String respuesta = servicioProductos.PUT("productos/"+elProducto.getId(), elProducto.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject productoJSON = (JSONObject) parser.parse(respuesta);
            elProducto = new Producto();
            elProducto.toObject(productoJSON);
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
    public boolean eliminar(Producto elProducto) {
        boolean eliminado =false;
        String respuesta = servicioProductos.DELETE("productos/" + elProducto.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }

    // Setters and Getters
    
    /**
     * @return the servicioProductos
     */
    public Servicio getServicioProductos() {
        return servicioProductos;
    }

    /**
     * @param servicioProductos the servicioProductos to set
     */
    public void setServicioProductos(Servicio servicioProductos) {
        this.servicioProductos = servicioProductos;
    }
    
    
    
}
