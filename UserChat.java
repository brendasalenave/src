
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updtateUserList(TreeMap<String, IUserChat> userList) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
