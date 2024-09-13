package com.learning.cli.commands;

import com.learning.cli.models.Expense;
import com.learning.cli.utils.ExpenseList;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "list",
    aliases = {"ls"},
    mixinStandardHelpOptions = true,
    header = "List Command",
    description = "List all expension",
    footerHeading = "@Copyright",
    footer = "Developed by Kuku107"
)
public class ListCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        List<Expense> expenseList = ExpenseList.getExpenseList();
        System.out.printf("%3s %10s %6s %s\n", "ID", "Date", "Amount", "Description");
        for(Expense expense : expenseList) {
            System.out.printf("%3d %10s %6s %s\n",
                    expense.getId(), expense.getDate(), "$" + expense.getAmount(), expense.getDescription());
        }
        return 0;
    }
}
