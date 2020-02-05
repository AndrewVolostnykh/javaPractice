package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        Model model = Model.getInstance();
        User user = model.findUser(name, password);
        if(user != null)
        {
            /*
            req.setAttribute("user", user);
            req.getRequestDispatcher("viewjsp/profile.jsp").forward(req, resp);
            */
            req.setAttribute("name", user.getName());
            req.setAttribute("email", user.getEmail());
            req.setAttribute("id", user.getId());
            req.setAttribute("country", user.getCountry());
            req.setAttribute("birthday", user.getBirthDate());
            req.setAttribute("gender", user.getGender());
            RequestDispatcher disp = req.getRequestDispatcher("viewjsp/profile.jsp");
            disp.forward(req, resp);

        } else {
            doGet(req, resp);
        }
    }
}
