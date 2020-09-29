
package pokeesmeralda;

public class Comida {
    //atributos de la clase comida
    private String tipoComida;
    private String nombreComida;
    private int  darOQuitarSalud;

// constructor
    public Comida(String tipoComida, String nombreComida, int darOQuitarSalud) {
        this.tipoComida = tipoComida;
        this.nombreComida = nombreComida;
        this.darOQuitarSalud = darOQuitarSalud;

    }
// metodos sets and gets
    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public int getDarOQuitarSalud() {
        return darOQuitarSalud;
    }

    public void setDarOQuitarSalud(int darOQuitarSalud) {
        this.darOQuitarSalud = darOQuitarSalud;
    }

    
}
