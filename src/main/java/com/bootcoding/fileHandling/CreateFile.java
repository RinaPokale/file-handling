package com.bootcoding.fileHandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File file = new File("Hello.txt");
        if(!file.exists()){
            file.createNewFile();
        }else{
            System.out.println(file.getName() +" file already exist");
        }
    }
}

//InputStreamReader:- is used to convert byte stream to character stream