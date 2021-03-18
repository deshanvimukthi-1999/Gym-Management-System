package GymSystem;


import java.util.Scanner;

public class ConsoleMain {
    private static Scanner sc = new Scanner(System.in);

    private static MyGymManager manager = new MyGymManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Healthy Gym  Management System");
        int option = 0;
        while (option != 7) {
            System.out.println("----------------------------------------------");
            System.out.println("Console");
            System.out.println("Select Option");
            System.out.println("1.Add New Member");
            System.out.println("2.Delete a Member");
            System.out.println("3.View Member List");
            System.out.println("4.Sort Items");
            System.out.println("5.Save Details");
            System.out.println("6.Open Interface");
            System.out.println("7.Exit");
            System.out.println("----------------------------------------------");

            System.out.println("Your Choice :");
            option = inputValidation();

            //Start console
            switch (option) {
                case 1: {
                    System.out.println("Select '1' to add the Default Member or'2' to add the Student Members or '3' to add Over 60 Members");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            addDefaultMember();
                            break;
                        case 2:
                            addStudentMember();
                            break;
                        case 3:
                            addOver60Member();
                    }
                }
                break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    viewList();
                    break;
                case 4:
                    sortMembers();
                    break;
                case 5:
                    saveMembers();
                    break;
                case 6:
                    openInterface();
                    break;
                case 7:
                    System.out.println("Thank You & See you Again!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection, please re-enter the correct value !!");
            }
        }//end of Console
    }

    //GUI
    private static void openInterface() {

    }


    //SortList
    private static void sortMembers() {
        manager.sortMembers();
    }

    //ViewList
    private static void viewList() {

        manager.viewList();
    }

    //Save Member to Database
    private static void saveMembers() {
        System.out.println("----------------------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Members data was Saved to a database  named 'HealthyGymDatabase'!! ");
        System.out.println("-------------------------------------------------------------------");


    }


    //Delete Members
    private static void deleteMember() {
        System.out.print("Enter Membership Number to Delete : ");
        int membershipNumber = sc.nextInt();

        manager.deleteMember(membershipNumber);
    }

    //Add over60 Members
    private static void addOver60Member() {

        System.out.print("Enter Member First Name : ");
        String over60MemberName = sc.next();
        System.out.print("Enter Membership Number : ");
        int over60MemberNumber = sc.nextInt();
        System.out.print("Enter Membership Start Date : ");
        String over60StartDate = sc.next();
        System.out.print("Enter Member Age : ");
        int over60Age = sc.nextInt();

        Over60Member over60 = new Over60Member(over60MemberName, over60MemberNumber, over60StartDate, over60Age);
        manager.addOver60Member(over60);
    }

    //Add Student Members
    private static void addStudentMember() {

        System.out.print("Enter Member First Name : ");
        String studentMemberName = sc.next();
        System.out.print("Enter Membership Number : ");
        int studentMemberNumber = sc.nextInt();
        System.out.print("Enter Membership Start Date : ");
        String studentMemberStartDate = sc.next();
        System.out.print("Enter Member School : ");
        String studentMemberSchool = sc.next();

        StudentMember studentMember = new StudentMember(studentMemberName,studentMemberNumber,studentMemberStartDate,studentMemberSchool);
        manager.addStudentMember(studentMember);

    }

    //Add Default Member
    private static void addDefaultMember() {

        System.out.print("Enter Member First Name : ");
        String defaultMemberName = sc.next();
        System.out.print("Enter Membership Number : ");
        int defaultMemberNumber = sc.nextInt();
        System.out.print("Enter Membership Start Date : ");
        String defaultMemberStartDate = sc.next();

        DefaultMember defaultMember = new DefaultMember(defaultMemberName,defaultMemberNumber,defaultMemberStartDate);
        manager.addDefaultMember(defaultMember);

    }
    //Validate
    private static int inputValidation() {
        while (!sc.hasNextInt()) {
            System.out.println("Re-Enter!!");
            sc.next();
        }
        return sc.nextInt();
    }

}