import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";

export class FeedStockCounterCsv extends FeedStockCounter {
    protected buildParser() {
        return new FeedParserCsv();
    }
}