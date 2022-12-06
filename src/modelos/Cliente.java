/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.simple.JSONObject;

/**
 *
 * @author jpgonzalez
 */
public class Cliente extends Usuario {
    
    // Atributos clase Cliente
    private String _id;
    private Compra mi_compra;
    
    // Métodos constructores de la Clase Cliente
    public Cliente(String nombre, String cedula, String correo, String telefono) {
        super(nombre, cedula, correo, telefono);
        this.mi_compra = new Compra();
    }
    
    public Cliente() {
    }
    
    @Override
    public void toObject(JSONObject clienteJSON) {
        this.setId((String) clienteJSON.get("_id"));
        this.setNombre((String) clienteJSON.get("nombre"));
        this.setCedula((String) clienteJSON.get("cedula"));
        this.setCorreo((String) clienteJSON.get("correo"));
        this.setTelefono((String) clienteJSON.get("telefono"));
    }
    
    @Override
    public JSONObject toJSON() {
        JSONObject clienteJSON = new JSONObject();
        clienteJSON.put("nombre", this.getNombre());
        clienteJSON.put("cedula", this.getCedula());
        clienteJSON.put("correo", this.getCorreo());
        clienteJSON.put("telefono", this.getTelefono());
        return clienteJSON;
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

    public Compra getMi_compra() {
        return mi_compra;
    }

    public void setMi_compra(Compra mi_compra) {
        this.mi_compra = mi_compra;
    }
    
    public void comprar(Producto p){
        boolean encontro = false;
        p.setExistencia(1);
        for (int i = 0; i < this.mi_compra.productos.size();i++) {
            Producto temp = this.mi_compra.productos.get(i);
            if (temp.getNombre() == p.getNombre()){
                temp.setExistencia(temp.getExistencia() + 1);
                encontro = true;
            }
        }
        if (!encontro){
            this.mi_compra.productos.add(p);
        }
    }

    
}
