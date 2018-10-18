package ad11;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class Metodos {

    File file = null;
    
    public void aleatorio(String  f){
        file = new File(f);
        Producto p;
        try{
            
            /*
            * Declaramos objeto del tipo RandomAccessFile, le pasamos el fichero
            * e indicamos que lo abrimos en modo lectura-escritura
            */
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            
            //Instanciamos lo arrays con los valores
            String[] cod = {"p1","p2","p3"};
            String[] des = {"parafusos","cravos","tachas"};
            int[] pre = {3,4,5};
            
            String codr = "";
            String desr = "";
            
            /*
             Bucle que recorre lo arrays y escribe en el fichero
             El string format rellenara por la derecha con blancos hasta 
             que se llenen los 3 caracteres del codigo y los 10 de 
             la descripcion.
             La funcion replace cambiara los espacios en blanco por asteriscos
            */
            for(int i=0; i<cod.length; i++){
                raf.writeChars(String.format("%-3s", cod[i]).replace(' ', '*'));
                raf.writeChars(String.format("%-10s", des[i]).replace(' ', '*'));
                raf.writeInt(pre[i]);
            }
            
            //Una vez acabada la escritura, comenzamos la lectura
            
            //Preguntamos por el numero de registro al que queremos acceder
            
            int reg = Integer.parseInt(JOptionPane.showInputDialog("Nº de registro:"));
            /*
             Con seek movemos el puntero por el fichero, como sabemos que cada
             entrada ocupa 30 bytes usaremos la siguiente formula para movernos
             Asi, para la primera entrada 1-1 = 0 -> 0*30=0 -> La primera 
             entrada estará en la posicion 0
             2-1 = 1 -> 1*30 = 30
             3-1 = 2 -> 2*30 = 60
             y así sucesivamente
            */
            raf.seek((reg-1)*30);
            
            /*
             Bucle que recorre las 13 posiciones que ocupan el codigo y la 
             descipcion juntos, y los separa para la lectura
            */
            for(int i=0; i<13; i++){
                if(i<3){
                    codr += raf.readChar();
                } else{
                    desr += raf.readChar();
                }
            }
            

            
            p = new Producto(codr.replace("*", ""),desr.replace("*", ""),raf.readInt());
            System.out.println(p);
            raf.close();
        
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }
    }
}
