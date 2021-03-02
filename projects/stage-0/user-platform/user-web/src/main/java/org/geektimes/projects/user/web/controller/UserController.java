package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserController implements PageController {

    private UserService userService = new UserServiceImpl();

    @POST
    @Path("/register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            return "register.jsp";
        }

        if (userService.register(new User(username, password))) {
            return "register-success.jsp";
        }

        return "register.jsp";
    }
}
