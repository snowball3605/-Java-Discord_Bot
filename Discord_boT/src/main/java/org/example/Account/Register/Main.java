package org.example.Account.Register;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.sql.*;

public class Main {
    public static void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("Register")) return;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/discordbot", "snow", "A@@46426764@@a");
            Statement St = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

