/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.util.ArrayList;

/**
 *
 * @author asher.ansari
 */
public class BookDatabase extends BookDatabaseVariable {

    ArrayList<BookDatabaseVariable> arrayList = new ArrayList<>();

    public BookDatabase(int id, String TitleName, String authorName, int quantity) {
        super(id, TitleName, authorName, quantity);
    }

    public void addNewEntry(BookDatabaseVariable variable) {
        arrayList.add(variable);
    }

    public BookDatabase() {
    }

    public boolean getSearch(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean getSearch(String title, String author) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (title.equals(arrayList.get(i).getTitleName()) && author.equals(arrayList.get(i).getAuthorName())) {
                return true;
            }
        }
        return false;
    }

    public void displayBook() {
        if (arrayList.size() <= 0) {
            System.err.println("Sorry no List Found...");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println("\tId: " + arrayList.get(i).getId() + ", Book Title: " + arrayList.get(i).getTitleName() + ", Author Name: " + arrayList.get(i).getAuthorName() + " & Quantity: " + arrayList.get(i).getQuantity());
            }
        }
        System.out.println("\n");
    }

    public void displayBook(int id) {
        int check = -1;
        if (arrayList.size() <= 0) {
            System.err.println("Sorry no List Found...");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (id == arrayList.get(i).getId()) {
                    System.out.println("\tId: " + arrayList.get(i).getId() + ", Book Title: " + arrayList.get(i).getTitleName() + ", Author Name: " + arrayList.get(i).getAuthorName() + " & Quantity: " + arrayList.get(i).getQuantity());
                    check = 0;
                }
            }
        }
        if (check == -1) {
            System.out.println("Sorry no List Found...!");
        }
        System.out.println("\n");
    }

    public void updateBook(int id, String author) {
        int total = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                arrayList.get(i).setAuthorName(author);
                total += 1;
            }
        }
        if (arrayList.size() <= 0) {
            System.err.println("Sorry List Is Empty...");
        }
        if (total == 0 || total < 0) {
            System.out.println("sorry No book found on this Id: " + id);
        } else {
            System.out.println("Total " + total + "Book title & author Name Updated..");
        }

    }

    public void updateBook(int id, String title, String author) {
        int total = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                arrayList.get(i).setAuthorName(author);
                arrayList.get(i).setTitleName(title);
                total += 1;
            }
        }
        if (arrayList.size() <= 0) {
            System.err.println("Sorry List Is Empty...");
        }
        if (total == 0 || total < 0) {
            System.out.println("sorry No book found on this Id: " + id);
        } else {
            System.out.println("Total " + total + "Book title & author Name Updated..");
        }
    }

    public void deleteBook(int id) {
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                temp = arrayList.get(i).getQuantity();
                arrayList.remove(i);
            }
        }
        if (temp == 0 || temp < 0) {
            System.out.println("Sorry Book Not Found..!!");
        } else {
            System.out.println("Total " + temp + " quantity Book has been Removed From Library Database According to This Book Id: " + id);
        }
    }

    public void updateBook(String title, int id) {
        int total = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                arrayList.get(i).setTitleName(title);
                total += 1;
            }
        }
        if (arrayList.size() <= 0) {
            System.err.println("Sorry List Is Empty...");
        }
        if (total == 0 || total < 0) {
            System.out.println("sorry No book found on this Id: " + id);
        } else {
            System.out.println("Total " + total + "Book title & author Name Updated..");
        }
    }
//
//    public boolean bookIsExists(){
//        
//    }

    public boolean checkIdExists(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public int getIndexNumber(int id) {
//        int j = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                System.out.println("i = " + i);
                return i;
            }
        }
        return -1;
    }

    public BookDatabaseVariable getBookDetailForStudent(int id) {
        BookDatabaseVariable temp = new BookDatabaseVariable();
        temp = null;
        int index = 0;
        index = getIndexNumber(id);
        if (index < 0) {
            System.out.println("Book Not FOund.!!");
        } else {
            temp = arrayList.get(index);
//                arrayList.remove(index);
            if (temp.getQuantity() <= 0) {
                System.out.println("Sorry All Books Has Been Issued..");
            } else {

                arrayList.get(index).issusingBookToStudent();
//                System.out.println("Top: " + arrayList.get(index).getQuantity());
//
//                System.out.println("Top: " + temp.getQuantity());
//                arrayList.add(temp);
//                temp.setQuantityOne();
                temp = getLAtestVarible(temp);
                System.out.println("name = " + temp.getAuthorName() + ", title = " + temp.getTitleName() + ", quantity = " + temp.getQuantity() + " and id = " + temp.getId());
//                System.out.println("down: " + arrayList.get(index).getQuantity());
//                System.out.println("down: " + temp.getQuantity());

                return temp;
            }

        }
        return temp;
    }

    public BookDatabaseVariable getLAtestVarible(BookDatabaseVariable bdv) {
//        bdv.setQuantity(1);
        return new BookDatabaseVariable(bdv.getId(), bdv.getTitleName(), bdv.getAuthorName(), bdv.getOne());
    }
    public void incrementInMainDatabase(int id)
    {
        for(int i=0; i<arrayList.size();i++)
        {
            if(id == arrayList.get(i).getId())
            {
                arrayList.get(i).getBookFromStudent();
            }
        }
    }
}
