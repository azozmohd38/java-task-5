import java.util.Scanner;

public class FilePathSplitter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Read the full file path
        System.out.print("Enter a file path: ");
        String originalPath = input.nextLine().trim();

        // Check if the path is blank
        if (originalPath.isEmpty()) {
            System.out.println("Invalid path.");
            input.close();
            return;
        }

        // Check if the original path contains backslashes
        boolean isWindowsPath = originalPath.contains("\\");

        // Replace backslashes with forward slashes
        String normalizedPath = originalPath.replace('\\', '/');

        // Find the last slash
        int lastSlash = normalizedPath.lastIndexOf('/');

        String folder;
        String fileName;

        if (lastSlash == -1) {
            folder = "None";
            fileName = normalizedPath;
        } else {
            folder = normalizedPath.substring(0, lastSlash);
            fileName = normalizedPath.substring(lastSlash + 1);
        }

        // Get the file extension
        String extension;
        int lastDot = fileName.lastIndexOf('.');

        if (lastDot == -1 || lastDot == fileName.length() - 1) {
            extension = "none";
        } else {
            extension = fileName.substring(lastDot + 1).toLowerCase();
        }

        // Determine the path style
        String pathStyle;
        if (isWindowsPath) {
            pathStyle = "Windows Path";
        } else {
            pathStyle = "Unix Path";
        }

        // Display the results
        System.out.println("\nPath       : " + originalPath);
        System.out.println("Folder     : " + folder);
        System.out.println("File Name  : " + fileName);
        System.out.println("Extension  : " + extension);
        System.out.println("Path Style : " + pathStyle);

        // Close the Scanner
        input.close();
    }
}