const courseTitle = require('../src');

test('gets the course title', () => {
    const course = {title: 'Refactoring'}
    expect(courseTitle(course)).toBe('Refactoring')
});