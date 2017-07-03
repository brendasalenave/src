
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
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

    public TreeMap<String, IUserChat> userList;
    public TreeMap<String, Integer> userIds;
    public ArrayList<Integer> freeIds = new ArrayList<Integer>();
    
    public RoomChat() throws RemoteException{
        userList = new TreeMap();
        userIds = new TreeMap();
        for(int i=0;i<20;i++){
            freeIds.add(i);
        }
    }
    
    @Override
    public int joinRoom(String username, IUserChat localObjRef) throws RemoteException{
        if(freeIds.size()>0){
            userList.put(username, localObjRef);
            for(Map.Entry<String, IUserChat> entry : this.userList.entrySet()) {
                entry.getValue().updateUserList(this.userList);
            }
            int id = freeIds.remove(0);
            userIds.put(username, id);
            return id;
        }
        return -1;
    }

    @Override
    public void leaveRoom(String usrName) throws RemoteException{
        userList.remove(usrName);
        for(Map.Entry<String, IUserChat> entry : this.userList.entrySet()) {
            entry.getValue().updateUserList(this.userList);
        }
        int id = userIds.remove(usrName);
        freeIds.add(id);
        
    }

    @Override
    public void closeRoom() throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
