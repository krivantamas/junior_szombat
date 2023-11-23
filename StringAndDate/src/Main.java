import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(caesarCode("XYZ ALMA223", 200));

    }

    private static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String reverse_2(String s) {

        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.toCharArray()[i]);
        }
        return reversed.toString();
    }

    private static int occurrences(String s, String substring) {

        int index = 0;
        int occurrences = 0;
        while (index != -1) {
            index = s.indexOf(substring, index);
            if (index != -1) {
                occurrences++;
                index += substring.length();
            }
        }

        return occurrences;
    }


    // "alma", "almalé", "alma", "alf"
    private static String longestCommonPrefix(List<String> stringList) {

        String prefix = "";

        if (stringList.size() > 0) {
            String initialString = stringList.get(0);

            for (int i = 1; i < initialString.length(); i++) {
                prefix = initialString.substring(0, i);
                for (String s : stringList) {
                    if (!s.startsWith(prefix)) {
                        return prefix.substring(0, prefix.length() - 1);
                    }
                }
            }
        }


        return prefix;

    }

    public static String caesarCode(String message, int offset) {

        char[] chars = message.toUpperCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = (char) ((chars[i] - 'A' + offset) % 26 + 'A');
            }
        }

        return new String(chars);
    }


    private static boolean isAnagram(String s1, String s2) {

        char[] split = s1.toCharArray();
        char[] split_2 = s2.toCharArray();

        Arrays.sort(split);
        Arrays.sort(split_2);
        return Arrays.equals(split, split_2);
    }

    private static void printStrings(String... strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }
}