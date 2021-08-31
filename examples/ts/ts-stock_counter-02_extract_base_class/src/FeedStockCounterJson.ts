import {Feed} from "./Feed";
import {Flower} from "./Flower";
import {FeedStockCounter} from "./FeedStockCounter";

export class FeedStockCounterJson extends FeedStockCounter {
    totalStock(feed: Feed): number {
        const flowers = this.parseJsonFeed(feed);
        return this.countTotalStock(flowers);
    }

    private parseJsonFeed(feed: Feed): Array<Flower> {
        const items = JSON.parse(feed.content);
        return items.map(item => {
            return new Flower(parseInt(item["id"]), item["name"], parseInt(item["stock"]));
        });
    }
}