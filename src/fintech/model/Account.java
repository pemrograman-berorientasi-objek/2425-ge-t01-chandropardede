package fintech.model;
import java.util.HashMap;
import java.util.Map;
/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Account {
    private static Map<String, Account> accounts = new HashMap<>();
    private final String owner;
    private final String name;
    private double balance = 0.0;

    public Account(String _owner, String _name) {
        this.owner = _owner;
        this.name = _name;
        accounts.put(_owner + "|" + _name, this);
    }

    public String getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return balance;
    }

    public Transaction offer(Transaction _transaction){
        this.balance+=_transaction.getAmount();

        return _transaction;
    }
    public void withdraw(double _amount) throws Exception {
        if (_amount > this.balance) {
            throw new Exception("Insufficient balance");
        }
        this.balance -= _amount;
    }
    public static void deleteAccount(String _owner, String _name) throws Exception {
        String key = _owner + "|" + _name;
        if (accounts.containsKey(key)) {
            accounts.remove(key);
        } else{
            throw new Exception("Account not found");
        }
        
    }
    public static void showall(){
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    @Override
    public String toString() {
        return this.name + "|" + this.owner + "|" + this.balance;
    }

}