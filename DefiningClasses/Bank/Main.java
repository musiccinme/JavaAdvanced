package DefiningClasses.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accountMap = new HashMap<>();
        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("End")){
            String command = input[0];
            if(command.equals("Create")){
                BankAccount bankAccount = new BankAccount();
                accountMap.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());
            }else if(command.equals("Deposit")){
                int currentID = Integer.parseInt(input[1]);
                if(accountMap.containsKey(currentID)){
                    double depositToAdd = Double.parseDouble(input[2]);
                    accountMap.get(currentID).deposit(depositToAdd);
                    System.out.printf("Deposited %.0f to ID%d%n", depositToAdd, currentID);
                }else {
                    System.out.println("Account does not exist");
                }
            }else if(command.equals("GetInterest")){
                int currentID = Integer.parseInt(input[1]);
                int years = Integer.parseInt(input[2]);
                if(accountMap.containsKey(currentID)){
                    System.out.printf("%.2f%n", accountMap.get(currentID).getInterest(years));
                }else {
                    System.out.println("Account does not exist");
                }
            }else if(command.equals("SetInterest")){
                double newInterest = Double.parseDouble(input[1]);
                BankAccount.setInterest(newInterest);
            }

            input = scanner.nextLine().split("\\s+");
        }
    }
}
