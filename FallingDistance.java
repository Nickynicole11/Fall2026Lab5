import java.util.Scanner;
/**
 * Calculates the distance an objects falls based on the number of seconds. 
 *
 * @author Nicole Rodriguez
 * @version v1.0
 * @since 10/03/2026
 */
public class FallingDistance
{
    public static final double ACCELERATION = 9.8;
    /** Prompts the user for the number of seconds and displays the distance an object falls for each second.
     *@param args comand-line arguments
     */
    public static void main(String[] args)
    {
        Scanner Keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;
        
        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = Keyboard.nextInt();
        System.out.println("\nTime(secs)\tDistance(m)");
        System.out.println("================");
        
        for( int seconds = 1; seconds <= numOfSecs; seconds++)
        { 
            distance = getDistance(seconds);
            System.out.printf("%d\t\t%.1f%n", seconds, distance);
        }
    }
    /**
     * Calculates the distance an object falls using the formula distance = 0.5 * acceleration * time^2.
     * 
     * @param seconds the number of seconds the objects has been falling 
     * @return the distance the object falls in meters
     */
    public static double getDistance(int seconds)
    {
        return 0.5 * ACCELERATION * Math.pow(seconds, 2);
    }
}