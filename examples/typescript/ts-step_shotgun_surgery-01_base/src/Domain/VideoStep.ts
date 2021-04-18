import StepId from "./StepId";
import Step from "./Step";
import {STEP_TYPE_VIDEO} from "./StepEnums";

class VideoStep extends Step {
    constructor(
        stepId: StepId,
        private videoDuration: number
    ) {
        super(stepId)
    }

    type(): string {
        return STEP_TYPE_VIDEO
    }

    getVideoDuration(): number {
        return this.videoDuration
    }
}

export default VideoStep