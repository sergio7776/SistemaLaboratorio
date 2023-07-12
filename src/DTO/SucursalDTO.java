package DTO;

public class SucursalDTO {

    private String numeroSucursal;
    private String direccionSucursal;
    private String responsableTecnico;

    public SucursalDTO(String numeroSucursal, String direccionSucursal, String responsableTecnico){
        this.numeroSucursal = numeroSucursal;
        this.direccionSucursal = direccionSucursal;
        this.responsableTecnico = responsableTecnico;
    }

    public String getNumeroSucursal() { return numeroSucursal; }

    public void setNumeroSucursal(String numeroSucursal) { this.numeroSucursal = numeroSucursal; }

    public String getDireccionSucursal() { return direccionSucursal; }

    public void setDireccionSucursal(String direccionSucursal) { this.direccionSucursal = direccionSucursal; }

    public String getResponsableTecnico() { return responsableTecnico; }

    public void setResponsableTecnico(String responsableTecnico) { this.responsableTecnico = responsableTecnico; }


}
