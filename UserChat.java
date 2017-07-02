
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
public class UserChat extends UnicastRemoteObject implements IUserChat {

    public UserChat() throws RemoteException{
    }
    
    @Override
    public void deliverMsg(String senderUsrName, String msg, int id, Integer[] clockMatrix) throws RemoteException{
        
    }
    
    
    @Override
    public void updateUserList(TreeMap<String, IUserChat> userList) throws RemoteException{

    }
    
}
