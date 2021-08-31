import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";

const feed = getWarehouseProductFeed();

let totalStock: number

if (feed.contentType === 'text/csv') {
    const feedStockCounter = new FeedStockCounter(new FeedParserCsv());
    totalStock = feedStockCounter.totalStock(feed);
} else if (feed.contentType === 'application/json') {
    const feedStockCounter = new FeedStockCounter(new FeedParserJson());
    totalStock = feedStockCounter.totalStock(feed);
} else {
    throw Error('Unknown content type');
}

console.log(totalStock);