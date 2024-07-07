<?php

if (!($link = ibase_connect('192.168.56.3:n2care', 'SYSDBA', 'Seguridad(4321)',
        "utf-8","0","3", "none"))) {
    echo ibase_errmsg();
    echo 'No se pudo conectar';
    exit();
}

$query = "select A.NOMBRECOMPLETO, (select TCNOMBREDIA from NOMBRE_DIA_LARGO(A.DIA)) as Dia, "
        . "A.INICIAL, A.FINAL, A.CANTIDAD_PACIENTE,  (A.CANTIDAD_PACIENTE - "
        . "(select count(*) from T_CONSULTAS C "
        . "where C.IDCONTROLCONSULTA = A.IDCONTROLCONSULTA and C.FECHA = '" . filter_input(INPUT_POST, 'fechaConsulta') . "')) "
        . "as Disponible "
        . "from GET_CONTROLCONSULTA A "
        . "where DIA = (select TCNOMBREDIA from NOMBRE_DIA_CORTO('" . filter_input(INPUT_POST, 'fechaConsulta') . "'))";


$resultado = ibase_query($link, $query);
echo ibase_errmsg();


echo '<input placeholder="Inserte valor a buscar en la tabla" oninput="w3.filterHTML(\'#tabla3\', \'.item\', this.value)">';

echo "<table class='w3-table-all w3-hoverable' id='tabla3'> "
 . "<thead> "
 . "<tr> "
 . "<th>Doct@r</th> "
 . "<th>Dia</th> "
 . "<th>Hora de inicio</th> "
 . "<th>Hora final</th> "
 . "<th>Cantidad de paciente</th> "
 . "<th>Disponible</th> "
 . "</tr> "
 . "</thead> "
 . "<tbody> ";
while ($row = ibase_fetch_row($resultado)) {
    echo "<tr class='item'> " .
    "<td >" . $row[0] . "</td>" .
    "<td >" . $row[1] . "</td>" .
    "<td >" . $row[2] . "</td>" .
    "<td >" . $row[3] . "</td>" .
    "<td align='right'>" . $row[4] . "</td>" .
    "<td align='right'>" . $row[5] . "</td>" .
    "</tr>";
}
echo "</tbody> "
 . "</table> ";
echo ibase_errmsg();
