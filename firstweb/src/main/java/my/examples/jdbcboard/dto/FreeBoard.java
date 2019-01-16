package my.examples.jdbcboard.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FreeBoard {

    private long id;
    private String title;
    private String name;
    private String content;
    private Date regdate;
    private int readcount;
    private int family;
    private int level;
    private int sequence;

    public FreeBoard() {
    }

    public FreeBoard(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

//    public FreeBoard(String name, String title, String content, long id) {
//        this(name, title, content);
//        this.id = id;
//    }

    public FreeBoard(long id, String name, String title, String content, Date regdate, int readcount, int family, int level, int sequence) {
        this(name,title,content);
        this.id = id;
        this.regdate = regdate;
        this.readcount = readcount;
        this.family = family;
        this.level = level;
        this.sequence = sequence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", readcount=" + readcount +
                ", family=" + family +
                ", level=" + level +
                ", sequence=" + sequence +
                '}';
    }
}
