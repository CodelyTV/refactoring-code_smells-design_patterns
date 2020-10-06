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

    public CustomerId id() {
        return id;
    }

    public CustomerName name() {
        return name;
    }

    public EmailAddress emailAddress() {
        return emailAddress;
    }
}
