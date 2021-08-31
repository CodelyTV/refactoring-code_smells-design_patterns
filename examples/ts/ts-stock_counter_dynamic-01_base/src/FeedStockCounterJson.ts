import {FeedParserJson} from "./FeedParserJson";
import {Feed} from "./Feed";
import {FeedStockCounter} from "./FeedStockCounter";

export class FeedStockCounterJson {
    totalStock(feed: Feed): number {
        return new FeedStockCounter(new FeedParserJson()).totalStock(feed)
    }
}