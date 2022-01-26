/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DReporte;
import Dato.Reporte;
import java.util.ArrayList;

/**
 *
 * @author Christian Vargas
 */
public class NReporte {
    private DReporte dreporte;

    public NReporte() {
        this.dreporte = new DReporte();
    }
    
    public String reporteServicioPlan(){
        ArrayList<Reporte> reporte = new ArrayList<>();
        reporte = dreporte.listar();
        if(reporte.size()>0){
            String s_res = "<h2>Reporte de servicios por plan</h2>";
            s_res = s_res + "<table border=1>"
                        + "<tr>" 
                        + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Direccion</th>"
                        + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Codigo</th>"
                        + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre del plan</th>"
                        + "</tr>";
            for (Reporte reporte1 : reporte) {
                s_res = s_res + "<tr>";
                s_res = s_res + "<td>" + reporte1.getDireccion() + "</td>";
                s_res = s_res + "<td>" + reporte1.getCodigo()+ "</td>";
                s_res = s_res + "<td>" + reporte1.getPlan_nombre()+ "</td>";
                s_res = s_res + "</tr>";
            }
            s_res = s_res + "</table>";
            return s_res;
        }
        return errorMessage("Parametros incorrectos");
    }
    
    public String resporteSignacionTecnico(){
        ArrayList<Reporte> reporte = new ArrayList<>();
        reporte = dreporte.listar2();
        if(reporte.size()>0){
            String s_res = "<h2>Reporte asignacion de servicio a tecnicos</h2>";
            s_res = s_res + "<table border=1>"
                    + "<tr>"
                    + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Direccion</th>"
                    + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Codigo</th>"
                    + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Tipo del plan</th>"
                    + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre del plan</th>"
                    + "<th align=\"center\"valign=\"top\"  bgcolor=\"#7FFFD4\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre del tecnico</th>"
                    + "</tr>";
            for (Reporte reporte1 : reporte) {
                s_res = s_res + "<tr>";
                s_res = s_res + "<td>" + reporte1.getDireccion()+ "</td>";
                s_res = s_res + "<td>" + reporte1.getCodigo()+ "</td>";
                s_res = s_res + "<td>" + reporte1.getTipo()+ "</td>";
                s_res = s_res + "<td>" + reporte1.getNombre_tecnico()+ "</td>";
                s_res = s_res + "<td>" + reporte1.getPlan_nombre()+ "</td>";
                s_res = s_res + "</tr>";
            }
            s_res = s_res + "</table>";
            return s_res;
        }
        return errorMessage("Parametros incorrectos");
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
