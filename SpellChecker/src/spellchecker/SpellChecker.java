/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Justin Mclennan
 */
public class SpellChecker {

    public String[] readFile(String s) {
        String filename = s;
        String testString[] = {};
        try {
            ArrayList<String> testList = new ArrayList<>();

            try (Scanner testData = new Scanner(new File(s))) {
                while (testData.hasNext()) {
                    testList.add(testData.next().toLowerCase());
                }
            }
            testString = (String[]) testList.toArray(new String[testList.size()]);

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + filename + "'");
        }
        return testString;
    }

    public boolean seqSearch(String[] file1, String file2) {
        for (int i = 0; i < file1.length; i++) {
            if ((file2.compareTo(file1[i])) == 0) {
                return true;
            }
        }
        return false;
    }

    public <T extends Comparable<T>> boolean binSearch(T[] file1, T file2) {
        int low = 0;
        int high = file1.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (file2.compareTo(file1[middle]) == 0) {
                return true;
            } else if (file2.compareTo(file1[middle]) < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int seq = 0, bin = 0;
        String text[], text2[];
        SpellChecker cd = new SpellChecker();
        text = cd.readFile("lab4_wordlist.txt");
        text2 = cd.readFile("lab4_testdata.txt");

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < text2.length; i++) {
            if (!cd.seqSearch(text, text2[i])) {
                seq++;
            }
        }
        long stopTime1 = System.currentTimeMillis();
        long elapsedTime1 = stopTime1 - startTime1;
        System.out.println("Sequential Search: " + seq + " words are not found " + elapsedTime1 * 1000 + " Microsecond");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < text2.length; i++) {
            if (!cd.binSearch(text, text2[i])) {
                bin++;
            }
        }
        long stopTime2 = System.currentTimeMillis();
        long elapsedTime2 = stopTime2 - startTime2;
        System.out.println("Binary Search: " + bin + " words are not found " + elapsedTime2 * 1000 + " Microsecond");
    }

}
