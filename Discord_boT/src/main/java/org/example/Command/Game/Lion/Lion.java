package org.example.Command.Game.Lion;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.*;

import java.awt.*;
import java.util.Random;

import static org.example.util.CommandOptions.SLOT;

public class Lion extends ListenerAdapter {

    public static int total;
    public static int total1;
    public void onSlashCommand1(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("slot")) return;

            if (!Stats.Lion && !AdminMember.Admin(event.getMember().getIdLong())) {
                String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
                event.getInteraction().reply(Text).queue();
                return;
            }

            CommandOptions.Slot_Money = Integer.parseInt(event.getOption(SLOT).getAsString());

            int old = Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong())));
            if (old < CommandOptions.Slot_Money) {
                event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "No_Money")).queue();
                return;
            }

            int Player_old = (Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong())))) - CommandOptions.Slot_Money;
            JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(Player_old));

            String J = "";
            Random random = new Random();
            Random random1 = new Random();
            Random random2 = new Random();

            int Number1 = random.nextInt(1, 21);
            int Number2 = random1.nextInt(1, 21);
            int Number3 = random2.nextInt(1, 21);
            int Number4 = random.nextInt(1, 21);
            int Number5 = random1.nextInt(1, 21);
            int Number6 = random2.nextInt(1, 21);

            if (Number1 == Number2 && Number2 == Number3) {
                total = (int) ((CommandOptions.Slot_Money * 9.9) + Player_old);
                J = LangStructure.Detection(event.getGuild().getIdLong(), "Win");
                JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(total));
                total = total - Player_old;
            }else if ((Number1 == Number2 || Number2 == Number3 || Number1 == Number3) || (Number4 == Number5 || Number5 == Number6 || Number4 == Number6)) {
                total = (int) (CommandOptions.Slot_Money * 3.3) + Player_old;
                J = LangStructure.Detection(event.getGuild().getIdLong(), "Win");
                JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(total));
                total = total - Player_old;
            } else {
                J = LangStructure.Detection(event.getGuild().getIdLong(), "Lost");
                total = CommandOptions.Slot_Money;
            }

            String Message = Number1 + " " + Number2 + " " + Number3;
            String Message2 = Number4 + " " + Number5 + " " + Number6;
            MessageEmbed messageEmbed = new EmbedBuilder()
                    .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Slot"))
                    .setDescription(Message)
                    .appendDescription("\n" + Message2)
                    .appendDescription("\n" + J + total)
                    .setColor(new Color(random.nextInt(1, 256), random1.nextInt(1, 256), random2.nextInt(1, 256))).build();

            event.getInteraction().replyEmbeds(messageEmbed).queue();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
