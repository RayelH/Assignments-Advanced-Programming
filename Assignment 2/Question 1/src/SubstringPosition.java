/**
 * This class returns the starting position of the substring "sip" in "mississippi".
 */
public class SubstringPosition {

    public static void main(String[] args) {

        System.out.println(indexOf("Mississippi", "sip"));
    }

    /**
     * indexOf returns the starting position of a certain substring in a string.
     *
     * @param  text the string which contains a substring of which we want to find the starting position.
     * @param  str  the substring of which we want to find the starting position.
     * @return the starting position of the substring. If text does not contain str the method returns -1.
     */
    public static int indexOf(String text, String str) {

        // the method does not differentiate between uppercase and lowercase letters
        text = text.toLowerCase();
        str = str.toLowerCase();

        // str cannot be a substring of text if it is a longer string than text itself
        if (text.length() < str.length()) {

            return -1;
        }

        if (text.substring(0, str.length()).equals(str)) {

            return 0;
        }

        // call the method with first character "cut off"
        int index = indexOf(text.substring(1), str);

        // if index = -1 text does not contain str. Else we return 1 + the method call with the first character "cut off"
        return (index == -1) ? -1 : 1 + index;

    }
}
