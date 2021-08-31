import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserJson} from "./FeedParserJson";

export class FeedStockCounterJson extends FeedStockCounter {
    protected buildParser() {
        return new FeedParserJson();
    }
}