package XZXcom.student.dao;

import XZXcom.student.model.Student;
import XZXcom.student.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // 1. 增加学生记录
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, age, gender, class_name, score) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGender());
            pstmt.setString(4, student.getClassName());
            pstmt.setDouble(5, student.getScore());
            pstmt.executeUpdate();
        }
    }

    // 2. 更改学生记录
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, age=?, gender=?, class_name=?, score=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGender());
            pstmt.setString(4, student.getClassName());
            pstmt.setDouble(5, student.getScore());
            pstmt.setInt(6, student.getId());
            pstmt.executeUpdate();
        }
    }

    // 3. 删除学生记录
    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // 4. 查询所有学生记录
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setClassName(rs.getString("class_name"));
                student.setScore(rs.getDouble("score"));
                students.add(student);
            }
        }
        return students;
    }
}