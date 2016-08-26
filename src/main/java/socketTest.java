
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yuyu
 */
public class socketTest {

    static String ip = "localhost";
    static int portNum = 8080;

//    public static void ShowTime(Socket w) {

//        try {
//            Scanner scn1 = new Scanner(w.getInputStream());
//            PrintWriter prnt1 = new PrintWriter(w.getOutputStream(), true);
//            
//            String msg1 = "";
//            prnt1.println("Velkommen til server");
//            
//            if(msg1.equals("hello")){
//            msg1 = scn1.nextLine();
//
//                prnt1.println(dateFormat.format(cal.getTime()));
//            
//            }
            
//
//            scn1.close();
//            prnt1.close();
//            w.close();
//        } catch (IOException ex) {
//            Logger.getLogger(socketTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void handleClient(Socket s) {
        try {
            Scanner scn = new Scanner(s.getInputStream());
            PrintWriter prnt = new PrintWriter(s.getOutputStream(), true);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String msg = "";
            prnt.println("dude");
            while (!msg.equals("stop")) {
                msg = scn.nextLine();
                prnt.println(msg.toUpperCase());
                
                if(msg.equals("hejsa")){
                msg = scn.nextLine();

                prnt.println(dateFormat.format(cal.getTime()));
                }
            }

            scn.close();
            prnt.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(socketTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Calendar cal = Calendar.getInstance();
//        System.out.println(dateFormat.format(cal.getTime()));

        if (args.length == 2) {
            ip = args[0];
            portNum = Integer.parseInt(args[1]);

        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, portNum));

        while (true) {
            Socket link = ss.accept();
            System.out.println("new Client Connection");
//ShowTime(link);
//            handleClient(link);
            

        }

    }

}
