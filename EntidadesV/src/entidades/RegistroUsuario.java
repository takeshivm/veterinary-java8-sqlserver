
package entidades;


public class RegistroUsuario {
    
    private int codigo;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private boolean estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public String getNombreCompleto(){
        return this.nombres + " " + this.apellidos;
    }
    
    public String getNombreEstado(){
        String nombre;
        if (estado == true) {
            nombre = "Activo";
        }else{
            nombre = "Inactivo";
        }
        return nombre;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
