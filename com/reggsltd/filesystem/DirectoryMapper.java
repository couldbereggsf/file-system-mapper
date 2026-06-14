package com.reggsltd.filesystem;

public class DirectoryMapper {

    private int totalMalwareFound = 0;

    // This is the public method the user calls
    public void scanSystem(VirtualFile rootNode) {
        System.out.println("Starting Deep System Scan on: " + rootNode.getName());
        // Call the private recursive method, starting with zero indentation
        recursiveScan(rootNode, "");
        System.out.println("\nScan Complete. Total Threats Quarantined: " + totalMalwareFound);
    }

    // ==========================================
    // THE RECURSIVE METHOD
    // ==========================================
    private void recursiveScan(VirtualFile currentFile, String indent) {

        // 1. Process the current file/folder
        analyzeFile(currentFile.getName(), indent);

        // 2. THE BASE CASE: If it's not a directory, recursion stops for this branch.
        if (!currentFile.isDirectory()) {
            return;
        }

        // 3. THE RECURSIVE STEP: If it IS a directory, loop through its children.
        for (VirtualFile child : currentFile.getChildren()) {
            // It calls ITSELF, adding more spaces to the indent for visual tree mapping
            recursiveScan(child, indent + "   ");
        }
    }

    // Helper method showcasing Java String manipulation
    private void analyzeFile(String fileName, String indent) {
        // String methods: toLowerCase(), endsWith(), contains()
        String lowerCaseName = fileName.toLowerCase();

        if (lowerCaseName.endsWith(".exe") && lowerCaseName.contains("trojan")) {
            System.out.println(indent + "└── 💀 QUARANTINED: " + fileName);
            totalMalwareFound++;
        } else if (lowerCaseName.endsWith(".log")) {
            // We ignore log files to save space on the dashboard
            // (Doing nothing effectively acts as a 'continue' in the recursive tree)
        } else {
            System.out.println(indent + "└── 📄 " + fileName);
        }
    }
}