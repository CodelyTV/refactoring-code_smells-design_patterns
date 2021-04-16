import GetStepDuration from '../../src/Application/GetStepDuration';
import StepId from "../../src/Domain/StepId";
import Step from "../../src/Domain/Step";

test('should get the video step duration', () => {
    const stepId = new StepId('stepId')
    const step = new Step(stepId, 13)
    const stepRepository = {
        find: jest.fn((stepId: StepId) => step)
    }
    const getStepDuration = new GetStepDuration(stepRepository)

    expect(getStepDuration.execute(stepId.value())).toBe(13)
});