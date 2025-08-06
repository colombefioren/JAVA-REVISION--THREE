package gestion;

import java.time.LocalDate;

public class ApprovalExpense extends Expense {
    private boolean approved;

    public ApprovalExpense(String name, double amount, LocalDate date, ExpenseType type, boolean approved) {
        super(name, amount, date, type);
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve(){
        this.approved = true;
    }
}
