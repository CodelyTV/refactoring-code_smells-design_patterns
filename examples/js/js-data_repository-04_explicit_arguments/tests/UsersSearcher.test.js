import {FakeUserRepository} from "./FakeUserRepository";
import {UsersSearcher}      from "../src/UsersSearcher";

describe('UsersSearcher should', () => {
    it('search all existing users', () => {
        const existingUsers = [{"name": "javi"}, {"name": "rafa"}];
        
        const repository = new FakeUserRepository(existingUsers);
        const searcher   = new UsersSearcher(repository);
        
        expect(searcher.searchAll()).toBe(existingUsers);
    });
});
