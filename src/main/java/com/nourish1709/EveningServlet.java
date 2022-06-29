package com.nourish1709;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/evening")
public class EveningServlet extends HttpServlet {

    private static final String NAME_ATTRIBUTE = "name";
    private static final String DEFAULT_USER_NAME = "Buddy";
    private String userName = DEFAULT_USER_NAME;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = resolveName(request);

        PrintWriter printWriter = response.getWriter();
        printWriter.print("Good evening, " + name);
        printWriter.flush();
    }

    private String resolveName(HttpServletRequest request) {
        Optional<String> nameParam = Optional.ofNullable(request.getParameter(NAME_ATTRIBUTE));
        nameParam.ifPresent(name -> userName = name);
        return userName;
    }

}
