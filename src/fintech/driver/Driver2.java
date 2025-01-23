package fintech.driver;
import java.util.Scanner;

import fintech.model.Account;
import fintech.model.Transaction;
/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Driver2 {

    public static void main(String[] _args) {
        String owner;
        String name;
        Account account;
//       Scanner scanner = new Scanner(System.in);
        

        while(true){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            owner = scanner.nextLine();
            name = scanner.nextLine();
            if (command.equalsIgnoreCase("create-account")) {
                if (!scanner.hasNextLine()) break;
                owner = scanner.nextLine();
                name = scanner.nextLine();
                account = new Account(owner, name);
                System.out.println(account);
                System.out.println("Account created successfully.");
            } else if (command.equalsIgnoreCase("create-transaction")) {
                try {
                    owner = scanner.nextLine();
                    name = scanner.nextLine();
                    account = new Account(owner, name);
                    String amount = scanner.nextLine();
                    String postedAt = scanner.nextLine();
                    String note = scanner.nextLine();
                    Transaction transaction = new Transaction(account, Double.parseDouble(amount), postedAt, note);
                    System.out.println(transaction);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                
            } else if (command.equalsIgnoreCase("delete-account")) {
                try {
                    owner = scanner.nextLine();
                    name = scanner.nextLine();
                    Account.deleteAccount(owner, name);
                    System.out.println("Account deleted successfully.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equalsIgnoreCase("show-all")) {
                try {
                    Account.showall();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
            scanner.close();
            break;
        }
        }
        //scanner.close();
        
        

    }

}