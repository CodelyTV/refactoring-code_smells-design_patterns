export class MySqlUserRepository {
    constructor(container) {
        const Mysql     = require('sync-mysql');
        this.connection = new Mysql({
            host: container.mysqlHost,
            user: container.mysqlUser,
            password: container.mysqlPassword,
            database: container.mysqlDatabase,
            port: container.mysqlPort
        });
    }

    searchAll() {
        return this.connection.query('SELECT * FROM users');
    }
}
