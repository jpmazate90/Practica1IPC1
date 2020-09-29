
package pokeesmeralda;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PokeEsmeralda {
    // variables globales
    public static int opcionMenuPrincipal;
    public static Scanner scannerMenuPrincipal = new Scanner(System.in);
    public static int cantidadPokemon=0;
    public static Pokemon[] pokemon = new Pokemon[5];
    public static Comida[] comidas = new Comida[6];
    public static Actividades[] actividades = new Actividades[6];
    public static int escogerPokemonActivo=0;
    private static int historialBatallasTotales=0;
    private static int historialBatallasGanadas=0;
    private static int historialBatallasPerdidas=0;
    private static boolean pokemonVivos=false;
    private static boolean pokemonMuertos=false;
    private static boolean pokemonParaLuchar=false;
    private static boolean claveTerminarBatalla=false;
    private static boolean ganasteLaBatalla=false;
    
    // metodo para crear un pokemon
    public static void crearPokemon(){
        boolean existeNombreIgual=false;
        String nombrePokemon=null;
        int nombreRepetido=0;
        Scanner scannerNombrePokemon = new Scanner(System.in);
        if(cantidadPokemon==5){
            System.out.println("Ya no puedes tener mas pokemon, el limite es 5");        
        }else{
            System.out.println("Dinos cual es el nombre que le deseas poner a tu pokemon:");
            nombrePokemon = scannerNombrePokemon.nextLine();
            for(int t=0;t<pokemon.length;t++){
                if(pokemon[t]==null){
                    
                }
                else{
                
                for(int q=0;q<pokemon.length && pokemon[t].getNombrePokemon().equals(nombrePokemon) ;q++){
                    nombreRepetido++;
                }
                
                if(pokemon[t].getNombrePokemon().equals(nombrePokemon) && nombreRepetido>1){
                    System.out.println("Ese nombre no se puede utilizar, ya esta en otro pokemon");
                    existeNombreIgual = true;
                    crearPokemon();
                    
                }
                }
            }
            if(!existeNombreIgual){
                String escogerImagenASCCI;
                Scanner scannerEscogerImagenASCCI = new Scanner(System.in);
                for(int k=0;k<pokemon.length;k++){
                
                    if(pokemon[k]==null){
                        escogerImagenASCCI= Pokemon.escogerImagenASCCI();
                        pokemon[k]= new Pokemon(nombrePokemon,100,0,"vivo", "no activo", escogerImagenASCCI); 
                        cantidadPokemon++;
                        System.out.println("Creaste un pokemon llamado: "+pokemon[k].getNombrePokemon());
                        System.out.println("Su vida es: "+pokemon[k].getVidaPokemon());
                        System.out.println("Su nivel es: "+pokemon[k].getNivelPokemon());
                        System.out.println("Su imagen es: ");
                        System.out.println(pokemon[k].getImagenASCCI());
                        System.out.println("");
                        break;
                    }
                    
                
                }
            }
        }
           
        
    }
    // FUNCIONA AL CIEN
    // se escoge el pokemon activo
    public static int escogerPokemonActivo(){
        Scanner scannerEscogerPokemonActivo = new Scanner(System.in);
        verificarSiHayPokemonVivos();
        verificarSiHayPokemonParaLuchar();
        if(pokemonVivos==true && pokemonParaLuchar==true ){
            System.out.println("Escoge que pokemon quieres que te acompañe y este activo");
            for(int i=0;i<pokemon.length;i++){
                if(pokemon[i]==null){
                    
                }
                else{
                    if("huyo".equals(pokemon[i].getEstadoPokemonPelea()) || "desmayado".equals(pokemon[i].getEstadoPokemonPelea())){
                        System.out.println(i+".-"+ pokemon[i].getNombrePokemon()+ " estado: "+pokemon[i].getEstadoPokemonPelea()+" vida: "+pokemon[i].getVidaPokemon());
                    }else{
                        System.out.println((i)+".-"+pokemon[i].getNombrePokemon()+ " estado: "+pokemon[i].getEstadoPokemon()+ " vida: "+pokemon[i].getVidaPokemon());
                    }
                }
            }
            escogerPokemonActivo= scannerEscogerPokemonActivo.nextInt();
            
            // si no esta vivo no se puede escoger como activo
            while(!"vivo".equals(pokemon[escogerPokemonActivo].getEstadoPokemon()) || "huyo".equals(pokemon[escogerPokemonActivo].getEstadoPokemonPelea()) || "desmayado".equals(pokemon[escogerPokemonActivo].getEstadoPokemonPelea())){
                System.out.println("Este pokemon no es posible tenerlo activo, esta desmayado, huido o muerto, escoge otro:");
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i]==null){}
                    else{
                        if("huyo".equals(pokemon[i].getEstadoPokemonPelea()) || "desmayado".equals(pokemon[i].getEstadoPokemonPelea())){
                            System.out.println(i+".-"+ pokemon[i].getNombrePokemon()+ " estado: "+pokemon[i].getEstadoPokemonPelea()+" vida: "+pokemon[i].getVidaPokemon());
                        }else{
                            System.out.println((i)+".-"+pokemon[i].getNombrePokemon()+ " estado: "+pokemon[i].getEstadoPokemon()+ " vida: "+pokemon[i].getVidaPokemon());
                        }
                    }
                }
                escogerPokemonActivo= scannerEscogerPokemonActivo.nextInt();
            }
            if("vivo".equals(pokemon[escogerPokemonActivo].getEstadoPokemon())){
                pokemon[escogerPokemonActivo].cambiarEstadoPokemonPelea("activo");
                System.out.println("El pokemon activo es: "+pokemon[escogerPokemonActivo].getNombrePokemon());
                return escogerPokemonActivo;
            }
        }
        else{
        
            System.out.println("No tienes pokemon para tenerlo activo");
            return escogerPokemonActivo;
        }
        return escogerPokemonActivo;
    }
    // funciona al cien
    // sirve para revivir o eliminar un pokemon, si no hay muertos no entra el menu
    public static void revivirOEliminarPokemon(){
        int revivirOEliminar;
        Scanner scannerOpcionPokemonARevivirOEliminar = new Scanner(System.in);
        Scanner scannerRevivirOEliminar = new Scanner(System.in);
        pokemonMuertos=false;
        verificarSiHayPokemonMuertos();
        if(pokemonMuertos==true){
            
            System.out.println("Escoge que pokemon deseas revivir o eliminar");
            for(int j=0;j<pokemon.length ;j++){
                if(pokemon[j]==null){}
                else{
                if(!"muerto".equals(pokemon[j].getEstadoPokemon())){
                    System.out.println(j+ ".- el Pokemon en esta casilla esta vivo");
                }
                else{
                    System.out.println(j+".- "+pokemon[j].getNombrePokemon()+ "  Estado: "+pokemon[j].getEstadoPokemon());
                    
                } 
                }
            }
                escogerPokemonActivo= scannerOpcionPokemonARevivirOEliminar.nextInt();
                
                System.out.println(pokemon[escogerPokemonActivo].getNombrePokemon());
                System.out.println("¿Que deseas hacerle?\n1.-Revivirlo\n2.-Eliminarlo");
                revivirOEliminar= scannerRevivirOEliminar.nextInt();
                switch(revivirOEliminar){
                    case 1: actividades(); break;
                    case 2: eliminarPokemon(); break;
                }
        }
        else{
            System.out.println("No tienes pokemon muertos");
            System.out.println("");
        
        }
        
    }
    // elimina por completo el pokemon
    public static void eliminarPokemon(){
        pokemon[escogerPokemonActivo]=null;
        cantidadPokemon--;
    }
    
    // enlista las actividades que existen, solo este menu puede revivir a un pokemon
    public static void actividades(){
        int opcionActividades;
        Scanner scannerOpcionActividades = new Scanner(System.in);
        System.out.println("Existen 3 actividades saludables");
        for(int i=0;i<3;i++){
            System.out.println((i)+".- "+actividades[i].getNombreActividad());
        }
        System.out.println("Y 3 actividades no saludables");
        for(int i=3;i<6;i++){
            System.out.println((i)+".- "+actividades[i].getNombreActividad());
        }
        System.out.println("Escoge que actividad deseas realizar, con el numero correspondiente");
        opcionActividades= scannerOpcionActividades.nextInt();
        pokemon[escogerPokemonActivo].actividad(actividades[opcionActividades].getNombreActividad(), actividades[opcionActividades].getTipoActividad(), actividades[opcionActividades].getDarOQuitarSalud());
        
    }
    //enlista las comidas que existen,  si se quiere alimentar con un pokemon muerto no deja
    public static void alimentacion(){
        int opcionAlimentacion;
        if("muerto".equals(pokemon[escogerPokemonActivo].getEstadoPokemon())){
            System.out.println("No puedes revivir un pokemon con una comida, solo con una actividad, ve al menu actividad");
        }
        else{
            Scanner scannerOpcionAlimentacion = new Scanner(System.in);
            System.out.println("Existen 3 comidas saludables");
            for(int i=0;i<3;i++){
                System.out.println((i)+".- "+comidas[i].getNombreComida());
            }
            System.out.println("Y 3 comidas no saludables");
            for(int i=3;i<6;i++){
                System.out.println((i)+".- "+comidas[i].getNombreComida());
            }
            System.out.println("Escoge que alimento deseas comer, con el numero correspondiente");
            opcionAlimentacion = scannerOpcionAlimentacion.nextInt();
            pokemon[escogerPokemonActivo].comer(comidas[opcionAlimentacion].getNombreComida(), comidas[opcionAlimentacion].getTipoComida(),comidas[opcionAlimentacion].getDarOQuitarSalud());
    
        }
    }
    // muestra el menu cuando se esta en batalla
    public static void menuBatalla(){
        verificarSiHayPokemonVivos();
        verificarSiHayPokemonParaLuchar();
        if(pokemonVivos==true && pokemonParaLuchar== true){
            System.out.println("Estas en batalla");
            System.out.println("El turno de quien ataca sera escogido aleatoriamente");
            elegirTurno();
        }
        else{
            System.out.println("No tienes pokemon para pelear");
        }
    }
    // elige el turno aleatoriamente
    public static void elegirTurno(){
        Random randomNumAleatorio3 = new Random();
        int numAleatorio3= 1 + randomNumAleatorio3.nextInt(2);
        if(numAleatorio3==1){
            opcionesDePelea();
        }else{
            System.out.println("INGRESE ESTE CODIGO EN EL SOFTWARE DEL RIVAL");
            System.out.println(""+pokemon[escogerPokemonActivo].getNombrePokemon()+""+"|0");
            leerCodigo();
            opcionesDePelea();
        }
        
    }
    // verifica si hay pokemon para pelear
    public static void verificarSiHayPokemonParaLuchar(){
        pokemonParaLuchar=false;
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                if("activo".equals(pokemon[i].getEstadoPokemonPelea()) || "no activo".equals(pokemon[i].getEstadoPokemonPelea())){
                    
                        pokemonParaLuchar=true;
                    }
                
                else{
                    pokemonParaLuchar=false;
                }
            }
        } 
    }
    // devuelve un valor booleano si hay pokemon vivos 
    public static boolean verificarSiHayPokemonVivos(){
        pokemonVivos=false;
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                if("vivo".equals(pokemon[i].getEstadoPokemon()) ){
                    pokemonVivos=true;
                    return pokemonVivos;
                }
            }
        }
        return pokemonVivos;
        
    }
    // devuelve valor booleano verdadero si hay pokemon muertos
    public static boolean verificarSiHayPokemonMuertos(){
        pokemonMuertos=false;
        for(int j=0;j<pokemon.length;j++){
            if(pokemon[j]==null){}
            else{
                if("muerto".equals(pokemon[j].getEstadoPokemon())){
                    pokemonMuertos=true;
                    return pokemonMuertos;
                }   
            }
        }
        return pokemonMuertos;
    }
    // gestiona toda la pelea 
    public static void opcionesDePelea(){
        int opcionesDePelea;
        int dañoHecho;
        String huir;
        Scanner scannerOpcionesDePelea = new Scanner(System.in);
        verificarSiHayPokemonVivos();
        verificarSiHayPokemonParaLuchar();
        ganasteLaBatalla=false;
        while(pokemonVivos==true  && pokemonParaLuchar==true && claveTerminarBatalla==false){
            claveTerminarBatalla=false;
            System.out.println("Es tu turno");
            System.out.println("Elige la opcion que desees:");
            System.out.println("1.- Atacar\n2.- Huir");
            opcionesDePelea= scannerOpcionesDePelea.nextInt();
            if(opcionesDePelea==1){
                dañoHecho=pokemon[escogerPokemonActivo].atacar();
                generarCodigo(dañoHecho);
                leerCodigo();
            }
            else{
                huir=pokemon[escogerPokemonActivo].huir();
                generarCodigo(huir);
                verificarSiHayPokemonVivos();
                verificarSiHayPokemonParaLuchar();
                if(pokemonVivos==true && pokemonParaLuchar==true){
                escogerPokemonActivo();
                }
                else{
                    verificarQuienGanoLaBatalla();
                    
                }
            }
            verificarSiHayPokemonVivos();
            verificarSiHayPokemonParaLuchar();
            
        }
        
        if(claveTerminarBatalla=true && ganasteLaBatalla==true){
            
            repartirExperiencia();
            
        }
        if(claveTerminarBatalla==true && ganasteLaBatalla==false){
            System.out.println("La batalla ha terminado, has perdido");
        }
        if(pokemonVivos==false && claveTerminarBatalla==false){
            System.out.println("No se puede pelear no tienes pokemon");
        }
    }
    // genera codigo con un entero
    public static void generarCodigo(int dañoHechoT){
        System.out.println("INGRESE ESTE CODIGO EN EL SOTWARE DEL RIVAL");
        System.out.println(pokemon[escogerPokemonActivo].getNombrePokemon()+"|"+dañoHechoT);
        

    }
    // sobrecarga el metodo y gnera codigo con un string (polimorfismo)
    public static void generarCodigo(String huirT){
        System.out.println("INGRESE ESTE CODIGO EN EL SOFTWARE DEL RIVAL ");
        System.out.println(pokemon[escogerPokemonActivo].getNombrePokemon()+"|"+huirT);
        pokemon[escogerPokemonActivo].huir();
    }
    // mira quien gano la batalla
    public static boolean verificarQuienGanoLaBatalla(){
        ganasteLaBatalla=false;
        Scanner scannerQuienGanoLaBatalla = new Scanner(System.in);
        String quienGanoLaBatalla;
        System.out.println("¿Ganaste la batalla?, [S]i , [N]o");
        quienGanoLaBatalla= scannerQuienGanoLaBatalla.nextLine();
       if("s".equals(quienGanoLaBatalla) || "S".equals(quienGanoLaBatalla)){
           ganasteLaBatalla= true;
           claveTerminarBatalla=true;
           historialBatallasGanadas++;
           
       }else{
           ganasteLaBatalla=false;
           claveTerminarBatalla=true;
           historialBatallasPerdidas++;
       }
       historialBatallasTotales++;
       regresarPokemonASuEstadoPokemon();
        return ganasteLaBatalla;
        
    }
    // al terminar la batalla pone coo vivo a los que estan desmayados
    public static void regresarPokemonASuEstadoPokemon(){
        for(int k=0;k<pokemon.length;k++){
            if(pokemon[k]==null){
                
            }else{
                if("huyo".equals(pokemon[k].getEstadoPokemonPelea())){
                    pokemon[k].setEstadoPokemonPelea("no activo");
                    pokemon[k].setEstadoPokemon("vivo");
                }
                if("desmayado".equals(pokemon[k].getEstadoPokemonPelea()) && !"muerto".equals(pokemon[k].getEstadoPokemon())){
                    pokemon[k].setEstadoPokemonPelea("no activo");
                    pokemon[k].setEstadoPokemon("vivo");
                }
            }
            
        }
    }
    // lee el codigo del contrincante
    public static void leerCodigo(){
        Scanner scannerCodigoDelRival = new Scanner(System.in);
        String codigoDelRival;
        int factorHechoEntero;
        String factorHechoCadena;
        String huida;
        String nombreEnemigo;
        int posicion, dañoEnemigo;
        System.out.println("Ingrese el codigo del rival");
        codigoDelRival = scannerCodigoDelRival.nextLine();
        posicion = codigoDelRival.indexOf("|");
        nombreEnemigo= codigoDelRival.substring(0, posicion);
        try{
            factorHechoEntero= Integer.parseInt(codigoDelRival.substring(posicion+1));
            System.out.println(nombreEnemigo+" te esta atacando");
            pokemon[escogerPokemonActivo].recibirDaño(factorHechoEntero);
            if(!"activo".equals(pokemon[escogerPokemonActivo].getEstadoPokemonPelea())  ){
                escogerPokemonActivo();
                if(pokemonVivos==false){
                    System.out.println("La batalla ha terminado");
                    verificarQuienGanoLaBatalla();
                }
            }
        }catch(Exception miExcepcion){
            factorHechoCadena=codigoDelRival.substring(posicion+1);    
            if("R".equals(factorHechoCadena) || "r".equals(factorHechoCadena)){
               pokemon[escogerPokemonActivo].setPokemonDerrotados(pokemon[escogerPokemonActivo].getPokemonDerrotados()+1);
            }
            
            if("T".equals(factorHechoCadena) || "t".equals(factorHechoCadena)){
                claveTerminarBatalla=true;
                verificarQuienGanoLaBatalla();
            }
            
        }
    }
    // reparte experiencia segun las condiciones dadas
    public static void repartirExperiencia(){
        Scanner scannerSaludPokemonEnemigoQuitada = new Scanner(System.in);
       final double PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_VIVO_1= 0.6;
       final double PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_MUERTO_1= 0.4;
       final double PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_VIVO_2= 0.9;
       final double PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_MUERTO_2= 0.1;
       int pokemonVivosEnBatalla=0, pokemonMuertosEnBatalla=0;
       int numAlmacenarExperiencia1, numAlmacenarExperiencia2;
       int numAlmacenarExperiencia3, numAlmacenarExperiencia4;
       int saludPokemonEnemigoQuitada;
       for(int i=0;i<pokemon.length;i++){
           if(pokemon[i]==null){}
           else{
                if(!"desmayado".equals(pokemon[i].getEstadoPokemonPelea()) && !"muerto".equals(pokemon[i].getEstadoPokemon())){
                    pokemonVivosEnBatalla++;
                }
                else{
                    pokemonMuertosEnBatalla++;
                }
            }
       }
        System.out.println("Ingrese la cantidad de vida que rebajo de los pokemon enemigos");
        saludPokemonEnemigoQuitada=scannerSaludPokemonEnemigoQuitada.nextInt();
        if(pokemonVivosEnBatalla==0){
            numAlmacenarExperiencia1=saludPokemonEnemigoQuitada/pokemonMuertosEnBatalla;
            for(int p=0;p<pokemon.length ;p++)
                if(pokemon[p]==null){}
                else{
                    pokemon[p].recibirExperiencia(numAlmacenarExperiencia1);
                }
        }
        if(pokemonMuertosEnBatalla==0){
            numAlmacenarExperiencia1=saludPokemonEnemigoQuitada/pokemonVivosEnBatalla;
            for(int h=0;h<pokemon.length; h++){
                if( pokemon[h]==null){}
                else{
                    pokemon[h].recibirExperiencia(numAlmacenarExperiencia1);
                }
            }
        }
        else{
            if(pokemonVivosEnBatalla<=pokemonMuertosEnBatalla){
                numAlmacenarExperiencia1 = (int) (PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_VIVO_1*saludPokemonEnemigoQuitada);
                numAlmacenarExperiencia2 = numAlmacenarExperiencia1/pokemonVivosEnBatalla;
                numAlmacenarExperiencia3 = (int) (PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_MUERTO_1*saludPokemonEnemigoQuitada);
                numAlmacenarExperiencia4 = numAlmacenarExperiencia3/pokemonMuertosEnBatalla;
                for(int j=0;j<pokemon.length && pokemon[j]!=null;j++){
                    if(!"desmayado".equals(pokemon[j].getEstadoPokemonPelea()) && !"muerto".equals(pokemon[j].getEstadoPokemon())){
                        pokemon[j].recibirExperiencia(numAlmacenarExperiencia2);
                    }
                else{
                    pokemon[j].recibirExperiencia(numAlmacenarExperiencia4);
                }
                pokemon[j].subirDeNivel();
                }
            }
            else{
                numAlmacenarExperiencia1 = (int) (PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_VIVO_2*saludPokemonEnemigoQuitada);
                numAlmacenarExperiencia2 = numAlmacenarExperiencia1/pokemonVivosEnBatalla;
                numAlmacenarExperiencia3 = (int) (PORCENTAJE_PARA_DISTRIBUIR_EXPERIENCIA_MUERTO_2*saludPokemonEnemigoQuitada);
                numAlmacenarExperiencia4 = numAlmacenarExperiencia3/pokemonMuertosEnBatalla;
                for(int k=0;k<pokemon.length ;k++){
                    if(pokemon[k]==null){}
                    else{
                        if(!"desmayado".equals(pokemon[k].getEstadoPokemonPelea()) && !"muerto".equals(pokemon[k].getEstadoPokemon())){
                            pokemon[k].recibirExperiencia(numAlmacenarExperiencia2);
                        }
                        else{
                            pokemon[k].recibirExperiencia(numAlmacenarExperiencia4);
                        }   
                        pokemon[k].subirDeNivel();
                    }
                }
            }
        }
        
    }
    
    // muestra el historial de batalla
    public static void mostrarHistorialDeBatallas(){
        System.out.println("La cantidad de batallas realizadas es: "+historialBatallasTotales);
        System.out.println("La cantidad de batallas ganadas es: "+historialBatallasGanadas);
        System.out.println("La cantidad de batallas perdidas es: "+historialBatallasPerdidas);
    }
    // muestra el menu de reportes
    public static void reportes() throws IOException{
        int reportes;
        Scanner scannerReportes = new Scanner(System.in);
        System.out.println("Selecciona que reporte quieres ver");
        System.out.println("1.-Reporte de estado de los pokemon\n2.-Reporte de alimentos 1\n3.-Reporte de alimentos 2\n4.-Reporte visual\n5.-Reporte de actividades\n6.-Reporte de mejor y peor alimento\n7.-Reporte de Batallas\n8.-Reporte de mejor y peor pokemon Guerrero\n9.-Salir");
        reportes = scannerReportes.nextInt();
        while(reportes!=9){
            switch(reportes){
                case 1: reporteEstadoPokemon(); break;
                case 2: reporteAlimentos1(); break;
                case 3: reporteAlimentos2(); break;
                case 4: reporteVisual(); break;
                case 5: reporteActividades(); break;
                case 6: reporteMejorPeorAlimento(); break;
                case 7: reporteBatallas(); break;
                case 8: reporteMejorPeorPokemonGuerrero(); break;
            }
            System.out.println("¿Quieres ver algun otro reporte?");
            System.out.println("1.-Reporte de estado de los pokemon\n2.-Reporte de alimentos 1\n3.-Reporte de alimentos 2\n4.-Reporte visual\n5.-Reporte de actividades\n6.-Reporte de mejor y peor alimento\n7.-Reporte de Batallas\n8.-Reporte de mejor y peor pokemon Guerrero\n9.-Salir");
            reportes = scannerReportes.nextInt();
        }
        
        if(reportes==9){
            System.out.println("Estas saliendo del menu reportes");
            
        }
    }   
    // muestra el reporte de estado del pokemon
    public static void reporteEstadoPokemon() throws IOException{
        String verSiguientePokemon;
        Scanner scannerVerSiguientePokemon = new Scanner(System.in);
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                System.out.println("Nombre: "+pokemon[i].getNombrePokemon());
                System.out.println("Estado: "+pokemon[i].getEstadoPokemon());
                System.out.println("Imagen ASCCI: "+pokemon[i].getImagenASCCI());
                System.in.read();
                if(i+1<pokemon.length && pokemon[i+1]!=null){
                    System.out.println("Quieres ver del siguiente pokemon, [S]i  [N]o");
                    System.out.println(pokemon[i+1].getNombrePokemon());
                    verSiguientePokemon= scannerVerSiguientePokemon.nextLine();
                    if("n".equals(verSiguientePokemon)|| "N".equals(verSiguientePokemon)){
                        break ;
                    }
                
                }
            
            } 
        }
    }
    // muestra el reporte de alimento en orden descendente de cada pokemon
    public static void reporteAlimentos1() throws IOException{
        String verSiguientePokemon;
        Scanner scannerVerSiguientePokemon = new Scanner(System.in);
        for(int i=0; i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                pokemon[i].mostrarHistorialComidasDescendentes();
                System.in.read();
                if(i+1<pokemon.length && pokemon[i+1]!=null){
                    System.out.println("Quieres ver del siguiente pokemon, [S]i  [N]o");
                    System.out.println(pokemon[i+1].getNombrePokemon());
                    verSiguientePokemon= scannerVerSiguientePokemon.nextLine();
                    if("n".equals(verSiguientePokemon)|| "N".equals(verSiguientePokemon)){
                        break;
                    }
                }
            }
        }
    }
    // FUNCIONA AL CIEN
    // muestra el reporte de alimento en orden ascendente de cada pokemon
    public static void reporteAlimentos2() throws IOException{
        String verSiguientePokemon;
        Scanner scannerVerSiguientePokemon = new Scanner(System.in);
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){
            }
            else{
                pokemon[i].mostrarHistorialComidasAscendentes();
                System.in.read();
                if(i+1<pokemon.length && pokemon[i+1]!=null){
                    System.out.println("Quieres ver del siguiente pokemon, [S]i  [N]o");
                    System.out.println(pokemon[i+1].getNombrePokemon());
                    verSiguientePokemon= scannerVerSiguientePokemon.nextLine();
                    if("n".equals(verSiguientePokemon)|| "N".equals(verSiguientePokemon)){
                        break;
                    }
                }
            }
        }
    }
    // muestra la imagen de cada pokemon
    public static void reporteVisual(){
        String verSiguientePokemon;
        Scanner scannerVerSiguientePokemon = new Scanner(System.in);
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                System.out.println("Nombre: "+pokemon[i].getNombrePokemon());
                System.out.println("Imagen: ");
                System.out.println(pokemon[i].getImagenASCCI());
                if(i+1<pokemon.length && pokemon[i+1]!=null){
                    System.out.println("Quieres ver del siguiente pokemon, [S]i  [N]o");
                    System.out.println(pokemon[i+1].getNombrePokemon());
                    verSiguientePokemon= scannerVerSiguientePokemon.nextLine();
                    if("N".equals(verSiguientePokemon)|| "n".equals(verSiguientePokemon)){
                        break;
                    }
                }
            }   
        }
    }
    // uestra el reporte de actividades realizadas de cada pokemon
    public static void reporteActividades() throws IOException{
        String verSiguientePokemon;
        Scanner scannerVerSiguientePokemon = new Scanner(System.in);
        for(int i=0;i<pokemon.length;i++){
            if(pokemon[i]==null){}
            else{
                pokemon[i].mostrarHistorialActividadesDescendentes();
                System.in.read();
                if(i+1<pokemon.length && pokemon[i+1]!=null){
                    System.out.println("Quieres ver del siguiente pokemon, [S]i  [N]o");
                    System.out.println(pokemon[i+1].getNombrePokemon());
                    verSiguientePokemon= scannerVerSiguientePokemon.nextLine();
                    if("N".equals(verSiguientePokemon)|| "n".equals(verSiguientePokemon)){
                        break;
                     }    
                }
            }
        }
    } 
    // muestra el reporte de alientos del que cosumio mas alimentos saludables y del que menos
    public static void reporteMejorPeorAlimento(){
        int[] guardarComidasBuenasTemporal = new int[5];
        int[] guardarComidasMalasTemporal = new int[5];
        int ordenarMejorComida=pokemon[0].contarComidasBuenas();
        int casillaMejorComida=0;
        int ordenarPeorComida=pokemon[0].contarComidaMala();
        int casillaPeorComida=0;
        for(int i=0;i<pokemon.length ;i++){
            if(pokemon[i]==null){}
            else{
                guardarComidasBuenasTemporal[i]=pokemon[i].contarComidasBuenas();
                guardarComidasMalasTemporal[i]=pokemon[i].contarComidaMala();
            }
        }
        
        for(int j=1;j<pokemon.length;j++){
            if(ordenarMejorComida<guardarComidasBuenasTemporal[j]){
                ordenarMejorComida = guardarComidasBuenasTemporal[j];
                casillaMejorComida=j;
            }
        }
        
        for(int k=1;k<pokemon.length;k++){
            if(ordenarPeorComida<guardarComidasMalasTemporal[k]){
                ordenarPeorComida=guardarComidasMalasTemporal[k];
                casillaPeorComida=k;
            }
        }
        System.out.println("El pokemon que mas alimento saludable consumio es: "+pokemon[casillaMejorComida].getNombrePokemon());
        pokemon[casillaMejorComida].mostrarHistorialComidasDescendentes();
        System.out.println("El pokemon que mas alimentos no saludables consumio es: "+pokemon[casillaPeorComida].getNombrePokemon());
        pokemon[casillaPeorComida].mostrarHistorialComidasDescendentes();
    }
    // muestra el reporte de batallas realizadas
    public static void reporteBatallas() throws IOException{
        System.out.println("Aqui veras el reporte de todas las batallas realizadas");
        System.out.println("Cantidad de batallas realizadas: "+historialBatallasTotales);
        System.out.println("Cantidad de batallas ganadas: "+historialBatallasGanadas);
        System.out.println("Cantidad de batalals perdidas: "+historialBatallasPerdidas);
        System.in.read();
    }
    
    // muestra las estadisticas del pokemon que mas pokemon ha desmayado, del que mas dse ha desmayado, y del que mas ha huido
    public static void reporteMejorPeorPokemonGuerrero(){
        int ordenarPokemonQueMasEnemigosHaDesmayado=pokemon[0].getPokemonDerrotados();
        int casillaPokemonQueMasEnemigosHaDesmayado=0;
        int ordenarPokemonQueMasSeHaDesmayado=pokemon[0].getCantidadVecesDesmayado();
        int casillaPokemonQueMasSeHaDesmayado=0;
        int ordenarPokemonQueMasHaHuido=pokemon[0].getCantidadVecesHuida();
        int casillaPokemonQueMasHaHuido=0;
        int[] guardarPokemonQueMasEnemigosHaDesmayado = new int[5];
        int[] guardarPokemonQueMasSeHaDesmayado = new int[5];
        int[] guardarPokemonQueMasHaHuido = new int[5];
        
        for(int i=0;i<pokemon.length ;i++){
            if(pokemon[i]==null){}
            else{
                guardarPokemonQueMasEnemigosHaDesmayado[i]=pokemon[i].getPokemonDerrotados();
                guardarPokemonQueMasSeHaDesmayado[i]=pokemon[i].getCantidadVecesDesmayado();
                guardarPokemonQueMasHaHuido[i]=pokemon[i].getCantidadVecesHuida();
            }
        }
        
        for(int j=1;j<pokemon.length;j++){
            if(ordenarPokemonQueMasEnemigosHaDesmayado<guardarPokemonQueMasEnemigosHaDesmayado[j]){
                ordenarPokemonQueMasEnemigosHaDesmayado = guardarPokemonQueMasEnemigosHaDesmayado[j];
                casillaPokemonQueMasEnemigosHaDesmayado=j;
            }
        }
        
        for(int k=1;k<pokemon.length;k++){
            if(ordenarPokemonQueMasSeHaDesmayado<guardarPokemonQueMasSeHaDesmayado[k]){
                ordenarPokemonQueMasSeHaDesmayado=guardarPokemonQueMasSeHaDesmayado[k];
                casillaPokemonQueMasSeHaDesmayado=k;
            }
        }
        
        for(int f=1;f<pokemon.length;f++){
            if(ordenarPokemonQueMasHaHuido<guardarPokemonQueMasHaHuido[f]){
                ordenarPokemonQueMasHaHuido=guardarPokemonQueMasHaHuido[f];
                casillaPokemonQueMasHaHuido=f;
            }
        }
        
        System.out.println("El pokemon que mas pokemon ha derrotado es: "+pokemon[ casillaPokemonQueMasEnemigosHaDesmayado].getNombrePokemon());
        pokemon[ casillaPokemonQueMasEnemigosHaDesmayado].mostrarEstadisticasPokemon();
        System.out.println("");
        
        System.out.println("El pokemon que mas veces se ha desmayado es: "+pokemon[casillaPokemonQueMasEnemigosHaDesmayado].getNombrePokemon());
        pokemon[casillaPokemonQueMasEnemigosHaDesmayado].mostrarEstadisticasPokemon();
        System.out.println("");
        
        System.out.println("El pokemon que mas veces ha huido es: "+pokemon[casillaPokemonQueMasHaHuido].getNombrePokemon());
        pokemon[casillaPokemonQueMasHaHuido].mostrarEstadisticasPokemon();
                
        
    }
    
    // Muestra el menu principal
    public static void mostrarMenuPrincipal(){
        
        System.out.println("MENU PRINCIPAL");
        if(pokemon[escogerPokemonActivo]==null){
            System.out.println("Pokemon Activo: no hay pokemon activo");
        }
        else{
            if(pokemon[escogerPokemonActivo].getEstadoPokemonPelea()=="no activo"){
                pokemon[escogerPokemonActivo].setEstadoPokemonPelea("activo");
            }
            System.out.println("Pokemon Activo: "+pokemon[escogerPokemonActivo].getNombrePokemon());
        }
        System.out.println("Escoge a donde quieres ir ");
        System.out.println("1.- Crear Pokemon\n2.- Escoger Pokemon Activo\n3.- Batalla\n4.- Alimentacion\n5.- Actividades\n6.- Reportes\n7.- Introducir Codigo De Batalla\n8.- Revivir o eliminar un pokemon\n9.- Salir");
        opcionMenuPrincipal= scannerMenuPrincipal.nextInt();
    }
    // metodo main
    public static void main(String[] args) throws IOException {
        final String NOMBRE_ENTRENADOR= "Entrenador Miguelito";
        
        
        comidas[0]= new Comida("saludable", "Ensalada", 25);
        comidas[1]= new Comida("saludable", "Carne", 50);
        comidas[2]= new Comida("saludable", "Fruta", 100);
        comidas[3]= new Comida("no saludable", "Pizza", -25);
        comidas[4]= new Comida("no saludable", "Hamburguesa", -50);
        comidas[5]= new Comida("no saludable", "Churros", -100);
        
        actividades[0] = new Actividades("Caminar", "saludable", 25);
        actividades[1] = new Actividades("Correr", "saludable", 50);
        actividades[2] = new Actividades("Jugar", "saludable", 100);
        actividades[3] = new Actividades("Desvelarse", "saludable", -25);
        actividades[4] = new Actividades("Saltar", "no saludable", -50);
        actividades[5] = new Actividades("Nadar", "no saludable", -100);
        
        
        
        System.out.println("Bienvenido al PokeEsmeralda, "+NOMBRE_ENTRENADOR);
        System.out.println("Aqui podras tener diferentes pokemon, cuidarlos, alimentarlos y pelear contra otros entrenadores pokemon");
        crearPokemon();
        mostrarMenuPrincipal();
        while(opcionMenuPrincipal!=9){
            switch(opcionMenuPrincipal){
                case 1: crearPokemon(); 
                        mostrarMenuPrincipal();
                        break;
                case 2: escogerPokemonActivo(); 
                        mostrarMenuPrincipal();
                        break;
                case 3: menuBatalla();
                        mostrarMenuPrincipal();
                        break;
                case 4: alimentacion();
                        mostrarMenuPrincipal();
                        break;
                case 5: actividades();
                        mostrarMenuPrincipal();
                        break;
                case 6: reportes();
                        mostrarMenuPrincipal();
                        break;
                case 7: leerCodigo(); 
                        opcionesDePelea();
                        mostrarMenuPrincipal();
                        break;
                case 8: revivirOEliminarPokemon();
                        mostrarMenuPrincipal();
                        break;
            }
        }
        
        if(opcionMenuPrincipal==9){
            System.out.println("Estas saliendo de PokeEsmeralda");
            System.out.println("Gracias por jugar, "+NOMBRE_ENTRENADOR);
        }

    }
    
}
