package org.example.Command.Rule;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class rule extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("rule")) return;
        if (!event.getUser().getId().equals("705674606043856956")) return;
        event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle("社群規則").setDescription("一 、 社會政治問題\n" +
                "                  1.不當言論： 禁止在聊天中使用種族、性別、宗教、政治等方面的歧視性言論。\n" +
                "                 2.政治宣傳： 防止在聊天中進行政治宣傳。保持環境中立，避免引起不必要的爭議。\n" +
                "                 3.敏感內容： 不允許分享或創建包含敏感主題的建築或藝術品。(即是18+, 18+頻道除外)\n" +
                "                 4.公平公正公開：不允許任何形式的偏見或不平等\n" +
                "                 5.霸凌： 禁止任何形式的霸凌行為，包括對社會政治立場的霸凌。\n" +
                "                 6.遵從法律法規： 請遵守當地法律和法規。\n" +
                "                 7.尊重言論自由： 保障玩家言論自由，但同時要求他們在言論中保持尊重和理智。\n" +
                "\n" +
                "二、伺服器問題\n" +
                "                1.外掛或作弊程式： 禁止在伺服器上使用任何外掛或作弊程式，以確保遊戲的公平性和平衡性。\n" +
                "               2.禁止滥用漏洞： 禁止利用遊戲中的漏洞或錯誤，並應及時向管理員報告發現的漏洞。\n" +
                "               3.保護伺服器資源： 不准進行對伺服器性能有害的行為，例如大量生成實體、不當的紅石電路等。\n" +
                "               4.不同意開啟PvP： 避免玩家在未經其他玩家同意的情況下進行PvP（玩家間對戰）。\n" +
                "               5.禁止進行非法交易： 不准在伺服器上進行非法物品或帳號的交易。\n" +
                "               6.禁止滥用聊天： 不准進行刷屏、辱罵或其他影響聊天體驗的行為。\n" +
                "               7.尊重管理員指示： 玩家應尊重伺服器管理員的決定並遵從他們的指示，特別是在解決伺服器問題的情況下。\n" +
                "              8.禁止廣告宣傳： 不准在伺服器上進行未經許可的宣傳行為(宣傳頻道除外)。\n" +
                "              9.保護個人資訊： 不准在伺服器上公開或索取其他玩家的個人資訊。\n" +
                "\n" +
                "一經發現直接 請離 伺服器(如沒有問題,請點下面按鈕)").build()).setActionRow(Button.success("rule", "確定")).queue();
    }

    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (!event.getButton().getId().equals("rule")) return;
        event.getGuild().addRoleToMember(event.getUser(), event.getJDA().getRoleById("1188494499777871933")).queue();
        event.getInteraction().reply("已新增新分組").setEphemeral(true).queue();
    }
}
