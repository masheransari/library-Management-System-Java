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
            System.out.print("Press 1 to Add new Course");
            System.out.println("Press 2 for Display Books");
            System.out.println("Press 3  for remove the book from Library");
            System.out.println("press 4 for Update The Book Detail");
            System.out.println("Press 5 to issue book to Student");
            System.out.println("Press 6 to Show Alloted Book");
            System.out.println("press 7 to retrieve Book From Student");
            int choice;
            choice = s.nextInt();
//            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Please Enter The Book Id");
                    int id = Integer.parseInt(bufferedReader.readLine());
//                    int id = s.nextInt();
                    System.out.println("Please Enter The Book Title");
                    String title = bufferedReader.readLine();
//                    String title = s.nextLine();
                    System.out.println("Please Enter The Author Name: ");
                    String name = bufferedReader.readLine();
//                    String name = s.nextLine();
//                    variabeleClassBook v = new variabeleClassBook(id, name, title);
                    database.createNew(new variabeleClassBook(id, name, title));
                    break;
                case 2:
                    System.out.println("\t\tPress 1 for Display All,\n\t\t2 for Search by Index Number");
//                    choice = Integer.parseInt(bufferedReader.readLine());
                    int ind = s.nextInt();
                    switch (ind) {
                        case 1:
                            database.displayCourse();
                            break;
                        case 2:
                            System.out.println("Please Enter The Book Id");
//                            database.displayCourse(Integer.parseInt(bufferedReader.readLine()));
                            id = s.nextInt();
                            database.displayCourse(id);
                            break;
                        default:
                            System.err.println("Invaild Choice..!!");
                            break;
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
                    switch(choi)
                    {
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
                    String studentID =null;
                    studentID = bufferedReader.readLine();
                    System.out.println("Please Enter The Student Name: ");
                    String studentName = bufferedReader.readLine();
                    System.out.println("please Enter The How Many days Student Take this book: ");
                    int days = Integer.parseInt(bufferedReader.readLine());
                    temp = database.getCourse(bookIdi);
                    student.addInStudentRecord(studentName, days, studentID, temp);
//                    student.showStudentAllotedBooks();
                    break;
                case 6:
//                    System.err.println("The Following Alloted Book are: ");
                        System.out.println("Press 1 to show all Alloted Detail\nPress 2 to show the Specific Student Detail");
                        int showChoice = 0;
                        showChoice = Integer.parseInt(bufferedReader.readLine());
                        switch(showChoice){
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
                    variabeleClassBook tempa = new variabeleClassBook();
                    
                    tempa = student.getRetrieveBook(ida, bookIda);
//                    System.out.println(""+tempa);
                    database.createNew(tempa);
                    
                    break;
                default:
                    System.exit(0);
            }

        }

    }

}
