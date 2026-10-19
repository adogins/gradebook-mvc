// Main entry point for the Gradebook MVC CLI application
class Main {
    static void main(String[] args) {
        def view = new ConsoleView()
        def service = new GradebookService()
        def controller = new GradebookController(service, view)

        controller.start()
    }
}