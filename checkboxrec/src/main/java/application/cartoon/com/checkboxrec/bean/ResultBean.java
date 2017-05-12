package application.cartoon.com.checkboxrec.bean;

import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-13.
 */

public class ResultBean {
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

  private   List<Book> bookList;
}
