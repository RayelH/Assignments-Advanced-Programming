import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class does a MultiThreaded Mergesort. The path of the file that needs to be sorted must put in line 16.
 */
public class MultiThreadedMergeSort {

    public static void main(String[] args) throws InterruptedException {

        String[] words = readListFromFile("C:\\Users\\Rayel\\Documents\\School\\EUR\\Advanced Programming\\Assignments-Advanced-Programming\\Assignment 3\\Question 2\\src\\words.txt");
        int numberOfThreads = 4;
        ArrayList<String[]> dividedLists = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        // loop to divide the initial words list and store all the divided lists into an ArrayList
        for(int i = 0; i<numberOfThreads; i++){

            /* the last list of the divided lists should have total number of elements - number of elements that al already in the other list,
               in case number of words in words.txt is not divisible by number of threads
            */
            if(i == numberOfThreads-1){
                String[] subWords = new String[words.length - (numberOfThreads - 1) * words.length/numberOfThreads];
                int totalLength = 0;

                // get total number of elements in words that are already in the other lists
                for(int k = 0; k<dividedLists.size(); k++){
                    totalLength = totalLength + dividedLists.get(k).length;
                }

                for (int j = 0; j < subWords.length; j++) {
                    subWords[j] = words[j + totalLength];
                }
                dividedLists.add(subWords);
            }
            else {
                String[] subWords = new String[words.length / numberOfThreads];

                for (int j = 0; j < subWords.length; j++) {
                    subWords[j] = words[j + i*subWords.length];
                }

                dividedLists.add(subWords);
            }
        }


        //System.out.println(Arrays.toString(words));
        System.out.println(words.length);
        for(int i = 0; i<dividedLists.size(); i++){

            //System.out.println(Arrays.toString(dividedLists.get(i)));
            System.out.println(dividedLists.get(i).length);
        }

        ArrayList<Worker> workers = new ArrayList<>();

        // make, store and start all threads
        for(int i = 0; i<numberOfThreads; i++){
            Worker worker = new Worker(dividedLists.get(i));
            workers.add(worker);
            worker.start();
            worker.join();
        }

        bigMerge(dividedLists, words);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("4-thread MergeSort takes: " + (float) elapsedTime / 1000 + " seconds");
        //System.out.println(Arrays.toString(words));
        System.out.println(words.length);
    }


    /**
     * Method to merge n sorted lists
     * @param lists an ArrayList where all the sorted arrays that need to be merges are stored in
     * @param finalArray The final array in which you want all the sorted array merged
     */
    public static void bigMerge(ArrayList<String[]> lists, String[] finalArray){

        String[] mergeArray = lists.get(0);

        for(int i = 1; i < lists.size(); i++) {
            mergeArray = smallMerge(mergeArray, lists.get(i));
        }

        // copy results into input Array
        for(int i = 0; i<finalArray.length; i++){

            finalArray[i] = mergeArray[i];
        }
    }

    public static String[] smallMerge(String[] first, String[] second) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        String[] a = new String[first.length + second.length];
        while (iFirst < first.length && iSecond < second.length) {

            // condition for Strings
            if (first[iFirst].compareTo(second[iSecond]) < 0) {

                a[j] = first[iFirst];
                iFirst++;
            } else {

                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        while (iFirst < first.length) {

            a[j] = first[iFirst];
            iFirst++;
            j++;
        }

        while (iSecond < second.length) {

            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
        return a;
    }

    /**
     * A method for reading the content of a file to an array of Strings.
     *
     * @param filePath the path of the file which needs to be read
     * @return An array of Strings which is sorted in alphabetical order
     */
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

}
