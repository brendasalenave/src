
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
public class RoomChat implements IRoomChat{

    public TreeMap<String, IUserChat> userList;
    
    @Override
    public int joinRoom(String username, IUserChat localObjRef) {
        userList.put(username, localObjRef);
        return userList.size(); // id do usuário
    }

    @Override
    public void leaveRoom(String usrName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeRoom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
