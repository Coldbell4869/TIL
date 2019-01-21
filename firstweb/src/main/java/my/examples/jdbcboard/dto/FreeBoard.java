package my.examples.jdbcboard.dto;

import java.util.Date;

public class FreeBoard {
    private Long id;
    private Long user_id;
    private String user_name;
    private String title;
    private String content;
    private Date regdate;
    private int readcount;
    private int family;
    private int level;
    private int sequence;

    public FreeBoard() {
        this.regdate = new Date();
        this.readcount = 0;
    }

    public FreeBoard(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }

    public FreeBoard(Long id, String title, String content, Date regdate, int readcount) {
        this(title, content);
        this.id = id;
        this.regdate = regdate;
        this.readcount = readcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "FreeBoard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", readcount=" + readcount +
                '}';
    }
}
