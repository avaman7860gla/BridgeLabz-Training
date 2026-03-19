package M1_Practice_Problem;

import java.util.*;

class Transaction {
    String type;
    int amount;
    int remainingLimit;

    public Transaction(String type, int amount, int remainingLimit) {
        this.type=type;
        this.amount=amount;
        this.remainingLimit=remainingLimit;
    }
}

class CreditCard {
    String cardNumber;
    String cardHolderName;
    int creditLimit;
    int availableLimit;
    List<Transaction> transactions=new ArrayList<>();

    public CreditCard(String cardNumber, String cardHolderName, int creditLimit) {
        this.cardNumber=cardNumber;
        this.cardHolderName=cardHolderName;
        this.creditLimit=creditLimit;
    }
}

class CreditCardSystem {
    Map<String, CreditCard> cardMap = new HashMap<>();

    public int issueCard(String cardNumber, String holderName, int creditLimit) {
        if(!cardMap.containsKey(cardNumber)){
            CreditCard card=new CreditCard(cardNumber, holderName, creditLimit);
            card.availableLimit=creditLimit;
            cardMap.put(cardNumber, card);
        }
        return 0;
    }

    public int spendAmount(String cardNumber, int amount) {
        if(cardMap.containsKey(cardNumber)){
            CreditCard card=cardMap.get(cardNumber);
            if(amount<=card.availableLimit){
                card.availableLimit-=amount;
                Transaction t=new Transaction("SPEND", amount, card.availableLimit);
                card.transactions.add(t);
                System.out.println("SPENT "+cardNumber+" "+card.availableLimit);
            }
            else{
                System.out.println("Transaction declined");
            }
        }
        else{
            System.out.println("Transaction declined");
        }
        return 0;
    }

    public int makePayment(String cardNumber, int amount) {
        if(cardMap.containsKey(cardNumber)){
            CreditCard card=cardMap.get(cardNumber);
            card.availableLimit+=amount;
            if(card.availableLimit>card.creditLimit) {
                card.availableLimit = card.creditLimit;
            }

            Transaction t=new Transaction("PAYMENT", amount, card.availableLimit);
            card.transactions.add(t);
            System.out.println("PAYMENT DONE "+cardNumber+" "+card.availableLimit);
            }
        else{
            System.out.println("Card not found");
        }
        return 0;
    }

    public void getCardsByHolder(String holderName) {
        List<CreditCard> list=new ArrayList<>();

        for(CreditCard card: cardMap.values()){
            if(card.cardHolderName.equals(holderName)){
                list.add(card);
            }
        }

        if(list.isEmpty()){
            System.out.println("No cards found");
            return;
        }

        Collections.sort(list, (a,b)->a.cardNumber.compareTo(b.cardNumber));

        for(CreditCard card:list){
            System.out.println(card.cardNumber+" "+card.availableLimit);
        }
    }
}

public class CreditCardAccountManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreditCardSystem system = new CreditCardSystem();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "ISSUE":{
                    String cardNumber=parts[1];
                    String cardHolderName=parts[2];
                    int creditLimit=Integer.parseInt(parts[3]);
                    system.issueCard(cardNumber, cardHolderName, creditLimit);
                    break;
                }

                case "SPEND":{
                    String cardNumber=parts[1];
                    int amount=Integer.parseInt(parts[2]);
                    system.spendAmount(cardNumber, amount);
                    break;
                }

                case "PAYMENT":{
                    String cardNumber=parts[1];
                    int amount=Integer.parseInt(parts[2]);
                    system.makePayment(cardNumber, amount);
                    break;
                }

                case "HOLDER":{
                    String cardHolderName=parts[1];
                    system.getCardsByHolder(cardHolderName);
                    break;
                }
            }
        }
    }
}