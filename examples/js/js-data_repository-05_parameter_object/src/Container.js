import {MySqlUserRepository} from "./MySqlUserRepository";
import {UsersSearcher}       from "./UsersSearcher";
import {MySqlConfig}         from "./MySqlConfig";

export class Container {
    mysqlConfig         = new MySqlConfig();
    mysqlUserRepository = new MySqlUserRepository(this.mysqlConfig);
    usersSearcher       = new UsersSearcher(this.mysqlUserRepository);
}
