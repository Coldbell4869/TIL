package my.examplse.firstweb;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FreeDTO {

    private long id;
    private String name;
    private String[] checkbox;
    private String radio;
    private String password;
    private String title;
    private String contents;
    private LocalDate regdate;
    private long viewcount;

    public FreeDTO(){
        regdate = LocalDate.now();
    }

    public FreeDTO(long id, String name, String title, long viewcount) {
        this();
        this.id = id;
        this.name = name;
        this.title = title;
        this.viewcount = viewcount;
    }

    public FreeDTO(String name, String title, String contents) {
        this();
        this.name = name;
        this.title = title;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String[] checkbox) {
        this.checkbox = checkbox;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }

    public long getViewcount() {
        return viewcount;
    }

    public void setViewcount(long viewcount) {
        this.viewcount = viewcount;
    }
}
