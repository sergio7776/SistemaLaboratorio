package model;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private int numero;
    private String direccion;
    private Usuario responsableTecnico;
    private List<Peticion> peticiones;

    public Sucursal(int numero, String direccion, Usuario responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        this.peticiones = new ArrayList<Peticion>();
    }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Usuario getResponsableTecnico() { return responsableTecnico; }
    public void setResponsableTecnico(Usuario responsableTecnico) { this.responsableTecnico = responsableTecnico; }

    public List<Peticion> getPeticiones() { return peticiones; }

    public void setPeticiones(List<Peticion> peticiones) { this.peticiones = peticiones; }

    public void setPeticiones(Peticion peticionNueva) { this.peticiones.add(peticionNueva); }


}
