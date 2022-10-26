
package dao;

import accesoDatos.Conexion;
import entidades.HistorialClinico;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DAOHistorialClinico {
    
    public void registrar(HistorialClinico historial) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(historial.getFecha());
        sql = "insert into HISTORIAL_CLINICO(Fecha, Enfermedad_Previa, Alergia, Desparasitacion, Vigencia, Id_ExpedienteP) " +
                "values('"+fecha
                +"','"+historial.getEnfermedad()
                +"','"+historial.getAlergia()
                +"',"+(historial.isDesparasitacion() == true ? "1" : "0")
                +","+(historial.isVigencia() == true ? "1" : "0")
                +","+historial.getPaciente().getCodigo()+")";
        
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
    
    public void actualizar(HistorialClinico historial) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        String fecha = sdf.format(historial.getFecha());
        sql = "Update HISTORIAL_CLINICO set Fecha = '"+fecha
                +"', Enfermedad_Previa= '"+historial.getEnfermedad()
                +"', Alergia= '"+historial.getAlergia()
                +"',  Desparasitacion = "+(historial.isDesparasitacion() == true ? "1" : "0")
                +", Vigencia =  "+(historial.isVigencia()== true ? "1" : "0")
                +", Id_ExpedienteP =  "+historial.getPaciente().getCodigo()+
                " where Id_HistoriaCli = "+historial.getCodigo();
        
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
    
    public List<HistorialClinico> listar(String nombre) throws Exception{
        List<HistorialClinico> historias;
        HistorialClinico his;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select H.Id_HistoriaCli, H.Fecha, H.Enfermedad_Previa, H.Alergia, H.Desparasitacion, " +
                    " H.Vigencia, E.NombrePac as Paciente " +
                    "from HISTORIAL_CLINICO H inner join EXPEDIENTE_PACIENTE E on H.Id_ExpedienteP = E.Id_ExpedienteP " +
                    "Where E.NombrePac like '"+nombre+"%' " +
                        "order by E.NombrePac";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            historias = new ArrayList<>();
            while (rs.next() == true) {
                his = new HistorialClinico();
                his.setCodigo(rs.getInt("Id_HistoriaCli"));
                his.setFecha(rs.getDate("Fecha"));
                his.setEnfermedad(rs.getString("Enfermedad_Previa"));
                his.setAlergia(rs.getString("Alergia"));
                his.setDesparasitacion(rs.getBoolean("Desparasitacion"));
                his.setVigencia(rs.getBoolean("Vigencia"));
                his.setPaciente(new Paciente());
                his.getPaciente().setNombre(rs.getString("Paciente"));
                
                historias.add(his);
            }
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
        return historias;
    }
    
    public HistorialClinico leer(HistorialClinico historial) throws Exception{
        
        HistorialClinico his = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        String sql = "select H.Id_HistoriaCli, H.Fecha, H.Enfermedad_Previa, H.Alergia, H.Desparasitacion, " +
                        " H.Vigencia, H.Id_ExpedienteP " +
                        " from HISTORIAL_CLINICO H " +
                        "Where H.Id_HistoriaCli = "+ historial.getCodigo();
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                his = new HistorialClinico();
                his.setCodigo(historial.getCodigo());
                his.setFecha(rs.getDate("Fecha"));
                his.setEnfermedad(rs.getString("Enfermedad_Previa"));
                his.setAlergia(rs.getString("Alergia"));
                his.setDesparasitacion(rs.getBoolean("Desparasitacion"));
                his.setVigencia(rs.getBoolean("Vigencia"));
                his.setPaciente(new Paciente());
                his.getPaciente().setCodigo(rs.getInt("Id_ExpedienteP"));
                
                
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
            
            return his;
        }
    }
    
    public List<HistorialClinico> listarPropietario(String nombre) throws Exception{
        List<HistorialClinico> historias;
        HistorialClinico his;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select H.Id_HistoriaCli, H.Fecha, H.Enfermedad_Previa, H.Alergia, H.Desparasitacion, " +
                    " H.Vigencia, E.NombrePac as Paciente, P.Nombres as Propietario " +
                    "from HISTORIAL_CLINICO H inner join EXPEDIENTE_PACIENTE E on H.Id_ExpedienteP = E.Id_ExpedienteP "
                    + " inner join PROPIETARIO P on E.Id_Propietario = P.Id_Propietario " +
                    " Where E.NombrePac like '"+nombre+"%' " +
                        "order by Propietario";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            historias = new ArrayList<>();
            while (rs.next() == true) {
                his = new HistorialClinico();
                his.setCodigo(rs.getInt("Id_HistoriaCli"));
                his.setFecha(rs.getDate("Fecha"));
                his.setEnfermedad(rs.getString("Enfermedad_Previa"));
                his.setAlergia(rs.getString("Alergia"));
                his.setDesparasitacion(rs.getBoolean("Desparasitacion"));
                his.setVigencia(rs.getBoolean("Vigencia"));
                his.setPaciente(new Paciente());
                his.getPaciente().setNombre(rs.getString("Paciente"));
                his.setNombrePaciente(rs.getString("Paciente"));
                his.setNombrePropietario(rs.getString("Propietario"));
                
                historias.add(his);
            }
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
        return historias;
    }
    
}
