export class MySqlUserRepository {
    constructor(connection) {
        this.connection = connection;
    }

    searchAll() {
        return this.connection.query('SELECT * FROM users');
    }
}
