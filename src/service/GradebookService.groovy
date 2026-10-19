// Contains business logic for managing students, courses, and grades
class GradebookService {

    Map<String, Student> students = [:] // studentId -> Student
    Map<String, Course> courses = [:] // courseId -> Course

    Student addStudent(String id, String name) {
        def student = new Student(id, name)
        students[id] = student
        return student
    }

    Course addCourse(String id, String title) {
        def course = new Course(id, title)
        courses[id] = course
        return course
    }

    Grade assignGrade(String studentId, String courseId, String letter) {
        def student = students[studentId]
        if (!student) {
            throw new IllegalArgumentException("Student with ID ${studentId} not found")
        }
        def course = courses[courseId]
        if (!course) {
            throw new IllegalArgumentException("Course with ID ${courseId} not found")
        }

        def grade = new Grade(courseId, studentId, letter)
        student.grades[courseId] = grade
        return grade
    }

    Student getStudent(String id) {
        return students[id]
    }

    Collection<Student> listStudents() {
        return students.values()
    }

    Map<String, Course> getCourses() {
        return courses
    }
}