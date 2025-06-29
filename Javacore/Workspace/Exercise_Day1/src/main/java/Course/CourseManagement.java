package Course;

import Course.entity.Course;
import Course.entity.Enrollment;
import Course.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {
    private Scanner sc = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public CourseManagement() {
        Student student1 = new Student("HV01", "Minh Nhật", "nhattminh1204@gmail.com");
        Student student2 = new Student("HV02", "Văn B", "thutam08054@gmail.com");
        students.add(student1);
        students.add(student2);

        Course course1 = new Course("KH01", "DevOps", 20);
        Course course2 = new Course("KH02", "Fullstack", 45);
        courses.add(course1);
        courses.add(course2);

        Enrollment enrollment1 = new Enrollment(student1, course1, LocalDate.of(2024, 5, 12));
        Enrollment enrollment2 = new Enrollment(student1, course2, LocalDate.of(2024, 4, 30));
        Enrollment enrollment3 = new Enrollment(student2, course2, LocalDate.of(2024, 9, 10));

        enrollments.add(enrollment1);
        enrollments.add(enrollment2);
        enrollments.add(enrollment3);

        course1.getEnrollments().add(enrollment1);
        course2.getEnrollments().add(enrollment2);
        course2.getEnrollments().add(enrollment3);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n--------- QUẢN LÝ KHÓA HỌC ---------");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Hiển thị danh sách khóa học");
            System.out.println("3. Thêm học viên");
            System.out.println("4. Thêm khóa học");
            System.out.println("5. Đăng ký học viên vào khóa học");
            System.out.println("6. In danh sách sinh viên của một khóa học");
            System.out.println("7. In danh sách khóa học mà một học viên đã đăng ký");
            System.out.println("8. Thống kê");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    printStudentList();
                    break;
                case 2:
                    printCourseList();
                    break;
                case 3:
                    addStudentSample();
                    break;
                case 4:
                    addCourseSample();
                    break;
                case 5:
                    enrollCourse();
                    break;
                case 6:
                    printStudentsInCourse();
                    break;
                case 7:
                    printCoursesOfStudent();
                    break;
                case 8:
                    statistics();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }


    // In danh sách sinh viên
    private void printStudentList() {
        System.out.println("Danh sách học viên:");
        for (Student student : students) {
            System.out.println("- " + student.getName() + " (" + student.getId() + "), Email: " + student.getEmail());
        }
    }

    // In danh sách khóa học
    private void printCourseList() {
        System.out.println("Danh sách khóa học:");
        for (Course course : courses) {
            System.out.println("- " + course.getTitle() + " (" + course.getId() + "), Số học viên tối đa: " + course.getMaxStudents());
        }
    }

    // Thêm sinh viên
    private void addStudentSample() {
        while (true) {
            System.out.print("Id: ");
            String id = sc.nextLine();
            boolean exists = false;
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Học viên đã tồn tại. Vui lòng nhập lại!");
            } else {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                Student student = new Student(id, name, email);
                students.add(student);
                System.out.println("Thêm học viên thành công!");
                break;
            }
        }
    }

    // Thêm khóa học
    private void addCourseSample() {
        while (true) {
            System.out.print("Id: ");
            String id = sc.nextLine();
            boolean exists = false;
            for (Course course : courses) {
                if (course.getId().equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Lớp học đã tồn tại. Vui lòng nhập lại");
            } else {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Max Students: ");
                int maxStudents = sc.nextInt();
                sc.nextLine();
                Course course = new Course(id, title, maxStudents);
                courses.add(course);
                System.out.println("Thêm khóa học thành công!");
                break;
            }
        }
    }

    // Học viên đăng ký khóa học
    private void enrollCourse() {
        Student student = null;
        Course course = null;

        System.out.print("Nhập id học viên: ");
        String studentId = sc.nextLine();

        // Check học viên có tồn tại không?
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Học viên không tồn tại!");
            return;
        }

        // Check khóa học có tồn tại không?
        System.out.print("Nhập id khóa học: ");
        String courseId = sc.nextLine();

        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            System.out.println("Khóa học không tồn tại!");
            return;
        }

        // Check lớp học đã full chưa
        if (course.isFull()) {
            System.out.println("Khóa học đã đầy!");
            return;
        }

        // isEnrollments
        for (Enrollment e : enrollments) {
            if (e.getStudent().getId().equals(studentId) && e.getCourse().getId().equals(courseId)) {
                System.out.println("Học viên đã đăng ký khóa học!");
                return;
            }
        }

        // Add học viên
        Enrollment newEnrollment = new Enrollment(student, course, LocalDate.now());
        course.getEnrollments().add(newEnrollment);
        enrollments.add(newEnrollment);
        System.out.println("Học viên " + student.getName() + " đã đăng ký khóa học " + course.getTitle() + " thành công!");
    }

    // Danh sách học viên trong khóa học
    private void printStudentsInCourse() {
        System.out.print("Nhập Id khóa học: ");
        String courseId = sc.nextLine();

        Course course = null;

        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            System.out.println("Khóa học không tồn tại!");
            return;
        }

        if (course.getEnrollments().isEmpty()) {
            System.out.println("Khóa học chưa có sinh viên đăng ký!");
            return;
        }

        course.getEnrollments().sort((e1, e2) -> e1.getEnrollmentDate().compareTo(e2.getEnrollmentDate()));

        System.out.println("Danh sách sinh viên của khóa học " + course.getTitle() + ":");
        for (Enrollment enrollment : course.getEnrollments()) {
            System.out.println("- " + enrollment.getStudent().getName() + " (" + enrollment.getStudent().getId() +
                    "), Đăng ký ngày: " + enrollment.getEnrollmentDate());
        }
    }

    // Danh sách khóa học của học viên
    private void printCoursesOfStudent() {
        System.out.print("Nhập Id học viên: ");
        String studentId = sc.nextLine();

        Student student = null;
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Học viên không tồn tại!");
            return;
        }

        List<Course> registeredCourses = new ArrayList<>();
        for (Course c : courses) {
            for (Enrollment e : c.getEnrollments()) {
                if (e.getStudent().getId().equals(studentId)) {
                    registeredCourses.add(c);
                    break;
                }
            }
        }

        if (registeredCourses.isEmpty()) {
            System.out.println("Học viên này chưa đăng ký khóa học nào.");
        } else {
            System.out.println("Danh sách khóa học của học viên " + student.getName() + ":");
            for (Course c : registeredCourses) {
                System.out.println("- " + c.getTitle() + " (" + c.getId() + ")");
            }
        }
    }

    // Thống kê
    private void statistics() {
        if (courses.isEmpty() || students.isEmpty()) {
            System.out.println("Chưa có dữ liệu để thống kê.");
            return;
        }

        Course maxCourse = null;
        int maxEnrollmentCount = 0;
        for (Course c : courses) {
            int count = c.getEnrollments().size();
            if (count > maxEnrollmentCount) {
                maxEnrollmentCount = count;
                maxCourse = c;
            }
        }

        if (maxCourse != null && maxEnrollmentCount > 0) {
            System.out.println("Khóa học có nhiều sinh viên nhất: " + maxCourse.getTitle() + " (" + maxCourse.getId() + "), Số lượng: " + maxEnrollmentCount);
        } else {
            System.out.println("Chưa có sinh viên nào đăng ký khóa học.");
        }

        Student maxStudent = null;
        int maxCoursesCount = 0;
        for (Student s : students) {
            int count = 0;
            for (Enrollment e : enrollments) {
                if (e.getStudent().getId().equals(s.getId())) {
                    count++;
                }
            }
            if (count > maxCoursesCount) {
                maxCoursesCount = count;
                maxStudent = s;
            }
        }

        if (maxStudent != null && maxCoursesCount > 0) {
            System.out.println("Sinh viên đăng ký nhiều khóa học nhất: " + maxStudent.getName() + " (" + maxStudent.getId() + "), Số lượng: " + maxCoursesCount);
        } else {
            System.out.println("Chưa có học viên nào đăng ký khóa học.");
        }
    }
}