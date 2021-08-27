export class Flower {
    constructor(
        private id: number,
        private name: string,
        private stock: number
    ) {
    }

    totalStock(): number {
        return this.stock;
    }
}