package model;

public class Practica {

    private String codigo;

    private String nombreDePractica;

    private String grupo;

    private Boolean valoresCriticos;

    private Boolean valoresReservados;

    private int horasHastaResultado;

    private boolean resultadosFinalizados;

    private String resultado;

    public Practica(String codigo, String nombreDePractica, Boolean valoresCriticos, Boolean valoresReservados, String resultado) {
        this.codigo = codigo;
        this.nombreDePractica = nombreDePractica;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.resultadosFinalizados = true;
        this.horasHastaResultado = 0;
        this.resultado = resultado;
    }

    public Practica(String codigo, String nombreDePractica, int horasHastaResultado) {
        this.codigo = codigo;
        this.nombreDePractica = nombreDePractica;
        this.horasHastaResultado = horasHastaResultado;
        this.resultadosFinalizados = false;
        this.valoresCriticos = null;
        this.valoresReservados = null;
        this.resultado = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDePractica() {
        return nombreDePractica;
    }

    public void setNombreDePractica(String nombreDePractica) {
        nombreDePractica = nombreDePractica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Boolean isValoresCriticos() {
        if(valoresCriticos == null) return false;
        return valoresCriticos;
    }

    public void setValoresCriticos(Boolean valoresCriticos) {
        this.valoresCriticos = valoresCriticos;
    }

    public Boolean isValoresReservados() {
        if(valoresReservados == null) return false;
        return valoresReservados;
    }

    public void setValoresReservados(Boolean valoresReservados) {
        this.valoresReservados = valoresReservados;
    }

    public int getHorasHastaResultado() {
        return horasHastaResultado;
    }

    public void setHorasHastaResultado(int horasHastaResultado) {
        this.horasHastaResultado = horasHastaResultado;
    }

    public boolean isResultadosFinalizados() { return resultadosFinalizados; }

    public void setResultadosFinalizados(boolean resultadosFinalizados) { this.resultadosFinalizados = resultadosFinalizados; }

    public String getResultado() {
        if(resultado == null) return "-";
        if(isValoresReservados()) return "Retirar por sucursal";
        return resultado;
    }

    public void setResultado(String resultado) { this.resultado = resultado; }

}
