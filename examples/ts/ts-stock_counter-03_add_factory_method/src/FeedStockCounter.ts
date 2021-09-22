import {Flower} from "./Flower";
import {Feed} from "./Feed";
import {FeedParser} from "./FeedParser";

export abstract class FeedStockCounter {
    totalStock(feed: Feed): number {
        const flowers = this.buildParser().parse(feed);
        return this.countTotalStock(flowers);
    }

    private countTotalStock(flowers: Flower[]): number {
        return flowers.reduce((acc, flower) => {
            return acc + flower.totalStock();
        }, 0);
    }

    protected abstract buildParser(): FeedParser;
}