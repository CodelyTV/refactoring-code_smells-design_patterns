import {Flower} from "./Flower";

export class FeedStockCounter {
    protected countTotalStock(flowers: Flower[]) {
        return flowers.reduce((acc, flower) => {
            return acc + flower.totalStock();
        }, 0);
    }
}