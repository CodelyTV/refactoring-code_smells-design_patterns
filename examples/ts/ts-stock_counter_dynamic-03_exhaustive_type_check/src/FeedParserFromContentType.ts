import {FeedParserCsv} from "./FeedParserCsv";
import {FeedParserJson} from "./FeedParserJson";
import {FeedParser} from "./FeedParser";
import {ContentType} from "./ContentType";

export class FeedParserFromContentType {
    get(contentType: ContentType): FeedParser {
        switch (contentType) {
            case ContentType.Csv:
                return new FeedParserCsv();
            case ContentType.Json:
                return new FeedParserJson();
            default:
                const _exhaustiveCheck: never = contentType;
                return _exhaustiveCheck;
        }
    }
}