package controller;

import DTO.PacienteDomicilioDTO;
import DTO.SucursalDTO;
import DTO.UsuarioRolDTO;
import model.*;
import vista.Peticiones.FrmVerPeticiones;
import vista.Practicas.FrmVerPracticasAsociadas;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    private static Controller INSTANCE;

    private static List<Practica> practicas;

    private static List<Usuario> usuarios;

    private static List<Sucursal> sucursales;

    private static List<Paciente> pacientes;

    private static List<Peticion> peticiones;


    private Controller(){}

    public static synchronized Controller getInstances(){
        if(INSTANCE == null){
            INSTANCE = new Controller();
            initPacientes();
            initUsuarios();
            initSucursales();
            initPeticiones();
        }
        return INSTANCE;
    }

    private static void initPacientes(){
        pacientes =  new ArrayList<>();
        pacientes.add(new Paciente(11111111,"Julio","Morales", new Domicilio("Av. Libertador", 2121),new ObraSocial("Osde", "210"), "julio.morales@gmail.com","Masculino", 20));
        pacientes.add(new Paciente(22222222,"Pedro","Pepe" ,new Domicilio("Alsina",1234), new ObraSocial("Osde", "310"), "pedro.pepe@gmail.com", "Masculino", 32));
        pacientes.add(new Paciente(33333333, "Martin" ,"Gonzalez", new Domicilio("Av. Santa Fe", 3100), new ObraSocial("SwissMedical", "SMG20"), "martin.gonzalez@gmail.com", "Masculino", 57));
    }

    public static void initUsuarios(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("LLima", "l.lima@gmail.com", "0traC0ntras3ñ4",
                "Laura Lima", new Domicilio("Av. Juramento", 4100), 132123123, new Date(90, 4, 12), roles.Administrador));
        usuarios.add(new Usuario("MInsua", "m.insua@gmail.com", "C0ntr4s3ñ4",
                "Maximiliano Insua", new Domicilio("Gorriti", 1233), 2131321, new Date(99, 10, 1), roles.Recepcion));
    }
    public static void initSucursales(){
        sucursales = new ArrayList<>();
        sucursales.add(new Sucursal(212,"Av. Leandro N. Alem 1303", usuarios.get(0)));
        sucursales.add(new Sucursal(130,"Av. Cordoba 2310", usuarios.get(1)));
    }
    public static void initPeticiones(){
        peticiones = new ArrayList<>();
        peticiones.add(new Peticion(
                       pacientes.get(0),
                       sucursales.get(0),
                       "A00001",
                       new Date(119, 11, 10),
                       false,
                       new ArrayList<Practica>(){{
                           add(new Practica("RSN","Resonancia", false, false, "No se observa desgarro"));
                           add(new Practica("ECTR", "Electrocardiograma", true, true, "Problema cardiaco"));
                       }
                       })
        );
        peticiones.add(new Peticion(
                        pacientes.get(1),
                       sucursales.get(0),
                       "A00002",
                        new Date(121, 2, 20),
                        false,
                        new ArrayList<Practica>(){{
                            add(new Practica("ECTR","Electrocardiograma", true, true, "Se observa rotura de LCA"));
                            add(new Practica("RSN", "Resonancia", false, false, "Estudios normales"));
                        }
            })
        );
        peticiones.add(new Peticion(
                        pacientes.get(2),
                        sucursales.get(1),
                        "A00003",
                        new Date(123, 5, 28),
                        true,
                        new ArrayList<Practica>(){{
                            add(new Practica("TMG","Tomografia",1));
                            add(new Practica("EGF", "Ecografia", 12));
                        }
            })
        );

    }

    public void crearPaciente(PacienteDomicilioDTO dto){
        Paciente pacienteNuevo = toModelPaciente(dto);
        boolean existe = false;
        for (int i=0; i<pacientes.size(); i++){
            if(pacienteNuevo.getDni() == pacientes.get(i).getDni()){
                existe = true;
            }
        }
        if(!existe) {
            pacientes.add(pacienteNuevo);
            JOptionPane.showMessageDialog(null, "Paciente añadido");
        } else {
            JOptionPane.showMessageDialog(null, "Paciente ya existe");
        }
    }

    public void crearUsuario(UsuarioRolDTO dto){
        Usuario usuarioNuevo = toModelUsuario(dto);
        boolean existe = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarioNuevo.getNombreUsuario() == usuarios.get(i).getNombreUsuario()){
                existe = true;
            }
        }
        if(!existe){
            usuarios.add(usuarioNuevo);
            JOptionPane.showMessageDialog(null, "Usuario añadido");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario ya existia");
        }
    }

    public void crearSucursal(SucursalDTO dto){
        Sucursal sucursalNueva = toModelSucursal(dto);
        if(sucursalNueva == null) return;
        boolean existe = false;
        for (int i = 0; i < sucursales.size(); i++) {
            if(sucursalNueva.getNumero() == sucursales.get(i).getNumero()){
                existe = true;
            }
        }
        if(!existe){
            sucursales.add(sucursalNueva);
            JOptionPane.showMessageDialog(null, "Sucursal añadida");
        } else {
            JOptionPane.showMessageDialog(null, "Sucursal ya existia");
        }
    }

    public void eliminarPaciente(String dni){
        int dniAux = Integer.valueOf(dni);
        boolean existePaciente = false;
        List<Integer> peticionesARemover = new ArrayList<Integer>();
        for(int i=0; i<pacientes.size(); i++){
            if(dniAux == pacientes.get(i).getDni()){
                for(int j=0; j<peticiones.size(); j++){
                    if(peticiones.get(j).getPaciente().getDni() == dniAux){
                        if(peticiones.get(j).getPracticasAsociadas().get(0).isResultadosFinalizados() == true){
                            JOptionPane.showMessageDialog(null, "El paciente tiene practicas con resultados finalizadas y no puede ser eliminado");
                            return;
                        } else{
                            peticionesARemover.add(j);
                        }
                    }
                    for (int k = 0; k < peticionesARemover.size(); k++) {
                        peticiones.remove(peticionesARemover.get(k));
                    }
                }
                pacientes.remove(i);
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
                existePaciente = true;
            }
        }
        if(!existePaciente) JOptionPane.showMessageDialog(null, "No hay ningun paciente con ese DNI");
    }

    public boolean seDerivoPeticion(int numeroSucursalAEliminar, Peticion peticionADerivar){
        for (int i = 0; i < sucursales.size(); i++) {
            if(sucursales.get(i).getNumero() != numeroSucursalAEliminar){
                sucursales.get(i).setPeticiones(peticionADerivar);
                peticionADerivar.setSucursal(sucursales.get(i));
                JOptionPane.showMessageDialog(null, "La peticion " + peticionADerivar.getIdPeticion() + " esta activa y se va a derivar a la sucursal numero " + sucursales.get(i).getNumero());
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No habia otra sucursal para derivar la petición, no se puede eliminar la sucursal");
        return false;
    }

    public void eliminarSucursal(String numeroSucursal){
        int numeroSucursalAux = Integer.valueOf(numeroSucursal);
        boolean existePaciente = false;
        List<Integer> peticionesARemover = new ArrayList<Integer>();
        List<Integer> peticionesADerivar = new ArrayList<Integer>();
        for(int i=0; i<sucursales.size(); i++){
            if(numeroSucursalAux == sucursales.get(i).getNumero()){
                for(int j=0; j<peticiones.size(); j++){
                    if(peticiones.get(j).getSucursal().getNumero() == numeroSucursalAux){
                        if(peticiones.get(j).getPracticasAsociadas().get(0).isResultadosFinalizados() == true){
                            JOptionPane.showMessageDialog(null, "La sucursal tiene practicas con resultados finalizadas y no puede ser eliminada");
                            return;
                        } else if (peticiones.get(j).isPeticionActiva() == true){
                            peticionesADerivar.add(j);
                        } else peticionesARemover.add(j);
                    }
                    for (int l = 0; l < peticionesADerivar.size(); l++) {
                        if(!seDerivoPeticion(numeroSucursalAux, peticiones.get(peticionesADerivar.get(l)))) {
                            return;
                        }
                    }
                    for (int k = 0; k < peticionesARemover.size(); k++) {
                        peticiones.remove(peticionesARemover.get(k));
                    }
                }
                sucursales.remove(i);
                JOptionPane.showMessageDialog(null, "Sucursal eliminada");
                existePaciente = true;
            }
        }
        if(!existePaciente) JOptionPane.showMessageDialog(null, "No hay ninguna sucursal con ese numero de sucursal");
    }

    public static List<Peticion> getPeticionesConResultadosCriticos(){
        List<Peticion> peticionesAux = new ArrayList<Peticion>();
        for (int i = 0; i < peticiones.size(); i++) {
            for (int j = 0; j < peticiones.get(i).getPracticasAsociadas().size(); j++) {
                if(peticiones.get(i).getPracticasAsociadas().get(j).isValoresCriticos() == true){
                    peticionesAux.add(peticiones.get(i));
                }
            }
        }
        return peticionesAux;
    }

    public static List<String> getIdsPeticionesCriticas(List<Peticion> listaPeticiones){
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            ids.add(listaPeticiones.get(i).getIdPeticion());
        }
        return ids;
    }





    public static class ListaPeticionesCriticas extends AbstractListModel{

        List<Peticion> listaPeticionAux = getPeticionesConResultadosCriticos();

        List<String> item = getIdsPeticionesCriticas(listaPeticionAux);

        @Override
        public int getSize() {
            return item.size();
        }

        @Override
        public Object getElementAt(int index) {
            return item.get(index);
        }
    }

    public static class ListaPacientes extends AbstractListModel {

        private List<String> item = getNombreApellidoList();

        @Override
        public int getSize() {
            return item.size();
        }

        @Override
        public Object getElementAt(int i) {
            return item.get(i);
        }
        public int getDni(int i){
            return pacientes.get(i).getDni();
        }
        public String getCalleDom(int i){
            return pacientes.get(i).getDomicilio().getCalle();
        }
        public int getNumeroDom(int i){
            return pacientes.get(i).getDomicilio().getNumero();
        }
        public String getNombre(int i){
                return pacientes.get(i).getNombre();
        }
        public String getApellido(int i){
            return pacientes.get(i).getApellido();
        }
        public String getNombreObr(int i){ return pacientes.get(i).getObraSocial().getNombre();}
        public String getCodigoObr(int i){ return pacientes.get(i).getObraSocial().getCodigo();}
        public String getMail(int i){ return pacientes.get(i).getMail();}
        public String getSexo(int i){ return pacientes.get(i).getSexo();}
        public int getEdad(int i){ return pacientes.get(i).getEdad();}

        public List getNombreApellidoList(){
            List aux = new ArrayList<>();
            for(int i=0; i<pacientes.size();i++){
                aux.add(getNombre(i) + ' ' + getApellido(i));
            }
            return aux;
        }
    }

    public static class ListaUsuarios extends AbstractListModel {

        private List<String> item = getNombreUsuarioList();

        @Override
        public int getSize() {
            return item.size();
        }

        @Override
        public Object getElementAt(int i) {
            return item.get(i);
        }

        public int getDni(int i) { return usuarios.get(i).getDNI(); }

        public String getCalleDom(int i) { return usuarios.get(i).getDomicilio().getCalle(); }

        public int getNumeroDom(int i) { return usuarios.get(i).getDomicilio().getNumero(); }

        public String getNombreUsuario(int i) { return usuarios.get(i).getNombreUsuario(); }

        public String getNombreApellido(int i) { return usuarios.get(i).getNombre(); }

        public String getFecha(int i) { return String.valueOf(usuarios.get(i).getFechaNacimiento()); }

        public String getRol(int i) { return String.valueOf(usuarios.get(i).getRol()); }

        public String getEmail(int i) { return usuarios.get(i).getEmail(); }

        public String getPwd(int i) { return usuarios.get(i).getPassword();}

        public List getNombreUsuarioList(){
            List aux = new ArrayList<>();
            for(int i=0; i<usuarios.size();i++){
                aux.add(getNombreUsuario(i));
            }
            return aux;
        }
    }

    public static class ListaSucursales extends AbstractListModel {

        private List<String> item = getNumeroSucursalList();

        @Override
        public int getSize() {
            return item.size();
        }

        @Override
        public Object getElementAt(int i) {
            return item.get(i);
        }

        public String getDireccion(int i) { return sucursales.get(i).getDireccion(); }

        public String getResponsableTecnico(int i) { return String.valueOf(sucursales.get(i).getResponsableTecnico().getNombre()); }

        public String getNumeroSucursal(int i) { return String.valueOf(sucursales.get(i).getNumero()); }


        public List getNumeroSucursalList(){
            List aux = new ArrayList<>();
            for(int i=0; i<sucursales.size();i++){
                aux.add(getNumeroSucursal(i));
            }
            return aux;
        }
    }



    public static class MiTablaPracticasAsociadas extends AbstractTableModel{
        private List<Practica> lista;
        private int numeroPeticion2;
        public MiTablaPracticasAsociadas(int numeroPeticion){
            this.numeroPeticion2 = numeroPeticion;
            lista = peticiones.get(this.numeroPeticion2).getPracticasAsociadas();
        }

        protected String[] columnNames = new String[] {"Código", "Nombre de práctica", "Horas hasta resultados", "Resultados finalizados", "Valores críticos", "Valores reservados", "Resultado"};
        protected Class[] columnClasses = new Class[] {String.class, String.class, Integer.class, Boolean.class, Boolean.class, Boolean.class, String.class};

        public String getColumnName(int col) { return columnNames[col];}
        public Class getColumnClass(int col) { return columnClasses[col]; }

        @Override
        public int getRowCount() {
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return this.columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex){
                case 0: return lista.get(rowIndex).getCodigo();
                case 1: return lista.get(rowIndex).getNombreDePractica();
                case 2: return lista.get(rowIndex).getHorasHastaResultado();
                case 3: return lista.get(rowIndex).isResultadosFinalizados();
                case 4: return lista.get(rowIndex).isValoresCriticos();
                case 5: return lista.get(rowIndex).isValoresReservados();
                case 6: return lista.get(rowIndex).getResultado();
                default: return null;
            }
        }

    }

    public static class MiTablaPeticiones extends AbstractTableModel{

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        private List<Peticion> lista= peticiones;
        protected String[] columnNames = new String[] {"Dni del paciente", "Numero Sucursal", "Id peticion", "Fecha de carga", "Practicas asociadas", "Peticion Activa", "Resultados finalizados"};
        protected Class[] columnClasses = new Class[] {String.class, String.class, String.class, String.class, JButton.class, Boolean.class, Boolean.class};

        public String getColumnName(int col) { return columnNames[col];}
        public Class getColumnClass(int col) { return columnClasses[col]; }

        @Override
        public int getRowCount() {
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return this.columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex){
                case 0: return lista.get(rowIndex).getPaciente().getDni();
                case 1: return lista.get(rowIndex).getSucursal().getNumero();
                case 2: return lista.get(rowIndex).getIdPeticion();
                case 3: return formatter.format(lista.get(rowIndex).getFechaDeCarga());
                case 4: final JButton button = new JButton(columnNames[columnIndex]);
                        button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            FrmVerPracticasAsociadas frame = new FrmVerPracticasAsociadas(FrmVerPeticiones.self,"Practicas Asociadas", rowIndex);
                            frame.setVisible(true);
                        }
                        });
                        return button;
                case 5: return lista.get(rowIndex).isPeticionActiva();
                case 6: return lista.get(rowIndex).getPracticasAsociadas().get(0).isResultadosFinalizados();
                default: return null;
            }
        }
    }

    private static Usuario toModelUsuario(UsuarioRolDTO dto){
        int numero = Integer.valueOf(dto.getNumeroDomicilioUsuario());
        Domicilio domicilio = new Domicilio(dto.getCalleDomicilioUsuario(), numero);
        int dni = Integer.valueOf(dto.getDniUsuario());
        Date date = new Date(Integer.valueOf(dto.getAñoNacimientoUsuario()), Integer.valueOf(dto.getMesNacimientoUsuario()), Integer.valueOf(dto.getDiaNacimientoUsuario()));
        roles rol = roles.valueOf(dto.getRolUsusario());
        Usuario usuario = new Usuario(dto.getNombreUsuario(), dto.getEmailUsuario(), dto.getPasswordUsuario(), dto.getNombreApellidoUsuario(), domicilio, dni, date, rol);
        return usuario;
    }

    public static Usuario findUsuarioByNombreUsuario(String nombreUsuario){
        String nombreUsuarioAux = nombreUsuario;
        for (int i = 0; i < usuarios.size(); i++) {
            if(nombreUsuarioAux.equals(usuarios.get(i).getNombreUsuario())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    private static Sucursal toModelSucursal(SucursalDTO dto){
        int numero = Integer.valueOf(dto.getNumeroSucursal());
        Usuario usuario = findUsuarioByNombreUsuario(dto.getResponsableTecnico());
        if(usuario == null) {
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese nombre de usuario");
            return null;
        }
        Sucursal sucursal = new Sucursal(numero, dto.getDireccionSucursal(), usuario);
        return sucursal;
    }

    private static Paciente toModelPaciente(PacienteDomicilioDTO dto){
        int numero = Integer.valueOf(dto.getNumeroDomicilio());
        Domicilio domicilio = new Domicilio(dto.getCalleDomicilioPaciente(), numero);
        int dni = Integer.valueOf(dto.getDniPaciente());
        ObraSocial obraSocial = new ObraSocial(dto.getNombreObraSocial(), dto.getCodigoObraSocial());
        int edad = Integer.valueOf(dto.getEdad());
        Paciente paciente = new Paciente(dni, dto.getNombrePaciente(), dto.getApellidoPaciente(), domicilio , obraSocial, dto.getMail(), dto.getSexo(), edad);
        return paciente;
    }
}

