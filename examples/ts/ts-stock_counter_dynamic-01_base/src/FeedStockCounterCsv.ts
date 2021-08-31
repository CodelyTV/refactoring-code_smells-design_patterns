import {FeedParserCsv} from "./FeedParserCsv";
import {Feed} from "./Feed";
import {FeedStockCounter} from "./FeedStockCounter";

export class FeedStockCounterCsv {
    totalStock(feed: Feed): number {
        return new FeedStockCounter(new FeedParserCsv()).totalStock(feed)
    }
}