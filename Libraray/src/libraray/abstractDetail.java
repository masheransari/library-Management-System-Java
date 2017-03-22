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
public abstract class abstractDetail extends variabeleClassBook{
    String name;
    int dateDuration;
    String idForBookIssue;
    variabeleClassBook mBook;
    
    public abstractDetail(){}
    public abstractDetail(String name,int dur, String id, variabeleClassBook mBook){
        this.name = name;
        this.dateDuration= dur;
        this.idForBookIssue = id;
        this.mBook = mBook;
    }
    abstract String getNamee();
    abstract int getDate();
    abstract String getIdForBookIssue();
    abstract variabeleClassBook getVarBook();


//    public String getName() {
//        return name;
//    }
//
//    public int getDateDuration() {
//        return dateDuration;
//    }
//
//    public String getIdForBookIssue() {
//        return idForBookIssue;
//    }

    public void setmBook(variabeleClassBook mBook) {
        this.mBook = mBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateDuration(int dateDuration) {
        this.dateDuration = dateDuration;
    }

    public void setIdForBookIssue(String idForBookIssue) {
        this.idForBookIssue = idForBookIssue;
    }
    
    
    
    
}
