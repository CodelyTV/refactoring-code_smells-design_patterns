import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";

const feed = getWarehouseProductFeed();

let totalStock: number;
let feedStockCounter: FeedStockCounter;

if (feed.contentType === 'text/csv') {
    feedStockCounter = new FeedStockCounter(new FeedParserCsv());
} else if (feed.contentType === 'application/json') {
    feedStockCounter = new FeedStockCounter(new FeedParserJson());
} else {
    throw Error('Unknown content type');
}

totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);