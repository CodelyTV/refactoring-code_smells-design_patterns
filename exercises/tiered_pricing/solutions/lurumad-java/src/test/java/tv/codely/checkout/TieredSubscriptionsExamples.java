package tv.codely.checkout;

public class TieredSubscriptionsExamples {
    public static Subscriptions tierOne(){
        return Subscriptions.by(random(1,2));
    }

    public static Subscriptions tierTwo(){
        return Subscriptions.by(random(3,10));
    }

    public static Subscriptions tierThree(){
        return Subscriptions.by(random(11,25));
    }

    public static Subscriptions tierFour(){
        return Subscriptions.by(random(26,50));
    }

    public static Subscriptions tierFive(){
        return Subscriptions.by(random(51,100));
    }

    private static int random(int min, int max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}
