package my.examples.miniwebserver.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 챗하우스의 개념을 만들고, 그 안에는 여러개의 채팅방과 다수의 챗 유저가 있을 수 있도록 한다.
 */

// 챗하우스 안에 여러 방과 챗하우스에 있는 유저들을 각각 리스트로 만들어둔다.
public class CatHouse {
    private List<CatRoom> rooms;
    private List<CatUser> lobby;

// 챗하우스를 만들 때 rooms와 lobby의 쓰레드가 꼬이지 않도록 synchronizedList() 메소드를 사용한다.
    public CatHouse(){
        rooms = Collections.synchronizedList(new ArrayList<>());
        lobby = Collections.synchronizedList(new ArrayList<>());
    }

    public void createRoom(CatUser catUser, String title){
        CatRoom catRoom = new CatRoom(catUser, title);
        rooms.add(catRoom);
    }

    public void createPasswordRoom(CatUser catUser, String title, String password){
        CatRoom catRoom = new CatRoom(catUser, title, password);
        rooms.add(catRoom);
    }

    public void addLobbyUser(CatUser catUser) { lobby.add(catUser);}

    public void exit(CatUser catUser) { lobby.remove(catUser);}

    public List<CatUser> getUser(CatUser catUser){
        for(CatRoom room : rooms){
            if(room.ExistCatUser(catUser)){
                return room.getRoom();
            }
        }
        return new ArrayList<>();
    }

    public List<CatRoom> getRooms() {
        return rooms;
    }

    public List<CatUser> getLobby() {
        return lobby;
    }

    public void joinRoom(int roomNum, CatUser catUser){
        CatRoom catRoom = rooms.get(roomNum);
        catRoom.addCatUser(catUser);
    }

    public void joinRoom(int roomNum, CatUser catUser, String password){
        CatRoom catRoom = rooms.get(roomNum);
        catRoom.addCatUser(catUser);
    }
}
