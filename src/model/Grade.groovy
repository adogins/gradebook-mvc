// Represents a grade assigned to a student for a specfic course
class Grade {
    String courseId
    String studentId
    String letter // e.g. A, B, C, D, F
    Date timestamp = new Date()

    Grade(String courseId, String studentId, String letter) {
        this.courseId = courseId
        this.studentId = studentId
        this.letter = letter
    }
}