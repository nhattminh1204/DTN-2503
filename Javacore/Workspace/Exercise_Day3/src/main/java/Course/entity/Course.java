package Course.entity;

import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private Instructor instructor;
    private List<Student> students;

    public Course(String courseId, String courseName, Instructor instructor, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = students;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student.getName() + " đã được thêm vào khóa học " + courseName);
        } else {
            System.out.println(student.getName() + " đã có mặt trong khóa học này rồi.");
        }
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println(student.getName() + " đã bị xóa khỏi khóa học " + courseName);
        } else {
            System.out.println(student.getName() + " không có trong danh sách khóa học này.");
        }
    }

    public void printStudentList() {
        if (students.isEmpty()) {
            System.out.println("Khóa học này chưa có học viên.");
        } else {
            System.out.println("Danh sách học viên trong khóa học " + courseName + ":");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
}
