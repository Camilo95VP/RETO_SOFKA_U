
package Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class IngresarJugador {
    String nombre;
    int puntaje;
    public IngresarJugador(String nombre,int puntaje) throws IOException{
        this.nombre=nombre;
        this.puntaje=puntaje;
        
        String fichJugador="Registro Jugadores";
        File ficheroJ=new File(fichJugador);
    
        if(ficheroJ.exists()==false){
            ficheroJ.mkdirs();
        } 
        
        BufferedWriter docJugador;
        docJugador=new BufferedWriter(new FileWriter("Registro Jugadores/"+nombre+".csv"));
                                                
        docJugador.write("Jugador,Puntaje\n");
        docJugador.write(nombre+","+puntaje);
        docJugador.close();
         
    }   
    
}

