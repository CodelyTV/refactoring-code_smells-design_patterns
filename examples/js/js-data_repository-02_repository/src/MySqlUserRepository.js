export class MySqlUserRepository {
    mysqlHost     = "localhost";
    mysqlUser     = "root";
    mysqlPassword = "";
    mysqlDatabase = "super_project";
    mysqlPort     = 3306;

    constructor() {
        const Mysql     = require('sync-mysql');
        this.connection = new Mysql({
            host: this.mysqlHost,
            user: this.mysqlUser,
            password: this.mysqlPassword,
            database: this.mysqlDatabase,
            port: this.mysqlPort
        });
    }

    searchAll() {
        return this.connection.query('SELECT * FROM users');
    }
}
