package Negocio;

import Dato.DViatico;
import Dato.Viatico;
import java.util.ArrayList;

/**
 *
 * @author Oni
 */
public class NViatico {
     private DViatico dviatico;

    public NViatico() {
        this.dviatico = new DViatico();
    }

    public String listar(String id) {
        String mensaje = "Error de parametros tiene : " + id + " deberia ser numerico";
        if (esNumero(id)) {
            ArrayList<Viatico> lista = dviatico.listar(Integer.valueOf(id));
            if (!lista.isEmpty()) {
                String res = "<h2> Lista de Viatico </h2>\n"
                        + "<table border=1>\n"
                        + "<tr>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">ID</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Monto</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Fecha</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Razon</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Usser_id</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre</td>"
                        + "</tr>\n";
                for (Viatico viatico : lista) {
                    res += viatico.toString();
                }
                res += "</table>";
                return res;
            } else {
                mensaje = "El Viatico no encontrado";
            }
        }
        return mensaje;
    }

    public String crear(String[] parametros) {
        String mensaje = "Error de parametros tien : " + parametros.length + " deberia ser solo 4";
        if (parametros.length == 4 && esNumero(parametros[3])) {
            if (dviatico.crear(Integer.valueOf(parametros[0]), parametros[1],parametros[2],Integer.valueOf(parametros[3]))) {
                return successMessage("Viatico Registrado exitosamente!!");
            }
            mensaje = "Error al insertar el Viatico";
        }
        return errorMessage(mensaje);
    }

    public String editar(String[] parametros) {
        String mensaje = "Error de parametros tiene : " + parametros.length + " deberia ser solo 5";
        if (parametros.length == 5 && esNumero(parametros[0]) && esNumero(parametros[4])) {
            if (dviatico.editar(Integer.valueOf(parametros[0]),Integer.valueOf(parametros[1]), parametros[2],parametros[3],Integer.valueOf(parametros[4]))) {
                return successMessage("Viatico editado exitosamente!!");
            }
            mensaje = "Error al editar el Usuario";
        }
        return errorMessage(mensaje);
    }

    public String eliminar(String id) {
        String mensaje = "Error de parametros tiene : " + id + " deberia ser numerico";
        if (esNumero(id)) {
            if (dviatico.eliminar(Integer.valueOf(id))) {
                return successMessage("Usuario eliminado exitosamente!!");
            }
            mensaje = "Error al eliminar el Usuario";
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
