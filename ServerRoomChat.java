import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ServerRoomChat extends UnicastRemoteObject implements IServerRoomChat{
    
        public TreeMap<String, IRoomChat> roomList;
    
        JTextArea logServer;
        
        public ServerRoomChat(JTextArea logServer) throws RemoteException{
            this.logServer = logServer;
            roomList = new TreeMap<String, IRoomChat>();
        }
    
        @Override
	public TreeMap<String, IRoomChat> getRooms() throws RemoteException{
            return roomList;
	}

        @Override
	public void createRoom(String roomName) throws RemoteException{
            RoomChat rc = new RoomChat();
            try {
                String ip = InetAddress.getLocalHost().getHostAddress().toString();
                String enderecoServidor = "rmi://"+ip+":2020/";
                
                String url = enderecoServidor + roomName;
                Naming.bind(url, rc);
                logServer.append("Room '"+roomName+"' created...\n");
            } catch (AlreadyBoundException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ServerRoomChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            roomList.put(roomName, rc);
            System.out.println(roomList.size());
	}

}
