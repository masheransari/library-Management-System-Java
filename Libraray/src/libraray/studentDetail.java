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
public class studentDetail extends abstractDetail {

    @Override
    String getNamee() {
        return name;
    }

    @Override
    int getDate() {
        return dateDuration;
    }

    @Override
    String getIdForBookIssue() {
        return idForBookIssue;
    }
    private ArrayList<abstractDetail> arrayListStudent = new ArrayList<>();

    public studentDetail() {
    }

    public void addInStudentRecord(String na, int duration, String id, variabeleClassBook book) {
        this.name = na;
        this.dateDuration = duration;
        this.idForBookIssue = id;
        this.mBook = book;
        arrayListStudent.add(new abstractDetail(name, dateDuration, idForBookIssue, mBook) {
            @Override
            String getNamee() {
                return name;
            }

            @Override
            int getDate() {
                return dateDuration;
            }

            @Override
            String getIdForBookIssue() {
                return idForBookIssue;
            }

            @Override
            variabeleClassBook getVarBook() {
                return mBook;
            }
        });
        System.out.println("Book Has Been Issued..!!");
    }

    public void showStudentAllotedBooks() {
        if (arrayListStudent.size() == 0) {
            System.err.println("!!..Sorry No Book has Been Issued...!!");
        } else {
            System.err.println("This is Books is Issues To the Following Students");
            for (int i = 0; i < arrayListStudent.size(); i++) {
                System.out.println("Student ID: " + arrayListStudent.get(i).getIdForBookIssue() + "\tStudent Name: " + arrayListStudent.get(i).getNamee() + "\tBook Aloted Duration: " + arrayListStudent.get(i).getVarBook().getId() + "\tBook ID: " + arrayListStudent.get(i).getVarBook().getId() + "\tBook Title: " + arrayListStudent.get(i).getVarBook().getTitle() + "\tBook Author: " + arrayListStudent.get(i).getVarBook().getAuthor() + "\tQuantity: " + arrayListStudent.get(i).getVarBook().getQuantity());
            }
        }
    }

    public void showStudentAllotedBooks(String studentId) {
        int total = 0;
        for (int i = 0; i < arrayListStudent.size(); i++) {
            if (studentId.equals(arrayListStudent.get(i).getIdForBookIssue())) {
                System.out.println("Student ID: " + arrayListStudent.get(i).getIdForBookIssue() + "\tStudent Name: " + arrayListStudent.get(i).getNamee() + "\tBook Aloted Duration: " + arrayListStudent.get(i).getVarBook().getId() + "\tBook ID: " + arrayListStudent.get(i).getVarBook().getId() + "\tBook Title: " + arrayListStudent.get(i).getVarBook().getTitle() + "\tBook Author: " + arrayListStudent.get(i).getVarBook().getAuthor() + "\tQuantity: " + arrayListStudent.get(i).getVarBook().getQuantity());
                total++;
            }
        }
        if (total != 0) {
            System.err.println("This books has been Issue to This Student..");
        } else {
            System.err.println("Sorry no book issue to this student..!!");
        }
    }

    public variabeleClassBook getRetrieveBook(String studentId, int bookId) {
        int j = -1;
        variabeleClassBook temp = new variabeleClassBook();
        for (int i = 0; i < arrayListStudent.size(); i++) {
            if (studentId.equals(arrayListStudent.get(i).getIdForBookIssue()) && bookId == arrayListStudent.get(i).getVarBook().getId()) {
                temp = arrayListStudent.get(i).getVarBook();
                j = i;
                if (temp.getQuantity() <= 0) {
                    arrayListStudent.remove(j);
                }
            }
        }
        if (j == -1) {
            temp = null;
            System.err.println("No Student Record Found..!!");
        }
        return temp;
    }

    @Override
    variabeleClassBook getVarBook() {
        return mBook;
    }

}
