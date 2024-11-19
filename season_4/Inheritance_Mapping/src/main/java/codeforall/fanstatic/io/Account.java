package codeforall.fanstatic.io;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractModel {
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private Double balance;
}
