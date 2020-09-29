
package pokeesmeralda;

import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    //atributos de la clase
    private int nivelPokemon=0;
    private int vidaPokemon=(nivelPokemon+1);
    private int experienciaPokemon=0;
    private int cantidadPokemonVivos;
    private int cantidadPokemonEnemigosDerrotados;
    private int cuentaComidas=0;
    private int cuentaActividades=0;
    private String estadoPokemon;
    private String estadoPokemonPelea;
    private String imagenASCCI;
    private String nombrePokemon;
    private int pokemonDerrotados;
    private int cantidadVecesHuida;
    private int cantidadVecesDesmayado;
    Comida[] historialComidas = new Comida[1000];
    Actividades[] historialActividades = new Actividades[1000];
    
    //constructor
    public Pokemon(String nombrePokemon, int vidaPokemon, int nivelPokemon, String estadoPokemon, String estadoPokemonPelea,String imagenASCCI){
    this.nombrePokemon = nombrePokemon;
    this.vidaPokemon = vidaPokemon;
    this.nivelPokemon = nivelPokemon;
    this.estadoPokemon = estadoPokemon;
    this.estadoPokemonPelea = estadoPokemonPelea;
    this.imagenASCCI= imagenASCCI;
    cantidadPokemonEnemigosDerrotados=0;
    cantidadPokemonVivos=0;
    cuentaComidas=0;
    cuentaActividades=0;
    experienciaPokemon=0;
    pokemonDerrotados=0;
    cantidadVecesHuida=0;
    cantidadVecesDesmayado=0;
    }
    // metodos sets and gets
    public int getNivelPokemon() {
        return nivelPokemon;
    }

    public void setNivelPokemon(int nivelPokemon) {
        this.nivelPokemon = nivelPokemon;
    }

    public int getVidaPokemon() {
        return vidaPokemon;
    }

    public void setVidaPokemon(int vidaPokemon) {
        this.vidaPokemon = vidaPokemon;
    }

    public int getExperienciaPokemon() {
        return experienciaPokemon;
    }

    public void setExperienciaPokemon(int experienciaPokemon) {
        this.experienciaPokemon = experienciaPokemon;
    }

    public int getCantidadPokemonVivos() {
        return cantidadPokemonVivos;
    }

    public void setCantidadPokemonVivos(int cantidadPokemonVivos) {
        this.cantidadPokemonVivos = cantidadPokemonVivos;
    }

    public int getCantidadPokemonEnemigosDerrotados() {
        return cantidadPokemonEnemigosDerrotados;
    }

    public void setCantidadPokemonEnemigosDerrotados(int cantidadPokemonEnemigosDerrotados) {
        this.cantidadPokemonEnemigosDerrotados = cantidadPokemonEnemigosDerrotados;
    }

    public int getCuentaComidas() {
        return cuentaComidas;
    }

    public void setCuentaComidas(int cuentaComidas) {
        this.cuentaComidas = cuentaComidas;
    }

    public int getCuentaActividades() {
        return cuentaActividades;
    }

    public void setCuentaActividades(int cuentaActividades) {
        this.cuentaActividades = cuentaActividades;
    }

    public String getEstadoPokemon() {
        return estadoPokemon;
    }

    public void setEstadoPokemon(String estadoPokemon) {
        this.estadoPokemon = estadoPokemon;
    }
    
    

    public String getEstadoPokemonPelea() {
        return estadoPokemonPelea;
    }

    public void setEstadoPokemonPelea(String estadoPokemonPelea) {
        this.estadoPokemonPelea = estadoPokemonPelea;
    }

    public String getImagenASCCI() {
        return imagenASCCI;
    }

    public void setImagenASCII(String imagenASCCI) {
        this.imagenASCCI = imagenASCCI;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public Comida getHistorialComidas(Comida historialComidas) {
        return historialComidas;
    }

    public void setHistorialComidas(Comida[] historialComidas) {
        this.historialComidas = historialComidas;
    }

    public Actividades[] getHistorialActividades() {
        return historialActividades;
    }

    public void setHistorialactividades(Actividades[] historialActividades) {
        this.historialActividades = historialActividades;
        
    }

    public int getPokemonDerrotados() {
        return pokemonDerrotados;
    }

    public void setPokemonDerrotados(int pokemonDerrotados) {
        this.pokemonDerrotados = pokemonDerrotados;
    }

    public int getCantidadVecesHuida() {
        return cantidadVecesHuida;
    }

    public void setCantidadVecesHuida(int cantidadVecesHuida) {
        this.cantidadVecesHuida = cantidadVecesHuida;
    }

    public int getCantidadVecesDesmayado() {
        return cantidadVecesDesmayado;
    }

    public void setCantidadVecesDesmayado(int cantidadVecesDesmayado) {
        this.cantidadVecesDesmayado = cantidadVecesDesmayado;
    }
    
    
    // sirve para que el pokemon ataque
    public int atacar(){
        Random numeroAleatorio1 = new Random();
        int numAleatorio1= (1 + numeroAleatorio1.nextInt(40))*(nivelPokemon+1);
        int daño = numAleatorio1;
        System.out.println(nombrePokemon+" ha atacado");
        System.out.println(nombrePokemon+" ha hecho un daño de: "+daño);
        return daño;
    }
//sirve para que el pokemon huya, cambia el estado de pelea
    
    public String huir(){
        String huir= "R";
        estadoPokemonPelea="huyo";
        cantidadVecesHuida++;
        return huir;
        
    }
    
    // cambia el estado de pelea de los pokemon
    
    public String cambiarEstadoPokemonPelea(String tEstadoPokemonPelea){
        this.estadoPokemonPelea= tEstadoPokemonPelea;
        return estadoPokemonPelea;
    }
    /*
        recibe daño el pokemon, y altera los estados segun la vida
    */
    public void recibirDaño(int tDaño){
        vidaPokemon-=tDaño;
        System.out.println(nombrePokemon+" recibio un golpe de: "+ tDaño);
        System.out.println("Ahora tiene de salud: "+vidaPokemon);
        if(vidaPokemon<=(100*(nivelPokemon+1)*0.25)){
            System.out.println("El pokemon se ha desmayado");
            cantidadVecesDesmayado++;
            estadoPokemonPelea="desmayado";
        }
        if(vidaPokemon<=0){
            System.out.println("El pokemon se ha muerto");
            vidaPokemon=0;
            estadoPokemonPelea="desmayado";
            estadoPokemon="muerto";
        }
    }
    // come la comida dada por los parametros
    public void comer(String tNombreComida, String tTipoComida, int tSaludMasOMenos){
        if("saludable".equals(tTipoComida)){
            System.out.println(nombrePokemon+" esta a punto de comer "+tNombreComida+ "esta comida es: "+tTipoComida);
            System.out.println(nombrePokemon+" se curara "+tSaludMasOMenos+" puntos de salud");
            if(vidaPokemon+tSaludMasOMenos>100*(nivelPokemon+1)){
                vidaPokemon=100*(nivelPokemon+1);
                System.out.println("La vida de "+nombrePokemon+" se ha regenerado al maximo");
            }
            else{
                vidaPokemon+=tSaludMasOMenos;
                System.out.println("La vida de "+nombrePokemon+" ahora es: "+vidaPokemon); 
            }
        }
        if("no saludable".equals(tTipoComida)){
            vidaPokemon+=tSaludMasOMenos;
            System.out.println(nombrePokemon+" esta a punto de comer "+tNombreComida+ " esta comida es: "+tTipoComida);
            System.out.println(nombrePokemon+" perdera "+tSaludMasOMenos+" puntos de salud");
            
            if((vidaPokemon+tSaludMasOMenos)<=(25*(nivelPokemon+1)) && vidaPokemon+tSaludMasOMenos>0){
                System.out.println(nombrePokemon+" se ha desmayado");
                cantidadVecesDesmayado++;
                estadoPokemonPelea = "desmayado";
            }
            if(vidaPokemon+tSaludMasOMenos<=0){
                vidaPokemon=0;
                estadoPokemon= "muerto";
                estadoPokemonPelea="desmayado";
                System.out.println("El pokemon esta muerto, su salud es: "+vidaPokemon);
            }
           
        }
         guardarHistorialComidas(tNombreComida, tTipoComida, tSaludMasOMenos);
    
    }
    // realiza la actividad dada por los parametros
    public void actividad(String tNombreActividad, String tTipoActividad, int tSaludMasOMenos){
        if("saludable".equals(tTipoActividad)){
            System.out.println(nombrePokemon+" esta a punto de realizar una actividad "+tNombreActividad+ " ,esta actividad es: "+tTipoActividad);
            System.out.println(nombrePokemon+" se curara "+tSaludMasOMenos+ " puntos de salud");
            if(vidaPokemon+tSaludMasOMenos>100*(nivelPokemon+1)){
                vidaPokemon=100*(nivelPokemon+1);
                estadoPokemon="vivo";
                estadoPokemonPelea="no activo";
                System.out.println("La vida de "+nombrePokemon+" se ha regenerado al maximo");
            }
            else{
                vidaPokemon+=tSaludMasOMenos; 
                System.out.println("La vida de "+nombrePokemon+" ahora es: "+vidaPokemon);
                if(vidaPokemon>=100*0.25*(nivelPokemon+1)){
                    estadoPokemon="vivo";
                    estadoPokemonPelea="no activo";
                }
                if(vidaPokemon<100*0.25*(nivelPokemon+1) && vidaPokemon>0){
                    System.out.println("El pokemon se ha desmayado");
                    cantidadVecesDesmayado++;
                    estadoPokemonPelea="desmayado";
                }
            }
            guardarHistorialActividades(tNombreActividad, tTipoActividad, tSaludMasOMenos);
        }
        if("no saludable".equals(tTipoActividad)){
            vidaPokemon+=tSaludMasOMenos;
            System.out.println(nombrePokemon+" esta a punto  de realizar una actividad "+tNombreActividad+" esta actividad es: "+tTipoActividad);
            System.out.println(nombrePokemon+" perdera "+tSaludMasOMenos+" puntos de salud");
            System.out.println(nombrePokemon+" tiene de vida: "+vidaPokemon);
            if(vidaPokemon+tSaludMasOMenos<=100*0.25*(nivelPokemon+1) && vidaPokemon+tSaludMasOMenos>0){
                System.out.println(nombrePokemon+" se ha desmayado");
                estadoPokemonPelea="desmayado";
                cantidadVecesDesmayado++;
            }
            if(vidaPokemon+tSaludMasOMenos<=0){
                estadoPokemon="muerto";
                estadoPokemonPelea="desmayado";
                vidaPokemon=0;        
                System.out.println(nombrePokemon+" se ha muerto, su vida es: "+vidaPokemon);   
            }
            guardarHistorialActividades(tNombreActividad, tTipoActividad, tSaludMasOMenos);
        }

    }
    /*
            recibe y suma la experiencia
    */
    public void recibirExperiencia(int experienciaRecibida){
        experienciaPokemon+=experienciaRecibida;
        System.out.println(nombrePokemon+" recibio experiencia: "+experienciaRecibida);
        System.out.println("Ahora tiene "+experienciaPokemon+ " puntos de experiencia");
        subirDeNivel();
    }   
    // sube de nivel a los pokemon
    public void subirDeNivel(){
        int subirDeNivel;
        int tempVerificarNivel;
        subirDeNivel=(experienciaPokemon%100);
        tempVerificarNivel=(experienciaPokemon-subirDeNivel)/100;
        if(tempVerificarNivel>nivelPokemon){
        nivelPokemon=tempVerificarNivel;
        System.out.println(nombrePokemon+" tiene de experiencia: "+experienciaPokemon);
        System.out.println("El nuevo nivel de "+nombrePokemon+" es "+nivelPokemon);
        vidaPokemon=100*(nivelPokemon+1);
        System.out.println("Su vida ahora es: "+vidaPokemon);
        }
    }
    // escoge la imagen ascci, es statico por lo que es parte del molde
    public static String escogerImagenASCCI(){
        Scanner scannerOpcionImagenASCCI= new Scanner(System.in);
        String escogerImagenASCCI=null;
        int numeroImagenASCCI;
        String[] opcionImagenASCCI= new String[6];
        System.out.println("Escoge que imagen ASCCI deseas pulsando el numero correspondiente");
        System.out.println("Opcion 1, pikachu");
        System.out.println(""
     + "\\:.             .:/\n" +
"        \\``._________.''/ \n" +
"         \\             / \n" +
" .--.--, / .':.   .':. \\\n" +
"/__:  /  | '::' . '::' |\n" +
"   / /   |`.   ._.   .'|\n" +
"  / /    |.'         '.|\n" +
" /___-_-,|.\\  \\   /  /.|\n" +
"      // |''\\.;   ;,/ '|\n" +
"      `==|:=         =:|\n" +
"         `.          .'\n" +
"           :-._____.-:\n" +
"          `''       `'' ");
    
        System.out.println("Opcion 2, bulbasaur");
        System.out.println("		"
      + "    `;,;.;,;.;.'\n" +
"              ..:;:;::;: \n" +
"        ..--''' '' ' ' '''--.  \n" +
"      /' .   .'        '.   .`\\\n" +
"     | /    /            \\   '.|\n" +
"     | |   :             :    :|\n" +
"   .'| |   :             :    :|\n" +
" ,: /\\ \\.._\\ __..===..__/_../ /`.\n" +
"|'' |  :.|  `'          `'  |.'  ::.\n" +
"|   |  ''|    :'';          | ,  `''\\\n" +
"|.:  \\/  | /'-.`'   ':'.-'\\ |  \\,   |\n" +
"| '  /  /  | / |...   | \\ |  |  |';'|\n" +
" \\ _ |:.|  |_\\_|`.'   |_/_|  |.:| _ |\n" +
"/,.,.|' \\__       . .      __/ '|.,.,\\\n" +
"     | ':`.`----._____.---'.'   |\n" +
"      \\   `:...-------'..' |   |\n" +
"       ',-,-',             .'-=,=,.");
    
        System.out.println("Opcion 3, Charmander");
        System.out.println("       "
    + "       _.--..`-..\n" +
"            ,'          `.\n" +
"          ,'          __  `.\n" +
"         /|          . __   \\\n" +
"        , |           / |.   .\n" +
"        |,'          !_.'|   |\n" +
"      ,'             '   |   |\n" +
"     /              |`--'|   |\n" +
"    |                `---'   |\n" +
"     .   ,                   |                       ,..\n" +
"      ._     '           _'  |                    , ' \\ `\n" +
"  `.. `.`-...___,...---..    |       __,.        ,`.   L,|\n" +
"  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\n" +
"-:..     `. `-..--_.,.<       `.      / `.        `-/ |   .\n" +
"  `,         ....'     `.              ,'         |   |  ',,\n" +
"    `.      '            '            /          '    |'. |/\n" +
"      `.   |              \\       _,-'           |       ''\n" +
"        `._'               \\   '.\\                .      |\n" +
"           |                '     \\                `._  ,'\n" +
"           |                 '     \\                 .'|\n" +
"           |                 .      \\                | |\n" +
"           |                 |       L              ,' |\n" +
"           `                 |       |             /   '\n" +
"            \\                |       |           ,'   /\n" +
"          ,' \\               |  _.._ ,-..___,..-'    ,'\n" +
"         /     .             .      `!             ,j'\n" +
"        /       `.          /        .           .'/\n" +
"       .          `.       /         |        _.'.'\n" +
"        `.          7`'---'          |------.'_.'\n" +
"       _,.`,_     _'                ,''-----.'\n" +
"   _,-_    '       `.     .'      ,\\\n" +
"   -. /`.         _,'     | _  _  _.|\n" +
"    ..--'---.....'        `' '! |! /\n" +
"                            `. . -' ");
        
        System.out.println("Opcion 4, Squirtle");
        System.out.println(""
            + " _,........__\n" +
"            ,-'            .`-.\n" +
"          ,'                   `-.\n" +
"        ,'                        \\\n" +
"      ,'                           .\n" +
"      .'\\               ,...       `\n" +
"     ._.'|             / |  `       \\\n" +
"     |   |            `-.'  ||       `.\n" +
"     |   |            '-._,'||       | \\\n" +
"     .`.,'             `..,'.'       , |`-.\n" +
"     l                       .'`.  _/  |   `.\n" +
"     `-.._'-   ,          _ _'   -. \\  .     `\n" +
"`......'-.`-...,---------','         `. `....__.\n" +
".'        `.-..___      __,'\\          \\  \\     \\\n" +
"\\_ .          |   `....'    `.           . \\     \\\n" +
"  `.          |              `.          |  .     L\n" +
"    `.        |`--...________.'.        j   |     |\n" +
"      `._    .'      |          `.     .|   ,     |\n" +
"         `--,\\       .            `7..' |  ,      |\n" +
"            ` `      `            /     |  |      |    _,-'...`-.\n" +
"             \\ `.     .          /      |  '      |  ,'          `.\n" +
"              \\  v.__  .        '       .   \\    /| /              \\\n" +
"               \\/    `..\\.......`.       \\   \\  /.''                |\n" +
"                `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
"                ,`-.      \\         ..     `.  |/        j     `    |\n" +
"               /    `.     \\       /         \\ /         |     /    j\n" +
"              |       `-.   7-.._ .          |.          '         /\n" +
"              |          `./_    `|          |            .     _,'\n" +
"              `.           / `----|          |-............`---'\n" +
"                \\          \\      |          |\n" +
"               ,'           )     `.         |\n" +
"                7____,,..--'      /          |\n" +
"                                  `---.__,--.'");
        System.out.println("Opcion 5, Catarperie");
        System.out.println("	"
                + "  _,........_\n" +
"               _.-'    ___    `-._\n" +
"            ,-'      ,'   \\       `.\n" +
" _,...    ,'      ,-'     |  ,...:`._.\n" +
"/     `--+.   _,.'      _.',',|.|  ` \\`\n" +
"\\_         `.'     _,-.'  | / `-'   l L\\\n" +
"  `.---.._      ,-.       | l       | | |\n" +
"      /   `.   |          ' `.     ,' ; |\n" +
"     j     |   |           `._`...' ,'  |__\n" +
"     |      `--'____          `----'    .' `.\n" +
"     |    _,-...    `-.                 |    \\\n" +
"     l   /             `.               F     l\n" +
"      `./     __..._     `.           ,'      |\n" +
"        |  ,-.      `.    | ._     _.'        |\n" +
"        . j           \\   j   /`...      __   |          ,.`.\n" +
"         `|           | _,.__ |        ,'  `. |          |   |\n" +
"          `-._       /-'     `L       .     , '          |   |\n" +
"              F-...-'          `      |    , /           |   |\n" +
"              |            ,----.     `...' /            |   |\n" +
"              .--.        j      l        ,'             |   j\n" +
"             j    L       |      |'-...--<               .  /\n" +
"             `     |       . __,,_    ..  |               \\/\n" +
"              `-..'.._  __,-'     \\  |  |/`._           ,'`\n" +
"                  |   ..       .--`. `--,  ,-`..____..,'   |\n" +
"                   L          /     \\ _.  |   | \\  .-.\\    j\n" +
"                  .'._        l     .\\    `---' |  |  || ,'\n" +
"                   .  `..____,-.._.'  `._       |  `--;.I'\n" +
"                    `--.' `.            ,`-..._/__,.-1,'\n" +
"                            `-.__  __,.'     ,' ,' _-'\n" +
"                                 `'...___..`'--^--'");
        
        
        
        opcionImagenASCCI[1]= "				"
     + "\\:.             .:/\n" +
"        \\``._________.''/ \n" +
"         \\             / \n" +
" .--.--, / .':.   .':. \\\n" +
"/__:  /  | '::' . '::' |\n" +
"   / /   |`.   ._.   .'|\n" +
"  / /    |.'         '.|\n" +
" /___-_-,|.\\  \\   /  /.|\n" +
"      // |''\\.;   ;,/ '|\n" +
"      `==|:=         =:|\n" +
"         `.          .'\n" +
"           :-._____.-:\n" +
"          `''       `'' ";
        
        opcionImagenASCCI[2]= "	"
           + "`;,;.;,;.;.'\n" +
"              ..:;:;::;: \n" +
"        ..--''' '' ' ' '''--.  \n" +
"      /' .   .'        '.   .`\\\n" +
"     | /    /            \\   '.|\n" +
"     | |   :             :    :|\n" +
"   .'| |   :             :    :|\n" +
" ,: /\\ \\.._\\ __..===..__/_../ /`.\n" +
"|'' |  :.|  `'          `'  |.'  ::.\n" +
"|   |  ''|    :'';          | ,  `''\\\n" +
"|.:  \\/  | /'-.`'   ':'.-'\\ |  \\,   |\n" +
"| '  /  /  | / |...   | \\ |  |  |';'|\n" +
" \\ _ |:.|  |_\\_|`.'   |_/_|  |.:| _ |\n" +
"/,.,.|' \\__       . .      __/ '|.,.,\\\n" +
"     | ':`.`----._____.---'.'   |\n" +
"      \\   `:...-------'..' |   |\n" +
"       ',-,-',             .'-=,=,.";
        
        opcionImagenASCCI[3]="   "
            + "_.--..`-..\n" +
"            ,'          `.\n" +
"          ,'          __  `.\n" +
"         /|          . __   \\\n" +
"        , |           / |.   .\n" +
"        |,'          !_.'|   |\n" +
"      ,'             '   |   |\n" +
"     /              |`--'|   |\n" +
"    |                `---'   |\n" +
"     .   ,                   |                       ,..\n" +
"      ._     '           _'  |                    , ' \\ `\n" +
"  `.. `.`-...___,...---..    |       __,.        ,`.   L,|\n" +
"  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\n" +
"-:..     `. `-..--_.,.<       `.      / `.        `-/ |   .\n" +
"  `,         ....'     `.              ,'         |   |  ',,\n" +
"    `.      '            '            /          '    |'. |/\n" +
"      `.   |              \\       _,-'           |       ''\n" +
"        `._'               \\   '.\\                .      |\n" +
"           |                '     \\                `._  ,'\n" +
"           |                 '     \\                 .'|\n" +
"           |                 .      \\                | |\n" +
"           |                 |       L              ,' |\n" +
"           `                 |       |             /   '\n" +
"            \\                |       |           ,'   /\n" +
"          ,' \\               |  _.._ ,-..___,..-'    ,'\n" +
"         /     .             .      `!             ,j'\n" +
"        /       `.          /        .           .'/\n" +
"       .          `.       /         |        _.'.'\n" +
"        `.          7`'---'          |------.'_.'\n" +
"       _,.`,_     _'                ,''-----.'\n" +
"   _,-_    '       `.     .'      ,\\\n" +
"   -. /`.         _,'     | _  _  _.|\n" +
"    ..--'---.....'        `' '! |! /\n" +
"                            `. . -' ";
    opcionImagenASCCI[4]= "	"
            + "_,........__\n" +
"            ,-'            .`-.\n" +
"          ,'                   `-.\n" +
"        ,'                        \\\n" +
"      ,'                           .\n" +
"      .'\\               ,...       `\n" +
"     ._.'|             / |  `       \\\n" +
"     |   |            `-.'  ||       `.\n" +
"     |   |            '-._,'||       | \\\n" +
"     .`.,'             `..,'.'       , |`-.\n" +
"     l                       .'`.  _/  |   `.\n" +
"     `-.._'-   ,          _ _'   -. \\  .     `\n" +
"`......'-.`-...,---------','         `. `....__.\n" +
".'        `.-..___      __,'\\          \\  \\     \\\n" +
"\\_ .          |   `....'    `.           . \\     \\\n" +
"  `.          |              `.          |  .     L\n" +
"    `.        |`--...________.'.        j   |     |\n" +
"      `._    .'      |          `.     .|   ,     |\n" +
"         `--,\\       .            `7..' |  ,      |\n" +
"            ` `      `            /     |  |      |    _,-'...`-.\n" +
"             \\ `.     .          /      |  '      |  ,'          `.\n" +
"              \\  v.__  .        '       .   \\    /| /              \\\n" +
"               \\/    `..\\.......`.       \\   \\  /.''                |\n" +
"                `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
"                ,`-.      \\         ..     `.  |/        j     `    |\n" +
"               /    `.     \\       /         \\ /         |     /    j\n" +
"              |       `-.   7-.._ .          |.          '         /\n" +
"              |          `./_    `|          |            .     _,'\n" +
"              `.           / `----|          |-............`---'\n" +
"                \\          \\      |          |\n" +
"               ,'           )     `.         |\n" +
"                7____,,..--'      /          |\n" +
"                                  `---.__,--.'";
    
    opcionImagenASCCI[5]= ""
            + "    _,........_\n" +
"               _.-'    ___    `-._\n" +
"            ,-'      ,'   \\       `.\n" +
" _,...    ,'      ,-'     |  ,...:`._.\n" +
"/     `--+.   _,.'      _.',',|.|  ` \\`\n" +
"\\_         `.'     _,-.'  | / `-'   l L\\\n" +
"  `.---.._      ,-.       | l       | | |\n" +
"      /   `.   |          ' `.     ,' ; |\n" +
"     j     |   |           `._`...' ,'  |__\n" +
"     |      `--'____          `----'    .' `.\n" +
"     |    _,-...    `-.                 |    \\\n" +
"     l   /             `.               F     l\n" +
"      `./     __..._     `.           ,'      |\n" +
"        |  ,-.      `.    | ._     _.'        |\n" +
"        . j           \\   j   /`...      __   |          ,.`.\n" +
"         `|           | _,.__ |        ,'  `. |          |   |\n" +
"          `-._       /-'     `L       .     , '          |   |\n" +
"              F-...-'          `      |    , /           |   |\n" +
"              |            ,----.     `...' /            |   |\n" +
"              .--.        j      l        ,'             |   j\n" +
"             j    L       |      |'-...--<               .  /\n" +
"             `     |       . __,,_    ..  |               \\/\n" +
"              `-..'.._  __,-'     \\  |  |/`._           ,'`\n" +
"                  |   ..       .--`. `--,  ,-`..____..,'   |\n" +
"                   L          /     \\ _.  |   | \\  .-.\\    j\n" +
"                  .'._        l     .\\    `---' |  |  || ,'\n" +
"                   .  `..____,-.._.'  `._       |  `--;.I'\n" +
"                    `--.' `.            ,`-..._/__,.-1,'\n" +
"                            `-.__  __,.'     ,' ,' _-'\n" +
"                                 `'...___..`'--^--' ";
        
        System.out.println("Pulsa el numero de la imagen que deseas");
        numeroImagenASCCI= scannerOpcionImagenASCCI.nextInt();
        escogerImagenASCCI=opcionImagenASCCI[numeroImagenASCCI];
        return escogerImagenASCCI;
    }

    
       // guarda el historial de comidas
    public void guardarHistorialComidas(String tNombreComida, String tTipoComida, int tDarOQuitarSalud){
            historialComidas[cuentaComidas] = new Comida(tTipoComida,tNombreComida,tDarOQuitarSalud);
            cuentaComidas++;
 
    }
    // muestra el historial de ccomidas en orden desscendente
    public void mostrarHistorialComidasDescendentes(){
        if(historialComidas[0]==null){
            System.out.println(nombrePokemon);
            System.out.println("NO HA INGERIDO NADA");
        }
        else{
            for(int i=0;i<=cuentaComidas && historialComidas[i]!=null;i++){
            System.out.println(nombrePokemon+" ha ingerido "+historialComidas[i].getNombreComida());
            System.out.println("El tipo de comida es: "+historialComidas[i].getTipoComida());
            System.out.println("Puntos de salud dados o quitados, dependiendo del simbolo es: "+historialComidas[i].getDarOQuitarSalud());
            }
        }
    }
    // muestra el historial de ccomidas en orden ascendente
    public void mostrarHistorialComidasAscendentes(){
        if(historialComidas[0]==null){
            System.out.println(nombrePokemon);
            System.out.println("NO HA INGERIDO NADA");
        }
        else{
            for(int i=cuentaComidas; i>=0;i--){
                if(historialComidas[i]==null){
                    
                }
                else{
                    System.out.println(nombrePokemon+" ha ingerido "+historialComidas[i].getNombreComida());
                    System.out.println("El tipo de comida es: "+historialComidas[i].getTipoComida());
                    System.out.println("Puntos de salud dados o quitados, dependiendo del simbolo es: "+historialComidas[i].getDarOQuitarSalud());
                    System.out.println("");
                }
            }
        }
    }
    // guarda el historial de actividades 
    public void guardarHistorialActividades(String tNombreActividad, String tTipoActividad, int tDarOQuitarSalud){
        historialActividades[cuentaActividades]= new Actividades(tNombreActividad,tTipoActividad,tDarOQuitarSalud);
        cuentaActividades++;
    }
    // muestra el historial de actividades en orden descendente
    public void mostrarHistorialActividadesDescendentes(){
        if(historialActividades[0]==null){
            System.out.println(nombrePokemon);
            System.out.println("NO HA HECHO NINGUNA ACTIVIDAD");
        }
        else{
            for(int i=0; i<=cuentaActividades && historialActividades[i]!=null;i++){
                System.out.println(nombrePokemon+"   ha hecho una actividad "+historialActividades[i].getNombreActividad());
                System.out.println("El tipo de actividad es: "+historialActividades[i].getTipoActividad());
                System.out.println("Puntos de salud dados o quitados, dependiendo del simbolo es: "+historialActividades[i].getDarOQuitarSalud());   
            }
        }
    }
    //muestra el historial de actividades en orden ascendente
    public void mostrarHistorialActividadesAscendentes(){
        if(historialActividades[0]==null){
            System.out.println(nombrePokemon);
            System.out.println("NO HA HECHO NINGUNA ACTIVIDAD");
        }
        else{
            for(int i=cuentaActividades; i>=0 ;i--){
                if(historialActividades[cuentaActividades]==null){
                    
                }
                else{
                System.out.println(nombrePokemon+" ha hecho una actividad "+historialActividades[i].getNombreActividad());
                System.out.println("El tipo de actividad es: "+historialActividades[i].getTipoActividad());
                System.out.println("Puntos de salud dados o quitados, dependiendo del simbolo es: "+historialActividades[i].getDarOQuitarSalud());   
                }
            }
        }
    }
    // cuenta la comida buena
    public int contarComidasBuenas(){
        int cantidadComidaBuena=0;

        for(int i=0;i<cuentaComidas;i++){
            if("saludable".equals(historialComidas[i].getTipoComida())){
                cantidadComidaBuena++;
            }
        }
        return cantidadComidaBuena;
    }
    // cuenta la comida mala
    public int contarComidaMala(){
        int cantidadComidaMala=0;
        for(int i=0;i<cuentaComidas;i++){
            if("no saludable".equals(historialComidas[i].getTipoComida())){
                cantidadComidaMala++;
            }
        }
        return cantidadComidaMala;
    }
    // muestra las estadisticas del pokemon
    public void mostrarEstadisticasPokemon(){
        System.out.println("Nombre: "+nombrePokemon);
        System.out.println("Vida:" +vidaPokemon);
        System.out.println("Experiencia:" +experienciaPokemon);
        System.out.println("Nivel. "+nivelPokemon);
        System.out.println("Pokemon Derrotados: "+pokemonDerrotados);
        System.out.println("Veces que ha huido: "+cantidadVecesHuida);
        System.out.println("Veces que se ha desmayado: "+cantidadVecesDesmayado);
        System.out.println("Imagen:");
        System.out.println(imagenASCCI);
    }
}

    
//cantidadVecesHuida
//cantidadVecesMuerto
//pokemonDerrotados