
package dao;

import accesoDatos.Conexion;
import entidades.Servicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOServicio {
    public void registrar(Servicio servicio) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st =  null; 
        String sql;
        
        sql = "insert into SERVICIO(Nombre, Descripcion, Precio, Vigencia) " +
                "values('"+servicio.getNombre()
                +"','"+servicio.getDescripcion()
                +"','"+servicio.getPrecio()
                +"',"+(servicio.isVigencia() == true ? "1" : "0")+")";
        
        con = new Conexion();
        try{
            cn = con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e){
            throw e;
        }finally{
            if (st!=null && st.isClosed()==false) {
                st.close();
            }
            st = null;
            if (cn!=null && cn.isClosed()==false) {
                cn.close();
            }
            cn = null;
        }
    }
    
    public void actualizar(Servicio servicio) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st =  null; 
        String sql;
        
        sql = "Update SERVICIO set Nombre = '"+servicio.getNombre()
                +"', Descripcion = '"+servicio.getDescripcion()
                +"', Precio = "+servicio.getPrecio()
                +", Vigencia = "+(servicio.isVigencia() == true ? "1" : "0")+
                " where Codigo_Servicio = "+ servicio.getCodigo();
        
        con = new Conexion();
        try{
            cn = con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e){
            throw e;
        }finally{
            if (st!=null && st.isClosed()==false) {
                st.close();
            }
            st = null;
            if (cn!=null && cn.isClosed()==false) {
                cn.close();
            }
            cn = null;
        }
    }
   
    public Servicio leer(Servicio servicio) throws Exception{
        Servicio serv = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql ="Select S.Codigo_Servicio, S.Nombre, S.Descripcion, S.Precio, S.Vigencia " +
                    "from SERVICIO S " +
                    "where S.Codigo_Servicio = "+ servicio.getCodigo();
        
        con = new Conexion();
        
        try{
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next() == true){
                serv = new Servicio();
                serv.setCodigo(servicio.getCodigo());
                serv.setNombre(rs.getString("Nombre"));
                serv.setDescripcion(rs.getString("Descripcion"));
                serv.setPrecio(rs.getDouble("Precio"));
                serv.setVigencia(rs.getBoolean("Vigencia"));
            }
        }catch (Exception e){
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
        }
        return serv;
    }
   
    public List<Servicio> listar() throws Exception{
        List<Servicio> servicios;
        Servicio serv;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql ="Select S.Codigo_Servicio, S.Nombre, S.Descripcion, S.Precio, S.Vigencia " +
                    "from SERVICIO S " +
                    " order by S.Nombre";
        
        con = new Conexion();
        try{
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            servicios = new ArrayList<>();
            while(rs.next() == true){
                serv = new Servicio();
                serv.setCodigo(rs.getInt("Codigo_Servicio"));
                serv.setNombre(rs.getString("Nombre"));
                serv.setDescripcion(rs.getString("Descripcion"));
                serv.setPrecio(rs.getDouble("Precio"));
                serv.setVigencia(rs.getBoolean("Vigencia"));
                
                servicios.add(serv);
            }
        }catch (Exception e){
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
        }
        return servicios;
    }
    
}
