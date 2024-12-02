import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Matrix. Input size and character from keyboard
 */
public class Lab1UvarovViktor {
    /**
     * @param args command line values
     * @throws FileNotFoundException if the file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int length;
        char fill;
        File dataFile = new File("Lab1.txt");

        try (PrintWriter fout = new PrintWriter(dataFile)) {
            // Input character and matrix length
            System.out.print("Введіть розмір квадратної матриці: ");
            length = scan.nextInt();
            System.out.print("Введіть символ: ");
            scan.nextLine(); // Clear buffer
            fill = scan.next().charAt(0);

            char[][] array = new char[length][length];

            // Output image of the matrix
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    // Logic for outputting characters
                    if (i == 0 || i == length - 1 || j == 0 || j == length - 1 ||
                        (i > 1 && i < length - 2 && j > 1 && j < length - 2)) {
                        array[i][j] = fill;
                        System.out.print(array[i][j] + " ");
                        fout.print(array[i][j] + " ");
                    } else {
                        System.out.print("  "); // Two spaces for alignment
                        fout.print("  ");
                    }
                }
                System.out.println(); // Newline for console
                fout.println(); // Newline for file
            }
        }

        scan.close(); // Close scanner
    }
}