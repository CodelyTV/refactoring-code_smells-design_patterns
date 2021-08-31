import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";

const feed = getWarehouseProductFeed();

let totalStock: number;
let feedStockCounter: FeedStockCounter;

if (feed.contentType === 'text/csv') {
    let parser = new FeedParserCsv();
    feedStockCounter = new FeedStockCounter(parser);
} else if (feed.contentType === 'application/json') {
    let parser = new FeedParserJson();
    feedStockCounter = new FeedStockCounter(parser);
} else {
    throw Error('Unknown content type');
}

totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);