/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import modelos.Cliente;
import modelos.Compra;
import modelos.Planta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class ControladorCompras {
    
    // Atributos ServicioClientes
    private Servicio ServicioCompras;

    // Método constructor ServicioClientes
    public ControladorCompras(Servicio ServicioCompras) {
        this.ServicioCompras = ServicioCompras;
    }
    
    public boolean agregarCompraAcliente(Compra laCompra, Cliente elCliente){
        boolean agregado = false;
        String respuesta = ServicioCompras.POST("compras/clientes"+elCliente.getId(), elCliente.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            laCompra = new Compra();
            laCompra.toObject(plantaJSON);
            agregado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return agregado;
    }
    
    /**
     * Crea un objeto JSON a base de una instacnia de compra y lo subo a la DB
     * @param laCompra - la instancia de compra a crear
     * @return validacion de si se creo o no
     */
    public Compra crear(Compra laCompra, Cliente elCliente) {
        boolean creado = false;
        String respuesta = ServicioCompras.POST("compras/clientes/"+elCliente.getId(), laCompra.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject compraJSON = (JSONObject) parser.parse(respuesta);
            laCompra = new Compra();
            laCompra.toObject(compraJSON);
            return laCompra;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return null;
    }
    
    /**
     * Devuelve una instancia de compra seleccionada por el usuario
     * @param id - id del administrador
     * @return El objeto, si es que lo encuentra en el proceso
     */
    public Compra ver(String id) {
        Compra laCompra = null;
        String respuesta = ServicioCompras.GET("compras/" + id);
        try {
            JSONParser pasrser = new JSONParser();
            JSONObject compraJSON = (JSONObject) pasrser.parse(respuesta);
            laCompra = new Compra();
            laCompra.toObject(compraJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return laCompra;
    }
    
    public Compra comprasEnCLiente(String idCliente){
        Compra compra = new Compra();
        String res = ServicioCompras.GET("compras/clientes/" + idCliente);
        try {
            JSONParser parser = new JSONParser();
            JSONObject comprasJSON = (JSONObject) parser.parse(res);
            compra.toObject((JSONObject)comprasJSON);
        } catch (Exception e) {
            System.err.println("error");
        }
        return compra;
    }
    /**
     * Método encargado de traer todos los datos de la ruta 'compras'
     * @return LinkedList con los objetos
     */
    public LinkedList<Compra> listar() {
        LinkedList<Compra> lasCompras= new LinkedList<>();
        String respuesta =  this.ServicioCompras.GET("compras");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray comprasJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : comprasJSON) {
                Compra compraActual = new Compra();
                compraActual.toObject((JSONObject) actual);
                lasCompras.add(compraActual);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return lasCompras;
    }
    
    /**
     * Edita una instancia de administrador y la sube a la base de datos haviendo uso del ID
     * @param laCompra
     * @return validacion de si se encontro y edito el objeto
     */
    public boolean editar(Compra laCompra) {
        boolean editado = false;
        String respuesta = ServicioCompras.PUT("compras/"+laCompra.getId(), laCompra.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject compraJSON = (JSONObject) parser.parse(respuesta);
            laCompra = new Compra();
            laCompra.toObject(compraJSON);
            editado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return editado;
    }
    
    /**
     * Elimina una instancia de administrado querida por el usuario
     * @param laCompra
     * @return validacion de si se elimino o no
     */
    public boolean eliminar(Compra laCompra) {
        boolean eliminado =false;
        String respuesta = ServicioCompras.DELETE("compras/" + laCompra.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }

    // Setters and Getters
    
    /**
     * @return the ServicioCompras
     */
    public Servicio getServicioCompras() {
        return ServicioCompras;
    }

    /**
     * @param ServicioCompras the ServicioCompras to set
     */
    public void setServicioCompras(Servicio ServicioCompras) {
        this.ServicioCompras = ServicioCompras;
    }
    
    
}
