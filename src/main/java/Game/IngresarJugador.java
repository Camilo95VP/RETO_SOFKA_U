
package Game;

import java.io.BufferedWriter; //importando clases
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class IngresarJugador {
    String nombre;
    int puntaje;
    public IngresarJugador(String nombre,int puntaje) throws IOException{ //constructor clase jugador
        this.nombre=nombre;
        this.puntaje=puntaje;
        
        String fichJugador="Registro Jugadores";
        File ficheroJ=new File(fichJugador);
    
        if(ficheroJ.exists()==false){//verifica si la carpeta no existe la crea
            ficheroJ.mkdirs();
        } 
        
        BufferedWriter docJugador; //declarando objeto de escritura a traves de la clase BufferedWriter
        docJugador=new BufferedWriter(new FileWriter("Registro Jugadores/"+nombre+".csv"));//intanciando objeto declarado
                                                
        docJugador.write("Jugador,Puntaje\n");//escribiendo sobre el archivo
        docJugador.write(nombre+","+puntaje);
        docJugador.close();
        
        
        
        
    } 
    
}

