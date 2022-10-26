
package dao;

import accesoDatos.Conexion;
import entidades.Especie;
import entidades.Paciente;
import entidades.Propietario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DAOPaciente {
    
    
    public void registrar(Paciente paciente) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(paciente.getFechaNac());
        sql = "insert into EXPEDIENTE_PACIENTE(NombrePac, Raza, Tamaño,Sexo,Color, "
                + "Fecha_Nac, Vigencia, Id_Propietario, Id_Especie) " +
                "values('"+paciente.getNombre()
                +"','"+paciente.getRaza()
                +"','"+paciente.getTamano()
                +"','"+paciente.getSexo()
                +"','"+paciente.getColor()
                +"','"+fecha
                +"',"+(paciente.isVigencia() == true ? "1" : "0")
                +","+paciente.getPropietario().getCodigo()
                +","+paciente.getEspecie().getCodigo()+")";
        
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
    
    public void actualizar(Paciente paciente) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        String fecha = sdf.format(paciente.getFechaNac());
        sql = "Update EXPEDIENTE_PACIENTE "
                + "set NombrePac = '"+paciente.getNombre()
                +"', Raza = '"+paciente.getRaza()
                +"', Tamaño = '"+paciente.getTamano()
                +"', Sexo = '"+paciente.getSexo()
                +"',Color = '"+paciente.getColor()
                +"', Fecha_Nac = '"+fecha
                +"', Vigencia = "+(paciente.isVigencia() == true ? "1" : "0")
                +", Id_Propietario = '"+paciente.getPropietario().getCodigo()
                +"', Id_Especie = " + paciente.getEspecie().getCodigo()+
                " where Id_ExpedienteP = " +paciente.getCodigo();
        
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
    
    public Paciente leer(Paciente paciente) throws Exception{
        
        Paciente pac = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        String sql = "select E.Id_ExpedienteP, E.NombrePac, E.Raza, E.Tamaño, E.Sexo, " +
                "E.Color, E.Fecha_Nac, E.Vigencia, E.Id_Propietario, E.Id_Especie " +
                "from EXPEDIENTE_PACIENTE E " +
                "Where E.Id_ExpedienteP = "+ paciente.getCodigo();

        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next() == true) {
                pac = new Paciente();
                pac.setCodigo(paciente.getCodigo());
                pac.setNombre(rs.getString("NombrePac"));
                pac.setRaza(rs.getString("Raza"));
                pac.setTamano(rs.getString("Tamaño"));
                pac.setSexo(rs.getString("Sexo").charAt(0));
                pac.setColor(rs.getString("Color"));
                pac.setFechaNac((Date)rs.getDate("Fecha_Nac"));
                pac.setVigencia(rs.getBoolean("Vigencia"));
                pac.setPropietario(new Propietario());
                pac.getPropietario().setCodigo(rs.getInt("Id_Propietario"));
                pac.setEspecie(new Especie());
                pac.getEspecie().setCodigo(rs.getInt("Id_Especie"));
                
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
            
            return pac;
        }
    }
    
    
    public List<Paciente> listar(String nombre) throws Exception{
        List<Paciente> pacientes;
        Paciente pac;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select E.Id_ExpedienteP, E.NombrePac, E.Raza, E.Tamaño, E.Sexo, E.Color, E.Fecha_Nac, " +
                    " E.Vigencia, ES.Nombre_Especie as Especie, P.Nombres as Propietario " +
                    "from EXPEDIENTE_PACIENTE E " +
                    "join " +
                    " ESPECIE ES " +
                    " on E.Id_Especie = ES.Id_Especie " +
                    "join " +
                    " PROPIETARIO P on E.Id_Propietario = P.Id_Propietario " +
                    "Where E.NombrePac like '"+nombre+"%' " +
                    "order by E.NombrePac";
        
        con = new Conexion();
        
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            pacientes = new ArrayList<>();
            while (rs.next() == true) {
                pac = new Paciente();
                pac.setCodigo(rs.getInt("Id_ExpedienteP"));
                pac.setNombre(rs.getString("NombrePac"));
                pac.setRaza(rs.getString("Raza"));
                pac.setTamano(rs.getString("Tamaño"));
                pac.setSexo(rs.getString("Sexo").charAt(0));
                pac.setColor(rs.getString("Color"));
                pac.setFechaNac(rs.getDate("Fecha_Nac"));
                pac.setVigencia(rs.getBoolean("Vigencia"));
                pac.setPropietario(new Propietario());
                pac.getPropietario().setNombres(rs.getString("Propietario"));
                pac.setEspecie(new Especie());
                pac.getEspecie().setNombre(rs.getString("Especie"));
                
                pacientes.add(pac);
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
        return pacientes;
    }
    
    
}
