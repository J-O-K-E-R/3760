package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
        int i;
        int j = 0;
        int capacity = 0;
        if(w1.length() != w2.length()){
            return false;
        }
        if((w1.compareTo(w2)) == 0){
            return false;
        }
        StringBuffer sb =  new StringBuffer(w2);
        for(i = 0; i< w1.length();i++){
            for(j = 0; j< sb.length(); j++){
                if(w1.charAt(i) == sb.charAt(j)){
                    sb.deleteCharAt(j);
                    break;
                }
            }
        }
        capacity = sb.length();
        if(capacity != 0){
            return false;
        }
        return true;
    }
    public boolean Tech2(String w1, String w2){
        String word1 = w1.toLowerCase();
	String word2 = w2.toLowerCase();
        if(word1.length() != word2.length()) {
            return false;
        }
        if((word1.compareTo(word2)) == 0){
            return false;
        }
        //Changing the case of characters of both word1 and word2 and converting them to char array
        char[] ArrayWord1 = word1.toLowerCase().toCharArray();
        char[] ArrayWord2 = word2.toLowerCase().toCharArray();
        
        //Sorting both ArrayWord1 and ArrayWord2
        Arrays.sort(ArrayWord1);
        Arrays.sort(ArrayWord2);
        
        //Checking whether s1Array and s2Array are equal
        if(Arrays.equals(ArrayWord1, ArrayWord2)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean Tech3(String w1, String w2){
	String word1 = w1.toLowerCase();
	String word2 = w2.toLowerCase();
		
	if(word1.length() != word2.length()){
            return false;
        }
	int[] vector = new int[1024];
		
	for(int i = 0; i < word1.length(); i++){
            vector[(int) word1.charAt(i)]++;
        }
	for(int i = 0; i < word2.length(); i++){
            vector[(int) word2.charAt(i)]--;
        }
        for(int i = 0; i < 1024; i++){
            if(vector[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String w1, w2;
        int count1 = 0, count2 = 0, count3 = 0;
        int max1 = 0, max2 = 0, max3 = 0;
        String mAna1 = "", mAna2 = "", mAna3 = "";
        lab3 cd = new lab3();
        cd.readfile();
        String []ftext = text.split(" ");
        String []stext = text.split(" ");
        
        
        double startTime = System.currentTimeMillis();
        for(int i=0; i<ftext.length; i++){
            w1 = ftext[i];
            count1 = 0;
            for(int j=0; j<stext.length; j++){
                w2 = stext[j];
                if((cd.Tech1(w1, w2)) == true){
                    count1++;
                    if(max1 < count1){
                        max1 = count1;
                        mAna1 = w1;
                    }
                }
            }
        }
        double stopTime = System.currentTimeMillis();
        double elapsedTime = stopTime - startTime;
        System.out.println("Technique #1: ");
        System.out.println("Time Elapsed: " + elapsedTime/1000 + "s");
        System.out.println(mAna1 + " has " + max1 + " anagrams");
        
        
        double startTime2 = System.currentTimeMillis();
        for(int i=0; i<ftext.length; i++){
            w1 = ftext[i];
            count2 = 0;
            for(int j=0; j<stext.length; j++){
                w2 = stext[j];
                if((cd.Tech2(w1, w2)) == true){
                    count2++;
                    if(max2 < count2){
                        max2 = count2;
                        mAna2 = w1;
                    }
                }
            }
        }
        double stopTime2 = System.currentTimeMillis();
        double elapsedTime2 = stopTime2 - startTime2;
        System.out.println("Technique #2: ");
        System.out.println("Time Elapsed: " + elapsedTime2/1000 + "s");
        System.out.println(mAna2 + " has " + max2 + " anagrams");
        
        double startTime3 = System.currentTimeMillis();
        for(int i=0; i<ftext.length; i++){
            w1 = ftext[i];
            count3 = 0;
            for(int j=0; j<stext.length; j++){
                w2 = stext[j];
                if((cd.Tech3(w1, w2)) == true){
                    count3++;
                    if(max3 < count3){
                        max3 = count3;
                        mAna3 = w1;
                    }
                }
            }
        }
        double stopTime3 = System.currentTimeMillis();
        double elapsedTime3 = stopTime3 - startTime3;
        System.out.println("Technique #3: ");
        System.out.println("Time Elapsed: " + elapsedTime3/1000 + "s");
        System.out.println(mAna3 + " has " + max3 + " anagrams");
    }
    
}