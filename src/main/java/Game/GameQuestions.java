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
            System.out.println("1.Jugar");
            System.out.println("2.Crear preguntas");
            System.out.println("3.Ingresar mi nombre");
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
            
            if(opcion.equals("1")){

                if(nombre.equals("")){
                    System.out.println("Si es primera vez que juegas, debes ingresar el nombre");
                }    
                else{
                    
                    
                    
                    if(ficheroCategoria.exists()==false | //creando ficheros/persistencia de datos
                            ficheroCategoria1.exists()==false | 
                            ficheroCategoria2.exists()==false | 
                            ficheroCategoria3.exists()==false | 
                            ficheroCategoria4.exists()==false | 
                            ficheroCategoria5.exists()==false){
                        System.out.println("Ingresa las categorias");
                    }    
                    else{
                        File[] listaCat1= ficheroCategoria1.listFiles();
                        File[] listaCat2= ficheroCategoria2.listFiles();
                        File[] listaCat3= ficheroCategoria3.listFiles();
                        File[] listaCat4= ficheroCategoria4.listFiles();
                        File[] listaCat5= ficheroCategoria5.listFiles();
                    
                        if(listaCat1.length<=4 | listaCat2.length<=4 | listaCat3.length<=4 | listaCat4.length<=4 | listaCat5.length<=4){
                            System.out.println("Completa minimo 5 preguntas por categoria");
                            System.out.println("Categoria 1: "+listaCat1.length);
                            System.out.println("Categoria 2: "+listaCat2.length);
                            System.out.println("Categoria 3: "+listaCat3.length);
                            System.out.println("Categoria 4: "+listaCat4.length);
                            System.out.println("Categoria 5: "+listaCat5.length);
                        }