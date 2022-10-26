
package dao;

import accesoDatos.Conexion;
import entidades.Medico;
import entidades.RegistroUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOMedico {
    
    public void registrar(Medico medico) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        sql = "insert into MEDICO(Nombre, Apellido, Especialidad, Estado) " +
                "values('"+medico.getNombre()
                +"','"+medico.getApellido()
                +"','"+medico.getEspecialidad()
                +"',"+(medico.isEstado() == true ? "1" : "0")+")";
        
        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
    }
    
    public void actualizar(Medico medico) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        sql = "Update MEDICO set Nombre = '"+medico.getNombre()
                +"', Apellido = '"+medico.getApellido()
                +"', Especialidad = '"+medico.getEspecialidad()
                +"', Estado = "+(medico.isEstado() == true ? "1" : "0") +
                " where Codigo_Medico = "+medico.getCodigo();
        

         con = new Conexion();
         try {
            cn = con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
            
            }catch(Exception e){
                throw e;
        }finally{
             if (st != null && st.isClosed() == false) {
                 st.close();
             }
             st = null;
             
             if (cn != null && cn.isClosed() == false) {
                 cn.close();
             }
             cn = null;
        }
    }
    
    public List<Medico> listar(String nombre) throws Exception{
        List<Medico> medicos;
        Medico med;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select M.Codigo_Medico, M.Nombre, M.Apellido, M.Especialidad, M.Estado " +
                        "from MEDICO M " +
                        "where M.Nombre like '"+nombre+"%'"+
                        "order by M.Nombre";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            medicos = new ArrayList<>();
            while (rs.next() == true) {
                med = new Medico();
                med.setCodigo(rs.getInt("Codigo_Medico"));
                med.setNombre(rs.getString("Nombre"));
                med.setApellido(rs.getString("Apellido"));
                med.setEspecialidad(rs.getString("Especialidad"));
                med.setEstado(rs.getBoolean("Estado"));
                
                medicos.add(med);
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
        return medicos;
    }
    
    public Medico leer(Medico medico) throws Exception{
        
        Medico med = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select M.Codigo_Medico, M.Nombre, M.Apellido, M.Especialidad, M.Estado " +
                        "from MEDICO M " +
                        "where M.Codigo_Medico =" + medico.getCodigo();
       
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                med = new Medico();
                med.setCodigo(medico.getCodigo());
                med.setNombre(rs.getString("Nombre"));
                med.setApellido(rs.getString("Apellido"));
                med.setEspecialidad(rs.getString("Especialidad"));
                med.setEstado(rs.getBoolean("Estado"));
                
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
            
            return med;
        }
    }
    
}
