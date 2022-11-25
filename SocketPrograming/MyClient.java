package com.infotrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	
    public static void main(String[] args)
    {
        
        try (Socket socket = new Socket("localhost", 7050)) {
            
           
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
  
            
            BufferedReader in
                = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
  
          
            Scanner sc = new Scanner(System.in);
            String line = null;
  
            while (!"exit".equalsIgnoreCase(line)) {
                
               
                line = sc.nextLine();
  
               
                out.println(line);
                out.flush();
  
                
                System.out.println("Server replied "
                                   + in.readLine());
            }
            
           
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
