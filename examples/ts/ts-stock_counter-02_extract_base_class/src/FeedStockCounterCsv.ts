import {Feed} from "./Feed";
import {Flower} from "./Flower";
import {FeedStockCounter} from "./FeedStockCounter";

export class FeedStockCounterCsv extends FeedStockCounter {
    totalStock(feed: Feed): number {
        const flowers = this.parseCsvFeed(feed);
        return this.countTotalStock(flowers);
    }

    private parseCsvFeed(feed: Feed): Array<Flower> {
        const rows = feed.content.split('\n').slice(1);
        return rows.map(row => {
            const fields = row.split(',');
            return new Flower(parseInt(fields[0]), fields[1], parseInt(fields[2]));
        });
    }
}