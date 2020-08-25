public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = i + 1;
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i <= 9; i++) {
                int a = arr[j] * i;

                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }
}
