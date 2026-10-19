// Represents a student in the gradebook system
class Student {
    String id
    String name
    Map<String, Grade> grades = [:] // courseId -> Grade

    Student(String id, String name) {
        this.id = id
        this.name = name
    }
}