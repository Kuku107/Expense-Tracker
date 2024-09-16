package com.learning.cli.utils;

import com.learning.cli.models.Expense;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public class CSVFile {
    public static void writeToCSV(Path path) {
        List<Expense> expenseList = ExpenseList.getExpenseList();
        try (Writer writer = new FileWriter(path.toString())){
            StatefulBeanToCsv<Expense> sbc = new StatefulBeanToCsvBuilder<Expense>(writer)
                    .withQuotechar('\'')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            sbc.write(expenseList);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}
