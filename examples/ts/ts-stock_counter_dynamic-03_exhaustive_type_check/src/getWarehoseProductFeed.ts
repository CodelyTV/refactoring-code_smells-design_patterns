import {Feed} from "./Feed";
import fs from "fs";
import {ContentType} from "./ContentType";

export function getWarehouseProductFeed(): Feed {
    if (true) {
        const content = fs.readFileSync(__dirname + '/data/warehouse-stock.csv').toString();
        return new Feed(content, ContentType.Csv)
    } else {
        const content = fs.readFileSync(__dirname + '/data/warehouse-stock.json').toString();
        return new Feed(content, ContentType.Json)
    }
}