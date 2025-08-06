package gestion.dao;

import static org.junit.jupiter.api.Assertions.*;

import gestion.entity.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseTest {
  Expense expense1;
  Expense expense2;
  Expense expense3;
  Expense expense4;
  Expense expense5;
  ExpenseDAO expenseDAO;

  @BeforeEach
  void setup() {
    expense1 = new RefundableExpense("Coffee", 10.0, LocalDate.of(2025, 8, 5), null, false);
    expense2 =
        new RecurringExpense(
            "Pizza", 100.0, LocalDate.of(2025, 7, 2), null, Recurrence.MONTHLY, 12);
    expense3 = new ApprovalExpense("Beer", 546.0, LocalDate.of(2025, 8, 5), null, false);
    expense4 = new Expense("Gas", 13000000, LocalDate.of(2025, 7, 4), null);
    expense5 = new Expense("Food", 10.0, LocalDate.of(2025, 8, 5), null);

    expenseDAO = new ExpenseDAO(Arrays.asList(expense1, expense2, expense3, expense4, expense5));
  }

  @Test
  void test_return_every_unrefunded_expenses_ok() {
    List<Expense> expectedList = Collections.singletonList(expense1);
    assertEquals(expectedList, expenseDAO.getPendingRefunds());
  }

  @Test
  void test_return_total_recurring_amount_ok() {
    assertEquals(100, expenseDAO.getTotalRecurringAmount());
  }

  @Test
  void test_return_high_label_expenses_ok() {
    List<String> expectedList = Arrays.asList("Beer", "Gas");
    assertEquals(expectedList, expenseDAO.getHighLabelExpenses());
  }

  @Test
  void test_return_total_expenses_by_month_ok() {
    Map<String, Double> expectedMap = new java.util.HashMap<>();
    expectedMap.put("2025-08", 566.0);
    expectedMap.put("2025-07", 13000100.0);
    assertEquals(expectedMap, expenseDAO.groupTotalByMonth());
  }
}
