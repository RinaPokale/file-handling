package com.bootcoding.fileHandling.directoryHandling;

import java.io.File;

public class DirectoryList {
    public static void main(String[] args) {

        new DirectoryList().listAllFolders("C://Users//rinap");
    }

    private void listAllFolders(String directoryPath) {
        File file = new File(directoryPath);
        if(file.isDirectory()){
            // folder or directory
            String[] list = file.list();
            File[] files = file.listFiles();
            for(File f : files){
                if(!f.getName().startsWith(".")) {
                    if (f.isDirectory()) {
                        listAllFolders(f.getPath());
                    } else {
                        print(f);
                    }
                }
            }
        }else{
            print(file);
        }
    }

    private void print(File file){
        System.out.println(file.getPath() + "/" + file.getName());
    }
}
