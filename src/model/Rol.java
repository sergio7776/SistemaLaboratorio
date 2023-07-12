package model;

import java.util.HashMap;
import java.util.Map;

public class Rol {

    private roles rol;

    private static final Map<roles, String> permisos = new HashMap<roles, String>();

    static {
        permisos.put(roles.Recepcion, "Cargar peticiones - Consultar resultados");
        permisos.put(roles.Laboratorista, "Procesa muestras - Carga los resultados");
        permisos.put(roles.Administrador, "Puede realizar todas las tareas");
    }

    public Rol(roles rol){
        this.rol = rol;
    }

    public roles getRol() {
        return rol;
    }

    public String getPermisos(){
        return permisos.get(this.rol);
    }
}
