<!DOCTYPE html>
<%@page import="sur.softsurena.entidades.Bingo" %>
<%!
    Bingo bingo = new Bingo();
%>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>B</th>
                    <th>I</th>
                    <th>N</th>
                    <th>G</th>
                    <th>O</th>
                </tr>
            </thead>
            <tbody>
                <%
                    StringBuilder fila = new StringBuilder();
                    int index = 0;
                    for (int i = 0; i < 5; i++) {
                        out.print("<tr>");
                        fila = new StringBuilder();

                        do {

                            fila.append("<td>").
                                    append(bingo.generarCarton().get(index)).
                                    append("</td>");
                            index++;
                        } while ((index % 5) != 0);
                        out.print(fila);
                        out.print("</tr>");
                    }
                %>

            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>

        </tbody>
    </table>

</body>
</html>
