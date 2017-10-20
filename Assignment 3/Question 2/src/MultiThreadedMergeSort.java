import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MultiThreadedMergeSort {

    public static void main(String[] args) throws InterruptedException {

        String[] words = readListFromFile("C:\\Users\\Rayel\\Documents\\School\\EUR\\Advanced Programming\\Assignments-Advanced-Programming\\Assignment 3\\Question 2\\src\\words.txt");
        int numberOfThreads = 4;

        long startTime = System.currentTimeMillis();
        String[] subWords1 = new String[words.length / numberOfThreads];
        String[] subWords2 = new String[words.length / numberOfThreads];
        String[] subWords3 = new String[words.length / numberOfThreads];
        String[] subWords4 = new String[words.length - (numberOfThreads - 1) * (int) words.length / numberOfThreads];

        for (int i = 0; i < subWords1.length; i++) {
            subWords1[i] = words[i];
        }
        for (int i = 0; i < subWords2.length; i++) {
            subWords2[i] = words[i + subWords1.length];
        }
        for (int i = 0; i < subWords3.length; i++) {
            subWords3[i] = words[i + subWords1.length + subWords2.length];
        }
        for (int i = 0; i < subWords4.length; i++) {
            subWords4[i] = words[i + subWords1.length + subWords2.length + subWords3.length];
        }

        //System.out.println(Arrays.toString(words));
        System.out.println(words.length);
       // System.out.println(Arrays.toString(subWords1));
        System.out.println(subWords1.length);
        //System.out.println(Arrays.toString(subWords2));
        System.out.println(subWords2.length);
        //System.out.println(Arrays.toString(subWords3));
        System.out.println(subWords3.length);
        //System.out.println(Arrays.toString(subWords4));
        System.out.println(subWords4.length);

        Worker worker1 = new Worker(subWords1);
        Worker worker2 = new Worker(subWords2);
        Worker worker3 = new Worker(subWords3);
        Worker worker4 = new Worker(subWords4);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();
        finalMerge(worker1.getSortArray(), worker2.getSortArray(), worker3.getSortArray(), worker4.getSortArray(), words);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("4-thread MergeSort takes: " + (float) elapsedTime / 1000 + " seconds");
        //System.out.println(Arrays.toString(words));
        System.out.println(words.length);
    }

    public static String[] readListFromFile(String filePath) {

        ArrayList<String> list = new ArrayList<String>();

        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list.toArray(new String[list.size()]);
    }

    public static void finalMerge(String[] a, String[] b, String[] c, String[] d, String[] finalSortedArray){

        String[] temp1 = new String[a.length + b.length];
        String[] temp2 = new String[c.length + d.length];
        Worker.merge(a, b, temp1);
        Worker.merge(c, d, temp2);
        Worker.merge(temp1, temp2, finalSortedArray);
    }
}
