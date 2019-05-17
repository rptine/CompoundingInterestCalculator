
public class Money {
    public static void main(String[] args) {
        Double x = 33.5234532;
        System.out.println(roundMoney(x));
    }
    public static String roundMoney(Double MoneyVal) {
        String MoneyValString = MoneyVal.toString();
        int index = MoneyValString.indexOf('.');
        return MoneyValString.substring(0,index+3);

    }

}
