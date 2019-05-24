import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SocketButton {

    private JFrame frame;
    private JPanel panel;
    private JButton showDialogButton;
    private JButton showDialogButton2;
    private JButton showDialogButton3;
    private JButton showDialogButton4;
    private JButton showDialogButton5;
    private SocketFunction sockettest;

    public void run() throws Exception {
        _initialize();
        displayJFrame();
    }

    public void _initialize() throws Exception {
        panel = new JPanel();
        frame = new JFrame("Socket Communication");
        showDialogButton = new JButton("Connection - fixed IP");
        showDialogButton2 = new JButton("Connection - custom IP");
        showDialogButton3 = new JButton("Send - Hi");
        showDialogButton4 = new JButton("Send - Type");
        showDialogButton5 = new JButton("Read");
        sockettest = new SocketFunction();

        // put the button on the panel
        panel.add(showDialogButton);
        panel.add(showDialogButton2);
        panel.add(showDialogButton3);
        panel.add(showDialogButton4);
        panel.add(showDialogButton5);

        // set up the jframe, then display it
        frame.add(panel);
        frame.setPreferredSize(new Dimension(350, 120));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void displayJFrame() {

        showDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sockettest.SocketConnection("127.0.0.1", 1025);
                } catch (Exception e1) {
                    System.out.println("Unexpected exception: " + e1.getMessage());
                }
            }
        });

        showDialogButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sockettest.SocketConnection();
                } catch (Exception e1) {
                    System.out.println("Unexpected exception: " + e1.getMessage());
                }
            }
        });

        showDialogButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sockettest.SocketSending("Hi");
                } catch (Exception e1) {
                    System.out.println("Unexpected exception: " + e1.getMessage());
                }
            }
        });

        showDialogButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String kbdtype = JOptionPane.showInputDialog(null);
                    sockettest.SocketSendingbyKbd(kbdtype);
                } catch (
                        Exception e1) {
                    System.out.println("Unexpected exception: " + e1.getMessage());
                }
            }
        });

        showDialogButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sockettest.SocketReading();
                } catch (Exception e1) {
                    System.out.println("Unexpected exception: " + e1.getMessage());
                }
            }
        });

    }
}