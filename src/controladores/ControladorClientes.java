/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import modelos.Cliente;
import modelos.Producto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class ControladorClientes {
    
    // Atributos de ControladorClientes
    private Servicio miServicioClientes;

    // Método constructor de ControladorClientes
    public ControladorClientes(Servicio miServicioClientes) {
        this.miServicioClientes = miServicioClientes;
    }
    
    /**
     * Crea un objeto JSON a base de una instacnia de Cliente y lo subo a la DB
     * @param elCliente -  cliente a crear
     * @return validacion de si se creo o no
     */
    public boolean crear(Cliente elCliente) {
        boolean creado = false;
        String respuesta = miServicioClientes.POST("clientes", elCliente.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject clienteJSON = (JSONObject) parser.parse(respuesta);
            elCliente = new Cliente();
            elCliente.toObject(clienteJSON);
            creado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return creado;
    }
    
    /**
     * Devuelve una instancia de cliente seleccionada por el usuario
     * @param id - id del cliente
     * @return El objeto, si es que lo encuentra en el proceso
     */
    public Cliente ver(String id) {
        Cliente elCliente = null;
        String respuesta = miServicioClientes.GET("clientes/" + id);
        try {
            JSONParser pasrser = new JSONParser();
            JSONObject clienteJSON = (JSONObject) pasrser.parse(respuesta);
            elCliente = new Cliente();
            elCliente.toObject(clienteJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return elCliente;
    }
    
    /**
     * Método encargado de traer todos los datos de la ruta 'clientes'
     * @return LinkedList con los objetos
     */
    public LinkedList<Cliente> listar() {
        LinkedList<Cliente> losClientes = new LinkedList<>();
        String respuesta =  this.miServicioClientes.GET("clientes");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray clientesJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : clientesJSON) {
                Cliente clienteTemporal = new Cliente();
                clienteTemporal.toObject((JSONObject) actual);
                losClientes.add(clienteTemporal);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return losClientes;
    }
    
    /**
     * Edita una instancia de Cliente y la sube a la base de datos haviendo uso del ID
     * @param elCliente - El cliente a editar
     * @return validacion de si se encontro y edito el objeto
     */
    public boolean editar(Cliente elCliente) {
        boolean editado = false;
        String respuesta = miServicioClientes.PUT("clientes/"+elCliente.getId(), elCliente.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject clienteJSON = (JSONObject) parser.parse(respuesta);
            elCliente = new Cliente();
            elCliente.toObject(clienteJSON);
            editado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return editado;
    }
    
    /**
     * Elimina una instancia de Cliente querida por el usuario
     * @param cliente - El cliente a eliminar
     * @return validacion de si se elimino o no
     */
    public boolean eliminar(Cliente cliente) {
        boolean eliminado =false;
        String respuesta = miServicioClientes.DELETE("clientes/" + cliente.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }

    // Setters and Getters
    
    /**
     * @return the miServicioClientes
     */
    public Servicio getMiServicioClientes() {
        return miServicioClientes;
    }

    /**
     * @param miServicioClientes the miServicioClientes to set
     */
    public void setMiServicioClientes(Servicio miServicioClientes) {
        this.miServicioClientes = miServicioClientes;
    }

    
    
}
