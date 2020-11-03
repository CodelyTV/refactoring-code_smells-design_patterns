package tv.codely.student_grades;

public final class Pair<FirstType, SecondType> {
    final private FirstType first;
    final private SecondType second;

    public Pair(FirstType first, SecondType second) {
        this.first  = first;
        this.second = second;
    }

    public FirstType first() {
        return first;
    }

    public SecondType second() {
        return second;
    }
}
