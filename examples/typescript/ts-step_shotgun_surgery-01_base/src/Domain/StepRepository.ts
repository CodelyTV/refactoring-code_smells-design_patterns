import Step from './Step'
import StepId from './StepId'

interface StepRepository {
    find(stepId: StepId): Step
}

export default StepRepository