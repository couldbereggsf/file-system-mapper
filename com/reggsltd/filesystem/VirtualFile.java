package com.reggsltd.filesystem;

public class VirtualFile {
    private final String name;
    private final boolean isDirectory;
    private final VirtualFile[] children; // Array to hold nested files

    // Constructor for a standard file
    public VirtualFile(String name) {
        this.name = name;
        this.isDirectory = false;
        this.children = new VirtualFile[0]; // Empty array
    }

    // Constructor for a directory
    public VirtualFile(String name, VirtualFile[] children) {
        this.name = name;
        this.isDirectory = true;
        this.children = children;
    }

    public String getName() { return name; }
    public boolean isDirectory() { return isDirectory; }
    public VirtualFile[] getChildren() { return children; }
}