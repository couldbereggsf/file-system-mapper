package com.reggsltd.filesystem;

public class Main {
    public static void main(String[] args) {

        // Building the nested array structure from the bottom up
        VirtualFile[] system32Files = {
                new VirtualFile("kernel.dll"),
                new VirtualFile("network_trojan.exe"), // Malicious file
                new VirtualFile("system.log")
        };
        VirtualFile[] rootDriveFiles = getVirtualFiles(system32Files);
        VirtualFile rootDrive = new VirtualFile("C_Drive", rootDriveFiles);

        // Execute the recursive scan
        DirectoryMapper mapper = new DirectoryMapper();
        mapper.scanSystem(rootDrive);
    }

    private static VirtualFile[] getVirtualFiles(VirtualFile[] system32Files) {
        VirtualFile system32Folder = new VirtualFile("System32", system32Files);

        VirtualFile[] userFiles = {
                new VirtualFile("passwords.txt"),
                new VirtualFile("family_photo.jpg"),
                new VirtualFile("hidden_miner_trojan.exe") // Malicious file
        };
        VirtualFile documentsFolder = new VirtualFile("Documents", userFiles);

        // The Root Drive holds the two folders above
        VirtualFile[] rootDriveFiles = {
                system32Folder,
                documentsFolder,
                new VirtualFile("boot.ini")
        };
        return rootDriveFiles;
    }
}