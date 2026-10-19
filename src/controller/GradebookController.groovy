// Coordinates user actions between the view and the service layer
class GradebookController {

    GradebookService service
    ConsoleView view

    GradebookController(GradebookService service, ConsoleView view) {
        this.service = service
        this.view = view
    }

    void start() {
        boolean running = true

        while (running) {
            view.showMenu()
            def choice = System.console()?.readLine() ?: new BufferedReader(new InputStreamReader(System.in)).readLine()

            switch (choice) {
                case "1":
                    handleAddStudent()
                    break
                case "2":
                    handleAddCourse()
                    break
                case "3":
                    handleAssignGrade()
                    break
                case "4":
                    handleViewStudentRecord()
                    break
                case "5":
                    handleListStudents()
                    break
                case "6":
                    running = false
                    view.showMessage("Exiting Gradebook. Goodbye!")
                    break
                default:
                    view.showMessage("Invalid option. Please try again.")
            }
        }
    }

    private void handleAddStudent() {
        def id = view.prompt("Student ID: ")
        def name = view.prompt("Student name: ")
        service.addStudent(id, name)
        view.showMessage("Student added successfully.")
    }

    private void handleAddCourse() {
        def id = view.prompt("Course ID: ")
        def title = view.prompt("Course title: ")
        service.addCourse(id, title)
        view.showMessage("Course added successfully.")
    }

    private void handleAssignGrade() {
        def studentId = view.prompt("Student ID: ")
        def courseId = view.prompt("Course ID: ")
        def letter = view.prompt("Letter grade (A-F): ")
        try {
            service.assignGrade(studentId, courseId, letter)
            view.showMessage("Grade assigned successfully.")
        } catch (IllegalArgumentException e) {
            view.showMessage("Error: ${e.message}")
        }
    }

    private void handleViewStudentRecord() {
        def studentId = view.prompt("Student ID: ")
        def student = service.getStudent(studentId)
        if (!student) {
            view.showMessage("Student not found.")
            return
        }
        view.showStudentRecord(student, service.getCourses())
    }

    private void handleListStudents() {
        view.listStudents(service.listStudents())
    }
}