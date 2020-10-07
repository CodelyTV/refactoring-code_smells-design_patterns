import {MySqlUserRepository} from "./MySqlUserRepository";
import {UsersSearcher}       from "./UsersSearcher";

export class Container {
    mysqlHost     = "localhost";
    mysqlUser     = "root";
    mysqlPassword = "";
    mysqlDatabase = "super_project";
    mysqlPort     = 3306;

    mysqlUserRepository = new MySqlUserRepository(
        this.mysqlHost,
        this.mysqlUser,
        this.mysqlPassword,
        this.mysqlDatabase,
        this.mysqlPort
    );
    usersSearcher       = new UsersSearcher(this.mysqlUserRepository);
}
