import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway = new Stack<>();
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street = new Stack<>();

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
       // ...


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method
        //...
        driveway.push(licensePlate);
        //System.out.println(driveway);


    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // Complete this method
       // ...
       for (Integer car : driveway) {
           if (car != licensePlate) {
               street.push(car);
           } else {
              driveway.remove(car);
              break;
           }
        
        //System.out.println(driveway);
          }

          /*for (Integer car : street) {
           if (car == licensePlate) {
               street.remove(car);
               break;
           } */
        //System.out.println(driveway);
          }
    

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
       // ...
       for (Integer car : driveway) {
           System.out.println(car);
       }
       //System.out.println(driveway);

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
       // ...
       for (Integer car : street) {
           System.out.println(car);
       }

    }
}
