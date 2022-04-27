
package Game;
        
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IngresarPregunta {
    String categoria;
    String opcion1;
    String opcion2;
    String opcion3;
    String opcion4;
    String respuesta;
    String pregunta;
    public IngresarPregunta(String cate,String pre,String opc1,String opc2,String opc3,String opc4,String res) throws IOException{
        this.categoria=cate;
        this.pregunta=pre;
        this.opcion1=opc1;
        this.opcion2=opc2;
        this.opcion3=opc3;
        this.opcion4=opc4;
        this.respuesta=res;
        
        
        String fichCategoria="Preguntas";
        File ficheroJ=new File(fichCategoria);
    
        if(ficheroJ.exists()==false){
            ficheroJ.mkdirs();
        }
        
        String fichCategoriaEsp="Preguntas/Cat"+categoria;
        File ficheroCatE=new File(fichCategoriaEsp);
    
        if(ficheroCatE.exists()==false){
            ficheroCatE.mkdirs();
        }
        
        File[] listaCat= ficheroCatE.listFiles();
        int num=listaCat.length+1;
        
        BufferedWriter preguntaEscrita;
        preguntaEscrita=new BufferedWriter(new FileWriter(fichCategoriaEsp+"/"+num+".csv"));
        
        preguntaEscrita.write(pregunta+","+opcion1+","+opcion2+","+opcion3+","+opcion4+","+respuesta);
        preguntaEscrita.close();
    }
        
                
    }
