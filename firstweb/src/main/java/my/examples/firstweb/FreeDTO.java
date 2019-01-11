package my.examples.firstweb;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FreeDTO {

    private String id;
    private String name;
    private String[] checkbox; // checkbox1, checkbox2, checkbox3
    private String radio; // radio1 ,radio2
    private String password;
    private String title;
    private String contents;
    private LocalDate regdate; // mysql db에서는 date
    private long viewcount; // mysql db에서는 view

    public FreeDTO(){
        regdate = LocalDate.now();
    }

    public FreeDTO(String id, String name, String title, String contents, long viewcount) {
        this();
        this.id = id;
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.viewcount = viewcount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
