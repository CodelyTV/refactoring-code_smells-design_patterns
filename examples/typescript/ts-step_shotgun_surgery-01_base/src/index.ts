interface Course {
    title: string;
}

function courseTitle(course: Course) {
    return course.title;
}

module.exports = courseTitle;