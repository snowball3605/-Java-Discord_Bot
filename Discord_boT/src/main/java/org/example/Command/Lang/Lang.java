package org.example.Command.Lang;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;
import org.example.util.port;

import java.io.IOException;

import static org.example.util.CommandOptions.LANG;
import static org.example.util.port.Lang_File;

public class Lang {
    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("lang")) return;
        if (!Stats.Lang && !AdminMember.Admin(event.getMember().getIdLong())) {
            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
            event.getInteraction().reply(Text).queue();
            return;
        }

        String lang = event.getOption(LANG).getAsString();
        JsonStructure.WriteJsonFile((Lang_File + "ServerID.json"), String.valueOf(event.getGuild().getIdLong()), lang);
        event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Complete")).queue();
    }


}
