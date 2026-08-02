public class FileInventoryReport {
    public static void main(String[] args) {

        // Store CSV file records
        String[] fileRecords = {"photo.png,340", "report.pdf,120", "music.mp3,500", "program.java,80",
                "notes.txt,50", "image.gif,200", "data.xyz,30", "wrongRecord"};

        // Counters and totals
        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        int totalSize = 0;
        int totalFiles = 0;

        String largestFile = "";
        int largestSize = 0;

        System.out.println("File Inventory Report");
        System.out.println("-------------");

        // Process each record
        for (String record : fileRecords) {

            // Split CSV record
            String[] parts = record.split(",");

            // Skip invalid records
            if (parts.length != 2) {
                System.out.println("Skipping malformed record: " + record);
                continue;
            }

            String fileName = parts[0].trim();
            int fileSize;

            // Convert size to number
            try {
                fileSize = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid size: " + record);
                continue;
            }

            // Get file extension
            String extension = "none";
            int dotIndex = fileName.lastIndexOf('.');

            if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
                extension = fileName.substring(dotIndex + 1).toLowerCase();
            }

            // Classify file type
            String fileType;

            switch (extension) {

                case "txt":
                case "pdf":
                case "docx":
                case "xlsx":
                    fileType = "Document";
                    documentCount++;
                    break;

                case "jpg":
                case "png":
                case "gif":
                    fileType = "Image";
                    imageCount++;
                    break;

                case "mp3":
                case "wav":
                    fileType = "Audio";
                    audioCount++;
                    break;

                case "java":
                case "py":
                case "js":
                    fileType = "Code";
                    codeCount++;
                    break;

                default:
                    fileType = "Other";
                    otherCount++;
            }

            // Add file size to total
            totalSize += fileSize;
            totalFiles++;

            // Check largest file
            if (fileSize > largestSize) {
                largestSize = fileSize;
                largestFile = fileName;
            }

            // Print file information
            System.out.println(
                    "Name: " + fileName +
                            ", Extension: " + extension +
                            ", Type: " + fileType +
                            ", Size: " + fileSize + " KB"
            );
        }

        // Print summary
        System.out.println("\n========== Summary ==========");
        System.out.println("Total Files: " + totalFiles);
        System.out.println("Total Size: " + totalSize + " KB");

        System.out.println("\nCategory Counts:");
        System.out.println("Documents: " + documentCount);
        System.out.println("Images: " + imageCount);
        System.out.println("Audio: " + audioCount);
        System.out.println("Code: " + codeCount);
        System.out.println("Other: " + otherCount);

        System.out.println("\nLargest File:");
        System.out.println(largestFile + " (" + largestSize + " KB)");
    }
}
