package librarysimulation;

//Abdulrhman Alshurihi - 446102314
//GitHub Repository: https://github.com/Delice47/CSC111-LibraryProject

public class Member {

 // Attributes
 private int id;
 private String name;
 private int borrowedCount;

 // Session stats
 private int numViewBorrowed;
 private int numBorrows;
 private int numReturns;
 private double sessionFees;

 // Global stats
 public static double TotalRevenue = 0.0;
 public static int TotalViewBorrowed = 0;
 public static int TotalBorrows = 0;
 public static int TotalReturns = 0;

 // Constructor
 public Member(int id, String name, int borrowedCount) {
     this.id = id;
     this.name = name;
     this.borrowedCount = borrowedCount;
 }

 // Check borrow limit
 private boolean canBorrow() {
     return borrowedCount < 5;
 }

 // Check return limit
 private boolean canReturn() {
     return borrowedCount > 0;
 }

 // View borrowed count
 public void viewBorrowedCount() {
     System.out.println(name + " has " + borrowedCount + " books borrowed.");
     numViewBorrowed++;
     TotalViewBorrowed++;
 }

 // Borrow book
 public boolean borrowOne() {
     if (canBorrow()) {
         borrowedCount++;
         numBorrows++;
         sessionFees += 0.50;
         
         TotalBorrows++;
         TotalRevenue += 0.50;
         
         System.out.println("Book borrowed. You now have " + borrowedCount + " books.");
         return true;
     } else {
         System.out.println("Error: You cannot borrow more than 5 books.");
         return false;
     }
 }

 // Return book
 public boolean returnOne() {
     if (canReturn()) {
         borrowedCount--;
         numReturns++;
         
         TotalReturns++;
         
         System.out.println("Book returned. You now have " + borrowedCount + " books.");
         return true;
     } else {
         System.out.println("Error: You have no books to return.");
         return false;
     }
 }

 // Display stats
 public void displayStatistics() {
     System.out.println("\n--- Session Summary for " + name + " ---");
     System.out.println("Times Book Count Viewed: " + numViewBorrowed);
     System.out.println("Books Borrowed this session: " + numBorrows);
     System.out.println("Books Returned this session: " + numReturns);
     System.out.printf("Total Fees this session: $%.2f%n", sessionFees);
 }

 // Reset stats
 public void reset() {
     numViewBorrowed = 0;
     numBorrows = 0;
     numReturns = 0;
     sessionFees = 0.0;
 }

 // Getters
 public int getId() { return id; }
 public String getName() { return name; }
}
