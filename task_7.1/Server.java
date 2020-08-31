package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("В ведите логин: ");
        String login = scanner.nextLine();
        System.out.println(login);
        System.out.print("В ведите пароль: ");
        String password = scanner.nextLine();
        System.out.println(password);
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true){
                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключился");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true){
                                String str = in.readUTF();
                                broadcastMsg(str);
                                System.out.println("Клиент прислал сообщение: "+str);
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void broadcastMsg(String str) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(str);
        }
    }
}
