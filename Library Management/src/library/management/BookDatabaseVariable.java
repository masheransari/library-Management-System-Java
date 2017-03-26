/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

/**
 *
 * @author asher.ansari
 */
public class BookDatabaseVariable {

    int id;
    String TitleName;
    String authorName;
    int quantity;

    public BookDatabaseVariable(int id, String TitleName, String authorName, int quantity) {
        this.id = id;
        this.TitleName = TitleName;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    public BookDatabaseVariable() {
    }

    public int getId() {
        return id;
    }

    public String getTitleName() {
        return TitleName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitleName(String TitleName) {
        this.TitleName = TitleName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBookFromStudent() {
        this.quantity = this.quantity + 1;
        return this.quantity;
    }

    public int issusingBookToStudent() {
        this.quantity = this.quantity - 1;
        return this.quantity;
    }

    public void setQuantityOne() {
        this.quantity = 1;
    }
    public int getOne(){
        return 1;
    }
}
