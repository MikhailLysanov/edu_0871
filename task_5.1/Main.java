import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,String> addresses = new HashMap<String, String>();
        while (true)
        {
            String city = reader.readLine();
            if(city.isEmpty()) break;
            String name = reader.readLine();
            if (!city.isEmpty() & !name.isEmpty())
            {
                addresses.put(city, name);
            }
            else break;
        }

        String tempCity = reader.readLine();


        for (Map.Entry<String, String> pair: addresses.entrySet())
        {
            String city = pair.getKey();

            if (tempCity.equals(city))
            {
                String name = pair.getValue();
                System.out.println(name);
            }
        }
    }

}
