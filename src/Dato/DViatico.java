package Dato;

import DB.Conexion;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Oni
 */
public class DViatico {
    private Conexion con;

    public DViatico() {
        this.con = Conexion.getInstancia();
    }
    
    public ArrayList<Viatico> listar(int id){
        ArrayList<Viatico> lista = new ArrayList<>();
        try {
            String query = (id == 0) ?"SELECT viaticos.id, viaticos.monto, viaticos.fecha, viaticos.razon, viaticos.user_id, users.nombre"
                    + " FROM viaticos, users WHERE viaticos.user_id = users.id;" 
                    : "SELECT viaticos.id, viaticos.monto, viaticos.fecha, viaticos.razon, viaticos.user_id, users.nombre "
                    + "FROM viaticos, users WHERE viaticos.user_id = users.id and viaticos.id = "+id;
            PreparedStatement pre = con.conectar().prepareStatement(query);
            ResultSet result = pre.executeQuery();
            while(result.next()){
                lista.add(new Viatico(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6)));
            }
            pre.close();
        } catch (Exception e) {
            System.out.println("Error DViatico : "+e);
        }
        finally{
            con.desconectar();
        }
        return lista;
    }
    
    public boolean crear(int monto, String fecha, String razon, int user_id){
        String query = "insert into viaticos (monto,fecha,razon,user_id,created_at,updated_at) values(?,'"+fecha+"',?,?,now(),now())";
        try {
            DUsuario usuario = new DUsuario();
            if (usuario.listar(user_id).isEmpty()){
                return false;
            }
            PreparedStatement pre = con.conectar().prepareStatement(query);
            pre.setInt(1, monto);
            pre.setString(2, razon);
            pre.setInt(3, user_id);
            pre.execute();
            pre.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error DViatico crear : "+e);
        }finally{
            con.desconectar();
        }
        return false;
    }
    
    public boolean editar(int id, int monto, String fecha, String razon, int user_id){
        String query = "UPDATE viaticos SET monto = ?, fecha = '"+fecha+"', razon = ?, user_id = ?, updated_at = now()  WHERE id = ? ";
        try {
            DUsuario user = new DUsuario();
            if (listar(id).isEmpty() && user.listar(user_id).isEmpty()){
                return false;
            }
            PreparedStatement pre = con.conectar().prepareStatement(query);
            pre.setInt(1, monto);
            pre.setString(2, razon);
            pre.setInt(3, user_id);
            pre.setInt(4, id);
            pre.executeUpdate();
            pre.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error DViatico editar : "+e);
        }finally{
            con.desconectar();
        }
        return false;
    }
    
    public boolean eliminar(int id){
        String query = "delete from viaticos where id = ?";
        try {
            if (listar(id).isEmpty()){
                return false;
            }
            PreparedStatement pre = con.conectar().prepareStatement(query);
            pre.setInt(1, id);
            pre.execute();
            pre.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error DViatico eliminar : "+e);
        }finally{
            con.desconectar();
        }
        return false;
    }
}
