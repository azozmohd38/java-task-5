public class FileInventoryReport {
    public static void main(String[] args) {

        // Store CSV file records
        String[] records = {"photo.png,340", "app.java,8", "song.mp3,5200", "report.pdf,150",
                "notes.txt,25", "script.py,30", "badrecord", "video.mp4,900", "image.jpg,-50"};

        // Summary variables
        int totalFiles = 0;
        int totalSize = 0;
        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        String largestFile = "";
        int largestSize = -1;

        // Process each record
        for (String record : records) {

            // Split the CSV record
            String[] parts = record.split(",");

            // Check that the record has exactly two fields
            if (parts.length != 2) {
                System.out.println("Invalid record skipped: " + record);
                continue;
            }

            // Read and trim values
            String fileName = parts[0].trim();
            String sizeText = parts[1].trim();

            int fileSize;

            // Convert size to integer
            try {
                fileSize = Integer.parseInt(sizeText);
            } catch (NumberFormatException e) {
                System.out.println("Invalid size skipped: " + record);
                continue;
            }

            // Reject negative file sizes
            if (fileSize < 0) {
                System.out.println("Negative file size skipped: " + record);
                continue;
            }

            // Get file extension
            String extension = "";
            int dotIndex = fileName.lastIndexOf('.');

            if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
                extension = fileName.substring(dotIndex + 1).toLowerCase();
            }

            // Classify the file
            String type;

            switch (extension) {
                case "txt":
                case "pdf":
                case "docx":
                case "xlsx":
                    type = "Document";
                    documentCount++;
                    break;

                case "jpg":
                case "png":
                case "gif":
                    type = "Image";
                    imageCount++;
                    break;

                case "mp3":
                case "wav":
                    type = "Audio";
                    audioCount++;
                    break;

                case "java":
                case "py":
                case "js":
                    type = "Code";
                    codeCount++;
                    break;

                default:
                    type = "Other";
                    otherCount++;
            }

            // Update totals
            totalFiles++;
            totalSize += fileSize;

            // Update largest file
            if (fileSize > largestSize) {
                largestSize = fileSize;
                largestFile = fileName;
            }

            // Display file information
            System.out.println("File Name : " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Type     : " + type);
            System.out.println("Size (KB): " + fileSize);
            System.out.println("----------------------------");
        }

        // Print summary
        System.out.println("\n===== Inventory Summary =====");
        System.out.println("Total Files      : " + totalFiles);
        System.out.println("Total Size (KB)  : " + totalSize);
        System.out.println("Documents        : " + documentCount);
        System.out.println("Images           : " + imageCount);
        System.out.println("Audio            : " + audioCount);
        System.out.println("Code             : " + codeCount);
        System.out.println("Other            : " + otherCount);

        if (largestSize >= 0) {
            System.out.println("Largest File     : " + largestFile + " (" + largestSize + " KB)");
        } else {
            System.out.println("Largest File     : None");
        }
    }
}