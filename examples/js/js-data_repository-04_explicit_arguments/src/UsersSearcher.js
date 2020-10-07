export class UsersSearcher {
    constructor(repository) {
        this.repository = repository;
    }

    searchAll() {
        return this.repository.searchAll();
    }
}
