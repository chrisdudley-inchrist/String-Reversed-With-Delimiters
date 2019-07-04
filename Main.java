import java.util.*;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Facebook.
 *
 * Given a string and a set of delimiters, reverse the words in the
 * string while maintaining the relative order of the delimiters.
 * For example, given "hello/world:here", return "here/world:hello"
 *
 * Follow-up: Does your solution work for
 * the following cases: "hello/world:here/", "hello//world:here"
 */

public class Main {

    public static void main(String[] args) {
        String reversed = stringReverser("hello/world:here/");
        System.out.println(reversed);
    }

    private static String stringReverser(String s) {
        String word = "";
        String reversed = "";
        LinkedList<String> wordsBackwards = new LinkedList<>();
        LinkedList<Character> delimiters = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '/' || c == ':') {
                delimiters.addLast(c);
                wordsBackwards.addFirst(word);
                word = "";
            } else {
                word += c;
            }
        }
        if (word != ""
        ) {
            wordsBackwards.addFirst(word);
        }

        int biggestSize = wordsBackwards.size();
        if (wordsBackwards.size() < delimiters.size()) {
            biggestSize = delimiters.size();
        }


        for (int i = 0; i < biggestSize; i++) {
            reversed += wordsBackwards.get(i);
            reversed += delimiters.get(i);
        }
        return reversed;
    }
}



