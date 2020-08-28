import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(name);

        ArrayList<Integer> list = new ArrayList<Integer>();

        String temp = "";

        while (fileInputStream.available() > 0) {
            temp += (char)fileInputStream.read();
        }

        String[] str = temp.split("\r\n");

        for (int i = 0; i < str.length; i++) {
            if (Integer.parseInt(str[i])%2 == 0)
                list.add(Integer.parseInt(str[i]));
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    int tempInt = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, tempInt);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        bufferedReader.close();
        fileInputStream.close();
    }
}
