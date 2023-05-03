<%@page import="org.example.web.CreditModel"%>
<%
    CreditModel model= (CreditModel)request.getAttribute("mod");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta>
        <title>Simulateur Credit</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href= "webapp\CSS\style.css"/>
    </head>

    <body>
        <div>
            <form method="post">
                <table>
                    <tr>
                        <td>Montant :</td>
                        <td><input type="text" name="montant" value=<%=model.getMontant()%> /></td>
                        <td>DH</td>
                    </tr>
                    <tr>
                        <td>Duree :</td>
                        <td><input type="text" name="duree" value=<%=model.getDuree()%> /></td>
                        <td>Month</td>
                    </tr>
                    <tr>
                        <td>Taux :</td>
                        <td><input type="text" name="taux" value=<%=model.getTaux()%> /></td>
                        <td>%</td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Calculer"/></td>
                    </tr>

                </table>

            </form>
            <div>
                <table>
                    <tr>
                        <td>mensualité:</td>
                        <td><%= model.getMensualite() %></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>