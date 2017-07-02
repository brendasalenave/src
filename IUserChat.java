
import java.rmi.Remote;
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
public interface IUserChat extends Remote{
    
    public void deliverMsg(String senderUsrName, String msg, int id, Integer[] clockMatrix);
    public void updtateUserList(TreeMap<String, IUserChat> userList);
    
}
