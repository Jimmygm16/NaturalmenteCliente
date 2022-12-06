/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import controladores.ControladorProductos;
import java.util.LinkedList;
import org.json.simple.JSONObject;

/**
 *
 * @author jpgonzalez
 */
public class Compra {
    
    // Atributos de la clase Compra
    private String _id;
    private String fecha;
    private long valor;
    Cliente miCliente; 
    LinkedList<Producto> productos;
    
    // Métodos constructores de la clase Compra
    public Compra(String fecha, long valor) {
        this.fecha = fecha;
        this.valor = valor; 
        this.productos = new LinkedList<>();
    }
    
    public Compra() {
        this.productos = new LinkedList<>();
    }
    
    public void toObject(JSONObject compraJSON) {
        this._id = (String) compraJSON.get("_id");
        this.fecha = (String) compraJSON.get("fecha");
        this.valor = (long) compraJSON.get("valor");
    }
    
    public JSONObject toJSON() {
        JSONObject compraJSON = new JSONObject();
        compraJSON.put("fecha", this.fecha);
        compraJSON.put("valor", this.valor);
        compraJSON.put("miCliente", this.miCliente);
        return compraJSON;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public Cliente getCliente() {
        return miCliente;
    }

    public void setCliente(Cliente cliente) {
        this.miCliente = cliente;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }
    
    
    
}
