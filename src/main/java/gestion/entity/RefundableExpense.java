package gestion.entity;

import java.time.LocalDate;

public class RefundableExpense extends Expense{
    private boolean refunded;


    public RefundableExpense(String name, double amount, LocalDate date, ExpenseType type, boolean refunded) {
        super(name, amount, date, type);
        this.refunded = refunded;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void refund(){
        this.refunded = true;
    }

    @Override
    public String toString() {
        if(refunded){
            return super.toString() + "RefundableExpense{" + "refunded= REMBOURSÉ}";
        }
        return super.toString() + "RefundableExpense{" + "refunded= NON REMBOURSÉ";
    }
}
