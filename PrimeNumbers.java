import java.util.Scanner;
/**
 * Determines whether a number is a prime number and 
 * allows users to test multiple numbers
 * 
 *
 * @author Nicole Rodriguez
 * @version v1.0
 * @since 10/3/2026
 */
public class PrimeNumbers
{
    public static void main(String[] args)
    {
        boolean isPrime;
        int num;
        String playAgain;
        
        Scanner Keyboard = new Scanner(System.in); 
        
        do
        {
            System.out.print("Enter a whole number > 2 to test if prime: ");
            num = Keyboard.nextInt();
            isPrime = testForPrime(num);
            
            if (isPrime)
            {
                System.out.println(num + " is prime.");
            }
            else
            {
                System.out.println(num + " is not prime.");
            }
            System.out.print("Enter yes to test another number, no to quit ");
            playAgain = Keyboard.next();
        }
        while (playAgain.equalsIgnoreCase("yes"));
    }
    /**
     * Determines whether an integer is a prime number or not.
     * 
     * @param inNumber the number is being tested
     * @return true if the number is prime, false if otherwise
     */
    public static boolean testForPrime(int inNumber)
    {
        int inNumberSqRt;
        inNumberSqRt = (int)Math.sqrt(inNumber);
        boolean isPrimeMeth = true;
        
        for (int i =2; isPrimeMeth && i <= inNumberSqRt; i++)
        {
            if(inNumber % i == 0)
            {
                isPrimeMeth = false;
            }
        }
        return isPrimeMeth;
    }
}