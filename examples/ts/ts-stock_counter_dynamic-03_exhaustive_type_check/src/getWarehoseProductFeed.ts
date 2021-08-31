import {Feed} from "./Feed";
import fs from "fs";

export function getWarehouseProductFeed(): Feed {
    let content: string;
    let contentType: string;
    if (true) {
        content = fs.readFileSync(__dirname + '/data/warehouse-stock.csv').toString();
        contentType = 'text/csv';
    } else {
        content = fs.readFileSync(__dirname + '/data/warehouse-stock.json').toString();
        contentType = 'application/json';
    }
    return new Feed(content, contentType)
}