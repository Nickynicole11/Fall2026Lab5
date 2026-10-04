import java.io.*;
import java.util.Scanner;
/**
 * Program reads sets of grades from an input file, 
 * calculates the number of each letter grade, minimum, maximum, and average, and writes the results to an output file.
 *
 * @author Nicole Rodriguez
 * @version v1.0
 * @since 10/04/2026
 */
public class GradeProcessing
{
     public static void main(String[] args) throws IOException
    {
        String inFile, outFile;

        inFile = getInFile();
        outFile = getOutFile();

        processFile(inFile, outFile);
    }
    /**
     * Uses Scanner to get and return the input file name.
     * @return input file name
     */
    public static String getInFile()
    {
        String fileName;
        File inputFile;
        
        Scanner Keyboard = new Scanner(System.in);
        
        System.out.print("Enter the name of the input file: ");
        fileName = Keyboard.nextLine();

        inputFile = new File(fileName);

        while (!inputFile.exists())
        {
            System.out.print("File not found. Enter the input file name again: ");
            fileName = Keyboard.nextLine();

            inputFile = new File(fileName);
        }
        return fileName;
    }
    /**
     * Uses Scanner to get and return the output file name.
     * @return output file name
     */
    public static String getOutFile()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the name of the output file: ");
        
        return keyboard.nextLine();
    }
    /**
     * Reads grades from the input file and writes the results to the output file.
     * 
     * @param inFileName name of input file
     * @param outFileName name of output file
     */
    public static void processFile(String inFileName, String outFileName) throws IOException 
    {
        int number, As, Bs, Cs, Ds, Fs, min, max, total, count, set = 1;
        double average;
        
        File inputFile = new File(inFileName);
        
        Scanner inStream = new Scanner(inputFile);
        
        PrintWriter outStream = new PrintWriter(outFileName);
        
        while(inStream.hasNextLine())
        {
            As=0;
            Bs=0;
            Cs=0;
            Ds=0;
            Fs=0;
            
            average= 0.0;
            
            number = inStream.nextInt();
            
            min = number;
            max = number;
            
            total = 0;
            count = 0;
            
            while(number != -1)
            {
                if(number < min)
                {
                    min = number;
                }
                if(number > max)
                {
                    max = number;
                }
                count ++;
                total += number;
                
                if(number >= 90)
                {
                    As++;
                }
                else if (number >= 80)
                {
                    Bs++;
                }
                 else if (number >= 70)
                {
                    Cs++;
                }
                 else if (number >= 60)
                {
                    Ds++;
                }
                 else 
                {
                    Fs++;
                }
                number = inStream.nextInt();
            }
            outStream.println("Set " + set + " of grades calculated");
            
            if (count == 0)
            {
                outStream.println(" No grades to average");
            }
            else
            {
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);
                
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);

                average = (double) total / count;

                outStream.printf("The average score is: %.1f%n", average);
            }
            outStream.println();
            set++;
            
        }
        System.out.println("Grade processing is completed.");
        System.out.println("You can retrieve the output file at: " + outFileName);
        
        inStream.close();
        outStream.close();
    }
    }