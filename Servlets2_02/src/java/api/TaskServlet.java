package api;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import org.json.JSONObject;

import model.Task;
import org.json.JSONArray;

@WebServlet(name = "TaskServlet", urlPatterns = {"/tasks"})
public class TaskServlet extends HttpServlet {

    private JSONObject getJSONBody(BufferedReader reader) throws Exception {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return new JSONObject(buffer.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        JSONObject file = new JSONObject();
        try {
            if (request.getMethod().equals("PUT")) {
                //Reading body
                JSONObject body = getJSONBody(request.getReader());
                //Adding task, if exists
                String title = body.getString("title");
                if (title != null) {
                    Task t = new Task(title);
                    Task.list.add(t);
                }
                //Returning tasks
                file.put("list", new JSONArray(Task.list));
            } else if (request.getMethod().equals("GET")) {
                file.put("list", new JSONArray(Task.list));
            } else if (request.getMethod().equals("DELETE")) { //DELETE don't support body
                String title = request.getParameter("title");
                int i = -1;
                for (Task t : Task.list) {
                    if (t.getTitle().equals(title)) {
                        i = Task.list.indexOf(t);
                        break;
                    }
                }
                if (i > -1) {
                    Task.list.remove(i);
                }
                file.put("list", new JSONArray(Task.list));
            } else {
                file.put("error", "Método Inválido: " + request.getMethod());
            }
            response.getWriter().print(file.toString());
        } catch (Exception ex) {
            file.put("error", ex.getLocalizedMessage());
            response.getWriter().print(file.toString());

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
