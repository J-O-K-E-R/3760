package lab3;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Justin
 */
public class lab3 {
    
    public static String text = null;

    public lab3(){
        
    }

    public void readfile(){
        String filename = "Dict.txt";
        try{
            FileReader filereader = new FileReader(filename);
            
            BufferedReader bufferReader = new BufferedReader(filereader);
            
            text = bufferReader.readLine();

            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filename + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");                  

        }
    }
    public boolean Tech1(){
        
        return true;
    }
     
    public static void main(String[] args) {
        String w1, w2;
        lab3 cd = new lab3();
        cd.readfile();
        System.out.print(text);

        //cd.Tech1();
        
    }
    
}