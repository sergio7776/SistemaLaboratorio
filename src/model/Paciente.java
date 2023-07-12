package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Paciente {

    private int dni;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private ObraSocial obraSocial;
    private String mail;
    private String sexo;
    private int edad;
    private List<Peticion> peticiones;

    public Paciente(int dni, String nombre, String apellido, Domicilio domicilio, ObraSocial obraSocial, String mail, String sexo, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.obraSocial = obraSocial;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        this.peticiones = new ArrayList<Peticion>();
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public ObraSocial getObraSocial() { return obraSocial; }

    public void setObraSocial(ObraSocial obraSocial) { this.obraSocial = obraSocial; }

    public Collection<Peticion> getPeticiones() { return peticiones; }

    public void setPeticiones(List<Peticion> peticiones) { this.peticiones = peticiones; }

    public void setPeticiones(Peticion peticionNueva) { this.peticiones.add(peticionNueva); }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

}
