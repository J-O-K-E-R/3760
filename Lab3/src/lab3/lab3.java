package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    public boolean Tech1(String w1, String w2){
        if(w2.length() != w2.length()){
            return false;
        }
        StringBuffer sb =  new StringBuffer(w2);
        for(int i=0; i< w1.length();i++){
            for(int j=0; j< w2.length(); j++){
                if(w1.charAt(i) == w2.charAt(j)){
                    sb.delete(j,j);
                    break;
                }
            }
        }
        return true;
    }
     
    public static void main(String[] args) {
        String w1, w2;
        int count = 0;
        lab3 cd = new lab3();
        cd.readfile();
        String []ftext = text.split(" ");
        String []stext = text.split(" ");
        System.out.println("Wtf is going on");
        for(int i=0; i<ftext.length; i++){
            w1 = ftext[i];
            for(int j=1; j<stext.length; j++){
                w2 = stext[j];
                System.out.print(w1);
                System.out.print(w2);
                /*if((cd.Tech1(w1, w2)) == true){
                    count++;
                }*/
            }
        }
        System.out.println(count);
    }
    
}