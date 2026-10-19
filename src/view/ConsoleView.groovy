// Handles all console input and output for the gradebook application
class ConsoleView {

    void showMenu() {
        println "\n=== Gradebook System ==="
        println "1. Add Student"
        println "2. Add Course"
        println "3. Assign Grade"
        println "4. View Student Record"
        println "5. List All Students"
        println "6. Exit"
        print "Choose an option: "
    }

    String prompt(String msg) {
        println msg
    }

    void showStudentRecord(Student student, Map<String, Course> courses) {
        println "\nRecord for ${student.name} (ID: ${student.id})"
        if (student.grades.isEmpty()) {
            println " No grades recorded."
            return
        }
        student.grades.each { courseId, grade ->
            def course = courses[courseId]
            println " Course: ${course?.title ?: courseId} | Grade: ${grade.letter} | Date: ${grade.timestamp}"
        }
    }

    void listStudents(Collection<Student> students) {
        println "\nAll Students:"
        if (students.isEmpty()) {
            println " No students found."
            return
        }
        students.each { s ->
            println " ID: ${s.id} | Name: ${s.name}"
        }
    }
}