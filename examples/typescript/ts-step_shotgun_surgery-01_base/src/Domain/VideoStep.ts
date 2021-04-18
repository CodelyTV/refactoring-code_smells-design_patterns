import StepId from "./StepId";
import Step from "./Step";

class VideoStep extends Step {
    constructor(
        stepId: StepId,
        private videoDuration: number
    ) {
        super(stepId)
    }

    type(): string {
        return 'video'
    }

    getVideoDuration(): number {
        return this.videoDuration
    }
}

export default VideoStep