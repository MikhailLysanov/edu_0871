package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream incoming = new DataInputStream(socket.getInputStream());
                DataOutputStream outgoing = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключен.");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = null;
                        try {
                            outgoing.writeUTF("Укажите ваше имя:");
                            String name = incoming.readUTF();
                            System.out.println("name: " + name);

                            user = new User(name, socket);
                            users.add(user);

                            broadcastMsg("", "");

                            while (true) {
                                String str = incoming.readUTF();
                                broadcastMsg(user.name, str);

                                System.out.println(user.name + " прислал сообщение: " + str);
                            }
                        } catch (IOException e) {
                            try {
                                socket.close();
                                users.remove(user);
                                broadcastMsg("", "");
                            } catch (Exception ee) {
                            }

                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMsg(String userName, String str) {
        for (User user: users) {
            if (userName.isEmpty() && str.isEmpty()) {
                String stri = "/+**:";
                for (int i = 0; i < users.size(); i++) {
                    stri = stri + users.get(i).name + ";";
                }
                stri = stri.substring(0, stri.length() - 1);
                user.send(stri);
            } else {
                user.send(userName + " сказал: " + str);
            }
        }
    }
}

class User {
    String name;
    Socket socket;

    User(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    void send(String text) {
        DataOutputStream outgoing;
        try {
            outgoing = new DataOutputStream(socket.getOutputStream());
            outgoing.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
