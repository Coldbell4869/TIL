package my.examplse.firstweb;

import java.time.LocalDateTime;

public class Board {
    // 필드
    private Long id;
    private String name;
    private String password;
    private String title;
    private String content;
    private LocalDateTime regdate;

    // 자기 자신의 생성자를 호출하는 방법
    // LocalDateTime 에 대하여 공부
    public Board(){
        regdate = LocalDateTime.now(); // 현재 시간을 저장.
    }

    public Board(String name, String title, String content){
        this(); // 기본 생성자를 이런식으로 또다시 불러올 수 있음. 맨 위에 있어야됨.
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public Board(String name, String password, String title, String content){
        this(name, title, content);
        this.password = password;
    }

    // getter, setter 메소드
    // getter, setter 메소드를 '프로퍼티' 라고 부름.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }
}
