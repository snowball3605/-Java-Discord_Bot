//package org.example.Command.reload;
//
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//import org.example.Command.Game.Lion.Lion;
//import org.example.Command.Game.Poker.onSlashCommand;
//import org.example.Command.Game.Wolf.Button;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class reload extends ListenerAdapter {
//
//    public static void reloadAllProjects() {
//        for (Object pro : getFile.File("Discord_boT/")) {
//            try {
//                String FileName = pro.toString();
//                System.out.println(FileName);
//                Class<?> DC = Class.forName(FileName);
//                Method dM = DC.getEnclosingMethod();
//                dM.invoke(DC);
//                System.out.println("reload: " + DC);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//    public void Reload () throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name = reader.readLine();
//        System.out.println(name);
//        if (name.equals("/reload")) {
//            reloadAllProjects();
//        }
//    }
//
//    public static void main(String[] args) {
//        reloadAllProjects();
//    }
//}
