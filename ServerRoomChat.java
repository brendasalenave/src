import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRoomChat extends UnicastRemoteObject implements IServerRoomChat{
    
        public ServerRoomChat() throws RemoteException{
            
        }
    
        public TreeMap<String, IRoomChat> roomList;
    
        @Override
	public TreeMap<String, IRoomChat> getRooms() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

        @Override
	public void createRoom(String roomName) throws RemoteException{
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
