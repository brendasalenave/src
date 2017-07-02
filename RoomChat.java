
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class RoomChat extends UnicastRemoteObject implements IRoomChat{

    public RoomChat() throws RemoteException{
    }
    
    public TreeMap<String, IUserChat> userList;
    
    @Override
    public int joinRoom(String username, IUserChat localObjRef) throws RemoteException{
        userList.put(username, localObjRef);
        return userList.size(); // id do usuário
    }

    @Override
    public void leaveRoom(String usrName) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeRoom() throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
