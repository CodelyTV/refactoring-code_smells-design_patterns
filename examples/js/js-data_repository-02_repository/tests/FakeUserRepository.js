export class FakeUserRepository {
    constructor(users) {
        this.users = users;
    }

    searchAll() {
        return this.users;
    }
}
