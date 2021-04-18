import GetStepDuration from '../../src/Application/GetStepDuration';
import StepId from "../../src/Domain/StepId";
import VideoStep from "../../src/Domain/VideoStep";
import QuizStep from "../../src/Domain/QuizStep";

test('should get the video step duration', () => {
    const stepId = new StepId('stepId')
    const step = new VideoStep(stepId, 13)
    const stepRepository = {
        find: jest.fn(() => step)
    }
    const getStepDuration = new GetStepDuration(stepRepository)

    expect(getStepDuration.execute(stepId.value())).toBe(14.3)
});

test('should get the quiz step duration', () => {
    const stepId = new StepId('stepId')
    const step = new QuizStep(stepId, 5)
    const stepRepository = {
        find: jest.fn(() => step)
    }
    const getStepDuration = new GetStepDuration(stepRepository)

    expect(getStepDuration.execute(stepId.value())).toBe(37.5)
});