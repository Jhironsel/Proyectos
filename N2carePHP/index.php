<?php
// grab recaptcha library
require_once "recaptchalib.php";
// your secret key
$secret = "6Ld4Z6cUAAAAADBxkWfTzkpy1QiRKMACObqkl0DC";

// empty response
$response = null;

// check secret key
$reCaptcha = new ReCaptcha($secret);

// if submitted check response
if (filter_input(INPUT_POST, "g-recaptcha-response")) {
    $response = $reCaptcha->verifyResponse(
            filter_input(INPUT_SERVER, "REMOTE_ADDR"),
            filter_input(INPUT_POST, "g-recaptcha-response")
    );
}
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Sistema pediátrico</title>
        <meta charset="UTF-8">
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="ccs/w3.css">
        <link rel="stylesheet" href="ccs/css.css">
        <link href="ccs/estilos.css" rel="stylesheet" type="text/css"/>
        <script src="js/js.js" type="text/javascript"></script>
        <script src="js/w3.js" type="text/javascript"></script>
        <script src="lib/jquery-1.9.0.min.js" type="text/javascript"></script>
        <script src="src/jquery.maskedinput.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function () {
                $.mask.definitions['~'] = "[+-]";
                $("#date").mask("99/99/9999", {placeholder: "mm/dd/yyyy", completed: function () {
                        alert("completed!");
                    }});
                $(".phone").mask("(999) 999-9999");
                $("#phoneExt").mask("(999) 999-9999? x99999");
                $("#iphone").mask("+33 999 999 999");
                $("#tin").mask("99-9999999");
                $("#ssn").mask("999-99-9999");
                $(".cedula").mask("999-9999999-9");
                $("#product").mask("a*-999-a999", {placeholder: " "});
                $("#eyescript").mask("~9.99 ~9.99 999");
                $("#po").mask("PO: aaa-999-***");
                $("#pct").mask("99%");
                $("#phoneAutoclearFalse").mask("(999) 999-9999", {autoclear: false, completed: function () {
                        alert("completed autoclear!");
                    }});
                $("#phoneExtAutoclearFalse").mask("(999) 999-9999? x99999", {autoclear: false});

                $("input").blur(function () {
                    $("#info").html("Unmasked value: " + $(this).mask());
                }).dblclick(function () {
                    $(this).unmask();
                });
            });
            if (typeof applet != 'undefined' && typeof applet.isChrome == 'function') {
                applet.isChrome = function () {
                    return false
                }
            }
        </script>
        <script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
    </head>
    <body>
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding w3-card-4" style="z-index: 3; width: 280px; font-weight: bold; display: none;" id="mySidebar"><br>
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Cerrar Menú</a>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>Sistema N2Care</b></h3>
            </div>
            <div class="w3-bar-block">
                <a href="#servicios" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Servicios</a>
                <a href="#especialidades" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Especialidades</a> 
                <a href="#horarioConsulta" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Horarios <br>de consultas</a> 
                <a href="#realizarConsulta" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Realizar pre consulta</a> 
                <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Contactos</a>
            </div>

            <div class="g-recaptcha w3-bar-block w3-bottom" id="gwd-reCAPTCHA_2" 
                 data-sitekey="6Ld4Z6cUAAAAAGCy8l9bYwFT9uyGDJ3tijWU6Bzg">

            </div>
        </nav>

        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right" onclick="w3_open()">☰</a>
            <span class="w3">Sistema N2Care</span>
            <div class="g-recaptcha w3-display-topright" id="gwd-reCAPTCHA_2" 
                 data-sitekey="6Ld4Z6cUAAAAAGCy8l9bYwFT9uyGDJ3tijWU6Bzg">

            </div>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" 
             style="cursor: pointer; display: none;" title="close side menu" 
             id="myOverlay">

        </div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:280px; margin-right:1px;" id="cuerpo">
            <div class="w3-container" id="servicios" style="margin-top:75px">
                <h1 class="w3-xxxlarge w3-text-red">
                    <b>
                        Servicios.
                    </b>
                </h1>
                <hr style="width:50px; border:5px solid red" class="w3-round">
                <div class="w3-panel w3-blue w3-card-4 w3-round-xlarge ">
                    <div class="w3-container" style="display: inline-block;">
                        <ul type="circle">
                            <li>Alergología</li>
                            <li>Cirugía Pediátrica</li>
                            <li>Dermatología Pediátrica</li>
                            <li>Dietética y Nutrición</li>
                            <li>Endocrinilogía Pediátrica</li>
                            <li>Fisioterapia Respiratoria</li>
                            <li>Gastroenterología</li>
                            <li>Hematología Pediátrica</li>
                            <li>Lactancia Materna</li>
                        </ul>
                    </div>
                    <div class="w3-container" style="display: inline-block;">
                        <ul type="circle">
                            <li>Logopedia</li>
                            <li>Nefrología Pediátrica</li>
                            <li>Neumología Pediátrica</li>
                            <li>Neurocirugía Pediátrica</li>
                            <li>Neurología Pedátrica</li>
                            <li>Odontopediatría</li>
                            <li>Seguimiento Neonatal</li>
                            <li>Traumatología</li><br>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="w3-container" style="margin-top:80px" id="especialidades">
                <h1 class="w3-xxxlarge w3-text-red"><b>Especialidades pediátricas</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
            </div>

            <div class="w3-row-padding">
                <div class="w3-half">
                    <img src="imagenes/C_Pediatrica_Check_Up_Neonatal.jpg" 
                         style="width:100%" onclick="onClick(this)" 
                         alt="Cuidado de su bebe desde su nacimiento" height="500px">
                    <img src="imagenes/MetricaBebe.jpg" style="width:100%" 
                         onclick="onClick(this)" 
                         alt="Seguimiento continuo, con nuestro sistema de graficas." height="500px">
                    <img src="imagenes/traumatologia-infantil.jpg" 
                         style="width:100%" onclick="onClick(this)" 
                         alt="Cuidado con esos pequeños traumas que marcan a nuestros hijos." height="500px">
                </div>
                <div class="w3-half">
                    <img src="imagenes/Hola.jpg" style="width:100%" 
                         onclick="onClick(this)" 
                         alt="Nos ganaremos la confianza del mas importante entre nosotros" height="500px">
                    <img src="imagenes/1-2-1024x1024.jpg" style="width:100%" 
                         onclick="onClick(this)" 
                         alt="Damos seguientos sobre las evoluciones del infante en todo momento." height="500px">
                    <img src="imagenes/odontopediatria1.jpg" style="width:100%" 
                         onclick="onClick(this)" 
                         alt="El cuidado vocal es una de nuestra tareas ya sean infante hasta adolecentes." height="500px">
                </div>
            </div>

            <!-- Modal for full size images on click-->
            <div id="modal01" class="w3-modal w3-blue-gray" style="padding-top:0" 
                 onclick="this.style.display = 'none'">
                <span class="w3-button w3-black w3-xxlarge w3-display-topright">×</span>
                <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
                    <img id="img01" class="w3-image">
                    <p id="caption"></p>
                </div>
            </div>

            <div class="w3-container" style="margin-top:75px" id="horarioConsulta">
                <h1 class="w3-xxxlarge w3-text-red"><b>Horario de consultas.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">

                <form name="horario" id="horario" 
                      action="" 
                      onsubmit="
                              verificacion(1);
                              return false;">                    
                    <label for="fechaConsulta">Fecha:</label>
                    <input type="date" 
                           name="fechaConsulta" 
                           id="fechaConsulta" 
                           step="1" 
                           min="2019-05-01" 
                           value="<?php echo date("Y-m-d"); ?>">
                    <div class="w3-container" id="cuerpoFecha">
                    </div>
                </form>


                <button form="horario" type="submit" 
                        class="w3-button w3-padding-large w3-blue 
                        w3-margin-bottom w3-left">
                    Consultar horarios
                </button>


            </div>

            <!--Realizar registro-->
            <div class="w3-container" id="realizarConsulta" style="margin-top:75px" >
                <h1 class="w3-xxxlarge w3-text-red"><b>Realizar pre registro.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
                <form name="registro" 
                      action="" 
                      method="POST" 
                      onsubmit="verificacion(2); return false;">
                    <div class="w3-section">
                        <h1 class="w3-xlarge w3-text-red"><b>Padre o Madre</b></h1>
                        <div class="w3-container">
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="w3-input" type="text" 
                                       name="nombrePadre" required="" 
                                       id="nombrePadre" placeholder="Ingrese sus nombre"/>
                            </div>
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="w3-input" type="text" 
                                       name="apellidosPadre" required="" 
                                       id="apellidosPadre" placeholder="Ingrese sus apellidos"/>
                            </div>
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="cedula w3-input" tabindex="2" type="text" 
                                       name="cedulaPadre" required="" 
                                       id="cedulaPadre" placeholder="Ingrese su cedula"/>
                            </div>
                        </div>
                        <div class="w3-container">
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="phone w3-input" tabindex="2" type="text" 
                                       name="telefonoPadre" required="" 
                                       id="telefonoPadre" placeholder="Ingrese numero telefonico"/>
                            </div>
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="w3-input" tabindex="2" type="email" 
                                       name="correoPadre" required="" 
                                       id="correoPadre" placeholder="Ingrese correo electronico"/>
                            </div>
                            <select name="sexoPadre" id="sexoPadre" style="display: inline-block; width: 33%;"  
                                    required="">
                                <option value="i">Seleccione su sexo</option>
                                <option value="m">Masculino</option>
                                <option value="f">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="w3-section">
                        <h1 class="w3-xlarge w3-text-red"><b>Paciente</b></h1>
                        <div class="w3-container">
                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="w3-input" type="text" 
                                       name="nombrePaciente" required="" 
                                       id="nombrePaciente" placeholder="Ingrese nombre de paciente"/>
                            </div>

                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="w3-input" type="text" 
                                       name="apellidosPaciente" required="" 
                                       id="apellidosPaciente" placeholder="Ingrese apellidos de paciente"/>
                            </div>

                            <div class="w3-section" style="display: inline-block; width: 33%;">
                                <input class="cedula w3-input" tabindex="2" type="text" 
                                       name="cedulaPaciente" required="" 
                                       id="cedulaPaciente" placeholder="Ingrese cedula del paciente"/>
                            </div>
                        </div>
                        <div class="w3-container" required="">
                            <select name="sexoPaciente" id="sexoPaciente">
                                <option value="i">Seleccione su sexo</option>
                                <option value="m">Masculino</option>
                                <option value="f">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="w3-container w3-margin-right">
                        <div id="example1">

                        </div>
                        <button type="submit"
                                class="w3-button w3-animate-bottom w3-padding-16 w3-blue w3-right">
                            Enviar pre registro
                        </button>

                    </div>
                    <div class="w3-container" id="resultadoRegistro">
                    </div>
                </form>
            </div>
            <!--Contactar a doctor-->
            <div class="w3-container" id="contact" style="margin-top:55px">
                <h1 class="w3-xxxlarge w3-text-red"><b>Contactos.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
                <form name="mensaje"
                      action="" 
                      onsubmit="
                              verificacion(3);
                              return false;">
                    <div class="w3-section">
                        <select class="w3-input w3-select" name="doctores" 
                                required="" id="doctores" style="width: 50%;">
                            <option value = '0'>
                                Seleccione un doctor
                            </option>
                            <?php
                            $link = ibase_connect('192.168.56.3:n2care', 'SYSDBA', 'Seguridad(4321)', "utf-8", "0", "3", "none");
                            echo ibase_errmsg();
                            $query = 'select LOGINNAME, PNOMBRE, APELLIDOS, '
                                    . 'ESPECIALIDAD '
                                    . 'from GET_DOCTOR '
                                    . 'where estado';
                            echo ibase_errmsg();
                            $resultado = ibase_query($link, $query);
                            echo ibase_errmsg();
                            while ($row = ibase_fetch_row($resultado)) {
                                echo ibase_errmsg();
                                echo "<option value = '" . $row[0] . "'>" .
                                $row[1] . " " .
                                $row[2] . " \t \t <b>Especialidad:</b> " .
                                $row[3] .
                                "</option>";
                            }
                            echo ibase_errmsg();
                            ibase_free_query($resultado);
                            echo ibase_errmsg();
                            ibase_close($link);
                            echo ibase_errmsg();
                            ?>
                        </select>
                        <div class="w3-section">
                            <input class="w3-input" type="text" 
                                   name="Name" required="" id="Name" 
                                   placeholder="Ingrese su nombre"
                                   style="display: inline-block; width: 50%;">
                            <input class="w3-input" type="text" 
                                   name="Email" required=""  id="Email" 
                                   placeholder="Ingrese su correo"
                                   style="display: inline-block; width: 50%;">
                        </div>
                        <div class="w3-section">
                            <textarea name="Message" required="" style="width:50%" 
                                      id="Message" rows="10" cols="50" 
                                      placeholder="Ingrese el mensaje"></textarea>
                        </div>
                    </div>
                    <button type="submit"
                            class="w3-button w3-animate-bottom w3-padding-16 w3-blue w3-center">
                        Enviar mensaje
                    </button>
                </form>
            </div>
        </div>

        <!-- W3.CSS Container -->
        <div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px"><p class="w3-right">Sistema pediátrico soportado por SoftSureña</p></div>
    </body>
</html>