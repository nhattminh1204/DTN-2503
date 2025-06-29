package Course;

import Course.entity.Course;
import Course.entity.Instructor;
import Course.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Instructor> instructors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        data();
        showMenu();
    }

    public static void data() {
        Instructor instructor1 = new Instructor("I001", "Nguyễn Văn Nhật");
        Instructor instructor2 = new Instructor("I002", "Trần Thị Quý");
        instructors.add(instructor1);
        instructors.add(instructor2);

        Student student1 = new Student("S001", "Lê Minh Tâm", new ArrayList<>());
        Student student2 = new Student("S002", "Phạm Ngọc Anh", new ArrayList<>());
        Student student3 = new Student("S003", "Nguyễn Thu Hương", new ArrayList<>());
        Student student4 = new Student("S004", "Hoàng Quang Hiếu", new ArrayList<>());
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Course course1 = new Course("C001", "Lập trình Java cơ bản", instructor1, new ArrayList<>());
        Course course2 = new Course("C002", "Lập trình Web với Spring Boot", instructor2, new ArrayList<>());
        Course course3 = new Course("C003", "Khoa học dữ liệu với Python", instructor1, new ArrayList<>());
        Course course4 = new Course("C004", "Cấu trúc dữ liệu và giải thuật", instructor2, new ArrayList<>());

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        registerStudentToCourse(student1, course1);
        registerStudentToCourse(student1, course2);
        registerStudentToCourse(student2, course1);
        registerStudentToCourse(student2, course3);
        registerStudentToCourse(student3, course4);
        registerStudentToCourse(student4, course2);
        registerStudentToCourse(student4, course3);
    }

    private static void registerStudentToCourse(Student student, Course course) {
        student.getCourses().add(course);
        course.getStudents().add(student);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n------ Hệ thống đăng ký khóa học ------");
            System.out.println("1. In danh sách khóa học");
            System.out.println("2. In danh sách học viên");
            System.out.println("3. Thêm khóa học");
            System.out.println("4. Xóa khóa học");
            System.out.println("5. Đăng ký khóa học");
            System.out.println("6. Hủy đăng ký khóa học");
            System.out.println("7. In danh sách học viên trong khóa học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printCourseList();
                    break;
                case 2:
                    printStudentList();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    removeCourse();
                    break;
                case 5:
                    registerCourse();
                    break;
                case 6:
                    removeStudentFromCourse();
                    break;
                case 7:
                    printStudentListInCourse();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void printStudentList() {
        System.out.println("\n------ Danh sách sinh viên ------");
        for (Student student : students) {
            System.out.println(student.getName() + "(" + student.getId() + ")" );
        }
    }

    public static void printCourseList() {
        System.out.println("\n------ Danh sách khóa học ------");
        for (Course course : courses) {
            System.out.println(course.getCourseName() + "(" + course.getCourseId() + ")");
        }
    }

    public static void addCourse() {
        while (true) {
            System.out.print("Nhập mã khóa học: ");
            String courseId = scanner.nextLine();

            if (isCourseIdExist(courseId)) {
                System.out.println("Mã khóa học đã tồn tại. Vui lòng nhập lại.");
                continue;
            }

            System.out.print("Nhập tên khóa học: ");
            String courseName = scanner.nextLine();

            Instructor instructor = null;
            while (instructor == null) {
                System.out.print("Nhập giảng viên (mã giảng viên): ");
                String instructorId = scanner.nextLine();
                instructor = findInstructorById(instructorId);

                if (instructor == null) {
                    System.out.println("Giảng viên không tồn tại. Vui lòng nhập lại mã giảng viên.");
                }
            }

            Course newCourse = new Course(courseId, courseName, instructor, new ArrayList<>());
            courses.add(newCourse);
            System.out.println("Khóa học \"" + courseName + "\" đã được thêm.");
            break;
        }
    }

    public static void removeCourse() {
        while (true) {
            printCourseList();
            System.out.print("Nhập mã khóa học cần xóa: ");
            String courseId = scanner.nextLine();
            Course courseToRemove = findCourseById(courseId);

            if (courseToRemove != null) {
                if (courseToRemove.getStudents().isEmpty()) {
                    courses.remove(courseToRemove);
                    System.out.println("Khóa học \"" + courseToRemove.getCourseName() + "\" đã bị xóa.");
                    break;
                } else {
                    System.out.println("Khóa học \"" + courseToRemove.getCourseName() + "\" có sinh viên đăng ký. Vui lòng hủy đăng ký trước.");
                    break;
                }
            } else {
                System.out.println("Khóa học không tồn tại. Vui lòng thử lại.");
            }
        }
    }

    public static void registerCourse() {
        while (true) {
            System.out.print("Nhập mã sinh viên: ");
            String studentId = scanner.nextLine();
            Student student = findStudentById(studentId);

            if (student != null) {
                while (true) {
                    System.out.print("Nhập mã khóa học để đăng ký: ");
                    String courseId = scanner.nextLine();
                    Course course = findCourseById(courseId);

                    if (course != null) {
                        if (course.getStudents().contains(student)) {
                            System.out.println("Sinh viên đã đăng ký khóa học này rồi.");
                            break;
                        } else {
                            student.registerCourse(course);
                            course.getStudents().add(student);
                            System.out.println("Sinh viên đã đăng ký thành công khóa học \"" + course.getCourseName() + "\".");
                            break;
                        }
                    } else {
                        System.out.println("Khóa học không tồn tại. Vui lòng nhập lại mã khóa học.");
                    }
                }
                break;
            } else {
                System.out.println("Sinh viên không tồn tại. Vui lòng nhập lại mã sinh viên.");
            }
        }
    }

    public static void removeStudentFromCourse() {
        while (true) {
            System.out.print("Nhập mã sinh viên: ");
            String studentId = scanner.nextLine();
            Student student = findStudentById(studentId);

            if (student != null) {
                while (true) {
                    System.out.print("Nhập mã khóa học để hủy đăng ký: ");
                    String courseId = scanner.nextLine();
                    Course course = findCourseById(courseId);

                    if (course != null) {
                        if (course.getStudents().contains(student)) {
                            student.removeCourse(course);
                            course.getStudents().remove(student);
                            System.out.println("Sinh viên đã hủy đăng ký thành công khóa học \"" + course.getCourseName() + "\".");
                            break;
                        } else {
                            System.out.println("Sinh viên chưa đăng ký khóa học này. Vui lòng thử lại.");
                            break;
                        }
                    } else {
                        System.out.println("Khóa học không tồn tại. Vui lòng nhập lại mã khóa học.");
                    }
                }
                break;
            } else {
                System.out.println("Sinh viên không tồn tại. Vui lòng nhập lại mã sinh viên.");
            }
        }
    }

    public static void printStudentListInCourse() {
        while (true) {
            printCourseList();
            System.out.print("Nhập mã khóa học để in danh sách học viên: ");
            String courseId = scanner.nextLine();
            Course course = findCourseById(courseId);

            if (course != null) {
                System.out.println("Danh sách học viên trong khóa học \"" + course.getCourseName() + "\":");
                if (course.getStudents().isEmpty()) {
                    System.out.println(">> Hiện tại chưa có học viên nào đăng ký khóa học này.");
                } else {
                    for (Student student : course.getStudents()) {
                        System.out.println(student.getName());
                    }
                }
                break;
            } else {
                System.out.println("Khóa học không tồn tại. Vui lòng nhập lại mã khóa học.");
            }
        }
    }

    public static Course findCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }

    public static Student findStudentById(String studentId) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    public static Instructor findInstructorById(String instructorId) {
        for (Instructor i : instructors) {
            if (i.getId().equals(instructorId)) {
                return i;
            }
        }
        return null;
    }

    public static boolean isCourseIdExist(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

}
