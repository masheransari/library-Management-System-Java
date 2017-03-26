
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author asher.ansari
 */
public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.err.println("...Welcome To THe Libraray Management System in Java...");
        int choice = 0;

        BookDatabase database = new BookDatabase();
        StudentDetail detail = new StudentDetail();
//        database.addNewEntry(database);

        boolean tempCheckWhile = true;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1. To Add Item in Library Database..!!");
            System.out.println("2. Display The Total Item Availabale in Library..!!");
            System.out.println("3. Update The Course Detail..!!");
            System.out.println("4. Delete Course From List");
            System.out.println("5. Issue The Book To Student");
            System.out.println("6. Returning Book From Student");
            System.out.println("7. Display Aloted Book of Student");

            choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    tempCheckWhile = true;
                    String author = null,
                     title = null;
                    int id = 0;
                    while (tempCheckWhile == true) {
                        System.out.println("Please Enter The New Item Id:");
                        id = Integer.parseInt(bufferedReader.readLine());
//                            id = s.nextInt();
                        if (!database.getSearch(id)) {
                            tempCheckWhile = false;
                        }
                    }
                    tempCheckWhile = true;
                    while (tempCheckWhile == true) {
                        System.out.println("Please Enter The Book Title Name: ");
                        title = bufferedReader.readLine();
                        System.out.println("Please Enter the Book Author Name: ");
                        author = bufferedReader.readLine();
                        if (!database.getSearch(title, author)) {
                            tempCheckWhile = false;
                        }
                    }
                    System.out.println("Please Enter The Book Quantity: ");
                    int quantity = Integer.parseInt(bufferedReader.readLine());
                    database.addNewEntry(new BookDatabaseVariable(id, title, author, quantity));
                    System.out.println("DEtail Added in Database");
                    break;
                case 2:
                    tempCheckWhile = true;
                    int displayBookId = 0;
                    System.out.println("How Would your DIsplay");
                    System.out.println("1. All");
                    System.out.println("2. Display Indivuals");
                    displayBookId = Integer.parseInt(bufferedReader.readLine());
                    switch (displayBookId) {
                        case 1:
                            database.displayBook();
                            break;
                        case 2:
                            System.out.println("Please Enter The Book Id if Exists: ");
                            displayBookId = 0;
                            tempCheckWhile = true;
                            do {
                                displayBookId = Integer.parseInt(bufferedReader.readLine());
                                if (database.checkIdExists(displayBookId)) {
                                    database.displayBook(displayBookId);
                                    tempCheckWhile = false;
                                } else {
                                    System.err.println("Book Not Found..!!");
                                    System.out.println("Do You Want to Search Again? press y or Y To Continue");
                                    String temp = bufferedReader.readLine();
                                    if (temp.equals("y") || temp.equals("Y")) {
                                        System.out.println("Please Enter Again The Id: ");
                                    } else {
                                        tempCheckWhile = false;
                                    }
                                }
                            } while (tempCheckWhile == true);
                            break;
                        default:
                            System.err.println("Invalid Selection");
                            break;
                    }
                    break;
                case 3:

                    System.out.println("Please Enter The Book Id: ");
                    int bookId = Integer.parseInt(bufferedReader.readLine());

                    if (database.checkIdExists(bookId)) {
                        System.out.println("Please Enter What You Want to Update??");
                        System.out.println("1. To Update Author Name");
                        System.out.println("2. To Update Title Name");
                        System.out.println("3. Update Author and  TItle of Book");
                        int updateChoice = 0;
                        updateChoice = Integer.parseInt(bufferedReader.readLine());
                        switch (updateChoice) {
                            case 1:
                                System.out.println("Please Enter The Author Name: ");
                                database.updateBook(bookId, bufferedReader.readLine());
                                break;
                            case 2:
                                System.out.println("Please Enter The Title Name: ");
                                database.updateBook(bufferedReader.readLine(), bookId);
                                break;
                            case 3:
                                System.out.println("Please Enter The Author Name: ");
                                String authorName = bufferedReader.readLine();
                                System.out.println("Please Enter The Title Name: ");
                                database.updateBook(bookId, bufferedReader.readLine(), authorName);

                                break;
                            default:
                                System.err.println("Invalid Selection..!!");
                                break;
                        }
                    } else {
                        System.err.println("Sorry!! Book Not Exists in Database...");
                    }
                    break;
                case 4:
                    System.out.println("Welcome To The Delete Menu..");
                    System.out.println("Please Enter The Course Id");
                    int deleteId = Integer.parseInt(bufferedReader.readLine());
                    if (database.checkIdExists(deleteId)) {
                        database.deleteBook(deleteId);
                    } else {
                        System.out.println("Sorry Book Id Did not Exists..!!");
                    }
                    break;
                case 5:
                    System.out.println("Please Enter The Book Id, Which is Going To be Issuing: ");
                    int bookIssueId = Integer.parseInt(bufferedReader.readLine());
                    if (database.checkIdExists(bookIssueId)) {
                        System.out.println("Please Enter The Student Name: ");
                        String name = bufferedReader.readLine();
                        System.out.println("Please Enter The Student Gr NUmber: ");
                        String gr = bufferedReader.readLine();
                        BookDatabaseVariable variable1 = new BookDatabaseVariable();
                        variable1 = database.getBookDetailForStudent(bookIssueId);

                        if (variable1 != null) {
                            detail.issueBookToStudent(name, gr, variable1);
                            System.out.println("Book Has Been Issued..!!");
                        }
                    } else {
                        System.out.println("Sorry Book Not Exists..");
                    }
                    break;
                case 6:
                    System.out.println("Welcome to Return Book Menu..");
                    System.out.println("Please Enter The Student Gr Number: ");
                    String grReturn = bufferedReader.readLine();
                    int countBooks = detail.getIssuedBookCount(grReturn);
                    if(countBooks !=0)
                    {
                        System.out.println("This Book Has Been ISsued To THis Gr Number: ");
                        detail.displayDetail(grReturn);
                        System.out.println("Please Enter The Book ID: ");
                        int idBook = Integer.parseInt(bufferedReader.readLine());
                        if(detail.isBookExists(idBook)){
                            detail.returnBookFromStudent(idBook, grReturn);
                            database.incrementInMainDatabase(idBook);
                            System.out.println("Book Has Been Returning Sucessfully..!!");
                        }
                        else{
                            System.out.println("Sorry!! Book Id did not FInd in Database...");
                        }
                    }
                    else{
                        System.out.println("Sorry Now Book Issue To This Student..!!");
                    }
                    break;
                case 7:
                    System.out.println("Welcome To Display Aloted Book Menu");
                    System.out.println("1. To Display All Student Books");
                    System.out.println("2. To Display Specific Student Books Detail");
                    int choiceDisplayStudent = Integer.parseInt(bufferedReader.readLine());
                    switch(choiceDisplayStudent)
                    {
                        case 1:
                            detail.displayDetail();
                            break;
                        case 2:
                            System.out.println("Please Enter The GR Number: ");
                            String grDispalyBook = bufferedReader.readLine();
                            detail.displayDetail(grDispalyBook);
                            break;
                        default:
                            System.out.println("Invalid Selection...!!");
                            break;
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

}
