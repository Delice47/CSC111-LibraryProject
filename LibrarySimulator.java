package librarysimulation;

//Student name: Abdulrhman Alshurihi - 446102314

import java.util.Scanner;

public class LibrarySimulator {

 public static void main(String[] args) {
     // Create members
     Member member1 = new Member(1, "Ahmad", 0);
     Member member2 = new Member(2, "Khalid", 0);
     Member member3 = new Member(3, "Abdulrhman", 0);

     Scanner keyboard = new Scanner(System.in);
     boolean programRunning = true;

     while (programRunning) {
         // Main menu
         System.out.println("\n--- Welcome to the Library Simulation System ---");
         System.out.println("1. Login as " + member1.getName() + " (ID: " + member1.getId() + ")");
         System.out.println("2. Login as " + member2.getName() + " (ID: " + member2.getId() + ")");
         System.out.println("3. Login as " + member3.getName() + " (ID: " + member3.getId() + ")");
         System.out.println("4. Login as Administrator");
         System.out.println("5. Exit");
         System.out.print("Please select an option (1-5): ");

         int menuChoice = keyboard.nextInt();

         switch (menuChoice) {
             case 1: // User 1
                 System.out.println("\nWelcome, " + member1.getName() + "!");
                 member1.reset(); 
                 runUserSession(member1, keyboard);
                 break;

             case 2: // User 2
                 System.out.println("\nWelcome, " + member2.getName() + "!");
                 member2.reset();
                 runUserSession(member2, keyboard);
                 break;

             case 3: // User 3
                 System.out.println("\nWelcome, " + member3.getName() + "!");
                 member3.reset();
                 runUserSession(member3, keyboard);
                 break;

             case 4: // Admin
                 System.out.println("\nWelcome, Administrator!");
                 boolean adminActive = true;
                 while (adminActive) {
                     System.out.println("\n--- Administrator Menu ---");
                     System.out.println("1. View Total Revenue");
                     System.out.println("2. View Most Frequent Operation");
                     System.out.println("3. Exit to Main Menu");
                     System.out.print("Please select an option (1-3): ");

                     int adminChoice = keyboard.nextInt();

                     switch (adminChoice) {
                         case 1:
                             System.out.printf("Total Revenue Collected: $%.2f%n", Member.TotalRevenue);
                             break;
                         case 2:
                             System.out.println("--- Library-Wide Statistics ---");
                             System.out.println("Total Borrows: " + Member.TotalBorrows);
                             System.out.println("Total Returns: " + Member.TotalReturns);
                             
                             if (Member.TotalBorrows > Member.TotalReturns) {
                                 System.out.println("Most Frequent: Borrow");
                             } else if (Member.TotalReturns > Member.TotalBorrows) {
                                 System.out.println("Most Frequent: Return");
                             } else {
                                 System.out.println("Most Frequent: Borrow and Return (Tied)");
                             }
                             break;
                         case 3:
                             adminActive = false;
                             System.out.println("Logging out, Administrator...");
                             break;
                         default:
                             System.out.println("Invalid choice.");
                     }
                 }
                 break;

             case 5: // Exit
                 programRunning = false;
                 System.out.println("Goodbye!");
                 break;

             default:
                 System.out.println("Invalid choice.");
         }
     }
 }

 // Helper method for user session
 public static void runUserSession(Member currentMember, Scanner scanner) {
     boolean sessionActive = true;
     while (sessionActive) {
         System.out.println("\n--- " + currentMember.getName() + "'s Account ---");
         System.out.println("1. View Borrowed Books Count");
         System.out.println("2. Borrow Book (Fee: $0.50)");
         System.out.println("3. Return Book");
         System.out.println("4. View Session Summary");
         System.out.println("5. Exit to Main Menu");
         System.out.print("Please select an option (1-5): ");

         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 currentMember.viewBorrowedCount();
                 break;
             case 2:
                 currentMember.borrowOne();
                 break;
             case 3:
                 currentMember.returnOne();
                 break;
             case 4:
                 currentMember.displayStatistics();
                 break;
             case 5:
                 sessionActive = false;
                 System.out.println("Logging out...");
                 break;
             default:
                 System.out.println("Invalid choice.");
         }
     }
 }
}