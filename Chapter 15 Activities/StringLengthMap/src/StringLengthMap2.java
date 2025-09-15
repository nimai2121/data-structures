import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "data-structures/Chapter 15 Activities/StringLengthMap/src/test1.txt";
        //String filename = "Chapter 15 Activities/StringLengthMap/src/test1.txt";
        System.out.println(System.getProperty("user.dir"));

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Integer, String> map = new HashMap();
            

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                map.merge(len, word, (oldVal, newVal) -> oldVal + ", " + newVal);

                // Update the map here
                // map.put(len, word);
                // Modify Worked Example 15.1
                
            }

            for (Integer key: map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
