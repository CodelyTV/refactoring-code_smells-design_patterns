import {getWarehouseProductFeed} from "./getWarehoseProductFeed";
import {FeedStockCounter} from "./FeedStockCounter";
import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";
import {FeedParser} from "./FeedParser";
import {FeedParserFromContentType} from "./FeedParserFromContentType";

const feed = getWarehouseProductFeed();

let contentType = feed.contentType;
const feedParserFromContentType = new FeedParserFromContentType();
const parser = feedParserFromContentType.get(contentType);
const feedStockCounter = new FeedStockCounter(parser);
const totalStock = feedStockCounter.totalStock(feed);

console.log(totalStock);