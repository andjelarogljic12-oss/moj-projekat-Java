/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klijent;

import domain.Odgovor;
import domain.Zahtev;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class Komunikacija {
    private static final String ADRESA = "localhost";
    private static final int PORT = 9000;
    
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    public void poveziSe() throws Exception{
        socket = new Socket(ADRESA, PORT);
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
    }
    
    public Odgovor posalji(Zahtev zahtev) throws Exception{
        out.writeObject(zahtev);
        out.flush();
        return (Odgovor) in.readObject();
    }
    
    public void prekiniVezu() throws Exception{
        if(socket != null){
            socket.close();
            
        }
    }
}
