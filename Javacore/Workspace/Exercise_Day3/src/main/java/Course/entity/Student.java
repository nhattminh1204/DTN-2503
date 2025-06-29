package Course.entity;

import java.util.List;

public class Student extends Person {
    private List<Course> courses;

    public Student(String id, String name, List<Course> courses) {
        super(id, name);
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void registerCourse(Course course) {
        if (!checkExists(course)) {
            courses.add(course);
            course.addStudent(this);
            System.out.println(getName() + " đã đăng ký khóa học " + course.getCourseName());
        } else {
            System.out.println(getName() + " đã đăng ký khóa học này rồi.");
        }
    }

    public void removeCourse(Course course) {
        if (checkExists(course)) {
            courses.remove(course);
            course.removeStudent(this);
            System.out.println(getName() + " đã hủy đăng ký khóa học " + course.getCourseName());
        } else {
            System.out.println(getName() + " chưa đăng ký khóa học này.");
        }
    }

    public boolean checkExists(Course course) {
        for (Course c : courses)
            if (c.getCourseId().equals(course.getCourseId())) return true;
        return false;
    }

}
