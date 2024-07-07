// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
    document.getElementById("img01").src = element.src;
    document.getElementById("modal01").style.display = "block";
    var captionText = document.getElementById("caption");
    captionText.innerHTML = element.alt;
}
function limpiar() {
    document.getElementById('Name').value = '';
    document.getElementById('Email').value = '';
    document.getElementById('Message').value = '';
    document.getElementById('estado').value = '';
    document.getElementById('doctores').value = 0;
}
function limpiar2() {
    document.getElementById('nombrePadre').value = '';
    document.getElementById('apellidosPadre').value = '';
    document.getElementById('cedulaPadre').value = '';
    document.getElementById('telefonoPadre').value = '';
    document.getElementById('nombrePaciente').value = '';
    document.getElementById('apellidosPaciente').value = '';
    document.getElementById('cedulaPaciente').value = '';
    document.getElementById('sexoPaciente').value = 'n';
    document.getElementById('sexoPadre').value = 'n';
}

function tiempo() {
    setTimeout('limpiar();', 2000);
    return false;
}

function tiempo1() {
    setTimeout('horario();', 2000);
    return false;
}

function tiempo2() {
    setTimeout('limpiar2();', 2000);
    return false;
}

function objetoAjax() {
    var xmlhttp = false;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {

        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }

    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function enviarDatos() {

    //Recogemos los valores introducimos en los campos de texto
    doctores = document.mensaje.doctores.value;
    Name = document.mensaje.Name.value;
    Email = document.mensaje.Email.value;
    Message = document.mensaje.Message.value;
    //instanciamos el objetoAjax
    ajax = objetoAjax();

    //Abrimos una conexión AJAX pasando como parámetros el método de envío, y el archivo que realizará las operaciones deseadas
    ajax.open("POST", "../contactos/mensaje.php", true);

    //cuando el objeto XMLHttpRequest cambia de estado, la función se inicia
    ajax.onreadystatechange = function () {

        //Cuando se completa la petición, mostrará los resultados
        if (ajax.readyState == 4) {
            //El método responseText() contiene el texto de nuestro 'consultar.php'. Por ejemplo, cualquier texto que mostremos por un 'echo'
            alert('Enviado');
        }
    }

    //Llamamos al método setRequestHeader indicando que los datos a enviarse están codificados como un formulario.
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    //enviamos las variables a 'consulta.php'
    ajax.send("&doctores=" + doctores + "&Name=" + Name + "&Email=" + Email + "&Message=" + Message);

}

function getHorario() {
    //Recogemos los valores introducimos en los campos de texto
    fechaConsulta = document.horario.fechaConsulta.value;

    //Aquí será donde se mostrará el resultado
    resultado = document.getElementById('cuerpoFecha');

    //instanciamos el objetoAjax
    ajax = objetoAjax();

    //Abrimos una conexión AJAX pasando como parámetros el método de envío, y el archivo que realizará las operaciones deseadas
    ajax.open('POST', 'horario/consultaHorario.php', true);

    //cuando el objeto XMLHttpRequest cambia de estado, la función se inicia
    ajax.onreadystatechange = function () {
        resultado.innerHTML = (ajax.responseText);
    }

    //Llamamos al método setRequestHeader indicando que los datos a enviarse están codificados como un formulario.
    ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    //enviamos las variables a 'consulta.php'
    ajax.send('&fechaConsulta=' + fechaConsulta);
}

function registroPadrePaciente() {
    //Recogemos los valores introducimos en los campos de texto
    nombrePadre = document.registro.nombrePadre.value;
    apellidosPadre = document.registro.apellidosPadre.value;
    cedulaPadre = document.registro.cedulaPadre.value;
    telefonoPadre = document.registro.telefonoPadre.value;
    correoPadre = document.registro.correoPadre.value;
    sexoPadre = document.registro.sexoPadre.value;

    cedulaPaciente = document.registro.cedulaPaciente.value;
    nombrePaciente = document.registro.nombrePaciente.value;
    apellidosPaciente = document.registro.apellidosPaciente.value;
    sexoPaciente = document.registro.sexoPaciente.value;

    if (sexoPaciente == 'n' || sexoPadre == 'n') {
        alert('Seleccione el sexo');
        return;
    }


    //Aquí será donde se mostrará el resultado
    resultado = document.getElementById('resultadoRegistro');

    //instanciamos el objetoAjax
    ajax = objetoAjax();

    //Abrimos una conexión AJAX pasando como parámetros el método de envío, y el archivo que realizará las operaciones deseadas
    ajax.open('POST', 'consulta/registro.php', true);

    //cuando el objeto XMLHttpRequest cambia de estado, la función se inicia
    ajax.onreadystatechange = function () {
        resultado.innerHTML = (ajax.responseText);
    };

    //Llamamos al método setRequestHeader indicando que los datos a enviarse están codificados como un formulario.
    ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    //enviamos las variables a 'consulta.php'
    ajax.send('&nombrePadre=' + nombrePadre + '&apellidosPadre=' + apellidosPadre +
            '&cedulaPadre=' + cedulaPadre + '&telefonoPadre=' + telefonoPadre +
            '&correoPadre=' + correoPadre + '&sexoPadre=' + sexoPadre +
            '&cedulaPaciente=' + cedulaPaciente + '&nombrePaciente=' + nombrePaciente +
            '&apellidosPaciente=' + apellidosPaciente + '&sexoPaciente=' + sexoPaciente);
}


function verificacion(Element) {
    var response = grecaptcha.getResponse();

    if (response.length == 0) {
        alert("Captcha no verificado");
    }
    switch (Element) {
        case 1:
            getHorario();
            break;
        case 2:
            registroPadrePaciente();
            break;
        case 3:
            enviarDatos();
            tiempo();
            break;
        default:
            alert('Caso no registrado');
            break;
    }
}