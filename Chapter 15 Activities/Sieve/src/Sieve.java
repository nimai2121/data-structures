import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < n; i++) {
            set.add(i);
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int d = iterator.next();
            if (d % 2 == 0 || d % 3 == 0 ) {
                iterator.remove();
                //System.out.println(set);
            }
        }

        System.out.println(set);
        

        
        //. . .







    }
}
