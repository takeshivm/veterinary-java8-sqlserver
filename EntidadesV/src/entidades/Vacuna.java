
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Vacuna {
    
    private int codigo;
    private HistorialClinico historia;
    private String producto;
    private String tipoVacuna;
    private Date fecha;
    private Date refuerzo;
    private boolean estado;
    private String nobrePaciente;

    public String nombreEstado(){
        String nombre = "";
        if (this.estado == true) {
            nombre = "valido";
        }else{
            nombre = "nulo";
        }
        return nombre;
    }
    
    public String getNombreFecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
        return sdf.format(fecha);
    }
    
    public String getNombreRefuerzo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
        return sdf.format(refuerzo);
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    public String getNobrePaciente() {
        return nobrePaciente;
    }

    public void setNobrePaciente(String nobrePaciente) {
        this.nobrePaciente = nobrePaciente;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public HistorialClinico getHistoria() {
        return historia;
    }

    public void setHistoria(HistorialClinico historia) {
        this.historia = historia;
    }
    
    
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(Date refuerzo) {
        this.refuerzo = refuerzo;
    }
    
    
}
