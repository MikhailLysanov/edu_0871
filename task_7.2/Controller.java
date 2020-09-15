package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {

    Socket socket;
    DataInputStream incoming;
    DataOutputStream outgoing;

    @FXML
    TextArea messageWindow;

    @FXML
    TextArea userList;

    @FXML
    TextField textField;

    @FXML
    private void send(){
        String str = textField.getText();
        try {
            outgoing.writeUTF(str);
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        try {
            socket = new Socket("localhost", 8189);
            incoming = new DataInputStream(socket.getInputStream());
            outgoing = new DataOutputStream(socket.getOutputStream());
           
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String response = null;
                        try {
                            response = incoming.readUTF();
                            if (response.startsWith("/+**:")) {
                                response = response.substring(5);
                                response = response.replaceAll(";", "\n");
                                userList.setText(response);
                            } else {
                                messageWindow.appendText(response + "\n");
                            }
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });
            responseThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
