import StepId from "./StepId";

class Step {
    constructor(
        private id: StepId,
        private videoDuration: number
    ) {}

    type(): string {
        return 'video'
    }

    getVideoDuration(): number {
        return this.videoDuration
    }
}

export default Step