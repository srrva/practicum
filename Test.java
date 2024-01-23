import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> personList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        collectPersonData(in, stringScanner, personList);

        // Save person data to CSV file
        saveToCSV(personList, "PersonTestData.txt");

        in.close();
        stringScanner.close();
    }

    private static void collectPersonData(Scanner in, Scanner stringScanner, ArrayList<String> personList) {
        boolean input;

        do {
            String ID = SafeInput.getNonZeroLenString(in, "What is your ID?");
            String firstName = SafeInput.getNonZeroLenString(in, "What is your first name?");
            String lastName = SafeInput.getNonZeroLenString(in, "What is your last name?");
            String title = SafeInput.getNonZeroLenString(in, "What is your title?");

            int YOB = SafeInput.getRangedInt(in, "Enter your YOB", 1000, 2024);

           String personInfo = String.format("| %-15s | %-15s | %-10s | %-15s | %-4d |", ID, firstName, lastName, title, YOB);
            personList.add(personInfo);
            System.out.println(personInfo);

            input = SafeInput.getYNConfirm(stringScanner, "Do you have another person to input?");
        }

        while (input);

        if (!input) {
            System.out.println("Information for all persons: ");
            printTableHeader();
            for (String info : personList) {
                System.out.println(info);
            }
            printTableFooter();
        }
    }

    private static void saveToCSV(ArrayList<String> personList, String fileName) {
        try (FileWriter writer = new FileWriter("PersonTestData.txt")) {
            for (String personInfo : personList) {
                writer.write(personInfo + "\n");
            }
            System.out.println("Person data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTableHeader() {
        System.out.println("+-----------------+-----------------+------------+-----------------+------+");
        System.out.printf("| %-15s | %-15s | %-10s | %-15s | %-4s |\n", "First Name", "Last Name", "ID", "Title", "YOB");
        System.out.println("+-----------------+-----------------+------------+-----------------+------+");
    }

    private static void printTableFooter() {
        System.out.println("+-----------------+-----------------+------------+-----------------+------+");
    }
}
