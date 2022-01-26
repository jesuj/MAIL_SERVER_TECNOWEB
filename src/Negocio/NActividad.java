/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.Actividad;
import Dato.DActividad;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Christian Vargas
 */
public class NActividad {
    private DActividad dactividad;

    public NActividad() {
        this.dactividad = new DActividad();
    }
    
    public String listar(String id){
        String mensaje = "Error de parametros tiene: " + id + "deberia ser un numero";
        if(esNumero(id)){
            ArrayList<Actividad> lista = dactividad.listar(Integer.valueOf(id));
            if(!lista.isEmpty()){
                String res = "<h2> Lista de Actividades </h2>\n"
                        + "<table border=1>\n"
                        + "<tr>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Inicio</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Fin</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Foto</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Estado</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Servicio</td>"
                        + "</tr>\n";
                for (Actividad actividad : lista) {
                    res += actividad.toString();
                }
                res += "</table>";
                return res;
            }else{
                mensaje = "La actividad no encontrada";
            }
        }
        return mensaje;
    }
    
    public String crear(String[] parametros){
        String mensaje = "Error de parametros tienen: "+parametros.length+" deberian ser 5 parametros";
        if(parametros.length == 5){
            if(this.dactividad.registrarActividad(Date.valueOf(parametros[0]), Date.valueOf(parametros[1]), parametros[2], parametros[3], Integer.valueOf(parametros[4]))){
                return successMessage("Actividad registrada exitosamente");
            }
            mensaje = "Error al insertar la actividad";
        }
        return errorMessage(mensaje);
    }
    
    public String editar(String[] parametros){
        String mensaje = "Error en los parametros tiene: "+parametros.length+" deberia ser solo 5 parametros";
        if(parametros.length == 5 && esNumero(parametros[0])){
            if(dactividad.editar(Integer.valueOf(parametros[0]), Date.valueOf(parametros[1]), Date.valueOf(parametros[2]), parametros[3], Integer.valueOf(parametros[4]))){
                return successMessage("Actividad editada exitosanmente");
            }
            mensaje = "Error al editar la actividad";
        }
        return errorMessage(mensaje);
    }
    
    public String eliminar(String id){
        String mensaje = "Error de parametros tiene: "+id+" deberia ser numerico";
        if(esNumero(id)){
            if(dactividad.eliminar(Integer.valueOf(id))){
                return successMessage("Actividad eliminada");
            }
            mensaje = "Error al eliminar la actividad";
        }
        return errorMessage(mensaje);
    }
    
    public boolean esNumero(String prt_parametros) {
        try {
            Integer.parseInt(prt_parametros);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String errorMessage(String parametro) {
        return "<div><strong>ERROR</strong><p>" + parametro + "</p></div>";
    }

    public String successMessage(String parametro) {
        return "<div><strong>EXITO</strong><p>" + parametro + "</p></div>";
    }
}
