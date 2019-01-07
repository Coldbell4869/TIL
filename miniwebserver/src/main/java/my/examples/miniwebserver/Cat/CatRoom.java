package my.examples.miniwebserver.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 유저들이 들어가서 채팅할 수 있는 채팅방 하나하나를 나타내는 클래스
 */

// 채팅방에는 당연히 방제가 있고, 비번방을 위한 비밀번호, 그리고 채팅방에 들어와있는 유저들의 리스트가 있을것이다.
public class CatRoom {
    private List<CatUser> room;
    private String title;
    private String password;

//    두 가지 채팅방 유형을 생성자로 정의해둔다(일반방/비번방)
    // 일반방
    public CatRoom(CatUser catUser, String title){
        this.title = title;
        room = Collections.synchronizedList(new ArrayList<>());
        room.add(catUser);
    }
    public CatRoom(CatUser catUser, String title, String password){
        this.title = title;
        this.password = password;
        room = Collections.synchronizedList(new ArrayList<>());
        room.add(catUser);
    }

    public void addCatUser(CatUser catUser){
        room.add(catUser);
    }

    public boolean ExistCatUser(CatUser catUser) {
        return room.contains(catUser);
    }

    public List<CatUser> getRoom() {
        return room;
    }

    public void setRoom(List<CatUser> room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

