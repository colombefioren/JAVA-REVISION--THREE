package gestion.entity;

import java.time.LocalDate;

public class Expense {
    protected final  String name;
    protected final double amount;
    protected final LocalDate date;
    protected final ExpenseType type;

    public Expense(String name, double amount, LocalDate date, ExpenseType type) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public ExpenseType getType() {
        return type;
    }

    public boolean isLargeExpense(){
        return amount > 200;
    }

    public String getYearMonth(){
        String year = date.getYear() + "";
        String month = date.getMonthValue() + "";
        if(month.length() == 1){
            month = "0" + month;
        }
        return year + "-" + month;
    }

    @Override
    public String toString() {
        return "Expense{" + "name=" + name + ", amount=" + amount + ", date=" + date + ", type=" + type + '}';
    }
}
