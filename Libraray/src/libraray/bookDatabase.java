/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray;

import java.util.ArrayList;

/**
 *
 * @author asher.ansari
 */
public class bookDatabase extends variabeleClassBook{

//    private String title;
//    private String author;
//    private int bookId;
    private ArrayList<variabeleClassBook> arrayList = new ArrayList<>();

//    public bookDatabase(String title, String author, int bookId) {
//        this.title = title;
//        this.author = author;
//        this.bookId = bookId;
//    }
    public bookDatabase() {
    }

    public int searchIndex(ArrayList<variabeleClassBook> al, int bookId) {
        for (int i = 0; i < al.size(); i++) {
//            Object object = arr[i];
            if (bookId == al.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void updateCourse(String title, int id) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
            arrayList.get(index).setTitle(title);
        } else {
//            System.err.println("Book Not Found..!!");
            bookError("Book Not Found..!!");
        }
    }

    public void updateCourse(String author, String title, int id) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
            arrayList.get(index).setAuthor(author);
            arrayList.get(index).setTitle(title);
        } else {
            bookError("Book Not Found..!!");
        }
    }

    public void updateCourse(int id, String author) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
            arrayList.get(index).setAuthor(author);
        } else {
//            System.err.println("Book Not Found..!!");
            bookError("Book Not Found..!!");
        }
    }

    public void deleteCourse(int id) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
            arrayList.remove(index);
        } else {
            bookError("Sorry Book Not Found..!!");
        }
    }

    public void createNew(variabeleClassBook v) {
//        variabeleClassBook v = new variabeleClassBook(id,name,title);
        arrayList.add(v);
        System.out.println("Book added in Database");
    }

    public void displayCourse() {

        if (arrayList.size() == 0) {
//            System.err.println("The Book list Is empty");
            bookError("The Book list Is empty");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                System.err.println("\tId: " + arrayList.get(i).getId() + "\tTitle: " + arrayList.get(i).getTitle() + "\tAuthor: " + arrayList.get(i).getAuthor());
            }
            System.err.println("This is the All Courses List...\n\n");
        }
    }

    public void bookError(String detail) {
        System.err.println(detail);
    }

    public void displayCourse(int id) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
//            System.out.println("");
            System.err.println("\tId: " + arrayList.get(index).getId() + "\tTitle: " + arrayList.get(index).getTitle() + "\tAuthor: " + arrayList.get(index).getAuthor());
        } else {
            bookError("Sorry Book Not Found...!!");
        }

    }

    public variabeleClassBook getCourse(int bookId){
        
        for(int i=0;i<arrayList.size();i++)
        {
            if (bookId == arrayList.get(i).getId()) {
                variabeleClassBook temp = new variabeleClassBook();
                temp = arrayList.get(i);
                arrayList.remove(i);
                return temp;
            }
        }
        return null;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public int getBookId() {
//        return bookId;
//    }
    public ArrayList<variabeleClassBook> getArrayList() {
        return arrayList;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setBookId(int bookId) {
//        this.bookId = bookId;
//    }
//    public void setArrayList(ArrayList<bookDatabase> arrayList) {
//        this.arrayList = arrayList;
//    }
}
