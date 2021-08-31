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
} else if (feed.contentType === 'application/json') {
    parser = new FeedParserJson();
} else {
    throw Error('Unknown content type');
}

feedStockCounter = new FeedStockCounter(parser);
totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);