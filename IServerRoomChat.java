import java.rmi.Remote;
import java.util.TreeMap;

public interface IServerRoomChat extends Remote{
		public TreeMap<String, IRoomChat> getRooms();
		public void createRoom(String roomName);
}
