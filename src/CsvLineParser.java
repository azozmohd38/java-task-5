import java.util.Scanner;

public class CsvLineParser {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Read CSV record
        System.out.print("Enter record (Name, Age, City): ");
        String record = input.nextLine().trim();

        if (record.isEmpty()) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }

        // Split the record by commas
        String[] fields = record.split(",", -1);

        // Validate the number of fields
        if (fields.length != 3) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }

        // Trim each field
        String name = fields[0].trim();
        boolean nameValid = !name.isEmpty();
        String ageText = fields[1].trim();
        String city = fields[2].trim();
        boolean cityValid = !city.isEmpty();

        if (!nameValid || !cityValid || ageText.isEmpty()) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }

        // Convert age to integer
        int age;

        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }

        if (age < 0) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }

        // Classify the age
        String ageGroup;

        if (age <= 17) {
            ageGroup = "Minor";
        } else if (age >= 18 && age <= 64) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Senior";
        }

        // Display the results
        System.out.println("\n===== CSV Record =====");
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("City      : " + city);
        System.out.println("Age Group : " + ageGroup);

        // Close Scanner
        input.close();
    }
}
