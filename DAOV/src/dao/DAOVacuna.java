
package dao;

import accesoDatos.Conexion;
import entidades.HistorialClinico;
import entidades.Vacuna;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DAOVacuna {
    
    
  public void registrar(Vacuna vacuna) throws Exception {
    Conexion con;
    Connection cn = null;
    Statement st = null;
    String sql;
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      String fecha = sdf.format(vacuna.getFecha());
      String refuerzo = sdf.format(vacuna.getRefuerzo());
    sql = "insert into CARTILLA_VACUNA(Producto_Vac, Tipo_vac, Fecha, Refuerzo, Estado, Id_HistoriaCli) " +
            "values('"+vacuna.getProducto()
            +"','"+vacuna.getTipoVacuna()
            +"','"+fecha
            +"','"+refuerzo
            +"',"+(vacuna.isEstado() == true ? "1" : "0")
            +","+vacuna.getHistoria().getCodigo()+")";

    con = new Conexion();
    try {
      cn = con.conectar();
      st = cn.createStatement();
      st.executeUpdate(sql);
    } catch (Exception e) {
      throw e;
    } finally {
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

  public void actualizar(Vacuna vacuna) throws Exception {
    Conexion con;
    Connection cn = null;
    Statement st = null;
    String sql;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      String fecha = sdf.format(vacuna.getFecha());
      String refuerzo = sdf.format(vacuna.getRefuerzo());
    sql = "Update CARTILLA_VACUNA set Producto_Vac = '"+vacuna.getProducto()
            +"', Tipo_vac = '"+vacuna.getTipoVacuna()
            +"', Fecha = '"+fecha
            +"', Refuerzo = '"+refuerzo
            +"', Id_HistoriaCli = "+vacuna.getHistoria().getCodigo()
            +", Estado = "+(vacuna.isEstado() == true ? "1" : "0")+
            " where Id_CartillaVac = "+vacuna.getCodigo();
            
    con = new Conexion();
    try {
      cn = con.conectar();
      st = cn.createStatement();
      st.executeUpdate(sql);
    } catch (Exception e) {
      throw e;
    } finally {
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

  public Vacuna leer(Vacuna vacuna) throws Exception {
    Vacuna vac = null;
    Conexion con;
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = "select C.Id_CartillaVac, C.Producto_Vac, C.Tipo_vac, C.Fecha, C.Refuerzo, " +
                " C.Id_HistoriaCli, C.Estado " +
                "from CARTILLA_VACUNA C " +
                "Where C.Id_CartillaVac = "+ vacuna.getCodigo();

    con = new Conexion();
    try {
      cn = con.conectar();
      st = cn.createStatement();
      rs = st.executeQuery(sql);
      if (rs.next() == true) {
          vac = new Vacuna();
          vac.setCodigo(vacuna.getCodigo());
          vac.setProducto(rs.getString("Producto_Vac"));
          vac.setTipoVacuna(rs.getString("Tipo_vac"));
          vac.setFecha(rs.getDate("Fecha"));
          vac.setRefuerzo(rs.getDate("Refuerzo"));
          vac.setEstado(rs.getBoolean("Estado"));
          vac.setHistoria(new HistorialClinico());
          vac.getHistoria().setCodigo(rs.getInt("Id_HistoriaCli"));
          
      }
    } catch (Exception e) {
      throw e;
    } finally {
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
    return vac;
  }

  public List<Vacuna> listar() throws Exception {
    List<Vacuna> vacunas = null;
    Vacuna vac;
    Conexion con;
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = "select C.Id_CartillaVac, C.Producto_Vac, C.Tipo_vac, C.Fecha, C.Refuerzo," +
                    " C.Estado, H.Id_HistoriaCli as Historial, E.NombrePac as Paciente " +
                    "from CARTILLA_VACUNA C inner join HISTORIAL_CLINICO H on C.Id_HistoriaCli = H.Id_HistoriaCli " +
                    "	join EXPEDIENTE_PACIENTE E on E.Id_ExpedienteP = H.Id_ExpedienteP " +
                     " order by E.NombrePac desc";
    
    con = new Conexion();
    try {
      cn = con.conectar();
      st = cn.createStatement();
      rs = st.executeQuery(sql);
      vacunas = new ArrayList<>();
      while (rs.next() == true) {
          vac = new Vacuna();
          vac.setCodigo(rs.getInt("Id_CartillaVac"));
          vac.setProducto(rs.getString("Producto_Vac"));
          vac.setTipoVacuna(rs.getString("Tipo_vac"));
          vac.setFecha(rs.getDate("Fecha"));
          vac.setRefuerzo(rs.getDate("Refuerzo"));
          vac.setEstado(rs.getBoolean("Estado"));
          vac.setNobrePaciente(rs.getString("Paciente"));
          vac.setHistoria(new HistorialClinico());
          vac.getHistoria().setCodigo(rs.getInt("Historial"));
          
        vacunas.add(vac);
      }
    } catch (Exception e) {
      throw e;
    } finally {
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
    return vacunas;
  }
    
}
