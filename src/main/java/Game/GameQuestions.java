package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameQuestions {
    static String nombre="";  //creacion variables de clase 
    static int puntaje=0;
    public static void main(String[] args) throws IOException { 
        while (true){
            int ronda=1;
            int incremento=2000;
            puntaje=0;
            int puntajeAcumulado=0;
            System.out.println("Seleccione que desea hacer");
            System.out.println("1.Iniciar Juego");
            System.out.println("2.Configurar preguntas");
            System.out.println("3.Jugador");
            Scanner opcionRespuesta=new Scanner(System.in);
            String opcion=opcionRespuesta.nextLine();
            System.out.println(opcion);
                   
            String fichCategorias="Preguntas";
            File ficheroCategoria=new File(fichCategorias);
                    
            String fichCategoria1="Preguntas/"+"Cat1";
            File ficheroCategoria1=new File(fichCategoria1);

            String fichCategoria2="Preguntas/"+"Cat2";
            File ficheroCategoria2=new File(fichCategoria2);

            String fichCategoria3="Preguntas/"+"Cat3";
            File ficheroCategoria3=new File(fichCategoria3);

            String fichCategoria4="Preguntas/"+"Cat4";
            File ficheroCategoria4=new File(fichCategoria4);

            String fichCategoria5="Preguntas/"+"Cat5";
            File ficheroCategoria5=new File(fichCategoria5);
