
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Consulta {
    
    private int codigo;
    private Date fecha;
    private String sintoma;
    private String diagnostico;
    private String tipoConsulta;
    private String razonConsulta;
    private String tratamiento;
    private double peso;
    private double temperatura;
    private int frecuenciaResp;
    private int pulso;
    private String Condicion;
    private boolean estado;
    private HistorialClinico histotia;
    private Medico medico;

    private String nombrePaciente;

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    
    
    
    public String getFechaConsulta(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        return sdf.format(this.fecha);
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getRazonConsulta() {
        return razonConsulta;
    }

    public void setRazonConsulta(String razonConsulta) {
        this.razonConsulta = razonConsulta;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getFrecuenciaResp() {
        return frecuenciaResp;
    }

    public void setFrecuenciaResp(int frecuenciaResp) {
        this.frecuenciaResp = frecuenciaResp;
    }

    public int getPulso() {
        return pulso;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public HistorialClinico getHistotia() {
        return histotia;
    }

    public void setHistotia(HistorialClinico histotia) {
        this.histotia = histotia;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    
}
