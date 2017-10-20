public class Worker extends Thread {

    String[] sortArray;

    public Worker(String[] sortArray){

        this.sortArray = sortArray;

    }

    public String[] getSortArray() {
        return sortArray;
    }

    /**
     * This is the same algorithm as given in the book.
     * Sorts an array, using merge sort.
     * @param a the array to sort
     */
    public static void sort(String[] a) {

        if (a.length <= 1) { return; }
        String[] firstHalf = new String[a.length / 2];
        String[] secondHalf = new String[a.length - firstHalf.length];

        for (int i = 0; i < firstHalf.length; i++) {
            firstHalf[i] = a[i];
        }

        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = a[firstHalf.length + i];
        }
        sort(firstHalf);
        sort(secondHalf);
        merge(firstHalf, secondHalf, a);
    }

    /**
     * This is the same algorithm as given in the book to merge 2 sorted arrays. Only now it works for Strings instead of ints.
     * Merges two sorted arrays into an array.
     * @param first the first sorted array
     * @param second the second sorted array
     * @param a the array into which to merge first and second
     */
    public static void merge(String[] first, String[] second, String[] a) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

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
    }

    public void run() {
        sort(sortArray);
    }

}
