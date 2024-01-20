package java_basics;

public class NamingConventionConverter {


    public static String toSnakeCase(String sentence, boolean toUppercase) {

        String[] words = sentence.split(" ");

        StringBuilder snakeCase = new StringBuilder();
        for(int i = 0; i < words.length-1;i++){
            snakeCase.append(!toUppercase ? (words[i].toUpperCase()) : words[i]);
            snakeCase.append("-");
        }
        snakeCase.append(toUppercase ? (words[words.length].toUpperCase()) : words[words.length-1]);
        return snakeCase.toString();

    }

    public static String toCamelCase(String sentence){
        String[] words = sentence.split(" ");

        StringBuilder snakeCase = new StringBuilder();

        snakeCase.append(words[0]);

        for(int i = 1; i < words.length;i++){
            String firstChar = words[i].substring(0,1);
            String remainingChars = words[0].substring(i,words[i].length());
            snakeCase.append(firstChar.toUpperCase()+remainingChars);
        }
        return snakeCase.toString();
    }

    public static String toPascalCase(String sentence){
        throw new UnsupportedOperationException();
    }

    public static String toKebabCase(String sentence){
        throw new UnsupportedOperationException();
    }




}
