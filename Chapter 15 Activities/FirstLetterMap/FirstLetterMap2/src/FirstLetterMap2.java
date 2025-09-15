import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. Then print out the word sets in
 * alphabetical order. Update the map by modifying
 * Worked Example 15.1.
*/
public class FirstLetterMap2
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/FirstLetterMap/FirstLetterMap2/src/test1.txt";
        System.out.println(System.getProperty("user.dir"));
        //String filename = "data-structures/Chapter 15 Activities/FirstLetterMap/FirstLetterMap2/src/test1.txt";
        

        try (Scanner in = new Scanner(new File(filename)))
        {
            Map<Character, Set<String>> map = new HashMap<>();

            // Create your map here
            //...

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Modify Worked Example 15.1
                //Use the Java 8 merge method
                map.merge(c, new HashSet<>(Arrays.asList(word)), (oldSet, newSet) -> { 
                    oldSet.addAll(newSet);
                    return oldSet;
                }); 

                //map.merge(c, word, (oldVal, newVal) -> oldVal + ", " + newVal);
                



            }

            // Print the map here in this form
            // a: [a, able, aardvark]
           // . . .
            for (Character key: map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }

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
