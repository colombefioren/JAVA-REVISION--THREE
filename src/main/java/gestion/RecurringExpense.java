package gestion;

import java.time.LocalDate;

public class RecurringExpense extends Expense {
    private final Recurrence recurrence;
    private final int durationInMonths;


    public RecurringExpense(String name, double amount, LocalDate date, ExpenseType type,Recurrence recurrence, int durationInMonths) {
        super(name, amount, date, type);
        this.durationInMonths = durationInMonths;
        this.recurrence = recurrence;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    @Override
    public String toString() {
        return super.toString() + "RecurringExpense{" + "recurrence=" + recurrence + ", durationInMonths=" + durationInMonths + '}';
    }
}
