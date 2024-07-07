<?php
$link = ibase_connect('192.168.56.3:n2care', 'SYSDBA', 'Seguridad(4321)');

if($link){
    echo 'Conecto';
}else{
    echo "No se conecto";
    echo ibase_errmsg();
    exit();
}
echo '<br>';
$query = "insert into T_MENSAJE (LOGINNAME, NOMBRE, CORREO, MENSAJE) "
        . "values (".filter_input(INPUT_POST, 'doctores').", '"
        . "".filter_input(INPUT_POST, 'Name')."', '"
        . "".filter_input(INPUT_POST, 'Email')."', '"
        . "".filter_input(INPUT_POST, 'Message')."')";

$resultado = ibase_query($link, $query);

echo ibase_errmsg();

if($resultado){
    echo 'Mensaje enviado';
}else{
    echo 'Mensaje no enviado';
}
echo ibase_errmsg();
ibase_free_result($resultado);
ibase_close($link);

