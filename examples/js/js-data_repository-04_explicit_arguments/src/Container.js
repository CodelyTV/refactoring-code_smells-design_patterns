import {MySqlUserRepository} from "./MySqlUserRepository";
import {UsersSearcher}       from "./UsersSearcher";

export class Container {
    mysqlHost     = "localhost";
    mysqlUser     = "root";
    mysqlPassword = "";
    mysqlDatabase = "super_project";
    mysqlPort     = 3306;

    mysqlUserRepository = new MySqlUserRepository(this);
    usersSearcher       = new UsersSearcher(this.mysqlUserRepository);
}
