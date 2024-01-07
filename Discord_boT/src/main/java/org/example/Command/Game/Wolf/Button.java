package org.example.Command.Game.Wolf;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.event.ActionEvent;

import static org.example.Command.Game.Wolf.Start.*;

public class Button {
    public void ButtonClick(ButtonInteractionEvent event) {
        if (!event.getButton().getId().equals("start")) return;
        if (MemberCount <= 5) {
            event.getInteraction().reply("人數不足,無法開始").setEphemeral(true).queue();
        } else {
            MessageEmbed embedBuilder = new EmbedBuilder()
                    .setTitle("遊戲開始")
                    .setDescription("請各位關閉直播,打開DM查看職位").build();

            event.getInteraction().replyEmbeds(embedBuilder).queue();
            for (int i = 0; i >= MemberCount;i++) {
                for (long Member : MemberID)
                event.getGuild().getMemberById(Member).getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessage("你是" + RandomTag.main()).queue();
                });
            }
        }
    }
}
