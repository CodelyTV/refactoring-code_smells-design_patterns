export class MySqlUserRepository {
    constructor(config) {
        const Mysql     = require('sync-mysql');
        this.connection = new Mysql({
            host: config.host,
            user: config.user,
            password: config.password,
            database: config.database,
            port: config.port
        });
    }

    searchAll() {
        return this.connection.query('SELECT * FROM users');
    }
}
