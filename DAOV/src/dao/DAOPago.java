
package dao;

import accesoDatos.Conexion;
import entidades.DetallePago;
import entidades.HistorialClinico;
import entidades.Pago;
import entidades.Vacuna;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DAOPago {
    
    
    public void registrar(Pago pago) throws Exception{
        
        Conexion con = new Conexion();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql;
        int codigoPago;
        
        try {
            cn = con.conectar();
            cn.setAutoCommit(false);
            st = cn.createStatement();
        //1: Registrar la venta (El servidor asigna codigo)
            SimpleDateFormat sdf  = new SimpleDateFormat();
            String fecha = sdf.format(pago.getFecha());
        sql = "insert into PAGO(Fecha, Tipo_Pago, IGV, Total, Vigencia, Id_HistoriaCli)" +
            " values('"+fecha
                +"', '"+pago.getTipoPago()
                +"',"+pago.getIGV()
                +","+pago.getTotal()
                +","+(pago.isVigencia() == true ? "1" : "0")
                +","+pago.getHistotial().getCodigo()+")";
                
                
            st.executeUpdate(sql);
        //2. Averiguar el codigo generado
            sql = "SELECT  @@IDENTITY as Codigo";
            rs = st.executeQuery(sql);
            rs.next();
            codigoPago = rs.getInt("Codigo");
            rs.close();
        //3. Varias veces segun sea necesario
            //3.1 registrar cada detalle
            for (DetallePago detalle : pago.getDetalle()) {
                sql = "insert into DETALLE_PAGO(Precio,Codigo_Pago,Codigo_Servicio) " +
                        "values ("+detalle.getPrecio()
                        +","+codigoPago
                        +","+detalle.getServicio().getCodigo()+")";
                
                st.executeUpdate(sql);
            }
            cn.commit();
            
        } catch (Exception e) {
            cn.rollback();
            throw e;
        }finally{
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
    }
    
    public List<Pago> listar() throws Exception {
    List<Pago> pagos = null;
    Pago pag;
    Conexion con;
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = "select P.Codigo_Pago,P.Fecha,P.Tipo_Pago,P.IGV,P.Total,P.Vigencia,e.NombrePac as Paciente, " +
                " PR.Nombres as Propietario, H.Id_HistoriaCli as Id_Historial" +
                " from PAGO P inner join HISTORIAL_CLINICO H on P.Id_HistoriaCli = H.Id_HistoriaCli " +
                "  inner join EXPEDIENTE_PACIENTE E on H.Id_ExpedienteP = E.Id_ExpedienteP  " +
                "  inner join PROPIETARIO PR on E.Id_Propietario = PR.Id_Propietario  " +
                    " order by P.Fecha desc";
    
    con = new Conexion();
    try {
      cn = con.conectar();
      st = cn.createStatement();
      rs = st.executeQuery(sql);
      pagos = new ArrayList<>();
      while (rs.next() == true) {
          pag = new Pago();
          pag.setCodigo(rs.getInt("Codigo_Pago"));
          pag.setFecha(rs.getDate("Fecha"));
          pag.setTipoPago(rs.getString("Tipo_Pago"));
          pag.setIGV(rs.getDouble("IGV"));
          pag.setTotal(rs.getDouble("Total"));
          pag.setVigencia(rs.getBoolean("Vigencia"));
          pag.setNombrePropietario(rs.getString("Propietario"));
          pag.setNombrePaciente(rs.getString("Paciente"));
          pag.setHistotial(new HistorialClinico());
          pag.getHistotial().setCodigo(rs.getInt("Id_Historial"));
          
        pagos.add(pag);
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
    return pagos;
  }
    
}
