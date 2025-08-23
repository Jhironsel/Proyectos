package sur.softsurena.webServlets;

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
    private static final long serialVersionUID = 1L;

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
        Integer _idCliente;
        try {
            _idCliente = Integer.valueOf(req.getParameter("idCliente"));
        } catch (NumberFormatException e) {
            _idCliente = -1;
        }

        if (!Objects.isNull(accion)) {
            if (accion.equalsIgnoreCase("editar")) {
                
                req.setAttribute(
                        "cliente",
                        M_Cliente.select(
                                Cliente
                                        .builder()
                                        .idPersona(_idCliente)
                                        .build()
                        )
                );

                try {
                    req.getRequestDispatcher(
                            "/WEB-INF/paginas/cliente/editarCliente.jsp"
                    ).forward(req, resp);
                } catch (ServletException | IOException e) {
                }
                return;
            }

            if (accion.equalsIgnoreCase("eliminar")) {
                M_Cliente.delete(
                        Cliente
                                .builder()
                                .idPersona(_idCliente)
                                .build()
                );
            }

        }
        try {
            accionDefauld(req, resp);
        } catch (ServletException | IOException e) {
        }
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
                        Cliente.
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

                M_ContactoEmail.insert(
                        ContactoEmail
                                .builder()
                                .idPersona(resultado.getId())
                                .email(req.getParameter("txtCorreo"))
                                .porDefecto(Boolean.TRUE)
                                .build()
                );

                M_Cliente.insert(
                        Cliente.builder().idPersona(resultado.getId()).build()
                );

                try {
                    accionDefauld(req, resp);
                } catch (ServletException | IOException e) {
                }
                return;
            }

            if (accion.equalsIgnoreCase("modificar")) {
                Integer _idPersona;
                try {
                    _idPersona = Integer.valueOf(req.getParameter("idCliente"));
                } catch (NumberFormatException e) {
                    _idPersona = -1;
                }
                M_Persona.update(
                        Cliente
                                .builder()
                                .idPersona(_idPersona)
                                .pnombre(req.getParameter("txtPNombre"))
                                .snombre(req.getParameter("txtSNombre"))
                                .apellidos(req.getParameter("txtApellidos"))
                                .sexo(req.getParameter("cbSexo").charAt(0))
                                .build()
                );//.correo(req.getParameter("txtCorreo"))
                //.saldo(new BigDecimal(req.getParameter("txtSaldo")))
                try {
                    accionDefauld(req, resp);
                } catch (ServletException | IOException e) {
                }
                return;
            }

        }

        if (Objects.isNull(usuario) || usuario.isBlank()) {
            
            try {
                resp.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Nombre de usuario en blanco."
                );
            } catch (IOException e) {
            }
            return;
        }

        if (usuario.length() <= 4) {
            try {
                resp.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Nombre de usuario demasiado corto."
                );
            } catch (IOException e) {
            }
            return;
        }

        if (Objects.isNull(clave) || clave.isBlank()) {
            try {
                resp.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Contraseña incorrecta!"
                );
            } catch (IOException e) {
            }
            return;
        }

        Conexion.getInstance(
                usuario,
                clave,
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
        );

        if (Conexion.verificar().getEstado()) {
            try {
                accionDefauld(req, resp);
            } catch (ServletException | IOException e) {
            }
        } else {
            try {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
            }
            
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

        try {
            req.getRequestDispatcher("accesoCliente.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }

        resp.sendRedirect("accesoCliente.jsp");
    }

}
