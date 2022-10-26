
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Pago {
    private int codigo;
    private HistorialClinico histotial;
    private Date fecha;
    private String tipoPago;
    private double IGV;
    private double total;
    private boolean vigencia;
    private String nombrePaciente;
    private String nombrePropietario;

    public String getCadenaFecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        return sdf.format(this.fecha);
    }
    
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    
    
    
    private List<DetallePago> detalle;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public HistorialClinico getHistotial() {
        return histotial;
    }

    public void setHistotial(HistorialClinico histotial) {
        this.histotial = histotial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public List<DetallePago> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePago> detalle) {
        this.detalle = detalle;
    }
    
    
}
