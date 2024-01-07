package org.example.Command.Game.Poker;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.example.AdminMember;
import org.example.MoneySystem.Command;
import org.example.Stats;
import org.example.util.*;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.example.util.CommandOptions.MONEY;

public class onSlashCommand extends ListenerAdapter {
    long After;
    public void onSlashCommandEvent(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("poker")) return;
        String Flower = "";
        String Flower2 = "";
        if (!Stats.Poker && !AdminMember.Admin(event.getMember().getIdLong())) {
            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
            event.getInteraction().reply(Text).queue();
            return;
        }
        CommandOptions.Money = event.getOption(MONEY).getAsInt();
        if (!MoneyEnough.Main(event.getGuild().getIdLong(), event.getMember().getIdLong(), CommandOptions.Money)) {
            event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "No_Money")).queue();
            return;
        }

        if (!CommandOptions.queue.isEmpty()) {
            event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "Playing")).queue();
            System.out.println(CommandOptions.queue.peek());
            return;
        }
        CommandOptions.Poker_Click = event.getUser().getIdLong();
        CommandOptions.queue.add(event.getUser().getId());
        int Value = Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong())));
        int finalValue = Value - CommandOptions.Money;
        JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(finalValue));

        Random random = new Random(); // number
        Random random1 = new Random(); // Flower

        Random random2 = new Random();
        Random random3 = new Random();

        switch (random1.nextInt(1,5)) {
            case 1:
                Flower = "♣";
            case 2:
                Flower = "♥";
            case 3:
                Flower = "♠";
            case 4:
                Flower = "♦";
        }
        switch (random3.nextInt(1, 5)) {
            case 1:
                Flower2 = "♦";
            case 2:
                Flower2 = "♥";
            case 3:
                Flower2 = "♠";
            case 4:
                Flower2 = "♣";
        }
        int Text = random.nextInt(1, 11);
        int Text1 = random2.nextInt(1, 11);
        String Message = LangStructure.Detection(event.getGuild().getIdLong(), "Card_First");
        String Message1 = LangStructure.Detection(event.getGuild().getIdLong(), "Card_Second");
        MessageEmbed messageEmbed = new EmbedBuilder()
                .setTitle("Poker")
                .setDescription(Message + (Flower + Text) + "  ")
                .appendDescription(Message1 + (Flower2 + Text1))
                .setFooter(LangStructure.Detection(event.getGuild().getIdLong(), "10Sec")).build();
        CommandOptions.MoneyJ = Text + Text1;
        event.getInteraction().replyEmbeds(messageEmbed).addActionRow(Button.success("AddPoker", LangStructure.Detection(event.getGuild().getIdLong(), "AddPoker")), Button.danger("StopPoker", LangStructure.Detection(event.getGuild().getIdLong(), "StopPoker"))).queue();
//        long First = NowTimeStructure.Int_LocalTime();
//        while ((After - First) <= 9.9) {
//            After = NowTimeStructure.Int_LocalTime();
//            if ((After - First) >= 10) {
//                System.out.println("break");
//                CommandOptions.queue.clear();
//                return;
//            }
//        }

    }


    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (!event.getButton().getId().equals("AddPoker")) return;
        if (event.getMember().getIdLong() != CommandOptions.Poker_Click) {
            event.getInteraction().reply(LangStructure.Detection(event.getGuild().getIdLong(), "NoTurn")).setEphemeral(true).queue();
            return;
        }

        if (event.getButton().getId().equals("AddPoker")) {
            Random random = new Random();
            Random random1 = new Random();
            String Flower = "";
            switch (random1.nextInt(1,5)) {
                case 1:
                    Flower = "♣";
                case 2:
                    Flower = "♥";
                case 3:
                    Flower = "♠";
                case 4:
                    Flower = "♦";
            }
            int Number = random.nextInt(1, 11);
            CommandOptions.MoneyJ = CommandOptions.MoneyJ + Number;

            if (CommandOptions.MoneyJ > 21) {
                MessageEmbed messageEmbed = new EmbedBuilder()
                        .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Card") + Flower + Number)
                        .setDescription(LangStructure.Detection(event.getGuild().getIdLong(), "Total") + CommandOptions.MoneyJ)
                        .appendDescription("\n" + LangStructure.Detection(event.getGuild().getIdLong(), "Lost") + CommandOptions.Money + " Money")
                        .setColor(new Color(255, 255, 0)).build();

                event.getInteraction().replyEmbeds(messageEmbed).queue();
                CommandOptions.queue.clear();
                System.out.println(CommandOptions.queue.poll());
            } else if (CommandOptions.MoneyJ == 21){
                int S = CommandOptions.Money * 3;
                MessageEmbed messageEmbed = new EmbedBuilder()
                        .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Card") + Flower  + Number)
                        .setDescription(LangStructure.Detection(event.getGuild().getIdLong(), "Total") + CommandOptions.MoneyJ)
                        .appendDescription("\n"+ LangStructure.Detection(event.getGuild().getIdLong(), "Win") + S + " Money")
                        .setColor(new Color(255, 255, 0)).build();

                event.getInteraction().replyEmbeds(messageEmbed).queue();
                int HU = (Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()))));
                int MY = ((CommandOptions.Money * 3) + HU) + CommandOptions.Money;
                JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(MY));
                CommandOptions.queue.clear();
                System.out.println(CommandOptions.queue.poll());
            }else {
                MessageEmbed messageEmbed = new EmbedBuilder()
                        .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Card") + Flower  + Number)
                        .setDescription(LangStructure.Detection(event.getGuild().getIdLong(), "Total") + CommandOptions.MoneyJ)
                        .setFooter(LangStructure.Detection(event.getGuild().getIdLong(), "10Sec"))
                        .setColor(new Color(255, 255, 0)).build();

                event.getInteraction().replyEmbeds(messageEmbed).addActionRow(Button.success("AddPoker", LangStructure.Detection(event.getGuild().getIdLong(), "AddPoker")), Button.danger("StopPoker", LangStructure.Detection(event.getGuild().getIdLong(), "StopPoker"))).queue();
//                long First = NowTimeStructure.Int_LocalTime();
//                while ((After - First) <=
//                        9.9) {
//                    After = NowTimeStructure.Int_LocalTime();
//                    if ((After - First) >= 10) {
//                        CommandOptions.queue.clear();
//                        System.out.println("break");
//                        return;
//                    }
//                }
            }
        }

        if (event.getButton().getId().equals("StopPoker")) {
            CommandOptions.queue.clear();
            System.out.println(CommandOptions.queue.poll());
            Random random = new Random();

            String WinOrLost = "IDK";
            int Number1 = random.nextInt(1, 11);
            int Number2 = random.nextInt(1, 11);
            int total = Number1 + Number2;

            while (true) {
                if (total <= 17) {
                    total = total + random.nextInt(1, 11);
                }
                if (total >= 17) break;
            }

            if ((total > CommandOptions.MoneyJ || (total == 21 && CommandOptions.MoneyJ != 21)) && total <= 21) {
                WinOrLost = LangStructure.Detection(event.getGuild().getIdLong(), "Lost")  + CommandOptions.Money;
                CommandOptions.queue.poll();
            } else if (total == CommandOptions.MoneyJ) {
                WinOrLost = LangStructure.Detection(event.getGuild().getIdLong(), "Tie");
                JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(CommandOptions.Money));
                CommandOptions.queue.poll();
            } else {
                WinOrLost = LangStructure.Detection(event.getGuild().getIdLong(), "Win") + (CommandOptions.Money* 2);
                int HU = (Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()))));
                int MY = ((CommandOptions.Money * 2) + HU) + CommandOptions.Money;
                System.out.println(HU);
                JsonStructure.AddProperty(port.Money_File, String.valueOf(event.getGuild().getIdLong()), String.valueOf(event.getUser().getIdLong()), String.valueOf(MY));
                CommandOptions.queue.poll();
            }

            MessageEmbed messageEmbed = new EmbedBuilder()
                    .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Point") + CommandOptions.MoneyJ)
                    .setDescription(LangStructure.Detection(event.getGuild().getIdLong(), "Banker") + ": " + total)
                    .appendDescription("\n" + WinOrLost).build();

            event.getInteraction().replyEmbeds(messageEmbed).queue();
            CommandOptions.queue.poll();
        }
    }
}
