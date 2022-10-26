
package dao;

import accesoDatos.Conexion;
import entidades.Propietario;
import entidades.RegistroUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoPropietario {
    
    public void registrar(Propietario propietario) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        sql = "insert into PROPIETARIO(Nombres, Apellidos, Direccion, Telefono, DNI, Sexo, Email, Vigencia, Id_Usuario) " +
            " values('"+ propietario.getNombres() +
                "', '"+propietario.getApellidos() +
                "', '"+ propietario.getDireccion()+
                "', '"+propietario.getTelefono()+
                "', '"+propietario.getDNI()+
                "', '"+propietario.getSexo()+
                "', '"+propietario.getE_mail()+
                "', "+ (propietario.isVigencia() == true ? "1" : "0")+ ", " +
                propietario.getUsuario().getCodigo()+")";
        
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
    
    public void actualizar(Propietario propietario) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        
        sql = "UPDATE PROPIETARIO " +
                "set Nombres = '"+propietario.getNombres()+"'," +
                "Apellidos = '"+propietario.getApellidos()+"'," +
                "Direccion = '"+propietario.getDireccion()+"'," +
                "Telefono = '"+propietario.getTelefono()+"'," +
                "DNI = '"+propietario.getDNI()+"'," +
                "Sexo = '"+propietario.getSexo()+"'," +
                "Email= '"+propietario.getE_mail()+"', " +
                "Vigencia = "+(propietario.isVigencia() == true ? "1" : "0")+
                ", Id_Usuario = "+propietario.getUsuario().getCodigo()+
                "  where Id_Propietario = "+propietario.getCodigo();
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
    
    public List<Propietario> listar(String nombre) throws Exception{
        List<Propietario> propietarios;
        Propietario pro;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select P.Id_Propietario, P.Nombres, P.Apellidos, P.Direccion, P.Telefono, " +
                        "P.DNI, P.Sexo, P.Email, P.Vigencia, U.Nombres as Usuario " +
                        "from PROPIETARIO P inner join USUARIO U on P.Id_Usuario = U.Id_Usuario " +
                        "Where P.Nombres like '"+nombre+"%' " +
                        "order by P.Nombres";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            propietarios = new ArrayList<>();
            while (rs.next() == true) {
                pro = new Propietario();
                pro.setCodigo(rs.getInt("Id_Propietario"));
                pro.setNombres(rs.getString("Nombres"));
                pro.setApellidos(rs.getString("Apellidos"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setTelefono(rs.getString("Telefono"));
                pro.setDNI(rs.getString("DNI"));
                pro.setSexo(rs.getString("Sexo").charAt(0));
                pro.setE_mail(rs.getString("Email"));
                pro.setVigencia(rs.getBoolean("Vigencia"));
                pro.setUsuario(new RegistroUsuario());
                pro.getUsuario().setNombres(rs.getString("Usuario"));
                
                propietarios.add(pro);
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
        return propietarios;
    }
    
    public Propietario leer(Propietario propietario) throws Exception{
        
        Propietario pro = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        String sql = "select P.Id_Propietario, P.Nombres,"
                + " P.Apellidos, P.Direccion, P.Telefono, "
                + "P.DNI, P.Sexo, P.Email, P.Vigencia, P.Id_Usuario" +
                " from PROPIETARIO P" +
                " Where P.Id_Propietario = "+ propietario.getCodigo();
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                pro = new Propietario();
                pro.setCodigo(propietario.getCodigo());
                pro.setNombres(rs.getString("Nombres"));
                pro.setApellidos(rs.getString("Apellidos"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setTelefono(rs.getString("Telefono"));
                pro.setDNI(rs.getString("DNI"));
                pro.setSexo(rs.getString("Sexo").charAt(0));
                pro.setE_mail(rs.getString("Email"));
                pro.setVigencia(rs.getBoolean("Vigencia"));
                pro.setUsuario(new RegistroUsuario());
                pro.getUsuario().setCodigo(rs.getInt("Id_Usuario"));
                
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
            
            return pro;
        }
    }
    
}
