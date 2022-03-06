import java.util.Scanner;
import java.util.SortedMap;

public class A51 {
    final static int xMajorityIndex = 8;
    final static int yMajorityIndex = 10;
    final static int zMajorityIndex = 10;
    static int bits = 0;
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

        System.out.println("How many bits to generate in the keystream? \n(Enter a number!)");
        try{
            bits = scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Error: Invalid Input. Please Try Again!");
            return;
        }

        String keystream = "";
        for (int i = 0; i < bits; i++){
            char maj = majority(x.charAt(xMajorityIndex), y.charAt(yMajorityIndex), z.charAt(zMajorityIndex));
            if (x.charAt(xMajorityIndex) == maj){
                char p = xor(x.charAt(13), x.charAt(16));
                p = xor(p, x.charAt(17));
                p = xor(p, x.charAt(18));
                x = p + x.substring(0, x.length() - 1);
            }
            if (y.charAt(yMajorityIndex) == maj){
                char p = xor(y.charAt(20), y.charAt(21));
                y = p + y.substring(0, y.length() - 1);
            }
            if (z.charAt(zMajorityIndex) == maj){
                char p = xor(z.charAt(7), z.charAt(20));
                p = xor(p, z.charAt(21));
                p = xor(p, z.charAt(22));
                z = p + z.substring(0, z.length() - 1);
            }
            char bit = xor(x.charAt(18), y.charAt(21));
            bit = xor(bit, z.charAt(22));
            keystream += bit;
        }
        System.out.println("Done!\n\n\n");

        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("Z: " + z);
        System.out.println("KeyStream: " + keystream);
    }

    public static char majority(char c1, char c2, char c3){
        if (c1 == c2 || c1 == c3){
            return c1;
        }
        return c2;
    }

    public static char xor(char c1, char c2){
        if (c1 == c2){
            return '0';
        }
        return '1';
    }
}
