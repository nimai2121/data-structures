import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//. . .
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Map<String, String> names = new HashMap<>();
        //. . .

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
               // . . .
               System.out.println("What's the student's name?");
               String nameOfStudent = in.next();
               //System.out.println();
               System.out.println("What's the student's grade?");
               String grade = in.next();
               names.put(nameOfStudent, grade);

            } else if (input.equals("R"))
            {
               System.out.println("What's the student's name that you want to remove?");
               String name = in.next();
               Set<String> keys = names.keySet();
               boolean noStudent = true;
                for (String n: keys) {
                    if (n.equals(name)) {
                        names.remove(n);
                        noStudent = false;
                        break;
                    
                    
                    } //else {
                    //    System.out.println("Student not found!");
                    //}
                }
                if (noStudent) {
                        System.out.println("Student not found!");
                    }

               
               // . . .
            } else if (input.equals("M"))
            {

               System.out.println("What's the student's name that you want to edit the grades for?");
               String name = in.next();
               
               Set<String> keys = names.keySet();
              boolean noStudent = true;
                for (String n: keys) {
                    if (n.equals(name)) {
                        System.out.println("What's the student's new grade?");
                        String grade = in.next();
                        //names.remove(n);
                        names.put(n, grade); 
                        noStudent = false;
                       
                    }
                    
                    if(noStudent) {
                        System.out.println("Student not found!");
                    }
                }
               // . . .
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = names.keySet();
                for (String key: keys) {
                    System.out.println(key + ": " + names.get(key));
                }

            } else
            {
                done = true;
            }
        }
    }
}
