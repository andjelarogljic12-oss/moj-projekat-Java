/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9000)){
            System.out.println("Server pokrenut na 9000...");
            
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Klijent je povezan.");
                new KlijentNit(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}