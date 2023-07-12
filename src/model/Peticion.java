package model;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Peticion {

    private Paciente paciente;
    private Sucursal sucursal;
    private String idPeticion;
    private Date fechaDeCarga;
    private List<Practica> practicasAsociadas;
    private boolean peticionActiva;

    public Peticion(Paciente paciente, Sucursal sucursal, String idPeticion, Date fechaDeCarga, boolean peticionActiva, List<Practica> practicasAsociadas){
        this.paciente = paciente;
        this.sucursal = sucursal;
        sucursal.setPeticiones(this);
        this.idPeticion = idPeticion;
        paciente.setPeticiones(this);
        this.fechaDeCarga = fechaDeCarga;
        this.peticionActiva = peticionActiva;
        this.practicasAsociadas = practicasAsociadas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        this.fechaDeCarga = fechaDeCarga;
    }

    public Date getFechaDeCarga(){
        return fechaDeCarga;
    }

    public void setPracticasAsociadas(List<Practica> practicasAsociadas) { this.practicasAsociadas = practicasAsociadas; }

    public void setPracticasAsociadas(Practica practica) {
        this.practicasAsociadas.add(practica);
    }

    public List<Practica> getPracticasAsociadas(){
        return practicasAsociadas;
    }

    public void setPeticionActiva(boolean peticionActiva) {
        this.peticionActiva = peticionActiva;
    }

    public boolean isPeticionActiva(){
        return peticionActiva;
    }

    public String getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(String idPeticion) {
        this.idPeticion = idPeticion;
    }
    public Sucursal getSucursal() { return sucursal; }

    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }

}
