package org.example.util;

import com.google.gson.JsonObject;
import net.dv8tion.jda.api.utils.TimeUtil;

import java.io.IOException;
import java.util.Objects;


public class LangStructure {
    public static String Detection(long GuildID, String Key) {
        String ID = String.valueOf(GuildID);
        String a = JsonStructure.readJsonFile_Key((port.Lang_File + "ServerID.json"), ID);
        if (Objects.equals(a, "false")) {
            Add(GuildID, Key);
            JsonStructure.WriteJsonFile((port.Lang_File + "ServerID.json"), String.valueOf(GuildID), "en_US");
        }

        a = JsonStructure.readJsonFile_Key((port.Lang_File + "ServerID.json"), ID);
        switch (a) {
            case "zh_TW":
               return JsonStructure.readJsonFile_Key((port.Lang_File + "zh_TW.json"), Key);
            case "zh_CN":
                return JsonStructure.readJsonFile_Key((port.Lang_File + "zh_CN.json"), Key);
            case "ja_JP":
                return JsonStructure.readJsonFile_Key((port.Lang_File + "ja_JP.json"), Key);
            case "en_US":
                return JsonStructure.readJsonFile_Key((port.Lang_File + "en_US.json"), Key);
        }

        return null;
    }

    public static void Add(long Guild, String Key) {
        JsonStructure.WriteJsonFile((port.Lang_File + "ServerID.json"), String.valueOf(Guild), Key);
    }


}
