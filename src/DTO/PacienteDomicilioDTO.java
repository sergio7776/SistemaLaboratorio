package DTO;

public class PacienteDomicilioDTO {

    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private String calleDomicilioPaciente;
    private String numeroDomicilio;
    private String nombreObraSocial;
    private String codigoObraSocial;
    private String mail;
    private String sexo;
    private String edad;

    public PacienteDomicilioDTO(String nombrePaciente, String apellidoPaciente, String dniPaciente, String calleDomicilioPaciente, String numeroDomicilio, String nombreObraSocial, String codigoObraSocial, String mail, String sexo, String edad) {
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dniPaciente = dniPaciente;
        this.calleDomicilioPaciente = calleDomicilioPaciente;
        this.numeroDomicilio = numeroDomicilio;
        this.nombreObraSocial = nombreObraSocial;
        this.codigoObraSocial = codigoObraSocial;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getCalleDomicilioPaciente() {
        return calleDomicilioPaciente;
    }

    public void setCalleDomicilioPaciente(String calleDomicilioPaciente) { this.calleDomicilioPaciente = calleDomicilioPaciente; }

    public String getNumeroDomicilio() {
        return numeroDomicilio;
    }

    public void setNumeroDomicilio(String numeroDomicilio) {
        this.numeroDomicilio = numeroDomicilio;
    }

    public String getNombreObraSocial() { return nombreObraSocial; }

    public void setNombreObraSocial(String nombreObraSocial) { this.nombreObraSocial = nombreObraSocial; }

    public String getCodigoObraSocial() { return codigoObraSocial; }

    public void setCodigoObraSocial(String codigoObraSocial) { this.codigoObraSocial = codigoObraSocial; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getEdad() { return edad; }

    public void setEdad(String edad) { this.edad = edad; }
}
