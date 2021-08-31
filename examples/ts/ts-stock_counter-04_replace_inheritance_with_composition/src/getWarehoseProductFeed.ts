import {Feed} from "./Feed";
import fs from "fs";

export function readCsvFeed(): Feed {
    return new Feed(fs.readFileSync(__dirname + '/data/warehouse-stock.csv').toString());
}

export function readJsonFeed(): Feed {
    return new Feed(fs.readFileSync(__dirname + '/data/warehouse-stock.json').toString());
}