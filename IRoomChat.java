
import java.rmi.Remote;

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
    public int joinRoom(String username, IUserChat localObjRef);
    public void leaveRoom(String usrName);
    public void closeRoom();
}
