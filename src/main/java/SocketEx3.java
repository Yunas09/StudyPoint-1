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
public class SocketEx3 {
    static String ip = "localhost";
    static int portNum = 8080;

   public static void WordTranslate(Socket s){
    
        try { 
            Scanner scn1 = new Scanner(s.getInputStream());
            PrintWriter prnt1 = new PrintWriter(s.getOutputStream(), true);
            String msg = "";
            prnt1.println("Velkommen Til server");
            if(msg.equals("Dog")){
                msg = scn1.nextLine();
                prnt1.println("Hund");
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketEx3.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public static void main(String[] args) throws IOException {


        if (args.length == 2) {
            ip = args[0];
            portNum = Integer.parseInt(args[1]);

        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, portNum));

        while (true) {
            Socket link = ss.accept();
            System.out.println("new Client2 Connection");
            WordTranslate(link);
        }
   }
   
   

}
