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
        boolean hasBackslash = originalPath.contains("\\");

        // Replace backslashes with forward slashes
        String normalizedPath = originalPath.replace('\\', '/').trim();

        // Find the last slash
        int lastSlash = normalizedPath.lastIndexOf('/');

        String folder;
        String fileName;

        if (lastSlash == -1) {
            folder = "None";
            fileName = normalizedPath.trim();
        } else {
            folder = normalizedPath.substring(0, lastSlash);
            fileName = normalizedPath.substring(lastSlash + 1).trim();
        }

        if (fileName.isEmpty()) {
            System.out.println("Invalid path.");
            input.close();
            return;
        }

        // Get the file extension
        String extension;
        int lastDot = fileName.lastIndexOf('.');
        boolean hasExtension = lastDot > 0 && lastDot < fileName.length() - 1;

        if (!hasExtension) {
            extension = "none";
        } else {
            extension = fileName.substring(lastDot + 1).toLowerCase();
        }

        // Determine the path style
        String pathStyle;
        if (hasBackslash) {
            pathStyle = "Windows Path";
        } else {
            pathStyle = "Unix Path";
        }

        // Display the results
        System.out.println("\n===== Path Details =====");
        System.out.println("Path       : " + originalPath);
        System.out.println("Folder     : " + folder);
        System.out.println("File Name  : " + fileName);
        System.out.println("Extension  : " + extension);
        System.out.println("Path Style : " + pathStyle);

        input.close();
    }
}