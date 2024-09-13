package com.learning.cli.commands;

import com.learning.cli.models.Expense;
import com.learning.cli.utils.ExpenseList;
import picocli.CommandLine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "add",
        aliases = {"plus, make"},
        header = "Add Command",
        description = "Add an expensing you've make",
        mixinStandardHelpOptions = true,
        footerHeading = "@Copyright\n",
        requiredOptionMarker = '*',
        footer = "Developed by Kuku107"
)
public class AddCommand implements Callable<Integer> {

    @CommandLine.Option(
        names = {"-d", "--description"},
        required = true
    )
    private String description;

    @CommandLine.Option(
            names = {"-a", "--amount"},
            required = true
    )
    private double amount;

    @Override
    public Integer call() throws Exception {
        List<Expense> expenseList = ExpenseList.getExpenseList();
        int id = (Objects.isNull(expenseList) || expenseList.isEmpty()) ? 1 : expenseList.get(expenseList.size()-1).getId() + 1;
        Date date = new Date();
        String description = this.description;
        double amount = this.amount;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Expense expense = new Expense(id, new java.sql.Date(new java.util.Date().getTime()), description, amount);
        expenseList.add(expense);
        ExpenseList.writeExpenseList(expenseList);
        System.out.printf("Expense added successfully (ID: %d)%n", id);
        return 0;
    }
}
