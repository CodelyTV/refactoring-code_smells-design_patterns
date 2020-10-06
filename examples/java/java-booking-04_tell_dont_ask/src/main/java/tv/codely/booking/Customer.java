package tv.codely.booking;

public final class Customer {
    private final CustomerId   id;
    private final CustomerName name;
    private final EmailAddress emailAddress;

    public Customer(CustomerId id, CustomerName name, EmailAddress emailAddress) {
        this.id           = id;
        this.name         = name;
        this.emailAddress = emailAddress;
    }
}
