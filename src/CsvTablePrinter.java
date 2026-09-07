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
        String[] header = csvRows.get(0).split(",");

        // Print table header
        System.out.printf("%-15s %-10s %-15s%n",
                header[0], header[1], header[2]);

        // Print separator line
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();

        int rowsShown = 0;

        // Read data rows
        for (int i = 1; i < csvRows.size(); i++) {

            String row = csvRows.get(i);

            String[] data = row.split(",");

            // Skip invalid rows
            if (data.length != header.length) {
                System.out.println("Skipping malformed row: " + row);
                continue;
            }

            // Print row in formatted columns
            System.out.printf("%-15s %-10s %-15s%n",
                    data[0].trim(),
                    data[1].trim(),
                    data[2].trim());

            rowsShown++;
        }

        // Display total rows
        System.out.println("\nRows Shown: " + rowsShown);
    }
}