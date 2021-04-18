import StepId from '../Domain/StepId'
import StepRepository from '../Domain/StepRepository'
import VideoStep from "../Domain/VideoStep";

class GetStepDuration {
    constructor(private repository: StepRepository) {
    }

    execute(stepId: string): number {
        const step = this.repository.find(new StepId(stepId))
        return step instanceof VideoStep ?
            step.getVideoDuration() :
            step.totalQuestions;
    }
}

export default GetStepDuration