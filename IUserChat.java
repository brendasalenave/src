/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.TreeMap;

/**
 *
 * @author mdonato
 */
public interface IUserChat extends Remote {
    public void deliverMsg(String senderUsrName, String msg, int id, Integer[] clockMatrix) throws RemoteException;
    public void updateUserList(TreeMap<String, IUserChat> userList) throws RemoteException;
}
