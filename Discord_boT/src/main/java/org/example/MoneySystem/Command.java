package org.example.MoneySystem;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;
import org.example.util.port;

import java.io.IOException;

import static org.example.util.CommandOptions.*;

public class Command {
    public void SetMoney(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("setmoney")) return;
        if (!Stats.SetMoney && !AdminMember.Admin(event.getMember().getIdLong())) {
            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
            event.getInteraction().reply(Text).queue();
            return;
        }
        long GuildID = event.getOption(GUILDID).getAsLong();
        long MEMBER = event.getOption(MEMBERID).getAsLong();
        int Money = event.getOption(MONEYCOUNT).getAsInt();

        JsonStructure.AddProperty(port.Money_File, String.valueOf(GuildID), String.valueOf(MEMBER), String.valueOf(Money));

        event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Complete")).queue();

    }
}
