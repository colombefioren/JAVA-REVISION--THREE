package gestion.dao;

import gestion.entity.Expense;
import gestion.entity.RecurringExpense;
import gestion.entity.RefundableExpense;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseDAO {
  private final List<Expense> expenses;

  public ExpenseDAO(List<Expense> expenses) {
    this.expenses = expenses;
  }

  public List<Expense> getExpenses() {
    return expenses;
  }

  public List<Expense> getPendingRefunds() {
    return expenses.stream()
        .filter(e -> e instanceof RefundableExpense && !((RefundableExpense) e).isRefunded())
        .toList();
  }

  public double getTotalRecurringAmount() {
    return expenses.stream()
        .filter(e -> e instanceof RecurringExpense)
        .mapToDouble(Expense::getAmount)
        .sum();
  }

  public List<String> getHighLabelExpenses() {
    return expenses.stream().filter(Expense::isLargeExpense).map(Expense::getName).toList();
  }

  public double getTotalExpensesAmount() {
    return expenses.stream().mapToDouble(Expense::getAmount).sum();
  }

  public Map<String, Double> groupTotalByMonth() {
    Map<String, Double> result = new HashMap<>();
    expenses.forEach(
        e -> {
          String key = e.getYearMonth();
          if (result.containsKey(key)) {
            result.put(key, result.get(key) + e.getAmount());
          } else {
            result.put(key, e.getAmount());
          }
        });
    return result;
  }
}
