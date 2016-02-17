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
public class Mergesort {
    
    public Mergesort(){
        
    }
    private int[] numbers;
    private int[] others;

    private int size;

    public void sort(int[] values) {
        numbers = values;
        size = values.length;
        others = new int[size];
        mergesort(0, size - 1);
    }

    private void mergesort(int low, int high) {
        
        if (low < high) {

            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            others[i] = numbers[i];
        }
        int i = low;
        int j = middle + 1;
        int v = low;
        while (i <= middle && j <= high) {
            if (others[i] <= others[j]) {
                numbers[v] = others[i];
                i++;
            } else {
                numbers[v] = others[j];
                j++;
            }
            v++;
        }
        while (i <= middle) {
            numbers[v] = others[i];
            v++;
            i++;
        }

    }

    public static void main(String[] args) {
        int original[] = {2, 4, 8, 3, 6, 9, 1, 6, 5};
        int array[] = {2, 4, 8, 3, 6, 9, 1, 6, 5};
        Mergesort cd = new Mergesort();
        cd.sort(array);
        for(int i =0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        for(int j =0; j < array.length; j++){
            System.out.print(original[j] + " ");
        }
    }
}
