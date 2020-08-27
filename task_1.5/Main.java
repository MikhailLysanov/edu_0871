import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cTemp = scanner.nextInt();
        double fTemp = ((cTemp * 9 ) / 5) + 32;
        System.out.println(fTemp);
    }
}
