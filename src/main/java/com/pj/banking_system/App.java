package com.pj.banking_system;

import com.pj.banking_system.imp.HibernateAccountDao;
import com.pj.banking_system.imp.HibernateCustomerDao;
import com.pj.banking_system.model.Account;
import com.pj.banking_system.model.Customer;
import com.pj.banking_system.service.BankingService;
import com.pj.banking_system.model.GovernmentIdType;


import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HibernateCustomerDao custDao = new HibernateCustomerDao();
        HibernateAccountDao accDao = new HibernateAccountDao();
        BankingService service = new BankingService();

        System.out.println("========== ONLINE BANKING SYSTEM ==========");

        for (;;) {      // no while loop
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Funds");
            System.out.println("6. View Account Details");
            System.out.println("7. Find Account ID by Account Number");
            System.out.println("8. Exit");
            System.out.print("Enter option: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

            case 1: {
                System.out.print("Enter customer name  : ");
                String name = sc.nextLine();

                System.out.print("Enter customer email  : ");
                String email = sc.nextLine();

                System.out.print("Enter phone number  : ");
                String phone = sc.nextLine();

                System.out.print("Enter address  : ");
                String address = sc.nextLine();

                System.out.println("Select Government ID Type  : ");
                System.out.println("1. PAN");
                System.out.println("2. AADHAAR");
                System.out.println("3. DRIVING LICENSE");
                System.out.print("Enter choice (1-3): ");
                int idChoice = sc.nextInt();
                sc.nextLine();   // consume \n

                GovernmentIdType idType;
                if (idChoice == 1)       idType = GovernmentIdType.PAN;
                else if (idChoice == 2)  idType = GovernmentIdType.AADHAAR;
                else                     idType = GovernmentIdType.DRIVING_LICENSE;

                System.out.print("Enter selected ID Number   : ");
                String idNumber = sc.nextLine();

                Customer c = new Customer(
                        name,
                        email,
                        phone,
                        address,
                        idType,
                        idNumber
                );

                custDao.save(c);
                System.out.println("Customer created with ID: " + c.getId());
                break;
            }


                case 2: {
                    System.out.print("Enter account number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter customer ID: ");
                    Long cid = sc.nextLong();

                    Optional<Customer> cust = custDao.findById(cid);
                    if (cust.isEmpty()) {
                        System.out.println("❌ Customer not found");
                        break;
                    }

                    Account acc = new Account(accNum, cust.get(), BigDecimal.ZERO);
                    accDao.save(acc);
                    System.out.println("Account created with ID: " + acc.getId());
                    break;
                }

                case 3: {
                    System.out.print("Enter account ID for deposit: ");
                    Long aid = sc.nextLong();
                    System.out.print("Enter amount: ");
                    BigDecimal amt = sc.nextBigDecimal();

                    Optional<Account> account = accDao.findById(aid);
                    if (account.isEmpty()) {
                        System.out.println("❌ Account not found");
                        break;
                    }

                    Account a = account.get();
                    a.setBalance(a.getBalance().add(amt));
                    accDao.save(a);  // using persist-style save
                    System.out.println("✔ Deposit successful. New Balance: " + a.getBalance());
                    break;
                }

                case 4: {
                    System.out.print("Enter account ID for withdrawal: ");
                    Long aid2 = sc.nextLong();
                    System.out.print("Enter amount: ");
                    BigDecimal wamt = sc.nextBigDecimal();

                    Optional<Account> account2 = accDao.findById(aid2);
                    if (account2.isEmpty()) {
                        System.out.println("❌ Account not found");
                        break;
                    }

                    Account a2 = account2.get();
                    if (a2.getBalance().compareTo(wamt) < 0) {
                        System.out.println("❌ Insufficient balance");
                        break;
                    }

                    a2.setBalance(a2.getBalance().subtract(wamt));
                    accDao.save(a2);
                    System.out.println("✔ Withdraw successful. New Balance: " + a2.getBalance());
                    break;
                }

                case 5: {
                    System.out.print("Enter From Account ID: ");
                    Long from = sc.nextLong();
                    System.out.print("Enter To Account ID: ");
                    Long to = sc.nextLong();
                    System.out.print("Enter Amount: ");
                    BigDecimal amt2 = sc.nextBigDecimal();

                    boolean ok = service.transferFunds(from, to, amt2);
                    if (ok) System.out.println("✔ Transfer completed!");
                    else System.out.println("❌ Transfer failed!");
                    break;
                }

                case 6: {
                    System.out.print("Enter account ID: ");
                    Long id = sc.nextLong();

                    Optional<Account> accD = accDao.findById(id);
                    if (accD.isEmpty()) {
                        System.out.println("❌ Account not found");
                        break;
                    }

                    Account a = accD.get();
                    System.out.println("\n--- Account Details ---");
                    System.out.println("ID       : " + a.getId());
                    System.out.println("Number   : " + a.getAccountNumber());
                    System.out.println("Customer : " + a.getCustomer().getName());
                    System.out.println("Balance  : " + a.getBalance());
                    break;
                }
                case 7: {
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.next();
                    Long id = service.findIdByAccountNumber(accNum);
                    System.out.println("Account ID = " + id);
                    break;
                }


                case 8:
                    System.out.println("Thank you for using Online Banking System!");
                    return;

                default:
                    System.out.println("❌ Invalid choice, try again.");
            }
        }
    }
}
