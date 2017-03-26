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
public class StudentDetail extends CommonDetail {

    public StudentDetail() {
    }
    ArrayList<CommonDetail> arrayList1 = new ArrayList<>();

    public StudentDetail(String name, String gr, BookDatabaseVariable variable) {
        this.name = name;
        this.grId = gr;
        this.variable = variable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGrId() {
        return grId;
    }

    @Override
    public BookDatabaseVariable getVariable() {
        return variable;
    }

    public void issueBookToStudent(String name1, String gr, BookDatabaseVariable variable1) {

//        variable1.setQuantity(1);
        System.out.println("another: " + variable1.getQuantity());
//        variable1.setQuantityOne();
//        variable1.setQuantity(1);
        arrayList1.add(new CommonDetail(name1, gr, variable1) {

            @Override
            public String getName() {
                return name1;
            }

            @Override
            public String getGrId() {
                return gr;
            }

            @Override
            public BookDatabaseVariable getVariable() {
                return variable1;
            }
        });
//        for(int i=0; i<arrayList.size();i++)
//        {
        System.out.println("Quantity: " + variable1.getQuantity());
//        }

//        arrayList.add();
    }

    public int getIssuedBookCount(String StudentId) {
        int count = 0;
        for (int i = 0; i < arrayList1.size(); i++) {
            if (StudentId.equals(arrayList1.get(i).getGrId())) {
                count++;
            }
        }
        return count;
    }

    public void displayDetail(String gr) {
        if (getIssuedBookCount(gr) <= 0) {
            System.out.println("No Book Has Been Issue..");
        } else {
            for (int i = 0; i < arrayList1.size(); i++) {
                if (gr.equals(arrayList1.get(i).getGrId())) {
                    System.out.println("Name: " + arrayList1.get(i).getName() + " , Book ID: " + arrayList1.get(i).getVariable().getId() + " , Book Name: " + arrayList1.get(i).getVariable().getTitleName());
                }
            }
        }
    }

    public void displayDetail() {
     int count = 0;
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println("Name: " + arrayList1.get(i).getName() + " , Book ID: " + arrayList1.get(i).getVariable().getId() + " , Book Name: " + arrayList1.get(i).getVariable().getTitleName());
            count++;
        }
        if(count ==0)
        {
            System.out.println("No Book Issue Detail Found..!!");
        }
    }

    public boolean isBookExists(int bookId) {

        for (int i = 0; i < arrayList1.size(); i++) {
            if (bookId == arrayList1.get(i).getVariable().getId()) {
                return true;
            }
        }
        return false;
    }

    public void returnBookFromStudent(int bookId, String gr) {
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).getGrId().equals(gr) && arrayList1.get(i).getVariable().getId() == bookId) {
                arrayList1.remove(i);
            }
        }
    }
//    public void 
}
