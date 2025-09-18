import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	Stack<String> words = new Stack<>();
        // Complete this method. Use a Stack.
       // ...
       
       
       /*for (int i = 0; i < 5; i++) { 
            //words.push(sentence.substring(0, sentence.indexOf(" ")));
            words.push(scanner.next()); //iterate until scanner.next().contains(".") and then pop stack onto the output string, clear stack, then keep iterating
            //if 
       }*/

       
       String x = "";
       String output = "";

       while(scanner.hasNext()) {
        x = scanner.next();

        if (x.contains(".")) {
            words.push(x.substring(0, 1).toUpperCase() + x.substring(1, x.length()-1));
            int len = words.size();
            for (int i = 0; i < len; i++) {
                output += words.pop() + " ";
            } 

            
        } else {
            if (words.isEmpty()) {
                words.push(x.toLowerCase() + ".");
            }
            else {
                words.push(x.toLowerCase());
            }
        }
            
            
       }

        System.out.println(output);       





        return sentence;

    }
}
