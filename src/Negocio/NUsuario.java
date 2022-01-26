package Negocio;

import Dato.DUsuario;
import Dato.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Oni
 */
public class NUsuario {
    private DUsuario dusuario;

    public NUsuario() {
        this.dusuario = new DUsuario();
    }
    
    public ArrayList<Usuario> buscarCorreo(String correo){
        return dusuario.buscarCorreo(correo);
    }

    public String listar(String id) {
        String mensaje = "Error de parametros tiene : " + id + " deberia ser numerico";
        if (esNumero(id)) {
            ArrayList<Usuario> lista = dusuario.listar(Integer.valueOf(id));
            if (!lista.isEmpty()) {
                String res = "<h2> Lista de Usuario </h2>\n"
                        + "<table border=1>\n"
                        + "<tr>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">ID</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Apellido</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">CI</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Correo</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Rold_id</td>"
                        + "<td align=\"center\"valign=\"top\"  bgcolor=\"#178ffa\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">Nombre_rol</td>"
                        + "</tr>\n";
                for (Usuario user : lista) {
                    res += user.toString();
                }
                res += "</table>";
                return res;
            } else {
                mensaje = "El Usuario no encontrado";
            }
        }
        return mensaje;
    }

    public String crear(String[] parametros) {
        String mensaje = "Error de parametros tien : " + parametros.length + " deberia ser solo 6";
        if (parametros.length == 6 && esNumero(parametros[5])) {
            if (dusuario.crear(parametros[0], parametros[1],Integer.valueOf(parametros[2]),parametros[3],parametros[4],Integer.valueOf(parametros[5]))) {
                return successMessage("Usuario Registrado exitosamente!!");
            }
            mensaje = "Error al insertar el Usuario";
        }
        return errorMessage(mensaje);
    }

    public String editar(String[] parametros) {
        String mensaje = "Error de parametros tiene : " + parametros.length + " deberia ser solo 7";
        if (parametros.length == 7 && esNumero(parametros[0]) && esNumero(parametros[6])) {
            if (dusuario.editar(Integer.valueOf(parametros[0]),parametros[1], parametros[2],Integer.valueOf(parametros[3]),parametros[4],parametros[5],Integer.valueOf(parametros[6]))) {
                return successMessage("Usuario editado exitosamente!!");
            }
            mensaje = "Error al editar el Usuario";
        }
        return errorMessage(mensaje);
    }

    public String eliminar(String id) {
        String mensaje = "Error de parametros tiene : " + id + " deberia ser numerico";
        if (esNumero(id)) {
            if (dusuario.eliminar(Integer.valueOf(id))) {
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
