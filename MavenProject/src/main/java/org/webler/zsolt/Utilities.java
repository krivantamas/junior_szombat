package org.webler.zsolt;

public class Utilities {


    public String joinWords(String... strings) {

        String joined = "";

        for (String word : strings) {
            joined = join(joined, word);
        }

        return joined;
    }

    private String join(String first, String second) {
        if (first.equals(second)) {
            return first;
        }
        for (int i = 0; i < first.length(); i++) {
            String prefix = first.substring(i);
            if (second.startsWith(prefix)) {
                return first + second.substring(prefix.length());
            }
        }
        return first + second;
    }

}
