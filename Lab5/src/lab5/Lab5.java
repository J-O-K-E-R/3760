/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Justin
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {2,4,8,3,6,9,1,6,5};
        int pos;
        pos = maxArray(0, array.length - 1, array);
        System.out.println(pos+1);
    }
    public static int maxArray(int first, int last, int s[]) {
        int mid, max, max2, pos;

        if(s[first] == s[last]){
            return first;
        } else if(first == last - 1) {
            if(s[first] > s[last]){
                return first;
            }else{
                return last;
            }
        } else {
            mid = (first + last)/2;
            max = maxArray(first, mid, s);
            max2 = maxArray(mid+1, last, s);
            if(s[max] > s[max2]){
                pos = max;
            } else {
                pos = max2;
            }
        }
        
        return pos;
    }
    
}
