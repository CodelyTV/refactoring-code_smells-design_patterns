const mysqlHost     = "localhost";
const mysqlUser     = "root";
const mysqlPassword = "";
const mysqlDatabase = "super_project";
const mysqlPort     = 3306;

const Mysql      = require('sync-mysql');
const connection = new Mysql({
    host: mysqlHost,
    user: mysqlUser,
    password: mysqlPassword,
    database: mysqlDatabase,
    port: mysqlPort
});

const users = connection.query('SELECT * FROM users')

console.log(users)
