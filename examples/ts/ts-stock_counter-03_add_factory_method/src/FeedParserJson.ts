import {FeedParser} from "./FeedParser";
import {Flower} from "./Flower";
import {Feed} from "./Feed";

export class FeedParserJson implements FeedParser {
    parse(feed: Feed): Array<Flower> {
        const items = JSON.parse(feed.content);
        return items.map(item => {
            return new Flower(parseInt(item["id"]), item["name"], parseInt(item["stock"]));
        });
    }
}