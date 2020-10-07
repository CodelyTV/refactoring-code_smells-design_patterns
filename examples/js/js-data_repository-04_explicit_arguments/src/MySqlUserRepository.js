export class MySqlUserRepository {
    constructor(mysqlHost, mysqlUser, mysqlPassword, mysqlDatabase, mysqlPort) {
        const Mysql     = require('sync-mysql');
        this.connection = new Mysql({
            host: mysqlHost,
            user: mysqlUser,
            password: mysqlPassword,
            database: mysqlDatabase,
            port: mysqlPort
        });
    }

    searchAll() {
        return this.connection.query('SELECT * FROM users');
    }
}
