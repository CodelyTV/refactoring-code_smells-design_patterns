import {MySqlUserRepository} from "./MySqlUserRepository";
import {UsersSearcher}       from "./UsersSearcher";
import {MySqlConfig}         from "./MySqlConfig";

export class Container {
    Mysql = require('sync-mysql');
    
    mysqlConfig     = new MySqlConfig();
    mySqlConnection = new this.Mysql({
        host:     this.mysqlConfig.host,
        user:     this.mysqlConfig.user,
        password: this.mysqlConfig.password,
        database: this.mysqlConfig.database,
        port:     this.mysqlConfig.port
    });
    
    mysqlUserRepository = new MySqlUserRepository(this.mySqlConnection);
    usersSearcher       = new UsersSearcher(this.mysqlUserRepository);
}
