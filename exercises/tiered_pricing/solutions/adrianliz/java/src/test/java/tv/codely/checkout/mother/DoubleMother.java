package tv.codely.checkout.mother;

public final class DoubleMother {

    public static double randomBetween(final int min, final int max) {
        return MotherCreator.random().number().randomDouble(2, min, max);
    }
}
