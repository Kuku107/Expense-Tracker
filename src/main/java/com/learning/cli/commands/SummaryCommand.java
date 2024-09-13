package com.learning.cli.commands;

import com.learning.cli.models.Expense;
import com.learning.cli.utils.ExpenseList;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "summary",
        aliases = {"total"},
        mixinStandardHelpOptions = true,
        header = "Summary Command",
        description = "Calculate all the expense",
        footerHeading = "@Copyright",
        footer = "Developed by Kuku107"
)
public class SummaryCommand implements Callable<Integer> {

    @CommandLine.Option(
        names = {"-m", "--month"},
        description = "Provide the specific month of expense"
    )
    private int month;

    @Override
    public Integer call() throws Exception {
        List<Expense> expenseList = ExpenseList.getExpenseList();
        double total = 0;
        if (month == 0) {
            for(Expense expense : expenseList) total += expense.getAmount();
            System.out.printf("Total expenses: %.2f%n", total);
        } else {
            for(Expense expense : expenseList) {
                if (expense.getDate().getMonth() == month)
                    total += expense.getAmount();
            }
            System.out.printf("Total expenses for %d: %.2f%n", this.month, total);
        }
        return 0;
    }
}
