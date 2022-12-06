/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.LinkedList;
import modelos.Administrador;
import modelos.Cliente;
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
public class ControladorPlantas {
    
    // Atributos clase ControladorPlantas
    private Servicio ServicioPlantas;

    // Método constructor de la clase ControladorPlantas
    public ControladorPlantas(Servicio ServicioPlantas) {
        this.ServicioPlantas = ServicioPlantas;
    }
    
    /**
     * Crea un objeto JSON a base de una instacnia de administrador y lo subo a la DB
     * @param elAdministrador - Obejto a transformar en JSON
     * @return validacion de si se creo o no
     */
    public boolean crear(Planta laPlanta) {
        boolean creado = false;
        String respuesta = ServicioPlantas.POST("plantas", laPlanta.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            laPlanta = new Planta();
            laPlanta.toObject(plantaJSON);
            creado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return creado;
    }
    
    public boolean agregarPlantaAProducto(Planta laPlanta, Producto elProducto){
        boolean agregado = false;
        String respuesta = ServicioPlantas.PUT("plantas/"+laPlanta.getId()+"/productos/"+elProducto.getId(), elProducto.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            laPlanta = new Planta();
            laPlanta.toObject(plantaJSON);
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
    public Planta ver(String id) {
        Planta laPlanta = null;
        String respuesta = ServicioPlantas.GET("plantas/" + id);
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            laPlanta = new Planta();
            laPlanta.toObject(plantaJSON);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return laPlanta;
    }
    
    public LinkedList<Planta> plantasEnProducto(String idProducto){
        LinkedList<Planta> plantas = new LinkedList<>();
        String res = ServicioPlantas.GET("plantas/productos/" + idProducto);
        try {
            JSONParser parser = new JSONParser();
            JSONArray plantasJSON = (JSONArray) parser.parse(res);
            for (Object object : plantasJSON) {
                Planta aux = new Planta();
                aux.toObject((JSONObject)object);
                plantas.add(aux);
            }
        } catch (Exception e) {
            System.err.println("error");
        }
        return plantas;
    }
    
    /**
     * Método encargado de traer todos los datos de la ruta 'plantas'
     * @return LinkedList con los objetos
     */
    public LinkedList<Planta> listar() {
        LinkedList<Planta> lasPlantas = new LinkedList<>();
        String respuesta =  this.ServicioPlantas.GET("plantas");
        System.err.println("" + respuesta);
        try {
            JSONParser parser = new JSONParser();
            JSONArray plantasJSON = (JSONArray) parser.parse(respuesta);
            for(Object actual : plantasJSON) {
                Planta plantaTemporal = new Planta();
                plantaTemporal.toObject((JSONObject) actual);
                lasPlantas.add(plantaTemporal);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return lasPlantas;
    }
    
    /**
     * Edita una instancia de administrador y la sube a la base de datos haviendo uso del ID
     * @param laPlanta
     * @return validacion de si se encontro y edito el objeto
     */
    public boolean editar(Planta laPlanta) {
        boolean editado = false;
        String respuesta = ServicioPlantas.PUT("plantas/"+laPlanta.getId(), laPlanta.toJSON());
        try {
            JSONParser parser = new JSONParser();
            JSONObject plantaJSON = (JSONObject) parser.parse(respuesta);
            laPlanta = new Planta();
            laPlanta.toObject(plantaJSON);
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
    public boolean eliminar(Planta laPlanta) {
        boolean eliminado =false;
        String respuesta = ServicioPlantas.DELETE("plantas/" + laPlanta.getId());
        try {
            eliminado = true;
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return eliminado;
    }

    // Setters and Getters
    
    /**
     * @return the ServicioPlantas
     */
    public Servicio getServicioPlantas() {
        return ServicioPlantas;
    }

    /**
     * @param ServicioPlantas the ServicioPlantas to set
     */
    public void setServicioPlantas(Servicio ServicioPlantas) {
        this.ServicioPlantas = ServicioPlantas;
    }
    
    
}
