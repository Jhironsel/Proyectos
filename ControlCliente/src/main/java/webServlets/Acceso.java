package webServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_ContactoEmail;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

@WebServlet("/Acceso")
public class Acceso extends HttpServlet {

    private static List<Cliente> clientesList;

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if (!Objects.isNull(accion)) {
            if (accion.equalsIgnoreCase("editar")) {
                req.setAttribute(
                        "cliente",
                        M_Cliente.select(
                                Cliente
                                        .builder()
                                        .id(
                                                Integer.valueOf(
                                                        req.getParameter("idCliente")
                                                )
                                        )
                                        .build()
                        )
                );

                req.getRequestDispatcher(
                        "/WEB-INF/paginas/cliente/editarCliente.jsp"
                ).forward(req, resp);
                return;
            }

            if (accion.equalsIgnoreCase("eliminar")) {
                M_Cliente.delete(Integer.parseInt(req.getParameter("idCliente")));
            }

        }
        accionDefauld(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;chartset=UTF8");

        String usuario = req.getParameter("txtUsuario");
        String clave = req.getParameter("txtPassword");
        String accion = req.getParameter("accion");

        if (!Objects.isNull(accion)) {
            if (accion.equalsIgnoreCase("insertar")) {
                Resultado resultado = M_Persona.insert(
                        Persona.
                                builder()
                                .persona('F')
                                .pnombre(req.getParameter("txtPNombre"))
                                .snombre(req.getParameter("txtSNombre"))
                                .apellidos(req.getParameter("txtApellidos"))
                                .sexo(req.getParameter("cbSexo").charAt(0))
                                .fecha_nacimiento(
                                        javaDateToSqlDate(
                                                stringToDate(
                                                        "01.01.2000",
                                                        "dd.MM.yyyy"
                                                )
                                        )
                                )
                                .estado(Boolean.TRUE)
                                .build()
                );
                //.saldo(new BigDecimal(req.getParameter("txtSaldo")))

                M_ContactoEmail.agregarContactosEmail(
                        ContactoEmail
                                .builder()
                                .idPersona(resultado.getId())
                                .email(req.getParameter("txtCorreo"))
                                .porDefecto(Boolean.TRUE)
                                .build()
                );

                M_Cliente.insertById(resultado.getId());

                accionDefauld(req, resp);
                return;
            }

            if (accion.equalsIgnoreCase("modificar")) {
                M_Persona.update(
                        Persona
                                .builder()
                                .idPersona(
                                        Integer.valueOf(
                                                req.getParameter("idCliente")
                                        )
                                )
                                .pnombre(req.getParameter("txtPNombre"))
                                .snombre(req.getParameter("txtSNombre"))
                                .apellidos(req.getParameter("txtApellidos"))
                                .sexo(req.getParameter("cbSexo").charAt(0))
                                .build()
                );//.correo(req.getParameter("txtCorreo"))
                //.saldo(new BigDecimal(req.getParameter("txtSaldo")))
                accionDefauld(req, resp);
                return;
            }

        }

        if (Objects.isNull(usuario) || usuario.isBlank()) {
            resp.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Nombre de usuario en blanco."
            );
            return;
        }

        if (usuario.length() <= 4) {
            resp.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Nombre de usuario demasiado corto."
            );
            return;
        }

        if (Objects.isNull(clave) || clave.isBlank()) {
            resp.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Contraseña incorrecta!"
            );
            return;
        }

        Conexion.getInstance(
                usuario,
                clave,
                "SoftSurena.db",
                "localhost",
                "3050"
        );

        if (Conexion.verificar().getEstado()) {
            accionDefauld(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            Conexion.setCnn(null);
        }
    }

    /**
     * Metodo que consulta a la base de datos y trae los clientes activos en el
     * sistema.
     *
     * @param req
     *
     * @param resp
     *
     * @throws ServletException
     *
     * @throws IOException
     */
    private void accionDefauld(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        Persona
//                .builder()
//                .estado(Boolean.TRUE)
//                .build();
        clientesList = M_Cliente.select(
                Cliente
                        .builder()
                        .build()
        );

        BigDecimal saldoTotal = BigDecimal.ZERO;

        clientesList.stream().forEach(
                cliente -> {
                    //saldoTotal += cliente.getSaldo().doubleValue();
                }
        );

        HttpSession sesion = req.getSession();

        sesion.setAttribute("clientes", clientesList);
        sesion.setAttribute("totalClientes", clientesList.size());
        sesion.setAttribute("saldoTotal", saldoTotal);

        req.getRequestDispatcher("accesoCliente.jsp").forward(req, resp);

        resp.sendRedirect("accesoCliente.jsp");
    }

}
