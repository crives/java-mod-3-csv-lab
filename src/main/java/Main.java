import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean repeat = true;
    public static boolean firstTime = true;
    public static Scanner sc = new Scanner(System.in);
    public static FileIORunner fileRunner = new FileIORunner();
    public static String askFirstName = "What is the person's first name?";
    public static String askLastName = "What is the person's last name?";


    public static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        welcome(true);
    }
    public static void welcome(boolean firstTime) {
        while (repeat) {
            try {
                printWelcomeMsg(firstTime);
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        fileRunner.readFromFile("person.csv");
                        firstTime = false;
                        break;
                    case 2:
                        addPerson();
//                        printWelcomeMsg(false);
                        repeat = true;
                        sc.nextLine();
                        break;
                    case 3:
                        printList();
                        break;
                    case 4:
                        Logger.getInstance().log("Goodbye!");
                        saveFile();
                        repeat = false;
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                sc.nextLine();
//                Logger.getInstance().log(error);
            }
        }
    }

    public static void printWelcomeMsg(boolean firstTime) {
        if (firstTime) {
            Logger.getInstance().log("Hello! \nWe will be adding to a list of people we will maintain in our program \nand save to a file when the program exits!");
        } else {
            Logger.getInstance().log("Please select from the menu below and enter the corresponding number value to your choice. \n");
            Logger.getInstance().log("Would you like to: \n1. Retrieve a list of people from a file \n2. Create a new list of people \n3. Print list of current persons \n4. Exit");
        }
    }

    public static void addPerson() {
        //Ask the user for the person's information.
        Person person = new Person();
        Logger.getInstance().log(askFirstName);
        try {
            String firstName = sc.nextLine();
            person.setFirstName(firstName);
            Logger.getInstance().log(askLastName);
            String lastName = sc.nextLine();
            person.setLastName(lastName);
        } catch (Exception e) {
            sc.nextLine();
//            log(error);
        }
        //Add the new person to your person's list.
        personList.add(person);
        sc.nextLine();
        welcome(false);
    }

    public static void printList() {
        //Print the person information for each person on your current list.
        personList.forEach((person) -> System.out.println(person));
        //Return the user to the 3 options from before.
        welcome(false);
    }

    public static void saveFile() throws IOException {
        fileRunner.writeCsv("person.csv", personList);
    }
}
