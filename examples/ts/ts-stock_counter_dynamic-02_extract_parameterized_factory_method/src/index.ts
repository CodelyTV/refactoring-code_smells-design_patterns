import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserFromContentType} from "./FeedParserFromContentType";

const feed = getWarehouseProductFeed();

const feedParserFromContentType = new FeedParserFromContentType();
const parser = feedParserFromContentType.get(feed.contentType);
const feedStockCounter = new FeedStockCounter(parser);
const totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);