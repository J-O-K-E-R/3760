/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Justin
 */
public class Q2 {
    public static int a[] = {4,5,1,6,2,7,3,8};
    public static void main(String[] args){
        int k = 4;
        Q2 six = new Q2();
        six.find(a, k);
    }
    
    public void find(int a[],int k){
        MaxComparator comparator = new MaxComparator();
        PriorityQueue pQ = new PriorityQueue(k , comparator);
        for(int i = 0; i < a.length; i++){
            if(pQ.size() < k){
                pQ.add(a[i]);
            }else{
                int x = Integer.parseInt(pQ.peek().toString());
                if(x > a[i]){
                    pQ.remove();
                    pQ.add(a[i]);
                }
                
            }
            
        }
        System.out.print(pQ);
    }
    
    static class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y) {
            if (x < y){
                return 1;
            }
            if (x > y){
                return -1;
            }
            return 0;
        }
        }
}

