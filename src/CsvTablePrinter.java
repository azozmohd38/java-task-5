import java.util.ArrayList;
import java.util.List;

public class CsvTablePrinter {

    public static void main(String[] args) {

        List<String> csvRows = new ArrayList<>();

        csvRows.add("Name,Age,City");
        csvRows.add("Ali,25,Muscat");
        csvRows.add("Sara,30,Nizwa");
        csvRows.add("Ahmed,22,Sohar");
        csvRows.add("Fatima,28,Salalah");
        csvRows.add("Omar,35");

        // Get header columns
        String[] header = csvRows.get(0).split(",", -1);

        String firstHeader = header[0].trim();
        String secondHeader = header[1].trim();
        String thirdHeader = header[2].trim();

        // Print table header
        System.out.printf("%-15s %-10s %-15s%n",
                firstHeader, secondHeader, thirdHeader);

        // Print separator line
        System.out.println("-".repeat(40));

        int rowsShown = 0;

        // Read data rows
        for (int i = 1; i < csvRows.size(); i++) {

            String row = csvRows.get(i);

            String[] data = row.split(",", -1);

            // Skip invalid rows
            if (data.length != header.length) {
                System.out.println("Skipping malformed row: " + row);
                continue;
            }

            String name = data[0].trim();
            String age = data[1].trim();
            String city = data[2].trim();

            if (name.isEmpty() || age.isEmpty() || city.isEmpty()) {
                System.out.println("Skipping malformed row: " + row);
                continue;
            }

            System.out.printf("%-15s %-10s %-15s%n", name, age, city);
            rowsShown++;
        }

        // Display total rows
        System.out.println("\nRows Shown: " + rowsShown);
    }
}