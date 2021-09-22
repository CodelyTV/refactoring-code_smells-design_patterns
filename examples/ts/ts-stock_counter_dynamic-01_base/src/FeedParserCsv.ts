import {FeedParser} from "./FeedParser";
import {Feed} from "./Feed";
import {Flower} from "./Flower";

export class FeedParserCsv implements FeedParser {
    parse(feed: Feed): Array<Flower> {
        const rows = feed.content.split('\n').slice(1);
        return rows.map(row => {
            const fields = row.split(',');
            return new Flower(parseInt(fields[0]), fields[1], parseInt(fields[2]));
        });
    }
}