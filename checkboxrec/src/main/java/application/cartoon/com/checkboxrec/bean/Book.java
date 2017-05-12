package application.cartoon.com.checkboxrec.bean;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-12.
 */

public class Book {

    private int id;
    private String name;
    private String desc;
private boolean isChose;
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book() {
    }

    public boolean isChose() {
        return isChose;
    }

    public void setChose(boolean chose) {
        isChose = chose;
    }


    public class SelectEvent {
    private int size;

    public SelectEvent(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}}
