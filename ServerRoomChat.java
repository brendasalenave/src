import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRoomChat implements IServerRoomChat{

        public TreeMap<String, IRoomChat> roomList;
    
	public TreeMap<String, IRoomChat> getRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createRoom(String roomName) {
            String ip = "192.168.1.4";
            String enderecoServidor = "rmi://"+ip+":2020/";
            RoomChat rc = new RoomChat();
            String url = enderecoServidor + roomName;
            try {
                Naming.bind(url, rc);
            } catch (AlreadyBoundException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.roomList.put(roomName, rc);
	}

}
