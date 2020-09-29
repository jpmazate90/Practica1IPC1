
package pokeesmeralda;

public class Actividades {
    //atributos de la clase actividades
    private String nombreActividad;
    private String tipoActividad;
    private int darOQuitarSalud;
    private int cuentaActividades;
//constructor
    public Actividades(String nombreActividad, String tipoActividad, int darOQuitarSalud) {
        this.nombreActividad = nombreActividad;
        this.tipoActividad = tipoActividad;
        this.darOQuitarSalud = darOQuitarSalud;
        this.cuentaActividades = 0;
    }
// metodos de sets and gets
    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public int getDarOQuitarSalud() {
        return darOQuitarSalud;
    }

    public void setDarOQuitarSalud(int darOQuitarSalud) {
        this.darOQuitarSalud = darOQuitarSalud;
    }

    public int getCuentaActividades() {
        return cuentaActividades;
    }

    public void setCuentaActividades(int cuentaActividades) {
        this.cuentaActividades = cuentaActividades;
    }
    
    
}
