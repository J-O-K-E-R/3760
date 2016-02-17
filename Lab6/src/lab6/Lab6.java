/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import static java.util.Arrays.sort;

/**
 *
 * @author Justin
 */
public class Lab6 {

    public static int a[] = {480, 231, 0, 477, 121, 1176, 501, 2000};
    
    public int transform(int a[]){
        int distance = 0, minDistance = 0;
        sort(a);
        distance = Math.abs(a[0] - a[1]);
        for(int i = 2; i < a.length - 1; i++){
            minDistance = Math.abs(a[i] - a[i-1]);
            if(minDistance < distance){
                distance = minDistance;
            }
        }
        return distance;
    }
    public int bruteforce(int a[]){
        int distance = Math.abs(a[0] - a[1]);
        int minDistance;
        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                minDistance = Math.abs(a[i] - a[j]);
                if(minDistance == 0){
                    
                } else if(minDistance < distance)
                    distance = minDistance;
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        Lab6 six = new Lab6();
        int tMin, bMin;
        tMin = six.transform(a);
        bMin = six.bruteforce(a);
        System.out.println(tMin);
        System.out.println(bMin);
    }
    
}
