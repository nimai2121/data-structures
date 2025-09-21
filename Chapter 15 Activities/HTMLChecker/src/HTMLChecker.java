import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        //System.out.println(System.getProperty("user.dir"));
        String filename = "data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            //...
            

            Stack<String> tagStack = new Stack<>();
            while (in.hasNext())
            {
                String token = in.next();
                if (token.startsWith("<") && !token.startsWith("</"))
                {
                    // Opening tag
                    tagStack.push(token);
                }
                else if (token.startsWith("</"))
                {
                    // Closing tag
                    if (tagStack.isEmpty() || !tagStack.pop().equals(token.replace("/", "")))
                    {
                        System.out.println("Unmatched closing tag: " + token);
                    }
                }
            }

            if (!tagStack.isEmpty())
            {
                System.out.println("Unmatched opening tags: " + tagStack);
            } else {
                System.out.println("All tags are properly nested.");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
