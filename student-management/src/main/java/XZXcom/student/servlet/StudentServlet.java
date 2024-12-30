package XZXcom.student.servlet;

import XZXcom.student.dao.StudentDAO;
import XZXcom.student.model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/list":
                    listStudents(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/add":
                    addStudent(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // 1. 增加学生记录
    private void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String className = request.getParameter("className");
        double score = Double.parseDouble(request.getParameter("score"));

        Student student = new Student(0, name, age, gender, className, score);
        studentDAO.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/student/list");
    }

    // 2. 更改学生记录
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String className = request.getParameter("className");
        double score = Double.parseDouble(request.getParameter("score"));

        Student student = new Student(id, name, age, gender, className, score);
        studentDAO.updateStudent(student);
        response.sendRedirect(request.getContextPath() + "/student/list");
    }

    // 3. 删除学生记录
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect(request.getContextPath() + "/student/list");
    }

    // 4. 查询所有学生记录
    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Student> students = studentDAO.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}