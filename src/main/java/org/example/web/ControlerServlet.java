package org.example.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.metier.CreditMetier;

import java.io.IOException;

@WebServlet(name = "cs",urlPatterns = {"/","*.php"})
public class ControlerServlet extends HttpServlet {

    private CreditMetier metier;

    @Override
    public void init() throws ServletException {
        metier =new CreditMetier();
    }

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("mod",new CreditModel());
        req.getRequestDispatcher("vueCredit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double m = Double.parseDouble(req.getParameter("montant"));
        Integer  d = Integer.parseInt(req.getParameter("duree"));
        Double t = Double.parseDouble(req.getParameter("taux"));


        CreditModel model = new CreditModel();
        model.setMontant(m);
        model.setDuree(d);
        model.setTaux(t);

        double res = metier.calculMensualite(m,d,t);

        model.setMensualite(res);

        req.setAttribute("mod",model);
        req.getRequestDispatcher("vueCredit.jsp").forward(req,resp);
    }
}
