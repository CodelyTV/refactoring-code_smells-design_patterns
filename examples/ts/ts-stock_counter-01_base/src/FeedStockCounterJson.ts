import {Feed} from "./Feed";
import {Flower} from "./Flower";

export class FeedStockCounterJson {
    totalStock(feed: Feed): number {
        const items = JSON.parse(feed.content);
        const flowers = items.map(item => {
            return new Flower(parseInt(item["id"]), item["name"], parseInt(item["stock"]));
        })

        const totalStock = flowers.reduce((acc, flower) => {
            return acc + flower.totalStock();
        }, 0)

        return totalStock;
    }
}