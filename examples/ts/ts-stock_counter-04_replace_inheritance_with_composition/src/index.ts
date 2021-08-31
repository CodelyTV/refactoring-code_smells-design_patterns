import {FeedStockCounterCsv} from "./FeedStockCounterCsv";
import {FeedStockCounterJson} from "./FeedStockCounterJson";
import {readCsvFeed, readJsonFeed} from "./getWarehoseProductFeed";

// Warehouse A
const feedStockCounterCsv = new FeedStockCounterCsv();
const csvFeed = readCsvFeed();
console.log(feedStockCounterCsv.totalStock(csvFeed));

// Warehouse B
const feedStockCounterJson = new FeedStockCounterJson();
const jsonFeed = readJsonFeed();
console.log(feedStockCounterJson.totalStock(jsonFeed));