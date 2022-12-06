/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import org.json.simple.JSONObject;

/**
 *
 * @author jpgonzalez
 */
public class Planta {
    
    // Atributos de la clase Planta
    private String _id;
    private String nombre;
    private String funcionalidad;
    
    // Métodos constructores de la clase Planta
    public Planta(String nombre, String funcionalidad) {
        this.nombre = nombre;
        this.funcionalidad = funcionalidad;
    }
    
    public Planta() {
        
    }
    
    /**
     * Genera un objeto de tipo planta a traves de un JSON Object
     * @param plantaJSON el JSON que se va a utilizar
     */
    public void toObject(JSONObject plantaJSON) {
        this._id = (String) plantaJSON.get("_id");
        this.nombre = (String) plantaJSON.get("nombre");
        this.funcionalidad = (String) plantaJSON.get("funcionalidad");
    }
    
    public JSONObject toJSON() {
        JSONObject plantaJSON = new JSONObject();
        plantaJSON.put("_id", this._id);
        plantaJSON.put("nombre", this.nombre);
        plantaJSON.put("funcionalidad", this.funcionalidad);
        return plantaJSON;
    }
    
    // Setters and Getters

    /**
     * @return the _id
     */
    public String getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(String _id) {
        this._id = _id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the funcionalidad
     */
    public String getFuncionalidad() {
        return funcionalidad;
    }

    /**
     * @param funcionalidad the funcionalidad to set
     */
    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }
    
}
