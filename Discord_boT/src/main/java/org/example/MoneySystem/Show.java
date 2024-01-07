package org.example.MoneySystem;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;
import org.example.util.port;
import org.json.JSONObject;

import java.io.IOException;

public class Show {
    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("money")) return;
        String Money = JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()));
        event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Balance") + Money).queue();
    }
}
