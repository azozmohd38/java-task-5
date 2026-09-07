import java.util.ArrayList;
import java.util.List;

public class FileTypeClassifier {

    public static void main(String[] args) {

        List<String> fileNames = new ArrayList<>(List.of(
                "report.pdf",
                "photo.jpg",
                "program.java",
                "notes.txt",
                "script.py",
                "logo.png",
                "website.js",
                "archive.zip",
                "animation.gif",
                "README"
        ));

        int documentCount = 0;
        int imageCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        // Process each file
        for (String originalName : fileNames) {

            String fileName = originalName.trim();
            String extension = "";
            String fileType;

            int dotIndex = fileName.lastIndexOf('.');

            // Check if the file has an extension
            if (dotIndex <= 0 || dotIndex == fileName.length() - 1) {
                fileType = "Other";
            } else {

                extension = fileName.substring(dotIndex + 1).trim().toLowerCase();

                switch (extension) {

                    case "txt":
                    case "pdf":
                    case "docx":
                        fileType = "Document";
                        break;

                    case "jpg":
                    case "png":
                        fileType = "Image";
                        break;

                    case "java":
                    case "py":
                    case "js":
                        fileType = "Code";
                        break;

                    default:
                        fileType = "Other";
                }
            }

            // Update counters
            switch (fileType) {

                case "Document":
                    documentCount++;
                    break;

                case "Image":
                    imageCount++;
                    break;

                case "Code":
                    codeCount++;
                    break;

                default:
                    otherCount++;
            }

            // Display file classification
            System.out.println(fileName + " -> " + fileType
                    + (extension.isEmpty() ? "" : " (" + extension + ")"));
        }

        // Display summary
        System.out.println("\n========== File Type Summary ==========");
        int totalFiles = fileNames.size();
        System.out.println("Total Files : " + totalFiles);
        System.out.println("Documents   : " + documentCount);
        System.out.println("Images      : " + imageCount);
        System.out.println("Code Files  : " + codeCount);
        System.out.println("Other Files : " + otherCount);
    }
}