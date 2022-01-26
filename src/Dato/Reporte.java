/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.util.ArrayList;

/**
 *
 * @author Christian Vargas
 */
public class Reporte {
    private int id;
    private String direccion;
    private String codigo;
    private String tipo;
    private String estado;
    private int plan_id;
    private int idUser;
    private String nombre_tecnico;
    private String apellido;
    private int ci;
    private String correo;
    private int rol_id;
    private int servicio_id;
    private int user_id;
    
    private String plan_nombre;

    public Reporte(int id, String direccion, String codigo, String tipo, String estado, int plan_id) {
        this.id = id;
        this.direccion = direccion;
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = estado;
        this.plan_id = plan_id;
    }

    public Reporte(String direccion, String codigo, String tipo, String nombre_tecnico) {
        this.direccion = direccion;
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre_tecnico = nombre_tecnico;
    }

    public Reporte(String direccion, String codigo, String tipo, String nombre_tecnico, String plan_nombre) {
        this.direccion = direccion;
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre_tecnico = nombre_tecnico;
        this.plan_nombre = plan_nombre;
    }

    public Reporte(String direccion, String codigo, String plan_nombre) {
        this.direccion = direccion;
        this.codigo = codigo;
        this.plan_nombre = plan_nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_nombre() {
        return plan_nombre;
    }

    public void setPlan_nombre(String plan_nombre) {
        this.plan_nombre = plan_nombre;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre_tecnico() {
        return nombre_tecnico;
    }

    public void setNombre_tecnico(String nombre_tecnico) {
        this.nombre_tecnico = nombre_tecnico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
