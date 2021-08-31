import {Flower} from "./Flower";
import {Feed} from "./Feed";
import {FeedParser} from "./FeedParser";

export class FeedStockCounter {
    constructor(private parser: FeedParser) {
    }

    totalStock(feed: Feed): number {
        const flowers = this.parser.parse(feed);
        return this.countTotalStock(flowers);
    }

    private countTotalStock(flowers: Flower[]): number {
        return flowers.reduce((acc, flower) => {
            return acc + flower.totalStock();
        }, 0);
    }
}