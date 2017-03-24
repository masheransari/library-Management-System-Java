/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author asher.ansari
 */
public class Libraray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        bookDatabase database = new bookDatabase();
        Scanner s = new Scanner(System.in);
        studentDetail student = new studentDetail();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("!!..Welcome To The Library Management System..!!");

        while (true) {
            System.out.println("Press 1 to Add new Course");
            System.out.println("Press 2 for Display Books");
            System.out.println("Press 3  for remove the book from Library");
            System.out.println("press 4 for Update The Book Detail");
            System.out.println("Press 5 to issue book to Student");
            System.out.println("Press 6 to Show Alloted Book");
            System.out.println("press 7 to retrieve Book From Student");
            int choice;
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    boolean che = true;
                    int id = 0;
                    String title = null,
                     name = null;
                    System.out.println("Please Enter The Book Id");
                    while (che == true) {
                        id = Integer.parseInt(bufferedReader.readLine());
                        if (!database.getSearch(id)) {
                            che = false;
                        } else {
                            System.err.println("Please Enter Again Id Number: ");
                        }
                    }
                    che = true;
                    do {
                        System.out.println("Please Enter The Book Title");
                        title = bufferedReader.readLine();
                        System.out.println("Please Enter The Author Name: ");
                        name = bufferedReader.readLine();

                        if (true == database.getSearch(title, name)) {
                            System.err.println("Already Found in Database... Please Enter Again..");
                        } else {
                            che = false;
                        }
                    } while (che == true);
                    System.out.println("Please Enter The Book Quantity: ");
                    int quan = Integer.parseInt(bufferedReader.readLine());

                    database.createNew(new variabeleClassBook(id, name, title, quan));

                    break;
                case 2:
                    System.out.println("\t\tPress 1 for Display All,\n\t\t2 for Search by Index Number");
                    int ind = s.nextInt();
                    switch (ind) {
                        case 1:
                            database.displayCourse();
                            break;
                        case 2:
                            System.out.println("Please Enter The Book Id");
                            int ide = s.nextInt();
                            database.displayCourse(ide);
                            break;
                        default:
                            System.err.println("Invaild Choice..!!");
                    }
                    break;
                case 3:
                    System.out.println("Please Enter The Course Id: ");
                    database.deleteCourse(s.nextInt());
                    break;
                case 4:
                    System.err.println("Please Enter what your want to Update??\n\t\tpress1 for Update Book Author Name\n\t\tPress 2 for update Book Title");
                    int choi = s.nextInt();
                    System.out.println("Please Enter The Book ID");
                    int bookId = Integer.parseInt(bufferedReader.readLine());
                    String detail = null;
                    switch (choi) {
                        case 1:
                            System.out.println("Please Enter The New Author Name");
                            detail = bufferedReader.readLine();
                            database.updateCourse(choi, detail);
                            break;
                        case 2:
                            System.out.println("Please Enter The new Book Title");
                            detail = bufferedReader.readLine();
                            break;
                        default:
                            System.err.println("!!..Invalid Selection..!!");
                            break;
                    }
                    break;
                case 5:
                    variabeleClassBook temp = new variabeleClassBook();

                    System.out.println("Please Enter The book Id To be Issuing");
                    int bookIdi = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please Enter The Student Gr Number: ");
                    String studentID = null;
                    studentID = bufferedReader.readLine();
                    System.out.println("Please Enter The Student Name: ");
                    String studentName = bufferedReader.readLine();
                    System.out.println("please Enter The How Many days Student Take this book: ");
                    int quantity = 0;
                    int days = Integer.parseInt(bufferedReader.readLine());
//                    quantity = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("How many book is going to be issuing: ");
                    int tempQuantity = database.getQuantityCount(bookIdi);
                    che = true;
                    do {
                        if (tempQuantity <= 0) {
                            System.out.println("Sorry no book Found in library..!!");
                        } else {
                            System.out.println("Please Enter The Book Quantity: ");
                            quantity = Integer.parseInt(bufferedReader.readLine());
                        }

                        if (quantity <= tempQuantity) {
                            che = false;
                        } else {
                            che = true;
                        }

                    } while (che == true);

//                    if(database.getQuantityCount(bookIdi) >=0)
//                    {
//                        
//                    }
                    temp = database.getCourse(bookIdi, quantity);
                    student.addInStudentRecord(studentName, days, studentID, temp);
                    break;
                case 6:
                    System.out.println("Press 1 to show all Alloted Detail\nPress 2 to show the Specific Student Detail");
                    int showChoice = 0;
                    showChoice = Integer.parseInt(bufferedReader.readLine());
                    switch (showChoice) {
                        case 1:
                            student.showStudentAllotedBooks();
                            break;
                        case 2:
                            System.out.println("Please Enter The Student GR number: ");
                            String gr = null;
                            gr = bufferedReader.readLine();
                            student.showStudentAllotedBooks(gr);
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Please Enter THe Student ID: ");
                    String ida = bufferedReader.readLine();
                    System.out.println("Please Enter The Book Id To be Recieving: ");
                    int bookIda = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("How Many Book is going to returning : ");
                    int returnBook = Integer.parseInt(bufferedReader.readLine());

                    variabeleClassBook tempa = new variabeleClassBook();
                    tempa = student.getRetrieveBook(ida, bookIda);
                    if (tempa != null) {
                        database.addCourseStudent(tempa, returnBook);
                    }
                    break;
                default:
                    System.exit(0);
            }

        }

    }

}
