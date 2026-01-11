package polymorphism;

public class AccountMain {

	public static void main(String[] args) {
    Account acc = new Account();
   /* acc.accNum=101;
    acc.name="Vamshi";
    acc.balance=20000.00; */
       acc.setAccNum(101);
       int accountNumber=acc.getAccNum();
       System.out.println(accountNumber);
       acc.setName("Vamshi");
       System.out.println(acc.getName());
       acc.setBalance(10000);
       System.out.println(acc.getBalance());
	}

}
