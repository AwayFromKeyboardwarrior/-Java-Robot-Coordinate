import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class SocketFunction {
    static Socket socket;

    public void SocketConnection(String ip, int port) throws Exception {
        socket = new Socket(ip, port);
    }

    public void SocketConnection() throws Exception {
        try {
            String ip = JOptionPane.showInputDialog("IP Address");
            int port = Integer.parseInt(JOptionPane.showInputDialog("Port"));
            socket = new Socket(ip, port);
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }

    }

    public String SocketReading() {
        String socketRead="";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketRead = in.readLine();
            //System.out.println(socketRead);
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
        return socketRead;
    }

    public void SocketSendingbyKbd(String string) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(string);
            out.newLine();
            out.flush();
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
    }

    public void SocketSending(String str) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner str1 = new Scanner(System.in);
            out.write(str);
            out.newLine();
            out.flush();
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
    }
}