<?php

if (!($link = ibase_connect("192.168.56.3:n2care", "SYSDBA", "Seguridad(4321)"))) {
    echo "Error al conectarse";
    echo "Codigo" . ibase_errcode();
    echo ibase_errmsg();
    exit();
}

$query = "select OUT_RESULTADO "
        . "from PRO_WEB_REGISTRO_PADRE_HIJO("
        . "'" . filter_input(INPUT_POST, "cedulaPadre") . "', "
        . "'" . filter_input(INPUT_POST, "nombrePadre") . "', "
        . "'" . filter_input(INPUT_POST, "apellidosPadre") . "', "
        . "'" . filter_input(INPUT_POST, "sexoPadre") . "', "
        . "'" . filter_input(INPUT_POST, "telefonoPadre") . "', "
        . "'" . filter_input(INPUT_POST, "correoPadre") . "', "
        . "'" . filter_input(INPUT_POST, "cedulaPaciente") . "', "
        . "'" . filter_input(INPUT_POST, "nombrePaciente") . "', "
        . "'" . filter_input(INPUT_POST, "apellidosPaciente") . "', "
        . "'" . filter_input(INPUT_POST, "sexoPaciente") . "')";

if(!($resultado = ibase_query($link, $query))){
    echo "Error al insertar a ".filter_input(INPUT_POST, "cedulaPadre");
    echo "Codigo::".ibase_errcode();
    echo $query;
    echo ibase_errmsg();
    exit();
}

$row = ibase_fetch_row($resultado);

echo '<h2>'.$row[0].'</h2>';
echo '<p>'.ibase_errmsg().'</p>';
echo '<p>'.ibase_errcode().'</p>';
ibase_free_result($resultado);
ibase_close();