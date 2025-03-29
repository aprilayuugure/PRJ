import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Tạo danh sách khách hàng
        List<Customer> customerList = new ArrayList<Customer>();
        Customer c = new Customer();
        c.setCustomerId(4); c.setFirstName("Bill");
 
        customerList.add(c);
        // Đặt danh sách và bảng vào request
        request.setAttribute("customerList", customerList);
        // Chuyển tiếp đến JSP
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}