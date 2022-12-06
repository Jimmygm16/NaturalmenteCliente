/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.LinkedList;
import org.json.simple.JSONObject;

/**
 *
 * @author jpgonzalez
 */
public class Tienda {
    
    // Atributos de la clase tienda
    private String _id;
    private String nombre;
    private String NIT;
    private String direccion;
    private LinkedList<Producto> productos;
    
    // Métodos constructores de la clase tienda
    public Tienda(String _id, String nombre, String NIT, String direccioon) {
        this._id = _id;
        this.nombre = nombre;
        this.NIT = NIT;
        this.direccion = direccioon;
        this.productos = new LinkedList<>();
    }
    
    public Tienda() {
        this.productos = new LinkedList<>();
    }
    
    public void toObject(JSONObject tiendaJSON) {
        this._id = (String) tiendaJSON.get("_id");
        this.nombre = (String) tiendaJSON.get("nombre");
        this.NIT = (String) tiendaJSON.get("NIT");
        this.direccion = (String) tiendaJSON.get("direccion");
    }
    
    public JSONObject toJSON() {
        JSONObject tiendaJSON = new JSONObject();
        tiendaJSON.put("nombre", this.nombre);
        tiendaJSON.put("NIT", this.NIT);
        tiendaJSON.put("direccion", this.direccion);
        return tiendaJSON;
    }

    // Setters y Getters
    
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
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the productos
     */
    public LinkedList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }
    
}
