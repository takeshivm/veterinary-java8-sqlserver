/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
DIAPOSITIVAS: 

Caratula: logo, integrantes, nombre del proyceto
realidad problematica
requerimiento
Diagrama de la base de datos

 */
package entidades;

/**
 *
 * @author Goku
 */
public class Especie {
    
    private int codigo;
    private String nombre;
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
