package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// handing queries by /add
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String date = req.getParameter("birthday"); // check, does it works

        /*
        User user = null;
        if(name != null & password != null & gender != null & country != null & date != null ) {
        user = new User(name, password, surname, country, date, gender);
        }
         */

        User user = new User(name, password, email, country, date, gender);
        Model model = Model.getInstance();

        PrintWriter writer = resp.getWriter(); // RE-WRITE

        if(model.duplicationCheck(user)) // block duplications
        {
            try{ //RE-WRITE
                writer.println("This user already registered or input data incorrect");
            } finally {
                writer.close();
        }
            doGet(req, resp);
        } else {
            System.out.println(user.getName());
            model.add(user);

            req.setAttribute("userName", name);
            doGet(req, resp);
        }
    }
}
