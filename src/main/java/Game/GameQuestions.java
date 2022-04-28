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
                        //_____________________________________________________________________________________________________
                        else{
                            while(ronda<=5){
                                System.out.println("RONDA: "+ronda);
                                System.out.println("PUNTAJE: "+puntaje);

                                System.out.println("Desea continuar: Digite 1 para si y 2 para no");
                                
                                Scanner opcionSeguir=new Scanner(System.in);
                                String seguir=opcionSeguir.nextLine();
                                if (seguir.equals("1")){
                                    int numPreguntas=0;
                                    if(ronda==1){
                                        numPreguntas=listaCat1.length;
                                    }
                                    if(ronda==2){
                                        numPreguntas=listaCat2.length;
                                    }
                                    if(ronda==3){
                                        numPreguntas=listaCat3.length;
                                    }
                                    if(ronda==4){
                                        numPreguntas=listaCat4.length;
                                    }
                                    if(ronda==5){
                                        numPreguntas=listaCat5.length;
                                    }
                                
                                    int numeroPregunta = (int)(Math.random()*numPreguntas+1);

                                    BufferedReader pregunta;
                                    try {
                                        pregunta = new BufferedReader(new FileReader("Preguntas/"+"Categoria"+ronda+"/"+numeroPregunta+".csv"));
                                        String opciones = pregunta.readLine();
                                        String [] listaOpciones = opciones.split(",");
                                        System.out.println("Pregunta: "+listaOpciones[0]);
                                        System.out.println("Opcion 1: "+listaOpciones[1]);
                                        System.out.println("Opcion 2: "+listaOpciones[2]);
                                        System.out.println("Opcion 3: "+listaOpciones[3]);
                                        System.out.println("Opcion 4: "+listaOpciones[4]);
                                        System.out.println("Ingrese la respuesta");
                                        Scanner opcionResp=new Scanner(System.in);
                                    
                                        String opcRespuesta=opcionResp.nextLine();
                                        String respuestaArchivo=(listaOpciones[5]);
                                        
                                        if(opcRespuesta.equals(respuestaArchivo)){

                                            if(ronda==5){
                                                ronda=1;
                                                pregunta.close();
                                                puntaje+=incremento;
                                                incremento=2000;
                                                if(puntaje>puntajeAcumulado){


                                                    BufferedWriter docJugador;
                                                    docJugador=new BufferedWriter(new FileWriter("Registro Jugadores/"+nombre+".csv"));

                                                    docJugador.write("Jugador,Puntaje\n");
                                                    docJugador.write(nombre+","+puntaje);
                                                    docJugador.close();

                                                    pregunta.close();
                                                    System.out.println("Respuesta correcta");
                                                    System.out.println("GANASTE!!");
                                                    break;
                                                }    
                                            }
                                            else{
                                                System.out.println("Respuesta correcta");
                                                ronda+=1;

                                                puntaje+=incremento;
                                                incremento+=2000;
                                                pregunta.close();
                                                continue;
                                            }
                                        }
                                        else{

                                            System.out.println("Respuesta incorrecta, intentalo de nuevo");
                                            pregunta.close();
                                            puntaje=0;
                                            ronda=1;
                                            incremento=2000;
                                            break;
                                        }
                                    
                                        
                                    } 
                                    
                                    catch (FileNotFoundException ex) {
                                        Logger.getLogger(GameQuestions.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    

                                    
                                    
                                    
                                    
                                    
                                }
                                else{
                                    ronda=1;

                                    incremento=2000;
                                    if(puntaje>puntajeAcumulado){
                                        
                                        BufferedWriter docJugador;
                                        docJugador=new BufferedWriter(new FileWriter("Registro Jugadores/"+nombre+".csv"));
                                                
                                        docJugador.write("Jugador,Puntaje\n");
                                        docJugador.write(nombre+","+puntaje);
                                        docJugador.close();
                                    
                               
                                        break; 
                                    }    
                                    else{
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                    
            
            }
               //_____________________________________________________________________________________________________
        
            if(opcion.equals("2")){

                System.out.println("Que categoria deseas para la pregunta: 1,2,3,4 ó 5"); //ingresando valores por consola
                Scanner opc=new Scanner(System.in);
                String opcionCategoria=opc.nextLine();

                System.out.println("Escribe la pregunta: ");
                String pregunta=opc.nextLine();
                
                System.out.println("A continuacion ingrese las cuatro opciones de respuesta: ");

                System.out.println("Opción 1 de respuesta");
                String opcion1=opc.nextLine();

                System.out.println("Opción 2 de respuesta");
                String opcion2=opc.nextLine();

                System.out.println("Opción 3 de respuesta");
                String opcion3=opc.nextLine();

                System.out.println("Opción 4 de respuesta");
                String opcion4=opc.nextLine();

                System.out.println("Ingrese cual de las cuantro opciones es la respuesta correcta: 1, 2, 3 ó 4");
                String respuesta=opc.nextLine();

                IngresarPregunta preguntaCreada=new IngresarPregunta(opcionCategoria,pregunta,opcion1,opcion2,opcion3,opcion4,respuesta);

            }
            if(opcion.equals("3")){
                System.out.println("Nombre de jugador: ");
                Scanner nom=new Scanner(System.in);
                nombre=nom.nextLine();
                
                String fichJugador="Registro Jugadores/"+nombre+".csv";
                File ficheroJ=new File(fichJugador);
                if(ficheroJ.exists()==false){
                    IngresarJugador jugador=new IngresarJugador(nombre,0);
                }    

                else {
                    
                
                    BufferedReader docJugador;
                    docJugador=new BufferedReader(new FileReader("Registro Jugadores/"+nombre+".csv"));
                                                
                    String info = docJugador.readLine();
                    String info2 = docJugador.readLine();
                    String [] listaOpciones = info2.split(",");
                    
                    puntaje=Integer.parseInt(listaOpciones[1]);
                    puntajeAcumulado=puntaje;
                    docJugador.close();
                }
            }
        }
    }
}
