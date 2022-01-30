import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String Empname=request.getParameter("ename");
        String Empemail=request.getParameter("eemail");
        String Empcontact=request.getParameter("econtact");
        String Empaddress=request.getParameter("eaddress");

        Emp e=new Emp();
        e.setId(id);
        e.setName(Empname);
        e.setEmail(Empemail);
        e.setContact(Empcontact);
        e.setAddress(Empaddress);

        int status=EmpDao.update(e);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}
