/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;
import DB.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Christian Vargas
 */
public class DReporte {
    private Conexion con;

    public DReporte() {
        this.con = Conexion.getInstancia();
    }
    
    public ArrayList<Reporte> listar(){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            String query = "SELECT servicios.direccion,servicios.codigo,plans.nombre FROM servicios,plans where servicios.plan_id = plans.id";
            PreparedStatement pre = con.conectar().prepareStatement(query);
            ResultSet resp = pre.executeQuery();
            while(resp.next()){
                lista.add(new Reporte(resp.getString(1), resp.getString(2), resp.getString(3)));
            }
            pre.close();
        } catch (Exception e) {
            System.out.println("Error DServicio "+e);
        }finally{
            con.desconectar();
        }
        return lista;
    }
    
    public ArrayList<Reporte> listar2(){
        ArrayList<Reporte> lista = new ArrayList<>();
        try {
            String query = "SELECT servicios.direccion as direccion, servicios.codigo as codigo,servicios.tipo as tipo,plans.nombre as plan,users.nombre as tecnico FROM servicios,users,asignacion_servicio,plans where servicios.id = asignacion_servicio.servicio_id and users.id = asignacion_servicio.user_id and servicios.plan_id = plans.id;";
            PreparedStatement pre = con.conectar().prepareStatement(query);
            ResultSet resp = pre.executeQuery();
            while(resp.next()){
                lista.add(new Reporte(resp.getString(1), resp.getString(2), resp.getString(3), resp.getString(4), resp.getString(5)));
            }
            pre.close();
        } catch (Exception e) {
            System.out.println("Error DServicio "+e);
        }finally{
            con.desconectar();
        }
        return lista;
    }
}
