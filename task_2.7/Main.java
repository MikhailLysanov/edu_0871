public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String str = String.valueOf(number);

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int x = Character.getNumericValue(c);
            sum = sum + x;
        }

        return sum;
    }
}
