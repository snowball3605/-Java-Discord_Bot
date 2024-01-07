package org.example.Event.EarthQuake;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.example.util.JsonStructure;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.example.util.port.EQ_Record;

public class EQ extends ListenerAdapter {
    int time = 0;
    @Override
    public void onReady(ReadyEvent event) {
        try {
            Thread thread = new Thread(() -> {
            while (true) {
                try {
                    time += 1;
                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(300, TimeUnit.SECONDS).build();

                    Request request = new Request.Builder().url("https://data.weather.gov.hk/weatherAPI/opendata/earthquake.php?dataType=feltearthquake&lang=en").build();
                    Response response = client.newCall(request).execute();
                    ResponseBody responseBody = response.body();
                    String s = responseBody.string();

                    if (s.equals("{}")) {
                    } else {
                        if (JsonStructure.readJsonFile_Key(EQ_Record, "0").equals(s)) return;

                        JsonStructure.WriteJsonFile(EQ_Record, JsonStructure.readStringBuild(s, "ptime"), s);

                        float lat = Float.parseFloat(JsonStructure.readStringBuild(s, "lat"));
                        float lon = Float.parseFloat(JsonStructure.readStringBuild(s, "lon"));

                        String intensity = JsonStructure.readStringBuild(s, "intensity");

                        MessageEmbed stringBuilder1 = new EmbedBuilder()
                                .setTitle(JsonStructure.readStringBuild(s, "ptime") + " Earthquake Happened")
                                .setDescription(JsonStructure.readStringBuild(s, "details"))
                                .addField("―――latitude and longitude―――", "lat:" + lat + ", lon:" + lon, true)
                                .addField("―――Intensity―――", Method.EQ_LEVEL(intensity) + intensity + "(" + Method.EQ_Text(intensity) + ")", false)
                                .addField("―――Timer―――", JsonStructure.readStringBuild(s, "ptime"), true)
                                .addField("―――Location―――", JsonStructure.readStringBuild(s, "region"), false)
                                .build();

                        event.getJDA().getGuildById("1156930341035065487").getTextChannelById("1158409952541556779").sendMessageEmbeds(stringBuilder1).queue();

                    }

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        continue;

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
            thread.start();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    };


//    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder().url("https://data.weather.gov.hk/weatherAPI/opendata/earthquake.php?dataType=feltearthquake&lang=en").build();
//        Response response = client.newCall(request).execute();
//        ResponseBody responseBody = response.body();
//        String s = responseBody.string();
//
//        if (s.equals("{}")) {
//            return;
//        } else {
//            if (JsonStructure.readJsonFile_Key(EQ_Record, "0").equals(s)) return;
//
//            JsonStructure.DeleteJsonKey(EQ_Record, "0");
//            JsonStructure.WriteJsonFile(EQ_Record, "0", s);
//            System.out.println(s);
//        }
//    }

