package com.learning.cli.commands;

import com.learning.cli.models.Expense;
import com.learning.cli.utils.ExpenseList;
import picocli.CommandLine;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "update",
        aliases = {"change"},
        header = "Update Command",
        description = "Update an expense by amount or description",
        mixinStandardHelpOptions = true,
        footerHeading = "@Copyright\n",
        requiredOptionMarker = '*',
        footer = "Developed by Kuku107"
)
public class UpdateCommand implements Callable<Integer> {

    @CommandLine.Option(
        names = {"--id"},
        description = "The id of expense you want to update",
        required = true
    )
    private int id;

    @CommandLine.Option(
        names = {"-d", "--description"},
        description = "The description change to"
    )
    private String description;

    @CommandLine.Option(
        names = {"-a", "--amount"},
        description = "The amount change to"
    )
    private double amount;

    @Override
    public Integer call() throws Exception {
        if (Objects.isNull(description) && amount == 0.0) {
            System.out.println("Please provide what you want to update");
            return 0;
        }
        List<Expense> expenseList = ExpenseList.getExpenseList();
        for(Expense expense : expenseList) {
            if (expense.getId() == id) {
                if (Objects.nonNull(description))
                    expense.setDescription(description);
                if (amount > 0)
                    expense.setAmount(amount);
                System.out.println("Update successfully");
                break;
            }
        }
        ExpenseList.writeExpenseList(expenseList);
        return 0;
    }
}
