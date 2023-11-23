


public class EmptyString {

    interface StringPredictor {

        boolean predicate(String s);
    }

    public boolean predicate(String s, StringPredictor stringPredictor){
        return stringPredictor.predicate(s);
    }

    public static void main (String... args){

        StringPredictor emptyStringPredictor = s -> s.isEmpty();
        StringPredictor stringLengthLessThan5 = s -> { return s.length()<5;};

        EmptyString emptyString = new EmptyString();


        System.out.println(emptyString.predicate("alma",emptyStringPredictor));
        System.out.println(emptyString.predicate("",emptyStringPredictor));
        System.out.println(emptyString.predicate("almafa",stringLengthLessThan5));
        System.out.println(emptyString.predicate("",stringLengthLessThan5));

    }


}
