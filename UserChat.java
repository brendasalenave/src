
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo
 */
public class UserChat extends UnicastRemoteObject implements IUserChat {

    public TreeMap <String, IUserChat> userList;
    private JTextArea log;
    private JList usersRoomList;
    public String username;
    public int id;
    public Integer[] clockMatrix = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public TreeMap<String,Integer[]> buffer = new TreeMap<String, Integer[]>();
    public TreeMap<String,String> buffer1 = new TreeMap<String, String>();
    
    
    public UserChat(JTextArea log, JList usersRoomList) throws RemoteException{
        this.log = log;
        this.usersRoomList = usersRoomList;
    }
    
    @Override
    public void deliverMsg(String senderUsrName, String msg, int id, Integer[] clockMatrix) throws RemoteException{
        if(senderUsrName.equals(username)){
            log.append("Me: "+msg+"\n");
        }else{
            if(verify(this.clockMatrix,clockMatrix)){
                this.clockMatrix[id]+=1;
                log.append(senderUsrName+": "+msg+"\n");
            }else{
                //vai pro buffer
                Integer[] copy = new Integer[21];
                System.arraycopy(clockMatrix, 0, copy, 0, 20);
                copy[20]=id;
                buffer.put(senderUsrName, copy);
                buffer1.put(senderUsrName, msg);
            }
            
            if(buffer.size()>0){
                for(String arg : buffer.keySet()){
                    String sender = arg;
                    String msg1 = buffer1.get(arg);
                    Integer[] clock = buffer.get(arg);
                    int id1 = clock[20];
                    Integer[] copy1 = new Integer[20];
                    System.arraycopy(clock, 0, copy1, 0, 20);
                    if(verify(this.clockMatrix,copy1)){
                        this.clockMatrix[id1]+=1;
                        log.append(sender+": "+msg1+"\n");
                        buffer.remove(sender);
                        buffer1.remove(sender);
                    }
                }
            }
            
        }
    }
    
    
    @Override
    public void updateUserList(TreeMap<String, IUserChat> userList) throws RemoteException{
        this.userList = userList;
        this.updateUsersRoom();
    }
    
    private void updateUsersRoom(){
        DefaultListModel model = new DefaultListModel();
        for (String name : userList.keySet()){
            model.addElement(name);
        }
        this.usersRoomList.setModel(model);
    }
    
    public void clearUsersRoom(){
        userList.clear();
        DefaultListModel model = new DefaultListModel();
        usersRoomList.setModel(model);
    }
    
    public void sendMsg(String msg,List<String> atrasos) throws RemoteException, InterruptedException{
        clockMatrix[id]+=1;
        Integer[] copyOfClockMatrix = clockMatrix.clone();
        Set<String> names = userList.keySet();
        System.out.println(atrasos.size());
        for (String name : names){
            if(!atrasos.contains(name)){
                IUserChat iuc = userList.get(name);
                iuc.deliverMsg(username, msg, id, clockMatrix);
            }
        }
        if(atrasos.size()>0){
            new Thread(){
                public void run(){
                    try {
                        Thread.sleep(15000);
                        for (String name : atrasos){
                            IUserChat iuc = userList.get(name);
                            iuc.deliverMsg(username, msg, id, copyOfClockMatrix);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserChat.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserChat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
    
    public Boolean verify(Integer[] clk1, Integer[] clk2){
        int diff = 0;
        for(int i=0;i<20;i++){
            diff+= Math.abs(clk1[i]-clk2[i]);
        }
        if(diff==1){
            return true;
        }
        return false;
    }
}