/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author jpgonzalez
 */
public class Producto {
    
    // Atributos de la clase Producto
    private String _id;
    private String nombre;
    private String tipo;
    private long valor;
    private long existencia;
    private LinkedList<Planta> plantas;
    
    // Métodos constructores de la clase Producto
    public Producto(String nombre, String tipo, long valor, long existencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.existencia = existencia;
        this.plantas = new LinkedList<>();
    }
    
    public Producto() {
        this.plantas = new LinkedList<>();
    }
    
    public void toObject(JSONObject productoJSON) {
        this._id = (String) productoJSON.get("_id");
        this.nombre = (String) productoJSON.get("nombre");
        this.tipo = (String) productoJSON.get("tipo");
        this.valor = (long) productoJSON.get("valor");
        this.existencia = (long) productoJSON.get("existencia");
        
    }
    
    public JSONObject toJSON() {
        JSONObject productoJSON = new JSONObject();
        productoJSON.put("nombre", this.nombre);
        productoJSON.put("tipo", this.tipo);
        productoJSON.put("valor", this.valor);
        productoJSON.put("existencia", this.existencia);
        return productoJSON;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(long valor) {
        this.valor = valor;
    }

    /**
     * @return the existencia
     */
    public long getExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }

    /**
     * @return the plantas
     */
    public LinkedList<Planta> getPlantas() {
        return plantas;
    }

    /**
     * @param plantas the plantas to set
     */
    public void setPlantas(LinkedList<Planta> plantas) {
        this.plantas = plantas;
    }

}
