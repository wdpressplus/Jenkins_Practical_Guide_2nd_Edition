package jp.gihyo.jenkinsbook;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.gihyo.jenkinsbook.action.SampleAction;

/**
 * Servlet implementation class SampleServlet.
 */
public class SampleServlet extends HttpServlet {
    /**
     * Serializable instance ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Forward error page if user access with get method.
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException Failed to servlet process
     * @throws IOException Failed to IO process
     * @see HttpServlet#doGet(
     *        HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(
        final HttpServletRequest req, final HttpServletResponse res
    ) throws ServletException, IOException {
        req.setCharacterEncoding("Shift_JIS");

        String path = "./WEB-INF/error.jsp";

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, res);
    }

    /**
     * Forward valid pages if user access with post method.
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException Failed to servlet process
     * @throws IOException Failed to IO process
     * @see HttpServlet#doPost(
     *        HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(
        final HttpServletRequest req, final HttpServletResponse res
    ) throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");

        String path = "./WEB-INF/error.jsp";

        String actionName = req.getParameter("action");

        if (actionName != null) {
            SampleAction action = createAction(actionName);

            if (action != null) {
                if (action.checkParameter(req)) {
                    path = action.execute(req);
                }
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, res);
    }

    /**
     * Decide the action.
     * @param name the action name
     * @return selected action by the action name
     */
    private SampleAction createAction(final String name) {

        if ("hello".equals(name)) {
            return new SampleAction();
        } else {
            return null;
        }
    }
}
