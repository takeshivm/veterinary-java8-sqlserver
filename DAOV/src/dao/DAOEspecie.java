
package dao;

import accesoDatos.Conexion;
import entidades.Especie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOEspecie {
    
    public List<Especie> listar() throws Exception{
        List<Especie> especies;
        Especie esp;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select E.Id_Especie, E.Nombre_Especie, E.Descripcion " +
                        "from ESPECIE E " +
                        "order by E.Nombre_Especie";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            especies = new ArrayList<>();
            while (rs.next() == true) {
                esp = new Especie();
                esp.setCodigo(rs.getInt("Id_Especie"));
                esp.setNombre(rs.getString("Nombre_Especie"));
                esp.setDescripcion(rs.getString("Descripcion"));
                
                especies.add(esp);
            };
        } catch (Exception e) {
            throw e;
        }finally{
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.isClosed();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.isClosed();
            }
            cn = null;
        }
        return especies;
    }
    
}
