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
public abstract class CommonDetail {
    String name;
    String grId;
    BookDatabaseVariable variable = new BookDatabaseVariable();

    public CommonDetail(){}

    abstract public String getName();

    abstract public String getGrId();

    abstract public BookDatabaseVariable getVariable();

    public CommonDetail( String name, String grId, BookDatabaseVariable variable) {
        this.name = name;
        this.grId = grId;
        this.variable = variable;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrId(String grId) {
        this.grId = grId;
    }

    public void setVariable(BookDatabaseVariable variable) {
        this.variable = variable;
    }
    
    
}
