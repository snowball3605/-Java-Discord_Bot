package org.example.Command.Eng_L;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Eng extends ListenerAdapter {

    String[] Word = {"1.Internet", "2.information", "3.Ubiquitous", "4.Ephemeral", "5.Ostentatious", "6.Pernicious", "7.Eloquent", "8.Meticulous", "9.Serendipity", "10.Benevolent", "11.Resilient", "12.Sycophant", "13.Community", "14.Efficient", "15.Reliable", "16.Diverse", "17.Innovative",
            "18.Respect", "19. Opportunity", "20.Challenge", "21.Environment", "22.Education", "23.Communication", "24.Global", "25.Technology", "26.Environment", "27.Leadership", "28.Knowledge", "29.Sustainability", "30.Creativity"
    }; //28
    String[] POS = {"1.Noun 名詞", "2.Noun 名詞", "3.adjective 形容詞", "4.adjective 形容詞", "5.adjective 形容詞", "6.adjective 形容詞", "7.adjective 形容詞", "8.adjective 形容詞", "9.noun 名詞", "10.adjective 形容詞", "11.adjective 形容詞", "12.noun 名詞", "13.noun 名詞", "14.adjective 形容詞", "15.adjective 形容詞", "16.adjective 形容詞", "17.adjective 形容詞",
            "18.verb 動詞", "19.Noun 名詞", "20.Noun 名詞", "21.Noun 名詞", "22.Noun 名詞", "23.Noun 名詞", "24.adjective 形容詞", "25.Noun 名詞", "26.Noun 名詞", "27.Noun 名詞", "28.Noun 名詞", "29.Noun 名詞", "30.Noun 名詞"
    };
    String[] Chinese = {"1.網路", "2.情報,資料,消息", "3.無所不在的, 普遍存在的", "4.短暫的,轉瞬即逝的", "5.炫耀的,炫示的", "6.有害的,致命的", "7.雄辯的,有口才的", "8.一絲不苟的,極為細心的", "9.意外的幸運，機緣巧合", "10.仁慈的,善良的", "11.有彈性的,能復原的", "12.馬屁精,阿諛奉承者", "13.社區，社會", "14.有效率的,高效的", "15.可靠的,可信賴的", "16.多樣的，不同種類的", "17.創新的,有創意的",
            "18.尊敬,尊重", "19.機會,機遇", "20.挑戰，困難", "21.環境，環境條件", "22.教育，學育", "23.溝通,交流", "24.全球的,國際的", "25.技術,科技", "26.環境，環境條件", "27.領導力，領導地位", "28.知識，學識", "29.可持續性，永續性", "創造力，創意"
    };

    int Max = 31;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("english")) return;
        int Word_Length = Word.length;
        int POS_Length = POS.length;
        int Chinese_Length = Chinese.length;

        if (Word_Length == POS_Length && Word_Length == Chinese_Length) {
            Random random = new Random();
            int Number = random.nextInt(0, Max);
            event.getInteraction().reply("單詞: " + Word[Number] + " ,POS: ||" +POS[Number] + "|| ,Chinese: ||" + Chinese[Number] + "||").setEphemeral(true).setActionRow(Button.success("English", "Next")).queue();
        } else {
            event.getInteraction().reply("Information is not neat").queue();
        }


    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (!event.getButton().getId().equals("English")) return;
        int Word_Length = Word.length;
        int POS_Length = POS.length;
        int Chinese_Length = Chinese.length;

        if (Word_Length == POS_Length && Word_Length == Chinese_Length) {
            Random random = new Random();
            int Number = random.nextInt(0, Max);
            event.getInteraction().reply("單詞: " + Word[Number] + " ,POS: ||" +POS[Number] + "|| ,Chinese: ||" + Chinese[Number] + "||").setEphemeral(true).setActionRow(Button.success("English", "Next")).queue();
        }else {
            event.getInteraction().reply("Information is not neat").queue();
        }
    }

}
