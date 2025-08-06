package gestion.entity;

@FunctionalInterface
public interface ExpenseFilter {
  boolean test(Expense expense);
}
