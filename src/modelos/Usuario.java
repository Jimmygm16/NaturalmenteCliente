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
public abstract class Usuario {
    
    // Atributos de la clase Usuario
    private String nombre;
    private String cedula;
    private String correo;
    private String telefono;
    
    //Métodos constructores de la clase Usuario
    public Usuario(String nombre, String cedula, String correo, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Usuario(){ 
        
    }

    /**
     * Método encargado de generar un obejtoa  traves de un JSON
     * @param objetoJSON 
     */
    public abstract void toObject(JSONObject objetoJSON);
    
    /**
     * Crea un objeto JSON a partitr de una instancia de obejto
     * @return 
     */
    public abstract JSONObject toJSON();
    
    // Setters and Getters

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
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
