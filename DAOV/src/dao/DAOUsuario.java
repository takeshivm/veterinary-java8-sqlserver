package dao;

import accesoDatos.Conexion;
import entidades.Propietario;
import entidades.RegistroUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {
    
    public void registrar(RegistroUsuario usuario) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        sql = "insert into USUARIO(Nombres, Apellidos, Usuario, Contraseña, Estado)" +
                "values('"+usuario.getNombres()
                +"','"+usuario.getApellidos()
                +"','"+usuario.getUsuario()
                +"','"+usuario.getContraseña()
                +"',"+(usuario.isEstado() == true ? "1" : "0")
                +")";
        
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
    
    public void actualizar(RegistroUsuario usuario) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        
        sql = "Update USUARIO set Nombres = '"+ usuario.getNombres()
                +"', Apellidos = '"+usuario.getApellidos()
                +"', Usuario = '"+usuario.getUsuario()
                +"', Contraseña = '"+usuario.getContraseña()
                +"',Estado = "+(usuario.isEstado() == true ? "1" : "0")+" " +
                "where Id_Usuario = "+usuario.getCodigo();
        

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
    
    public List<RegistroUsuario> listar() throws Exception{
        List<RegistroUsuario> usuarios;
        RegistroUsuario usr;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select U.Id_Usuario, U.Nombres, U.Apellidos, U.Usuario, U.Contraseña, U.Estado " +
                        "from USUARIO U " +
                        "order by U.Nombres";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            usuarios = new ArrayList<>();
            while (rs.next() == true) {
                usr = new RegistroUsuario();
                usr.setCodigo(rs.getInt("Id_Usuario"));
                usr.setNombres(rs.getString("Nombres"));
                usr.setApellidos(rs.getString("Apellidos"));
                usr.setUsuario(rs.getString("Usuario"));
                usr.setContraseña(rs.getString("Contraseña"));
                usr.setEstado(rs.getBoolean("Estado"));
                
                usuarios.add(usr);
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
        return usuarios;
    }
    
    public RegistroUsuario leer(RegistroUsuario usuario) throws Exception{
        
        RegistroUsuario usr = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select U.Nombres, U.Apellidos, U.Usuario, U.Contraseña, U.Estado " +
                        "from USUARIO U " +
                        "where U.Id_Usuario = " + usuario.getCodigo();
       
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                usr = new RegistroUsuario();
                usr.setCodigo(usuario.getCodigo());
                usr.setNombres(rs.getString("Nombres"));
                usr.setApellidos(rs.getString("Apellidos"));
                usr.setUsuario(rs.getString("Usuario"));
                usr.setContraseña(rs.getString("Contraseña"));
                usr.setEstado(rs.getBoolean("Estado"));
                
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
            
            return usr;
        }
    }
    
}
