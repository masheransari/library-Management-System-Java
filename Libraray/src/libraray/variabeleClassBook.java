/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray;

/**
 *
 * @author asher.ansari
 */
public class variabeleClassBook {
    private int id;
    private String author;
    private String title;

    public variabeleClassBook(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }
    public variabeleClassBook(){}

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
     
    
}
