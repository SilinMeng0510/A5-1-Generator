import java.util.Scanner;
import java.util.SortedMap;

public class A51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = "", y = "", z = "";
        boolean valid = false;
        while(!valid){
            System.out.println("Instruction: X = 19 Bits, Y = 22 Bits, Z = 23 Bits. \n");
            System.out.println("X: ");
            x = scan.nextLine();
            System.out.println("Length: " + x.length());
            System.out.println("Y: ");
            y = scan.nextLine();
            System.out.println("Length: " + y.length());
            System.out.println("Z: ");
            z = scan.nextLine();
            System.out.println("Length: " + z.length());
            if (x.length() == 19 && y.length() == 22 && z.length() == 23){
                System.out.println("Processing: Valid Length");
                String v = x + y + z;
                boolean isBinary = true;
                for (int i = 0; i < v.length(); i++){
                    if (v.charAt(i) != '0' && v.charAt(i) != '1'){
                        isBinary = false;
                    }
                }
                if (isBinary){
                    valid = true;
                    System.out.println("Complete!");
                }
                else{
                    System.out.println("Error: Must Contain Only 0 Or 1");
                }
            }
            else
                System.out.println("Error: Invalid Length\n\n\n");
        }
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("Z: " + z);


    }
}
