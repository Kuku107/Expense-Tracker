package com.learning.cli.commands;

import com.learning.cli.models.Expense;
import com.learning.cli.utils.ExpenseList;
import picocli.CommandLine;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete",
        aliases = {"remove", "del"},
        mixinStandardHelpOptions = true,
        header = "Delete command",
        description = "Delete an expense, The default is delete all expension",
        requiredOptionMarker = '*',
        footerHeading = "@Copyright",
        footer = "Developed by Kuku107"
)
public class DeleteCommand implements Callable<Integer> {

    @CommandLine.Option(
        names = {"--id"},
        description = "Provide an id of expension"
    )
    private int id;

    @Override
    public Integer call() throws Exception {
        List<Expense> expenseList = ExpenseList.getExpenseList();
        if (id == 0) {
            expenseList.clear();
        } else {
            for(Expense expense : expenseList)
                if (expense.getId() == id) {
                    expenseList.remove(expense);
                    break;
                }
        }
        ExpenseList.writeExpenseList(expenseList);
        System.out.println("Expense deleted successfully");
        return 0;
    }
}
