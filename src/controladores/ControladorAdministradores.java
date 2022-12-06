/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import javax.print.ServiceUI;
import modelos.Administrador;
import modelos.Producto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class ControladorAdministradores {
    
    // Atributos ControladorAdministradores
    private Servicio miServicioAdministradores;

    // Método constructor de la clase ControladorAdministradores
    public ControladorAdministradores(Servicio miServicioAdministradores) {
        this.miServicioAdministradores = miServicioAdministradores;
    }
    
    /**
     * Crea un objeto JSON a base de una instacnia de administrador y lo subo a la DB
     * @param elAdministrador - Obejto a transformar en JSON
     * @return validacion de si se creo o no
     */
    public boolean crear(Administrador elAdministrador) {
        boolean creado = false;
        String respuesta = miServicioAdministradores.POST("administradores", elAdministrador.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject adminJSON = (JSONObject) parser.parse(respuesta);
            elAdministrador = new Administrador();
            elAdministrador.toObject(adminJSON);
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
    public Administrador ver(String id) {
        Administrador elAdministrador = null;
        String respuesta = miServicioAdministradores.GET("administradores/" + id);
        try {
            JSONParser pasrser = new JSONParser();
            JSONObject adminJSON = (JSONObject) pasrser.parse(respuesta);
            elAdministrador = new Administrador();
            elAdministrador.toObject(adminJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return elAdministrador;
    }
    
    /**
     * Método encargado de traer todos los datos de la ruta 'administradores'
     * @return LinkedList con los objetos
     */
    public LinkedList<Administrador> listar() {
        LinkedList<Administrador> losAdministradores = new LinkedList<>();
        String respuesta =  this.miServicioAdministradores.GET("administradores");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray productosJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : productosJSON) {
                Administrador adminTemporal = new Administrador();
                adminTemporal.toObject((JSONObject) actual);
                losAdministradores.add(adminTemporal);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return losAdministradores;
    }
    
    /**
     * Edita una instancia de administrador y la sube a la base de datos haviendo uso del ID
     * @param elAdministrador - administrador editado
     * @return validacion de si se encontro y edito el objeto
     */
    public boolean editar(Administrador elAdministrador) {
        boolean editado = false;
        String respuesta = miServicioAdministradores.PUT("administradores/"+elAdministrador.getId(), elAdministrador.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject adminJSON = (JSONObject) parser.parse(respuesta);
            elAdministrador = new Administrador();
            elAdministrador.toObject(adminJSON);
            editado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return editado;
    }
    
    /**
     * Elimina una instancia de administrado querida por el usuario
     * @param administrador -  Administrador a eliminar
     * @return validacion de si se elimino o no
     */
    public boolean eliminar(Administrador administrador) {
        boolean eliminado =false;
        String respuesta =miServicioAdministradores.DELETE("administradores/" + administrador.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }

    // Setters and Getters
    
    /**
     * @return the miServicioAdministradores
     */
    public Servicio getMiServicioAdministradores() {
        return miServicioAdministradores;
    }

    /**
     * @param miServicioAdministradores the miServicioAdministradores to set
     */
    public void setMiServicioAdministradores(Servicio miServicioAdministradores) {
        this.miServicioAdministradores = miServicioAdministradores;
    }
    
}
