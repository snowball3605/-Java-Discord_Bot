package org.example;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import org.example.util.BotStructure;
import org.jetbrains.annotations.NotNull;

import static org.example.util.CommandOptions.*;

public class Main  extends ListenerAdapter {

    public static void main(String[] args) throws Exception {

        BotStructure.Main("--GG--", new Listener(),
                new CommandDataImpl[] {new CommandDataImpl("wolf", "play game")
                        .addOptions(new OptionData(OptionType.CHANNEL,VOICECHANNEL, "playchannel")),

                        new CommandDataImpl("poker", "poker")
                                .addOptions(new OptionData(OptionType.STRING, MONEY, "Select you want", true)
                                .addChoice("100", "100")
                                .addChoice("1000", "1000")
                                .addChoice("10K", "10000")
                                .addChoice("100K", "100000")
                                .addChoice("1M", "1000000")
                                .addChoice("10M", "10000000")),

                        new CommandDataImpl("lang", "lang")
                                .addOptions(new OptionData(OptionType.STRING, LANG, "Change Server Language", true)
                                .addChoice("zh_TW 繁體", "zh_TW")
                                .addChoice("zh_CN 簡體", "zh_CN")
                                .addChoice("ja_JP 日語", "ja_JP")
                                .addChoice("en_US English", "en_US")),

                        new CommandDataImpl("setmoney", "set player money")
                                .addOptions(new OptionData(OptionType.STRING, GUILDID, "guild id", true))
                                .addOptions(new OptionData(OptionType.STRING, MEMBERID, "member id", true))
                                .addOptions(new OptionData(OptionType.STRING, MONEYCOUNT, "money count", true)),

                        new CommandDataImpl("money", "check money"),

                        new CommandDataImpl("slot", "slotmachine")
                                .addOptions(new OptionData(OptionType.STRING, SLOT, "set play money", true)
                                .addChoice("100", "100")
                                .addChoice("1000", "1000")
                                .addChoice("10K", "10000")
                                .addChoice("100K","100000")
                                .addChoice("1M", "1000000")
                                .addChoice("10M","10000000")),
                        new CommandDataImpl("work", "just 10% at successfully"),
                        new CommandDataImpl("skyblock", "check skyblock value"),

                        new CommandDataImpl("english", "English Leaning"),
                        new CommandDataImpl("cx_complete_form", "cx complete form")
                                .addOptions(new OptionData(OptionType.MENTIONABLE, CX_MEMBER, "Member", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_REASON, "Reason", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_TIMESTAMP, "Discord Time Stamp", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_CM, "CM", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_POSITION, "Position", true)),
                        new CommandDataImpl("cx_complete", "Complete interview")
                                .addOptions(new OptionData(OptionType.MENTIONABLE, CX_MEMBER,"Member", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_Fraction, "Fraction", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_TIMESTAMP, "Discord Time Stamp", true))
                                .addOptions(new OptionData(OptionType.STRING, CX_CM, "CM", true)),
                        new CommandDataImpl("gemini", "Gemini AI")
                                .addOptions(new OptionData(OptionType.STRING, GPT_I, "input", true)),
                        new CommandDataImpl("rule", "rule")

                });

    }

//    .addOptions(new OptionData(OptionType.STRING, PLAY_OPTION, "game option", true)
//                                .addChoice("5人:1狼,1預言家,2平民,1獵人", "P5")
//                                .addChoice("6人:1狼,1預言家,2平民,1獵人,1女巫", "P6")
//                                .addChoice("7人:2狼,1預言家,2平民,1獵人,1女巫", "P7")
//                                .addChoice("10人:3狼,1預言家,4平民,1獵人,1女巫", "P10"))

}