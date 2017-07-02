
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo
 */
public class Teste {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException{
        IUserChat uc = new UserChat();
        String name = "Leonardo";
        
        String urlServer = "rmi://192.168.1.4:2020/Servidor";
        
        IServerRoomChat server = (IServerRoomChat) Naming.lookup(urlServer);
        server.createRoom("room");
        
        
        
        
    }
    
}
