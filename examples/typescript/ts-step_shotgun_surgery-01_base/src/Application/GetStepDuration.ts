import StepId from '../Domain/StepId'
import StepRepository from '../Domain/StepRepository'

class GetStepDuration {
    constructor(private repository: StepRepository) {
    }

    execute(stepId: string): number {
        const step = this.repository.find(new StepId(stepId))
        return step.getVideoDuration()
    }
}

export default GetStepDuration