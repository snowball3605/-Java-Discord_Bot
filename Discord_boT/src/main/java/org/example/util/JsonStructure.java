package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonStructure {
//            <dependency>
//            <groupId>com.google.code.gson</groupId>
//            <artifactId>gson</artifactId>
//            <version>2.10.1</version>
//        </dependency>
//        <dependency>
//            <groupId>org.json</groupId>
//            <artifactId>json</artifactId>
//            <version>20230618</version>
//        </dependency>
//        <dependency>
//            <groupId>com.fasterxml.jackson.core</groupId>
//            <artifactId>jackson-databind</artifactId>
//            <version>2.15.2</version>
//        </dependency>

    public static String readJsonFile_All(String FilePort) {
        try {

            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FilePort)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return stringBuilder.toString();

        } catch (FileNotFoundException e) {
            System.out.println("系統找不到指定的路徑。 錯誤: 0x00000017");
        } catch (IOException e) {
            System.out.println("系統找不到指定的路徑。 錯誤: 0x00000017");
        }
        return null;
    }

    public static String readJsonFile_Key(String FilePort, String Key) {
        String a = readJsonFile_All(FilePort);
        JSONObject jsonObject = new JSONObject(a);
        if (!jsonObject.has(Key)) {
            return "false";
        }

        return jsonObject.get(Key).toString();

    }

    public static String readStringBuild(String String, String Key) {
        JSONObject jsonObject = new JSONObject(String);
        return jsonObject.getString(Key);
    }


    public static Boolean WriteJsonFile(String FilePort, String Key, String Text) {
        try {
            FileReader fileReader = new FileReader(FilePort);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String jsonString = "";
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                jsonString += line;
            }
            bufferedReader.close();
            JSONObject jsonObject = new JSONObject(jsonString);
            jsonObject.put(Key, Text);
            String up = jsonObject.toString();
            FileWriter fileWriter = new FileWriter(FilePort);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(up);
            bufferedWriter.close();
            return true;

        } catch (JSONException | IOException e) {
            System.out.println("上傳失敗, 錯誤: 0x00000017");
            return false;
        }
    }

    public static void DeleteJsonKey(String FilePart, String Key) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(FilePart)));
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonNodes = objectMapper.readValue(jsonString, ObjectNode.class);
            jsonNodes.remove(Key);
            String up = objectMapper.writeValueAsString(jsonNodes);
            BufferedWriter writer = new BufferedWriter(new FileWriter(FilePart));
            writer.write(up);
            writer.close();

        } catch (IOException e) {
            System.out.println("上傳失敗, 錯誤: 0x00000017");
        }
    }

    public static void Property(String FilePart, String FirstKey, String Key, String Text) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(new FileReader(FilePart));

            JsonObject newR = new JsonObject();
            newR.addProperty(Key, Text);

            json.add(FirstKey, newR);

            Gson gson = new Gson();
            FileWriter writer = new FileWriter(FilePart);
            gson.toJson(json, writer);
            writer.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void AddProperty(String FilePart, String FirstKey, String Key, String Text) {
        String StringT = readJsonFile_All(FilePart);
        try {
            JSONObject jsonObject = new JSONObject(StringT);
            if (!jsonObject.has(FirstKey)) {
                Property(FilePart, FirstKey, Key, Text);
                return;
            }

            try {
                JSONObject jsonObject1 = new JSONObject(StringT);
                jsonObject1.getJSONObject(FirstKey).put(Key, Text);

                FileWriter fileWriter = new FileWriter(FilePart);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(jsonObject1.toString());
                bufferedWriter.close();


            } catch (Exception e) {
            }

        } catch (JSONException e) {
        }
    }

    public static void DeleteProperty(String FilePart, String FirstKey, String Key) {
        String String = readJsonFile_All(FilePart);
        try {
            JSONObject jsonObject = new JSONObject(String);
            JSONArray RA = jsonObject.getJSONArray(FirstKey);

            for (int i = 0; i < RA.length(); i++) {
                JSONObject rO = RA.getJSONObject(i);
                rO.remove(Key);
            }

            String mod = jsonObject.toString();

            FileWriter fileWriter = new FileWriter(FilePart);
            fileWriter.write(mod);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String GetPropertyKey(String FilePart, String FirstKey, String Key) {
         try {
             String StringT = readJsonFile_All(FilePart);
             JSONObject jsonObject = new JSONObject(StringT);

             if (jsonObject.has(FirstKey)) {
                 JSONObject o = jsonObject.getJSONObject(FirstKey);
                 if (!o.has(Key)) {
                     AddProperty(FilePart, FirstKey, Key, "0");
                     return "0";
                 }
             }
             if (!jsonObject.has(FirstKey)) {
                 AddProperty(FilePart, FirstKey, Key, "0");
                 JSONObject o = jsonObject.getJSONObject(FirstKey);
                 if (!o.has(Key)) {
                     AddProperty(FilePart, FirstKey, Key, "0");
                     return "0";
                 }
             }

             JSONObject rO = jsonObject.getJSONObject(FirstKey);

             return rO.getString(Key);

         } catch (JSONException ex) {
             throw new RuntimeException(ex);
         }
    }

//        public static void main(String[] args) {
//        System.out.println(GetPropertyKey("Discord_boT/src/test.json", "AK", "1232"));
//    }



}
