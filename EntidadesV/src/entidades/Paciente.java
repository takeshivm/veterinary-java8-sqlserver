package entidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Paciente {
    
    private int codigo;
    private Propietario propietario;
    private Especie especie;
    private String nombre;
    private String raza;
    private String tamano;
    private char Sexo;
    private String color;
    private Date fechaNac;
    private boolean vigencia;

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }
    

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    
    
    public String getCalcularEdad(){
        String edad = "";
        LocalDate horaActual = LocalDate.now();
        LocalDate horaNac;
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            horaNac = LocalDate.parse(getFechaNacimiento(), date);
            Period periodo =  Period.between(horaNac, horaActual);
            edad = periodo.getYears() + " años y " + periodo.getMonths() + " meses";
        
        return edad;
    }
    
    
    public String getFechaNacimiento(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        return sdf.format(fechaNac);
    }
    
    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    
    
    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /*
    public String nombreSexo(){
        String sexo;
        if (this.Sexo == true ) {
            sexo = "Macho";
        }else{
            sexo = "Hembra";
        }
        return  sexo;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
}
