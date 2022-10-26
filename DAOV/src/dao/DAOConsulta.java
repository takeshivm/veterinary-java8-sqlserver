/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesoDatos.Conexion;
import entidades.Consulta;
import entidades.HistorialClinico;
import entidades.Medico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goku
 */
public class DAOConsulta {
    
    
    public void registrar(Consulta consulta) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(consulta.getFecha());
        sql = "insert into CONSULTA(fecha, Sintoma, Diagnostico, Tipo_Consulta, Razon_Consulta, Tratamiento, Peso, Temperatura, " +
                "Frec_Respiratoria, Pulso, Condicion_Corporal, Estado, Id_HistoriaCli, Codigo_Medico) " +
                "values('"+fecha
                +"','"+consulta.getSintoma()
                +"','"+consulta.getDiagnostico()
                +"','"+consulta.getTipoConsulta()
                +"','"+consulta.getRazonConsulta()
                +"','"+consulta.getTratamiento()
                +"',"+consulta.getPeso()
                +","+consulta.getTemperatura()
                +","+consulta.getFrecuenciaResp()
                +","+consulta.getPulso()
                +",'"+consulta.getCondicion()
                +"',"+(consulta.isEstado() == true ? "1" : "0")
                +","+consulta.getHistotia().getCodigo()
                +","+consulta.getMedico().getCodigo()+")";
        
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
    
    public void actualizar(Consulta consulta) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        String fecha = sdf.format(consulta.getFecha());
        sql = "Update CONSULTA set fecha = '"+fecha
                +"', Sintoma = '"+consulta.getSintoma()
                +"', Diagnostico = '"+consulta.getDiagnostico()
                +"', Tipo_Consulta = '"+consulta.getTipoConsulta()
                +"', Razon_Consulta = '"+consulta.getRazonConsulta()
                +"', Tratamiento = '"+consulta.getTratamiento()
                +"', Peso = "+consulta.getPeso()
                +", Temperatura = "+consulta.getTemperatura()
                +", Frec_Respiratoria = "+consulta.getFrecuenciaResp()
                +", Pulso = "+consulta.getPulso()
                +", Condicion_Corporal = '"+consulta.getCondicion()
                +"', Estado = "+(consulta.isEstado() == true ? "1" : "0")
                +", Id_HistoriaCli = "+consulta.getHistotia().getCodigo()
                +", Codigo_Medico = "+consulta.getMedico().getCodigo()+
                " where Id_Consulta = "+consulta.getCodigo();
        
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
    
    public Consulta leer(Consulta consulta) throws Exception{
        
        Consulta cons = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select C.Id_Consulta, C.fecha, C.Sintoma, C.Diagnostico, "
                + "C.Tipo_Consulta, C.Razon_Consulta, C.Tratamiento, " +
                " C.Peso, C.Temperatura, C.Frec_Respiratoria, C.Pulso, C.Condicion_Corporal, C.Estado, " +
                " C.Id_HistoriaCli, C.Codigo_Medico " +
                "from CONSULTA C " +
                "Where C.Id_Consulta = "+consulta.getCodigo();
                
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                cons = new Consulta();
                cons.setCodigo(consulta.getCodigo());
                cons.setFecha(rs.getDate("fecha"));
                cons.setSintoma(rs.getString("Sintoma"));
                cons.setDiagnostico(rs.getString("Diagnostico"));
                cons.setTipoConsulta(rs.getString("Tipo_Consulta"));
                cons.setRazonConsulta(rs.getString("Razon_Consulta"));
                cons.setTratamiento(rs.getString("Tratamiento"));
                cons.setPeso(rs.getDouble("Peso"));
                cons.setTemperatura(rs.getDouble("Temperatura"));
                cons.setFrecuenciaResp(rs.getInt("Frec_Respiratoria"));
                cons.setPulso(rs.getInt("Pulso"));
                cons.setCondicion(rs.getString("Condicion_Corporal"));
                cons.setEstado(rs.getBoolean("Estado"));
                cons.setHistotia(new HistorialClinico());
                cons.getHistotia().setCodigo(rs.getInt("Id_HistoriaCli"));
                cons.setMedico(new Medico());
                cons.getMedico().setCodigo(rs.getInt("Codigo_Medico"));
                
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
            
            return cons;
        }
    }
    
    
    public List<Consulta> listar(String nombre) throws Exception{
        List<Consulta> consultas;
        Consulta cons;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        
        
        String sql = "select C.Id_Consulta, C.fecha, C.Sintoma, C.Diagnostico, "
                + "C.Tipo_Consulta, C.Razon_Consulta, C.Tratamiento, " +
                " C.Peso, C.Temperatura, C.Frec_Respiratoria, C.Pulso, C.Condicion_Corporal, C.Estado, " +
                " M.Nombre as Medico, H.Id_HistoriaCli as Historia, E.NombrePac as Paciente " +
                " from CONSULTA C  " +
                "join " +
                "	MEDICO M " +
                "	on C.Codigo_Medico = M.Codigo_Medico " +
                "join " +
                "	HISTORIAL_CLINICO H on C.Id_HistoriaCli = H.Id_HistoriaCli " +
                "join " +
                "	EXPEDIENTE_PACIENTE E on H.Id_ExpedienteP = E.Id_ExpedienteP "+
                
                " where E.NombrePac like '"+nombre+"%' "
                + "order by Paciente";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            consultas = new ArrayList<>();
            while (rs.next() == true) {
                cons = new Consulta();
                cons.setCodigo(rs.getInt("Id_Consulta"));
                cons.setFecha(rs.getDate("fecha"));
                cons.setSintoma(rs.getString("Sintoma"));
                cons.setDiagnostico(rs.getString("Diagnostico"));
                cons.setTipoConsulta(rs.getString("Tipo_Consulta"));
                cons.setRazonConsulta(rs.getString("Razon_Consulta"));
                cons.setTratamiento(rs.getString("Tratamiento"));
                cons.setPeso(rs.getDouble("Peso"));
                cons.setTemperatura(rs.getDouble("Temperatura"));
                cons.setFrecuenciaResp(rs.getInt("Frec_Respiratoria"));
                cons.setPulso(rs.getInt("Pulso"));
                cons.setCondicion(rs.getString("Condicion_Corporal"));
                cons.setEstado(rs.getBoolean("Estado"));
                cons.setNombrePaciente(rs.getString("Paciente"));
                cons.setHistotia(new HistorialClinico());
                cons.getHistotia().setCodigo(rs.getInt("Historia"));
                cons.setMedico(new Medico());
                cons.getMedico().setNombre(rs.getString("Medico"));

                consultas.add(cons);
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
        return consultas;
    }
    
    
}
