package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("https://667480e6fa86.eu.ngrok.io", 8189); //
            DataInputStream incoming = new DataInputStream(socket.getInputStream());
            DataOutputStream outgoing = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String response = null;
                        try {
                            response = incoming.readUTF();
                            System.out.println(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            responseThread.start();
            while (true) {
                String str = scanner.nextLine();
                outgoing.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
