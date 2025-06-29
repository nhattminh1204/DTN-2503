package com.data.elearning_api.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    // Auth
    INVALID_USERNAME_LENGTH(1001, "Tên người dùng phải từ 5 đến 20 ký tự", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1002, "Email không đúng định dạng", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS(1003, "Tên người dùng đã tồn tại", HttpStatus.CONFLICT),
    INVALID_CREDENTIALS(1004, "Tên người dùng hoặc mật khẩu không đúng", HttpStatus.UNAUTHORIZED),
    USER_EXISTS(1005, "Tài khoản đã tồn tại", HttpStatus.CONFLICT),
    ACCOUNT_NOT_FOUND(1006, "Không tìm thấy tài khoản", HttpStatus.NOT_FOUND),

    // Course
    COURSE_NOT_FOUND(2001, "Không tìm thấy khóa học", HttpStatus.NOT_FOUND),
    COURSE_NAME_EXISTS(2002, "Tên khoá học đã tồn tại", HttpStatus.CONFLICT),
    INVALID_COURSE_NAME(2003, "Tên khoá học phải từ 2 đến 100 ký tự", HttpStatus.BAD_REQUEST),
    INVALID_COURSE_SESSIONS(2004, "Số buổi phải >= 0", HttpStatus.BAD_REQUEST),
    INVALID_COURSE_HOURS(2005, "Số giờ phải >= 0", HttpStatus.BAD_REQUEST),
    COURSE_HAS_CERTIFICATES(2006, "Không thể xoá khoá học vì đang có chứng chỉ liên quan", HttpStatus.BAD_REQUEST),
    COURSE_HAS_LESSONS(2007, "Không thể xoá khoá học vì đang có bài học liên quan", HttpStatus.BAD_REQUEST),


    // Category
    CATEGORY_NOT_FOUND(3001, "Không tìm thấy danh mục", HttpStatus.NOT_FOUND),
    INVALID_CATEGORY_NAME(3002, "Tên danh mục phải từ 3 đến 100 ký tự", HttpStatus.BAD_REQUEST),
    CATEGORY_HAS_COURSES(3003, "Không thể xoá danh mục vì đang chứa khoá học", HttpStatus.BAD_REQUEST),

    // Certificate
    CERTIFICATE_NOT_FOUND(5001, "Không tìm thấy chứng chỉ", HttpStatus.NOT_FOUND),
    INVALID_SCORE(5002, "Điểm phải từ 0 đến 100", HttpStatus.BAD_REQUEST),
    INVALID_ACCOUNT_ID(5003, "ID tài khoản không hợp lệ", HttpStatus.BAD_REQUEST),
    INVALID_COURSE_ID(5004, "ID khóa học không hợp lệ", HttpStatus.BAD_REQUEST),

    // Lesson
    LESSON_NOT_FOUND(6001, "Không tìm thấy bài học", HttpStatus.NOT_FOUND),
    LESSON_TITLE_EXISTS(6002, "Tên bài học đã tồn tại", HttpStatus.CONFLICT),
    INVALID_LESSON_TITLE(6003, "Tiêu đề bài học phải từ 3 đến 200 ký tự", HttpStatus.BAD_REQUEST),
    INVALID_LESSON_DURATION(6004, "Thời lượng bài học phải >= 0", HttpStatus.BAD_REQUEST),

    // Common
    VALIDATION_ERROR(8001, "Dữ liệu không hợp lệ", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(9000, "Lỗi hệ thống, vui lòng thử lại sau", HttpStatus.INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus status;
}
