package cryptotest;

/**
 *
 * @author josborne
 */
public class CryptoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Open new account with $1000");
        CryptoAcct account1 = new CryptoAcct(1000.00);
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=1000.0, cryptoBalance=0.0}");

        System.out.println("\nBuy $750 worth of crypto");
        account1.buyCrypto(750);
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=250.0, cryptoBalance=0.75}");

        System.out.println("\nTry to withdraw more than you've got.");
        boolean tryBadWithdraw = account1.withdrawCash(1000);
        System.out.println("Class response:   " + tryBadWithdraw);
        System.out.println("Correct response: false");
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=250.0, cryptoBalance=0.75}");

        System.out.println("\nTry to buy more crypto than cash on hand.");
        boolean tryBadBuy = account1.buyCrypto(1000);
        System.out.println("Class response:   " + tryBadBuy);
        System.out.println("Correct response: false");
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=250.0, cryptoBalance=0.75}");

        System.out.println("\nSell half the crypto in account.");
        boolean tryHalfSell = account1.sellCrypto(account1.getCryptoBalance() / 2);
        System.out.println("Class response:   " + tryHalfSell);
        System.out.println("Correct response: true");
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=625.0, cryptoBalance=0.375}");

        System.out.println("\nDeposit $250");
        account1.depositCash(250);
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=875.0, cryptoBalance=0.375}");

        System.out.println("\nWithdraw $500");
        account1.withdrawCash(500);
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=375.0, cryptoBalance=0.375}");

        System.out.println("\nSell all the crypto");
        boolean SellAll = account1.sellCrypto(account1.getCryptoBalance());
        System.out.println("Class response:   " + SellAll);
        System.out.println("Correct response: true");
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=750.0, cryptoBalance=0.0}");

        System.out.println("\nClose the account");
        boolean cashOut = account1.withdrawCash(account1.getCashBalance());
        System.out.println("Class response:   " + cashOut);
        System.out.println("Correct response: true");
        System.out.println("Class response:   " + account1.toString());
        System.out.println("Correct response: CryptoAcct{cashBalance=0.0, cryptoBalance=0.0}");
    }
}
