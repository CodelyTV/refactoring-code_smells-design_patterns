import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";
import {FeedParser} from "./FeedParser";

const feed = getWarehouseProductFeed();

let totalStock: number;
let feedStockCounter: FeedStockCounter;
let parser: FeedParser;

if (feed.contentType === 'text/csv') {
    parser = new FeedParserCsv();
    feedStockCounter = new FeedStockCounter(parser);
} else if (feed.contentType === 'application/json') {
    parser = new FeedParserJson();
    feedStockCounter = new FeedStockCounter(parser);
} else {
    throw Error('Unknown content type');
}

totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);