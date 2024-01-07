package org.example.Command.reload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getFile {
    static List<Object> proj = new ArrayList<>();
    public static List<Object> File(String Path) {
        File folder = new File(Path);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        proj.add(file.getName());
                    } else if (file.isDirectory()) {
                        // 如果是資料夾，遞迴進入資料夾進行相同操作
                        File(file.getAbsolutePath());
                    }
                }
            }
        }
        return proj;
    }

//    public static void main(String[] args) {
//        System.out.println(File("Discord_boT"));
//    }
}
