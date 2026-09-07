import java.util.Scanner;

public class FileNameAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Read file name from user
        System.out.print("Enter a file name: ");
        String fileName = input.nextLine().trim();

        int dotIndex = fileName.lastIndexOf('.');

        // Validate file name
        if (fileName.isEmpty() ||
                fileName.length() < 3 ||
                dotIndex == -1 ||
                dotIndex == 0 ||
                dotIndex == fileName.length() - 1) {

            System.out.println("Invalid file name.");
            input.close();
            return;
        }

        // Extract base name and extension
        String baseName = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex + 1).toLowerCase();

        // Classify the file
        String classification;

        switch (extension) {
            case "txt":
            case "pdf":
            case "docx":
                classification = "Document";
                break;

            case "jpg":
            case "png":
            case "gif":
                classification = "Image";
                break;

            case "mp3":
            case "wav":
                classification = "Audio";
                break;

            default:
                classification = "Other";
        }

        // Display results
        System.out.println("\nFile Name      : " + fileName);
        System.out.println("Base Name      : " + baseName);
        System.out.println("Extension      : " + extension);
        System.out.println("Classification : " + classification);

        input.close();
    }
}
