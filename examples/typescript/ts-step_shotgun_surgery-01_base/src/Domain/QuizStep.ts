import Step from "./Step";
import StepId from "./StepId";

class QuizStep extends Step {
    constructor(
        stepId: StepId,
        public readonly totalQuestions: Number
    ) {
        super(stepId);
    }

    type(): string {
        return 'quiz'
    }
}

export default QuizStep