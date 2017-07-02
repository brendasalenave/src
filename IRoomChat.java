
import java.rmi.Remote;
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
public interface IRoomChat extends Remote{
    public int joinRoom(String username, IUserChat localObjRef) throws RemoteException;
    public void leaveRoom(String usrName) throws RemoteException;
    public void closeRoom() throws RemoteException;
}
