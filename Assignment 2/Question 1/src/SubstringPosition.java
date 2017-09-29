public class SubstringPosition {

    public static void main(String[] args) {

        System.out.println(indexOf("Mississippi", "sip"));
    }

    public static int indexOf(String text, String str) {

        text = text.toLowerCase();
        str = str.toLowerCase();

        // str cannot be in text if it is a longer string than text itself
        if (text.length() < str.length()) {

            return -1;
        }

        if (text.substring(0, str.length()).equals(str)) {

            return 0;
        }

        // call method with simpler input
        int index = indexOf(text.substring(1), str);

        return (index == -1) ? -1 : 1 + index; // add 1 because every time the method is called, we "shift" an index in the original input

    }
}
