
package modelo;

import java.time.LocalDate;


public class Socios 
{
    
    private int idSocio;
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;
    private LocalDate fechaNac;
    private String email;
    private String telefono;
    private boolean  activo;
    
    //constructoresd de la clase socio, nos permite manipular los atributos que les dimos

    public Socios(int idSocio, String nombre, String apellido, String direccion, String localidad, LocalDate fechaNac, String email, String telefono, boolean activo) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.fechaNac = fechaNac;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }
    
    //creacion de getters and setters para la clase, como son atributos privados nosotros para llamarlos en otros paquetes y clases tenemos que generarlos

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    
     
        
}
/**
 *
 * @author Sol
 */