public class Main {
    public static void main(String[] args) {
        String array[] = new String[3];
        array[0] = "Мама";
        array[1] = "Мыла";
        array[2] = "Раму";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if(i!=j & i!=k & j!=k) 
                        System.out.println(array[i]+array[j]+array[k]);
                }
            }
       }
    }
} 
