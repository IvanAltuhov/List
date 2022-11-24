import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> purchases = new ArrayList<>();

        while (true){
            System.out.println("Viberite operaciu: ");

            String operation = scanner.next();

            switch (operation) {
                case ("1") : {
                    System.out.println("Vvedite pokupku ");
                    purchases.add(scanner.next());
                    break;
                }
                case ("2") : {
                    showPurchases(purchases);
                    break;
                }
                case ("3") : {
                    showPurchases(purchases);
                    System.out.println("Kakuy xotite udalit? Vvedite nomer ili nazvanie ");
                    String deleteValue = scanner.next();
                    if(isNumber(deleteValue)){
                        int index = Integer.parseInt(deleteValue);
                        purchases.remove(--index);
                    }
                    purchases.remove(deleteValue);
                    break;
                }
                default: {
                    flag = false;
                }
            }
        }
    }

    private static boolean isNumber(String value) {
        return Pattern.compile("^\\d+$").matcher(value).find();
    }

    private static void showPurchases(ArrayList<String> purchases) {
        int count = 1;
        System.out.println("Spisok pokupok: ");
        for (String purchase: purchases) {
            System.out.println((count++) + ". " + purchase);
        }
    }
}
