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
public class bookDatabase extends variabeleClassBook {

    private ArrayList<variabeleClassBook> arrayList = new ArrayList<>();

    public bookDatabase() {
    }

    public boolean getSearch(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                return true;
            }
        }

        return false;
    }

    public boolean getSearch(String titl, String author) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (titl.equals(arrayList.get(i).getTitle()) && author.equals(arrayList.get(i).getAuthor())) {
                return true;
            }
        }
        return false;
    }

    public int getQuantityCount(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                return arrayList.get(i).getQuantity();
            }
        }
        return 0;
    }

    public int searchIndex(ArrayList<variabeleClassBook> al, int bookId) {
        for (int i = 0; i < al.size(); i++) {
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
        arrayList.add(v);
        System.out.println("Book added in Database");
    }

    public void addCourseStudent(variabeleClassBook v, int quantity) {
//        arrayList.add(v);
        int temp=0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (v.getId()==arrayList.get(i).getId()) {
                temp = arrayList.get(i).getQuantity()+ quantity;
                arrayList.get(i).setQuantity(temp);
            }
        }
    }

    public void displayCourse() {

        if (arrayList.size() == 0) {
            bookError("The Book list Is empty");
        } else {
//            System.err.println("This is the All Courses List...\");
//            for (int i = 0; i < arrayList.size(); i++) {
            int ia = 0;
            while (ia < arrayList.size()) {
                System.err.println("\tId: " + arrayList.get(ia).getId() + "\tTitle: " + arrayList.get(ia).getTitle() + "\tAuthor: " + arrayList.get(ia).getAuthor() + "\tQuantity: " + arrayList.get(ia).getQuantity());
                ia++;
            }

        }
    }

    public void bookError(String detail) {
        System.err.println(detail);
    }

    public void displayCourse(int id) {
        int index = searchIndex(arrayList, id);
        if (index != -1) {
//            System.out.println("");
            System.err.println("\tId: " + arrayList.get(index).getId() + "\tTitle: " + arrayList.get(index).getTitle() + "\tAuthor: " + arrayList.get(index).getAuthor() + "\tQuantity: " + arrayList.get(index).getQuantity());
        } else {
            bookError("Sorry Book Not Found...!!");
        }

    }

    public variabeleClassBook getCourse(int bookId, int quantity) {
        int tempQuantity = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (bookId == arrayList.get(i).getId()) {
                variabeleClassBook temp, temp1 = new variabeleClassBook();
                tempQuantity = arrayList.get(i).getQuantity();
                tempQuantity =tempQuantity - quantity;
                temp = arrayList.get(i);//Student
                temp1 = arrayList.get(i);//Main

                temp1.setQuantity(tempQuantity);//Main
                temp.setQuantity(quantity);//Student
                arrayList.remove(i);
                arrayList.add(temp1);
                return temp;
            }
        }
        return null;
    }

    public ArrayList<variabeleClassBook> getArrayList() {
        return arrayList;
    }
}
