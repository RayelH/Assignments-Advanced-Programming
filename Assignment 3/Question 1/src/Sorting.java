import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class sorts a list of countries and has a function to do a binary search on the list.
 */
public class Sorting {

    public static void main(String[] args) {

        String[] countries = readListFromFile("");
        selectionSortArray(countries);
        System.out.println(Arrays.toString(countries));
        System.out.println(binarySearch(countries, 0, countries.length - 1, "Albania"));
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

    /**
     * A method that sorts an array of Strings in alphabetical order by using selection sort.
     *
     * @param list the array that needs to be sorted
     */
    public static void selectionSortArray(String[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < list.length; j++) {

                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    /**
     * A method that does a binary search in an array of Strings.
     *
     * @param list the array that you want to do the binary search in
     * @param low  the low index of the range
     * @param high the high index of the range
     * @param item the String of which the index needs to be found
     * @return the index of the string which you want to find
     */
    public static int binarySearch(String[] list, int low, int high, String item) {

        if (low <= high) {

            int mid = (low + high) / 2;

            if (list[mid].compareTo(item) == 0) {
                return mid;
            }

            if (list[mid].compareTo(item) > 0) {
                return binarySearch(list, low, mid - 1, item);

            } else if (list[mid].compareTo(item) < 0) {
                return binarySearch(list, mid + 1, high, item);
            }
        }
        return -1;
    }
}
