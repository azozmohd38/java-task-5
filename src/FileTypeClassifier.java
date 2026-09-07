import java.util.ArrayList;
import java.util.List;

public class FileTypeClassifier {

    public static void main(String[] args) {

        List<String> fileNames = new ArrayList<>();

        fileNames.add("report.pdf");
        fileNames.add("photo.jpg");
        fileNames.add("program.java");
        fileNames.add("notes.txt");
        fileNames.add("script.py");
        fileNames.add("logo.png");
        fileNames.add("website.js");
        fileNames.add("archive.zip");
        fileNames.add("README"); // No extension

        int documentCount = 0;
        int imageCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        // Process each file
        for (String fileName : fileNames) {

            String extension = "";
            String fileType;

            int dotIndex = fileName.lastIndexOf('.');

            // Check if the file has an extension
            if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
                fileType = "Other";
            } else {

                extension = fileName.substring(dotIndex + 1).toLowerCase();

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
            System.out.println(fileName + " -> " + fileType);
        }

        // Display summary
        System.out.println("\n========== Summary ==========");
        System.out.println("Total Files : " + fileNames.size());
        System.out.println("Documents   : " + documentCount);
        System.out.println("Images      : " + imageCount);
        System.out.println("Code Files  : " + codeCount);
        System.out.println("Other Files : " + otherCount);
    }
}