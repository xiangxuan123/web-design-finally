package com.example.springmvc;

import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class FileUtils {
    /**
     * 获取指定文件大小
     * @param path
     * @return
     */
    public static long getSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException("操作错误！无法对指定文件执行操作");
        }
    }

    public static void main(String[] args) {
            File file = new File("1231");
            assert file.exists();
            System.out.println("1");
            //long siz = FileUtils.getSize(Path.of("D://a.txt"));
    }
}


