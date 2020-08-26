public class Main {
    public static void main(String[] args) {

        String array[] = new String[3];
        array[0] = "Мама";
        array[1] = "Мыла";
        array[2] = "Раму";
        prmt(array, 0);
    }

    private static void prmt(String[] pa, int i) {
        if (i == pa.length - 1) {
            arraout(pa);
        } else {
            for (int j = i; j < pa.length; j++) {
                aswap(pa, i, j);
                prmt(pa, i + 1);
                aswap(pa, i, j);
            }
        }
    }


    static void aswap(String[] array, int index1, int index2) {
        String tmp = array[index1];
        array[index1]= array[index2];
        array[index2] = tmp;
    }

    private static void arraout(String[] pa) {
        String s = "  ";

        for (String a : pa) {
            s += a + "";
        }

        s = s.substring(0, s.length() - 2);

        s += "   ";

        System.out.println(s);
    }
}
