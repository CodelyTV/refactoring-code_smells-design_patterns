import {ContentType} from "./ContentType";

export class Feed {
    constructor(
        readonly content: string,
        readonly contentType: ContentType
    ) {
    }
}