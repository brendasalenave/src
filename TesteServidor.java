
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo
 */
public class TesteServidor {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        /*String ip = "192.168.1.3";
        String enderecoServidor = "rmi://"+ip+":2020/";
        int portaServidor = 2020;
        System.setProperty("java.rmi.server.hostname", ip);
        Registry reg = LocateRegistry.createRegistry(portaServidor);
        IServerRoomChat servidor = new ServerRoomChat();    
        reg.bind("Servidor", servidor);  */
    }
}
