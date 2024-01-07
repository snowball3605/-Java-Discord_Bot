package org.Console.PID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.JDA;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class side {
    public static void Main(JDA jda) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String Text = scanner.nextLine();

            if (Text.equalsIgnoreCase("/PID")) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    JsonNode jsonNode = objectMapper.readTree(new File("PID/PID.json"));
                    System.out.println("PID size: " + jsonNode.size());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
