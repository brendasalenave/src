
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.TreeMap;

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
        UserChat uc = new UserChat();
        String name = "Leonardo";
        
        String urlServer = "rmi://192.168.1.3:2020/Servidor";
        
        IServerRoomChat server = (IServerRoomChat) Naming.lookup(urlServer);
        server.createRoom("room");
        
        TreeMap<String, IRoomChat> rooms = server.getRooms();
        
        IRoomChat rc = (IRoomChat) Naming.lookup("rmi://192.168.1.3:2020/room");
        
        if(rc!=null){
            System.out.println(rooms.size());
            rc.joinRoom(name, (IUserChat) uc);
        }
        
    }
    
}
