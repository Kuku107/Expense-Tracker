package com.learning.cli.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learning.cli.models.Expense;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
    public static List<Expense> getExpenseList() {
        Path filePath = Path.of("src/main/java/com/learning/cli/data.json");
        List<Expense> result = new ArrayList<>();
        try {
            String content = Files.readString(filePath);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Expense>>() {}.getType();
            result = gson.fromJson(content, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeExpenseList(List<Expense> expenseList) {
        String filePath = "src/main/java/com/learning/cli/data.json";
        Gson gson = new Gson();
        String json = gson.toJson(expenseList);
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
