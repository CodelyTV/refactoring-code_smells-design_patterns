package tv.codely.checkout.mother;

public final class IntegerMother {

    public static int random() {
        return MotherCreator.random().number().randomDigitNotZero();
    }

    public static int randomBetween(final int min, final int max) {
        return MotherCreator.random().number().numberBetween(min, max);
    }
}
