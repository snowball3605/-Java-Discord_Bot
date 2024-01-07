package org.example.Command.Lang;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;
import org.example.util.port;

import java.io.IOException;
import java.util.Random;

public class Work {
    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("work")) return;
        if (!Stats.Work && !AdminMember.Admin(event.getMember().getIdLong())) {
            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
            event.getInteraction().reply(Text).queue();
            return;
        }
        int old_money = Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong())));

        Random random = new Random();
        int S = random.nextInt(1, 101);
        if (S <= 10) {
            event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Work_S")).queue();
            int r = random.nextInt(1, 2000);
            int total = old_money + r;
            JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(total));
            event.getChannel().sendMessage(LangStructure.Detection(event.getGuild().getIdLong(), "Got") + r).queue();
        } else {
            event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Work_F")).queue();

        }

    }
}
