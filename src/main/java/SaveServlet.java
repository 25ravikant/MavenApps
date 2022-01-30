
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String Empname=request.getParameter("ename");
        String Empemail=request.getParameter("eemail");
        String Empcontact=request.getParameter("econtact");
        String Empaddress=request.getParameter("eaddress");

        Emp e=new Emp();
        e.setName(Empname);
        e.setEmail(Empemail);
        e.setContact(Empcontact);
        e.setAddress(Empaddress);

        int status=EmpDao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
            out.println(Empaddress);
        }

        out.close();
    }

}
