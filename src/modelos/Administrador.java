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
public class Administrador extends Usuario { 
    
    private String _id;
    
    // Métodos constructores de la clase Administrador
    public Administrador(String nombre, String cedula, String correo, String telefono) {
        super(nombre, cedula, correo, telefono);
    }
    
    public Administrador() {
        
    }
    
    @Override
    public void toObject(JSONObject administradorJSON) {
        this.setNombre((String) administradorJSON.get("nombre"));
        this.setCedula((String) administradorJSON.get("cedula"));
        this.setCorreo((String) administradorJSON.get("correo"));
        this.setTelefono((String) administradorJSON.get("telefono"));
    }

    @Override
    public JSONObject toJSON() {
        JSONObject administradorJSON = new JSONObject();
        administradorJSON.put("nombre", this.getNombre());
        administradorJSON.put("cedula", this.getCedula());
        administradorJSON.put("correo", this.getCorreo());
        administradorJSON.put("telefono", this.getTelefono());
        return administradorJSON;
    }
    
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
}
