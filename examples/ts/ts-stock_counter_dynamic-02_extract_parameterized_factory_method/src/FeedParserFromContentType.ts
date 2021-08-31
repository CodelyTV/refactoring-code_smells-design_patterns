import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";
import {FeedParser} from "./FeedParser";

export class FeedParserFromContentType {
    get(contentType: string): FeedParser {
        if (contentType === 'text/csv') {
            return new FeedParserCsv();
        } else if (contentType === 'application/json') {
            return new FeedParserJson();
        } else {
            throw Error('Unknown content type');
        }
    }
}