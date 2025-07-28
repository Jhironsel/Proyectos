
/* Setting properties */

SET NAMES UTF8;
SET SQL DIALECT 3;
CONNECT 'localhost/3050:softsurena.db' USER 'sysdba' PASSWORD '1';
SET AUTODDL ON;

/* ----- Creating Domains ----- */

/* D_ABREVIATURA */
CREATE DOMAIN D_ABREVIATURA AS CHAR(1)
	NOT NULL
	CHECK (VALUE IN('S', 'I', 'U', 'D', 'G', 'M', 'X', 'R'))
	COLLATE UTF8;

/* D_APELLIDOS */
CREATE DOMAIN D_APELLIDOS AS VARCHAR(40)
	DEFAULT ''
	CHECK (value similar to '[[:ALPHA:]-'' .ÑñÁáÉéÍíÓóÚú]*' escape '@')
	COLLATE UTF8;

/* D_BLOB_BINARIO */
CREATE DOMAIN D_BLOB_BINARIO AS BLOB SUB_TYPE BINARY;

/* D_BLOB_TEXTO */
CREATE DOMAIN D_BLOB_TEXTO AS BLOB SUB_TYPE TEXT
	COLLATE UTF8;

/* D_BOOLEAN_F */
CREATE DOMAIN D_BOOLEAN_F AS BOOLEAN
	DEFAULT FALSE
	NOT NULL;

/* D_BOOLEAN_T */
CREATE DOMAIN D_BOOLEAN_T AS BOOLEAN
	DEFAULT TRUE;

/* D_CANTIDAD_PACIENTE */
CREATE DOMAIN D_CANTIDAD_PACIENTE AS SMALLINT
	DEFAULT 0
	CHECK (VALUE >= 0);

/* D_CEDULA */
CREATE DOMAIN D_CEDULA AS CHAR(13)
	CHECK (value similar to '[[:DIGIT:]]{3}[-][[:DIGIT:]]{7}[-][[:DIGIT:]]{1}')
	COLLATE UTF8;
COMMENT ON DOMAIN D_CEDULA IS 'Esto es una cedula por ejemplo: 000-0012345-2';

/* D_CLAVE */
CREATE DOMAIN D_CLAVE AS VARCHAR(30)
	COLLATE UTF8;

/* D_CODIGO */
CREATE DOMAIN D_CODIGO AS VARCHAR(20)
	COLLATE UTF8;

/* D_CODIGO_CUENTA_CONTABLE */
CREATE DOMAIN D_CODIGO_CUENTA_CONTABLE AS VARCHAR(14)
	NOT NULL
	COLLATE UTF8;

/* D_CODIGO_PAI */
CREATE DOMAIN D_CODIGO_PAI AS CHAR(7)
	COLLATE UTF8;

/* D_CORREO */
CREATE DOMAIN D_CORREO AS VARCHAR(100)
	CHECK (trim(VALUE) SIMILAR TO '[[:ALNUM:]-_.]*@[[:ALNUM:]-_]*.[[:ALPHA:].]*' and 
     ascii_val(SUBSTRING(VALUE FROM 1 FOR 1)) > 65 and ascii_val(SUBSTRING(VALUE FROM 1 FOR 1)) < 90 or 
     ascii_val(SUBSTRING(VALUE FROM 1 FOR 1)) > 97 and ascii_val(SUBSTRING(VALUE FROM 1 FOR 1)) < 122)
	COLLATE UTF8;

/* D_DEDO */
CREATE DOMAIN D_DEDO AS CHAR(2)
	DEFAULT 'IN'
	NOT NULL
	CHECK (value in('PU', 'IN', 'MA', 'AN', 'ME'))
	COLLATE UTF8;

/* D_DESCUENTO */
CREATE DOMAIN D_DESCUENTO AS NUMERIC(5,2)
	DEFAULT 0.00
	CHECK (VALUE >= 0 AND VALUE <= 100);

/* D_DIA */
CREATE DOMAIN D_DIA AS CHAR(2)
	DEFAULT 'LU'
	CHECK (value in('LU', 'MA', 'MI', 'JU', 'VI', 'SA', 'DO'))
	COLLATE UTF8;

/* D_DINERO */
CREATE DOMAIN D_DINERO AS NUMERIC(18,2)
	DEFAULT 0.00;

/* D_DOBLE_PRESICION */
CREATE DOMAIN D_DOBLE_PRESICION AS DOUBLE PRECISION;

/* D_EDAD */
CREATE DOMAIN D_EDAD AS SMALLINT
	DEFAULT 0
	NOT NULL
	CHECK (VALUE >= 0);
COMMENT ON DOMAIN D_EDAD IS 'Dominio que se encarga de asegurar que las edades sean mayores a 0.';

/* D_ESTADO_CIVIL */
CREATE DOMAIN D_ESTADO_CIVIL AS CHAR(1)
	DEFAULT 'S'
	CHECK (VALUE IN ('S', 'C', 'D', 'V', 'U', 'X'))
	COLLATE UTF8;
COMMENT ON DOMAIN D_ESTADO_CIVIL IS '
El dominio D_ESTADO_CIVIL admitirá una sola letra mayúscula la cual puede ser:
S(soltero)
C(casado)
D(divorciado)
V(viudo)
U(Union Libre)
X(Desconocido)

';

/* D_ESTADO_C_I_P_A_N_T */
CREATE DOMAIN D_ESTADO_C_I_P_A_N_T AS CHAR(1)
	DEFAULT 'i'
	CHECK (LOWER(VALUE) IN('c','i', 'p', 'a', 'n', 't'))
	COLLATE UTF8;
COMMENT ON DOMAIN D_ESTADO_C_I_P_A_N_T IS 'Los Estados de una Deuda 
Credito (c)
Inicial (i)
Pagada (p)
Abonada (a)
Nulada (n)
Temporal (t)
Se propone un estado de factura cerrada, la cual no puede ser tocada nuevamente.
';

/* D_ESTADO_ENTRADA_PRODUCTO */
CREATE DOMAIN D_ESTADO_ENTRADA_PRODUCTO AS CHAR(1)
	DEFAULT 't'
	NOT NULL
	CHECK (VALUE IN('t', 'r', 's', 'd'))
	COLLATE UTF8;

/* D_ESTADO_MENSAJES */
CREATE DOMAIN D_ESTADO_MENSAJES AS CHAR(1)
	DEFAULT 'N'
	NOT NULL
	CHECK (VALUE IN('N', 'L', 'R', 'B'))
	COLLATE UTF8;

/* D_FECHA */
CREATE DOMAIN D_FECHA AS DATE
	DEFAULT CURRENT_DATE;

/* D_FECHA_HORA */
CREATE DOMAIN D_FECHA_HORA AS TIMESTAMP
	DEFAULT CURRENT_TIMESTAMP;

/* D_HORA */
CREATE DOMAIN D_HORA AS TIME
	DEFAULT CURRENT_TIME;

/* D_ID */
CREATE DOMAIN D_ID AS INTEGER
	CHECK (VALUE >= -1);

/* D_ID_DEFAULT_0 */
CREATE DOMAIN D_ID_DEFAULT_0 AS INTEGER
	DEFAULT 0
	NOT NULL
	CHECK (VALUE >= 0 );

/* D_ID_MAYOR_0 */
CREATE DOMAIN D_ID_MAYOR_0 AS INTEGER
	NOT NULL
	CHECK (VALUE > 0);

/* D_INSERT_DELETE */
CREATE DOMAIN D_INSERT_DELETE AS CHAR(1)
	DEFAULT 'I'
	NOT NULL
	CHECK (UPPER(value) in('I', 'D'))
	COLLATE UTF8;

/* D_LINEA */
CREATE DOMAIN D_LINEA AS SMALLINT
	DEFAULT 0
	CHECK (VALUE >= 0);

/* D_MEDIDA */
CREATE DOMAIN D_MEDIDA AS NUMERIC(18,2)
	DEFAULT 0.00;
COMMENT ON DOMAIN D_MEDIDA IS 'Este dominio puede representar valores de medidas, peso, valores.';

/* D_MES */
CREATE DOMAIN D_MES AS SMALLINT
	DEFAULT 1
	NOT NULL
	CHECK (VALUE BETWEEN 1 AND 12);

/* D_MONEDA */
CREATE DOMAIN D_MONEDA AS VARCHAR(3)
	DEFAULT 'DOP'
	NOT NULL
	CHECK (value in('DOP', 'USD', 'EUR'))
	COLLATE UTF8;

/* D_NIVEL_CUENTA */
CREATE DOMAIN D_NIVEL_CUENTA AS CHAR(1)
	DEFAULT 'X'
	NOT NULL
	CHECK (VALUE IN('D', 'G'))
	COLLATE UTF8;

/* D_NOMBRES */
CREATE DOMAIN D_NOMBRES AS VARCHAR(40)
	DEFAULT ''
	CHECK (value similar to '[[:ALPHA:]-'' .ÑñÁáÉéÍíÓóÚú]*' escape '@')
	COLLATE UTF8;

/* D_PERSONA */
CREATE DOMAIN D_PERSONA AS CHAR(1)
	DEFAULT 'F'
	CHECK (VALUE in ('F', 'J', 'X'))
	COLLATE UTF8;

/* D_PUNTO_CARDINALES */
CREATE DOMAIN D_PUNTO_CARDINALES AS VARCHAR(5)
	DEFAULT 'N/A'
	CHECK (VALUE IN('Norte', 'Este', 'Sur', 'Oeste', 'N/A'))
	COLLATE UTF8;

/* D_ROL */
CREATE DOMAIN D_ROL AS CHAR(31)
	DEFAULT CURRENT_ROLE
	NOT NULL
	COLLATE UTF8;

/* D_SANGRE_SIMBOLOS */
CREATE DOMAIN D_SANGRE_SIMBOLOS AS VARCHAR(3)
	DEFAULT 'N/A'
	CHECK (VALUE in('N/A','O-','O+', 'A-', 'A+', 'B-', 'B+', 'AB-', 'AB+'))
	COLLATE UTF8;

/* D_SEXO */
CREATE DOMAIN D_SEXO AS CHAR(1)
	DEFAULT 'M'
	CHECK (UPPER(value) = 'M' or UPPER(value) = 'F' or UPPER(value) = 'X')
	COLLATE UTF8;
COMMENT ON DOMAIN D_SEXO IS 'Dominio que describe el sexo de las personas, indicando M Masculino, Femenino y X indica seleccionar sexo. ';

/* D_TELEFONO */
CREATE DOMAIN D_TELEFONO AS CHAR(16)
	CHECK (value similar to '[+][1][(][[:digit:]]{3}[)][ ][[:digit:]]{3}[-][[:digit:]]{4}')
	COLLATE UTF8;

/* D_TIEMPO_GESTACION */
CREATE DOMAIN D_TIEMPO_GESTACION AS NUMERIC(4,2)
	DEFAULT 4
	NOT NULL
	CHECK (VALUE > 1 AND VALUE < 10);

/* D_TIPO_CUENTAS */
CREATE DOMAIN D_TIPO_CUENTAS AS VARCHAR(2)
	DEFAULT 'XX'
	NOT NULL
	CHECK ((VALUE IN('A', 'PA', 'PT', 'I', 'G', 'CC', 'CO'))
/*
     A  = ACTIVO,
     PA = PASIVO, 
     PT = PATRIMONIO, 
     I  = INGRESOS, 
     G  = GASTOS, 
     CC = CUENTAS DE CIERRE, 
     CO = CUENTAS DE ORDEN.
*/)
	COLLATE UTF8;
COMMENT ON DOMAIN D_TIPO_CUENTAS IS '/*
     A  = ACTIVO,
     PA = PASIVO, 
     PT = PATRIMONIO, 
     I  = INGRESOS, 
     G  = GASTOS, 
     CC = CUENTAS DE CIERRE, 
     CO = CUENTAS DE ORDEN.
*/';

/* D_TURNO */
CREATE DOMAIN D_TURNO AS SMALLINT
	DEFAULT 0
	CHECK (VALUE >= 0);

/* D_USER_NAME */
CREATE DOMAIN D_USER_NAME AS VARCHAR(63)
	DEFAULT CURRENT_USER
	NOT NULL
	COLLATE UTF8;

/* D_VARCHAR_1024 */
CREATE DOMAIN D_VARCHAR_1024 AS VARCHAR(1024)
	COLLATE UTF8;

/* D_VARCHAR_15 */
CREATE DOMAIN D_VARCHAR_15 AS VARCHAR(15)
	COLLATE UTF8;

/* D_VARCHAR_25 */
CREATE DOMAIN D_VARCHAR_25 AS VARCHAR(25)
	COLLATE UTF8;

/* D_VARCHAR_255 */
CREATE DOMAIN D_VARCHAR_255 AS VARCHAR(255)
	COLLATE UTF8;

/* D_VARCHAR_45 */
CREATE DOMAIN D_VARCHAR_45 AS VARCHAR(45)
	COLLATE UTF8;

/* D_VARCHAR_70 */
CREATE DOMAIN D_VARCHAR_70 AS VARCHAR(70)
	COLLATE UTF8;

/* D_VARCHAR_MAX */
CREATE DOMAIN D_VARCHAR_MAX AS VARCHAR(32765) CHARACTER SET ISO8859_1
	COLLATE ES_ES_CI_AI;

/* D_YEAR */
CREATE DOMAIN D_YEAR AS SMALLINT
	DEFAULT 0
	CHECK (VALUE >= 0);

/* ----- Creating Tables ----- */

/* ALMACENES */
CREATE TABLE ALMACENES (
    ID D_ID NOT NULL,
    NOMBRE D_VARCHAR_70,
    UBICACION D_VARCHAR_255,
    ESTADO D_BOOLEAN_T,
    BORRADO D_BOOLEAN_F NOT NULL);


/* ALMACENES_DISPONIBLE */
CREATE TABLE ALMACENES_DISPONIBLE (
    ID D_ID NOT NULL,
    ID_TURNO D_ID_DEFAULT_0 NOT NULL,
    ID_ALMACEN D_ID_DEFAULT_0 NOT NULL,
    USER_NAME D_USER_NAME);


/* ANTECEDENTES */
CREATE TABLE ANTECEDENTES (
    ID D_ID NOT NULL,
    ID_CONSULTA D_ID_DEFAULT_0 NOT NULL,
    DESCRIPCION D_VARCHAR_1024 NOT NULL);

COMMENT ON TABLE ANTECEDENTES IS 'Es una tabla utilizada para almacenar los antecedentes de los pacientes del sistema, dicho antecedente describe la condicion de los paciente en el momento de la consulta.';

/* ARS */
CREATE TABLE ARS (
    ID D_ID NOT NULL,
    DESCRIPCION D_VARCHAR_45 NOT NULL,
    COVERCONSULTAPORC D_DESCUENTO NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    CANTIDAD_REGISTRO D_ID,
    USER_NAME D_USER_NAME,
    ROL D_ROL NOT NULL);

COMMENT ON TABLE ARS IS 'Tabla que almacenas las propiedades basicas de los seguros con lo que opera el sistema.

Descripcion seria el nombre de la aseguradora, la converConsulta guardar el valor en porciento de lo que el seguro cubre por consulta.';

/* ASEGURADOS */
CREATE TABLE ASEGURADOS (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID_DEFAULT_0 NOT NULL,
    ID_ARS D_ID_DEFAULT_0 NOT NULL,
    NO_NSS D_VARCHAR_25 NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL);


/* CARGOS */
CREATE TABLE CARGOS (
    ID D_ID_DEFAULT_0 NOT NULL,
    ID_DEPARTAMENTO D_ID_DEFAULT_0 NOT NULL,
    NOMBRE D_NOMBRES,
    DESCRIPCION D_VARCHAR_1024,
    ESTADO D_BOOLEAN_T);

COMMENT ON COLUMN CARGOS.ID IS 'Identificador del registros.';
COMMENT ON COLUMN CARGOS.ID_DEPARTAMENTO IS 'Identificador del departamento al que cargo pertenece.';
COMMENT ON COLUMN CARGOS.NOMBRE IS 'Nombre unico del cargo.';
COMMENT ON COLUMN CARGOS.DESCRIPCION IS 'La descripcion del cargo. ';
COMMENT ON COLUMN CARGOS.ESTADO IS 'Estado del cargo si esta disponible para seguir asignando. ';
COMMENT ON TABLE CARGOS IS 'Registros de los cargos de los empleados del sistema.';

/* CARTONES_BINGO */
CREATE TABLE CARTONES_BINGO (
    ID D_ID NOT NULL,
    CARTON_HASH D_ID NOT NULL,
    FECHA_CREACCION D_FECHA_HORA NOT NULL,
    MATRIZ_OBJ D_BLOB_TEXTO NOT NULL,
    ESTADO D_BOOLEAN_T);


/* CATEGORIAS */
CREATE TABLE CATEGORIAS (
    ID D_ID NOT NULL,
    DESCRIPCION D_VARCHAR_70,
    FECHA_CREACION D_FECHA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    USER_NAME D_USER_NAME);


/* CONSULTAS */
CREATE TABLE CONSULTAS (
    ID D_ID NOT NULL,
    ID_CONTROL_CONSULTA D_ID_DEFAULT_0,
    ID_PACIENTE D_ID_DEFAULT_0,
    FECHA D_FECHA NOT NULL,
    LINEA D_LINEA NOT NULL,
    ESTADO D_BOOLEAN_T,
    USER_NAME D_USER_NAME,
    COD_AUTORIZACION D_VARCHAR_15,
    COSTO D_DINERO,
    DESCUENTO D_DESCUENTO,
    TOTALCOSTO NUMERIC(18,2));

COMMENT ON COLUMN CONSULTAS.ID IS 'Identificador de la consulta.';
COMMENT ON COLUMN CONSULTAS.ID_CONTROL_CONSULTA IS 'Identificador del control de la consulta que indica fecha y hora de la consulta.
';
COMMENT ON COLUMN CONSULTAS.ID_PACIENTE IS 'Es el identificador de los paciente del sistema o la tabla PERSONAS_PACIENTES.';
COMMENT ON COLUMN CONSULTAS.FECHA IS 'Es la fecha en la que se realiza la consulta.';
COMMENT ON COLUMN CONSULTAS.LINEA IS 'Es el orden de los paciente en la consulta. ';
COMMENT ON COLUMN CONSULTAS.ESTADO IS 'Es el estado de la consulta que se desea realizar.

Si su valor es verdadero quiere decir que 

Si su valor es falso quiere decir que ';
COMMENT ON COLUMN CONSULTAS.USER_NAME IS 'Usuario que realiza la consulta. ';

/* CONTACTOS_DIRECCIONES */
CREATE TABLE CONTACTOS_DIRECCIONES (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID_DEFAULT_0 NOT NULL,
    ID_PROVINCIA D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    ID_MUNICIPIO D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    ID_DISTRITO_MUNICIPAL D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    ID_CODIGO_POSTAL D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    DIRECCION D_VARCHAR_255 DEFAULT 'Sin direccion ingresada' NOT NULL,
    FECHA D_FECHA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    POR_DEFECTO D_BOOLEAN_F NOT NULL);

COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID IS 'Identificador del registro.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA IS 'Identificador de la personas en el sistema.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA IS 'Identificador de la pronvincia que tiene registrada la persona.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO IS 'Identificador del municipio que tiene registrada la persona.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL IS 'Identificador del distrito municipal que tiene registrada la persona.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL IS 'Identificador del codigo postal que tiene registrada la persona.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.DIRECCION IS 'Direccion de la persona en la cual se debe registrar el nombre de la calle y numero de la casa o referencia.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.FECHA IS 'Fecha en la que se hizo el registro en el sistema.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.ESTADO IS 'Este campo indica si la direccion de la persona sigue utilizando  dicha direccion.';
COMMENT ON COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO IS 'Este campo indica si la direccion es la principal utilizada por el sistema.';
COMMENT ON TABLE CONTACTOS_DIRECCIONES IS 'Tabla que almacena la direcciones de las personas en el sistema.

Se supone que estos registros no deben de eliminarse al menos que 
no tenga registros asociado a la llave primaria.';

/* CONTACTOS_EMAIL */
CREATE TABLE CONTACTOS_EMAIL (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID_DEFAULT_0 NOT NULL,
    EMAIL D_CORREO NOT NULL,
    FECHA D_FECHA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    POR_DEFECTO D_BOOLEAN_T NOT NULL);

COMMENT ON COLUMN CONTACTOS_EMAIL.ID IS 'Identificador del registro de contacto de la persona.';
COMMENT ON COLUMN CONTACTOS_EMAIL.ID_PERSONA IS 'Identificador de la persona que se ha registrado.';
COMMENT ON COLUMN CONTACTOS_EMAIL.EMAIL IS 'Correo de la persona que es propietario de este registros.';

/* CONTACTOS_TEL */
CREATE TABLE CONTACTOS_TEL (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID_DEFAULT_0 NOT NULL,
    TELEFONO D_TELEFONO NOT NULL,
    TIPO D_VARCHAR_15 NOT NULL,
    FECHA D_FECHA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    POR_DEFECTO D_BOOLEAN_T NOT NULL);

COMMENT ON COLUMN CONTACTOS_TEL.ID IS 'Identificador de registro.';
COMMENT ON COLUMN CONTACTOS_TEL.ID_PERSONA IS 'Identificador de la persona propietario del numero de telefono.';
COMMENT ON COLUMN CONTACTOS_TEL.TELEFONO IS 'Registros de telefono que sera unico para una persona, Dos o mas persona pueden ser propietario de un numero telefonico.';
COMMENT ON COLUMN CONTACTOS_TEL.TIPO IS 'Indica si es un celular movil, residencial, fax, entre otros. ';
COMMENT ON COLUMN CONTACTOS_TEL.FECHA IS 'Fecha de registro consultado. ';
COMMENT ON COLUMN CONTACTOS_TEL.ESTADO IS 'Estado del registro, indicando si es activo o inactivo.';
COMMENT ON COLUMN CONTACTOS_TEL.POR_DEFECTO IS 'Indica cual es el telefono registrado por defecto de la persona. ';

/* CONTROL_CONSULTA */
CREATE TABLE CONTROL_CONSULTA (
    ID D_ID NOT NULL,
    USER_NAME D_USER_NAME,
    CANTIDAD_PACIENTE D_CANTIDAD_PACIENTE,
    DIA D_DIA,
    INICIAL D_HORA,
    FINAL D_HORA,
    ESTADO D_BOOLEAN_T,
    USER_NAME_ D_USER_NAME);

COMMENT ON COLUMN CONTROL_CONSULTA.ID IS 'Identificador del registros del control de la consultas medicas.';
COMMENT ON COLUMN CONTROL_CONSULTA.USER_NAME IS 'Este campo es utilizando para guardar el usuario que va a tener consultas programadas cierto dias.
Deberia contener un rol de doctor por lo menos.
';
COMMENT ON COLUMN CONTROL_CONSULTA.CANTIDAD_PACIENTE IS 'Cantidad de paciente que este control admiten en un dia de consulta en la semana.';
COMMENT ON COLUMN CONTROL_CONSULTA.DIA IS 'El dia que este control de consulta tiene. <LU MA MI JU VI SA DO>';
COMMENT ON COLUMN CONTROL_CONSULTA.INICIAL IS 'Hora que arranca la consulta del dia.';
COMMENT ON COLUMN CONTROL_CONSULTA.FINAL IS 'Hora en la que no se acepta mas consulta en el sistema.';
COMMENT ON COLUMN CONTROL_CONSULTA.ESTADO IS 'El estado de esta control, pues puede ser cambiado por el doctor en un dia determinado. ';
COMMENT ON COLUMN CONTROL_CONSULTA.USER_NAME_ IS 'Este campo guarda el usuario que realizo el registro. ';

/* DEPARTAMENTOS */
CREATE TABLE DEPARTAMENTOS (
    ID D_ID NOT NULL,
    NOMBRE D_NOMBRES NOT NULL,
    DESCRIPCION D_VARCHAR_255,
    ESTADO D_BOOLEAN_T NOT NULL);


/* D_ANALISIS */
CREATE TABLE D_ANALISIS (
    ID D_ID NOT NULL,
    LINEA D_ID NOT NULL,
    ID_M_ANALISIS D_ID_DEFAULT_0 NOT NULL,
    ID_T_ANALITICA D_ID_DEFAULT_0 NOT NULL,
    OTRO D_VARCHAR_1024);


/* D_DEUDAS_PAGAS */
CREATE TABLE D_DEUDAS_PAGAS (
    ID D_ID NOT NULL,
    ID_DEUDAS D_ID_DEFAULT_0 NOT NULL,
    MONTO_PAGO D_DINERO NOT NULL,
    FECHA_HORA D_FECHA_HORA DEFAULT CURRENT_TIMESTAMP NOT NULL);

COMMENT ON TABLE D_DEUDAS_PAGAS IS 'En esta tabla llevamos los pagos de los cliente a las deudas registrada en la tabla de Deudas.';

/* D_ENTRADA_PRODUCTOS */
CREATE TABLE D_ENTRADA_PRODUCTOS (
    ID D_ID NOT NULL,
    LINEA D_ID NOT NULL,
    ID_M_ENTRADA_PRODUCTO D_ID_DEFAULT_0 NOT NULL,
    ID_ALMACEN D_ID,
    ID_PRODUCTO D_ID_DEFAULT_0 NOT NULL,
    ENTRADA D_MEDIDA NOT NULL,
    COSTO D_DINERO NOT NULL,
    FECHA_VECIMIENTO D_FECHA,
    OBSERVACION D_VARCHAR_1024);

COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.ID IS 'Identificador del registro de la entrada del producto.';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.LINEA IS 'Consecutivo de la lista de producto ingresado al sistema.';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.ID_M_ENTRADA_PRODUCTO IS 'Es el identificador maestro de la entra del producto al sistema. ';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.ID_ALMACEN IS 'Es el identificador del almacen donde este producto fue almacenado.';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.ID_PRODUCTO IS 'Identificador unico del producto.';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.ENTRADA IS 'Es la cantidad de producto a ingresar al invetario del sistema.';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.COSTO IS 'Campo que representa el costo del producto. ';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.FECHA_VECIMIENTO IS 'Es la fecha de vecimiento de algunos productos en el sistema. No es un campo obligatorio. ';
COMMENT ON COLUMN D_ENTRADA_PRODUCTOS.OBSERVACION IS 'Se agrega informacion extra de los productos en el sistema al momento de agregarlo al inventario.';

/* D_FACTURAS */
CREATE TABLE D_FACTURAS (
    ID D_ID NOT NULL,
    LINEA D_ID NOT NULL,
    ID_FACTURA D_ID_DEFAULT_0 NOT NULL,
    ID_PRODUCTO D_ID_DEFAULT_0 NOT NULL,
    ID_PRECIO D_ID_DEFAULT_0 NOT NULL,
    CANTIDAD D_DINERO NOT NULL);

COMMENT ON COLUMN D_FACTURAS.ID IS 'Identificador del registros.';
COMMENT ON COLUMN D_FACTURAS.LINEA IS 'Identifica el orden del registros cuando fue insertado.';
COMMENT ON COLUMN D_FACTURAS.ID_FACTURA IS 'Identificador de la factura maestra.';
COMMENT ON COLUMN D_FACTURAS.ID_PRODUCTO IS 'Identificador del producto.';
COMMENT ON COLUMN D_FACTURAS.ID_PRECIO IS 'Identificador del precio del producto. ';
COMMENT ON COLUMN D_FACTURAS.CANTIDAD IS 'La cantidad que desea el cliente del producto, sera multiplicado por el precio del producto.';

/* D_GUIA_VIGILANCIA_DESARROLLO */
CREATE TABLE D_GUIA_VIGILANCIA_DESARROLLO (
    ID D_ID NOT NULL,
    ID_GVD D_ID_DEFAULT_0 NOT NULL,
    ID_PACIENTE D_ID_DEFAULT_0 NOT NULL,
    FECHA D_FECHA_HORA);


/* D_MOTIVO_CONSULTA */
CREATE TABLE D_MOTIVO_CONSULTA (
    ID D_ID NOT NULL,
    ID_CONSULTA D_ID_DEFAULT_0 NOT NULL,
    ID_MOTIVO_CONSULTA D_ID_DEFAULT_0 NOT NULL);


/* D_RECETAS */
CREATE TABLE D_RECETAS (
    ID D_ID NOT NULL,
    ID_RECETA D_ID_DEFAULT_0 NOT NULL,
    LINEA D_LINEA NOT NULL,
    ID_MEDICAMENTO D_ID_DEFAULT_0 NOT NULL,
    CANTIDAD D_MEDIDA NOT NULL,
    D_DOSIS D_VARCHAR_255);

COMMENT ON COLUMN D_RECETAS.ID IS 'Identificador del registro.';
COMMENT ON COLUMN D_RECETAS.ID_RECETA IS 'Identifica una receta creada por el sistema. ';
COMMENT ON COLUMN D_RECETAS.LINEA IS 'Identifica el orden de  la receta.';
COMMENT ON COLUMN D_RECETAS.ID_MEDICAMENTO IS 'identificador del producto o medicamento registrado en la tabla de productos. ';
COMMENT ON COLUMN D_RECETAS.CANTIDAD IS 'Cantidad de que se requiere del medicamento o producto. ';
COMMENT ON COLUMN D_RECETAS.D_DOSIS IS 'Se registra la forma de como se tomara el medicamento el paciente.';

/* ERRORES */
CREATE TABLE ERRORES (
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    ERR_MODULO D_USER_NAME,
    ERR_USUARIO D_USER_NAME DEFAULT CURRENT_USER,
    ERR_TIEMPO D_FECHA_HORA DEFAULT CURRENT_TIMESTAMP,
    ERR_COMENT D_VARCHAR_255)
SQL SECURITY DEFINER;


/* FOTO_CATEGORIA */
CREATE TABLE FOTO_CATEGORIA (
    ID D_ID NOT NULL,
    ID_CATEGORIA D_ID NOT NULL,
    FOTO D_BLOB_TEXTO NOT NULL,
    FECHA_HORA_CREACION D_FECHA_HORA NOT NULL,
    ACTUAL D_BOOLEAN_T NOT NULL);

COMMENT ON TABLE FOTO_CATEGORIA IS 'Tabla que administra las fotos de las Categorias, esta hecha para guardar un historial de las fotos de las Categorias en el sistema.';

/* FOTO_PERSONA */
CREATE TABLE FOTO_PERSONA (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID NOT NULL,
    FOTO D_BLOB_TEXTO NOT NULL,
    FECHA_HORA_CREACION D_FECHA_HORA NOT NULL,
    ACTUAL D_BOOLEAN_T NOT NULL);

COMMENT ON TABLE FOTO_PERSONA IS 'Tabla que administra las fotos de las personas, esta hecha para guardar un historial de las fotos de las personas en el sistema.';

/* FOTO_PRODUCTO */
CREATE TABLE FOTO_PRODUCTO (
    ID D_ID NOT NULL,
    ID_PRODUCTO D_ID NOT NULL,
    FOTO D_BLOB_TEXTO NOT NULL,
    FECHA_HORA_CREACION D_FECHA_HORA NOT NULL,
    ACTUAL D_BOOLEAN_T NOT NULL);

COMMENT ON TABLE FOTO_PRODUCTO IS 'Tabla que administra las fotos de los productos, esta hecha para guardar un historial de las fotos de los productos en el sistema.';

/* GENERALES */
CREATE TABLE GENERALES (
    ID D_ID NOT NULL,
    ID_PERSONA D_ID_DEFAULT_0 NOT NULL,
    ID_TIPO_SANGRE D_ID_DEFAULT_0 NOT NULL,
    CEDULA D_CEDULA NOT NULL,
    ESTADO_CIVIL D_ESTADO_CIVIL NOT NULL);

COMMENT ON COLUMN GENERALES.ID IS 'Identificador del registro.';
COMMENT ON COLUMN GENERALES.ID_PERSONA IS 'Identificador unico de la personas en el sistema.';
COMMENT ON COLUMN GENERALES.ID_TIPO_SANGRE IS 'El tipo de sangre de la persona que ha sido registrada en el sistema. ';
COMMENT ON COLUMN GENERALES.CEDULA IS 'Identificador nacional de una persona cuyo numero cumple el siguiente patron. 
000-0000000-0';
COMMENT ON COLUMN GENERALES.ESTADO_CIVIL IS 'Estado civil de una persona actual en el sistema.';

/* HORARIOS */
CREATE TABLE HORARIOS (
    ID D_ID_MAYOR_0 NOT NULL,
    DESCRIPCION D_VARCHAR_255 NOT NULL,
    HORA D_HORA NOT NULL,
    TOLERANCIA D_ID_DEFAULT_0,
    ESTADO D_BOOLEAN_T);


/* HUELLAS */
CREATE TABLE HUELLAS (
    ID D_ID NOT NULL,
    ID_PERSONAL D_ID_DEFAULT_0 NOT NULL,
    TIPO_DEDO D_DEDO NOT NULL,
    HUELLA D_BLOB_BINARIO);

COMMENT ON COLUMN HUELLAS.ID IS 'Identificador de registro.';
COMMENT ON COLUMN HUELLAS.ID_PERSONAL IS 'Identificador de la persona en el sistema.';
COMMENT ON COLUMN HUELLAS.TIPO_DEDO IS 'Tipo de dedo que haya sido escaneado por la persona.';

/* INSCRIPCIONES */
CREATE TABLE INSCRIPCIONES (
    ID D_ID NOT NULL,
    ID_ESTUDIANTE D_ID_DEFAULT_0 NOT NULL,
    ID_TANDA D_ID_DEFAULT_0 NOT NULL,
    PAGO D_DINERO NOT NULL,
    FECHA_INSCRIPCION D_FECHA_HORA NOT NULL,
    ROL D_ROL NOT NULL,
    USER_NAME D_USER_NAME NOT NULL);

COMMENT ON COLUMN INSCRIPCIONES.ID IS 'Identificador del registro.';
COMMENT ON COLUMN INSCRIPCIONES.ID_ESTUDIANTE IS 'Identificador del registro del estudiante en el sistema.';
COMMENT ON COLUMN INSCRIPCIONES.ID_TANDA IS 'Identificador de la tanda en el sistema.';
COMMENT ON COLUMN INSCRIPCIONES.PAGO IS 'Este campo se va de aqui.';
COMMENT ON COLUMN INSCRIPCIONES.FECHA_INSCRIPCION IS 'Igualmente se va de aqui.';
COMMENT ON COLUMN INSCRIPCIONES.ROL IS 'Rol del usuario que realizo el registro.';
COMMENT ON COLUMN INSCRIPCIONES.USER_NAME IS 'Usuario que realizo el registro. ';

/* MENSAJES */
CREATE TABLE MENSAJES (
    ID D_ID NOT NULL,
    ID_DOCTOR D_USER_NAME NOT NULL,
    ID_PACIENTE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    HORA D_HORA NOT NULL,
    FECHA D_FECHA NOT NULL,
    MENSAJE D_BLOB_TEXTO NOT NULL,
    ESTADO D_ESTADO_MENSAJES NOT NULL);


/* METRICAS */
CREATE TABLE METRICAS (
    ID D_ID NOT NULL,
    ID_CONSULTA D_ID_DEFAULT_0 NOT NULL,
    PESOKG D_MEDIDA NOT NULL,
    ESTATURAMETRO D_MEDIDA NOT NULL,
    ESCEFALO D_MEDIDA NOT NULL,
    ENF_DETECT D_VARCHAR_255,
    HALLAZGOS_POS D_VARCHAR_255,
    ID_DIAG D_VARCHAR_255,
    TX D_VARCHAR_255,
    COMPLEMENTO D_VARCHAR_255,
    USER_NAME D_USER_NAME,
    IMAGEN_TEXTO D_BLOB_TEXTO,
    INDICE_MASA_CORPORAL NUMERIC(18,2));


/* MOVIES */
CREATE TABLE MOVIES (
    ID D_ID NOT NULL,
    TITLE D_VARCHAR_1024 NOT NULL,
    YEAR_ D_YEAR NOT NULL,
    VOTES D_ID,
    RATING D_DESCUENTO,
    IMAGE_URL D_VARCHAR_1024);


/* M_ANALISIS */
CREATE TABLE M_ANALISIS (
    ID D_ID NOT NULL,
    ID_PACIENTE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    FECHA_HORA_CREADA D_FECHA_HORA NOT NULL,
    FECHA_HORA_VISTA D_FECHA_HORA NOT NULL,
    ROL D_ROL,
    USER_NAME D_USER_NAME);

COMMENT ON COLUMN M_ANALISIS.ID IS 'Identificador de la analitica del paciente.';
COMMENT ON COLUMN M_ANALISIS.ID_PACIENTE IS 'Identificador del paciente que recibe la analitica.';
COMMENT ON COLUMN M_ANALISIS.FECHA_HORA_CREADA IS 'Fecha en la se le indico la analitica al paciente.';
COMMENT ON COLUMN M_ANALISIS.FECHA_HORA_VISTA IS 'Fecha y hora que se le entrega la analitica al paciente o que la consultan por la web.';
COMMENT ON COLUMN M_ANALISIS.ROL IS 'Rol de la persona que indica la analitica.';
COMMENT ON COLUMN M_ANALISIS.USER_NAME IS 'Usuario que indica la analitica al paciente.';

/* M_DEUDAS */
CREATE TABLE M_DEUDAS (
    ID D_ID NOT NULL,
    ID_CLIENTE D_ID_DEFAULT_0 NOT NULL,
    CONCEPTO D_VARCHAR_255 NOT NULL,
    MONTO D_DINERO DEFAULT 0.00 NOT NULL,
    FECHA D_FECHA NOT NULL,
    HORA D_HORA NOT NULL,
    ESTADO D_ESTADO_C_I_P_A_N_T NOT NULL);

COMMENT ON COLUMN M_DEUDAS.ID IS 'Identificador de la deuda.';
COMMENT ON COLUMN M_DEUDAS.ID_CLIENTE IS 'Identificador del Cliente';
COMMENT ON COLUMN M_DEUDAS.CONCEPTO IS 'Concepto por el cual se registra la deuda.';
COMMENT ON COLUMN M_DEUDAS.MONTO IS 'El monto de la deuda';
COMMENT ON COLUMN M_DEUDAS.FECHA IS 'La fecha de la deuda, se inserta SOLA';
COMMENT ON COLUMN M_DEUDAS.HORA IS 'La Hora tambien se Inserta SOLA';
COMMENT ON COLUMN M_DEUDAS.ESTADO IS 'Estado si es Deuda Inicial (i), Pagada (p), Abonada (a), Nulada (n).';
COMMENT ON TABLE M_DEUDAS IS 'Tabla que almacenas las deudas del sistema, tanto deuda por facturacion o externas.';

/* M_ENTRADA_PRODUCTOS */
CREATE TABLE M_ENTRADA_PRODUCTOS (
    ID D_ID NOT NULL,
    ID_PROVEEDOR D_ID_DEFAULT_0 NOT NULL,
    ID_ALMACEN D_ID_DEFAULT_0 NOT NULL,
    COD_FACTURA D_CODIGO NOT NULL,
    FECHA_ENTRADA D_FECHA NOT NULL,
    ESTADO D_ESTADO_ENTRADA_PRODUCTO,
    USER_NAME D_USER_NAME NOT NULL,
    ROL D_ROL);

COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.ID IS 'Identificador unico de la entrada de los productos al sistema.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.ID_PROVEEDOR IS 'Identificador del proveedor que proporciona los productos.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.ID_ALMACEN IS 'Identificador del almacen donde se encuentra los productos.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.COD_FACTURA IS 'Codigo de la orden de compra o factura que identifica los productos que se van a recibir en el almacen.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.FECHA_ENTRADA IS 'Indica el dia y la hora en la cual se registro la compra.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.ESTADO IS 'Es el estado o la condicion de la factura en el sistema.
* Se registra una factura en transito si la factura fue realizada y aun no llega a ningun almacen.
* Se registra como recibida en el negocio pero que aun no ha sido supervisada por una persona a carga de verla por las cantidades de productos en el sistema.
* Se registra como depositada si cumple las condiciones anteriores y se procede agregarla al almacen que fue asignado para estos productos.';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.USER_NAME IS 'Usuario que realiza la orden de compra. ';
COMMENT ON COLUMN M_ENTRADA_PRODUCTOS.ROL IS 'Rol utilizado para realizar la operaciones. ';
COMMENT ON TABLE M_ENTRADA_PRODUCTOS IS 'Es la tabla que se utiliza para darle entrada a las mercancia a los almacenes.

El estado de la entrada en genera debe pasar por distintos estados, el primero es en transito, recibido, supervisado, depositado entre otros por definir.';

/* M_FACTURAS */
CREATE TABLE M_FACTURAS (
    ID D_ID NOT NULL,
    ID_CLIENTE D_ID_DEFAULT_0 NOT NULL,
    ID_CONTACTOS_TEL D_ID_DEFAULT_0 NOT NULL,
    ID_CONTACTOS_DIRECCIONES D_ID_DEFAULT_0 NOT NULL,
    ID_CONTACTOS_EMAIL D_ID_DEFAULT_0 NOT NULL,
    ID_TURNO D_ID_DEFAULT_0 NOT NULL,
    FECHA_HORA D_FECHA_HORA NOT NULL,
    ESTADO_FACTURA D_ESTADO_C_I_P_A_N_T NOT NULL,
    NOMBRE_TEMP D_NOMBRES DEFAULT 'N A' NOT NULL,
    USER_NAME D_USER_NAME NOT NULL);

COMMENT ON COLUMN M_FACTURAS.ID IS 'Identificador de la tabla facturas.';
COMMENT ON COLUMN M_FACTURAS.ID_CLIENTE IS 'Identificador del cliente';
COMMENT ON COLUMN M_FACTURAS.ID_CONTACTOS_TEL IS 'Es el contacto telefonico del cliente por defecto y es el asignado para la factura.';
COMMENT ON COLUMN M_FACTURAS.ID_CONTACTOS_DIRECCIONES IS 'Es la direccion del cliente por defecto y es la asignada para la factura.';
COMMENT ON COLUMN M_FACTURAS.ID_CONTACTOS_EMAIL IS 'Es el contacto de correo del cliente por defecto y es el asignado para la factura.';
COMMENT ON COLUMN M_FACTURAS.ID_TURNO IS 'Turno que tiene asignado el cajero para realizar las operaciones de factura.';
COMMENT ON COLUMN M_FACTURAS.FECHA_HORA IS 'Fecha y hora de la creacion de la factura. ';
COMMENT ON COLUMN M_FACTURAS.ESTADO_FACTURA IS 'Este campo sirve para ver el estado de la factura que puede ser:
c = Contado
i = Iniciada
p = Pagado
a = Credito
n = nula
t = temporal
';
COMMENT ON COLUMN M_FACTURAS.NOMBRE_TEMP IS 'Nombre utilizado de manera temporal de la factura, para indentificar el cliente.';
COMMENT ON TABLE M_FACTURAS IS 'El campo estado puede ser  p=Pagado, c=credito, a=abono.';

/* M_RECETAS */
CREATE TABLE M_RECETAS (
    ID D_ID NOT NULL,
    ID_CONSULTA D_ID_DEFAULT_0 NOT NULL,
    FECHA D_FECHA_HORA NOT NULL,
    USER_NAME D_USER_NAME NOT NULL);


/* PERSONAS */
CREATE TABLE PERSONAS (
    ID D_ID NOT NULL,
    PERSONA D_PERSONA NOT NULL,
    PNOMBRE D_NOMBRES NOT NULL,
    SNOMBRE D_NOMBRES NOT NULL,
    APELLIDOS D_APELLIDOS NOT NULL,
    SEXO D_SEXO NOT NULL,
    FECHA_NACIMIENTO D_FECHA NOT NULL,
    FECHA_INGRESO D_FECHA_HORA NOT NULL,
    FECHA_HORA_ULTIMO_UPDATE D_FECHA_HORA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    USER_NAME D_USER_NAME,
    ROL_USUARIO D_ROL NOT NULL);

COMMENT ON COLUMN PERSONAS.ID IS 'Identificador de la Persona en el sistema';
COMMENT ON COLUMN PERSONAS.PERSONA IS 'Identidad de una persona F Fisica o J Juridica.';
COMMENT ON COLUMN PERSONAS.PNOMBRE IS 'Primer nombre de la persona, como se encuentra en la cedula de identidad.';
COMMENT ON COLUMN PERSONAS.SNOMBRE IS 'Segundo nombre de la persona. Este campo puede ser nulo o vacio.';
COMMENT ON COLUMN PERSONAS.APELLIDOS IS 'Apellidos Paternos mas Maternos';
COMMENT ON COLUMN PERSONAS.SEXO IS 'El sexo solo se define como Masculino y Femenino';
COMMENT ON COLUMN PERSONAS.FECHA_NACIMIENTO IS 'Fecha de nacimiento, este campo debe ser actualizado por una persona autorizada.';
COMMENT ON COLUMN PERSONAS.FECHA_INGRESO IS 'Este campo nadie deberia de modificarlo.';
COMMENT ON COLUMN PERSONAS.FECHA_HORA_ULTIMO_UPDATE IS 'Este campo debe ser actualizado cada vez que el registro se actualice. ';
COMMENT ON COLUMN PERSONAS.ESTADO IS 'Este campo hace referencia a estado en el sistema de la persona, si es true activo o false inactivo.';
COMMENT ON COLUMN PERSONAS.USER_NAME IS 'Ident. del usuario que registro a la persona al sistema.';
COMMENT ON COLUMN PERSONAS.ROL_USUARIO IS 'Conocer el rol que tenia ese usuario cuando registro esta persona.';
COMMENT ON TABLE PERSONAS IS 'Objetivos:
La entidad Persona es una tabla que guardar todos los registros de los clientes, estudiantes, proveedores, padres entre otros, la cual debe almacenar los atributos mas basicos de estos en una sola tabla.

Nota:
	1) Los registros de esta tabla no deben borrarse.

Reglas:

[SELECT]

[INSERT]

[UPDATE]

[DELETE]';

/* PERSONAS_CLIENTES */
CREATE TABLE PERSONAS_CLIENTES (
    ID D_ID NOT NULL);


/* PERSONAS_CLIENTES_ATR */
CREATE TABLE PERSONAS_CLIENTES_ATR (
    ID D_ID NOT NULL,
    TOTAL_FACTURADO D_DINERO,
    TOTAL_DEUDA D_DINERO,
    CANTIDAD_FACTURA D_ID,
    FECHA_ULTIMA_COMPRA D_FECHA,
    SALDO D_DINERO);

COMMENT ON COLUMN PERSONAS_CLIENTES_ATR.ID IS 'Identificador del cleinte';
COMMENT ON COLUMN PERSONAS_CLIENTES_ATR.TOTAL_FACTURADO IS 'Monto total de lo que el cliente a facturado';
COMMENT ON COLUMN PERSONAS_CLIENTES_ATR.TOTAL_DEUDA IS 'Deuda contraida en el negocio';
COMMENT ON COLUMN PERSONAS_CLIENTES_ATR.CANTIDAD_FACTURA IS 'Cantidad de factura realizada al cliente';
COMMENT ON COLUMN PERSONAS_CLIENTES_ATR.FECHA_ULTIMA_COMPRA IS 'En este campo se guarda la fecha de la ultima factura. 

Deberia guardarse el ide la ultima factura. ';

/* PERSONAS_EMPLEADOS */
CREATE TABLE PERSONAS_EMPLEADOS (
    ID D_ID NOT NULL);


/* PERSONAS_EMPLEADOS_ATR */
CREATE TABLE PERSONAS_EMPLEADOS_ATR (
    ID D_ID_MAYOR_0 NOT NULL,
    ID_DEPARTAMENTO D_ID,
    ID_CARGO D_ID_MAYOR_0 NOT NULL,
    SUELDO_BRUTO D_DINERO);


/* PERSONAS_ESTUDIANTES */
CREATE TABLE PERSONAS_ESTUDIANTES (
    ID D_ID NOT NULL);


/* PERSONAS_ESTUDIANTES_ATR */
CREATE TABLE PERSONAS_ESTUDIANTES_ATR (
    ID D_ID NOT NULL,
    MATRICULA D_VARCHAR_15 NOT NULL);


/* PERSONAS_PACIENTES */
CREATE TABLE PERSONAS_PACIENTES (
    ID D_ID NOT NULL);


/* PERSONAS_PACIENTES_ATR */
CREATE TABLE PERSONAS_PACIENTES_ATR (
    ID D_ID NOT NULL,
    CESAREA D_BOOLEAN_T,
    TIEMPO_GESTACION D_TIEMPO_GESTACION,
    FUMADOR D_BOOLEAN_F,
    USER_NAME D_USER_NAME);

COMMENT ON COLUMN PERSONAS_PACIENTES_ATR.ID IS 'Identificador del paciente.';
COMMENT ON COLUMN PERSONAS_PACIENTES_ATR.CESAREA IS 'Dato que determina si el paciente nacio por cesarea.';
COMMENT ON COLUMN PERSONAS_PACIENTES_ATR.TIEMPO_GESTACION IS 'Tiempo de gestacion del paciente en el vientre de la madre.';
COMMENT ON COLUMN PERSONAS_PACIENTES_ATR.FUMADOR IS 'Dato para conocer si el paciente fuma.';
COMMENT ON COLUMN PERSONAS_PACIENTES_ATR.USER_NAME IS 'Nombre del usuario que realizo el registros en la base de datos.';

/* PERSONAS_PADRES */
CREATE TABLE PERSONAS_PADRES (
    ID D_ID NOT NULL);


/* PERSONAS_PROVEEDORES */
CREATE TABLE PERSONAS_PROVEEDORES (
    ID D_ID NOT NULL);


/* PERSONAS_PROVEEDORES_ATR */
CREATE TABLE PERSONAS_PROVEEDORES_ATR (
    ID D_ID NOT NULL,
    CODIGO D_CODIGO NOT NULL);


/* PRECIOS */
CREATE TABLE PRECIOS (
    ID D_ID NOT NULL,
    ID_PRODUCTO D_ID_DEFAULT_0 NOT NULL,
    ID_TIPO_PRECIO D_ID_DEFAULT_0 NOT NULL,
    ID_TIPO_IMPUESTO D_ID_DEFAULT_0 NOT NULL,
    PRECIO D_DINERO NOT NULL,
    MONEDA D_MONEDA NOT NULL,
    FECHA_INICIO D_FECHA NOT NULL,
    FECHA_FIN D_FECHA,
    DESCUENTO D_DESCUENTO NOT NULL,
    COSTO_ENVIO D_DINERO NOT NULL,
    ESTADO D_BOOLEAN_T);

COMMENT ON COLUMN PRECIOS.ID IS 'Identificador del  registro.';
COMMENT ON COLUMN PRECIOS.ID_PRODUCTO IS 'Identificador del regitros que tendra el precio registrado.';
COMMENT ON COLUMN PRECIOS.ID_TIPO_PRECIO IS 'Identificar que tipo de precio ha sido creado.';
COMMENT ON COLUMN PRECIOS.ID_TIPO_IMPUESTO IS 'Identifica si el producto ha sido agrabado con un tipo de impuesto.';
COMMENT ON COLUMN PRECIOS.PRECIO IS 'Es el precio del producto o medicamento del sistema.';
COMMENT ON COLUMN PRECIOS.MONEDA IS 'Moneda utilizada para hacer el cobro por el producto. Por el momento solo admite DOP EUR USD.';
COMMENT ON COLUMN PRECIOS.FECHA_INICIO IS 'Es la fecha en que fue creado el precio o cuando se aplicara el precio al producto.';
COMMENT ON COLUMN PRECIOS.FECHA_FIN IS 'Fecha de caducidad del precio en el sistema.';
COMMENT ON COLUMN PRECIOS.DESCUENTO IS 'Si dicho producto esta recibiendo algun descuento en el momento.';
COMMENT ON COLUMN PRECIOS.COSTO_ENVIO IS 'Se registra un coste de envio del producto en el sistema.';

/* PRODUCTOS */
CREATE TABLE PRODUCTOS (
    ID D_ID NOT NULL,
    ID_CATEGORIA D_ID_DEFAULT_0 NOT NULL,
    CODIGO D_VARCHAR_25 NOT NULL,
    DESCRIPCION D_VARCHAR_70 NOT NULL,
    EXISTENCIA D_MEDIDA NOT NULL,
    FECHA_CREACION D_FECHA NOT NULL,
    ESTADO D_BOOLEAN_T NOT NULL,
    NOTA D_VARCHAR_1024 DEFAULT 'N/A' NOT NULL,
    USER_NAME D_USER_NAME,
    ROL D_ROL);

COMMENT ON COLUMN PRODUCTOS.ID IS 'Identificador unico del producto.';
COMMENT ON COLUMN PRODUCTOS.ID_CATEGORIA IS 'Identificador de la categoria del producto.';
COMMENT ON COLUMN PRODUCTOS.CODIGO IS 'En este campo se almacenan los codigos de barras de los productos. ';
COMMENT ON COLUMN PRODUCTOS.DESCRIPCION IS 'Descripcion del producto en la cual puede digitarse el modelo, marca, serie del producto.';
COMMENT ON COLUMN PRODUCTOS.EXISTENCIA IS 'Es el total de la cantidad de producto registrada en el sistema, de este campo es que se descuenta la cantidad existentes del producto.';
COMMENT ON COLUMN PRODUCTOS.FECHA_CREACION IS 'Se registra la fecha cuando fue creado en el sistema el producto.';
COMMENT ON COLUMN PRODUCTOS.ESTADO IS 'Indica cual es el estado del producto en el sistema, si esta activo o inactivo.';
COMMENT ON COLUMN PRODUCTOS.NOTA IS 'Una nota que puede indicar otras observaciones en el sistema del producto. En esta puede indicarse si el producto debe mantenerse refrigerado o en una condiciones especiales.';
COMMENT ON COLUMN PRODUCTOS.USER_NAME IS 'En este campo se registra el usuario que registro el producto por primera vez.';
COMMENT ON COLUMN PRODUCTOS.ROL IS 'Muestra el rol utilizado por el usuario para registrar el producto. ';
COMMENT ON TABLE PRODUCTOS IS 'Tabla de los productos que contiene la informacion de los productos que el sistema tiene registrados.';

/* RELACION_PADRE_ESTUDIANTE */
CREATE TABLE RELACION_PADRE_ESTUDIANTE (
    ID D_ID NOT NULL,
    ID_PADRE_O_MADRE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    ID_ESTUDIANTE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL);


/* RELACION_PADRE_PACIENTE */
CREATE TABLE RELACION_PADRE_PACIENTE (
    ID D_ID NOT NULL,
    ID_PADRE_O_MADRE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    ID_PACIENTE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL);


/* SINTOMAS */
CREATE TABLE SINTOMAS (
    ID D_ID NOT NULL,
    ID_PACIENTE D_ID_DEFAULT_0 DEFAULT 0 NOT NULL,
    SINTOMAS D_VARCHAR_255,
    FECHA D_FECHA,
    HORA D_HORA,
    NOTA D_VARCHAR_255,
    USER_NAME D_USER_NAME);


/* TANDAS */
CREATE TABLE TANDAS (
    ID D_ID NOT NULL,
    ANNO_INICIAL D_FECHA DEFAULT CURRENT_DATE NOT NULL,
    ANNO_FINAL D_FECHA NOT NULL,
    HORA_INICIO D_HORA NOT NULL,
    HORA_FINAL D_HORA NOT NULL,
    LUNES D_BOOLEAN_F,
    MARTES D_BOOLEAN_F,
    MIERCOLES D_BOOLEAN_F,
    JUEVES D_BOOLEAN_F,
    VIERNES D_BOOLEAN_F,
    SABADOS D_BOOLEAN_F,
    DOMINGOS D_BOOLEAN_F,
    CANTIDAD_ESTUDIANTES D_CANTIDAD_PACIENTE,
    CON_EDAD D_BOOLEAN_T,
    EDAD_MINIMA D_YEAR,
    EDAD_MAXIMA D_YEAR,
    ESTADO D_BOOLEAN_T);

COMMENT ON COLUMN TANDAS.ID IS 'Identificador de la tanda en el sistema.';
COMMENT ON COLUMN TANDAS.ANNO_INICIAL IS 'Es el año que se piensa impartir la docencia al grupo.';
COMMENT ON COLUMN TANDAS.ANNO_FINAL IS 'Es el año que se piensa en termina el curso registrado.';
COMMENT ON COLUMN TANDAS.HORA_INICIO IS 'Hora que empienza la clase.';
COMMENT ON COLUMN TANDAS.HORA_FINAL IS 'Hora que termina la clase.';
COMMENT ON COLUMN TANDAS.CANTIDAD_ESTUDIANTES IS 'Cantidad de estudiantes que soporta la clase. ';
COMMENT ON COLUMN TANDAS.EDAD_MINIMA IS 'La edad minina admitida por el curso.';
COMMENT ON COLUMN TANDAS.EDAD_MAXIMA IS 'La edad maxima admitida por el curso.';

/* TURNOS */
CREATE TABLE TURNOS (
    ID D_ID NOT NULL,
    TURNO_USUARIO D_USER_NAME,
    FECHA_HORA_INICIO D_FECHA_HORA NOT NULL,
    FECHA_HORA_FINAL D_FECHA_HORA,
    ESTADO D_BOOLEAN_T NOT NULL,
    MONTO_FACTURADO D_DINERO,
    MONTO_DEVUELTO D_DINERO,
    MONTO_EFECTIVO D_DINERO,
    MONTO_CREDITO D_DINERO,
    ROL D_ROL,
    USER_NAME D_USER_NAME);

COMMENT ON TABLE TURNOS IS 'Tabla que almacena los turnos de los cajeros en el sistema.

Debe:
   *Debe validarse que el usuario exista en el sistema.
   *';

/* T_ANALISIS */
CREATE TABLE T_ANALISIS (
    ID D_ID NOT NULL,
    NOMBRE_CORTO_ANALISIS D_VARCHAR_70,
    NOMBRE_ANALISIS D_VARCHAR_70,
    NOTA D_VARCHAR_1024);


/* T_CODIGOS_POSTALES */
CREATE TABLE T_CODIGOS_POSTALES (
    ID D_ID NOT NULL,
    ID_PROVINCIA D_ID_DEFAULT_0 NOT NULL,
    LOCALIDAD D_VARCHAR_45,
    CODIGO_POSTAL D_ID);


/* T_DISTRITOS_MUNICIPALES */
CREATE TABLE T_DISTRITOS_MUNICIPALES (
    ID D_ID NOT NULL,
    NOMBRE D_VARCHAR_45,
    ID_MUNICIPIO D_ID_DEFAULT_0);


/* T_E_S_SYS */
CREATE TABLE T_E_S_SYS (
    ID D_ID NOT NULL,
    NOMBRE_EMPRESA D_NOMBRES,
    FCHI D_FECHA NOT NULL,
    FCHA D_FECHA NOT NULL,
    FCHV D_FECHA NOT NULL,
    TELEFONO D_TELEFONO,
    DIRECCION D_VARCHAR_255,
    MENSAJE_FOOTER D_VARCHAR_255,
    PATH_LOGO D_VARCHAR_MAX,
    LOGO D_BLOB_TEXTO,
    USUARIO D_USER_NAME,
    CLAVE D_CLAVE);

COMMENT ON COLUMN T_E_S_SYS.ID IS 'Identificador unico de la empresa.';
COMMENT ON COLUMN T_E_S_SYS.NOMBRE_EMPRESA IS 'Campo que almacena el nombre de la empresa';
COMMENT ON COLUMN T_E_S_SYS.FCHI IS 'Fecha de inicio de servicio de la empresa. ';
COMMENT ON COLUMN T_E_S_SYS.FCHA IS 'Fecha actual de la empresa.';
COMMENT ON COLUMN T_E_S_SYS.FCHV IS 'Fecha de vencimiento de la licencia del servicio. ';
COMMENT ON COLUMN T_E_S_SYS.TELEFONO IS 'Campo que almacena los numeros telefonico de la empresa.';
COMMENT ON COLUMN T_E_S_SYS.DIRECCION IS 'Direccion del local donde opera el sistema.';
COMMENT ON COLUMN T_E_S_SYS.MENSAJE_FOOTER IS 'Mensaje que se presentan en el pie de la factura. ';
COMMENT ON COLUMN T_E_S_SYS.LOGO IS 'Logo tipo de la empresa, que se presenta en la ventana principal. ';
COMMENT ON TABLE T_E_S_SYS IS 'Esta tabla tiene la finalidad de almacenar datos importantes del negocio.';

/* T_GUIA_VIGILANCIA_DESARROLLO */
CREATE TABLE T_GUIA_VIGILANCIA_DESARROLLO (
    ID D_ID NOT NULL,
    EDAD D_EDAD,
    CARACT_DESARR_EVALUAR D_VARCHAR_255);

COMMENT ON COLUMN T_GUIA_VIGILANCIA_DESARROLLO.ID IS 'Identificador para indentificar las caracteristicas del niño a su edad.';
COMMENT ON COLUMN T_GUIA_VIGILANCIA_DESARROLLO.EDAD IS 'Las edades que registran aqui son en meses';
COMMENT ON COLUMN T_GUIA_VIGILANCIA_DESARROLLO.CARACT_DESARR_EVALUAR IS 'Describe el comportamiento de niño a su edad.';

/* T_IMPUESTOS */
CREATE TABLE T_IMPUESTOS (
    ID D_ID NOT NULL,
    NOMBRE D_VARCHAR_15 NOT NULL,
    PORCENTAJE D_DESCUENTO NOT NULL);


/* T_MOTIVO_CONSULTA */
CREATE TABLE T_MOTIVO_CONSULTA (
    ID D_ID NOT NULL,
    DESCRIPCION D_VARCHAR_45 NOT NULL);


/* T_MUNICIPIOS */
CREATE TABLE T_MUNICIPIOS (
    ID D_ID NOT NULL,
    ID_PROVINCIA D_ID_DEFAULT_0,
    NOMBRE D_VARCHAR_45);


/* T_PLAN_CUENTA_CONTABLE */
CREATE TABLE T_PLAN_CUENTA_CONTABLE (
    ID D_ID NOT NULL,
    PAIS D_VARCHAR_15 NOT NULL,
    CODIGO_CUENTA_CONTABLE D_CODIGO_CUENTA_CONTABLE,
    NOMBRE_CUENTA D_VARCHAR_255 NOT NULL,
    TIPO_CUENTA D_TIPO_CUENTAS NOT NULL,
    NIVEL_CUENTA D_NIVEL_CUENTA NOT NULL,
    USA_TERCERO D_BOOLEAN_F NOT NULL,
    CENTRO_COSTOS D_BOOLEAN_F NOT NULL,
    PORCENTAJE_BASE D_DESCUENTO DEFAULT 0 NOT NULL,
    MONTO_BASE_MIN D_DINERO DEFAULT 0 NOT NULL,
    DETALLE_CUENTA D_BLOB_TEXTO DEFAULT 'NO PROPORCIONADO');


/* T_PROVINCIAS */
CREATE TABLE T_PROVINCIAS (
    ID D_ID NOT NULL,
    NOMBRE D_VARCHAR_45 NOT NULL,
    ZONA D_PUNTO_CARDINALES);


/* T_PRUEBA */
CREATE TABLE T_PRUEBA (
    ID D_ID NOT NULL,
    VALOR D_VARCHAR_1024);


/* T_TIPOS_PRECIO */
CREATE TABLE T_TIPOS_PRECIO (
    ID D_ID NOT NULL,
    NOMBRE D_NOMBRES NOT NULL,
    DESCRIPCION D_VARCHAR_255);


/* T_TIPOS_SANGRE */
CREATE TABLE T_TIPOS_SANGRE (
    ID D_ID NOT NULL,
    DESCRIPCION D_SANGRE_SIMBOLOS);


/* ----- Creating Global Temporary Tables ----- */

/* HTE_MOVIES */
CREATE GLOBAL TEMPORARY TABLE HTE_MOVIES (
    "YEAR" D_ID NOT NULL,
    RN_ INTEGER NOT NULL,
    VOTES INTEGER,
    ID BIGINT,
    RATING DOUBLE PRECISION,
    TITLE VARCHAR(300),
    IMAGE_URL VARCHAR(255))
ON COMMIT DELETE ROWS;


/* ----- Creating Views ----- */

/* VS_PRIVILEGIO */
CREATE OR ALTER VIEW VS_PRIVILEGIO (USUARIO, GRANTOR, ABRV_PRIVILEGIO, NOMBRE_ABREV, GRANT_OPTION, CON_OPC_ADMIN, NOMBRE_RELACION, NOMBRE_CAMPO, ID_TIPO_USUARIO, TIPO_USUARIO, ID_TIPO_OBJ, TIPO_OBJ, DESCRIPCION) 
AS 
/*

*/
SELECT 
     TRIM(RDB$USER), 
     COALESCE(TRIM(RDB$GRANTOR), ''),
     RDB$PRIVILEGE, 
     F_PRIVILEGIO(RDB$PRIVILEGE), 
     RDB$GRANT_OPTION, 
     IIF(RDB$GRANT_OPTION = 0, 'NO', 'SI'), 
     TRIM(RDB$RELATION_NAME), 
     COALESCE(TRIM(RDB$FIELD_NAME), ''),
     RDB$USER_TYPE,
     F_TIPO_USUARIO(RDB$USER_TYPE), 
     RDB$OBJECT_TYPE, 
     F_OBJECTOS(RDB$OBJECT_TYPE), 
     COALESCE(p.DESCRIPCION, '')
FROM RDB$USER_PRIVILEGES
LEFT JOIN VS_PROCEDIMIENTOS p ON TRIM(p.PROCEDIMIENTO) = TRIM(RDB$RELATION_NAME)
/*
     Filtro a utilizar 
     WHERE u.RDB$RELATION_NAME STARTING 'SP_'
*/
;
COMMENT ON VIEW VS_PRIVILEGIO IS 'Prueba';

/* GET_ROL */
CREATE OR ALTER VIEW GET_ROL (USER_NAME, ROL, ADMINISTRACION, DESCRIPCION) 
AS 
/*
    Esta vista proporciona los roles de los usuarios del sistema.
*/
SELECT 
     UPPER(TRIM(p.USUARIO)), 
     TRIM(p.NOMBRE_RELACION), 
     p.GRANT_OPTION, 
     COALESCE(r.DESCRIPCION, '')
FROM VS_PRIVILEGIO p
LEFT JOIN GET_ROLES r ON TRIM(r.ROL) STARTING WITH TRIM(p.NOMBRE_RELACION)
WHERE p.ABRV_PRIVILEGIO = 'M' AND p.NOMBRE_RELACION NOT STARTING WITH 'RRR_' AND p.GRANTOR <> ''
;
COMMENT ON VIEW GET_ROL IS 'Vista que nos permite obtener los roles de los usuarios.

Al crear un nuevo usuario, esta vista debe ser asignada al usuario al crearse.

Ofrece informacion de los roles de los usuarios tienen asignado en el sistema.

Me permite obtener todos los roles del sistema registrados.


USER_NAME Usuario del sistema.

ROL Rol asignado al usuario.

ADMINISTRACION
0 Indica que no tiene derecho de administracion.
2 Indica que tiene derecho de administracion.

DESCRIPCION
Es la descripcion del rol.
Este puede ser escrito en HTML.';

/* VS_USUARIOS */
CREATE OR ALTER VIEW VS_USUARIOS (USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO, ADMINISTRADOR, DESCRIPCION) 
AS 
/*
    TODO Validar que otro usuario que no  sea sysdba muestra registros de sysdba.
*/
SELECT 
  U.SEC$USER_NAME,
  COALESCE(U.SEC$FIRST_NAME, ''),
  COALESCE(U.SEC$MIDDLE_NAME, ''),
  COALESCE(U.SEC$LAST_NAME, ''),
  U.SEC$ACTIVE,
  U.SEC$ADMIN, 
  COALESCE(u.SEC$DESCRIPTION, '')
FROM 
  SEC$USERS U
WHERE TRIM(U.SEC$USER_NAME) NOT IN( IIF(CURRENT_USER = 'SYSDBA', '',  'SYSDBA'), 'REGISTRADOR')
;
COMMENT ON VIEW VS_USUARIOS IS 'Vista del sistema que brinda informacion de los usuarios del sistema.';

/* GET_CAJEROS */
CREATE OR ALTER VIEW GET_CAJEROS (USER_NAME, ROL, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO, DESCRIPCION) 
AS 
/*

*/
SELECT 
     r.USER_NAME, 
     r.ROL, 
     u.PNOMBRE, 
     u.SNOMBRE, 
     u.APELLIDOS, 
     u.ESTADO, 
     u.DESCRIPCION
FROM GET_ROL r 
RIGHT JOIN VS_USUARIOS u ON TRIM(u.USERNAME) LIKE TRIM(r.USER_NAME)
WHERE 
     r.ROL LIKE 'R_CAJERO' AND 
     r.USER_NAME NOT STARTING WITH 'SYSDBA'
;
COMMENT ON VIEW GET_CAJEROS IS 'Esta vista permite obtener la lista de los cajeros del sistema, la cual han sido asignado al rol de CAJERO. Se evita en esta consulta de obtener el usuario SYSDBA por cuestiones logica, ya que es el super usuario del sistema.';

/* V_GENERALES */
CREATE OR ALTER VIEW V_GENERALES (ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL) 
AS 
/*

*/
SELECT 
    ID,
    ID_PERSONA, 
    ID_TIPO_SANGRE,
    CEDULA, 
    ESTADO_CIVIL
FROM GENERALES 
/*

*/
;

/* V_PERSONAS */
CREATE OR ALTER VIEW V_PERSONAS (ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO, USER_NAME, ROL_USUARIO) 
AS 
/*

*/
SELECT 
     ID, 
     PERSONA, 
     PNOMBRE, 
     SNOMBRE, 
     APELLIDOS, 
     SEXO, 
     FECHA_NACIMIENTO, 
     FECHA_INGRESO, 
     FECHA_HORA_ULTIMO_UPDATE, 
     ESTADO, 
     USER_NAME, 
     ROL_USUARIO
FROM PERSONAS 
/*

*/
;
COMMENT ON VIEW V_PERSONAS IS 'Tabla para almacenar las personas tanto clientes, proveedores, padres Entre otros.

Es la tabla que almacena todas las informaciones de las entidades por debajo de ella.
     
     Estas entidades son:
          1) Los clientes
          2) Los estudiantes
          3) Los pacientes
          4) Los padres
          5) Los proveedores
          
     Reglas:
          Esta tabla no permite que se eliminen los registros de las entidades.';

/* V_M_DEUDAS */
CREATE OR ALTER VIEW V_M_DEUDAS (ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA, ESTADO) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CLIENTE, 
     CONCEPTO, 
     MONTO, 
     FECHA, 
     HORA, 
     ESTADO
FROM M_DEUDAS
;

/* GET_DEUDAS */
CREATE OR ALTER VIEW GET_DEUDAS (ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA, ESTADO, P_NOMBRE, S_NOMBRE, APELLIDOS, CEDULA) 
AS 
/*

*/
SELECT 
     d.ID, d.ID_CLIENTE, d.CONCEPTO, d.MONTO, d.FECHA, d.HORA,
     DECODE(
          d.ESTADO, 
               'i', 'Inicial', 
               'c', 'Credito', 
               'a', 'Abonada', 
               ''
     ) AS ESTADO,
     p.PNOMBRE, p.SNOMBRE, p.APELLIDOS,
     g.CEDULA
FROM V_M_DEUDAS d
INNER JOIN V_PERSONAS p ON p.ID = d.ID_CLIENTE
INNER JOIN V_GENERALES g ON g.ID_PERSONA = d.ID_CLIENTE
;

/* V_T_PROVINCIAS */
CREATE OR ALTER VIEW V_T_PROVINCIAS (ID, NOMBRE, ZONA) 
AS 
/*

*/
SELECT 
     ID, 
     NOMBRE, 
     ZONA
FROM T_PROVINCIAS
;

/* V_CONTACTOS_DIRECCIONES */
CREATE OR ALTER VIEW V_CONTACTOS_DIRECCIONES (ID, ID_PERSONA, ID_PROVINCIA, ID_MUNICIPIO, ID_DISTRITO_MUNICIPAL, ID_CODIGO_POSTAL, DIRECCION, FECHA, ESTADO, POR_DEFECTO) 
AS 
/*

*/
SELECT
	ID,
	ID_PERSONA,
	ID_PROVINCIA,
	ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL,
	DIRECCION,
	FECHA,
	ESTADO,
	POR_DEFECTO
FROM
	CONTACTOS_DIRECCIONES
;

/* V_T_CODIGOS_POSTALES */
CREATE OR ALTER VIEW V_T_CODIGOS_POSTALES (ID, ID_PROVINCIA, LOCALIDAD, CODIGO_POSTAL) 
AS 
/*

*/
SELECT 
     ID, 
     ID_PROVINCIA, 
     LOCALIDAD, 
     CODIGO_POSTAL
FROM T_CODIGOS_POSTALES
;

/* V_T_MUNICIPIOS */
CREATE OR ALTER VIEW V_T_MUNICIPIOS (ID, NOMBRE, ID_PROVINCIA) 
AS 
/*

*/
SELECT 
     ID, 
     NOMBRE, 
     ID_PROVINCIA 
FROM T_MUNICIPIOS
;

/* V_T_DISTRITOS_MUNICIPALES */
CREATE OR ALTER VIEW V_T_DISTRITOS_MUNICIPALES (ID, NOMBRE, ID_MUNICIPIO) 
AS 
/*

*/
SELECT 
     ID, 
     NOMBRE, 
     ID_MUNICIPIO
FROM T_DISTRITOS_MUNICIPALES
;

/* GET_DIRECCION_BY_ID */
CREATE OR ALTER VIEW GET_DIRECCION_BY_ID (ID, ID_PERSONA, ID_PROVINCIA, PROVINCIA, ID_MUNICIPIO, MUNICIPIO, ID_DISTRITO_MUNICIPAL, DISTRITO_MUNICIPAL, ID_CODIGO_POSTAL, CODIGO_POSTAL, DIRECCION, FECHA, ESTADO, POR_DEFECTO) 
AS 
SELECT r.ID, r.ID_PERSONA, 
     r.ID_PROVINCIA, p.NOMBRE, 
     r.ID_MUNICIPIO, m.NOMBRE,
     r.ID_DISTRITO_MUNICIPAL, d.NOMBRE, 
     r.ID_CODIGO_POSTAL, c.CODIGO_POSTAL, 
     r.DIRECCION, r.FECHA, r.ESTADO, r.POR_DEFECTO
FROM V_CONTACTOS_DIRECCIONES r
LEFT JOIN V_T_PROVINCIAS p ON p.ID = r.ID_PROVINCIA
LEFT JOIN V_T_MUNICIPIOS m ON m.ID = r.ID_MUNICIPIO
LEFT JOIN V_T_DISTRITOS_MUNICIPALES d ON d.ID = r.ID_DISTRITO_MUNICIPAL
LEFT JOIN V_T_CODIGOS_POSTALES c ON c.ID = r.ID_CODIGO_POSTAL
;

/* V_PERSONAS_ESTUDIANTES_ATR */
CREATE OR ALTER VIEW V_PERSONAS_ESTUDIANTES_ATR (ID, MATRICULA) 
AS 
/*

*/
SELECT 
     ID, 
     MATRICULA
FROM PERSONAS_ESTUDIANTES_ATR 
/*

*/
;

/* GET_ESTUDIANTES_SV */
CREATE OR ALTER VIEW GET_ESTUDIANTES_SV (ID, MATRICULA, CEDULA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, ESTADO) 
AS 
--
SELECT 
     r.ID, 
     e.MATRICULA, 
     g.CEDULA, 
     r.PNOMBRE, 
     r.SNOMBRE, 
     r.APELLIDOS, 
     r.SEXO, 
     r.FECHA_NACIMIENTO, 
     r.ESTADO
FROM V_PERSONAS_ESTUDIANTES_ATR e 
INNER JOIN V_PERSONAS r ON r.ID = e.ID
INNER JOIN V_GENERALES g ON g.ID_PERSONA = e.ID
/**

*/
;
COMMENT ON VIEW GET_ESTUDIANTES_SV IS 'Debe de obtenerse las relaciones entre padre he hijo de la tabla RELACION_FAMILIAR.';

/* V_PERSONAS_PACIENTES */
CREATE OR ALTER VIEW V_PERSONAS_PACIENTES (ID) 
AS 
/*

*/
SELECT 
     ID
FROM PERSONAS_PACIENTES
;

/* GET_GENERALES_PACIENTES */
CREATE OR ALTER VIEW GET_GENERALES_PACIENTES (ID, CEDULA, ID_TIPO_SANGRE, ESTADO_CIVIL) 
AS 
SELECT 
    r.ID, 
    COALESCE(g.CEDULA, 'No Registro'), COALESCE(g.ID_TIPO_SANGRE, 'No Registro'), COALESCE(g.ESTADO_CIVIL,'No Registro')
FROM V_PERSONAS_PACIENTES r
LEFT JOIN V_GENERALES g ON g.ID_PERSONA = r.ID
;

/* V_PERSONAS_PADRES */
CREATE OR ALTER VIEW V_PERSONAS_PADRES (ID) 
AS 
/*

*/
SELECT 
     ID 
FROM PERSONAS_PADRES
;

/* GET_GENERALES_PADRES */
CREATE OR ALTER VIEW GET_GENERALES_PADRES (ID, CEDULA, ID_TIPO_SANGRE, ESTADO_CIVIL) 
AS 
SELECT 
    r.ID, 
    COALESCE(g.CEDULA, 'No Registro'), COALESCE(g.ID_TIPO_SANGRE, 'No Registro'), COALESCE(g.ESTADO_CIVIL,'No Registro')
FROM V_PERSONAS_PADRES r
LEFT JOIN V_GENERALES g ON g.ID_PERSONA = r.ID
;

/* V_PERSONAS_PROVEEDORES */
CREATE OR ALTER VIEW V_PERSONAS_PROVEEDORES (ID) 
AS 
/*
*/
SELECT 
     ID 
FROM PERSONAS_PROVEEDORES
;

/* GET_GENERALES_PROVEEDORES */
CREATE OR ALTER VIEW GET_GENERALES_PROVEEDORES (ID, CEDULA, ID_TIPO_SANGRE, ESTADO_CIVIL) 
AS 
SELECT 
    r.ID, 
    COALESCE(g.CEDULA, 'No Registro'), COALESCE(g.ID_TIPO_SANGRE, 'No Registro'), COALESCE(g.ESTADO_CIVIL,'No Registro')
FROM V_PERSONAS_PROVEEDORES r
LEFT JOIN V_GENERALES g ON g.ID_PERSONA = r.ID
;

/* GET_GUID */
CREATE OR ALTER VIEW GET_GUID (DB_GUID, DB_FILE_ID) 
AS 
select 
     RDB$GET_CONTEXT('SYSTEM', 'DB_GUID'), --Identificador único de la base de datos.
     RDB$GET_CONTEXT('SYSTEM', 'DB_FILE_ID') --Utilizando este identificador para próxima versiones.
from rdb$database
/*
Método RDB$GET_CONTEXT tiene mas utilidad.
*/
;

/* GET_METRICAS */
CREATE OR ALTER VIEW GET_METRICAS (ID, ID_PACIENTE, PESOKG, ESTATURAMETRO) 
AS 
SELECT 
    m.ID, 
    c.ID_PACIENTE, 
    m.PESOKG, 
    m.ESTATURAMETRO
FROM CONSULTAS c
INNER JOIN METRICAS m ON m.ID_CONSULTA = c.ID
;

/* V_M_FACTURAS */
CREATE OR ALTER VIEW V_M_FACTURAS (ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES, ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, NOMBRE_TEMP, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CLIENTE, 
     ID_CONTACTOS_TEL, 
     ID_CONTACTOS_DIRECCIONES, 
     ID_CONTACTOS_EMAIL, 
     ID_TURNO,
     FECHA_HORA,
     ESTADO_FACTURA, 
     NOMBRE_TEMP, 
     USER_NAME
FROM M_FACTURAS 
/*

*/
;

/* GET_M_FACTURAS */
CREATE OR ALTER VIEW GET_M_FACTURAS (ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES, ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, NOMBRE_TEMP, USER_NAME, PNOMBRE, SNOMBRE, APELLIDOS) 
AS 
/*

*/
SELECT 
     LPAD(f.ID, 9, 0), f.ID_CLIENTE, f.ID_CONTACTOS_TEL, f.ID_CONTACTOS_DIRECCIONES, f.ID_CONTACTOS_EMAIL, f.ID_TURNO, 
     f.FECHA_HORA, f.ESTADO_FACTURA, f.NOMBRE_TEMP, f.USER_NAME, 
     p.PNOMBRE, p.SNOMBRE, p.APELLIDOS
FROM V_M_FACTURAS f
LEFT JOIN V_PERSONAS p ON p.ID = f.ID_CLIENTE 
/*

*/
;

/* V_ASEGURADOS */
CREATE OR ALTER VIEW V_ASEGURADOS (ID, ID_PERSONA, ID_ARS, NO_NSS, ESTADO) 
AS 
/*

*/
SELECT 
    ID,
    ID_PERSONA, 
    ID_ARS, 
    NO_NSS, 
    ESTADO 
FROM ASEGURADOS
;

/* GET_PADRES */
CREATE OR ALTER VIEW GET_PADRES (ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, ESTADO_PERSONA, ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS, NO_NSS, ESTADO_SEGURO) 
AS 
SELECT 
    persona.ID, persona.PNOMBRE, persona.SNOMBRE, persona.APELLIDOS, 
    persona.SEXO, persona.FECHA_NACIMIENTO, persona.ESTADO,
    general.ID_TIPO_SANGRE, general.CEDULA, general.ESTADO_CIVIL,
    asegurado.ID_ARS, asegurado.NO_NSS, asegurado.ESTADO
FROM V_PERSONAS_PADRES padre
LEFT JOIN V_PERSONAS persona ON persona.ID = padre.ID 
LEFT JOIN V_GENERALES general ON general.ID_PERSONA = persona.ID
LEFT JOIN V_ASEGURADOS asegurado ON asegurado.ID_PERSONA = persona.ID
/*
    Por el momento tenemos estos datos.
 */
;

/* VS_PROCEDIMIENTOS */
CREATE OR ALTER VIEW VS_PROCEDIMIENTOS (ID, PROCEDIMIENTO, PROPIETARIO, SQL_SECURITY, DESCRIPCION) 
AS 
/*

*/
SELECT 
     RDB$PROCEDURE_ID, 
     TRIM(RDB$PROCEDURE_NAME),
     TRIM(RDB$OWNER_NAME), 
     RDB$SQL_SECURITY, 
     TRIM(RDB$DESCRIPTION)
FROM RDB$PROCEDURES
;

/* GET_PERMISOS_ASIGNADOS */
CREATE OR ALTER VIEW GET_PERMISOS_ASIGNADOS (USUARIO, GRANT_OPTION, ID_TIPO_OBJ, PROCEDIMIENTO, DESCRIPCION) 
AS 
/*

*/
SELECT 
    TRIM(r.USUARIO) USUARIO,
    r.GRANT_OPTION,
    r.ID_TIPO_OBJ,
    TRIM(p.PROCEDIMIENTO) PROCEDIMIENTO,
    TRIM(COALESCE(p.DESCRIPCION, '')) DESCRIPCION
FROM VS_PROCEDIMIENTOS p 
LEFT JOIN VS_PRIVILEGIO r ON 
    UPPER(TRIM(r.NOMBRE_RELACION)) LIKE UPPER(TRIM(p.PROCEDIMIENTO)) 
WHERE 
        TRIM(UPPER(p.PROCEDIMIENTO)) STARTING WITH 'PERM_' AND 
        r.USUARIO IS NOT NULL AND 
        TRIM(UPPER(p.PROCEDIMIENTO)) NOT STARTING WITH 'TRANSITIONS'
;

/* V_PERSONAS_ESTUDIANTES */
CREATE OR ALTER VIEW V_PERSONAS_ESTUDIANTES (ID) 
AS 
/*

*/
SELECT 
     ID
FROM PERSONAS_ESTUDIANTES 
/*
     Tabla que almacenas las claves primarias de los estudiantes.
*/
;
COMMENT ON VIEW V_PERSONAS_ESTUDIANTES IS 'Tabla que almacenas las claves primarias de los estudiantes.';

/* GET_PERSONAS_ESTUDIANTES */
CREATE OR ALTER VIEW GET_PERSONAS_ESTUDIANTES (ID, MATRICULA, ESTADO) 
AS 
/*
     
*/
SELECT  
     e.ID, 
     ee.MATRICULA, 
     p.ESTADO
FROM V_PERSONAS_ESTUDIANTES e 
INNER JOIN V_PERSONAS_ESTUDIANTES_ATR ee ON ee.ID = e.ID
INNER JOIN V_PERSONAS p ON p.ID = e.ID
;

/* GET_PERSONAS_PADRES */
CREATE OR ALTER VIEW GET_PERSONAS_PADRES (ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, ESTADO_PERSONA, ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS, NO_NSS, ESTADO_SEGURO) 
AS 
SELECT 
    persona.ID, persona.PNOMBRE, persona.SNOMBRE, persona.APELLIDOS, 
    persona.SEXO, persona.FECHA_NACIMIENTO, persona.ESTADO,
    general.ID_TIPO_SANGRE, general.CEDULA, general.ESTADO_CIVIL,
    asegurado.ID_ARS, asegurado.NO_NSS, asegurado.ESTADO
FROM V_PERSONAS_PADRES padre
LEFT JOIN V_PERSONAS persona ON persona.ID = padre.ID 
LEFT JOIN V_GENERALES general ON general.ID_PERSONA = persona.ID
LEFT JOIN V_ASEGURADOS asegurado ON asegurado.ID_PERSONA = persona.ID
/*
    Por el momento tenemos estos datos.
 */
;

/* V_PERSONAS_CLIENTES */
CREATE OR ALTER VIEW V_PERSONAS_CLIENTES (ID) 
AS 
/*

*/
SELECT 
     ID 
FROM PERSONAS_CLIENTES
;
COMMENT ON VIEW V_PERSONAS_CLIENTES IS 'Tabla que almacena las claves primaria de los clientes.
     
     Para paginacion usar esto:
     
     ROWS (5 - 1) * 40 + 1 TO (5 + 1) * 40        donde 
     
     ROWS
     (nPaginaNro - 1) * nCantidadFilas + 1 TO (nPaginaNro + (nCantidadPaginas - 1)) * nCantidadFilas
     
     Utilizar el ORDER BY.';

/* GET_PERSONA_CLIENTES */
CREATE OR ALTER VIEW GET_PERSONA_CLIENTES (ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL, FECHA_INGRESO, ESTADO) 
AS 
/*

*/
SELECT 
     r.ID, 
     COALESCE(g.CEDULA, '000-0000000-0'),
     r.PERSONA, 
     r.PNOMBRE, 
     r.SNOMBRE, 
     r.APELLIDOS, 
     r.SEXO, 
     r.FECHA_NACIMIENTO, 
     COALESCE(g.ESTADO_CIVIL, 'X'),
     r.FECHA_INGRESO, 
     r.ESTADO
FROM V_PERSONAS_CLIENTES c 
LEFT JOIN V_PERSONAS r ON c.ID = r.ID 
LEFT JOIN V_GENERALES g ON c.ID = g.ID_PERSONA
;

/* V_PERSONAS_PROVEEDORES_ATR */
CREATE OR ALTER VIEW V_PERSONAS_PROVEEDORES_ATR (ID, CODIGO) 
AS 
/*

*/
SELECT 
     ID, 
     CODIGO
FROM PERSONAS_PROVEEDORES_ATR
;

/* GET_PROVEEDORES */
CREATE OR ALTER VIEW GET_PROVEEDORES (ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, ESTADO, CEDULA, CODIGO) 
AS 
/*

*/
SELECT 
     p.ID, 
     a.PERSONA, a.PNOMBRE, a.SNOMBRE, a.APELLIDOS, a.SEXO, a.ESTADO,
     b.CEDULA,
     d.CODIGO
FROM V_PERSONAS_PROVEEDORES p
LEFT JOIN V_PERSONAS a ON a.ID = p.ID
LEFT JOIN V_GENERALES b ON b.ID_PERSONA = p.ID
INNER JOIN V_PERSONAS_PROVEEDORES_ATR d ON d.ID = p.ID
;

/* GET_ROLES */
CREATE OR ALTER VIEW GET_ROLES (ROL, PROPIETARIO, DESCRIPCION) 
AS 
/*

*/
SELECT 
     TRIM(RDB$ROLE_NAME), 
     TRIM(RDB$OWNER_NAME), 
     COALESCE(RDB$DESCRIPTION, '')
FROM RDB$ROLES
WHERE TRIM(RDB$ROLE_NAME) NOT LIKE 'RRR_SOFTSURENA'
;
COMMENT ON VIEW GET_ROLES IS 'Me permite obtener todos los roles del sistema registrados.

Este rol debe ser ejecutados administradores del sistema.';

/* GET_TABLA_VISTA_SYSTEMA */
CREATE OR ALTER VIEW GET_TABLA_VISTA_SYSTEMA (NOMBRE, SQL_SEGURIDAD, TIPO_RELACION, DESCRIPCION) 
AS 
SELECT 
    RDB$RELATION_NAME, 
    RDB$SQL_SECURITY, 
    RDB$RELATION_TYPE, 
    RDB$DESCRIPTION
FROM RDB$RELATIONS 
WHERE RDB$RELATION_NAME NOT STARTING WITH 'RDB$' AND 
     RDB$RELATION_NAME NOT STARTING WITH 'SEC$' AND 
     RDB$RELATION_NAME NOT STARTING WITH 'MON$'
/**
RDB$RELATION_TYPE - SMALLINT: The type of the relation object being described:
0 - system or user-defined table 
1 - view 
2 - external table 
3 - monitoring table 
4 - connection-level GTT (PRESERVE ROWS) 
5 - transaction-level GTT (DELETE ROWS)
RDB$SQL_SECURITY - BOOLEAN: The SQL SECURITY mode (DEFINER or INVOKER):
NULL - initial default (INVOKER) 
FALSE - INVOKER 
TRUE - DEFINER
*/
;

/* V_TANDAS */
CREATE OR ALTER VIEW V_TANDAS (ID, ANNO_INICIAL, ANNO_FINAL, HORA_INICIO, HORA_FINAL, LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADOS, DOMINGOS, CANTIDAD_ESTUDIANTES, CON_EDAD, EDAD_MINIMA, EDAD_MAXIMA, ESTADO) 
AS 
/*

*/
SELECT 
     ID, 
     ANNO_INICIAL, 
     ANNO_FINAL, 
     HORA_INICIO, 
     HORA_FINAL, 
     LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADOS, DOMINGOS, 
     CANTIDAD_ESTUDIANTES, 
     CON_EDAD, 
     EDAD_MINIMA, 
     EDAD_MAXIMA, 
     ESTADO
FROM TANDAS
/*

*/
;

/* GET_TANDAS_DETALLADAS */
CREATE OR ALTER VIEW GET_TANDAS_DETALLADAS (ID, HORARIO) 
AS 
SELECT t.id, trim( case lunes when 1 then 'Lunes ' else trim('') end || 
                   case martes when 1 then 'Martes ' else trim('') end ||           
                   case miercoles when 1 then 'Miercoles ' else trim('') end ||           
                   case jueves when 1 then 'Jueves ' else trim('') end ||            
                   case viernes when 1 then 'Viernes ' else trim('') end ||           
                   case sabados when 1 then 'Sabados ' else trim('') end||           
                   case domingos when 1 then 'Domingos ' else trim('') end) || ' De ' ||           
                   subString(t.Hora_Inicio FROM 1 for 8) ||' Hasta '||              
                   subString(t.Hora_Final FROM 1 for 8) AS HORARIO 
FROM V_TANDAS t
;

/* VS_TRANSACCION_ACTUAL */
CREATE OR ALTER VIEW VS_TRANSACCION_ACTUAL (TNIDENTIFICADORTRANSACCION, TNIDENTIFICADORCONEXION, TCESTADOTRANSACCION, TDFECHAHORA, TNULTIMATRANSACCION, TNOLDESTINTERESTINGTRANSACTION, TNOLDESTACTIVETRANSACTION, TCMODOAISLAMIENTO, TCTIEMPOESPERA, TCREADONLY, TCAUTOCOMMIT, TCAUTOUNDO, TNIDENTIFICADORESTADISTICAS) 
AS 
SELECT
   MON$TRANSACTION_ID             AS tnIdentificadorTransaccion,
   MON$ATTACHMENT_ID              AS tnIdentificadorConexion,
   IIF(MON$STATE = 1, 'ACTIVA', 'INACTIVA') AS tcEstadoTransaccion,
   MON$TIMESTAMP                  AS tdFechaHora,
   MON$TOP_TRANSACTION            AS tnUltimaTransaccion,
   MON$OLDEST_TRANSACTION         AS tnOldestInterestingTransaction,
   MON$OLDEST_ACTIVE              AS tnOldestActiveTransaction,
   DECODE(MON$ISOLATION_MODE, 
   0, 'Acceso exclusivo', 
   1, 'Lecturas repetidas', 
   2, 'Lee filas confirmadas inmediatamente', 
   3, 'No lee una fila si otra transacción la usa') AS tcModoAislamiento,
   DECODE(MON$LOCK_TIMEOUT, 
   -1, 'Espera por siempre', 
   0, 'No espera', 
   'Espera ' || MON$LOCK_TIMEOUT || ' segundos') AS tcTiempoEspera,
   IIF(MON$READ_ONLY = 1, 'Read Only', 'Read Write')               AS tcReadOnly,
   IIF(MON$AUTO_COMMIT = 1, 'Auto COMMIT', 'No auto COMMIT')       AS tcAutoCommit,
   IIF(MON$AUTO_UNDO = 1, 'Tiene savepoint', 'No tiene savepoint') AS tcAutoUndo,
   MON$STAT_ID                                                     AS tnIdentificadorEstadisticas
FROM
   MON$TRANSACTIONS
WHERE
   MON$ATTACHMENT_ID  = CURRENT_CONNECTION AND
   MON$TRANSACTION_ID = CURRENT_TRANSACTION
;

/* VS_USUARIOS_TAGS */
CREATE OR ALTER VIEW VS_USUARIOS_TAGS (LLAVE, VALOR, USUARIO, PLUGING) 
AS 
/*

*/
SELECT 
     SEC$KEY, 
     SEC$VALUE, 
     SEC$USER_NAME, 
     SEC$PLUGIN
FROM SEC$USER_ATTRIBUTES
;

/* V_ALMACENES */
CREATE OR ALTER VIEW V_ALMACENES (ID, NOMBRE, UBICACION, ESTADO, BORRADO) 
AS 
/*

*/
SELECT 
     ID, 
     NOMBRE, 
     UBICACION, 
     ESTADO,
     BORRADO
FROM ALMACENES
;

/* V_ALMACENES_DISPONIBLE */
CREATE OR ALTER VIEW V_ALMACENES_DISPONIBLE (ID, ID_TURNO, ID_ALMACEN, USER_NAME) 
AS 
SELECT 
    ID, 
    ID_TURNO, 
    ID_ALMACEN, 
    USER_NAME
FROM ALMACENES_DISPONIBLE
;

/* V_ANTECEDENTES */
CREATE OR ALTER VIEW V_ANTECEDENTES (ID, ID_CONSULTA, DESCRIPCION) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CONSULTA, 
     DESCRIPCION
FROM ANTECEDENTES
;

/* V_ARS */
CREATE OR ALTER VIEW V_ARS (ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO, CANTIDAD_REGISTRO, USER_NAME, ROL) 
AS 
/*

*/SELECT 
     ID, 
     DESCRIPCION, 
     COVERCONSULTAPORC, 
     ESTADO, 
     CANTIDAD_REGISTRO, 
     USER_NAME, 
     ROL
FROM ARS
;
COMMENT ON VIEW V_ARS IS 'Tabla que almacenas las propiedades basicas de los seguros con lo que opera el sistema.

Descripcion seria el nombre de la aseguradora, la converConsulta guardar el valor en porciento de lo que el seguro cubre por consulta.';

/* V_CARGOS */
CREATE OR ALTER VIEW V_CARGOS (ID, NOMBRE, DESCRIPCION, ESTADO) 
AS 
SELECT ID, NOMBRE, DESCRIPCION, ESTADO
FROM CARGOS r
;

/* V_CARTONES_BINGO */
CREATE OR ALTER VIEW V_CARTONES_BINGO (ID, CARTON_HASH, FECHA_CREACCION, MATRIZ_OBJ, ESTADO) 
AS 
/*

*/
SELECT 
     ID, 
     CARTON_HASH, 
     FECHA_CREACCION, 
     MATRIZ_OBJ, 
     ESTADO
FROM CARTONES_BINGO
;

/* V_CATEGORIAS */
CREATE OR ALTER VIEW V_CATEGORIAS (ID, DESCRIPCION, FECHA_CREACION, ESTADO, USER_NAME) 
AS 
SELECT 
    ID, 
    DESCRIPCION, 
    FECHA_CREACION, 
    ESTADO, 
    USER_NAME
FROM CATEGORIAS
;

/* V_CONSULTAS */
CREATE OR ALTER VIEW V_CONSULTAS (ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE, ESTADO, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CONTROL_CONSULTA, 
     FECHA, 
     LINEA,
     ID_PACIENTE, 
     ESTADO, 
     USER_NAME
FROM CONSULTAS
;

/* V_CONTACTOS_EMAIL */
CREATE OR ALTER VIEW V_CONTACTOS_EMAIL (ID, ID_PERSONA, EMAIL, FECHA, ESTADO, POR_DEFECTO) 
AS 
/*

*/
SELECT 
     ID, 
     ID_PERSONA, 
     EMAIL, 
     FECHA, 
     ESTADO, 
     POR_DEFECTO
FROM CONTACTOS_EMAIL
;

/* V_CONTACTOS_TEL */
CREATE OR ALTER VIEW V_CONTACTOS_TEL (ID, ID_PERSONA, TELEFONO, TIPO, FECHA, ESTADO, POR_DEFECTO) 
AS 
/*

*/
SELECT 
     ID, 
     ID_PERSONA, 
     TELEFONO, 
     TIPO, 
     FECHA, 
     ESTADO, 
     POR_DEFECTO
FROM CONTACTOS_TEL
;

/* V_CONTROL_CONSULTA */
CREATE OR ALTER VIEW V_CONTROL_CONSULTA (ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL, ESTADO, USER_NAME_) 
AS 
/*

*/
SELECT 
     ID, 
     USER_NAME, 
     CANTIDAD_PACIENTE, 
     DIA, 
     INICIAL, 
     FINAL, 
     ESTADO, 
     USER_NAME_
FROM CONTROL_CONSULTA
;

/* V_DEPARTAMENTOS */
CREATE OR ALTER VIEW V_DEPARTAMENTOS (ID, NOMBRE, DESCRIPCION, ESTADO) 
AS 
SELECT ID, NOMBRE, DESCRIPCION, ESTADO
FROM DEPARTAMENTOS
;

/* V_D_ANALISIS */
CREATE OR ALTER VIEW V_D_ANALISIS (ID, ID_M_ANALISIS, LINEA, ID_T_ANALITICA, OTRO) 
AS 
/*

*/
SELECT 
     ID, 
     ID_M_ANALISIS, 
     LINEA, 
     ID_T_ANALITICA, 
     OTRO
FROM D_ANALISIS
;

/* V_D_DEUDAS_PAGAS */
CREATE OR ALTER VIEW V_D_DEUDAS_PAGAS (ID, ID_DEUDAS, MONTO_PAGO, FECHA_HORA) 
AS 
/*

*/
SELECT 
     ID, 
     ID_DEUDAS, 
     MONTO_PAGO, 
     FECHA_HORA
FROM D_DEUDAS_PAGAS
;

/* V_D_ENTRADA_PRODUCTOS */
CREATE OR ALTER VIEW V_D_ENTRADA_PRODUCTOS (ID, LINEA, ID_M_ENTRADA_PRODUCTO, ID_ALMACEN, ID_PRODUCTO, ENTRADA, COSTO, FECHA_VECIMIENTO, OBSERVACION) 
AS 
SELECT ID, LINEA, ID_M_ENTRADA_PRODUCTO, ID_ALMACEN, ID_PRODUCTO, ENTRADA, COSTO, 
        FECHA_VECIMIENTO, OBSERVACION
FROM D_ENTRADA_PRODUCTOS
;

/* V_D_FACTURAS */
CREATE OR ALTER VIEW V_D_FACTURAS (ID, LINEA, ID_FACTURA, ID_PRODUCTO, ID_PRECIO, CANTIDAD) 
AS 
/*

*/
SELECT 
     ID,
     LINEA, 
     ID_FACTURA, 
     ID_PRODUCTO, 
     ID_PRECIO, 
     CANTIDAD
FROM D_FACTURAS
;

/* V_D_GUIA_VIGILANCIA_DESARROLLO */
CREATE OR ALTER VIEW V_D_GUIA_VIGILANCIA_DESARROLLO (ID, ID_GVD, ID_PACIENTE, FECHA) 
AS 
/*

*/
SELECT
     ID,
     ID_GVD, 
     ID_PACIENTE, 
     FECHA
FROM D_GUIA_VIGILANCIA_DESARROLLO
;

/* V_D_MOTIVO_CONSULTA */
CREATE OR ALTER VIEW V_D_MOTIVO_CONSULTA (ID, ID_CONSULTA, ID_MOTIVO_CONSULTA) 
AS 
/*

*/
SELECT 
    ID,
    ID_CONSULTA, 
    ID_MOTIVO_CONSULTA
FROM D_MOTIVO_CONSULTA
;

/* V_D_RECETAS */
CREATE OR ALTER VIEW V_D_RECETAS (ID, ID_RECETA, LINEA, ID_MEDICAMENTO, CANTIDAD, D_DOSIS) 
AS 
/*
*/
SELECT 
    ID,
     ID_RECETA, 
     LINEA, 
     ID_MEDICAMENTO, 
     CANTIDAD, 
     D_DOSIS
FROM D_RECETAS
;

/* V_ERRORES */
CREATE OR ALTER VIEW V_ERRORES (ID, ERR_MODULO, ERR_USUARIO, ERR_TIEMPO, ERR_COMENT) 
AS 
SELECT 
    ID, 
    ERR_MODULO, 
    ERR_USUARIO, 
    ERR_TIEMPO, 
    ERR_COMENT
FROM ERRORES
;

/* V_FOTO_CATEGORIA */
CREATE OR ALTER VIEW V_FOTO_CATEGORIA (ID, ID_CATEGORIA, FOTO, FECHA_HORA_CREACION, ACTUAL) 
AS 
SELECT ID, ID_CATEGORIA, FOTO, FECHA_HORA_CREACION, ACTUAL
FROM FOTO_CATEGORIA
;

/* V_FOTO_PERSONA */
CREATE OR ALTER VIEW V_FOTO_PERSONA (ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL) 
AS 
SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
FROM FOTO_PERSONA
;

/* V_FOTO_PRODUCTO */
CREATE OR ALTER VIEW V_FOTO_PRODUCTO (ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL) 
AS 
SELECT ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL
FROM FOTO_PRODUCTO
;

/* V_HORARIOS */
CREATE OR ALTER VIEW V_HORARIOS (ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO) 
AS 
SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
FROM HORARIOS
;

/* V_HUELLAS */
CREATE OR ALTER VIEW V_HUELLAS (ID, ID_PERSONA, TIPO_DEDO, HUELLA) 
AS 
/*
*/
SELECT 
     ID, 
     ID_PERSONAL,
     TIPO_DEDO,
     HUELLA
FROM HUELLAS
;

/* V_INSCRIPCIONES */
CREATE OR ALTER VIEW V_INSCRIPCIONES (ID, ID_ESTUDIANTE, ID_TANDA, PAGO, FECHA_INSCRIPCION, ROL, USER_NAME) 
AS 
SELECT 
    ID, 
    ID_ESTUDIANTE, 
    ID_TANDA, 
    PAGO, 
    FECHA_INSCRIPCION, 
    ROL, 
    USER_NAME
FROM INSCRIPCIONES
;

/* V_MENSAJES */
CREATE OR ALTER VIEW V_MENSAJES (ID, ID_DOCTOR, ID_PACIENTE, HORA, FECHA, MENSAJE, ESTADO) 
AS 
/*

*/
SELECT 
     ID, 
     ID_DOCTOR, 
     ID_PACIENTE, 
     HORA, 
     FECHA, 
     MENSAJE, 
     ESTADO
FROM MENSAJES
;

/* V_METRICAS */
CREATE OR ALTER VIEW V_METRICAS (ID, ID_CONSULTA, PESOKG, ESTATURAMETRO, ESCEFALO, ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO, IMAGEN_TEXTO, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CONSULTA, 
     PESOKG, 
     ESTATURAMETRO, 
     ESCEFALO, 
     ENF_DETECT, 
     HALLAZGOS_POS, 
     ID_DIAG, 
     TX, 
     COMPLEMENTO,
     IMAGEN_TEXTO, 
     USER_NAME
FROM METRICAS 
/*

*/
;

/* V_M_ANALISIS */
CREATE OR ALTER VIEW V_M_ANALISIS (ID, ID_PACIENTE, FECHA_HORA_CREADA, FECHA_HORA_VISTA, ROL, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_PACIENTE, 
     FECHA_HORA_CREADA, 
     FECHA_HORA_VISTA, 
     ROL, 
     USER_NAME
FROM M_ANALISIS
;

/* V_M_ENTRADA_PRODUCTOS */
CREATE OR ALTER VIEW V_M_ENTRADA_PRODUCTOS (ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA, ESTADO, ROL, USER_NAME) 
AS 
SELECT 
     ID,
     ID_PROVEEDOR,
     ID_ALMACEN,
     COD_FACTURA,
     FECHA_ENTRADA,
     ESTADO,
     ROL,
     USER_NAME
FROM M_ENTRADA_PRODUCTOS
;

/* V_M_RECETAS */
CREATE OR ALTER VIEW V_M_RECETAS (ID, ID_CONSULTA, FECHA, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_CONSULTA, 
     FECHA, 
     USER_NAME
FROM M_RECETAS
;

/* V_PERSONAS_CLIENTES_ATR */
CREATE OR ALTER VIEW V_PERSONAS_CLIENTES_ATR (ID, TOTAL_FACTURADO, TOTAL_DEUDA, CANTIDAD_FACTURA, FECHA_ULTIMA_COMPRA, SALDO) 
AS 
/*

*/
SELECT 
     ID, 
     TOTAL_FACTURADO, 
     TOTAL_DEUDA, 
     CANTIDAD_FACTURA, 
     FECHA_ULTIMA_COMPRA, 
     SALDO
FROM PERSONAS_CLIENTES_ATR
/*

*/
;

/* V_PERSONAS_EMPLEADOS */
CREATE OR ALTER VIEW V_PERSONAS_EMPLEADOS (ID) 
AS 
SELECT ID
FROM PERSONAS_EMPLEADOS
;

/* V_PERSONAS_EMPLEADOS_ATR */
CREATE OR ALTER VIEW V_PERSONAS_EMPLEADOS_ATR (ID, ID_CARGO, SUELDO_BRUTO) 
AS 
SELECT ID, ID_CARGO, SUELDO_BRUTO
FROM PERSONAS_EMPLEADOS_ATR
;

/* V_PERSONAS_PACIENTES_ATR */
CREATE OR ALTER VIEW V_PERSONAS_PACIENTES_ATR (ID, CESAREA, TIEMPO_GESTACION, FUMADOR, USER_NAME) 
AS 
/*

*/
SELECT 
     ID,  
     CESAREA, 
     TIEMPO_GESTACION,
     FUMADOR,
     USER_NAME
FROM PERSONAS_PACIENTES_ATR
/*

*/
;

/* V_PRECIOS */
CREATE OR ALTER VIEW V_PRECIOS (ID, ID_PRODUCTO, ID_TIPO_PRECIO, ID_TIPO_IMPUESTO, PRECIO, MONEDA, FECHA_INICIO, FECHA_FIN, DESCUENTO, COSTO_ENVIO, ESTADO) 
AS 
SELECT 
    ID, 
    ID_PRODUCTO, 
    ID_TIPO_PRECIO, 
    ID_TIPO_IMPUESTO, 
    PRECIO, 
    MONEDA, 
    FECHA_INICIO, 
    FECHA_FIN, 
    DESCUENTO, 
    COSTO_ENVIO,
    ESTADO
FROM PRECIOS
;

/* V_PRODUCTOS */
CREATE OR ALTER VIEW V_PRODUCTOS (ID, ID_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA, FECHA_CREACION, ESTADO, NOTA) 
AS 
/*
     Inicio
*/
SELECT 
     ID, 
     ID_CATEGORIA, 
     CODIGO, 
     DESCRIPCION,
     EXISTENCIA,
     FECHA_CREACION,
     ESTADO, 
     NOTA
FROM PRODUCTOS 
/*
     Fin
*/
;

/* V_RELACION_PADRE_ESTUDIANTE */
CREATE OR ALTER VIEW V_RELACION_PADRE_ESTUDIANTE (ID, ID_PADRE_O_MADRE, ID_ESTUDIANTE) 
AS 
/*

*/
SELECT 
     ID,
     ID_PADRE_O_MADRE, 
     ID_ESTUDIANTE
FROM RELACION_PADRE_ESTUDIANTE
;

/* V_RELACION_PADRE_PACIENTE */
CREATE OR ALTER VIEW V_RELACION_PADRE_PACIENTE (ID, ID_PADRE_O_MADRE, ID_PACIENTE) 
AS 
/*

*/
SELECT 
     ID,
     ID_PADRE_O_MADRE, 
     ID_PACIENTE
FROM RELACION_PADRE_PACIENTE
;

/* V_SINTOMAS */
CREATE OR ALTER VIEW V_SINTOMAS (ID, ID_PACIENTE, SINTOMAS, FECHA, HORA, NOTA, USER_NAME) 
AS 
/*

*/
SELECT 
     ID, 
     ID_PACIENTE, 
     SINTOMAS, 
     FECHA, 
     HORA, 
     NOTA, 
     USER_NAME
FROM SINTOMAS
/*

*/
;

/* V_TURNOS */
CREATE OR ALTER VIEW V_TURNOS (ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO, ROL, USER_NAME) 
AS 
SELECT 
     ID, 
     TURNO_USUARIO, 
     FECHA_HORA_INICIO, 
     FECHA_HORA_FINAL, 
     ESTADO, 
     MONTO_FACTURADO, 
     MONTO_DEVUELTO,
     MONTO_EFECTIVO, 
     MONTO_CREDITO, 
     ROL, 
     USER_NAME
FROM TURNOS
;
COMMENT ON VIEW V_TURNOS IS 'Tabla utilizada para guardar los turnos de los cajeros del sistema.';

/* V_T_ANALISIS */
CREATE OR ALTER VIEW V_T_ANALISIS (ID, NOMBRE_CORTO_ANALISIS, NOMBRE_ANALISIS, NOTA) 
AS 
/*

*/
SELECT 
     ID, 
     NOMBRE_CORTO_ANALISIS, 
     NOMBRE_ANALISIS, 
     NOTA
FROM T_ANALISIS 
/*

*/
;

/* V_T_E_S_SYS */
CREATE OR ALTER VIEW V_T_E_S_SYS (ID, NOMBRE_EMPRESA, FCHI, FCHA, FCHV, DIAS_RESTANTES, TELEFONO, DIRECCION, MENSAJE_FOOTER, PATH_LOGO, LOGO, USUARIO, CLAVE) 
AS 
/*
     TODO esta vista debe ser analizada, pues contiene un campo con una funcion. 
     Debe darsele otro nombre.
*/
SELECT 
     ID, 
     NOMBRE_EMPRESA, 
     FCHI, 
     FCHA, 
     FCHV, 
     DATEDIFF(DAY FROM CURRENT_DATE TO FCHV), 
     TELEFONO, 
     DIRECCION, 
     MENSAJE_FOOTER, 
     PATH_LOGO,
     LOGO,
     usuario,
     clave
FROM T_E_S_SYS
;

/* V_T_GUIA_VIGILANCIA_DESARROLLO */
CREATE OR ALTER VIEW V_T_GUIA_VIGILANCIA_DESARROLLO (ID, EDAD, CARACT_DESARR_EVALUAR) 
AS 
/*

*/
SELECT 
     ID, 
     EDAD, 
     CARACT_DESARR_EVALUAR
FROM T_GUIA_VIGILANCIA_DESARROLLO
;

/* V_T_IMPUESTOS */
CREATE OR ALTER VIEW V_T_IMPUESTOS (ID, NOMBRE, PORCENTAJE) 
AS 
SELECT 
    ID, 
    NOMBRE, 
    PORCENTAJE
FROM T_IMPUESTOS
;

/* V_T_MOTIVO_CONSULTA */
CREATE OR ALTER VIEW V_T_MOTIVO_CONSULTA (ID, DESCRIPCION) 
AS 
/*

*/
SELECT 
     ID, 
     DESCRIPCION
FROM T_MOTIVO_CONSULTA
;

/* V_T_PLAN_CUENTA_CONTABLE */
CREATE OR ALTER VIEW V_T_PLAN_CUENTA_CONTABLE (ID, PAIS, CODIGO_CUENTA_CONTABLE, NOMBRE_CUENTA, TIPO_CUENTA, NIVEL_CUENTA, USA_TERCERO, CENTRO_COSTOS, PORCENTAJE_BASE, MONTO_BASE_MIN, DETALLE_CUENTA) 
AS 
/*

*/
SELECT 
     ID, 
     PAIS, 
     CODIGO_CUENTA_CONTABLE, 
     NOMBRE_CUENTA, 
     TIPO_CUENTA, 
     NIVEL_CUENTA, 
     USA_TERCERO,
     CENTRO_COSTOS, 
     PORCENTAJE_BASE, 
     MONTO_BASE_MIN, 
     DETALLE_CUENTA
FROM T_PLAN_CUENTA_CONTABLE
/*

*/
;

/* V_T_TIPOS_PRECIO */
CREATE OR ALTER VIEW V_T_TIPOS_PRECIO (ID, NOMBRE, DESCRIPCION) 
AS 
SELECT 
    ID, 
    NOMBRE, 
    DESCRIPCION
FROM T_TIPOS_PRECIO
;

/* V_T_TIPOS_SANGRE */
CREATE OR ALTER VIEW V_T_TIPOS_SANGRE (ID, DESCRIPCION) 
AS 
/*

*/
SELECT 
     ID, 
     DESCRIPCION
FROM T_TIPOS_SANGRE
;

/* ----- Creating Indices ----- */

/* IDX_ANTECEDENTES1 */
CREATE UNIQUE INDEX IDX_ANTECEDENTES1 ON ANTECEDENTES (ID,ID_CONSULTA);

/* IDX_D_GUIA_VIGILANCIA_DESARROLLO1 */
CREATE INDEX IDX_D_GUIA_VIGILANCIA_DESARROLLO1 ON D_GUIA_VIGILANCIA_DESARROLLO (ID_GVD,ID_PACIENTE);

/* IDX_M_DEUDAS1 */
CREATE INDEX IDX_M_DEUDAS1 ON M_DEUDAS (ESTADO);

/* IDX_M_FACTURAS1 */
CREATE INDEX IDX_M_FACTURAS1 ON M_FACTURAS (ID_TURNO,ESTADO_FACTURA);

/* IDX_PERSONAS1 */
CREATE INDEX IDX_PERSONAS1 ON PERSONAS (PNOMBRE);

/* IDX_PERSONAS2 */
CREATE INDEX IDX_PERSONAS2 ON PERSONAS (SNOMBRE);

/* IDX_PERSONAS3 */
CREATE INDEX IDX_PERSONAS3 ON PERSONAS (APELLIDOS);

/* IDX_PERSONAS4 */
CREATE INDEX IDX_PERSONAS4 ON PERSONAS (FECHA_NACIMIENTO);

/* IDX_PERSONAS5 */
CREATE INDEX IDX_PERSONAS5 ON PERSONAS (FECHA_INGRESO);

/* IDX_PERSONAS6 */
CREATE INDEX IDX_PERSONAS6 ON PERSONAS (PERSONA);

/* IDX_PERSONAS7 */
CREATE INDEX IDX_PERSONAS7 ON PERSONAS (SEXO);

/* IDX_TURNOS1 */
CREATE INDEX IDX_TURNOS1 ON TURNOS (TURNO_USUARIO);

/* T_CODIGO_POSTAL_IDX */
CREATE INDEX T_CODIGO_POSTAL_IDX ON T_CODIGOS_POSTALES (CODIGO_POSTAL);

/* ----- Creating Sequences ----- */

/* GEN_ALMACENES_DISPONIBLE_ID */
CREATE OR ALTER SEQUENCE GEN_ALMACENES_DISPONIBLE_ID START WITH 1 INCREMENT BY 1;

/* GEN_ALMACENES_ID */
CREATE OR ALTER SEQUENCE GEN_ALMACENES_ID START WITH 1 INCREMENT BY 1;

/* GEN_ASEGURADOS_ID */
CREATE OR ALTER SEQUENCE GEN_ASEGURADOS_ID START WITH 1 INCREMENT BY 1;

/* GEN_D_ENTRADA_PRODUCTO_ID */
CREATE OR ALTER SEQUENCE GEN_D_ENTRADA_PRODUCTO_ID START WITH 1 INCREMENT BY 1;

/* GEN_D_FACTURAS_ID */
CREATE OR ALTER SEQUENCE GEN_D_FACTURAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_D_GUIA_VIGILANCIA_DESARROLLO_ID */
CREATE OR ALTER SEQUENCE GEN_D_GUIA_VIGILANCIA_DESARROLLO_ID START WITH 1 INCREMENT BY 1;

/* GEN_D_RECETAS_ID */
CREATE OR ALTER SEQUENCE GEN_D_RECETAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_ESTUDIANTE_ID */
CREATE OR ALTER SEQUENCE GEN_ESTUDIANTE_ID START WITH 1 INCREMENT BY 1;

/* GEN_FACTURAS_ID */
CREATE OR ALTER SEQUENCE GEN_FACTURAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_FOTO_PERSONA_ID */
CREATE OR ALTER SEQUENCE GEN_FOTO_PERSONA_ID START WITH 1 INCREMENT BY 1;

/* GEN_FOTO_PRODUCTO_ID */
CREATE OR ALTER SEQUENCE GEN_FOTO_PRODUCTO_ID START WITH 1 INCREMENT BY 1;

/* GEN_GENERALES_ID */
CREATE OR ALTER SEQUENCE GEN_GENERALES_ID START WITH 1 INCREMENT BY 1;

/* GEN_HORARIOS_ID */
CREATE OR ALTER SEQUENCE GEN_HORARIOS_ID START WITH 1 INCREMENT BY 1;

/* GEN_MOVIES_ID */
CREATE OR ALTER SEQUENCE GEN_MOVIES_ID START WITH 1 INCREMENT BY 1;

/* GEN_M_DEUDAS_ID */
CREATE OR ALTER SEQUENCE GEN_M_DEUDAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_M_FACTURAS_ID */
CREATE OR ALTER SEQUENCE GEN_M_FACTURAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_M_RECETAS_ID */
CREATE OR ALTER SEQUENCE GEN_M_RECETAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_PRECIOS_ID */
CREATE OR ALTER SEQUENCE GEN_PRECIOS_ID START WITH 1 INCREMENT BY 1;

/* GEN_RECCOUNT_ID */
CREATE OR ALTER SEQUENCE GEN_RECCOUNT_ID START WITH 1 INCREMENT BY 1;

/* GEN_RELACION_PADRE_ESTUDIANTE_ID */
CREATE OR ALTER SEQUENCE GEN_RELACION_PADRE_ESTUDIANTE_ID START WITH 1 INCREMENT BY 1;

/* GEN_RELACION_PADRE_PACIENTE_ID */
CREATE OR ALTER SEQUENCE GEN_RELACION_PADRE_PACIENTE_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_ANALISIS_ID */
CREATE OR ALTER SEQUENCE GEN_T_ANALISIS_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_CODIGOS_POSTALES_ID */
CREATE OR ALTER SEQUENCE GEN_T_CODIGOS_POSTALES_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_E_S_SYS_ID */
CREATE OR ALTER SEQUENCE GEN_T_E_S_SYS_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_GUIA_VIGILANCIA_DESARROLLO_ID */
CREATE OR ALTER SEQUENCE GEN_T_GUIA_VIGILANCIA_DESARROLLO_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_IMPUESTOS_ID */
CREATE OR ALTER SEQUENCE GEN_T_IMPUESTOS_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_MOTIVO_CONSULTA_ID */
CREATE OR ALTER SEQUENCE GEN_T_MOTIVO_CONSULTA_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_MUNICIPIOS_ID */
CREATE OR ALTER SEQUENCE GEN_T_MUNICIPIOS_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_PROVINCIAS_ID */
CREATE OR ALTER SEQUENCE GEN_T_PROVINCIAS_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_PRUEBA_ID */
CREATE OR ALTER SEQUENCE GEN_T_PRUEBA_ID START WITH 1 INCREMENT BY 1;

/* GEN_T_TIPOS_PRECIO_ID */
CREATE OR ALTER SEQUENCE GEN_T_TIPOS_PRECIO_ID START WITH 1 INCREMENT BY 1;

/* G_ID_CONTACTOS_DIRECCIONES */
CREATE OR ALTER SEQUENCE G_ID_CONTACTOS_DIRECCIONES START WITH 1 INCREMENT BY 1;

/* SEQ_ANTECEDENTES_ID */
CREATE OR ALTER SEQUENCE SEQ_ANTECEDENTES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_ARS_ID */
CREATE OR ALTER SEQUENCE SEQ_ARS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CARTONES_BINGO_ID */
CREATE OR ALTER SEQUENCE SEQ_CARTONES_BINGO_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CATEGORIAS_ID */
CREATE OR ALTER SEQUENCE SEQ_CATEGORIAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CODIGOS_POSTALES_ID */
CREATE OR ALTER SEQUENCE SEQ_CODIGOS_POSTALES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CONSULTAS_ID */
CREATE OR ALTER SEQUENCE SEQ_CONSULTAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CONTACTOS_DIRECCIONES_ID */
CREATE OR ALTER SEQUENCE SEQ_CONTACTOS_DIRECCIONES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CONTACTOS_EMAIL_ID */
CREATE OR ALTER SEQUENCE SEQ_CONTACTOS_EMAIL_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CONTACTOS_TEL_ID */
CREATE OR ALTER SEQUENCE SEQ_CONTACTOS_TEL_ID START WITH 1 INCREMENT BY 1;

/* SEQ_CONTROL_CONSULTA_ID */
CREATE OR ALTER SEQUENCE SEQ_CONTROL_CONSULTA_ID START WITH 1 INCREMENT BY 1;

/* SEQ_DEUDAS_ID */
CREATE OR ALTER SEQUENCE SEQ_DEUDAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_DISTRITOS_MUNICIPALES_ID */
CREATE OR ALTER SEQUENCE SEQ_DISTRITOS_MUNICIPALES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_D_ANALISIS_ID */
CREATE OR ALTER SEQUENCE SEQ_D_ANALISIS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_D_DEUDAS_PAGAS_ID */
CREATE OR ALTER SEQUENCE SEQ_D_DEUDAS_PAGAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_E_S_SYS_ID */
CREATE OR ALTER SEQUENCE SEQ_E_S_SYS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_HUELLAS_ID */
CREATE OR ALTER SEQUENCE SEQ_HUELLAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_INSCRIPCIONES_ID */
CREATE OR ALTER SEQUENCE SEQ_INSCRIPCIONES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_MENSAJES_ID */
CREATE OR ALTER SEQUENCE SEQ_MENSAJES_ID START WITH 1 INCREMENT BY 1;

/* SEQ_METRICAS_ID */
CREATE OR ALTER SEQUENCE SEQ_METRICAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_MOTIVO_CONSULTA_ID */
CREATE OR ALTER SEQUENCE SEQ_MOTIVO_CONSULTA_ID START WITH 1 INCREMENT BY 1;

/* SEQ_MUNICIPIOS_ID */
CREATE OR ALTER SEQUENCE SEQ_MUNICIPIOS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_M_ANALISIS_ID */
CREATE OR ALTER SEQUENCE SEQ_M_ANALISIS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_M_ENTRADA_PRODUCTOS_ID */
CREATE OR ALTER SEQUENCE SEQ_M_ENTRADA_PRODUCTOS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_PERSONAS_ID */
CREATE OR ALTER SEQUENCE SEQ_PERSONAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_PLAN_CUENTA_CONTABLE_ID */
CREATE OR ALTER SEQUENCE SEQ_PLAN_CUENTA_CONTABLE_ID START WITH 1 INCREMENT BY 1;

/* SEQ_PRODUCTOS_ID */
CREATE OR ALTER SEQUENCE SEQ_PRODUCTOS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_PROVINCIAS_ID */
CREATE OR ALTER SEQUENCE SEQ_PROVINCIAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_RECETAS_ID */
CREATE OR ALTER SEQUENCE SEQ_RECETAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_SINTOMAS_ID */
CREATE OR ALTER SEQUENCE SEQ_SINTOMAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_TANDAS_ID */
CREATE OR ALTER SEQUENCE SEQ_TANDAS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_TIPOS_SANGRE_ID */
CREATE OR ALTER SEQUENCE SEQ_TIPOS_SANGRE_ID START WITH 1 INCREMENT BY 1;

/* SEQ_TURNOS_ID */
CREATE OR ALTER SEQUENCE SEQ_TURNOS_ID START WITH 1 INCREMENT BY 1;

/* SEQ_T_ANALISIS_ID */
CREATE OR ALTER SEQUENCE SEQ_T_ANALISIS_ID START WITH 1 INCREMENT BY 1;

/* ----- Creating Exceptions ----- */

/* E_ALMACEN_GENERAL */
CREATE EXCEPTION E_ALMACEN_GENERAL
	'Este almacen no puede ser editado ni eliminado.';

/* E_ALMACEN_INACTIVO */
CREATE EXCEPTION E_ALMACEN_INACTIVO
	'El almacen inactivo en el sistema. ID=[@1]';

/* E_ALMACEN_NO_EXISTE */
CREATE EXCEPTION E_ALMACEN_NO_EXISTE
	'El Almacen fue eliminado.';

/* E_CAJERO_NO_REGISTRADO */
CREATE EXCEPTION E_CAJERO_NO_REGISTRADO
	'Este usuario no cuenta con el rol de cajero.';

/* E_CAJERO_SIN_TURNO */
CREATE EXCEPTION E_CAJERO_SIN_TURNO
	'El cajero/usuario no cuenta con un turno activo.';

/* E_CAJERO_TURNO_ACTIVO */
CREATE EXCEPTION E_CAJERO_TURNO_ACTIVO
	'Este cajero cuenta con un turno activo actualmente.';

/* E_CANTIDAD_NEGATIVA */
CREATE EXCEPTION E_CANTIDAD_NEGATIVA
	'No se permite cantidad negativa.';

/* E_CARGO_INACTIVO */
CREATE EXCEPTION E_CARGO_INACTIVO
	'Cargo no esta activo en el sistema. ID=[@1]';

/* E_CATEGORIAS_INACTIVA */
CREATE EXCEPTION E_CATEGORIAS_INACTIVA
	'La categoria se encuentra inactiva.';
COMMENT ON EXCEPTION E_CATEGORIAS_INACTIVA IS 'Excepcion utilizada para indicar que un producto no se encuentra activado y no debe utilizarse.';

/* E_CATEGORIA_GENERICA */
CREATE EXCEPTION E_CATEGORIA_GENERICA
	'La categoria generica no puede ser tocada';

/* E_CEDULA_INCORRECTA */
CREATE EXCEPTION E_CEDULA_INCORRECTA
	'La cedula es incorrecta.';

/* E_CHOQUE_HORA */
CREATE EXCEPTION E_CHOQUE_HORA
	'Existe un choque de horas que intenta registrar.';

/* E_CLIENTE_ENCONTRADO */
CREATE EXCEPTION E_CLIENTE_ENCONTRADO
	'Este cliente se encuentra registrado en el sistema.';

/* E_CLIENTE_INACTIVO */
CREATE EXCEPTION E_CLIENTE_INACTIVO
	'Cliente inactivo.';

/* E_CLIENTE_NO_ENCONTRADO */
CREATE EXCEPTION E_CLIENTE_NO_ENCONTRADO
	'El identificador de cliente no es valido. Codigo del cliente [ @1 ]';
COMMENT ON EXCEPTION E_CLIENTE_NO_ENCONTRADO IS 'Excepcion utllizada cuando un identificador no se encuentra registrado en la base de datos.';

/* E_CODIGO_P_NO_DEFINIDO */
CREATE EXCEPTION E_CODIGO_P_NO_DEFINIDO
	'Dicho codigo postal no se encuentra en la base de datos.';

/* E_CODIGO_P_NO_PROVINCIA */
CREATE EXCEPTION E_CODIGO_P_NO_PROVINCIA
	'Dicho codigo postal no esta definido para la provincia.';

/* E_CONSULTA_CON_METRICAS */
CREATE EXCEPTION E_CONSULTA_CON_METRICAS
	'Existen metricas registradas en el sistema.';

/* E_CONSULTA_NO_ENCONTRADA */
CREATE EXCEPTION E_CONSULTA_NO_ENCONTRADA
	'No existe registro de consulta.';

/* E_CONTACTO_TEL_DUPLICADO */
CREATE EXCEPTION E_CONTACTO_TEL_DUPLICADO
	'La persona ya cuenta con este numero telefonico. ID Cliente [ @1 ]';

/* E_CONTROL_CONSULTA_NO_ENCONTRADA */
CREATE EXCEPTION E_CONTROL_CONSULTA_NO_ENCONTRADA
	'Dicha consulta no ha sido registrada en el sistema.';

/* E_CORREO_INACTIVO */
CREATE EXCEPTION E_CORREO_INACTIVO
	'Correo inactivo.';
COMMENT ON EXCEPTION E_CORREO_INACTIVO IS 'Exception lanzada cuando un correo se encuentra inactivo o eliminado de la vista V_CONTACTS_TEL.';

/* E_DELETE_GENERICO */
CREATE EXCEPTION E_DELETE_GENERICO
	'Registro generico no puede ser eliminado.';

/* E_DEPARTAMENTO_INACTIVO */
CREATE EXCEPTION E_DEPARTAMENTO_INACTIVO
	'El departamento se encuentra inactivo. ID=[@1]';

/* E_DESCUENTO_INCORRECTO */
CREATE EXCEPTION E_DESCUENTO_INCORRECTO
	'Tipo de descuento es incorrecto.';

/* E_DEUDA_ACTIVDA */
CREATE EXCEPTION E_DEUDA_ACTIVDA
	'La deuda se encuentra activa por un estado diferente de inicial.';

/* E_DEUDA_NO_ENCONTRADA */
CREATE EXCEPTION E_DEUDA_NO_ENCONTRADA
	'Deuda no encontrada...!';

/* E_DIRECCION_EN_USO */
CREATE EXCEPTION E_DIRECCION_EN_USO
	'La direccion se encuentra registrada en facturas.';
COMMENT ON EXCEPTION E_DIRECCION_EN_USO IS 'Cuando una direccion intenta eliminarse y esta se encuentra registrada en una factura del sistema, se debe de lanzar esta excepcion a la accion.';

/* E_DIRECCION_INACTIVO */
CREATE EXCEPTION E_DIRECCION_INACTIVO
	'Direccion inactiva.';
COMMENT ON EXCEPTION E_DIRECCION_INACTIVO IS 'Exception lanzada cuando una direccion de una persona no se encuentra registada en la vista V_DIRECCIONES.';

/* E_DIRECCION_NO_ENCONTRADA */
CREATE EXCEPTION E_DIRECCION_NO_ENCONTRADA
	'El codigo de la direccion no existe.';
COMMENT ON EXCEPTION E_DIRECCION_NO_ENCONTRADA IS 'Es una excepcion que valida que la vista V_CONTACTOS_DIRECCIONES contenga el codigo de la direccion que intentas actualizar en el sistema.';

/* E_DISTRITO_M_NO_DEFINIDO */
CREATE EXCEPTION E_DISTRITO_M_NO_DEFINIDO
	'El codigo del distrito municipal, no ha sido definido.';

/* E_DISTRITO_M_NO_MUNICIPIO */
CREATE EXCEPTION E_DISTRITO_M_NO_MUNICIPIO
	'Codigo de municipio no coinciden con el distrito seleccionado.';

/* E_DUPLICADO_CARTON_BINGO */
CREATE EXCEPTION E_DUPLICADO_CARTON_BINGO
	'Este HASH ha sido encontrado.';

/* E_DUPLICADO_CATEGORIA */
CREATE EXCEPTION E_DUPLICADO_CATEGORIA
	'Categoria duplicada.';

/* E_DUPLICADO_CEDULA */
CREATE EXCEPTION E_DUPLICADO_CEDULA
	'Cedula registrada en el sistema.';

/* E_DUPLICADO_NOMBRE */
CREATE EXCEPTION E_DUPLICADO_NOMBRE
	'Nombre duplicado en el sistema.';

/* E_EFECTIVO_MENOR_TOTAL */
CREATE EXCEPTION E_EFECTIVO_MENOR_TOTAL
	'Efectivo es menor que el total de la factura.';

/* E_EQUIPO_NO_REGISTRADO */
CREATE EXCEPTION E_EQUIPO_NO_REGISTRADO
	'El equipo no se encuentra registrado en nuestro sistema.';

/* E_ERROR_CONEXION */
CREATE EXCEPTION E_ERROR_CONEXION
	'No puede conectarse al servidor.!!!';

/* E_ESTADO_CIVIL_NO_ENCONTRADO */
CREATE EXCEPTION E_ESTADO_CIVIL_NO_ENCONTRADO
	'Estado civil no encontrado en el sistema.';

/* E_EXISTEN_REGISTROS_ALMACEN_DISPONIBLE */
CREATE EXCEPTION E_EXISTEN_REGISTROS_ALMACEN_DISPONIBLE
	'Existe registros en los almacenes disponibles del sistema.';

/* E_EXISTEN_REGISTROS_ASEGURADOS */
CREATE EXCEPTION E_EXISTEN_REGISTROS_ASEGURADOS
	'Este registro[@1] tiene relacion con asegurado.';

/* E_EXISTEN_REGISTROS_D_ENTRADA_PRODUCTO */
CREATE EXCEPTION E_EXISTEN_REGISTROS_D_ENTRADA_PRODUCTO
	'Existen registros en detalle de entrada de productos. ID=[@1]';

/* E_EXISTEN_REGISTROS_D_FACTURA */
CREATE EXCEPTION E_EXISTEN_REGISTROS_D_FACTURA
	'Existen precios en el detalle de una factura.';

/* E_EXISTEN_REGISTROS_M_ENTRADA_PRODUCTOS */
CREATE EXCEPTION E_EXISTEN_REGISTROS_M_ENTRADA_PRODUCTOS
	'Existen registros en las entradas de productos.';

/* E_EXISTEN_REGISTROS_M_FACTURAS */
CREATE EXCEPTION E_EXISTEN_REGISTROS_M_FACTURAS
	'Existen registros en el maestro de facturas.';

/* E_FACTURA_CONTIENE_DETALLE */
CREATE EXCEPTION E_FACTURA_CONTIENE_DETALLE
	'Factura no puede ser eliminana ni modificada porque contiene detalle';

/* E_FACTURA_NO_ENCONTRADA */
CREATE EXCEPTION E_FACTURA_NO_ENCONTRADA
	'No existe registro de esta factura.';

/* E_FACTURA_NO_NULA */
CREATE EXCEPTION E_FACTURA_NO_NULA
	'La factura no puede ser eliminada porque su estado no es nula.';

/* E_FACTURA_NO_NULA_NI_INICIAL */
CREATE EXCEPTION E_FACTURA_NO_NULA_NI_INICIAL
	'La factura no se encuentra en un estado de nula o inicial';

/* E_FECHA_ACTUAL_INCORRECTA */
CREATE EXCEPTION E_FECHA_ACTUAL_INCORRECTA
	'La fecha actual que intenta registrar es mayor que la actual en el servidor.';

/* E_FECHA_INCORRECTA */
CREATE EXCEPTION E_FECHA_INCORRECTA
	'Existe problemas con la fecha de registro.';

/* E_FECHA_INICIAL_INCORRECTA */
CREATE EXCEPTION E_FECHA_INICIAL_INCORRECTA
	'La fecha inicial registrada es mayor que la actual en el servidor.';

/* E_FECHA_VENCIMIENTO */
CREATE EXCEPTION E_FECHA_VENCIMIENTO
	'La fecha del producto se ha vencido';

/* E_LICENCIA_VENCIDA */
CREATE EXCEPTION E_LICENCIA_VENCIDA
	'La licencia del software ha vencido. Llamar al 829-297-2015';

/* E_MUNICIPIO_NO_DEFINIDO */
CREATE EXCEPTION E_MUNICIPIO_NO_DEFINIDO
	'Municipio no definido en el sistema.';

/* E_MUNICIPIO_NO_PROVINCIA */
CREATE EXCEPTION E_MUNICIPIO_NO_PROVINCIA
	'El municipio no pertenece a la pronvincia.';

/* E_NO_ERES_ADMIN */
CREATE EXCEPTION E_NO_ERES_ADMIN
	'USUARIO NO TIENE PRIVILEGIOS DE ADMINISTRADOR.';

/* E_OFNI */
CREATE EXCEPTION E_OFNI
	'Objecto volador no identificado';

/* E_OPER_NO_DEFINIDA */
CREATE EXCEPTION E_OPER_NO_DEFINIDA
	'Operacion no definida';

/* E_PACIENTE_NO_ENCONTRADO */
CREATE EXCEPTION E_PACIENTE_NO_ENCONTRADO
	'Identificador del paciente no encontrado.';

/* E_PERSONA_INACTIVA */
CREATE EXCEPTION E_PERSONA_INACTIVA
	'Persona inactivo.';

/* E_PRECIO_NO_ENCONTRADO */
CREATE EXCEPTION E_PRECIO_NO_ENCONTRADO
	'Producto no contiene un precio registrado.';

/* E_PRODUCTO_INACTIVO */
CREATE EXCEPTION E_PRODUCTO_INACTIVO
	'Producto inactivo.';

/* E_PRODUCTO_NO_ENCONTRADO */
CREATE EXCEPTION E_PRODUCTO_NO_ENCONTRADO
	'No existe registro de este producto.';

/* E_PROVEEDOR_INACTIVO */
CREATE EXCEPTION E_PROVEEDOR_INACTIVO
	'El proveedor tiene estado de inactivo. ID=[@1]';

/* E_PROVINCIA_NO_DEFINIDA */
CREATE EXCEPTION E_PROVINCIA_NO_DEFINIDA
	'El codigo de la provincia no está definido en el sistema.';

/* E_REGISTRO_GENERICO_CONTACTO_DIRECCION */
CREATE EXCEPTION E_REGISTRO_GENERICO_CONTACTO_DIRECCION
	'No puede realizar operaciones en este registro. [@1]';

/* E_ROL_NO_ENCONTRADO */
CREATE EXCEPTION E_ROL_NO_ENCONTRADO
	'Rol no encontrado en el sistema.! [@1]';
COMMENT ON EXCEPTION E_ROL_NO_ENCONTRADO IS 'Excepcion que se lanza cuando un rol de sistema no es encontrado.';

/* E_SUELDO_BRUTO_NEGATIVO */
CREATE EXCEPTION E_SUELDO_BRUTO_NEGATIVO
	'El sueldo tiene valor negativo. SUELDO=[@1]';

/* E_TELEFONO_INACTIVO */
CREATE EXCEPTION E_TELEFONO_INACTIVO
	'Telefono inactivo.';
COMMENT ON EXCEPTION E_TELEFONO_INACTIVO IS 'Exception lanzada cuando el telefono de una persona se encuentra inactivo o ha sido eliminado de la vista de V_CONTACTS_TEL.';

/* E_TIPO_SANGRE_NO_ENCONTRADA */
CREATE EXCEPTION E_TIPO_SANGRE_NO_ENCONTRADA
	'No existe registro de sangre.';

/* E_TURNO_CERRADO */
CREATE EXCEPTION E_TURNO_CERRADO
	'Este turno ya se encuentra cerrado';

/* E_TURNO_NO_EXISTE */
CREATE EXCEPTION E_TURNO_NO_EXISTE
	'No se encuentran registros en la base de datos de turno consultado.';

/* E_UPDATE_GENERICO */
CREATE EXCEPTION E_UPDATE_GENERICO
	'Registro generico no puede ser actualizado.';

/* E_USUARIO_INACTIVO */
CREATE EXCEPTION E_USUARIO_INACTIVO
	'Usuario Inactivo';

/* E_USUARIO_NO_AUTORIZADO */
CREATE EXCEPTION E_USUARIO_NO_AUTORIZADO
	'Accion no puede ser realizada por el usaurio [ @1 ]';

/* E_USUARIO_NO_ENCONTRADO */
CREATE EXCEPTION E_USUARIO_NO_ENCONTRADO
	'No es un usuario del sistema.';

/* E_USUARIO_REGISTRADO */
CREATE EXCEPTION E_USUARIO_REGISTRADO
	'Usuario registrado!';

/* ----- Creating Roles ----- */

/* RRR_SOFTSURENA */
CREATE ROLE RRR_SOFTSURENA;
COMMENT ON ROLE RRR_SOFTSURENA IS 'Es un rol que puede ser usado para hacer ajuste importante del sistema.';

/* R_ADMINISTRADOR */
CREATE ROLE R_ADMINISTRADOR;

/* R_CAJERO */
CREATE ROLE R_CAJERO;
COMMENT ON ROLE R_CAJERO IS '<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url("https://scontent.fhex5-2.fna.fbcdn.net/v/t1.18169-9/12009790_1068370356506549_8599854094894222264_n.png?stp=c17.0.766.400a_dst-jpg_s526x296&_nc_cat=110&ccb=1-7&_nc_sid=300f58&_nc_ohc=nXq2jETM2u4AX_9v_Am&_nc_ht=scontent.fhex5-2.fna&oh=00_AfB4thmtk4ucoGYERiXlNDQyQTDO77TNolzoi3uQdqjZqA&oe=655A79DC");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
  background-attachment: fixed;
}
</style>
</head>
<body>

<h1>Rol Cajero</h1>

<p>El Rol de cajero permiso al usuario acceder al modulo de facturacci�n.</p>


</body>
</html>';

/* R_CLIENTE */
CREATE ROLE R_CLIENTE;

/* R_DOCTOR */
CREATE ROLE R_DOCTOR;

/* R_GERENTE */
CREATE ROLE R_GERENTE;

/* R_RRHH */
CREATE ROLE R_RRHH;

/* R_SECRETARIA */
CREATE ROLE R_SECRETARIA;

/* ----- Creating Table Triggers stubs ----- */

/* ALMACENES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER ALMACENES_BI
	FOR ALMACENES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* ALMACENES_DISPONIBLE_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER ALMACENES_DISPONIBLE_BI
	FOR ALMACENES_DISPONIBLE BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* ANTECEDENTES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER ANTECEDENTES_BI
	FOR ANTECEDENTES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* ARS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER ARS_BI
	FOR ARS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* ASEGURADOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER ASEGURADOS_BI
	FOR ASEGURADOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CARTONES_BINGO_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CARTONES_BINGO_BI
	FOR CARTONES_BINGO BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CATEGORIAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CATEGORIAS_BI
	FOR CATEGORIAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CONSULTAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CONSULTAS_BI
	FOR CONSULTAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CONTACTOS_DIRECCIONES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_DIRECCIONES_BI
	FOR CONTACTOS_DIRECCIONES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CONTACTOS_EMAIL_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_EMAIL_BI
	FOR CONTACTOS_EMAIL BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CONTACTOS_TEL_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_TEL_BI
	FOR CONTACTOS_TEL BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* CONTROL_CONSULTA_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTROL_CONSULTA_BI
	FOR CONTROL_CONSULTA BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* D_ANALISIS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER D_ANALISIS_BI
	FOR D_ANALISIS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* D_DEUDAS_PAGAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER D_DEUDAS_PAGAS_BI
	FOR D_DEUDAS_PAGAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* D_FACTURAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER D_FACTURAS_BI
	FOR D_FACTURAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* D_GUIA_VIGILANCIA_DESARROLLO_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER D_GUIA_VIGILANCIA_DESARROLLO_BI
	FOR D_GUIA_VIGILANCIA_DESARROLLO BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* D_RECETAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER D_RECETAS_BI
	FOR D_RECETAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* FOTO_PERSONA_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER FOTO_PERSONA_BI
	FOR FOTO_PERSONA BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* FOTO_PRODUCTO_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER FOTO_PRODUCTO_BI
	FOR FOTO_PRODUCTO BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* GENERALES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER GENERALES_BI
	FOR GENERALES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* HORARIOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER HORARIOS_BI
	FOR HORARIOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* HUELLAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER HUELLAS_BI
	FOR HUELLAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* INSCRIPCIONES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER INSCRIPCIONES_BI
	FOR INSCRIPCIONES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* MENSAJES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER MENSAJES_BI
	FOR MENSAJES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* METRICAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER METRICAS_BI
	FOR METRICAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* MOVIES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER MOVIES_BI
	FOR MOVIES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* M_ANALISIS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER M_ANALISIS_BI
	FOR M_ANALISIS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* M_DEUDAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER M_DEUDAS_BI
	FOR M_DEUDAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* M_ENTRADA_PRODUCTOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER M_ENTRADA_PRODUCTOS_BI
	FOR M_ENTRADA_PRODUCTOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* M_FACTURAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER M_FACTURAS_BI
	FOR M_FACTURAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* M_RECETAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER M_RECETAS_BI
	FOR M_RECETAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* PERSONAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER PERSONAS_BI
	FOR PERSONAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* PRECIOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER PRECIOS_BI
	FOR PRECIOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* PRODUCTOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER PRODUCTOS_BI
	FOR PRODUCTOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* RELACION_PADRE_ESTUDIANTE_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER RELACION_PADRE_ESTUDIANTE_BI
	FOR RELACION_PADRE_ESTUDIANTE BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* RELACION_PADRE_PACIENTE_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER RELACION_PADRE_PACIENTE_BI
	FOR RELACION_PADRE_PACIENTE BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* SINTOMAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER SINTOMAS_BI
	FOR SINTOMAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* TANDAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER TANDAS_BI
	FOR TANDAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* TURNOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER TURNOS_BI
	FOR TURNOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_ANALISIS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_ANALISIS_BI
	FOR T_ANALISIS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_CODIGOS_POSTALES_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_CODIGOS_POSTALES_BI
	FOR T_CODIGOS_POSTALES BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_E_S_SYS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_E_S_SYS_BI
	FOR T_E_S_SYS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_GUIA_VIGILANCIA_DESARROLLO_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_GUIA_VIGILANCIA_DESARROLLO_BI
	FOR T_GUIA_VIGILANCIA_DESARROLLO BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_IMPUESTOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_IMPUESTOS_BI
	FOR T_IMPUESTOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_MOTIVO_CONSULTA_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_MOTIVO_CONSULTA_BI
	FOR T_MOTIVO_CONSULTA BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_MUNICIPIOS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_MUNICIPIOS_BI
	FOR T_MUNICIPIOS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_PROVINCIAS_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_PROVINCIAS_BI
	FOR T_PROVINCIAS BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_PRUEBA_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_PRUEBA_BI
	FOR T_PRUEBA BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* T_TIPOS_PRECIO_BI (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER T_TIPOS_PRECIO_BI
	FOR T_TIPOS_PRECIO BEFORE INSERT
AS BEGIN END^

SET TERM ;^

/* ----- Creating Functions stubs ----- */

/* F_CONEXION (STUB) */
SET TERM ^;
CREATE OR ALTER FUNCTION F_CONEXION
RETURNS BOOLEAN
AS BEGIN return null; END^

SET TERM ;^

/* F_OBJECTOS (STUB) */
SET TERM ^;
CREATE OR ALTER FUNCTION F_OBJECTOS (
	ID_OBJ D_ID
) 
RETURNS VARCHAR(45)
AS BEGIN return null; END^

SET TERM ;^

/* F_PRIVILEGIO (STUB) */
SET TERM ^;
CREATE OR ALTER FUNCTION F_PRIVILEGIO (
	ABREV D_ABREVIATURA
) 
RETURNS VARCHAR(15)
AS BEGIN return null; END^

SET TERM ;^

/* F_PROCEDIMIENTOS_SHOW (STUB) */
SET TERM ^;
CREATE OR ALTER FUNCTION F_PROCEDIMIENTOS_SHOW (
	SUFIJO D_VARCHAR_15
) 
RETURNS BOOLEAN
AS BEGIN return null; END^

SET TERM ;^

/* F_TIPO_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER FUNCTION F_TIPO_USUARIO (
	ID_TIPO D_ID
) 
RETURNS VARCHAR(45)
AS BEGIN return null; END^

SET TERM ;^

/* ----- Creating Procedures stubs ----- */

/* ACTUALIZAR_ESTADISTICAS_INDICES (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ACTUALIZAR_ESTADISTICAS_INDICES
AS BEGIN END^
SET TERM ;^

/* PARSER (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE PARSER (
	TCTEXTO D_BLOB_TEXTO,
	TCSEPARADOR D_VARCHAR_15
) 
RETURNS (
	FTCNOMBRE D_VARCHAR_1024
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* ACTUALIZAR_TABLA_PIVOT (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ACTUALIZAR_TABLA_PIVOT (
	TCTABLAPIVOT VARCHAR(28),
	TCVISTA VARCHAR(28),
	TCPRIMERACOLUMNACABECERA VARCHAR(64),
	TCOTRASCOLUMNASCABECERA VARCHAR(4096),
	TCCOLUMNADATOS VARCHAR(28),
	TCVALORESDATOS VARCHAR(1024)
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_AGREGAR_PERMISO_ADMIN_PROCE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_AGREGAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_AGREGAR_PERMISO_ADMIN_ROLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_AGREGAR_PERMISO_ADMIN_ROLE (
	I_ROLE D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_ALTER_ROLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_ALTER_ROLE (
	I_NOMBRE_ACTUAL D_VARCHAR_70,
	I_NOMBRE_NUEVO D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_BORRAR_PERMISO_ADMIN_PROCE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_BORRAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_BORRAR_ROLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_BORRAR_ROLE (
	I_ROLE D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL (
	I_USUARIO D_USER_NAME,
	I_CLAVE D_CLAVE
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_CONSULTA_PERMISOS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CONSULTA_PERMISOS
RETURNS (
	USER_MANAGEMENT D_BOOLEAN_F,
	READ_RAW_PAGES D_BOOLEAN_F,
	CREATE_USER_TYPES D_BOOLEAN_F,
	USE_NBACKUP_UTILITY D_BOOLEAN_F,
	CHANGE_SHUTDOWN_MODE D_BOOLEAN_F,
	TRACE_ANY_ATTACHMENT D_BOOLEAN_F,
	MONITOR_ANY_ATTACHMENT D_BOOLEAN_F,
	ACCESS_SHUTDOWN_DATABASE D_BOOLEAN_F,
	CREATE_DATABASE D_BOOLEAN_F,
	DROP_DATABASE D_BOOLEAN_F,
	USE_GBAK_UTILITY D_BOOLEAN_F,
	USE_GSTAT_UTILITY D_BOOLEAN_F,
	USE_GFIX_UTILITY D_BOOLEAN_F,
	IGNORE_DB_TRIGGERS D_BOOLEAN_F,
	CHANGE_HEADER_SETTINGS D_BOOLEAN_F,
	SELECT_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	ACCESS_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	MODIFY_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	CHANGE_MAPPING_RULES D_BOOLEAN_F,
	USE_GRANTED_BY_CLAUSE D_BOOLEAN_F,
	GRANT_REVOKE_ON_ANY_OBJECT D_BOOLEAN_F,
	GRANT_REVOKE_ANY_DDL_RIGHT D_BOOLEAN_F,
	CREATE_PRIVILEGED_ROLES D_BOOLEAN_F,
	GET_DBCRYPT_INFO D_BOOLEAN_F,
	MODIFY_EXT_CONN_POOL D_BOOLEAN_F,
	REPLICATE_INTO_DATABASE D_BOOLEAN_F,
	PROFILE_ANY D_BOOLEAN_F
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* ADMIN_CREATE_ROLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CREATE_ROLE (
	I_ROLE D_ROL
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_DAR_ROL_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_DAR_ROL_USUARIO (
	I_ROL D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70,
	I_ADMIN D_BOOLEAN_F
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_GET_ID_FACTURA_NUEVA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_GET_ID_FACTURA_NUEVA (
	ID_TURNO TYPE OF COLUMN TURNOS.ID
) 
RETURNS (
	ID_FACTURA TYPE OF COLUMN V_M_FACTURAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* ADMIN_QUITAR_PERMISO_ADMIN_PROCE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_QUITAR_PERMISO_ADMIN_ROL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_ROL (
	I_ROLE D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_QUITAR_ROL_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_ROL_USUARIO (
	I_ROL D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_QUITAR_ROLES_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_ROLES_USUARIO (
	USER_NAME TYPE OF COLUMN GET_ROL.USER_NAME
) 
AS BEGIN END^
SET TERM ;^

/* ADMIN_SET_ROLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_SET_ROLE (
	I_ROLE D_VARCHAR_70
) 
AS BEGIN END^
SET TERM ;^

/* CREAR_TABLA_PIVOT (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE CREAR_TABLA_PIVOT (
	TCNOMBRETABLA VARCHAR(28),
	TCVISTA VARCHAR(28),
	TCPRIMERACOLUMNACABECERA VARCHAR(64),
	TCOTRASCOLUMNASCABECERA VARCHAR(4096),
	TCCOLUMNADATOS VARCHAR(28),
	TCTIPODATOS VARCHAR(64)
) 
AS BEGIN END^
SET TERM ;^

/* HALLAR_PALABRAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE HALLAR_PALABRAS (
	FTCTEXTO D_BLOB_TEXTO
) 
RETURNS (
	FTCPALABRA D_VARCHAR_45
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* PERM_BASICOS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_BASICOS (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
AS BEGIN END^
SET TERM ;^

/* PERM_CREAR_FACTURAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_CREAR_FACTURAS (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
AS BEGIN END^
SET TERM ;^

/* PERM_PANEL_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_PANEL_USUARIO (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_D_MOTIVO_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_MOTIVO_CONSULTA (
	ID TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_PADRE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PADRE (
	ID TYPE OF COLUMN PERSONAS_PADRES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_TURNO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_TURNO (
	ID TYPE OF COLUMN TURNOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_M_DEUDAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_DEUDAS (
	ID TYPE OF COLUMN M_DEUDAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONSULTA (
	ID TYPE OF COLUMN CONSULTAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_PROOVEDOR_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PROOVEDOR_ATR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_HORARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HORARIO (
	ID TYPE OF COLUMN HORARIOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_CLIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_CLIENTE (
	ID TYPE OF COLUMN PERSONAS_CLIENTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_ANULAR_FACTURA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ANULAR_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA (
	ID TYPE OF COLUMN PERSONAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_ANTECEDENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ANTECEDENTE (
	ID TYPE OF COLUMN ANTECEDENTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_EMPLEADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONTROL_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTROL_CONSULTA (
	ID TYPE OF COLUMN CONTROL_CONSULTA.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_GENERAL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_GENERAL (
	ID_PERSONA TYPE OF COLUMN GENERALES.ID_PERSONA
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_D_FACTURA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_FACTURA (
	ID TYPE OF COLUMN D_FACTURAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONTACTO_TEL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_TEL (
	ID TYPE OF COLUMN CONTACTOS_TEL.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRODUCTO (
	I_ID_PRODUCTO TYPE OF COLUMN PRODUCTOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_EMPLEADO_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_EMPLEADO_ATR (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PRECIOS_BY_ID_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRECIOS_BY_ID_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN V_PRODUCTOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_D_ANALISIS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_ANALISIS (
	ID TYPE OF COLUMN D_ANALISIS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_ARS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ARS (
	ID TYPE OF COLUMN ARS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PRECIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRECIO (
	ID TYPE OF COLUMN PRECIOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CARTON_BINGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CARTON_BINGO (
	I_ID TYPE OF COLUMN CARTONES_BINGO.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_PROOVEDOR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PROOVEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_D_DEUDAS_PAGAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_DEUDAS_PAGAS (
	ID TYPE OF COLUMN D_DEUDAS_PAGAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_PACIENTE_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PACIENTE_ATR (
	ID TYPE OF COLUMN PERSONAS_PACIENTES_ATR.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONTACTO_EMAIL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_EMAIL (
	ID TYPE OF COLUMN CONTACTOS_EMAIL.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CATEGORIA (
	ID TYPE OF COLUMN CATEGORIAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_PACIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_ESTUDIANTE_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_ESTUDIANTE_ATR (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONTACTO_DIRECCION (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_DIRECCION (
	ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_D_GUIA_VIGILANCIA_DESARROLLO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_GUIA_VIGILANCIA_DESARROLLO (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_METRICA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_METRICA (
	ID TYPE OF COLUMN METRICAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_PERSONA_CLIENTE_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_CLIENTE_ATR (
	ID TYPE OF COLUMN PERSONAS_CLIENTES_ATR.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_M_FACTURA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_ASEGURADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ASEGURADO (
	ID TYPE OF COLUMN ASEGURADOS.ID_PERSONA
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_ALMACEN (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALMACEN (
	ID TYPE OF COLUMN ALMACENES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_ALL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALL
AS BEGIN END^
SET TERM ;^

/* SP_D_ALMACEN_DISPONIBLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALMACEN_DISPONIBLE (
	ID TYPE OF COLUMN ALMACENES_DISPONIBLE.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CARGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CARGO (
	ID TYPE OF COLUMN CARGOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_CONSULTA_BY_CONTROL_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONSULTA_BY_CONTROL_CONSULTA (
	ID_CONTROL_CONSULTA D_ID_DEFAULT_0
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_DEPARTAMENTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_DEPARTAMENTO (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_CATEGORIA (
	ID TYPE OF COLUMN FOTO_CATEGORIA.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_CATEGORIA_BY_ID_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_CATEGORIA_BY_ID_CATEGORIA (
	ID_CATEGORIA TYPE OF COLUMN FOTO_CATEGORIA.ID_CATEGORIA
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PERSONA (
	ID TYPE OF COLUMN FOTO_PERSONA.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_PERSONA_BY_ID_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PERSONA_BY_ID_PERSONA (
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PRODUCTO (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_FOTO_PRODUCTO_BY_ID_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PRODUCTO_BY_ID_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_HUELLA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HUELLA (
	ID TYPE OF COLUMN HUELLAS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_HUELLA_ID_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HUELLA_ID_PERSONA (
	ID_PERSONA TYPE OF COLUMN HUELLAS.ID_PERSONAL
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_METRICA_BY_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_METRICA_BY_CONSULTA (
	ID_CONSULTA TYPE OF COLUMN METRICAS.ID_CONSULTA
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_M_ENTRADA_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_ENTRADA_PRODUCTO (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_D_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_USUARIO (
	USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_ALMACEN (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ALMACEN (
	NOMBRE TYPE OF COLUMN ALMACENES.NOMBRE,
	UBICACION TYPE OF COLUMN ALMACENES.UBICACION,
	ESTADO TYPE OF COLUMN ALMACENES.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ALMACENES.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_ALMACENES_DISPONIBLE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ALMACENES_DISPONIBLE (
	ID_TURNO TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_TURNO,
	USER_NAME TYPE OF COLUMN ALMACENES_DISPONIBLE.USER_NAME,
	ID_ALMACEN TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_ALMACEN
) 
RETURNS (
	ID TYPE OF COLUMN ALMACENES_DISPONIBLE.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_ANTECEDENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ANTECEDENTE (
	ID_CONSULTA TYPE OF COLUMN ANTECEDENTES.ID_CONSULTA,
	DESCRIPCION TYPE OF COLUMN ANTECEDENTES.DESCRIPCION
) 
RETURNS (
	O_ID TYPE OF COLUMN ANTECEDENTES.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_ARS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ARS (
	DESCRIPCION TYPE OF COLUMN ARS.DESCRIPCION,
	COVER_CONSULTA_POR_C TYPE OF COLUMN ARS.COVERCONSULTAPORC,
	ESTADO TYPE OF COLUMN ARS.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ARS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_ASEGURADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ASEGURADO (
	ID_PERSONA TYPE OF COLUMN ASEGURADOS.ID_PERSONA,
	ID_ARS TYPE OF COLUMN ASEGURADOS.ID_ARS,
	NO_NSS TYPE OF COLUMN ASEGURADOS.NO_NSS,
	ESTADO TYPE OF COLUMN ASEGURADOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_CARGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CARGO (
	NOMBRE TYPE OF COLUMN CARGOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN CARGOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CARGOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN CARGOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CARTON_BINGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CARTON_BINGO (
	CARTON_HASH TYPE OF COLUMN CARTONES_BINGO.CARTON_HASH,
	MATRIZ_OBJ TYPE OF COLUMN CARTONES_BINGO.MATRIZ_OBJ
) 
RETURNS (
	O_ID TYPE OF COLUMN CARTONES_BINGO.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CATEGORIA (
	DESCRIPCION TYPE OF COLUMN CATEGORIAS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CATEGORIAS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN CATEGORIAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONSULTA (
	ID_PACIENTE TYPE OF COLUMN CONSULTAS.ID_PACIENTE,
	ID_CONTROL_CONSULTA TYPE OF COLUMN CONSULTAS.ID_CONTROL_CONSULTA,
	LINEA TYPE OF COLUMN CONSULTAS.LINEA,
	FECHA TYPE OF COLUMN CONSULTAS.FECHA
) 
RETURNS (
	O_ID TYPE OF COLUMN CONSULTAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_V_DIRECCION (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_V_DIRECCION (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_CONTACTO_DIRECCION (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_DIRECCION (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	DIRECCION TYPE OF COLUMN CONTACTOS_DIRECCIONES.DIRECCION,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CONTACTO_EMAIL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_EMAIL (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_EMAIL.ID_PERSONA,
	EMAIL TYPE OF COLUMN CONTACTOS_EMAIL.EMAIL,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_EMAIL.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN CONTACTOS_EMAIL.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CONTACTO_TEL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_TEL (
	I_ID_PERSONA TYPE OF COLUMN V_CONTACTOS_TEL.ID_PERSONA,
	I_TELEFONO TYPE OF COLUMN V_CONTACTOS_TEL.TELEFONO,
	I_TIPO TYPE OF COLUMN V_CONTACTOS_TEL.TIPO,
	I_POR_DEFECTO TYPE OF COLUMN V_CONTACTOS_TEL.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN V_CONTACTOS_TEL.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_CONTROL_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTROL_CONSULTA (
	USER_NAME TYPE OF COLUMN CONTROL_CONSULTA.USER_NAME,
	CANTIDAD_PACIENTE TYPE OF COLUMN CONTROL_CONSULTA.CANTIDAD_PACIENTE,
	DIA TYPE OF COLUMN CONTROL_CONSULTA.DIA,
	INICIAL TYPE OF COLUMN CONTROL_CONSULTA.INICIAL,
	FINAL TYPE OF COLUMN CONTROL_CONSULTA.FINAL,
	ESTADO TYPE OF COLUMN CONTROL_CONSULTA.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ALMACENES.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_DEPARTAMENTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_DEPARTAMENTO (
	NOMBRE TYPE OF COLUMN DEPARTAMENTOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN DEPARTAMENTOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN DEPARTAMENTOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_DOCTOR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_DOCTOR (
	I_USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME,
	I_CLAVE D_CLAVE,
	I_PNOMBRE TYPE OF COLUMN VS_USUARIOS.PNOMBRE,
	I_SNOMBRE TYPE OF COLUMN VS_USUARIOS.SNOMBRE,
	I_APELLIDOS TYPE OF COLUMN VS_USUARIOS.APELLIDOS,
	I_ROL TYPE OF COLUMN GET_ROL.ROL,
	I_COD_EXEQUATUR D_VARCHAR_70,
	I_ESPECIALIDAD D_VARCHAR_70,
	I_ESTADO TYPE OF COLUMN VS_USUARIOS.ESTADO,
	I_ADMINISTRADOR TYPE OF COLUMN VS_USUARIOS.ADMINISTRADOR
) 
RETURNS (
	O_ID TYPE OF COLUMN V_PERSONAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_D_FACTURAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_FACTURAS (
	LINEA TYPE OF COLUMN D_FACTURAS.LINEA,
	ID_FACTURA TYPE OF COLUMN D_FACTURAS.ID_FACTURA,
	ID_PRODUCTO TYPE OF COLUMN D_FACTURAS.ID_PRODUCTO,
	ID_PRECIO TYPE OF COLUMN D_FACTURAS.ID_PRECIO,
	CANTIDAD TYPE OF COLUMN D_FACTURAS.CANTIDAD
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_D_GUIA_VIGILANCIA_DESARROLLO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_GUIA_VIGILANCIA_DESARROLLO (
	ID_GVD TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_GVD,
	ID_PACIENTE TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_PACIENTE
) 
RETURNS (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_D_MOTIVO_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_MOTIVO_CONSULTA (
	ID_CONSULTA TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID_CONSULTA,
	ID_MOTIVO_CONSULTA TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID_MOTIVO_CONSULTA
) 
RETURNS (
	ID TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_D_RECETA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_RECETA (
	ID_RECETA TYPE OF COLUMN D_RECETAS.ID_RECETA,
	LINEA TYPE OF COLUMN D_RECETAS.LINEA,
	ID_MEDICAMENTO TYPE OF COLUMN D_RECETAS.ID_MEDICAMENTO,
	CANTIDAD TYPE OF COLUMN D_RECETAS.CANTIDAD,
	D_DOSIS TYPE OF COLUMN D_RECETAS.D_DOSIS
) 
RETURNS (
	ID TYPE OF COLUMN D_RECETAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_CATEGORIA (
	ID_CATEGORIA TYPE OF COLUMN FOTO_CATEGORIA.ID_CATEGORIA,
	FOTO TYPE OF COLUMN FOTO_CATEGORIA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_CATEGORIA.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_CATEGORIA.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_PERSONA (
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA,
	FOTO TYPE OF COLUMN FOTO_PERSONA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PERSONA.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_PERSONA.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO,
	FOTO TYPE OF COLUMN FOTO_PRODUCTO.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PRODUCTO.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_GENERAL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_GENERAL (
	ID_PERSONA TYPE OF COLUMN GENERALES.ID_PERSONA,
	CEDULA TYPE OF COLUMN GENERALES.CEDULA,
	ID_TIPO_SANGRE TYPE OF COLUMN GENERALES.ID_TIPO_SANGRE,
	ESTADO_CIVIL TYPE OF COLUMN GENERALES.ESTADO_CIVIL
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_HORARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_HORARIO (
	DESCRIPCION TYPE OF COLUMN HORARIOS.DESCRIPCION,
	HORA TYPE OF COLUMN HORARIOS.HORA,
	TOLERANCIA TYPE OF COLUMN HORARIOS.TOLERANCIA,
	ESTADO TYPE OF COLUMN HORARIOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN HORARIOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_HUELLA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_HUELLA (
	ID_PERSONA TYPE OF COLUMN HUELLAS.ID_PERSONAL,
	TIPO_DEDO TYPE OF COLUMN HUELLAS.TIPO_DEDO,
	HUELLA TYPE OF COLUMN HUELLAS.HUELLA
) 
RETURNS (
	ID TYPE OF COLUMN HUELLAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_METRICA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_METRICA (
	ID_CONSULTA TYPE OF COLUMN V_METRICAS.ID_CONSULTA,
	PESO_KG TYPE OF COLUMN V_METRICAS.PESOKG,
	ESTATURA_METRO TYPE OF COLUMN V_METRICAS.ESTATURAMETRO,
	ESCEFALO TYPE OF COLUMN V_METRICAS.ESCEFALO,
	ENF_DETECT TYPE OF COLUMN V_METRICAS.ENF_DETECT,
	HALLAZGOS_POS TYPE OF COLUMN V_METRICAS.HALLAZGOS_POS,
	ID_DIAG TYPE OF COLUMN V_METRICAS.ID_DIAG,
	TX TYPE OF COLUMN V_METRICAS.TX,
	COMPLEMENTO TYPE OF COLUMN V_METRICAS.COMPLEMENTO,
	IMAGEN_TEXTO TYPE OF COLUMN V_METRICAS.IMAGEN_TEXTO
) 
RETURNS (
	ID TYPE OF COLUMN V_METRICAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_M_DEUDAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_DEUDAS (
	ID_CLIENTE TYPE OF COLUMN M_DEUDAS.ID_CLIENTE,
	CONCEPTO TYPE OF COLUMN M_DEUDAS.CONCEPTO,
	MONTO TYPE OF COLUMN M_DEUDAS.MONTO
) 
RETURNS (
	O_ID TYPE OF COLUMN M_DEUDAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_M_ENTRADA_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_ENTRADA_PRODUCTO (
	ID_PROVEEDOR TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_PROVEEDOR,
	ID_ALMACEN TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_ALMACEN,
	COD_FACTURA TYPE OF COLUMN M_ENTRADA_PRODUCTOS.COD_FACTURA,
	ESTADO TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ESTADO DEFAULT 't'
) 
RETURNS (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_M_FACTURA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_FACTURA (
	ID_CLIENTE TYPE OF COLUMN M_FACTURAS.ID_CLIENTE,
	ID_CONTACTOS_TEL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_TEL,
	ID_CONTACTOS_DIRECCIONES TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_DIRECCIONES,
	ID_CONTACTOS_EMAIL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_EMAIL,
	ID_TURNO TYPE OF COLUMN M_FACTURAS.ID_TURNO,
	ESTADO_FACTURA TYPE OF COLUMN M_FACTURAS.ESTADO_FACTURA,
	NOMBRE_TEMP TYPE OF COLUMN M_FACTURAS.NOMBRE_TEMP
) 
RETURNS (
	ID TYPE OF COLUMN M_FACTURAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_M_RECETA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_RECETA (
	ID_CONSULTA TYPE OF COLUMN M_RECETAS.ID_CONSULTA
) 
RETURNS (
	ID TYPE OF COLUMN M_RECETAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA (
	PERSONA TYPE OF COLUMN PERSONAS.PERSONA,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
RETURNS (
	ID_PERSONA TYPE OF COLUMN PERSONAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_PERSONA_CLIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_CLIENTE (
	ID TYPE OF COLUMN PERSONAS_CLIENTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_EMPLEADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_EMPLEADO_ATR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_EMPLEADO_ATR (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID,
	ID_DEPARTAMENTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_DEPARTAMENTO,
	ID_CARGO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_CARGO,
	SUELDO_BRUTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.SUELDO_BRUTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_PACIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_PADRE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PADRE (
	ID TYPE OF COLUMN PERSONAS_PADRES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PERSONA_PROVEEDOR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_PRECIOS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PRECIOS (
	ID_PRODUCTO TYPE OF COLUMN PRECIOS.ID_PRODUCTO,
	ID_TIPO_PRECIO TYPE OF COLUMN PRECIOS.ID_TIPO_PRECIO,
	ID_TIPO_IMPUESTO TYPE OF COLUMN PRECIOS.ID_TIPO_IMPUESTO,
	PRECIO TYPE OF COLUMN PRECIOS.PRECIO,
	MONEDA TYPE OF COLUMN PRECIOS.MONEDA,
	FECHA_INICIO TYPE OF COLUMN PRECIOS.FECHA_INICIO,
	FECHA_FIN TYPE OF COLUMN PRECIOS.FECHA_FIN,
	DESCUENTO TYPE OF COLUMN PRECIOS.DESCUENTO,
	COSTO_ENVIO TYPE OF COLUMN PRECIOS.COSTO_ENVIO,
	ESTADO TYPE OF COLUMN PRECIOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN PRECIOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PRODUCTO (
	ID_CATEGORIA TYPE OF COLUMN PRODUCTOS.ID_CATEGORIA,
	CODIGO TYPE OF COLUMN PRODUCTOS.CODIGO,
	DESCRIPCION TYPE OF COLUMN PRODUCTOS.DESCRIPCION,
	NOTA TYPE OF COLUMN PRODUCTOS.NOTA,
	ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN PRODUCTOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_R_PADRE_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_R_PADRE_ESTUDIANTE (
	ID_PADRE_O_MADRE TYPE OF COLUMN V_RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_ESTUDIANTE TYPE OF COLUMN V_RELACION_PADRE_ESTUDIANTE.ID_ESTUDIANTE
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_R_PADRE_PACIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_R_PADRE_PACIENTE (
	ID_PADRE_O_MADRE TYPE OF COLUMN V_RELACION_PADRE_PACIENTE.ID_PADRE_O_MADRE,
	ID_PACIENTE TYPE OF COLUMN V_RELACION_PADRE_PACIENTE.ID_PACIENTE
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_TANDA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_TANDA (
	ANNO_INICIAL TYPE OF COLUMN V_TANDAS.ANNO_INICIAL,
	ANNO_FINAL TYPE OF COLUMN V_TANDAS.ANNO_FINAL,
	HORA_INICIO TYPE OF COLUMN V_TANDAS.HORA_INICIO,
	HORA_FINAL TYPE OF COLUMN V_TANDAS.HORA_FINAL,
	LUNES TYPE OF COLUMN V_TANDAS.LUNES,
	MARTES TYPE OF COLUMN V_TANDAS.MARTES,
	MIERCOLES TYPE OF COLUMN V_TANDAS.MIERCOLES,
	JUEVES TYPE OF COLUMN V_TANDAS.JUEVES,
	VIERNES TYPE OF COLUMN V_TANDAS.VIERNES,
	SABADOS TYPE OF COLUMN V_TANDAS.SABADOS,
	DOMINGOS TYPE OF COLUMN V_TANDAS.DOMINGOS,
	CANTIDAD_ESTUDIANTES TYPE OF COLUMN V_TANDAS.CANTIDAD_ESTUDIANTES,
	CON_EDAD TYPE OF COLUMN V_TANDAS.CON_EDAD,
	EDAD_MINIMA TYPE OF COLUMN V_TANDAS.EDAD_MINIMA,
	EDAD_MAXIMA TYPE OF COLUMN V_TANDAS.EDAD_MAXIMA,
	ESTADO TYPE OF COLUMN V_TANDAS.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN V_TANDAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_TURNO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_TURNO (
	TURNO_USUARIO TYPE OF COLUMN TURNOS.TURNO_USUARIO
) 
RETURNS (
	ID TYPE OF COLUMN TURNOS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_I_T_E_S_SYS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_T_E_S_SYS (
	LOGO TYPE OF COLUMN T_E_S_SYS.LOGO,
	PATH_LOGO TYPE OF COLUMN T_E_S_SYS.PATH_LOGO
) 
AS BEGIN END^
SET TERM ;^

/* SP_I_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_USUARIO (
	USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME,
	CLAVE D_CLAVE,
	PNOMBRE TYPE OF COLUMN VS_USUARIOS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN VS_USUARIOS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN VS_USUARIOS.APELLIDOS,
	ESTADO TYPE OF COLUMN VS_USUARIOS.ESTADO,
	ADMINISTRADOR TYPE OF COLUMN VS_USUARIOS.ADMINISTRADOR,
	DESCRIPCION TYPE OF COLUMN VS_USUARIOS.DESCRIPCION,
	TAGS_ D_VARCHAR_MAX
) 
AS BEGIN END^
SET TERM ;^

/* SP_S_GET_TURNOS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_S_GET_TURNOS
RETURNS (
	ID TYPE OF COLUMN TURNOS.ID,
	TURNO_USUARIO TYPE OF COLUMN TURNOS.TURNO_USUARIO,
	FECHA_HORA_INICIO TYPE OF COLUMN TURNOS.FECHA_HORA_INICIO,
	FECHA_HORA_FINAL TYPE OF COLUMN TURNOS.FECHA_HORA_FINAL,
	ESTADO TYPE OF COLUMN TURNOS.ESTADO,
	MONTO_FACTURADO TYPE OF COLUMN TURNOS.MONTO_FACTURADO,
	MONTO_DEVUELTO TYPE OF COLUMN TURNOS.MONTO_DEVUELTO,
	MONTO_EFECTIVO TYPE OF COLUMN TURNOS.MONTO_EFECTIVO,
	MONTO_CREDITO TYPE OF COLUMN TURNOS.MONTO_CREDITO,
	ID_FACTURA TYPE OF COLUMN M_FACTURAS.ID
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* SP_U_ALMACEN (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ALMACEN (
	ID TYPE OF COLUMN ALMACENES.ID,
	NOMBRE TYPE OF COLUMN ALMACENES.NOMBRE,
	UBICACION TYPE OF COLUMN ALMACENES.UBICACION,
	ESTADO TYPE OF COLUMN ALMACENES.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_ANTECEDENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ANTECEDENTE (
	ID TYPE OF COLUMN ANTECEDENTES.ID,
	DESCRIPCION TYPE OF COLUMN ANTECEDENTES.DESCRIPCION
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_ARS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ARS (
	ID TYPE OF COLUMN ARS.ID,
	DESCRIPCION TYPE OF COLUMN ARS.DESCRIPCION,
	COVERTURA TYPE OF COLUMN ARS.COVERCONSULTAPORC,
	ESTADO TYPE OF COLUMN ARS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_ASEGURADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ASEGURADO (
	ID_PERSONA TYPE OF COLUMN ASEGURADOS.ID_PERSONA,
	ID_ARS TYPE OF COLUMN ASEGURADOS.ID_ARS,
	NO_NSS TYPE OF COLUMN ASEGURADOS.NO_NSS,
	ESTADO TYPE OF COLUMN ASEGURADOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CARGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CARGO (
	ID TYPE OF COLUMN CARGOS.ID,
	NOMBRE TYPE OF COLUMN CARGOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN CARGOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CARGOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CARTONES_BINGO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CARTONES_BINGO (
	ID TYPE OF COLUMN CARTONES_BINGO.ID,
	ESTADO TYPE OF COLUMN CARTONES_BINGO.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CATEGORIA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CATEGORIA (
	ID TYPE OF COLUMN V_CATEGORIAS.ID,
	DESCRIPCION TYPE OF COLUMN V_CATEGORIAS.DESCRIPCION,
	ESTADO TYPE OF COLUMN V_CATEGORIAS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CONSULTAS (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONSULTAS (
	ID TYPE OF COLUMN CONSULTAS.ID,
	ID_PACIENTE TYPE OF COLUMN CONSULTAS.ID_PACIENTE,
	ID_CONTROL_CONSULTA TYPE OF COLUMN CONSULTAS.ID_CONTROL_CONSULTA,
	LINEA TYPE OF COLUMN CONSULTAS.LINEA,
	ESTADO TYPE OF COLUMN CONSULTAS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CONTACTO_DIRECCION (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_DIRECCION (
	ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID,
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	DIRECCION TYPE OF COLUMN CONTACTOS_DIRECCIONES.DIRECCION,
	ESTADO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CONTACTO_EMAIL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_EMAIL (
	ID TYPE OF COLUMN CONTACTOS_EMAIL.ID,
	EMAIL TYPE OF COLUMN CONTACTOS_EMAIL.EMAIL,
	ESTADO TYPE OF COLUMN CONTACTOS_EMAIL.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_EMAIL.POR_DEFECTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CONTACTO_TEL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_TEL (
	ID TYPE OF COLUMN CONTACTOS_TEL.ID,
	TELEFONO TYPE OF COLUMN CONTACTOS_TEL.TELEFONO,
	TIPO TYPE OF COLUMN CONTACTOS_TEL.TIPO,
	ESTADO TYPE OF COLUMN CONTACTOS_TEL.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_TEL.POR_DEFECTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_CONTROL_CONSULTA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTROL_CONSULTA (
	ID TYPE OF COLUMN CONTROL_CONSULTA.ID,
	USER_NAME TYPE OF COLUMN CONTROL_CONSULTA.USER_NAME,
	CANTIDAD_PACIENTE TYPE OF COLUMN CONTROL_CONSULTA.CANTIDAD_PACIENTE,
	DIA TYPE OF COLUMN CONTROL_CONSULTA.DIA,
	INICIAL TYPE OF COLUMN CONTROL_CONSULTA.INICIAL,
	FINAL TYPE OF COLUMN CONTROL_CONSULTA.FINAL,
	ESTADO TYPE OF COLUMN CONTROL_CONSULTA.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_DEPARTAMENTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_DEPARTAMENTO (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID,
	NOMBRE TYPE OF COLUMN DEPARTAMENTOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN DEPARTAMENTOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN DEPARTAMENTOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_DEUDA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_DEUDA (
	ID_DEUDA TYPE OF COLUMN M_DEUDAS.ID,
	CONCEPTO TYPE OF COLUMN M_DEUDAS.CONCEPTO,
	MONTO TYPE OF COLUMN M_DEUDAS.MONTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_D_GUIA_VIGILANCIA_DESARROLLO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_D_GUIA_VIGILANCIA_DESARROLLO (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID,
	ID_GVD TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_GVD,
	ID_PACIENTE TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_PACIENTE
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_R_PADRE_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_R_PADRE_ESTUDIANTE (
	ID TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_PADRE_O_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_ESTUDIANTE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_ESTUDIANTE
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA (
	ID TYPE OF COLUMN PERSONAS.ID,
	PERSONA TYPE OF COLUMN PERSONAS.PERSONA,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID,
	ID_R_PADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_PADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_R_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_FACTURA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID,
	ID_CONTACTOS_TEL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_TEL,
	ID_CONTACTOS_DIRECCIONES TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_DIRECCIONES,
	ID_CONTACTOS_EMAIL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_EMAIL,
	ID_TURNO TYPE OF COLUMN M_FACTURAS.ID_TURNO,
	ESTADO_FACTURA TYPE OF COLUMN M_FACTURAS.ESTADO_FACTURA,
	NOMBRE_TEMP TYPE OF COLUMN M_FACTURAS.NOMBRE_TEMP
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_FOTO_PERSONA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FOTO_PERSONA (
	ID TYPE OF COLUMN FOTO_PERSONA.ID,
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA,
	FOTO TYPE OF COLUMN FOTO_PERSONA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PERSONA.ACTUAL
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_FOTO_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FOTO_PRODUCTO (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID,
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO,
	FOTO TYPE OF COLUMN FOTO_PRODUCTO.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PRODUCTO.ACTUAL
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_GENERAL (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_GENERAL (
	ID TYPE OF COLUMN GENERALES.ID_PERSONA,
	CEDULA TYPE OF COLUMN GENERALES.CEDULA,
	ID_TIPO_SANGRE TYPE OF COLUMN GENERALES.ID_TIPO_SANGRE,
	ESTADO_CIVIL TYPE OF COLUMN GENERALES.ESTADO_CIVIL
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_HORARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_HORARIO (
	ID TYPE OF COLUMN HORARIOS.ID,
	DESCRIPCION TYPE OF COLUMN HORARIOS.DESCRIPCION,
	HORA TYPE OF COLUMN HORARIOS.HORA,
	TOLERANCIA TYPE OF COLUMN HORARIOS.TOLERANCIA,
	ESTADO TYPE OF COLUMN HORARIOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_HUELLA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_HUELLA (
	ID TYPE OF COLUMN HUELLAS.ID,
	TIPO_DEDO TYPE OF COLUMN HUELLAS.TIPO_DEDO,
	HUELLA TYPE OF COLUMN HUELLAS.HUELLA
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_METRICA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_METRICA (
	ID TYPE OF COLUMN METRICAS.ID,
	PESOKG TYPE OF COLUMN METRICAS.PESOKG,
	ESTATURAMETRO TYPE OF COLUMN METRICAS.ESTATURAMETRO,
	ESCEFALO TYPE OF COLUMN METRICAS.ESCEFALO,
	ENF_DETECT TYPE OF COLUMN METRICAS.ENF_DETECT,
	HALLAZGOS_POS TYPE OF COLUMN METRICAS.HALLAZGOS_POS,
	ID_DIAG TYPE OF COLUMN METRICAS.ID_DIAG,
	TX TYPE OF COLUMN METRICAS.TX,
	COMPLEMENTO TYPE OF COLUMN METRICAS.COMPLEMENTO,
	IMAGEN_TEXTO TYPE OF COLUMN METRICAS.IMAGEN_TEXTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_M_ENTRADA_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_M_ENTRADA_PRODUCTO (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID,
	ID_PROVEEDOR TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_PROVEEDOR,
	ID_ALMACEN TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_ALMACEN,
	COD_FACTURA TYPE OF COLUMN M_ENTRADA_PRODUCTOS.COD_FACTURA,
	ESTADO TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PERSONA_EMPLEADO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID,
	ID_CARGO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_CARGO,
	SUELDO_BRUTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.SUELDO_BRUTO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PERSONA_ESTUDIANTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.ID,
	MATRICULA TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.MATRICULA
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PERSONA_PACIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID,
	CESAREA TYPE OF COLUMN PERSONAS_PACIENTES_ATR.CESAREA,
	TIEMPO_GESTACION TYPE OF COLUMN PERSONAS_PACIENTES_ATR.TIEMPO_GESTACION,
	FUMADOR TYPE OF COLUMN PERSONAS_PACIENTES_ATR.FUMADOR
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PERSONA_PROVEEDOR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.ID,
	CODIGO TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.CODIGO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PRECIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PRECIO (
	ID TYPE OF COLUMN PRECIOS.ID,
	ID_PRODUCTO TYPE OF COLUMN PRECIOS.ID_PRODUCTO,
	ID_TIPO_PRECIO TYPE OF COLUMN PRECIOS.ID_TIPO_PRECIO,
	ID_TIPO_IMPUESTO TYPE OF COLUMN PRECIOS.ID_TIPO_IMPUESTO,
	PRECIO TYPE OF COLUMN PRECIOS.PRECIO,
	MONEDA TYPE OF COLUMN PRECIOS.MONEDA,
	FECHA_INICIO TYPE OF COLUMN PRECIOS.FECHA_INICIO,
	FECHA_FIN TYPE OF COLUMN PRECIOS.FECHA_FIN,
	DESCUENTO TYPE OF COLUMN PRECIOS.DESCUENTO,
	COSTO_ENVIO TYPE OF COLUMN PRECIOS.COSTO_ENVIO,
	ESTADO TYPE OF COLUMN PRECIOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PRODUCTO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PRODUCTO (
	ID TYPE OF COLUMN PRODUCTOS.ID,
	ID_CATEGORIA TYPE OF COLUMN PRODUCTOS.ID_CATEGORIA,
	CODIGO TYPE OF COLUMN PRODUCTOS.CODIGO,
	DESCRIPCION TYPE OF COLUMN PRODUCTOS.DESCRIPCION,
	NOTA TYPE OF COLUMN PRODUCTOS.NOTA,
	ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_PROVEEDOR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS.ID,
	CODIGO_PROVEEDOR TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.CODIGO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_R_PADRE_PACIENTE (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_R_PADRE_PACIENTE (
	ID TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID,
	ID_PADRE_O_MADRE TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID_PADRE_O_MADRE,
	ID_PACIENTE TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID_PACIENTE
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_TANDA (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_TANDA (
	ID TYPE OF COLUMN TANDAS.ID,
	ANNO_INICIAL TYPE OF COLUMN TANDAS.ANNO_INICIAL,
	ANNO_FINAL TYPE OF COLUMN TANDAS.ANNO_FINAL,
	HORA_INICIO TYPE OF COLUMN TANDAS.HORA_INICIO,
	HORA_FINAL TYPE OF COLUMN TANDAS.HORA_FINAL,
	LUNES TYPE OF COLUMN TANDAS.LUNES,
	MARTES TYPE OF COLUMN TANDAS.MARTES,
	MIERCOLES TYPE OF COLUMN TANDAS.MIERCOLES,
	JUEVES TYPE OF COLUMN TANDAS.JUEVES,
	VIERNES TYPE OF COLUMN TANDAS.VIERNES,
	SABADOS TYPE OF COLUMN TANDAS.SABADOS,
	DOMINGOS TYPE OF COLUMN TANDAS.DOMINGOS,
	CANTIDAD_ESTUDIANTES TYPE OF COLUMN TANDAS.CANTIDAD_ESTUDIANTES,
	CON_EDAD TYPE OF COLUMN TANDAS.CON_EDAD,
	EDAD_MINIMA TYPE OF COLUMN TANDAS.EDAD_MINIMA,
	EDAD_MAXIMA TYPE OF COLUMN TANDAS.EDAD_MAXIMA,
	ESTADO TYPE OF COLUMN TANDAS.ESTADO
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_TURNO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_TURNO (
	ID TYPE OF COLUMN TURNOS.ID
) 
AS BEGIN END^
SET TERM ;^

/* SP_U_USUARIO (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_USUARIO (
	USER_NAME TYPE OF COLUMN SEC$USERS.SEC$USER_NAME,
	CLAVE D_CLAVE,
	PNOMBRE TYPE OF COLUMN SEC$USERS.SEC$FIRST_NAME,
	SNOMBRE TYPE OF COLUMN SEC$USERS.SEC$MIDDLE_NAME,
	APELLIDOS TYPE OF COLUMN SEC$USERS.SEC$LAST_NAME,
	ESTADO TYPE OF COLUMN SEC$USERS.SEC$ACTIVE,
	ADMINISTRADOR TYPE OF COLUMN SEC$USERS.SEC$ADMIN,
	DESCRIPCION TYPE OF COLUMN SEC$USERS.SEC$DESCRIPTION,
	TAGS_ D_VARCHAR_MAX
) 
AS BEGIN END^
SET TERM ;^

/* SYSTEM_ENCRIPTAR (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE SYSTEM_ENCRIPTAR (
	TCTEXTO D_VARCHAR_MAX,
	TCACCION CHAR(1),
	TCNUMEROENCRIPTACION D_VARCHAR_255,
	TCNUMEROREPETICION D_VARCHAR_255
) 
RETURNS (
	FTCNUEVOTEXTO D_VARCHAR_MAX
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* TEST (STUB) */
SET TERM ^;
CREATE OR ALTER PROCEDURE TEST
RETURNS (
	RESULTADO D_VARCHAR_255
)
AS BEGIN 
	SUSPEND;
END^
SET TERM ;^

/* ----- Creating DB Triggers stubs ----- */

/* AUTOROLE (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER AUTOROLE ON CONNECT
AS BEGIN END^

SET TERM ;^

/* SYSTEM_SHAREWARE (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE ON CONNECT
AS BEGIN END^

SET TERM ;^

/* SYSTEM_SHAREWARE2 (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE2 ON CONNECT
AS BEGIN END^

SET TERM ;^

/* SYSTEM_SHAREWARE3 (STUB) */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE3 ON CONNECT
AS BEGIN END^

SET TERM ;^

/* ----- COMPUTED FIELDs defining ----- */

/* CONSULTAS.TOTALCOSTO */
ALTER TABLE CONSULTAS
	DROP TOTALCOSTO,
	ADD TOTALCOSTO COMPUTED BY (CAST((costo - (costo * (descuento/100))) as D_DINERO));

/* METRICAS.INDICE_MASA_CORPORAL */
ALTER TABLE METRICAS
	DROP INDICE_MASA_CORPORAL,
	ADD INDICE_MASA_CORPORAL COMPUTED BY (CAST(PESOKG/(ESTATURAMETRO*ESTATURAMETRO) as D_MEDIDA));

/* ----- Creating Functions ----- */

/* F_CONEXION */
SET TERM ^;
CREATE OR ALTER FUNCTION F_CONEXION
RETURNS D_BOOLEAN_T
SQL SECURITY DEFINER
AS
DECLARE VARIABLE comando D_VARCHAR_1024;
DECLARE VARIABLE Fchi D_FECHA;
DECLARE VARIABLE Fcha D_FECHA;
DECLARE VARIABLE Fchv D_FECHA;
DECLARE VARIABLE uuid D_VARCHAR_70;
DECLARE VARIABLE entrada D_BOOLEAN_T;
DECLARE VARIABLE usuario D_USER_NAME;
DECLARE VARIABLE clave D_CLAVE;
BEGIN
    --Armamos nuestro select que sera ejecutado en el servidor.
    comando = 'SELECT FCHI, FCHA, FCHV FROM SP_V_E_S_SYS(?);';
    
    --Bandera utilizada para validar que existe registro.
    entrada = TRUE;
    
    uuid = (select RDB$GET_CONTEXT('SYSTEM', 'DB_GUID') from RDB$DATABASE);
    --TODO 08.04.2025 Excepcion para cuando los siguiente campos esten nulos. 
    usuario = (SELECT USUARIO FROM V_T_E_S_SYS);
    clave = (SELECT CLAVE FROM V_T_E_S_SYS);
    
    --ON EXTERNAL DATA SOURCE 'inet4://40.233.25.79:3050/registros.db'
    FOR EXECUTE STATEMENT (:comando) (:uuid)
    ON EXTERNAL DATA SOURCE 'inet4://40.233.25.79:3050//home/ubuntu/BaseDatos/registros.fdb'
    AS USER :usuario
    PASSWORD :clave
    INTO
    :fchi, :fcha, :fchv
    DO BEGIN
        
        IF(CURRENT_DATE < :fchi)THEN
            EXCEPTION E_FECHA_INICIAL_INCORRECTA;
            
        IF(CURRENT_DATE < :fcha)THEN
            EXCEPTION E_FECHA_ACTUAL_INCORRECTA;
            
        IF(CURRENT_DATE > :fchv)THEN
            EXCEPTION E_FECHA_VENCIMIENTO;
        
        --TODO 08.04.2025 codificar fechas.
        UPDATE V_T_E_S_SYS SET 
            FCHI = :fchi,
            FCHA = :fcha,
            FCHV = :fchv;
            
        entrada = FALSE;
    END
    
    RETURN entrada;
    
    WHEN SQLCODE -901 DO BEGIN
        IN AUTONOMOUS TRANSACTION DO BEGIN
            SELECT FCHI, FCHA, FCHV
            FROM V_T_E_S_SYS 
            INTO
            :fchi, :fcha, :fchv;
            
            --TODO 08.04.2025 Decodificar fechas.
            --TODO 08.04.2025  y si las fechas son nulas que pasa. 
            
            IF(CURRENT_DATE < :fchi)THEN
                EXCEPTION E_FECHA_INICIAL_INCORRECTA;
                
            IF(CURRENT_DATE < :fcha)THEN
                EXCEPTION E_FECHA_ACTUAL_INCORRECTA;
                
            IF(CURRENT_DATE > :fchv)THEN
                EXCEPTION E_FECHA_VENCIMIENTO;
                
            entrada = FALSE;
        END
        RETURN entrada;
    END--GDSCODE
    
END^
SET TERM ;^

/* F_OBJECTOS */
SET TERM ^;
CREATE OR ALTER FUNCTION F_OBJECTOS (
	ID_OBJ D_ID
) 
RETURNS D_VARCHAR_45
SQL SECURITY DEFINER
AS
DECLARE VARIABLE resultado D_VARCHAR_45; 
BEGIN
     resultado = '';
     
     IF(ID_OBJ = 0) THEN
          resultado = 'table';
     IF(ID_OBJ = 1) THEN
          resultado = 'view';
     IF(ID_OBJ = 2) THEN
          resultado = 'trigger';
     IF(ID_OBJ = 3) THEN
          resultado = '';
     IF(ID_OBJ = 4) THEN
          resultado = '';
     IF(ID_OBJ = 5) THEN
          resultado = 'procedure';
     IF(ID_OBJ = 6) THEN
          resultado = '';
     IF(ID_OBJ = 7) THEN
          resultado = 'exception';
     IF(ID_OBJ = 8) THEN
          resultado = 'user';
     IF(ID_OBJ = 9) THEN
          resultado = 'domain';
     IF(ID_OBJ = 10) THEN
          resultado = '';
     IF(ID_OBJ = 11) THEN
          resultado = 'character set';
     IF(ID_OBJ = 12) THEN
          resultado = '';
     IF(ID_OBJ = 13) THEN
          resultado = 'role';
     IF(ID_OBJ = 14) THEN
          resultado = 'generator (sequence)';
     IF(ID_OBJ = 15) THEN
          resultado = 'function';
     IF(ID_OBJ = 16) THEN
          resultado = 'BLOB filter';
     IF(ID_OBJ = 17) THEN
          resultado = 'collation';
     IF(ID_OBJ = 18) THEN
          resultado = 'package';
     IF(ID_OBJ < 0 OR ID_OBJ > 18)THEN
          EXCEPTION E_OFNI;
     
     RETURN resultado;
END^
COMMENT ON FUNCTION F_OBJECTOS IS 'Permite decodificar los identificadores numericos de los campos RDB$OBJECT_TYPE en la tabla RDB$USER_PRIVILEGES'^
SET TERM ;^

/* F_PRIVILEGIO */
SET TERM ^;
CREATE OR ALTER FUNCTION F_PRIVILEGIO (
	ABREV D_ABREVIATURA
) 
RETURNS D_VARCHAR_15
SQL SECURITY DEFINER
AS
DECLARE VARIABLE resultado D_VARCHAR_15; 
BEGIN
     resultado = '';
     
     ABREV = UPPER(:ABREV);
 
     IF(ABREV = 'S') THEN 
          resultado = 'SELECT';
          
     IF(ABREV = 'I') THEN
          resultado = 'INSERT';
          
     IF(ABREV = 'U') THEN
          resultado = 'UPDATE';
          
     IF(ABREV = 'D') THEN
          resultado = 'DELETE';
          
     IF(ABREV = 'G') THEN
          resultado = 'USAGE';
          
     IF(ABREV = 'M') THEN
          resultado = 'MEMBERSHIP';
          
     IF(ABREV = 'X') THEN
          resultado = 'EXECUTE';
          
     IF(ABREV = 'R') THEN
          resultado = 'REFERENCES';
          
     IF(ABREV = '')THEN
          EXCEPTION E_OFNI;
          
     RETURN resultado;
END^
COMMENT ON FUNCTION F_PRIVILEGIO IS 'Permite decodificar las abreviatura de los campos RDB$PRIVILEGE en la tabla RDB$USER_PRIVILEGES'^
SET TERM ;^

/* F_PROCEDIMIENTOS_SHOW */
SET TERM ^;
CREATE OR ALTER FUNCTION F_PROCEDIMIENTOS_SHOW (
	SUFIJO D_VARCHAR_15
) 
RETURNS D_BOOLEAN_T
SQL SECURITY DEFINER
AS
BEGIN
     
     IF(SUFIJO = 'ADMIN') THEN
          RETURN TRUE;
          
     IF(SUFIJO = 'SP_') THEN
          RETURN TRUE;
          
     IF(SUFIJO = 'RP_') THEN
          RETURN TRUE;
          
     IF(SUFIJO = '') THEN
          RETURN TRUE;
          
     RETURN FALSE;
     
END^
SET TERM ;^

/* F_TIPO_USUARIO */
SET TERM ^;
CREATE OR ALTER FUNCTION F_TIPO_USUARIO (
	ID_TIPO D_ID
) 
RETURNS D_VARCHAR_45
SQL SECURITY DEFINER
AS
DECLARE VARIABLE resultado D_VARCHAR_45; 
BEGIN
     resultado = '';
     
     IF(ID_TIPO = 8) THEN
          resultado = 'USUARIO';
          
     IF(ID_TIPO = 13) THEN
          resultado = 'ROLE';
     
     IF(ID_TIPO = 20)THEN
          resultado = 'OTRO';
          
     IF(resultado = '')THEN
          EXCEPTION E_OFNI;
          
     RETURN resultado;
END^
SET TERM ;^

/* ----- Creating Procedures ----- */

/* ACTUALIZAR_ESTADISTICAS_INDICES */
SET TERM ^;
CREATE OR ALTER PROCEDURE ACTUALIZAR_ESTADISTICAS_INDICES
SQL SECURITY DEFINER
AS
DECLARE VARIABLE o_index_name D_VARCHAR_70;
BEGIN
 
     FOR SELECT RDB$INDEX_NAME
          FROM RDB$INDICES 
          INTO :o_index_name DO 
               EXECUTE STATEMENT 'SET STATISTICS INDEX ' || :o_index_name || ';' ;
END^
SET TERM ;^

/* PARSER */
SET TERM ^;
CREATE OR ALTER PROCEDURE PARSER (
	TCTEXTO D_BLOB_TEXTO,
	TCSEPARADOR D_VARCHAR_15
) 
RETURNS (
	FTCNOMBRE D_VARCHAR_1024
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE lnPosicion D_EDAD;
BEGIN
 
   lnPosicion = Position(tcSeparador IN tcTexto);
 
   ftcNombre = Left(tcTexto, lnPosicion - 1) ;
   SUSPEND;
 
END^
COMMENT ON PROCEDURE PARSER IS 'Su misión es extraer un subtexto dentro de un texto.'^
SET TERM ;^

/* ACTUALIZAR_TABLA_PIVOT */
SET TERM ^;
CREATE OR ALTER PROCEDURE ACTUALIZAR_TABLA_PIVOT (
	TCTABLAPIVOT VARCHAR(28),
	TCVISTA VARCHAR(28),
	TCPRIMERACOLUMNACABECERA VARCHAR(64),
	TCOTRASCOLUMNASCABECERA VARCHAR(4096),
	TCCOLUMNADATOS VARCHAR(28),
	TCVALORESDATOS VARCHAR(1024)
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE lcOtrasColumnasCabecera VARCHAR(4096);
DECLARE VARIABLE lcSelect VARCHAR(4096);
DECLARE VARIABLE lcColumna VARCHAR(28);
DECLARE VARIABLE lcGrupo VARCHAR(4096);
DECLARE VARIABLE lcInto1 VARCHAR(1024);
DECLARE VARIABLE lcInto2 VARCHAR(1024);
DECLARE VARIABLE lcInto3 VARCHAR(1024);
DECLARE VARIABLE lcActualizar VARCHAR(1024);
DECLARE VARIABLE lcTipoDatos VARCHAR(64);
BEGIN
   
   lcOtrasColumnasCabecera = tcOtrasColumnasCabecera;
   
   lcSelect = 'SELECT ' ||
              Left(tcPrimeraColumnaCabecera, Position(' ', tcPrimeraColumnaCabecera) - 1) || ', ' ;
   
   lcGrupo  = Left(tcPrimeraColumnaCabecera, Position(' ', tcPrimeraColumnaCabecera) - 1) || ', ' ;
   
   IF (Char_Length(lcOtrasColumnasCabecera) > 0) THEN BEGIN
     lcOtrasColumnasCabecera = lcOtrasColumnasCabecera || ',' ;
     WHILE (Char_Length(lcOtrasColumnasCabecera) > 0) DO BEGIN
        EXECUTE PROCEDURE Parser(lcOtrasColumnasCabecera, ',') RETURNING_VALUES :lcColumna;
        lcGrupo  = lcGrupo  || Left(lcColumna, Position(' ', lcColumna) - 1) || ',' ;
        lcOtrasColumnasCabecera = Replace(lcOtrasColumnasCabecera, lcColumna || ',', '') ;
     END
   END
   
   lcSelect = lcSelect || 
              tcColumnaDatos || ', ' ||
              tcValoresDatos ||
              ' FROM ' || tcVista || 
              ' GROUP BY ' || lcGrupo || 
              tcColumnaDatos ;
   
   FOR EXECUTE STATEMENT
      lcSelect 
   INTO 
      :lcInto1, 
      :lcInto2,
      :lcInto3
   DO BEGIN
      -- Aquí se insertan o actualizan la primera columna y los datos agrupados
      lcTipoDatos = SUBSTRING(tcPrimeraColumnaCabecera FROM Position(' ', tcPrimeraColumnaCabecera));
      lcTipoDatos = Upper(Trim(lcTipoDatos));
      IF (lcTipoDatos CONTAINING 'CHAR') THEN
         lcInto1 = '''' || lcInto1 || '''';
      lcInto2 = Left(lcInto2, 28);
      lcInto2 = Replace(lcInto2, ' ', '_');
      lcInto2 = Replace(lcInto2, '.', '_');
      lcInto2 = Replace(lcInto2, '/', '_');
      lcInto2 = Replace(lcInto2, '%', '_');
      lcActualizar = 'UPDATE OR INSERT INTO ' || 
                     tcTablaPivot || ' (' || 
                     Left(tcPrimeraColumnaCabecera, Position(' ', tcPrimeraColumnaCabecera) - 1) || ',' ||
                     lcInto2 || 
                     ') VALUES(' ||
                     lcInto1 || ',' ||
                     lcInto3 || ')' ;
      EXECUTE STATEMENT lcActualizar;
      IF (Char_Length(Trim(tcOtrasColumnasCabecera)) > 0) THEN BEGIN
        lcOtrasColumnasCabecera = tcOtrasColumnasCabecera || ',' ;
        lcActualizar = 'UPDATE ' || tcTablaPivot || ' SET ' ;
         WHILE (Char_Length(lcOtrasColumnasCabecera) > 0) DO BEGIN
            -- Aquí se actualizan todas las demás columnas de la cabecera
            EXECUTE PROCEDURE Parser(lcOtrasColumnasCabecera, ',') RETURNING_VALUES :lcColumna;
            lcActualizar = lcActualizar ||
                           Left(lcColumna, Position(' ', lcColumna) - 1) ||
                           ' = (SELECT ' || Left(lcColumna, Position(' ', lcColumna) - 1) || 
                           ' FROM ' || tcVista || 
                           ' WHERE ' ||
                           Left(tcPrimeraColumnaCabecera, Position(' ', tcPrimeraColumnaCabecera) - 1) || 
                           '=' || lcInto1 || 
                           ' ROWS 1),' ;
           lcOtrasColumnasCabecera = Replace(lcOtrasColumnasCabecera, lcColumna || ',', '') ;
         END
         lcActualizar = Left(lcActualizar, Char_Length(lcActualizar) - 1) ||
                        ' WHERE ' || 
                        Left(tcPrimeraColumnaCabecera, Position(' ', tcPrimeraColumnaCabecera) - 1) || '=' ||
                        lcInto1;
         EXECUTE STATEMENT lcActualizar;
      END
   END
   
END^
COMMENT ON PROCEDURE ACTUALIZAR_TABLA_PIVOT IS 'Este procedimiento en Firebird parece estar diseñado para actualizar una tabla pivot en función de los datos de una vista y algunas otras columnas especificadas. Aquí está el desglose de lo que hace:

1. **Declaración de Variables**: Comienza declarando varias variables que se utilizarán en el procedimiento.

2. **Construcción de Consulta SELECT**: El procedimiento construye una consulta SELECT dinámica utilizando los parámetros de entrada, 
	como `TCVISTA`, `TCPRIMERACOLUMNACABECERA`, `TCOTRASCOLUMNASCABECERA`, `TCCOLUMNADATOS`, y `TCVALORESDATOS`. La consulta se construye para agrupar datos en función de las columnas especificadas.

3. **Ejecución de la Consulta SELECT**: Luego, se ejecuta la consulta SELECT construida y los resultados se almacenan en las variables `lcInto1`, `lcInto2`, y `lcInto3`.

4. **Actualización o Inserción de Datos en la Tabla Pivot**: Se realiza una serie de manipulaciones en las variables y se construye una consulta de actualización o inserción (`UPDATE OR INSERT`) 
	en la tabla pivot (`tcTablaPivot`). Esto se hace en función de los resultados de la consulta SELECT. Los datos de la columna de la cabecera se tratan de acuerdo con su tipo de datos y se reemplazan 
	algunos caracteres especiales en el nombre de la columna.

5. **Actualización de Otras Columnas de la Cabecera**: Si `tcOtrasColumnasCabecera` contiene datos adicionales, el procedimiento también actualiza estas columnas en la tabla pivot. Para cada columna adicional, 
	se ejecuta una subconsulta para obtener el valor correspondiente de la vista y se actualiza en la tabla pivot.

6. **Concesión de Permiso**: Finalmente, se otorgan permisos de ejecución en el procedimiento a los roles `RDB$ADMIN` y `SYSDBA` con la opción de otorgar permisos.

En resumen, este procedimiento se utiliza para mantener actualizada una tabla pivot en función de los datos de una vista y otras columnas especificadas. Realiza operaciones de inserción y actualización en la 
	tabla pivot según los resultados de la consulta SELECT. También permite otorgar permisos de ejecución a roles específicos.'^
SET TERM ;^

/* ADMIN_AGREGAR_PERMISO_ADMIN_PROCE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_AGREGAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
                            ..........ROLE UTILIZADO..........
        Clase: Permiso
        Metodo: agregarPermisoAdminProcedimiento(String procedimiento, String rol) 
        
        NOTAS:
            1) Validar si el procedimiento y el rol existen.
            2) Se podria validar que no este en uso?
     */
     EXECUTE STATEMENT 'GRANT EXECUTE ON PROCEDURE '||:i_nombreProcedimiento||' TO '||:i_nombreRol||' WITH GRANT OPTION;';
END^
COMMENT ON PROCEDURE ADMIN_AGREGAR_PERMISO_ADMIN_PROCE IS 'Este es un SP que permite agregar el permiso de administracion a los SP.'^
SET TERM ;^

/* ADMIN_AGREGAR_PERMISO_ADMIN_ROLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_AGREGAR_PERMISO_ADMIN_ROLE (
	I_ROLE D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     EXECUTE STATEMENT 'GRANT '||:i_role||' TO '||:i_usuario||' WITH ADMIN OPTION';
END^
SET TERM ;^

/* ADMIN_ALTER_ROLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_ALTER_ROLE (
	I_NOMBRE_ACTUAL D_VARCHAR_70,
	I_NOMBRE_NUEVO D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE privilegio TYPE OF COLUMN VS_PRIVILEGIO.NOMBRE_ABREV;
DECLARE VARIABLE object_name D_VARCHAR_70;
DECLARE VARIABLE grant_opcion TYPE OF COLUMN RDB$USER_PRIVILEGES.RDB$GRANT_OPTION;
DECLARE VARIABLE miembro D_VARCHAR_70;
BEGIN
     /* Paso 1: Crear un nuevo rol con el nuevo nombre */
     EXECUTE STATEMENT 'CREATE ROLE ' || :I_NOMBRE_NUEVO;
     
     /* Paso 2: Transferir los privilegios del rol original al nuevo rol */
     FOR SELECT 
          r.NOMBRE_ABREV, 
          r.GRANT_OPTION, 
          r.NOMBRE_RELACION
     FROM VS_PRIVILEGIO r
     WHERE TRIM(r.USUARIO) STARTING WITH :I_NOMBRE_ACTUAL
     INTO :privilegio, :object_name, :grant_opcion
     DO
     BEGIN
          IF(:privilegio = 'MEMBERSHIP') THEN BEGIN
                EXECUTE STATEMENT 'GRANT ' || :privilegio || ' ON ' || :object_name || ' TO ' || :I_NOMBRE_NUEVO || 
                IIF(:grant_opcion <> 0, ' WITH GRANT OPTION;', ';');
          END
          IF(:privilegio = 'EXECUTE') THEN BEGIN
                EXECUTE STATEMENT 'GRANT ' || :privilegio || ' ON PROCEDURE ' || :object_name || ' TO ' || :I_NOMBRE_NUEVO || 
                IIF(:grant_opcion <> 0, ' WITH GRANT OPTION;', ';');
          END
     END

     /* Paso 3: Transferir miembros de rol */
     FOR SELECT 
          r.USUARIO, 
          r.GRANT_OPTION
     FROM VS_PRIVILEGIO r
     WHERE r.NOMBRE_RELACION STARTING WITH :I_NOMBRE_ACTUAL
     INTO :miembro, :grant_opcion
     DO BEGIN
          EXECUTE STATEMENT 'GRANT ' || :I_NOMBRE_NUEVO || ' TO ' || :miembro ||IIF(:grant_opcion <> 0,' WITH ADMIN OPTION;',';');
     END

     /* Paso 4: Opcionalmente, eliminar el rol original */
     EXECUTE STATEMENT 'DROP ROLE ' || :I_NOMBRE_ACTUAL;
END^
COMMENT ON PROCEDURE ADMIN_ALTER_ROLE IS '/**
* SP que permite a los administradores modificar los nombres de los roles y
* pasar los permisos y asignaciones de los roles al nuevo rol creado.
* 
* @param actual recibe el nombre de un rol existente. 
* @param nuevo recibe el nuevo nombre del rol a crear. 
* 
* @return devuelve un objecto Resultados para obtener informacion de la op.
*/'^
SET TERM ;^

/* ADMIN_BORRAR_PERMISO_ADMIN_PROCE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_BORRAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
          Validar si el procedimiento y el rol existen. Se podria validar que no este en uso.
     */
     EXECUTE STATEMENT 'REVOKE EXECUTE ON PROCEDURE '||:i_nombreProcedimiento||' FROM '||:i_nombreRol||';';
END^
COMMENT ON PROCEDURE ADMIN_BORRAR_PERMISO_ADMIN_PROCE IS 'Este es un SP que permite BORRAR el permiso de SP al rol.'^
SET TERM ;^

/* ADMIN_BORRAR_ROLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_BORRAR_ROLE (
	I_ROLE D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN

     /*
                        _____UTILIZADO____
        Clase: Roles
        Metodo: dropRole(String i_role)
     Deberia validarse que no exista usuario conectado usando este rol.
     */
     EXECUTE STATEMENT 'DROP ROLE '||:i_role;
END^
SET TERM ;^

/* ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL (
	I_USUARIO D_USER_NAME,
	I_CLAVE D_CLAVE
) 
SQL SECURITY DEFINER
AS
BEGIN
    /*
        Este procedimiento deberia de leer cierta caracteristica que deberian 
        tener las claves y los nombres de usuarios. 
    */
     EXECUTE STATEMENT 'ALTER USER '||I_USUARIO||' PASSWORD '''||I_CLAVE||'''';
END^
COMMENT ON PROCEDURE ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL IS 'Este procedimiento es de uso publico, para que el usuario cambie su 
clave de acceso. Solo recibe la clave.'^
SET TERM ;^

/* ADMIN_CONSULTA_PERMISOS */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CONSULTA_PERMISOS
RETURNS (
	USER_MANAGEMENT D_BOOLEAN_F,
	READ_RAW_PAGES D_BOOLEAN_F,
	CREATE_USER_TYPES D_BOOLEAN_F,
	USE_NBACKUP_UTILITY D_BOOLEAN_F,
	CHANGE_SHUTDOWN_MODE D_BOOLEAN_F,
	TRACE_ANY_ATTACHMENT D_BOOLEAN_F,
	MONITOR_ANY_ATTACHMENT D_BOOLEAN_F,
	ACCESS_SHUTDOWN_DATABASE D_BOOLEAN_F,
	CREATE_DATABASE D_BOOLEAN_F,
	DROP_DATABASE D_BOOLEAN_F,
	USE_GBAK_UTILITY D_BOOLEAN_F,
	USE_GSTAT_UTILITY D_BOOLEAN_F,
	USE_GFIX_UTILITY D_BOOLEAN_F,
	IGNORE_DB_TRIGGERS D_BOOLEAN_F,
	CHANGE_HEADER_SETTINGS D_BOOLEAN_F,
	SELECT_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	ACCESS_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	MODIFY_ANY_OBJECT_IN_DATABASE D_BOOLEAN_F,
	CHANGE_MAPPING_RULES D_BOOLEAN_F,
	USE_GRANTED_BY_CLAUSE D_BOOLEAN_F,
	GRANT_REVOKE_ON_ANY_OBJECT D_BOOLEAN_F,
	GRANT_REVOKE_ANY_DDL_RIGHT D_BOOLEAN_F,
	CREATE_PRIVILEGED_ROLES D_BOOLEAN_F,
	GET_DBCRYPT_INFO D_BOOLEAN_F,
	MODIFY_EXT_CONN_POOL D_BOOLEAN_F,
	REPLICATE_INTO_DATABASE D_BOOLEAN_F,
	PROFILE_ANY D_BOOLEAN_F
)
SQL SECURITY DEFINER
AS
BEGIN
    USER_MANAGEMENT = (select rdb$system_privilege(USER_MANAGEMENT) from RDB$DATABASE);
    READ_RAW_PAGES = (select rdb$system_privilege(READ_RAW_PAGES) from RDB$DATABASE);
    CREATE_USER_TYPES = (select rdb$system_privilege(CREATE_USER_TYPES) from RDB$DATABASE);
    USE_NBACKUP_UTILITY = (select rdb$system_privilege(USE_NBACKUP_UTILITY) from RDB$DATABASE);
    CHANGE_SHUTDOWN_MODE = (select rdb$system_privilege(CHANGE_SHUTDOWN_MODE) from RDB$DATABASE);
    TRACE_ANY_ATTACHMENT = (select rdb$system_privilege(TRACE_ANY_ATTACHMENT) from RDB$DATABASE);
    MONITOR_ANY_ATTACHMENT = (select rdb$system_privilege(MONITOR_ANY_ATTACHMENT) from RDB$DATABASE);
    ACCESS_SHUTDOWN_DATABASE = (select rdb$system_privilege(ACCESS_SHUTDOWN_DATABASE) from RDB$DATABASE);
    CREATE_DATABASE = (select rdb$system_privilege(CREATE_DATABASE) from RDB$DATABASE);
    DROP_DATABASE = (select rdb$system_privilege(DROP_DATABASE) from RDB$DATABASE);
    USE_GBAK_UTILITY = (select rdb$system_privilege(USE_GBAK_UTILITY) from RDB$DATABASE);
    USE_GSTAT_UTILITY = (select rdb$system_privilege(USE_GSTAT_UTILITY) from RDB$DATABASE);
    USE_GFIX_UTILITY = (select rdb$system_privilege(USE_GFIX_UTILITY) from RDB$DATABASE);
    IGNORE_DB_TRIGGERS = (select rdb$system_privilege(IGNORE_DB_TRIGGERS) from RDB$DATABASE);
    CHANGE_HEADER_SETTINGS = (select rdb$system_privilege(CHANGE_HEADER_SETTINGS) from RDB$DATABASE);
    SELECT_ANY_OBJECT_IN_DATABASE = (select rdb$system_privilege(SELECT_ANY_OBJECT_IN_DATABASE) from RDB$DATABASE);
    ACCESS_ANY_OBJECT_IN_DATABASE = (select rdb$system_privilege(ACCESS_ANY_OBJECT_IN_DATABASE) from RDB$DATABASE);
    MODIFY_ANY_OBJECT_IN_DATABASE = (select rdb$system_privilege(MODIFY_ANY_OBJECT_IN_DATABASE) from RDB$DATABASE);
    CHANGE_MAPPING_RULES = (select rdb$system_privilege(CHANGE_MAPPING_RULES) from RDB$DATABASE);
    USE_GRANTED_BY_CLAUSE = (select rdb$system_privilege(USE_GRANTED_BY_CLAUSE) from RDB$DATABASE);
    GRANT_REVOKE_ON_ANY_OBJECT = (select rdb$system_privilege(GRANT_REVOKE_ON_ANY_OBJECT) from RDB$DATABASE);
    GRANT_REVOKE_ANY_DDL_RIGHT = (select rdb$system_privilege(GRANT_REVOKE_ANY_DDL_RIGHT) from RDB$DATABASE);
    CREATE_PRIVILEGED_ROLES = (select rdb$system_privilege(CREATE_PRIVILEGED_ROLES) from RDB$DATABASE);
    GET_DBCRYPT_INFO = (select rdb$system_privilege(GET_DBCRYPT_INFO) from RDB$DATABASE);
    MODIFY_EXT_CONN_POOL = (select rdb$system_privilege(MODIFY_EXT_CONN_POOL) from RDB$DATABASE);
    REPLICATE_INTO_DATABASE = (select rdb$system_privilege(REPLICATE_INTO_DATABASE) from RDB$DATABASE);
    PROFILE_ANY = (select rdb$system_privilege(PROFILE_ANY_ATTACHMENT) from RDB$DATABASE);
    SUSPEND;
END^
SET TERM ;^

/* ADMIN_CREATE_ROLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_CREATE_ROLE (
	I_ROLE D_ROL
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
          Podriamos validar si el ROLE ya se encuentra registrado
     para enviar un excepcion.
     */
     EXECUTE STATEMENT 'CREATE ROLE R_'||:I_ROLE; 
END^
COMMENT ON PROCEDURE ADMIN_CREATE_ROLE IS 'Permitir al usuario crear roles en el sistema.'^
SET TERM ;^

/* ADMIN_DAR_ROL_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_DAR_ROL_USUARIO (
	I_ROL D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70,
	I_ADMIN D_BOOLEAN_F
) 
SQL SECURITY DEFINER
AS
BEGIN
    --Si el ROLE esta vacio, pasa a obtener el ROLE del usuario actual.
     IF(:i_rol = '')THEN
        i_rol = CURRENT_ROLE;
     
     IF(:i_rol = 'ADMINISTRADOR')THEN
        i_rol = 'RDB$ADMIN';
        
     --Si el usuario esta vacio, pasa a ser el usuario actual.
     IF(:i_usuario = '')THEN
         i_usuario= CURRENT_USER;
    
     /*Deberia validarse el usuario y el rol que exista.*/
     EXECUTE STATEMENT 'GRANT '|| UPPER(:i_rol) ||' TO '|| UPPER(:i_usuario) ||IIF(i_admin,' WITH ADMIN OPTION;','');
END^
SET TERM ;^

/* ADMIN_GET_ID_FACTURA_NUEVA */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_GET_ID_FACTURA_NUEVA (
	ID_TURNO TYPE OF COLUMN TURNOS.ID
) 
RETURNS (
	ID_FACTURA TYPE OF COLUMN V_M_FACTURAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Verificamos que el turno no este cerrado.
    IF(NOT EXISTS(SELECT 1 FROM V_TURNOS t WHERE t.ID = :ID_TURNO))THEN BEGIN
        ID_FACTURA = -1;
        SUSPEND;
        EXCEPTION E_TURNO_NO_EXISTE;
    END
        
    --Verificamos que el turno no este cerrado.
    IF(EXISTS(SELECT 1 FROM V_TURNOS t WHERE t.ID = :ID_TURNO AND t.ESTADO IS FALSE))THEN
        EXCEPTION E_TURNO_CERRADO;
    
    --Consultamos si la factura está creada.
    ID_FACTURA = (SELECT ID 
                    FROM V_M_FACTURAS f 
                    WHERE f.ID_TURNO = :ID_TURNO AND 
                    f.ESTADO_FACTURA = 'i'
                );
    --En caso de que exista una factura suspendemos.
    IF(ID_FACTURA IS NOT NULL ) THEN BEGIN
        SUSPEND;
    END ELSE BEGIN 
        --En caso contrario creamos una factura nueva.
        INSERT INTO V_M_FACTURAS (
                ID,
                ID_TURNO
                )
        VALUES (NULL, :ID_TURNO )
        RETURNING ID
        INTO ID_FACTURA;
        
        SUSPEND;
    END

END^
SET TERM ;^

/* ADMIN_QUITAR_PERMISO_ADMIN_PROCE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_PROCE (
	I_NOMBREPROCEDIMIENTO D_VARCHAR_70,
	I_NOMBREROL D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*Validar si el procedimiento y el rol existen. Se podria validar que no este en uso.*/
     EXECUTE STATEMENT 'REVOKE GRANT OPTION FOR EXECUTE ON PROCEDURE '||:i_nombreProcedimiento||' FROM '||:i_nombreRol||';';
END^
COMMENT ON PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_PROCE IS 'Este es un SP que permite quitar el permiso de administracion a los SP.'^
SET TERM ;^

/* ADMIN_QUITAR_PERMISO_ADMIN_ROL */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_ROL (
	I_ROLE D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*Pensar en las validaciones.*/
     EXECUTE STATEMENT 'REVOKE ADMIN OPTION FOR '||:I_ROLE||' FROM '||:I_USUARIO;
END^
SET TERM ;^

/* ADMIN_QUITAR_ROL_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_ROL_USUARIO (
	I_ROL D_VARCHAR_70,
	I_USUARIO D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     EXECUTE STATEMENT 'REVOKE '||:I_ROL||' FROM '||:I_USUARIO;
END^
SET TERM ;^

/* ADMIN_QUITAR_ROLES_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_QUITAR_ROLES_USUARIO (
	USER_NAME TYPE OF COLUMN GET_ROL.USER_NAME
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ROL TYPE OF COLUMN GET_ROL.ROL;
BEGIN
     FOR SELECT r.ROL 
         FROM GET_ROL r 
         WHERE r.USER_NAME LIKE :USER_NAME 
         INTO ROL DO BEGIN
            EXECUTE PROCEDURE ADMIN_QUITAR_PERMISO_ADMIN_ROL (:ROL, :USER_NAME);
            EXECUTE PROCEDURE ADMIN_QUITAR_ROL_USUARIO (:ROL, :USER_NAME);
     END
END^
SET TERM ;^

/* ADMIN_SET_ROLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE ADMIN_SET_ROLE (
	I_ROLE D_VARCHAR_70
) 
SQL SECURITY DEFINER
AS
BEGIN
     --Validando que el Role sea del sistema y que la variable sea diferente de NONE.
     if(NOT EXISTS(SELECT 1
         FROM GET_ROLES 
         WHERE UPPER(rol) STARTING WITH UPPER(:i_role)) AND UPPER(:i_role) NOT STARTING WITH 'NONE')THEN
        EXCEPTION E_ROL_NO_ENCONTRADO USING (:I_ROLE); 
        
     EXECUTE STATEMENT 'SET ROLE '|| UPPER(:i_role);
END^
COMMENT ON PROCEDURE ADMIN_SET_ROLE IS '/**
* Este metodo nos permite establecer el rol que el usuario usará en el
* sistema, puede ser ejecutado una vez que el usuario haya iniciado
* session.
* 
* Es un procedimiento de uso publico, ya que todos van a cambiar su rol en 
* el sistema.
*
* @param i_role Nombre del rol que va a establecerse al usuario que ejecute
* el metodo.
* @return
*/'^
SET TERM ;^

/* CREAR_TABLA_PIVOT */
SET TERM ^;
CREATE OR ALTER PROCEDURE CREAR_TABLA_PIVOT (
	TCNOMBRETABLA VARCHAR(28),
	TCVISTA VARCHAR(28),
	TCPRIMERACOLUMNACABECERA VARCHAR(64),
	TCOTRASCOLUMNASCABECERA VARCHAR(4096),
	TCCOLUMNADATOS VARCHAR(28),
	TCTIPODATOS VARCHAR(64)
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE lcCreate VARCHAR(4096);
DECLARE VARIABLE lcColumna VARCHAR(28);
DECLARE VARIABLE lcMensajeError VARCHAR(1024);
BEGIN
   
   -- Primero, creamos la tabla
   
   lcCreate = 'CREATE TABLE ' || tcNombreTabla || ' (';
   
   lcCreate = lcCreate || tcPrimeraColumnaCabecera || ' NOT NULL, ';
   
   IF (Char_Length(tcOtrasColumnasCabecera) > 0) THEN BEGIN
      tcOtrasColumnasCabecera = tcOtrasColumnasCabecera || ',';
      WHILE (Char_Length(tcOtrasColumnasCabecera) > 0) DO BEGIN
         EXECUTE PROCEDURE Parser(tcOtrasColumnasCabecera, ',') RETURNING_VALUES :lcColumna;
         lcCreate = lcCreate || Trim(lcColumna) || ' , ' ;
         tcOtrasColumnasCabecera = Replace(tcOtrasColumnasCabecera, lcColumna || ',', '');
      END
   END
   
   FOR EXECUTE STATEMENT
      'SELECT DISTINCT ' || tcColumnaDatos || ' FROM ' || tcVista
   INTO 
      :lcColumna 
   DO BEGIN
      lcColumna = Left(lcColumna, 28);
      lcColumna = Replace(lcColumna, ' ', '_');
      lcColumna = Replace(lcColumna, '.', '_');
      lcColumna = Replace(lcColumna, '/', '_');
      lcColumna = Replace(lcColumna, '%', '_');
      lcCreate  = lcCreate || lcColumna || ' ' || tcTipoDatos || ', ' ;
   END
   
   lcCreate = Left(lcCreate, Char_Length(lcCreate) - 2);
   
   lcCreate = lcCreate || ');';
   
   EXECUTE STATEMENT lcCreate;
   
   -- Segundo, le agregamos una Primary Key
   
   EXECUTE STATEMENT 
      'ALTER TABLE ' || tcNombreTabla || 
      ' ADD CONSTRAINT PK_' || tcNombreTabla || 
      ' PRIMARY KEY (' || Left(:tcPrimeraColumnaCabecera, Position(' ', :tcPrimeraColumnaCabecera)) || ')';
   
END^
SET TERM ;^

/* HALLAR_PALABRAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE HALLAR_PALABRAS (
	FTCTEXTO D_BLOB_TEXTO
) 
RETURNS (
	FTCPALABRA D_VARCHAR_45
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE lnI D_ID;
DECLARE VARIABLE lnInicio D_ID;
DECLARE VARIABLE lnLongitud D_ID;
BEGIN
 
   lnI        = 1;
   lnInicio   = 1;
   ftcTexto   = ftcTexto || ' ';
   lnLongitud = CHARACTER_LENGTH(ftcTexto);
 
   WHILE (lnI <= lnLongitud) DO BEGIN
      IF(CAST(SUBSTRING(ftcTexto FROM lnI FOR 1) AS D_VARCHAR_45) NOT SIMILAR TO '[[:ALNUM:]]' AND 
            POSITION(SUBSTRING(ftcTexto FROM lnI FOR 1) IN 'áéíóúñÁÉÍÓÚÑ') = 0 ) THEN BEGIN
         IF(lnI > lnInicio) THEN BEGIN
            ftcPalabra = SUBSTRING(ftcTexto FROM lnInicio FOR lnI - lnInicio);
            SUSPEND;
         END
         lnInicio = lnI + 1;
      END
      lnI = lnI + 1;
   END
END^
SET TERM ;^

/* PERM_BASICOS */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_BASICOS (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE V_SQL D_VARCHAR_MAX;
BEGIN
     IF(I_OTORGAR)THEN BEGIN
          --Vistas
          V_SQL = 'GRANT SELECT ON V_T_E_S_SYS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--1
          
          V_SQL = 'GRANT SELECT ON GET_ROL TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--2
          
          V_SQL = 'GRANT SELECT ON VS_PRIVILEGIO TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--3
          
          V_SQL = 'GRANT SELECT ON V_T_DISTRITOS_MUNICIPALES TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--4
          
          V_SQL = 'GRANT SELECT ON V_T_MUNICIPIOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--5
          
          V_SQL = 'GRANT SELECT ON V_T_PROVINCIAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--6
          
          
          --Procedimientos
          V_SQL = 'GRANT EXECUTE ON PROCEDURE ADMIN_SET_ROLE TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--7
          
          --Este mismo procedimiento
          V_SQL = 'GRANT EXECUTE ON PROCEDURE PERM_BASICOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;--8
          
     END ELSE BEGIN 
          --Vistas
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_T_E_S_SYS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--1
          
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON GET_ROL FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--2
          
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON VS_PRIVILEGIO FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--3
          
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_T_DISTRITOS_MUNICIPALES FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--4
          
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_T_MUNICIPIOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--5
          
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_T_PROVINCIAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--6
          
          --Procedimientos
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE ADMIN_SET_ROLE FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--7
          
          --Este mismo procedimiento
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE PERM_BASICOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;--8
     END
END^
COMMENT ON PROCEDURE PERM_BASICOS IS 'Aqui se colocan los permisos mas basicos de los usuarios del sistema. 

Asi tendremos un control de acceso mas ajustado, el cual nos evita 
usar el usuario PUBLIC.'^
SET TERM ;^

/* PERM_CREAR_FACTURAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_CREAR_FACTURAS (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE V_SQL D_VARCHAR_MAX;
BEGIN 
     IF(I_OTORGAR)THEN BEGIN 
          --Procedimientos
          V_SQL = 'GRANT EXECUTE ON PROCEDURE ADMIN_GET_ID_FACTURA_NUEVA TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          
          --Vistas
          V_SQL = 'GRANT SELECT ON V_PRODUCTOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_TURNOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_PERSONAS_CLIENTES TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_CATEGORIAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_M_FACTURAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_PRECIOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_TURNOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_M_FACTURAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_PERSONAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_GENERALES TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_FOTO_PRODUCTO TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'GRANT SELECT ON V_FOTO_CATEGORIA TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          
          
          --Procedimiento mismo
          V_SQL = 'GRANT EXECUTE ON PROCEDURE PERM_CREAR_FACTURAS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
     END ELSE BEGIN 
          --Procedimientos
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE ADMIN_GET_ID_FACTURA_NUEVA FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          
          --Vistas
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_PRODUCTOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_TURNOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_PERSONAS_CLIENTES FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_CATEGORIAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_M_FACTURAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_PRECIOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_TURNOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_M_FACTURAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_PERSONAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_GENERALES FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_FOTO_PRODUCTO FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON V_FOTO_CATEGORIA FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          
          --Procedimiento mismo
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE PERM_CREAR_FACTURAS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
     END
END^
COMMENT ON PROCEDURE PERM_CREAR_FACTURAS IS 'Permite a los usuarios del sistema crear facturas.'^
SET TERM ;^

/* PERM_PANEL_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE PERM_PANEL_USUARIO (
	I_ROL D_ROL,
	I_CON_ADMIN D_BOOLEAN_F,
	I_OTORGAR D_BOOLEAN_F
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE V_SQL D_VARCHAR_MAX;
BEGIN
     IF(I_OTORGAR)THEN BEGIN
          --Procedimientos
          --V_SQL = 'GRANT EXECUTE ON PROCEDURE <PROCEDIMIENTO> TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          --EXECUTE STATEMENT V_SQL;
          
          --Vistas
          V_SQL = 'GRANT SELECT ON GET_TURNOS TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
          
          --El propio procedimiento...
          V_SQL = 'GRANT EXECUTE ON PROCEDURE PERM_PANEL_USUARIO TO '||:I_ROL||(IIF(:I_CON_ADMIN,' WITH GRANT OPTION;', ';'));
          EXECUTE STATEMENT V_SQL;
     END ELSE BEGIN 
          --Procedimientos
          --V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE <PROCEDIMIENTO> FROM '||:I_ROL;
          --EXECUTE STATEMENT V_SQL;
          
          --Vistas
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' SELECT ON GET_TURNOS FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
          
          --El propio procedimiento...
          V_SQL = 'REVOKE '||(IIF(:I_CON_ADMIN,' GRANT OPTION FOR ', ''))||' EXECUTE ON PROCEDURE PERM_PANEL_USUARIO FROM '||:I_ROL;
          EXECUTE STATEMENT V_SQL;
     END
END^
SET TERM ;^

/* SP_D_D_MOTIVO_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_MOTIVO_CONSULTA (
	ID TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO Crear validaciones para eliminar un motivo de consulta.
    DELETE FROM V_D_MOTIVO_CONSULTA WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_PERSONA_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     DELETE FROM V_PERSONAS_ESTUDIANTES WHERE ID = :ID;
     POST_EVENT 'EVENT_PERSONA_ESTUDIANTE';
END^
SET TERM ;^

/* SP_D_PERSONA_PADRE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PADRE (
	ID TYPE OF COLUMN PERSONAS_PADRES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     
     DELETE FROM V_PERSONAS_PADRES WHERE ID = :ID;
     POST_EVENT 'EVENT_PADRE';
END^
SET TERM ;^

/* SP_D_TURNO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_TURNO (
	ID TYPE OF COLUMN TURNOS.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE v_estado TYPE OF COLUMN TURNOS.ESTADO;
BEGIN
    v_estado = (SELECT t.ESTADO FROM V_TURNOS t WHERE ID = :ID);

    IF(EXISTS(SELECT 1 FROM V_M_FACTURAS a WHERE a.ID_TURNO = :ID))THEN
        EXCEPTION E_EXISTEN_REGISTROS_M_FACTURAS;

    IF(EXISTS(SELECT 1 FROM V_ALMACENES_DISPONIBLE a WHERE a.ID_TURNO = :ID))THEN
        EXCEPTION E_EXISTEN_REGISTROS_ALMACEN_DISPONIBLE;

    IF(V_ESTADO IS FALSE AND TRIM(CURRENT_ROLE) NOT IN('RDB$ADMIN', 'R_ADMINISTRADOR'))THEN 
        EXCEPTION E_NO_ERES_ADMIN;


    DELETE FROM V_TURNOS WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_M_DEUDAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_DEUDAS (
	ID TYPE OF COLUMN M_DEUDAS.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE estado TYPE OF COLUMN M_DEUDAS.ESTADO;
BEGIN
    estado = (SELECT ESTADO FROM V_M_DEUDAS WHERE ID = :ID);
    
    IF(estado <> 'i')THEN 
        EXCEPTION E_DEUDA_ACTIVDA;
    
    DELETE FROM V_M_DEUDAS WHERE ID = :ID;
    POST_EVENT 'EVENT_M_DEUDA';
END^
SET TERM ;^

/* SP_D_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONSULTA (
	ID TYPE OF COLUMN CONSULTAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    /*
    TODO hacer las validaciones antes de eliminar un registro.

    Podria verificarse si el almacen se encuentra activo antes de eliminarlo. 
    */
    DELETE FROM V_CONSULTAS WHERE ID = :ID;
    POST_EVENT 'EVENT_CONSULTA';
END^
SET TERM ;^

/* SP_D_PERSONA_PROOVEDOR_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PROOVEDOR_ATR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
        
    DELETE FROM V_PERSONAS_PROVEEDORES_ATR WHERE ID = :ID;
    POST_EVENT 'PERSONAS_PROVEEDORES';
END^
SET TERM ;^

/* SP_D_HORARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HORARIO (
	ID TYPE OF COLUMN HORARIOS.ID
) 
AS
BEGIN
    DELETE FROM V_HORARIOS a WHERE a.ID = :ID;
    POST_EVENT 'EVENT_HORARIO';
END^
SET TERM ;^

/* SP_D_PERSONA_CLIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_CLIENTE (
	ID TYPE OF COLUMN PERSONAS_CLIENTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
     
     DELETE FROM V_PERSONAS_CLIENTES WHERE ID = :ID;
     POST_EVENT 'EVENT_CLIENTE';
END^
SET TERM ;^

/* SP_U_ANULAR_FACTURA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ANULAR_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     UPDATE V_M_FACTURAS 
     SET 
         ESTADO_FACTURA = 'n'
     WHERE
          ID            = :ID;
END^
SET TERM ;^

/* SP_D_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA (
	ID TYPE OF COLUMN PERSONAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN

     IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
     
     DELETE FROM V_PERSONAS WHERE ID = :ID;
     POST_EVENT 'EVENT_PERSONA';
END^
SET TERM ;^

/* SP_D_ANTECEDENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ANTECEDENTE (
	ID TYPE OF COLUMN ANTECEDENTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    

    DELETE FROM V_ANTECEDENTES WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_PERSONA_EMPLEADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN     
     DELETE FROM V_PERSONAS_EMPLEADOS WHERE ID = :ID;
     POST_EVENT 'EVENT_EMPLEADO';
END^
SET TERM ;^

/* SP_D_CONTROL_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTROL_CONSULTA (
	ID TYPE OF COLUMN CONTROL_CONSULTA.ID
) 
SQL SECURITY DEFINER
AS
BEGIN

    DELETE FROM V_CONTROL_CONSULTA WHERE ID = :ID;
    
    POST_EVENT 'EVENT_CONTROL_CONSULTA';
END^
SET TERM ;^

/* SP_D_GENERAL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_GENERAL (
	ID_PERSONA TYPE OF COLUMN GENERALES.ID_PERSONA
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID_PERSONA = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
    
    DELETE FROM V_GENERALES WHERE ID_PERSONA = :ID_PERSONA;
    POST_EVENT 'EVENT_GENERALES';
END^
SET TERM ;^

/* SP_D_D_FACTURA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_FACTURA (
	ID TYPE OF COLUMN D_FACTURAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_D_FACTURAS WHERE ID = :ID;
    POST_EVENT 'EVENT_D_FACTURAS';
END^
SET TERM ;^

/* SP_D_CONTACTO_TEL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_TEL (
	ID TYPE OF COLUMN CONTACTOS_TEL.ID
) 
SQL SECURITY DEFINER
AS
BEGIN

    IF(:ID <= 0)THEN
        EXCEPTION E_DELETE_GENERICO;
    
    DELETE FROM V_CONTACTOS_TEL WHERE ID = :ID;
    
    POST_EVENT 'EVENT_TELEFONO';
END^
SET TERM ;^

/* SP_D_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRODUCTO (
	I_ID_PRODUCTO TYPE OF COLUMN PRODUCTOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
          TODO
          
          Debe crearse validaciones antes de eliminar el producto.
          
          Un ejemplo de porque no eliminar producto.
          
          Cuando este tenga existencia en el inventario.
          Cuando el producto ya se encuentra facturado.
     */
     
     DELETE FROM V_PRODUCTOS p WHERE p.ID = :I_ID_PRODUCTO;
     POST_EVENT 'EVENT_PRODUCTO';
END^
SET TERM ;^

/* SP_D_PERSONA_EMPLEADO_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_EMPLEADO_ATR (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID
) 
SQL SECURITY DEFINER
AS
BEGIN     
     DELETE FROM V_PERSONAS_EMPLEADOS_ATR WHERE ID = :ID;
     POST_EVENT 'EVENT_EMPLEADO';
END^
SET TERM ;^

/* SP_D_PRECIOS_BY_ID_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRECIOS_BY_ID_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN V_PRODUCTOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     --TODO 17/11/2024 Deberian de tener privilegios de administrador para estos casos. 
     DELETE FROM V_PRECIOS p WHERE p.ID_PRODUCTO = :ID_PRODUCTO;
     
     POST_EVENT 'EVENT_PRECIO';
END^
SET TERM ;^

/* SP_D_D_ANALISIS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_ANALISIS (
	ID TYPE OF COLUMN D_ANALISIS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    /**TODO crear validaciones para eliminar un analisis del sistema. */
    
    DELETE FROM V_D_ANALISIS WHERE ID = :ID;
    POST_EVENT 'EVENT_D_ANALISIS';
END^
SET TERM ;^

/* SP_D_ARS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ARS (
	ID TYPE OF COLUMN ARS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    
    IF(EXISTS(SELECT ID FROM ASEGURADOS WHERE ID_ARS = :ID))THEN
        EXCEPTION E_EXISTEN_REGISTROS_ASEGURADOS USING(:ID);
    
    DELETE FROM V_ARS WHERE ID = :ID;
END^
COMMENT ON PROCEDURE SP_D_ARS IS 'Permite eliminar las ars del sistema.'^
SET TERM ;^

/* SP_D_PRECIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PRECIO (
	ID TYPE OF COLUMN PRECIOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO 17/11/2024 Deberian de tener privilegios de administrador para estos casos.

    IF(EXISTS(SELECT 1 FROM V_D_FACTURAS a WHERE a.ID_PRECIO = :ID) )THEN
        EXCEPTION E_EXISTEN_REGISTROS_D_FACTURA;

    DELETE FROM V_PRECIOS p WHERE p.ID = :ID;
    POST_EVENT 'EVENT_PRECIO';
END^
SET TERM ;^

/* SP_D_CARTON_BINGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CARTON_BINGO (
	I_ID TYPE OF COLUMN CARTONES_BINGO.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
          TODO 
          En este procedimiento debemos verificar si este registro no debe ser eliminado.
     */
     DELETE FROM V_CARTONES_BINGO a WHERE a.ID = :I_ID;
     POST_EVENT 'EVENT_CARTON_BINGO';
END^
SET TERM ;^

/* SP_D_PERSONA_PROOVEDOR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PROOVEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
        
    DELETE FROM V_PERSONAS_PROVEEDORES WHERE ID = :ID;
    POST_EVENT 'PERSONAS_PROVEEDORES';
END^
SET TERM ;^

/* SP_D_D_DEUDAS_PAGAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_DEUDAS_PAGAS (
	ID TYPE OF COLUMN D_DEUDAS_PAGAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_D_DEUDAS_PAGAS WHERE ID = :ID;
    POST_EVENT 'EVENT_D_DEUDAS_PAGAS';
END^
SET TERM ;^

/* SP_D_PERSONA_PACIENTE_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PACIENTE_ATR (
	ID TYPE OF COLUMN PERSONAS_PACIENTES_ATR.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_PERSONAS_PACIENTES_ATR WHERE ID = :ID;
    POST_EVENT 'EVENT_PERSONA_PACIENTE';
END^
SET TERM ;^

/* SP_D_CONTACTO_EMAIL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_EMAIL (
	ID TYPE OF COLUMN CONTACTOS_EMAIL.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID <= 0)THEN
        EXCEPTION E_DELETE_GENERICO;
    
    DELETE FROM V_CONTACTOS_EMAIL WHERE ID = :ID;    
    
    POST_EVENT 'EVENT_CORREO';
END^
SET TERM ;^

/* SP_D_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CATEGORIA (
	ID TYPE OF COLUMN CATEGORIAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    /*
    TODO Crear verificaciones de proceso de borrado de una categoria.
    */
    IF(:ID = 0)THEN
        EXCEPTION E_CATEGORIA_GENERICA;

    DELETE FROM V_CATEGORIAS WHERE ID = :ID;
    POST_EVENT 'EVENT_CATEGORIA';
END^
SET TERM ;^

/* SP_D_PERSONA_PACIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_PERSONAS_PACIENTES WHERE ID = :ID;
    POST_EVENT 'EVENT_PERSONA_PACIENTE';
END^
SET TERM ;^

/* SP_D_PERSONA_ESTUDIANTE_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_ESTUDIANTE_ATR (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     DELETE FROM V_PERSONAS_ESTUDIANTES_ATR WHERE ID = :ID;
     POST_EVENT 'EVENT_PERSONA_ESTUDIANTE';
END^
SET TERM ;^

/* SP_D_CONTACTO_DIRECCION */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONTACTO_DIRECCION (
	ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID <= 0)THEN
        EXCEPTION E_DELETE_GENERICO;
    
    DELETE FROM V_CONTACTOS_DIRECCIONES WHERE ID = :ID;
        
    POST_EVENT 'EVENT_DIRECCION';
END^
SET TERM ;^

/* SP_D_D_GUIA_VIGILANCIA_DESARROLLO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_D_GUIA_VIGILANCIA_DESARROLLO (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    /**
        TODO 10/12/2024 
        1) Debe validarse que el paciente este activo.
        2) Que la edad del paciente correspondar a la guia de vigilancia.
        3) entre otras cosas... 
    */
    DELETE FROM V_D_GUIA_VIGILANCIA_DESARROLLO 
    WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_METRICA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_METRICA (
	ID TYPE OF COLUMN METRICAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO 16/11/2024 Si una metrica tiene una consulta inactiva quiere decir que esta metrica no puede ser eliminada.
    DELETE FROM V_METRICAS WHERE ID = :ID;
    POST_EVENT 'EVENT_METRICA';
END^
SET TERM ;^

/* SP_D_PERSONA_CLIENTE_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_PERSONA_CLIENTE_ATR (
	ID TYPE OF COLUMN PERSONAS_CLIENTES_ATR.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
     
     DELETE FROM V_PERSONAS_CLIENTES_ATR WHERE ID = :ID;
     POST_EVENT 'EVENT_CLIENTE';
END^
SET TERM ;^

/* SP_D_M_FACTURA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ESTADO_FACTURA TYPE OF COLUMN M_FACTURAS.ESTADO_FACTURA;
BEGIN
    ESTADO_FACTURA = (
        SELECT f.ESTADO_FACTURA 
        FROM V_M_FACTURAS f
        WHERE f.ID = :ID
    );
    
    IF(LOWER(ESTADO_FACTURA) NOT IN('n', 'i')) THEN
        EXCEPTION E_FACTURA_NO_NULA_NI_INICIAL;
        
    IF(EXISTS(SELECT 1 
        FROM V_D_FACTURAS 
        WHERE ID_FACTURA = :ID))THEN
        EXCEPTION E_FACTURA_CONTIENE_DETALLE;
    
    IF((SELECT TRIM(CURRENT_ROLE)
        FROM RDB$DATABASE) NOT IN('RDB$ADMIN', 'R_ADMINISTRADOR') )THEN
        EXCEPTION E_NO_ERES_ADMIN;
    
    DELETE FROM V_M_FACTURAS WHERE ID = :ID;
    POST_EVENT 'EVENT_M_FACTURA';
END^
SET TERM ;^

/* SP_D_ASEGURADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ASEGURADO (
	ID TYPE OF COLUMN ASEGURADOS.ID_PERSONA
) 
SQL SECURITY DEFINER
AS
BEGIN

    IF(:ID <= 0)THEN
        EXCEPTION E_DELETE_GENERICO;

    DELETE FROM V_ASEGURADOS WHERE ID_PERSONA = :ID;
    POST_EVENT 'EVENT_ASEGURADO';
END^
SET TERM ;^

/* SP_D_ALMACEN */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALMACEN (
	ID TYPE OF COLUMN ALMACENES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_ALMACEN_GENERAL;
        
    IF(EXISTS(SELECT 1 
        FROM V_ALMACENES_DISPONIBLE 
        WHERE ID_ALMACEN = :ID))THEN 
        EXCEPTION E_EXISTEN_REGISTROS_ALMACEN_DISPONIBLE;
        
    IF(EXISTS(SELECT 1 
        FROM V_M_ENTRADA_PRODUCTOS
        WHERE ID_ALMACEN = :ID))THEN
        EXCEPTION E_EXISTEN_REGISTROS_M_ENTRADA_PRODUCTOS;

    DELETE FROM V_ALMACENES WHERE ID = :ID;

    POST_EVENT 'EVENT_ALMACEN';
END^
SET TERM ;^

/* SP_D_ALL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALL
SQL SECURITY DEFINER
AS
DECLARE VARIABLE v_id D_ID;
DECLARE VARIABLE ID D_ID;
DECLARE VARIABLE V_GENERADOR TYPE OF COLUMN RDB$GENERATORS.RDB$GENERATOR_NAME;
BEGIN
    
    
    ID = 0;
    IF(CURRENT_USER <> 'SYSDBA' AND CURRENT_ROLE <> 'RDB$ADMIN')THEN
        EXCEPTION E_USUARIO_NO_AUTORIZADO USING (CURRENT_USER);
        
    --ORDEN de las Facturas
    FOR SELECT ID FROM V_D_FACTURAS WHERE ID > :ID INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_D_FACTURA(:v_id);
    END
    
    FOR SELECT ID FROM V_M_FACTURAS WHERE ID > :ID INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_U_ANULAR_FACTURA (:v_id);
        EXECUTE PROCEDURE SP_D_M_FACTURA(:v_id);
    END
        
    FOR SELECT ID FROM V_TURNOS t WHERE ID > :ID INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_TURNO(:v_id);
    END
        
    --ORDEN EN CONSULTAs...
    
    FOR SELECT ID FROM V_ANTECEDENTES WHERE ID > :ID INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_ANTECEDENTE(:v_id);
    END
    
    
    FOR SELECT ID FROM V_METRICAS WHERE ID > :ID INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_METRICA(:v_id);
    END
    
    
    FOR SELECT ID FROM V_CONSULTAS WHERE ID > :ID+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CONSULTA(:v_id);
    END
    
    
    FOR SELECT ID FROM V_CONTROL_CONSULTA WHERE ID > :ID  INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CONTROL_CONSULTA(:v_id);
    END
    
        
    FOR SELECT ID FROM V_ALMACENES WHERE ID > :ID+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_ALMACEN(:v_id);
    END

    FOR SELECT ID_PERSONA FROM V_ASEGURADOS WHERE ID_PERSONA > :ID + 1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_ASEGURADO(:v_id);
    END
    
    FOR SELECT ID FROM V_ARS WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_ARS(:v_id);
    END
    
    FOR SELECT ID FROM V_CARTONES_BINGO WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CARTON_BINGO(:v_id);
    END
    
    FOR SELECT ID FROM V_CONTACTOS_DIRECCIONES WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CONTACTO_DIRECCION(:v_id);
    END
    
    FOR SELECT ID FROM V_CONTACTOS_EMAIL WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CONTACTO_EMAIL(:v_id);
    END
    
    FOR SELECT ID FROM V_CONTACTOS_TEL WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CONTACTO_TEL(:v_id);
    END
    
    FOR SELECT ID FROM V_D_ANALISIS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_D_ANALISIS(:v_id);
    END
    
    FOR SELECT ID FROM V_M_DEUDAS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_M_DEUDAS(:v_id);
    END
        
    FOR SELECT ID FROM V_D_DEUDAS_PAGAS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_D_DEUDAS_PAGAS(:v_id);
    END
    
    
    FOR SELECT ID FROM V_GENERALES WHERE ID_PERSONA > :id+1  INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_GENERAL(:v_id);
    END
    
    FOR SELECT ID FROM V_D_MOTIVO_CONSULTA  WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_D_MOTIVO_CONSULTA(:v_id);
    END
    
    
    
    --ORDEN EN PRODUCTOS
    FOR SELECT ID FROM V_PRODUCTOS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PRECIOS_BY_ID_PRODUCTO (:v_id);
        EXECUTE PROCEDURE SP_D_PRODUCTO(:v_id);
    END
    
    FOR SELECT ID FROM V_CATEGORIAS WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_CATEGORIA(:v_id);
    END
    
    
    FOR SELECT ID FROM V_D_GUIA_VIGILANCIA_DESARROLLO WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_D_GUIA_VIGILANCIA_DESARROLLO(:v_id);
    END
    
    --ORDEN Entidades de persona.
    FOR SELECT ID FROM V_PERSONAS_PACIENTES WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_PACIENTE(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_PACIENTES_ATR WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_PACIENTE_ATR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_ESTUDIANTES WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_ESTUDIANTE(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_ESTUDIANTES_ATR WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_ESTUDIANTE_ATR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_PROVEEDORES WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_PROOVEDOR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_PROVEEDORES_ATR WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_PROOVEDOR_ATR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_CLIENTES WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_CLIENTE(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_CLIENTES_ATR WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_CLIENTE_ATR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_EMPLEADOS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_EMPLEADO(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_EMPLEADOS_ATR WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_EMPLEADO_ATR(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS_PADRES WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA_PADRE(:v_id);
    END
    
    FOR SELECT ID FROM V_PERSONAS WHERE ID > :id+1 INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PERSONA(:v_id);
    END
    
    FOR SELECT ID FROM V_HORARIOS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_HORARIO(:v_id);
    END
    
    FOR SELECT ID FROM V_PRECIOS WHERE ID > :id INTO v_id DO BEGIN
        EXECUTE PROCEDURE SP_D_PRECIO(:v_id);
    END
    
    /*
    DELETE FROM V_D_ENTRADA_PRODUCTO;
    DELETE FROM V_D_RECETAS;
    DELETE FROM V_HUELLAS;
    DELETE FROM V_INSCRIPCIONES;
    DELETE FROM V_MENSAJES;
    DELETE FROM V_M_ANALISIS;
    DELETE FROM V_M_ENTRADA_PRODUCTOS;
    
    DELETE FROM V_RECETAS;
    DELETE FROM V_RELACION_PADRE_ESTUDIANTE;
    DELETE FROM V_RELACION_PADRE_PACIENTE;
    DELETE FROM V_SINTOMAS;
    DELETE FROM V_TANDAS;*/
    
    FOR SELECT RDB$GENERATOR_NAME FROM RDB$GENERATORS WHERE RDB$SYSTEM_FLAG = 0 INTO V_GENERADOR DO BEGIN 
        EXECUTE STATEMENT 'SET GENERATOR '||V_GENERADOR||' TO 0;';
    END
    
END^
SET TERM ;^

/* SP_D_ALMACEN_DISPONIBLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_ALMACEN_DISPONIBLE (
	ID TYPE OF COLUMN ALMACENES_DISPONIBLE.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE idTurno TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_TURNO;
DECLARE VARIABLE idAlmacen TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_ALMACEN;
BEGIN
    SELECT ID_TURNO, ID_ALMACEN
    FROM V_ALMACENES_DISPONIBLE
    WHERE ID = :ID
    INTO :idTurno, :idAlmacen;
    
    IF(EXISTS(SELECT ID  FROM V_TURNOS WHERE ID = :idTurno AND ESTADO IS FALSE))THEN
        EXCEPTION E_TURNO_CERRADO;
    
    DELETE FROM V_ALMACENES_DISPONIBLE WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_CARGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CARGO (
	ID TYPE OF COLUMN CARGOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
  DELETE FROM CARGOS a WHERE a.ID = :ID;
  POST_EVENT 'EVENT_CARGO';
END^
SET TERM ;^

/* SP_D_CONSULTA_BY_CONTROL_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_CONSULTA_BY_CONTROL_CONSULTA (
	ID_CONTROL_CONSULTA D_ID_DEFAULT_0
) 
SQL SECURITY DEFINER
AS
BEGIN 
END^
SET TERM ;^

/* SP_D_DEPARTAMENTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_DEPARTAMENTO (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID
) 
AS
BEGIN
    DELETE FROM V_DEPARTAMENTOS
    WHERE
        ID = :ID;
    POST_EVENT 'EVENT_DEPARTAMENTO';
END^
SET TERM ;^

/* SP_D_FOTO_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_CATEGORIA (
	ID TYPE OF COLUMN FOTO_CATEGORIA.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID_CATEGORIA TYPE OF COLUMN FOTO_CATEGORIA.ID_CATEGORIA;
DECLARE VARIABLE ESTADO TYPE OF COLUMN CATEGORIAS.ESTADO;
BEGIN
    
    ID_CATEGORIA = (SELECT ID_CATEGORIA FROM V_FOTO_CATEGORIA WHERE ID = :ID);
    
    ESTADO = (SELECT ESTADO FROM V_CATEGORIAS WHERE ID = :ID_CATEGORIA);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_CATEGORIAS_INACTIVA;
    
    DELETE FROM V_FOTO_CATEGORIA WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_FOTO_CATEGORIA_BY_ID_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_CATEGORIA_BY_ID_CATEGORIA (
	ID_CATEGORIA TYPE OF COLUMN FOTO_CATEGORIA.ID_CATEGORIA
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ESTADO TYPE OF COLUMN CATEGORIAS.ESTADO;
BEGIN
    
    ESTADO = (SELECT ESTADO FROM V_CATEGORIAS WHERE ID = :ID_CATEGORIA);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_CATEGORIAS_INACTIVA;
    
    DELETE FROM V_FOTO_CATEGORIA WHERE ID_CATEGORIA = :ID_CATEGORIA;
END^
SET TERM ;^

/* SP_D_FOTO_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PERSONA (
	ID TYPE OF COLUMN FOTO_PERSONA.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA;
DECLARE VARIABLE ESTADO TYPE OF COLUMN PERSONAS.ESTADO;
BEGIN
    
    ID_PERSONA = (SELECT ID_PERSONA FROM V_FOTO_PERSONA WHERE ID = :ID);
    
    ESTADO = (SELECT ESTADO FROM V_PERSONAS WHERE ID = :ID_PERSONA);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_PERSONA_INACTIVA;
    
    DELETE FROM V_FOTO_PERSONA WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_FOTO_PERSONA_BY_ID_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PERSONA_BY_ID_PERSONA (
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ESTADO TYPE OF COLUMN PERSONAS.ESTADO;
BEGIN
    
    ESTADO = (SELECT ESTADO FROM V_PERSONAS WHERE ID = :ID_PERSONA);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_PERSONA_INACTIVA;
    
    DELETE FROM V_FOTO_PERSONA WHERE ID_PERSONA = :ID_PERSONA;
END^
SET TERM ;^

/* SP_D_FOTO_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PRODUCTO (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO;
DECLARE VARIABLE ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO;
BEGIN
    
    ID_PRODUCTO = (SELECT ID_PRODUCTO FROM V_FOTO_PRODUCTO WHERE ID = :ID);
    
    ESTADO = (SELECT ESTADO FROM V_PRODUCTOS WHERE ID = :ID_PRODUCTO);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_PRODUCTO_INACTIVO;
    
    DELETE FROM V_FOTO_PRODUCTO WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_FOTO_PRODUCTO_BY_ID_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_FOTO_PRODUCTO_BY_ID_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO;
BEGIN
    
    ESTADO = (SELECT ESTADO FROM V_PRODUCTOS WHERE ID = :ID_PRODUCTO);
    
    IF(COALESCE(ESTADO, FALSE) IS FALSE)THEN
        EXCEPTION E_PRODUCTO_INACTIVO;
    
    DELETE FROM V_FOTO_PRODUCTO WHERE ID_PRODUCTO = :ID_PRODUCTO;
END^
SET TERM ;^

/* SP_D_HUELLA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HUELLA (
	ID TYPE OF COLUMN HUELLAS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_HUELLAS WHERE ID = :ID;
    POST_EVENT 'EVENT_HUELLA';
END^
SET TERM ;^

/* SP_D_HUELLA_ID_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_HUELLA_ID_PERSONA (
	ID_PERSONA TYPE OF COLUMN HUELLAS.ID_PERSONAL
) 
SQL SECURITY DEFINER
AS
BEGIN
    DELETE FROM V_HUELLAS WHERE ID_PERSONA = :ID_PERSONA;
    POST_EVENT 'EVENT_HUELLA';
END^
SET TERM ;^

/* SP_D_METRICA_BY_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_METRICA_BY_CONSULTA (
	ID_CONSULTA TYPE OF COLUMN METRICAS.ID_CONSULTA
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID TYPE OF COLUMN METRICAS.ID;
BEGIN

    --TODO 16/11/2024 Si una metrica tiene una consulta inactiva quiere decir que esta metrica no puede ser eliminada.
    
    
    FOR SELECT 
        ID
    FROM METRICAS
    WHERE ID_CONSULTA = :ID_CONSULTA
    INTO 
        ID
    DO
    BEGIN
        EXECUTE PROCEDURE SP_D_METRICA (:ID);
    END
    
END^
SET TERM ;^

/* SP_D_M_ENTRADA_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_M_ENTRADA_PRODUCTO (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(EXISTS(SELECT ID FROM V_D_ENTRADA_PRODUCTOS WHERE ID_M_ENTRADA_PRODUCTO = :ID))THEN
        EXCEPTION E_EXISTEN_REGISTROS_D_ENTRADA_PRODUCTO;
    
    DELETE FROM V_M_ENTRADA_PRODUCTOS WHERE ID = :ID;
END^
SET TERM ;^

/* SP_D_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_D_USUARIO (
	USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ROL TYPE OF COLUMN GET_ROL.ROL;
BEGIN
     /*
          A medida que se va desarrollando, se debe cuestionar
          ¿cuando un usuario no debe ser borrado?
     */
     IF((SELECT DISTINCT (1) 
          FROM V_TURNOS t 
          WHERE UPPER(TRIM(t.TURNO_USUARIO)) LIKE TRIM(:USER_NAME) AND 
          t.ESTADO ) = 1
        )THEN
           EXCEPTION E_CAJERO_TURNO_ACTIVO;
     
     EXECUTE STATEMENT 'DROP USER '||:USER_NAME;
     
     --Noticar evento de eliminacion de registro.
     POST_EVENT 'EVENT_USUARIO';
END^
COMMENT ON PROCEDURE SP_D_USUARIO IS 'Permite eliminar un usuario del sistema, pero antes de eliminarlo este realiza la siguientes comprobaciones:
        1) Verifica que el usuario no tenga un turno abierto.
        2) Ahora se eliminan los roles de los usuarios en el sistema cuando son eliminados.'^
SET TERM ;^

/* SP_I_ALMACEN */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ALMACEN (
	NOMBRE TYPE OF COLUMN ALMACENES.NOMBRE,
	UBICACION TYPE OF COLUMN ALMACENES.UBICACION,
	ESTADO TYPE OF COLUMN ALMACENES.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ALMACENES.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Se valida que no exista un nombre de almacen duplicado.
     IF((SELECT DISTINCT (1) 
            FROM V_ALMACENES 
            WHERE NOMBRE LIKE :NOMBRE) = 1)THEN
        EXCEPTION E_DUPLICADO_NOMBRE;
     
     --Se realiza la insercion del registro.
     INSERT INTO V_ALMACENES (ID, NOMBRE, UBICACION, ESTADO)
     VALUES (NULL, :NOMBRE, :UBICACION, :ESTADO)
     RETURNING ID
     INTO O_ID;
     
     POST_EVENT 'EVENT_ALMACEN';
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_ALMACENES_DISPONIBLE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ALMACENES_DISPONIBLE (
	ID_TURNO TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_TURNO,
	USER_NAME TYPE OF COLUMN ALMACENES_DISPONIBLE.USER_NAME,
	ID_ALMACEN TYPE OF COLUMN ALMACENES_DISPONIBLE.ID_ALMACEN
) 
RETURNS (
	ID TYPE OF COLUMN ALMACENES_DISPONIBLE.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    /*
        Validar lo siguiente:
            1) Que si turno es mayor que 0 debe tener estado activo.
            2) Que exista el usuario y que tenga el rol de cajero.
            3) Que el almacen exista y tenga el estado de activo y borrado falso.
    */
    --1
    IF(:ID_TURNO > 0)THEN BEGIN
        IF((SELECT 1 
        FROM V_TURNOS t 
        WHERE t.ID = :ID_TURNO AND 
              t.ESTADO IS FALSE) = 1)THEN BEGIN
                EXCEPTION E_TURNO_CERRADO;
        END
    END
    
    --2
    IF((SELECT 1 
        FROM GET_CAJEROS c
        WHERE TRIM(c.USER_NAME) LIKE TRIM(:USER_NAME)) IS NULL)THEN
            EXCEPTION E_CAJERO_NO_REGISTRADO;
    
    --3
    IF((SELECT 1 
        FROM V_ALMACENES a 
        WHERE a.ID = :ID_ALMACEN AND 
                a.ESTADO IS FALSE) = 1)THEN
                EXCEPTION E_ALMACEN_INACTIVO;
                
    IF((SELECT 1 
        FROM V_ALMACENES a 
        WHERE a.ID = :ID_ALMACEN AND 
                a.BORRADO) = 1)THEN
                EXCEPTION E_ALMACEN_NO_EXISTE;
    
    INSERT INTO V_ALMACENES_DISPONIBLE (ID, ID_TURNO, USER_NAME, ID_ALMACEN)
    VALUES (NULL, :ID_TURNO, :USER_NAME, :ID_ALMACEN);
END^
SET TERM ;^

/* SP_I_ANTECEDENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ANTECEDENTE (
	ID_CONSULTA TYPE OF COLUMN ANTECEDENTES.ID_CONSULTA,
	DESCRIPCION TYPE OF COLUMN ANTECEDENTES.DESCRIPCION
) 
RETURNS (
	O_ID TYPE OF COLUMN ANTECEDENTES.ID
)
SQL SECURITY DEFINER
AS
BEGIN

     IF(NOT EXISTS(SELECT DISTINCT (1) FROM V_CONSULTAS WHERE ID = :ID_CONSULTA AND ESTADO))THEN
        EXCEPTION E_CONSULTA_NO_ENCONTRADA;
     
     INSERT INTO V_ANTECEDENTES (ID, ID_CONSULTA, DESCRIPCION) 
     VALUES (NULL, :ID_CONSULTA, :DESCRIPCION)
     RETURNING ID
     INTO O_ID;
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_ARS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ARS (
	DESCRIPCION TYPE OF COLUMN ARS.DESCRIPCION,
	COVER_CONSULTA_POR_C TYPE OF COLUMN ARS.COVERCONSULTAPORC,
	ESTADO TYPE OF COLUMN ARS.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ARS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     --Validar que la descripcion no se encuentra en el registro.
     IF(EXISTS(SELECT 1 FROM V_ARS r WHERE r.DESCRIPCION STARTING WITH :DESCRIPCION))THEN
        EXCEPTION E_DUPLICADO_NOMBRE;

     --Insertando el registro.
     INSERT INTO V_ARS (ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO)
     VALUES (NULL, :DESCRIPCION, :COVER_CONSULTA_POR_C, :ESTADO)
     RETURNING ID 
     INTO O_ID;
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_ASEGURADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_ASEGURADO (
	ID_PERSONA TYPE OF COLUMN ASEGURADOS.ID_PERSONA,
	ID_ARS TYPE OF COLUMN ASEGURADOS.ID_ARS,
	NO_NSS TYPE OF COLUMN ASEGURADOS.NO_NSS,
	ESTADO TYPE OF COLUMN ASEGURADOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    INSERT INTO V_ASEGURADOS (ID_PERSONA, ID_ARS, NO_NSS, ESTADO)
    VALUES (:ID_PERSONA, :ID_ARS, :NO_NSS, :ESTADO);
    
    UPDATE V_ARS
    SET 
        CANTIDAD_REGISTRO = COALESCE(CANTIDAD_REGISTRO, 0) + 1
    WHERE
        ID = :ID_ARS;
END^
SET TERM ;^

/* SP_I_CARGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CARGO (
	NOMBRE TYPE OF COLUMN CARGOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN CARGOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CARGOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN CARGOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    INSERT INTO V_CARGOS (ID, NOMBRE, DESCRIPCION, ESTADO)
    VALUES (null, :NOMBRE, :DESCRIPCION, :ESTADO)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
    
    POST_EVENT 'EVENT_CARGO';
END^
SET TERM ;^

/* SP_I_CARTON_BINGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CARTON_BINGO (
	CARTON_HASH TYPE OF COLUMN CARTONES_BINGO.CARTON_HASH,
	MATRIZ_OBJ TYPE OF COLUMN CARTONES_BINGO.MATRIZ_OBJ
) 
RETURNS (
	O_ID TYPE OF COLUMN CARTONES_BINGO.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     IF((SELECT DISTINCT  (1) 
          FROM V_CARTONES_BINGO 
          WHERE CARTON_HASH = :CARTON_HASH) = 1)THEN
          EXCEPTION E_DUPLICADO_CARTON_BINGO;
          
     INSERT INTO V_CARTONES_BINGO (ID, CARTON_HASH, MATRIZ_OBJ)
     VALUES (NULL, :CARTON_HASH, :MATRIZ_OBJ)
     RETURNING (ID)
     INTO O_ID;
     
     SUSPEND;
     
END^
SET TERM ;^

/* SP_I_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CATEGORIA (
	DESCRIPCION TYPE OF COLUMN CATEGORIAS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CATEGORIAS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN CATEGORIAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     INSERT INTO V_CATEGORIAS (ID, DESCRIPCION, ESTADO)
     VALUES (NULL, :DESCRIPCION, :ESTADO)
     RETURNING ID
     INTO ID;
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONSULTA (
	ID_PACIENTE TYPE OF COLUMN CONSULTAS.ID_PACIENTE,
	ID_CONTROL_CONSULTA TYPE OF COLUMN CONSULTAS.ID_CONTROL_CONSULTA,
	LINEA TYPE OF COLUMN CONSULTAS.LINEA,
	FECHA TYPE OF COLUMN CONSULTAS.FECHA
) 
RETURNS (
	O_ID TYPE OF COLUMN CONSULTAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    
    IF(NOT EXISTS(SELECT 1 FROM V_PERSONAS_PACIENTES WHERE ID = :ID_PACIENTE))THEN
            EXCEPTION E_PACIENTE_NO_ENCONTRADO;

    IF(NOT EXISTS(SELECT 1 FROM V_CONTROL_CONSULTA WHERE ID = :ID_CONTROL_CONSULTA))THEN
            EXCEPTION E_CONTROL_CONSULTA_NO_ENCONTRADA;

    IF(:FECHA > CURRENT_DATE)THEN
        EXCEPTION E_FECHA_INCORRECTA;

    INSERT INTO V_CONSULTAS (ID, ID_PACIENTE, ID_CONTROL_CONSULTA, LINEA, FECHA)
    VALUES (NULL, :ID_PACIENTE, :ID_CONTROL_CONSULTA, :LINEA, :FECHA)
    RETURNING ID
    INTO O_ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_V_DIRECCION */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_V_DIRECCION (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
SQL SECURITY DEFINER
AS
BEGIN

     --No se permite operar con la persona generica.
     IF(:ID_PERSONA = 0)THEN
       EXCEPTION E_PERSONA_INACTIVA;
            
     --Verificando el codigo del cliente.
     IF(NOT EXISTS(SELECT DISTINCT(1) 
          FROM V_PERSONAS
          WHERE ID = :ID_PERSONA))THEN
          EXCEPTION E_CLIENTE_NO_ENCONTRADO USING(:ID_PERSONA);
          
     --Persona inactiva en el sistema.
     IF(EXISTS(SELECT 1 FROM V_PERSONAS a WHERE a.ID = :ID_PERSONA AND a.ESTADO IS FALSE))THEN
         EXCEPTION E_PERSONA_INACTIVA;
          
     --Verificando el codigo de la provincia.
     IF(NOT EXISTS(SELECT 1
          FROM V_T_PROVINCIAS 
          WHERE ID = :ID_PROVINCIA) OR :ID_PROVINCIA < 0)THEN
               EXCEPTION E_PROVINCIA_NO_DEFINIDA;
     
     --Verificando el codigo del MUNICIPIOS sea mayor o igual a cero
     IF(NOT EXISTS(SELECT 1
          FROM V_T_MUNICIPIOS 
          WHERE ID = :ID_MUNICIPIO) OR :ID_MUNICIPIO < 0)THEN BEGIN
               EXCEPTION E_MUNICIPIO_NO_DEFINIDO;
     END ELSE BEGIN
          --Verificamos que el codigo del MUNICIPIOS coincida con el codigo de la PROVINCIAS.
          IF(NOT EXISTS(SELECT 1
          FROM V_T_MUNICIPIOS 
          WHERE ID = :ID_MUNICIPIO AND 
                ID_PROVINCIA = :ID_PROVINCIA) AND :ID_MUNICIPIO <> 0)THEN
               EXCEPTION E_MUNICIPIO_NO_PROVINCIA;
     END
     
     --Verificamos que el DISTRITOS_MUNICIPALES sea mayor o igual a cero     
     IF(NOT EXISTS(SELECT 1
          FROM V_T_DISTRITOS_MUNICIPALES 
          WHERE ID = :ID_DISTRITO_MUNICIPAL) OR :ID_DISTRITO_MUNICIPAL < 0)THEN BEGIN
               EXCEPTION E_DISTRITO_M_NO_DEFINIDO;
     END ELSE BEGIN
          --Verificamos que el DISTRITOS_MUNICIPALES y MUNICIPIOS coincidan. 
          IF(NOT EXISTS(SELECT 1
               FROM V_T_DISTRITOS_MUNICIPALES 
               WHERE ID = :ID_DISTRITO_MUNICIPAL AND ID_MUNICIPIO = :ID_MUNICIPIO) AND 
                     :ID_DISTRITO_MUNICIPAL > 0 AND :ID_MUNICIPIO > 0)THEN
                    EXCEPTION E_DISTRITO_M_NO_MUNICIPIO;
     END
     
     --Verificamos que el CODIGOS_POSTALES sea mayor o igual a cero.
     IF(NOT EXISTS(SELECT 1
          FROM V_T_CODIGOS_POSTALES 
          WHERE ID = :ID_CODIGO_POSTAL) OR :ID_CODIGO_POSTAL < 0)THEN BEGIN
          EXCEPTION E_CODIGO_P_NO_DEFINIDO;
     END ELSE BEGIN
          --Verificamos que el codigo de CODIGOS_POSTALES y PROVINCIAS coincidan. 
          IF(NOT EXISTS(SELECT 1
               FROM V_T_CODIGOS_POSTALES 
               WHERE ID = :ID_CODIGO_POSTAL AND 
                     ID_PROVINCIA = :ID_PROVINCIA) AND
                     :ID_CODIGO_POSTAL > 0 AND :ID_PROVINCIA > 0)THEN
               EXCEPTION E_CODIGO_P_NO_PROVINCIA;
     END
     
     IF(:POR_DEFECTO)THEN BEGIN
          UPDATE V_CONTACTOS_DIRECCIONES
          SET 
               POR_DEFECTO = FALSE
          WHERE
               ID_PERSONA = :ID_PERSONA;
     END
     
END^
SET TERM ;^

/* SP_I_CONTACTO_DIRECCION */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_DIRECCION (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	DIRECCION TYPE OF COLUMN CONTACTOS_DIRECCIONES.DIRECCION,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     
     EXECUTE PROCEDURE SP_V_DIRECCION (:ID_PERSONA, :ID_PROVINCIA, :ID_MUNICIPIO, :ID_DISTRITO_MUNICIPAL,
                    :ID_CODIGO_POSTAL, :POR_DEFECTO);
    
                    
     INSERT INTO V_CONTACTOS_DIRECCIONES(ID, ID_PERSONA, ID_PROVINCIA, ID_MUNICIPIO, ID_DISTRITO_MUNICIPAL, 
                ID_CODIGO_POSTAL, DIRECCION, POR_DEFECTO)
     VALUES (NULL, :ID_PERSONA, :ID_PROVINCIA, :ID_MUNICIPIO, :ID_DISTRITO_MUNICIPAL, :ID_CODIGO_POSTAL, 
                :DIRECCION, :POR_DEFECTO)
     RETURNING (ID)
     INTO O_ID;
          
     POST_EVENT 'EVENT_DIRECCION';
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_CONTACTO_EMAIL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_EMAIL (
	ID_PERSONA TYPE OF COLUMN CONTACTOS_EMAIL.ID_PERSONA,
	EMAIL TYPE OF COLUMN CONTACTOS_EMAIL.EMAIL,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_EMAIL.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN CONTACTOS_EMAIL.ID
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE V_ID TYPE OF COLUMN CONTACTOS_EMAIL.ID;
BEGIN
    IF(:POR_DEFECTO)THEN BEGIN
    --Todos los registros con el ID_PERSONA Deben pasar POR_DEFECTO A FALSE
        UPDATE V_CONTACTOS_EMAIL
        SET 
            POR_DEFECTO = FALSE
        WHERE
            ID_PERSONA = :ID_PERSONA;
    END 
    
    --TODO Validar que el ID_PERSONA EXISTA.
    
    INSERT INTO V_CONTACTOS_EMAIL (ID, ID_PERSONA, EMAIL, POR_DEFECTO)
    VALUES (NULL, :ID_PERSONA, :EMAIL, :POR_DEFECTO) 
    RETURNING (ID)
    INTO O_ID;
    
    --Verificar si existe un registro para el usuario
    IF(NOT EXISTS(SELECT 1 FROM V_CONTACTOS_EMAIL WHERE ID_PERSONA = :ID_PERSONA AND ESTADO AND POR_DEFECTO) IS NULL) THEN BEGIN
            --Si es nulo buscamos el registro con el indice mas alto o mas reciente
            V_ID = (SELECT MAX(ID)  FROM V_CONTACTOS_EMAIL WHERE ID_PERSONA = :ID_PERSONA AND ESTADO IS NOT NULL);
            
            IF(V_ID IS NULL)THEN
                V_ID = (SELECT MAX(ID) FROM V_CONTACTOS_EMAIL WHERE ID_PERSONA = :ID_PERSONA);
            
            --Actualizamos ese registro y lo ponemos por defecto.
            UPDATE V_CONTACTOS_EMAIL
            SET 
                ESTADO = TRUE,
                POR_DEFECTO = TRUE
            WHERE
                ID = :V_ID;
                
            O_ID = :V_ID;
    END
    
    POST_EVENT 'EVENT_CORREO';
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_CONTACTO_TEL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTACTO_TEL (
	I_ID_PERSONA TYPE OF COLUMN V_CONTACTOS_TEL.ID_PERSONA,
	I_TELEFONO TYPE OF COLUMN V_CONTACTOS_TEL.TELEFONO,
	I_TIPO TYPE OF COLUMN V_CONTACTOS_TEL.TIPO,
	I_POR_DEFECTO TYPE OF COLUMN V_CONTACTOS_TEL.POR_DEFECTO
) 
RETURNS (
	O_ID TYPE OF COLUMN V_CONTACTOS_TEL.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Se valida el id de la persona que este registrado en la tabla persona.
    IF(NOT EXISTS(SELECT 1 FROM V_PERSONAS WHERE ID = :I_ID_PERSONA))THEN
        EXCEPTION E_CLIENTE_NO_ENCONTRADO;
    
    --Se valida que id de la persona y el telefono no este duplicado.
    IF(EXISTS(SELECT 1 FROM V_CONTACTOS_TEL WHERE ID_PERSONA = :I_ID_PERSONA AND TELEFONO STARTING WITH :I_TELEFONO))THEN
        EXCEPTION E_CONTACTO_TEL_DUPLICADO USING (:I_ID_PERSONA);
    
    --Se modifican los registros de la base de datos si este registro actual esta por defecto. 
    IF(:I_POR_DEFECTO)THEN BEGIN
        UPDATE V_CONTACTOS_TEL
        SET 
            POR_DEFECTO = FALSE 
        WHERE
            ID_PERSONA = :I_ID_PERSONA;
    END
    
    --Se realiza la insercion del registro. 
    INSERT INTO V_CONTACTOS_TEL (ID, ID_PERSONA, TELEFONO, TIPO, POR_DEFECTO)
    VALUES(NULL, :I_ID_PERSONA, :I_TELEFONO, :I_TIPO, :I_POR_DEFECTO)
    RETURNING(ID)
    INTO O_ID;
    
    POST_EVENT 'EVENT_TELEFONO';
    SUSPEND;
    
END^
SET TERM ;^

/* SP_I_CONTROL_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_CONTROL_CONSULTA (
	USER_NAME TYPE OF COLUMN CONTROL_CONSULTA.USER_NAME,
	CANTIDAD_PACIENTE TYPE OF COLUMN CONTROL_CONSULTA.CANTIDAD_PACIENTE,
	DIA TYPE OF COLUMN CONTROL_CONSULTA.DIA,
	INICIAL TYPE OF COLUMN CONTROL_CONSULTA.INICIAL,
	FINAL TYPE OF COLUMN CONTROL_CONSULTA.FINAL,
	ESTADO TYPE OF COLUMN CONTROL_CONSULTA.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN ALMACENES.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --TODO 16/11/2024 Aqui hay que validar que el USER_NAME tenga el role de DOCTOR.
    IF(EXISTS(SELECT 1 FROM V_CONTROL_CONSULTA WHERE TRIM(USER_NAME) LIKE TRIM(:USER_NAME) AND 
        DIA = :DIA AND :INICIAL BETWEEN INICIAL AND FINAL OR :FINAL BETWEEN INICIAL AND FINAL))THEN
        EXCEPTION E_CHOQUE_HORA;
     
     INSERT INTO V_CONTROL_CONSULTA(ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL, ESTADO)
     VALUES (NULL, :USER_NAME, :CANTIDAD_PACIENTE, :DIA, :INICIAL, :FINAL, :ESTADO)
     RETURNING ID
     INTO O_ID;
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_DEPARTAMENTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_DEPARTAMENTO (
	NOMBRE TYPE OF COLUMN DEPARTAMENTOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN DEPARTAMENTOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN DEPARTAMENTOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID
)
AS
BEGIN
    INSERT INTO DEPARTAMENTOS (ID, NOMBRE, DESCRIPCION, ESTADO)
    VALUES (NULL, :NOMBRE, :DESCRIPCION, :ESTADO)
    RETURNING ID
    INTO :ID;
    
    POST_EVENT 'EVENT_DEPARTAMENTO';
END^
SET TERM ;^

/* SP_I_DOCTOR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_DOCTOR (
	I_USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME,
	I_CLAVE D_CLAVE,
	I_PNOMBRE TYPE OF COLUMN VS_USUARIOS.PNOMBRE,
	I_SNOMBRE TYPE OF COLUMN VS_USUARIOS.SNOMBRE,
	I_APELLIDOS TYPE OF COLUMN VS_USUARIOS.APELLIDOS,
	I_ROL TYPE OF COLUMN GET_ROL.ROL,
	I_COD_EXEQUATUR D_VARCHAR_70,
	I_ESPECIALIDAD D_VARCHAR_70,
	I_ESTADO TYPE OF COLUMN VS_USUARIOS.ESTADO,
	I_ADMINISTRADOR TYPE OF COLUMN VS_USUARIOS.ADMINISTRADOR
) 
RETURNS (
	O_ID TYPE OF COLUMN V_PERSONAS.ID
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE V_ID D_ID; 
DECLARE VARIABLE V_SQL D_VARCHAR_255;
BEGIN
     IF(EXISTS(
                SELECT DISTINCT(1)
                FROM VS_USUARIOS  
                WHERE USERNAME STARTING WITH (TRIM(:I_USER_NAME))))THEN
                    EXCEPTION E_USUARIO_REGISTRADO;
     
     IF((SELECT r.ROL 
          FROM GET_ROLES r 
          WHERE TRIM(r.ROL) like TRIM(:i_rol)) IS NULL)THEN
          EXCEPTION E_ROL_NO_ENCONTRADO;
     
     V_ID = GEN_ID(SEQ_PERSONAS_ID, 1);
          
     V_SQL = 'CREATE USER '||:I_USER_NAME||
               ' PASSWORD '''||i_clave||
               ''' FIRSTNAME '''||i_pnombre||
               ''' MIDDLENAME '''||i_snombre||
               ''' LASTNAME '''||i_apellidos||''''||
     
     iif(i_estado, ' ACTIVE',' INACTIVE') ||
     
     iif(i_administrador, ' GRANT ',' REVOKE ') || 
     ' ADMIN ROLE USING PLUGIN Srp '||
     'TAGS(id='''||v_id||
     ''', gui=''0'', uid=''0'', rol='''||TRIM(i_rol)||
     ''', exe='''||i_cod_exequatur||''', esp='''||i_especialidad||''');';
     
     EXECUTE STATEMENT V_SQL;
     
     O_ID = :V_ID;
     SUSPEND;
END^
SET TERM ;^

/* SP_I_D_FACTURAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_FACTURAS (
	LINEA TYPE OF COLUMN D_FACTURAS.LINEA,
	ID_FACTURA TYPE OF COLUMN D_FACTURAS.ID_FACTURA,
	ID_PRODUCTO TYPE OF COLUMN D_FACTURAS.ID_PRODUCTO,
	ID_PRECIO TYPE OF COLUMN D_FACTURAS.ID_PRECIO,
	CANTIDAD TYPE OF COLUMN D_FACTURAS.CANTIDAD
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO Hacer validaciones para este SP.
    --Debe de verificar que el producto tenga un precio.
    --Que la factura este en modo de edicion.
    
    --Factura.
    IF((SELECT 1 
        FROM V_M_FACTURAS f 
        WHERE f.ID = : ID_FACTURA) IS NULL)THEN
        EXCEPTION E_FACTURA_NO_ENCONTRADA;
        
    
    --Producto
    IF((SELECT 1 
        FROM V_PRODUCTOS p 
        WHERE p.ID = :ID_PRODUCTO) IS NULL)THEN
        EXCEPTION E_PRODUCTO_NO_ENCONTRADO;
        
    IF((SELECT 1 
        FROM V_PRODUCTOS p 
        WHERE p.ID = :ID_PRODUCTO AND
             p.ESTADO IS FALSE) = 1 )THEN
        EXCEPTION E_PRODUCTO_INACTIVO;
    
    --Precio
    IF((SELECT 1 
        FROM V_PRECIOS p 
        WHERE p.ID = :ID_PRECIO AND 
             p.ID_PRODUCTO = :ID_PRODUCTO) IS NULL)THEN
        EXCEPTION E_PRECIO_NO_ENCONTRADO;
    
    --Cantidad
    IF(:CANTIDAD <= 0)THEN
        EXCEPTION E_CANTIDAD_NEGATIVA;
        
    INSERT INTO V_D_FACTURAS (ID, LINEA, ID_FACTURA, ID_PRODUCTO, ID_PRECIO, CANTIDAD) 
    VALUES (NULL, :LINEA, :ID_FACTURA, :ID_PRODUCTO, :ID_PRECIO, :CANTIDAD);
    
    --Descontar la existencia del producto por la cantidad de producto. 
    UPDATE V_PRODUCTOS a
    SET 
        a.EXISTENCIA = a.EXISTENCIA - :CANTIDAD
    WHERE
        a.ID = :ID_PRODUCTO;

    
END^
SET TERM ;^

/* SP_I_D_GUIA_VIGILANCIA_DESARROLLO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_GUIA_VIGILANCIA_DESARROLLO (
	ID_GVD TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_GVD,
	ID_PACIENTE TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_PACIENTE
) 
RETURNS (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    /**
        TODO 10/12/2024 
        1) Debe validarse que el paciente este activo.
        2) Que la edad del paciente correspondar a la guia de vigilancia.
        3) entre otras cosas... 
    */
    INSERT INTO D_GUIA_VIGILANCIA_DESARROLLO (ID, ID_GVD, ID_PACIENTE)
    VALUES (NULL, :ID_GVD, :ID_PACIENTE)
    RETURNING(ID)
    INTO ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_D_MOTIVO_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_MOTIVO_CONSULTA (
	ID_CONSULTA TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID_CONSULTA,
	ID_MOTIVO_CONSULTA TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID_MOTIVO_CONSULTA
) 
RETURNS (
	ID TYPE OF COLUMN V_D_MOTIVO_CONSULTA.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --TODO Crear validaciones para insertar motivos de consulta.
    INSERT INTO D_MOTIVO_CONSULTA (ID, ID_CONSULTA, ID_MOTIVO_CONSULTA)
    VALUES (NULL, :ID_CONSULTA, :ID_MOTIVO_CONSULTA)
    RETURNING(ID)
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_D_RECETA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_D_RECETA (
	ID_RECETA TYPE OF COLUMN D_RECETAS.ID_RECETA,
	LINEA TYPE OF COLUMN D_RECETAS.LINEA,
	ID_MEDICAMENTO TYPE OF COLUMN D_RECETAS.ID_MEDICAMENTO,
	CANTIDAD TYPE OF COLUMN D_RECETAS.CANTIDAD,
	D_DOSIS TYPE OF COLUMN D_RECETAS.D_DOSIS
) 
RETURNS (
	ID TYPE OF COLUMN D_RECETAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     /*
        TODO
          Debe Validarse si ID_MEDICAMENTO tiene estado activo,
          que tenga existencia, Cosas asi que me vienen a la cabeza.
     */
     INSERT INTO V_D_RECETAS(ID, ID_RECETA, LINEA, ID_MEDICAMENTO,  CANTIDAD, D_DOSIS)
     VALUES (NULL, :ID_RECETA, :LINEA, :ID_MEDICAMENTO, :CANTIDAD, :D_DOSIS)
     RETURNING ID 
     INTO ID;
     
     SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_CATEGORIA (
	ID_CATEGORIA TYPE OF COLUMN FOTO_CATEGORIA.ID_CATEGORIA,
	FOTO TYPE OF COLUMN FOTO_CATEGORIA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_CATEGORIA.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_CATEGORIA.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Si actual es verdadero
    IF (:ACTUAL) THEN BEGIN
        --Entonces cambiamos todos los actuales en el sistema a falso.
        UPDATE V_FOTO_CATEGORIA
        SET 
            ACTUAL = FALSE
        WHERE
            ID_CATEGORIA = :ID_CATEGORIA;
    END
    
    IF((SELECT 1 
        FROM V_FOTO_CATEGORIA 
        WHERE ID_CATEGORIA = :ID_CATEGORIA AND ACTUAL) IS NULL)THEN
        ACTUAL = TRUE;
    
    INSERT INTO V_FOTO_CATEGORIA (ID, ID_CATEGORIA, FOTO, ACTUAL)
    VALUES (NULL, :ID_CATEGORIA, :FOTO, :ACTUAL)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_PERSONA (
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA,
	FOTO TYPE OF COLUMN FOTO_PERSONA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PERSONA.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_PERSONA.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Si actual es verdadero
    IF (:ACTUAL) THEN BEGIN
        --Entonces cambiamos todos los actuales en el sistema a falso.
        UPDATE V_FOTO_PERSONA
        SET 
            ACTUAL = FALSE
        WHERE
            ID_PERSONA = :ID_PERSONA;
    END
    
    IF((SELECT 1 
        FROM V_FOTO_PERSONA 
        WHERE ID_PERSONA = :ID_PERSONA AND ACTUAL) IS NULL)THEN
        ACTUAL = TRUE;
    
    INSERT INTO V_FOTO_PERSONA (ID, ID_PERSONA, FOTO, ACTUAL)
    VALUES (NULL, :ID_PERSONA, :FOTO, :ACTUAL)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_FOTO_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_FOTO_PRODUCTO (
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO,
	FOTO TYPE OF COLUMN FOTO_PRODUCTO.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PRODUCTO.ACTUAL
) 
RETURNS (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Si actual es verdadero
    IF (:ACTUAL) THEN BEGIN
        --Entonces cambiamos todos los actuales en el sistema a falso.
        UPDATE V_FOTO_PRODUCTO
        SET 
            ACTUAL = FALSE
        WHERE
            ID_PRODUCTO = :ID_PRODUCTO;
    END
    
    IF((SELECT 1 
        FROM V_FOTO_PRODUCTO 
        WHERE ID_PRODUCTO = :ID_PRODUCTO AND ACTUAL) IS NULL)THEN
        ACTUAL = TRUE;
    
    INSERT INTO V_FOTO_PRODUCTO (ID, ID_PRODUCTO, FOTO, ACTUAL)
    VALUES (NULL, :ID_PRODUCTO, :FOTO, :ACTUAL)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_GENERAL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_GENERAL (
	ID_PERSONA TYPE OF COLUMN GENERALES.ID_PERSONA,
	CEDULA TYPE OF COLUMN GENERALES.CEDULA,
	ID_TIPO_SANGRE TYPE OF COLUMN GENERALES.ID_TIPO_SANGRE,
	ESTADO_CIVIL TYPE OF COLUMN GENERALES.ESTADO_CIVIL
) 
SQL SECURITY DEFINER
AS
BEGIN
    -- TODO Validar algunos campos.
    
    INSERT INTO V_GENERALES (ID, ID_PERSONA, CEDULA, ID_TIPO_SANGRE, ESTADO_CIVIL)
    VALUES (NULL, :ID_PERSONA, :CEDULA, :ID_TIPO_SANGRE, :ESTADO_CIVIL);
    
END^
SET TERM ;^

/* SP_I_HORARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_HORARIO (
	DESCRIPCION TYPE OF COLUMN HORARIOS.DESCRIPCION,
	HORA TYPE OF COLUMN HORARIOS.HORA,
	TOLERANCIA TYPE OF COLUMN HORARIOS.TOLERANCIA,
	ESTADO TYPE OF COLUMN HORARIOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN HORARIOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    INSERT INTO HORARIOS (ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO)
    VALUES (NULL, :DESCRIPCION, :HORA, :TOLERANCIA, :ESTADO)
    RETURNING (ID)
    INTO :ID;
    
    SUSPEND;
    POST_EVENT 'EVENT_HORARIO';
END^
SET TERM ;^

/* SP_I_HUELLA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_HUELLA (
	ID_PERSONA TYPE OF COLUMN HUELLAS.ID_PERSONAL,
	TIPO_DEDO TYPE OF COLUMN HUELLAS.TIPO_DEDO,
	HUELLA TYPE OF COLUMN HUELLAS.HUELLA
) 
RETURNS (
	ID TYPE OF COLUMN HUELLAS.ID
)
AS
BEGIN
    INSERT INTO V_HUELLAS (ID, ID_PERSONA, TIPO_DEDO, HUELLA)
    VALUES (NULL, :ID_PERSONA, :TIPO_DEDO, :HUELLA)
    RETURNING ID
    INTO :ID;
    
    POST_EVENT 'EVENT_HUELLA';
END^
SET TERM ;^

/* SP_I_METRICA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_METRICA (
	ID_CONSULTA TYPE OF COLUMN V_METRICAS.ID_CONSULTA,
	PESO_KG TYPE OF COLUMN V_METRICAS.PESOKG,
	ESTATURA_METRO TYPE OF COLUMN V_METRICAS.ESTATURAMETRO,
	ESCEFALO TYPE OF COLUMN V_METRICAS.ESCEFALO,
	ENF_DETECT TYPE OF COLUMN V_METRICAS.ENF_DETECT,
	HALLAZGOS_POS TYPE OF COLUMN V_METRICAS.HALLAZGOS_POS,
	ID_DIAG TYPE OF COLUMN V_METRICAS.ID_DIAG,
	TX TYPE OF COLUMN V_METRICAS.TX,
	COMPLEMENTO TYPE OF COLUMN V_METRICAS.COMPLEMENTO,
	IMAGEN_TEXTO TYPE OF COLUMN V_METRICAS.IMAGEN_TEXTO
) 
RETURNS (
	ID TYPE OF COLUMN V_METRICAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    
    INSERT INTO V_METRICAS (ID, ID_CONSULTA, PESOKG, ESTATURAMETRO, ESCEFALO, ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, 
            COMPLEMENTO, IMAGEN_TEXTO)
    VALUES (NULL, :ID_CONSULTA, :PESO_KG, :ESTATURA_METRO, :ESCEFALO, :ENF_DETECT, :HALLAZGOS_POS, :ID_DIAG, :TX, 
            :COMPLEMENTO, :IMAGEN_TEXTO)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_M_DEUDAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_DEUDAS (
	ID_CLIENTE TYPE OF COLUMN M_DEUDAS.ID_CLIENTE,
	CONCEPTO TYPE OF COLUMN M_DEUDAS.CONCEPTO,
	MONTO TYPE OF COLUMN M_DEUDAS.MONTO
) 
RETURNS (
	O_ID TYPE OF COLUMN M_DEUDAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Se valida que no exista un nombre de almacen duplicado.
    IF(EXISTS(SELECT 1 FROM V_PERSONAS WHERE ID = :ID_CLIENTE AND ESTADO IS FALSE))THEN
        EXCEPTION E_CLIENTE_INACTIVO;
     
    INSERT INTO V_M_DEUDAS (ID, ID_CLIENTE, CONCEPTO, MONTO, ESTADO)
    VALUES (NULL, :ID_CLIENTE, :CONCEPTO, :MONTO, 'i')
    RETURNING ID
    INTO O_ID;
    
    POST_EVENT 'EVENT_DEUDA';
    SUSPEND;
END^
SET TERM ;^

/* SP_I_M_ENTRADA_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_ENTRADA_PRODUCTO (
	ID_PROVEEDOR TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_PROVEEDOR,
	ID_ALMACEN TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_ALMACEN,
	COD_FACTURA TYPE OF COLUMN M_ENTRADA_PRODUCTOS.COD_FACTURA,
	ESTADO TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ESTADO DEFAULT 't'
) 
RETURNS (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    
    IF((SELECT ESTADO FROM V_PERSONAS WHERE ID = :ID_PROVEEDOR) IS FALSE)THEN
        EXCEPTION E_PROVEEDOR_INACTIVO USING(:ID_PROVEEDOR);
        
    IF((SELECT ESTADO FROM V_ALMACENES WHERE ID = :ID_ALMACEN) IS FALSE)THEN
        EXCEPTION E_ALMACEN_INACTIVO USING(:ID_ALMACEN);
    
    INSERT INTO V_M_ENTRADA_PRODUCTOS (ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, ESTADO)
    VALUES (NULL, :ID_PROVEEDOR, :ID_ALMACEN, :COD_FACTURA, :ESTADO)
    RETURNING ID
    INTO :ID;
    SUSPEND;
END^
SET TERM ;^

/* SP_I_M_FACTURA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_FACTURA (
	ID_CLIENTE TYPE OF COLUMN M_FACTURAS.ID_CLIENTE,
	ID_CONTACTOS_TEL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_TEL,
	ID_CONTACTOS_DIRECCIONES TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_DIRECCIONES,
	ID_CONTACTOS_EMAIL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_EMAIL,
	ID_TURNO TYPE OF COLUMN M_FACTURAS.ID_TURNO,
	ESTADO_FACTURA TYPE OF COLUMN M_FACTURAS.ESTADO_FACTURA,
	NOMBRE_TEMP TYPE OF COLUMN M_FACTURAS.NOMBRE_TEMP
) 
RETURNS (
	ID TYPE OF COLUMN M_FACTURAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     /*
          * Validaciones del SP la cual debe validar que:
          
          Antes de validar un campo como son Telefono, Correo o Direccion estos deben ser diferente de 0;
          
          1) La factura se registre con un turno valido.
          2) Que el numero telefonico este asignado al cliente de la factura.
          3) Que el correo electronico este asignado al cliente de la factura.
          4) Que la direccion sea valida para dicho cliente.
          
          Nota: Cuando se registra una factura debe de llevarse un control de la facturas que se van guardando 
          en el sistema. Por ejemplo, Cantidad de total facturas, las cantidades de la facturas que se realizan en
          un dia, en una semana, en un mes y en un año para el sistema analitico, cantidad de facturas por estado.
     */
     
     IF((SELECT 1 
         FROM V_PERSONAS_CLIENTES  
         WHERE ID = :ID_CLIENTE) IS NULL)THEN BEGIN
        IF((SELECT 1 
            FROM V_PERSONAS  
            WHERE ID = :ID_CLIENTE) = 1)THEN BEGIN 
                EXCEPTION E_CLIENTE_NO_ENCONTRADO 'La persona no está registrada como cliente.';
        END ELSE BEGIN 
                EXCEPTION E_CLIENTE_ENCONTRADO;
        END
     END
     
     
     
     --Validando que el turno este activo.
     IF(( SELECT DISTINCT(1) 
              FROM V_TURNOS 
              WHERE ID = :ID_TURNO AND ESTADO) IS NULL)THEN
          EXCEPTION E_TURNO_CERRADO;
     
     --Validando que el id de contacto es diferente de cero y que se encuentre en la tabla de CONTACTOS_TEL y
     --el codigo de cliente este relacionado a ese contacto y que el estado sea activo.
     IF(:ID_CONTACTOS_TEL <> 0 AND (SELECT DISTINCT (1) 
                                              FROM V_CONTACTOS_TEL t 
                                              WHERE t.ID = :ID_CONTACTOS_TEL AND 
                                                    t.ID_PERSONA = :ID_CLIENTE AND 
                                                    t.ESTADO) IS NULL) THEN
          EXCEPTION E_TELEFONO_INACTIVO;
     
     --Validacion de Correo
     IF(:ID_CONTACTOS_EMAIL <> 0 AND (SELECT DISTINCT (1) 
                                                  FROM V_CONTACTOS_EMAIL e 
                                                  WHERE e.ID = :ID_CONTACTOS_EMAIL AND 
                                                        e.ID_PERSONA = :ID_CLIENTE AND 
                                                        e.ESTADO) IS NULL) THEN
          EXCEPTION E_CORREO_INACTIVO;
          
     --Validacion de Direccion
     IF(:ID_CONTACTOS_DIRECCIONES <> 0 AND (SELECT DISTINCT (1) 
                                                        FROM V_CONTACTOS_DIRECCIONES e
                                                        WHERE e.ID = :ID_CONTACTOS_DIRECCIONES AND 
                                                                e.ID_PERSONA = :ID_CLIENTE AND 
                                                                e.ESTADO) IS NULL) THEN
          EXCEPTION E_DIRECCION_INACTIVO;
          
     INSERT INTO V_M_FACTURAS (ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES, ID_CONTACTOS_EMAIL,
                ID_TURNO, ESTADO_FACTURA, NOMBRE_TEMP)
     VALUES (NULL, :ID_CLIENTE, :ID_CONTACTOS_TEL, :ID_CONTACTOS_DIRECCIONES, :ID_CONTACTOS_EMAIL, 
                :ID_TURNO, :ESTADO_FACTURA, :NOMBRE_TEMP)
     RETURNING ID
     INTO ID;
     
     
     SUSPEND;
     
END^
SET TERM ;^

/* SP_I_M_RECETA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_M_RECETA (
	ID_CONSULTA TYPE OF COLUMN M_RECETAS.ID_CONSULTA
) 
RETURNS (
	ID TYPE OF COLUMN M_RECETAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    /*
        TODO 25/12/2024 Crear validaciones al campo de id_Consulta.
    */
    INSERT INTO V_M_RECETAS (ID, ID_CONSULTA)
    VALUES (NULL, :ID_CONSULTA)
    RETURNING ID
    INTO ID;
END^
SET TERM ;^

/* SP_I_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA (
	PERSONA TYPE OF COLUMN PERSONAS.PERSONA,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
RETURNS (
	ID_PERSONA TYPE OF COLUMN PERSONAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN

     INSERT INTO V_PERSONAS (ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, ESTADO)
     VALUES ( NULL, :PERSONA, :PNOMBRE, :SNOMBRE, :APELLIDOS, :SEXO,:FECHA_NACIMIENTO, :ESTADO) 
     RETURNING ID
     INTO ID_PERSONA;
     
     POST_EVENT 'EVENT_CLIENTE';
     POST_EVENT 'EVENT_PROVEEDOR';
     POST_EVENT 'EVENT_ESTUDIANTE';
     POST_EVENT 'EVENT_PADRE';
     SUSPEND;
END^
SET TERM ;^

/* SP_I_PERSONA_CLIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_CLIENTE (
	ID TYPE OF COLUMN PERSONAS_CLIENTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    --Ingresando el cliente
     UPDATE OR INSERT INTO V_PERSONAS_CLIENTES(ID) 
     VALUES(:ID)
     MATCHING (ID);

     POST_EVENT 'EVENT_CLIENTE';
END^
SET TERM ;^

/* SP_I_PERSONA_EMPLEADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE OR INSERT INTO V_PERSONAS_EMPLEADOS (ID)
    VALUES (:ID)
    MATCHING (ID);
     
    POST_EVENT 'EVENT_EMPLEADO';
END^
SET TERM ;^

/* SP_I_PERSONA_EMPLEADO_ATR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_EMPLEADO_ATR (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID,
	ID_DEPARTAMENTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_DEPARTAMENTO,
	ID_CARGO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_CARGO,
	SUELDO_BRUTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.SUELDO_BRUTO
) 
SQL SECURITY DEFINER
AS
BEGIN
    
    IF((SELECT ESTADO FROM V_CARGOS WHERE ID = :ID_CARGO) IS FALSE)THEN
        EXCEPTION E_CARGO_INACTIVO USING (:ID_CARGO);
        
    IF((SELECT ESTADO FROM V_DEPARTAMENTOS WHERE ID = :ID_DEPARTAMENTO) IS FALSE)THEN
        EXCEPTION E_DEPARTAMENTO_INACTIVO USING(:ID_DEPARTAMENTO);
        
    IF(:SUELDO_BRUTO < 0)THEN
        EXCEPTION E_SUELDO_BRUTO_NEGATIVO USING (:SUELDO_BRUTO);

    INSERT INTO PERSONAS_EMPLEADOS_ATR (ID, ID_DEPARTAMENTO, ID_CARGO, SUELDO_BRUTO)
    VALUES (
        :ID, 
        :ID_DEPARTAMENTO,
        :ID_CARGO, 
        :SUELDO_BRUTO
    );
     
    POST_EVENT 'EVENT_EMPLEADO';
END^
SET TERM ;^

/* SP_I_PERSONA_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN 
     
     UPDATE OR INSERT INTO V_PERSONAS_ESTUDIANTES (ID)
     VALUES (:ID)
     MATCHING (ID);
     
     POST_EVENT 'EVENT_ESTUDIANTE';
     
END^
SET TERM ;^

/* SP_I_PERSONA_PACIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
    
    IF(NOT EXISTS(SELECT 1 FROM V_PERSONAS WHERE ID = :ID)) THEN
        EXCEPTION E_PACIENTE_NO_ENCONTRADO;
    
    UPDATE OR INSERT INTO V_PERSONAS_PACIENTES (ID)
    VALUES (:ID)
    MATCHING (ID);
    
    POST_EVENT 'EVENT_PACIENTES';
END^
SET TERM ;^

/* SP_I_PERSONA_PADRE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PADRE (
	ID TYPE OF COLUMN PERSONAS_PADRES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN

     UPDATE OR INSERT INTO V_PERSONAS_PADRES(ID)
     VALUES(:ID)
     MATCHING (ID);
          
     POST_EVENT 'EVENT_PADRE';
END^
SET TERM ;^

/* SP_I_PERSONA_PROVEEDOR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PERSONA_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES.ID
) 
SQL SECURITY DEFINER
AS
BEGIN

     UPDATE OR INSERT INTO V_PERSONAS_PROVEEDORES (ID)
     VALUES (:ID)
     MATCHING (ID);
     
     POST_EVENT 'EVENT_PROVEEDORES';
END^
SET TERM ;^

/* SP_I_PRECIOS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PRECIOS (
	ID_PRODUCTO TYPE OF COLUMN PRECIOS.ID_PRODUCTO,
	ID_TIPO_PRECIO TYPE OF COLUMN PRECIOS.ID_TIPO_PRECIO,
	ID_TIPO_IMPUESTO TYPE OF COLUMN PRECIOS.ID_TIPO_IMPUESTO,
	PRECIO TYPE OF COLUMN PRECIOS.PRECIO,
	MONEDA TYPE OF COLUMN PRECIOS.MONEDA,
	FECHA_INICIO TYPE OF COLUMN PRECIOS.FECHA_INICIO,
	FECHA_FIN TYPE OF COLUMN PRECIOS.FECHA_FIN,
	DESCUENTO TYPE OF COLUMN PRECIOS.DESCUENTO,
	COSTO_ENVIO TYPE OF COLUMN PRECIOS.COSTO_ENVIO,
	ESTADO TYPE OF COLUMN PRECIOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN PRECIOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN

    --TODO Hacer la validaciones de que el producto este activo.
    --TODO Que la fecha inicio sea Mayor o igual que la fecha actual.
    --TODO Que la fecha fin si no es nula, debe ser mayor que la fecha actual. 
    
    INSERT INTO V_PRECIOS (ID, ID_PRODUCTO, ID_TIPO_PRECIO, ID_TIPO_IMPUESTO, 
            PRECIO, MONEDA, FECHA_INICIO, FECHA_FIN, DESCUENTO, COSTO_ENVIO,
            ESTADO)
    VALUES (:ID, :ID_PRODUCTO, :ID_TIPO_PRECIO, :ID_TIPO_IMPUESTO, 
            :PRECIO, :MONEDA, :FECHA_INICIO, :FECHA_FIN, :DESCUENTO, 
            :COSTO_ENVIO, :ESTADO)
    RETURNING ID
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_PRODUCTO (
	ID_CATEGORIA TYPE OF COLUMN PRODUCTOS.ID_CATEGORIA,
	CODIGO TYPE OF COLUMN PRODUCTOS.CODIGO,
	DESCRIPCION TYPE OF COLUMN PRODUCTOS.DESCRIPCION,
	NOTA TYPE OF COLUMN PRODUCTOS.NOTA,
	ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO
) 
RETURNS (
	ID TYPE OF COLUMN PRODUCTOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
     IF(EXISTS (SELECT 1 FROM V_CATEGORIAS WHERE ID = :ID_CATEGORIA AND ESTADO IS FALSE))THEN
        EXCEPTION E_CATEGORIAS_INACTIVA;
        
     INSERT INTO V_PRODUCTOS (ID, ID_CATEGORIA, CODIGO, DESCRIPCION, NOTA, ESTADO)
     VALUES (NULL, :ID_CATEGORIA, :CODIGO, :DESCRIPCION, :NOTA, :ESTADO)
     RETURNING ID 
     INTO ID;
     
     POST_EVENT 'EVENT_PRODUCTO';
     SUSPEND;
END^
SET TERM ;^

/* SP_I_R_PADRE_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_R_PADRE_ESTUDIANTE (
	ID_PADRE_O_MADRE TYPE OF COLUMN V_RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_ESTUDIANTE TYPE OF COLUMN V_RELACION_PADRE_ESTUDIANTE.ID_ESTUDIANTE
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO Validar los ID de las personas.
    INSERT INTO V_RELACION_PADRE_ESTUDIANTE (ID_PADRE_O_MADRE, ID_ESTUDIANTE)
    VALUES (:ID_PADRE_O_MADRE, :ID_ESTUDIANTE);
END^
SET TERM ;^

/* SP_I_R_PADRE_PACIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_R_PADRE_PACIENTE (
	ID_PADRE_O_MADRE TYPE OF COLUMN V_RELACION_PADRE_PACIENTE.ID_PADRE_O_MADRE,
	ID_PACIENTE TYPE OF COLUMN V_RELACION_PADRE_PACIENTE.ID_PACIENTE
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO Validar los IDes.
    INSERT INTO V_RELACION_PADRE_PACIENTE (ID_PADRE_O_MADRE, ID_PACIENTE)
    VALUES (:ID_PADRE_O_MADRE,  :ID_PACIENTE);
END^
SET TERM ;^

/* SP_I_TANDA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_TANDA (
	ANNO_INICIAL TYPE OF COLUMN V_TANDAS.ANNO_INICIAL,
	ANNO_FINAL TYPE OF COLUMN V_TANDAS.ANNO_FINAL,
	HORA_INICIO TYPE OF COLUMN V_TANDAS.HORA_INICIO,
	HORA_FINAL TYPE OF COLUMN V_TANDAS.HORA_FINAL,
	LUNES TYPE OF COLUMN V_TANDAS.LUNES,
	MARTES TYPE OF COLUMN V_TANDAS.MARTES,
	MIERCOLES TYPE OF COLUMN V_TANDAS.MIERCOLES,
	JUEVES TYPE OF COLUMN V_TANDAS.JUEVES,
	VIERNES TYPE OF COLUMN V_TANDAS.VIERNES,
	SABADOS TYPE OF COLUMN V_TANDAS.SABADOS,
	DOMINGOS TYPE OF COLUMN V_TANDAS.DOMINGOS,
	CANTIDAD_ESTUDIANTES TYPE OF COLUMN V_TANDAS.CANTIDAD_ESTUDIANTES,
	CON_EDAD TYPE OF COLUMN V_TANDAS.CON_EDAD,
	EDAD_MINIMA TYPE OF COLUMN V_TANDAS.EDAD_MINIMA,
	EDAD_MAXIMA TYPE OF COLUMN V_TANDAS.EDAD_MAXIMA,
	ESTADO TYPE OF COLUMN V_TANDAS.ESTADO
) 
RETURNS (
	O_ID TYPE OF COLUMN V_TANDAS.ID
)
AS
BEGIN
    
    INSERT INTO V_TANDAS (ID, ANNO_INICIAL, ANNO_FINAL, HORA_INICIO, HORA_FINAL, LUNES, MARTES, MIERCOLES, JUEVES, 
            VIERNES, SABADOS, DOMINGOS, CANTIDAD_ESTUDIANTES, CON_EDAD, EDAD_MINIMA, EDAD_MAXIMA, ESTADO)
    VALUES (NULL, :ANNO_INICIAL, :ANNO_FINAL, :HORA_INICIO, :HORA_FINAL, :LUNES, :MARTES, :MIERCOLES, :JUEVES, 
                :VIERNES, :SABADOS, :DOMINGOS, :CANTIDAD_ESTUDIANTES, :CON_EDAD, :EDAD_MINIMA, :EDAD_MAXIMA, 
                :ESTADO)
    RETURNING ID
    INTO O_ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_TURNO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_TURNO (
	TURNO_USUARIO TYPE OF COLUMN TURNOS.TURNO_USUARIO
) 
RETURNS (
	ID TYPE OF COLUMN TURNOS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    --Verificamos si el usuario existe en el sistema.
    IF(NOT EXISTS(SELECT 1 FROM VS_USUARIOS WHERE USERNAME STARTING WITH (UPPER(TRIM(:TURNO_USUARIO)))))THEN
      EXCEPTION E_USUARIO_NO_ENCONTRADO;

    --Validacion de estado del usuario.
    IF((SELECT ESTADO 
          FROM VS_USUARIOS 
          WHERE TRIM(USERNAME) STARTING WITH TRIM(:TURNO_USUARIO)) IS FALSE) THEN
      EXCEPTION E_USUARIO_INACTIVO;

    --Validando si es cajero.
    IF(NOT EXISTS(SELECT 1 FROM GET_CAJEROS WHERE USER_NAME STARTING WITH :TURNO_USUARIO)) THEN
        EXCEPTION E_CAJERO_NO_REGISTRADO;

    --Validamos que el usuario no cuente con un turno activo.
    IF(EXISTS(SELECT 1 FROM V_TURNOS WHERE UPPER(TRIM(TURNO_USUARIO)) STARTING WITH UPPER(TRIM(:TURNO_USUARIO)) AND ESTADO))THEN
      EXCEPTION E_CAJERO_TURNO_ACTIVO;
    
    -- 
    INSERT INTO V_TURNOS (ID, TURNO_USUARIO, FECHA_HORA_FINAL)
    VALUES (NULL, :TURNO_USUARIO, NULL)
    RETURNING (ID)
    INTO :ID;
    
    SUSPEND;
END^
SET TERM ;^

/* SP_I_T_E_S_SYS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_T_E_S_SYS (
	LOGO TYPE OF COLUMN T_E_S_SYS.LOGO,
	PATH_LOGO TYPE OF COLUMN T_E_S_SYS.PATH_LOGO
) 
SQL SECURITY DEFINER
AS
BEGIN
    --TODO
    --Esta tabla es llama Vista Tabla Entrada y Salida de Sistema.
    --Tengo la constante 1 temporalmente en este insert.
    --Luego veo que hago con ella...
    UPDATE OR INSERT INTO V_T_E_S_SYS(ID, LOGO, PATH_LOGO) 
    VALUES(1, :LOGO, :PATH_LOGO) 
    MATCHING(ID);
END^
SET TERM ;^

/* SP_I_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_I_USUARIO (
	USER_NAME TYPE OF COLUMN VS_USUARIOS.USERNAME,
	CLAVE D_CLAVE,
	PNOMBRE TYPE OF COLUMN VS_USUARIOS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN VS_USUARIOS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN VS_USUARIOS.APELLIDOS,
	ESTADO TYPE OF COLUMN VS_USUARIOS.ESTADO,
	ADMINISTRADOR TYPE OF COLUMN VS_USUARIOS.ADMINISTRADOR,
	DESCRIPCION TYPE OF COLUMN VS_USUARIOS.DESCRIPCION,
	TAGS_ D_VARCHAR_MAX
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE SQL_ D_VARCHAR_MAX;
DECLARE VARIABLE FIRST_NAME TYPE OF COLUMN VS_USUARIOS.PNOMBRE;
DECLARE VARIABLE MIDDLE_NAME TYPE OF COLUMN VS_USUARIOS.PNOMBRE;
DECLARE VARIABLE LAST_NAME TYPE OF COLUMN VS_USUARIOS.PNOMBRE;
BEGIN
    SQL_ = '';
    
    IF((SELECT DISTINCT (1) 
      FROM VS_USUARIOS 
      WHERE TRIM(USERNAME) STARTING WITH TRIM(:USER_NAME)) = 1)THEN
           EXCEPTION E_USUARIO_REGISTRADO;
           
    FIRST_NAME = IIF(PNOMBRE IS NULL OR PNOMBRE = '', '', ' FIRSTNAME ''' || TRIM(PNOMBRE) || '''');

    MIDDLE_NAME = IIF(SNOMBRE IS NULL OR SNOMBRE = '', '', ' MIDDLENAME ''' || TRIM(SNOMBRE) || ''''); 

    LAST_NAME = IIF(APELLIDOS IS NULL OR APELLIDOS = '', '', ' LASTNAME ''' || TRIM(APELLIDOS) || '''');
      
    SQL_ = 'CREATE USER ' || TRIM(USER_NAME) || ' PASSWORD ''' || TRIM( CLAVE ) || ''' ' ||
         FIRST_NAME ||
         MIDDLE_NAME ||
         LAST_NAME ||
         IIF(ESTADO, ' ACTIVE ' , ' INACTIVE ') ||
         IIF( TAGS_ = '', '', ' TAGS(' || TAGS_ || ') ' ) ||
         IIF(ADMINISTRADOR, ' GRANT ',' REVOKE ') || ' ADMIN ROLE USING PLUGIN Srp ; ';
      
    EXECUTE STATEMENT :SQL_;

    SQL_ = 'COMMENT ON USER ' || TRIM(USER_NAME) || ' is ''' || DESCRIPCION || '''';

    EXECUTE STATEMENT :SQL_;

    POST_EVENT 'EVENT_USUARIO';
     
    WHEN GDSCODE dsql_error DO BEGIN
        INSERT INTO T_PRUEBA (VALOR)
        VALUES (:SQL_);
    END
     
END^
SET TERM ;^

/* SP_S_GET_TURNOS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_S_GET_TURNOS
RETURNS (
	ID TYPE OF COLUMN TURNOS.ID,
	TURNO_USUARIO TYPE OF COLUMN TURNOS.TURNO_USUARIO,
	FECHA_HORA_INICIO TYPE OF COLUMN TURNOS.FECHA_HORA_INICIO,
	FECHA_HORA_FINAL TYPE OF COLUMN TURNOS.FECHA_HORA_FINAL,
	ESTADO TYPE OF COLUMN TURNOS.ESTADO,
	MONTO_FACTURADO TYPE OF COLUMN TURNOS.MONTO_FACTURADO,
	MONTO_DEVUELTO TYPE OF COLUMN TURNOS.MONTO_DEVUELTO,
	MONTO_EFECTIVO TYPE OF COLUMN TURNOS.MONTO_EFECTIVO,
	MONTO_CREDITO TYPE OF COLUMN TURNOS.MONTO_CREDITO,
	ID_FACTURA TYPE OF COLUMN M_FACTURAS.ID
)
SQL SECURITY DEFINER
AS
BEGIN
    
    ID = (SELECT ID FROM V_TURNOS WHERE TRIM(TURNO_USUARIO) LIKE TRIM(CURRENT_USER) AND ESTADO);
    
    IF(:ID IS NULL)THEN
        EXCEPTION E_CAJERO_SIN_TURNO;
    
    ID_FACTURA = (SELECT ID FROM V_M_FACTURAS WHERE ESTADO_FACTURA = 'i' AND ID_TURNO = :ID);
    
    IF(ID_FACTURA IS NULL)THEN BEGIN
        ID_FACTURA = (SELECT ID_FACTURA FROM ADMIN_GET_ID_FACTURA_NUEVA (:ID));
    END
    
    SUSPEND;
END^
SET TERM ;^

/* SP_U_ALMACEN */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ALMACEN (
	ID TYPE OF COLUMN ALMACENES.ID,
	NOMBRE TYPE OF COLUMN ALMACENES.NOMBRE,
	UBICACION TYPE OF COLUMN ALMACENES.UBICACION,
	ESTADO TYPE OF COLUMN ALMACENES.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_ALMACEN_GENERAL;
        
    UPDATE V_ALMACENES
    SET 
        NOMBRE    = :NOMBRE, 
        UBICACION = :UBICACION, 
        ESTADO    = :ESTADO
    WHERE
        ID        = :ID;

    POST_EVENT 'EVENT_ALMACEN';
END^
SET TERM ;^

/* SP_U_ANTECEDENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ANTECEDENTE (
	ID TYPE OF COLUMN ANTECEDENTES.ID,
	DESCRIPCION TYPE OF COLUMN ANTECEDENTES.DESCRIPCION
) 
SQL SECURITY DEFINER
AS
BEGIN
     /*
          Antes de modificar un antecendete debe de verificarse que este antecendete no este en uso, ejemplo
     */
     UPDATE V_ANTECEDENTES 
          SET DESCRIPCION   = :DESCRIPCION
     WHERE ID              = :ID;
END^
SET TERM ;^

/* SP_U_ARS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ARS (
	ID TYPE OF COLUMN ARS.ID,
	DESCRIPCION TYPE OF COLUMN ARS.DESCRIPCION,
	COVERTURA TYPE OF COLUMN ARS.COVERCONSULTAPORC,
	ESTADO TYPE OF COLUMN ARS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
     
     UPDATE V_ARS      SET 
          DESCRIPCION                   = :Descripcion, 
          COVERTURA_CONSULTA_PORCIENTO  = :Covertura, 
          ESTADO                        = :ESTADO
     WHERE
          ID                            = :ID;

END^
SET TERM ;^

/* SP_U_ASEGURADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ASEGURADO (
	ID_PERSONA TYPE OF COLUMN ASEGURADOS.ID_PERSONA,
	ID_ARS TYPE OF COLUMN ASEGURADOS.ID_ARS,
	NO_NSS TYPE OF COLUMN ASEGURADOS.NO_NSS,
	ESTADO TYPE OF COLUMN ASEGURADOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
     
    UPDATE V_ASEGURADOS
    SET 
        ID_ARS = :ID_ARS, 
        NO_NSS = :NO_NSS, 
        ESTADO = ESTADO
    WHERE
        ID_PERSONA = :ID_PERSONA;
END^
SET TERM ;^

/* SP_U_CARGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CARGO (
	ID TYPE OF COLUMN CARGOS.ID,
	NOMBRE TYPE OF COLUMN CARGOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN CARGOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN CARGOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE V_CARGOS
    SET 
        NOMBRE = :NOMBRE, 
        DESCRIPCION = :DESCRIPCION, 
        ESTADO = :ESTADO
    WHERE
        ID = :ID;
    
    POST_EVENT 'EVENT_CARGO';
END^
SET TERM ;^

/* SP_U_CARTONES_BINGO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CARTONES_BINGO (
	ID TYPE OF COLUMN CARTONES_BINGO.ID,
	ESTADO TYPE OF COLUMN CARTONES_BINGO.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
     
     UPDATE V_CARTONES_BINGO
     SET 
         ESTADO = :ESTADO
     WHERE
         ID = :ID;
END^
SET TERM ;^

/* SP_U_CATEGORIA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CATEGORIA (
	ID TYPE OF COLUMN V_CATEGORIAS.ID,
	DESCRIPCION TYPE OF COLUMN V_CATEGORIAS.DESCRIPCION,
	ESTADO TYPE OF COLUMN V_CATEGORIAS.ESTADO
) 
SQL SECURITY INVOKER
AS
BEGIN

    IF(:ID = 0)THEN
        EXCEPTION E_CATEGORIA_GENERICA;
    
    IF(EXISTS(SELECT 1 FROM V_CATEGORIAS WHERE DESCRIPCION LIKE :DESCRIPCION AND ID <> :ID))THEN
        EXCEPTION E_DUPLICADO_CATEGORIA;
    
    UPDATE V_CATEGORIAS
    SET 
        DESCRIPCION     = :DESCRIPCION, 
        ESTADO          = :ESTADO
    WHERE
        ID              = :ID;

END^
SET TERM ;^

/* SP_U_CONSULTAS */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONSULTAS (
	ID TYPE OF COLUMN CONSULTAS.ID,
	ID_PACIENTE TYPE OF COLUMN CONSULTAS.ID_PACIENTE,
	ID_CONTROL_CONSULTA TYPE OF COLUMN CONSULTAS.ID_CONTROL_CONSULTA,
	LINEA TYPE OF COLUMN CONSULTAS.LINEA,
	ESTADO TYPE OF COLUMN CONSULTAS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN 
    --TODO hacer las validaciones antes de actualizar o cambiar de estado un almacen. 
    UPDATE V_CONSULTAS
    SET 
        ID_PACIENTE             = :ID_PACIENTE, 
        ID_CONTROL_CONSULTA     = :ID_CONTROL_CONSULTA, 
        LINEA                   = :LINEA, 
        ESTADO                  = :ESTADO
    WHERE
        ID                      = :ID;
END^
SET TERM ;^

/* SP_U_CONTACTO_DIRECCION */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_DIRECCION (
	ID TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID,
	ID_PERSONA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PERSONA,
	ID_PROVINCIA TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_PROVINCIA,
	ID_MUNICIPIO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_MUNICIPIO,
	ID_DISTRITO_MUNICIPAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_DISTRITO_MUNICIPAL,
	ID_CODIGO_POSTAL TYPE OF COLUMN CONTACTOS_DIRECCIONES.ID_CODIGO_POSTAL,
	DIRECCION TYPE OF COLUMN CONTACTOS_DIRECCIONES.DIRECCION,
	ESTADO TYPE OF COLUMN CONTACTOS_DIRECCIONES.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_DIRECCIONES.POR_DEFECTO
) 
SQL SECURITY DEFINER
AS
BEGIN
     EXECUTE PROCEDURE SP_V_DIRECCION (:ID_PERSONA, :ID_PROVINCIA, :ID_MUNICIPIO, :ID_DISTRITO_MUNICIPAL,
                    :ID_CODIGO_POSTAL, :POR_DEFECTO);
    
     UPDATE V_CONTACTOS_DIRECCIONES 
     SET 
         ID_PERSONA             = :ID_PERSONA, 
         ID_PROVINCIA           = :ID_PROVINCIA, 
         ID_MUNICIPIO           = :ID_MUNICIPIO, 
         ID_DISTRITO_MUNICIPAL  = :ID_DISTRITO_MUNICIPAL, 
         ID_CODIGO_POSTAL       = :ID_CODIGO_POSTAL, 
         DIRECCION              = :DIRECCION, 
         ESTADO                 = :ESTADO, 
         POR_DEFECTO            = :POR_DEFECTO
     WHERE
         ID                     = :ID;
          
     POST_EVENT 'EVENT_DIRECCION';
END^
SET TERM ;^

/* SP_U_CONTACTO_EMAIL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_EMAIL (
	ID TYPE OF COLUMN CONTACTOS_EMAIL.ID,
	EMAIL TYPE OF COLUMN CONTACTOS_EMAIL.EMAIL,
	ESTADO TYPE OF COLUMN CONTACTOS_EMAIL.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_EMAIL.POR_DEFECTO
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID_PERSONA TYPE OF COLUMN CONTACTOS_EMAIL.ID_PERSONA;
BEGIN
    /*
    TODO Crear o pensar en validaciones que permitan realizar actualizaciones en los contactos de correo.
    */
    
    IF(:ESTADO AND :POR_DEFECTO)THEN BEGIN
        --Todos los registros con el ID_PERSONA Deben pasar POR_DEFECTO A FALSE
        ID_PERSONA = (SELECT ID_PERSONA FROM V_CONTACTOS_EMAIL WHERE ID = :ID);
        
        UPDATE V_CONTACTOS_EMAIL
        SET 
            POR_DEFECTO = FALSE
        WHERE
            ID_PERSONA = :ID_PERSONA;
    END

    UPDATE V_CONTACTOS_EMAIL
    SET 
        EMAIL       = :EMAIL, 
        ESTADO      = :ESTADO, 
        FECHA       = CURRENT_DATE,
        POR_DEFECTO = :POR_DEFECTO
    WHERE
        ID          = :ID;
    
    POST_EVENT 'EVENT_CORREO';
END^
SET TERM ;^

/* SP_U_CONTACTO_TEL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTACTO_TEL (
	ID TYPE OF COLUMN CONTACTOS_TEL.ID,
	TELEFONO TYPE OF COLUMN CONTACTOS_TEL.TELEFONO,
	TIPO TYPE OF COLUMN CONTACTOS_TEL.TIPO,
	ESTADO TYPE OF COLUMN CONTACTOS_TEL.ESTADO,
	POR_DEFECTO TYPE OF COLUMN CONTACTOS_TEL.POR_DEFECTO
) 
SQL SECURITY DEFINER
AS
BEGIN
    /*
    TODO Crear o pensar en validaciones que permitan realizar actualizaciones en los 
    almacen.
    */
    
    UPDATE V_CONTACTOS_TEL
    SET 
        TELEFONO        = :TELEFONO, 
        TIPO            = :TIPO, 
        FECHA           = CURRENT_DATE,
        ESTADO          = :ESTADO, 
        POR_DEFECTO     = :POR_DEFECTO
    WHERE
        ID              = :ID;
    POST_EVENT 'EVENT_TELEFONO';
END^
SET TERM ;^

/* SP_U_CONTROL_CONSULTA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_CONTROL_CONSULTA (
	ID TYPE OF COLUMN CONTROL_CONSULTA.ID,
	USER_NAME TYPE OF COLUMN CONTROL_CONSULTA.USER_NAME,
	CANTIDAD_PACIENTE TYPE OF COLUMN CONTROL_CONSULTA.CANTIDAD_PACIENTE,
	DIA TYPE OF COLUMN CONTROL_CONSULTA.DIA,
	INICIAL TYPE OF COLUMN CONTROL_CONSULTA.INICIAL,
	FINAL TYPE OF COLUMN CONTROL_CONSULTA.FINAL,
	ESTADO TYPE OF COLUMN CONTROL_CONSULTA.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN

    --TODO Crear validaciones para modificar un control de consulta.
     
    UPDATE V_CONTROL_CONSULTA 
    SET 
        USER_NAME = :USER_NAME, 
        CANTIDAD_PACIENTE = :CANTIDAD_PACIENTE, 
        DIA = :DIA, 
        INICIAL = :INICIAL, 
        FINAL = :FINAL, 
        ESTADO = :ESTADO
    WHERE
        ID = :ID;
END^
SET TERM ;^

/* SP_U_DEPARTAMENTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_DEPARTAMENTO (
	ID TYPE OF COLUMN DEPARTAMENTOS.ID,
	NOMBRE TYPE OF COLUMN DEPARTAMENTOS.NOMBRE,
	DESCRIPCION TYPE OF COLUMN DEPARTAMENTOS.DESCRIPCION,
	ESTADO TYPE OF COLUMN DEPARTAMENTOS.ESTADO
) 
AS
BEGIN
    UPDATE DEPARTAMENTOS
    SET 
        NOMBRE = :NOMBRE, 
        DESCRIPCION = :DESCRIPCION, 
        ESTADO = :ESTADO
    WHERE
        ID = :ID;
    
    POST_EVENT 'EVENT_DEPARTAMENTO';
END^
SET TERM ;^

/* SP_U_DEUDA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_DEUDA (
	ID_DEUDA TYPE OF COLUMN M_DEUDAS.ID,
	CONCEPTO TYPE OF COLUMN M_DEUDAS.CONCEPTO,
	MONTO TYPE OF COLUMN M_DEUDAS.MONTO
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF((SELECT DISTINCT(1) 
          FROM V_M_DEUDAS 
          WHERE ID = :ID_DEUDA) IS NULL)THEN
            EXCEPTION E_DEUDA_NO_ENCONTRADA;
    
     UPDATE V_M_DEUDAS
     SET 
          CONCEPTO  = :CONCEPTO,
          MONTO     = :MONTO
     WHERE
          ID        = :ID_DEUDA;
          
    POST_EVENT 'EVENT_DEUDA';
END^
SET TERM ;^

/* SP_U_D_GUIA_VIGILANCIA_DESARROLLO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_D_GUIA_VIGILANCIA_DESARROLLO (
	ID TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID,
	ID_GVD TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_GVD,
	ID_PACIENTE TYPE OF COLUMN D_GUIA_VIGILANCIA_DESARROLLO.ID_PACIENTE
) 
SQL SECURITY DEFINER
AS
BEGIN
    /**
        TODO 10/12/2024 
        1) Debe validarse que el paciente este activo.
        2) Que la edad del paciente correspondar a la guia de vigilancia.
        3) entre otras cosas... 
    */
    UPDATE V_D_GUIA_VIGILANCIA_DESARROLLO
    SET 
        ID_GVD = :ID_GVD, 
        ID_PACIENTE = :ID_PACIENTE
    WHERE
        ID = :ID;
END^
SET TERM ;^

/* SP_U_R_PADRE_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_R_PADRE_ESTUDIANTE (
	ID TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_PADRE_O_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_ESTUDIANTE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_ESTUDIANTE
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE V_RELACION_PADRE_ESTUDIANTE
    SET 
        ID_PADRE_O_MADRE    = :ID_PADRE_O_MADRE, 
        ID_ESTUDIANTE       = :ID_ESTUDIANTE
    WHERE
        ID                  = :ID;
END^
SET TERM ;^

/* SP_U_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA (
	ID TYPE OF COLUMN PERSONAS.ID,
	PERSONA TYPE OF COLUMN PERSONAS.PERSONA,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN

    IF(:ID = 0)THEN
        EXCEPTION E_UPDATE_GENERICO;
     
    UPDATE V_PERSONAS
    SET 
        PERSONA = :PERSONA, 
        PNOMBRE = :PNOMBRE, 
        SNOMBRE = :SNOMBRE, 
        APELLIDOS = :APELLIDOS, 
        SEXO = :SEXO, 
        FECHA_NACIMIENTO = :FECHA_NACIMIENTO, 
        FECHA_HORA_ULTIMO_UPDATE = CURRENT_DATE, 
        ESTADO = :ESTADO
    WHERE
        ID = :ID;
    
    POST_EVENT 'EVENT_CLIENTE';
    POST_EVENT 'EVENT_PROVEEDOR';
    POST_EVENT 'EVENT_ESTUDIANTE';
    POST_EVENT 'EVENT_PADRE';

END^
SET TERM ;^

/* SP_U_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES.ID,
	ID_R_PADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_PADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	ID_R_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID,
	ID_MADRE TYPE OF COLUMN RELACION_PADRE_ESTUDIANTE.ID_PADRE_O_MADRE,
	PNOMBRE TYPE OF COLUMN PERSONAS.PNOMBRE,
	SNOMBRE TYPE OF COLUMN PERSONAS.SNOMBRE,
	APELLIDOS TYPE OF COLUMN PERSONAS.APELLIDOS,
	SEXO TYPE OF COLUMN PERSONAS.SEXO,
	FECHA_NACIMIENTO TYPE OF COLUMN PERSONAS.FECHA_NACIMIENTO,
	ESTADO TYPE OF COLUMN PERSONAS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
     
     EXECUTE PROCEDURE SP_U_PERSONA (
            :ID, 
            'F', 
            :PNOMBRE, 
            :SNOMBRE, 
            :APELLIDOS, 
            :SEXO, 
            :FECHA_NACIMIENTO,
            :ESTADO
     );
    
     EXECUTE PROCEDURE SP_U_R_PADRE_ESTUDIANTE (:ID_R_PADRE, :ID_PADRE, :ID);
     EXECUTE PROCEDURE SP_U_R_PADRE_ESTUDIANTE (:ID_R_MADRE, :ID_MADRE, :ID);
END^
SET TERM ;^

/* SP_U_FACTURA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FACTURA (
	ID TYPE OF COLUMN M_FACTURAS.ID,
	ID_CONTACTOS_TEL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_TEL,
	ID_CONTACTOS_DIRECCIONES TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_DIRECCIONES,
	ID_CONTACTOS_EMAIL TYPE OF COLUMN M_FACTURAS.ID_CONTACTOS_EMAIL,
	ID_TURNO TYPE OF COLUMN M_FACTURAS.ID_TURNO,
	ESTADO_FACTURA TYPE OF COLUMN M_FACTURAS.ESTADO_FACTURA,
	NOMBRE_TEMP TYPE OF COLUMN M_FACTURAS.NOMBRE_TEMP
) 
SQL SECURITY DEFINER
AS
BEGIN
    --Validar que el turno esta habilitado
     IF((SELECT DISTINCT(1) 
         FROM V_TURNOS t 
         WHERE t.ID = :ID_TURNO AND 
                t.ESTADO) IS NULL)THEN
        EXCEPTION E_TURNO_CERRADO;
     
     --Validamos que el telefono del usuario esté activo
     IF(:ID_CONTACTOS_TEL <> 0 AND 
          (SELECT DISTINCT(1) 
               FROM V_CONTACTOS_TEL
               WHERE ID = :ID_CONTACTOS_TEL AND ESTADO) IS NULL)THEN
                    EXCEPTION E_TELEFONO_INACTIVO;
          
     
     
     --Validamos que el correo del usuario esté activo
     IF(:ID_CONTACTOS_EMAIL <> 0 AND 
          (SELECT DISTINCT(1) 
               FROM V_CONTACTOS_EMAIL
               WHERE ID = :ID_CONTACTOS_EMAIL AND ESTADO) IS NULL)THEN
                    EXCEPTION E_CORREO_INACTIVO;
     
     
     --Validamos que la direccion del usuario esté activa
     IF(:ID_CONTACTOS_DIRECCIONES <> 0 AND 
          (SELECT DISTINCT(1) 
               FROM V_CONTACTOS_DIRECCIONES
               WHERE ID = :ID_CONTACTOS_DIRECCIONES AND ESTADO) IS NULL)THEN
                    EXCEPTION E_DIRECCION_INACTIVO;
                    
     UPDATE V_M_FACTURAS 
     SET 
          ID_CONTACTOS_TEL          = :ID_CONTACTOS_TEL, 
          ID_CONTACTOS_DIRECCIONES  = :ID_CONTACTOS_DIRECCIONES, 
          ID_CONTACTOS_EMAIL        = :ID_CONTACTOS_EMAIL, 
          ESTADO_FACTURA            = :ESTADO_FACTURA, 
          NOMBRE_TEMP               = :NOMBRE_TEMP, 
          USER_NAME                 = CURRENT_USER
     WHERE
          ID                        = :ID;
     
     
END^
SET TERM ;^

/* SP_U_FOTO_PERSONA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FOTO_PERSONA (
	ID TYPE OF COLUMN FOTO_PERSONA.ID,
	ID_PERSONA TYPE OF COLUMN FOTO_PERSONA.ID_PERSONA,
	FOTO TYPE OF COLUMN FOTO_PERSONA.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PERSONA.ACTUAL
) 
SQL SECURITY DEFINER
AS
BEGIN
    --Si actual es verdadero
    IF (:ACTUAL) THEN BEGIN
        --Entonces cambiamos todos los actuales en el sistema a falso.
        UPDATE V_FOTO_PERSONA
        SET 
            ACTUAL = FALSE
        WHERE
            ID_PERSONA = :ID_PERSONA;
    END

    IF((SELECT 1 FROM V_FOTO_PERSONA WHERE ID_PERSONA = :ID_PERSONA AND ACTUAL) IS NULL)THEN
        ACTUAL = TRUE;

    --Se pasa actualizar la foto de la persona con el valor de actual.
    --Tambian se cambia la imagen.
    UPDATE V_FOTO_PERSONA
    SET 
        FOTO = :FOTO, 
        ACTUAL = :ACTUAL
    WHERE
        ID = :ID;
END^
SET TERM ;^

/* SP_U_FOTO_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_FOTO_PRODUCTO (
	ID TYPE OF COLUMN FOTO_PRODUCTO.ID,
	ID_PRODUCTO TYPE OF COLUMN FOTO_PRODUCTO.ID_PRODUCTO,
	FOTO TYPE OF COLUMN FOTO_PRODUCTO.FOTO,
	ACTUAL TYPE OF COLUMN FOTO_PRODUCTO.ACTUAL
) 
SQL SECURITY DEFINER
AS
BEGIN
    --Si actual es verdadero
    IF (:ACTUAL) THEN BEGIN
        --Entonces cambiamos todos los actuales en el sistema a falso.
        UPDATE V_FOTO_PRODUCTO
        SET 
            ACTUAL = FALSE
        WHERE
            ID_PRODUCTO = :ID_PRODUCTO;
    END

    IF((SELECT 1 FROM V_FOTO_PRODUCTO WHERE ID_PRODUCTO = :ID_PRODUCTO AND ACTUAL) IS NULL)THEN
        ACTUAL = TRUE;

    --Se pasa actualizar la foto de la persona con el valor de actual.
    --Tambian se cambia la imagen.
    UPDATE V_FOTO_PRODUCTO
    SET 
        FOTO = :FOTO, 
        ACTUAL = :ACTUAL
    WHERE
        ID = :ID;
END^
SET TERM ;^

/* SP_U_GENERAL */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_GENERAL (
	ID TYPE OF COLUMN GENERALES.ID_PERSONA,
	CEDULA TYPE OF COLUMN GENERALES.CEDULA,
	ID_TIPO_SANGRE TYPE OF COLUMN GENERALES.ID_TIPO_SANGRE,
	ESTADO_CIVIL TYPE OF COLUMN GENERALES.ESTADO_CIVIL
) 
SQL SECURITY DEFINER
AS
BEGIN
    
    
    UPDATE V_GENERALES
    SET 
        CEDULA          = :CEDULA, 
        ID_TIPO_SANGRE  = :ID_TIPO_SANGRE, 
        ESTADO_CIVIL    = :ESTADO_CIVIL
    WHERE
        ID_PERSONA      = :ID;
END^
SET TERM ;^

/* SP_U_HORARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_HORARIO (
	ID TYPE OF COLUMN HORARIOS.ID,
	DESCRIPCION TYPE OF COLUMN HORARIOS.DESCRIPCION,
	HORA TYPE OF COLUMN HORARIOS.HORA,
	TOLERANCIA TYPE OF COLUMN HORARIOS.TOLERANCIA,
	ESTADO TYPE OF COLUMN HORARIOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE V_HORARIOS a
    SET 
        a.DESCRIPCION = 'DESCRIPCION*', 
        a.HORA = 'HORA*', 
        a.TOLERANCIA = 'TOLERANCIA*', 
        a.ESTADO = 'ESTADO'
    WHERE
        a.ID = :ID;
    POST_EVENT 'EVENT_HORARIO';
END^
SET TERM ;^

/* SP_U_HUELLA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_HUELLA (
	ID TYPE OF COLUMN HUELLAS.ID,
	TIPO_DEDO TYPE OF COLUMN HUELLAS.TIPO_DEDO,
	HUELLA TYPE OF COLUMN HUELLAS.HUELLA
) 
AS
BEGIN
    UPDATE V_HUELLAS
    SET 
        TIPO_DEDO = :TIPO_DEDO, 
        HUELLA = :HUELLA
    WHERE
        ID = :ID;
    POST_EVENT 'EVENT_HUELLA';
END^
SET TERM ;^

/* SP_U_METRICA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_METRICA (
	ID TYPE OF COLUMN METRICAS.ID,
	PESOKG TYPE OF COLUMN METRICAS.PESOKG,
	ESTATURAMETRO TYPE OF COLUMN METRICAS.ESTATURAMETRO,
	ESCEFALO TYPE OF COLUMN METRICAS.ESCEFALO,
	ENF_DETECT TYPE OF COLUMN METRICAS.ENF_DETECT,
	HALLAZGOS_POS TYPE OF COLUMN METRICAS.HALLAZGOS_POS,
	ID_DIAG TYPE OF COLUMN METRICAS.ID_DIAG,
	TX TYPE OF COLUMN METRICAS.TX,
	COMPLEMENTO TYPE OF COLUMN METRICAS.COMPLEMENTO,
	IMAGEN_TEXTO TYPE OF COLUMN METRICAS.IMAGEN_TEXTO
) 
AS
BEGIN
    /**
        TODO 13/12/2024 Deben hacerse validaciones para cuando la CONSULTA esta cerrada ya.
    */
    UPDATE V_METRICAS
    SET 
        PESOKG = :PESOKG, 
        ESTATURAMETRO = :ESTATURAMETRO, 
        ESCEFALO = :ESCEFALO, 
        ENF_DETECT = :ENF_DETECT, 
        HALLAZGOS_POS = :HALLAZGOS_POS, 
        ID_DIAG = :ID_DIAG, 
        TX = :TX, 
        COMPLEMENTO = :COMPLEMENTO, 
        IMAGEN_TEXTO = :IMAGEN_TEXTO
    WHERE
        ID = :ID;
END^
SET TERM ;^

/* SP_U_M_ENTRADA_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_M_ENTRADA_PRODUCTO (
	ID TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID,
	ID_PROVEEDOR TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_PROVEEDOR,
	ID_ALMACEN TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ID_ALMACEN,
	COD_FACTURA TYPE OF COLUMN M_ENTRADA_PRODUCTOS.COD_FACTURA,
	ESTADO TYPE OF COLUMN M_ENTRADA_PRODUCTOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    
    IF((SELECT ESTADO FROM V_PERSONAS WHERE ID = :ID_PROVEEDOR) IS FALSE)THEN
        EXCEPTION E_PROVEEDOR_INACTIVO USING(:ID_PROVEEDOR);
        
    IF((SELECT ESTADO FROM V_ALMACENES WHERE ID = :ID_ALMACEN) IS FALSE)THEN
        EXCEPTION E_ALMACEN_INACTIVO USING(:ID_ALMACEN);

    UPDATE V_M_ENTRADA_PRODUCTOS a
    SET 
        a.ID_PROVEEDOR = :ID_PROVEEDOR, 
        a.ID_ALMACEN = :ID_ALMACEN, 
        a.COD_FACTURA = :COD_FACTURA,
        a.ESTADO = :ESTADO
    WHERE
        a.ID = :ID;

END^
SET TERM ;^

/* SP_U_PERSONA_EMPLEADO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_EMPLEADO (
	ID TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID,
	ID_CARGO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.ID_CARGO,
	SUELDO_BRUTO TYPE OF COLUMN PERSONAS_EMPLEADOS_ATR.SUELDO_BRUTO
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
        
    UPDATE V_PERSONAS_EMPLEADOS_ATR
    SET 
        ID_CARGO = :ID_CARGO,
        SUELDO_BRUTO = :SUELDO_BRUTO
    WHERE
        ID = :ID;
     
    POST_EVENT 'EVENT_EMPLEADO';
END^
SET TERM ;^

/* SP_U_PERSONA_ESTUDIANTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_ESTUDIANTE (
	ID TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.ID,
	MATRICULA TYPE OF COLUMN PERSONAS_ESTUDIANTES_ATR.MATRICULA
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
        
    UPDATE V_PERSONAS_ESTUDIANTES_ATR
    SET 
        MATRICULA  = :MATRICULA
    WHERE
        ID      = :ID;
END^
SET TERM ;^

/* SP_U_PERSONA_PACIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_PACIENTE (
	ID TYPE OF COLUMN PERSONAS_PACIENTES.ID,
	CESAREA TYPE OF COLUMN PERSONAS_PACIENTES_ATR.CESAREA,
	TIEMPO_GESTACION TYPE OF COLUMN PERSONAS_PACIENTES_ATR.TIEMPO_GESTACION,
	FUMADOR TYPE OF COLUMN PERSONAS_PACIENTES_ATR.FUMADOR
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
        
    UPDATE V_PERSONAS_PACIENTES_ATR
    SET 
        CESAREA             = :CESAREA, 
        TIEMPO_GESTACION    = :TIEMPO_GESTACION,
        FUMADOR             = :FUMADOR
    WHERE
        ID                  = :ID;
END^
SET TERM ;^

/* SP_U_PERSONA_PROVEEDOR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PERSONA_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.ID,
	CODIGO TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.CODIGO
) 
SQL SECURITY DEFINER
AS
BEGIN
    IF(:ID = 0)THEN
        EXCEPTION E_DELETE_GENERICO;
        
    UPDATE V_PERSONAS_PROVEEDORES_ATR
    SET 
        CODIGO  = :CODIGO
    WHERE
        ID      = :ID;
        
END^
SET TERM ;^

/* SP_U_PRECIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PRECIO (
	ID TYPE OF COLUMN PRECIOS.ID,
	ID_PRODUCTO TYPE OF COLUMN PRECIOS.ID_PRODUCTO,
	ID_TIPO_PRECIO TYPE OF COLUMN PRECIOS.ID_TIPO_PRECIO,
	ID_TIPO_IMPUESTO TYPE OF COLUMN PRECIOS.ID_TIPO_IMPUESTO,
	PRECIO TYPE OF COLUMN PRECIOS.PRECIO,
	MONEDA TYPE OF COLUMN PRECIOS.MONEDA,
	FECHA_INICIO TYPE OF COLUMN PRECIOS.FECHA_INICIO,
	FECHA_FIN TYPE OF COLUMN PRECIOS.FECHA_FIN,
	DESCUENTO TYPE OF COLUMN PRECIOS.DESCUENTO,
	COSTO_ENVIO TYPE OF COLUMN PRECIOS.COSTO_ENVIO,
	ESTADO TYPE OF COLUMN PRECIOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN 
    --TODO hacer las validaciones antes de actualizar o cambiar algun valor. 
          
    UPDATE V_PRECIOS a
    SET 
        a.ID_PRODUCTO       = :ID_PRODUCTO, 
        a.ID_TIPO_PRECIO    = :ID_TIPO_PRECIO, 
        a.ID_TIPO_IMPUESTO  = :ID_TIPO_IMPUESTO, 
        a.PRECIO            = :PRECIO, 
        a.MONEDA            = :MONEDA, 
        a.FECHA_INICIO      = :FECHA_INICIO, 
        a.FECHA_FIN         = :FECHA_FIN, 
        a.DESCUENTO         = :DESCUENTO, 
        a.COSTO_ENVIO       = :COSTO_ENVIO,
        a.ESTADO            = :ESTADO
    WHERE
        a.ID = :ID;
END^
SET TERM ;^

/* SP_U_PRODUCTO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PRODUCTO (
	ID TYPE OF COLUMN PRODUCTOS.ID,
	ID_CATEGORIA TYPE OF COLUMN PRODUCTOS.ID_CATEGORIA,
	CODIGO TYPE OF COLUMN PRODUCTOS.CODIGO,
	DESCRIPCION TYPE OF COLUMN PRODUCTOS.DESCRIPCION,
	NOTA TYPE OF COLUMN PRODUCTOS.NOTA,
	ESTADO TYPE OF COLUMN PRODUCTOS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
     
     IF((SELECT DISTINCT(1) 
            FROM V_CATEGORIAS
            WHERE ID = :ID_CATEGORIA AND ESTADO IS FALSE) = 1)THEN
          EXCEPTION E_CATEGORIAS_INACTIVA;
     
     UPDATE V_PRODUCTOS
     SET 
          ID_CATEGORIA  = :ID_CATEGORIA, 
          CODIGO        = :CODIGO, 
          DESCRIPCION   = :DESCRIPCION, 
          NOTA          = :NOTA, 
          ESTADO        = :ESTADO
     WHERE
          ID            = :ID;

    POST_EVENT 'EVENT_PRODUCTO';
END^
SET TERM ;^

/* SP_U_PROVEEDOR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_PROVEEDOR (
	ID TYPE OF COLUMN PERSONAS.ID,
	CODIGO_PROVEEDOR TYPE OF COLUMN PERSONAS_PROVEEDORES_ATR.CODIGO
) 
SQL SECURITY DEFINER
AS
BEGIN
     UPDATE V_PERSONAS_PROVEEDORES_ATR
     SET 
          CODIGO    = :CODIGO_PROVEEDOR 
     WHERE
          ID        = :ID;
END^
SET TERM ;^

/* SP_U_R_PADRE_PACIENTE */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_R_PADRE_PACIENTE (
	ID TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID,
	ID_PADRE_O_MADRE TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID_PADRE_O_MADRE,
	ID_PACIENTE TYPE OF COLUMN RELACION_PADRE_PACIENTE.ID_PACIENTE
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE V_RELACION_PADRE_PACIENTE
    SET 
        ID_PADRE_O_MADRE    = :ID_PADRE_O_MADRE, 
        ID_PACIENTE         = :ID_PACIENTE
    WHERE
        ID                  = :ID;
END^
SET TERM ;^

/* SP_U_TANDA */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_TANDA (
	ID TYPE OF COLUMN TANDAS.ID,
	ANNO_INICIAL TYPE OF COLUMN TANDAS.ANNO_INICIAL,
	ANNO_FINAL TYPE OF COLUMN TANDAS.ANNO_FINAL,
	HORA_INICIO TYPE OF COLUMN TANDAS.HORA_INICIO,
	HORA_FINAL TYPE OF COLUMN TANDAS.HORA_FINAL,
	LUNES TYPE OF COLUMN TANDAS.LUNES,
	MARTES TYPE OF COLUMN TANDAS.MARTES,
	MIERCOLES TYPE OF COLUMN TANDAS.MIERCOLES,
	JUEVES TYPE OF COLUMN TANDAS.JUEVES,
	VIERNES TYPE OF COLUMN TANDAS.VIERNES,
	SABADOS TYPE OF COLUMN TANDAS.SABADOS,
	DOMINGOS TYPE OF COLUMN TANDAS.DOMINGOS,
	CANTIDAD_ESTUDIANTES TYPE OF COLUMN TANDAS.CANTIDAD_ESTUDIANTES,
	CON_EDAD TYPE OF COLUMN TANDAS.CON_EDAD,
	EDAD_MINIMA TYPE OF COLUMN TANDAS.EDAD_MINIMA,
	EDAD_MAXIMA TYPE OF COLUMN TANDAS.EDAD_MAXIMA,
	ESTADO TYPE OF COLUMN TANDAS.ESTADO
) 
SQL SECURITY DEFINER
AS
BEGIN
    UPDATE V_TANDAS 
    SET 
        ANNO_INICIAL            = :ANNO_INICIAL, 
        ANNO_FINAL              = :ANNO_FINAL, 
        HORA_INICIO             = :HORA_INICIO, 
        HORA_FINAL              = :HORA_FINAL, 
        LUNES                   = :LUNES, 
        MARTES                  = :MARTES, 
        MIERCOLES               = :MIERCOLES, 
        JUEVES                  = :JUEVES, 
        VIERNES                 = :VIERNES, 
        SABADOS                 = :SABADOS, 
        DOMINGOS                = :DOMINGOS, 
        CANTIDAD_ESTUDIANTES    = :CANTIDAD_ESTUDIANTES, 
        CON_EDAD                = :CON_EDAD, 
        EDAD_MINIMA             = :EDAD_MINIMA, 
        EDAD_MAXIMA             = :EDAD_MAXIMA, 
        ESTADO                  = :ESTADO
    WHERE
        ID                      = :ID;
END^
SET TERM ;^

/* SP_U_TURNO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_TURNO (
	ID TYPE OF COLUMN TURNOS.ID
) 
SQL SECURITY DEFINER
AS
BEGIN
     IF(EXISTS(SELECT 1 FROM V_TURNOS WHERE ID = :ID AND ESTADO IS FALSE))THEN 
          EXCEPTION E_TURNO_CERRADO;
     
     UPDATE V_TURNOS 
     SET 
          FECHA_HORA_FINAL = CURRENT_TIMESTAMP, 
          ESTADO = FALSE
     WHERE
          ID = :ID;
END^
SET TERM ;^

/* SP_U_USUARIO */
SET TERM ^;
CREATE OR ALTER PROCEDURE SP_U_USUARIO (
	USER_NAME TYPE OF COLUMN SEC$USERS.SEC$USER_NAME,
	CLAVE D_CLAVE,
	PNOMBRE TYPE OF COLUMN SEC$USERS.SEC$FIRST_NAME,
	SNOMBRE TYPE OF COLUMN SEC$USERS.SEC$MIDDLE_NAME,
	APELLIDOS TYPE OF COLUMN SEC$USERS.SEC$LAST_NAME,
	ESTADO TYPE OF COLUMN SEC$USERS.SEC$ACTIVE,
	ADMINISTRADOR TYPE OF COLUMN SEC$USERS.SEC$ADMIN,
	DESCRIPCION TYPE OF COLUMN SEC$USERS.SEC$DESCRIPTION,
	TAGS_ D_VARCHAR_MAX
) 
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID D_ID; 
DECLARE VARIABLE SQL_ D_VARCHAR_255;
BEGIN
     /*Validando que el usuario este registrado en la app*/
     IF((SELECT DISTINCT (1) 
          FROM VS_USUARIOS  
          WHERE TRIM(USERNAME) STARTING WITH UPPER(TRIM(:USER_NAME))) IS NULL)THEN
               EXCEPTION E_USUARIO_NO_ENCONTRADO;
     
          
     SQL_ = 'ALTER USER '||TRIM(:USER_NAME)||
            ' FIRSTNAME '''||:PNOMBRE||
            ''' MIDDLENAME '''||:SNOMBRE||
            ''' LASTNAME '''||:APELLIDOS||''' '||
            IIF(:ESTADO, ' ACTIVE ',' INACTIVE ')||
            IIF( TAGS_ = '', '', ' TAGS(' || TAGS_ || ') ' ) ||
            IIF(:ADMINISTRADOR, 'GRANT ','REVOKE ')||' ADMIN ROLE USING PLUGIN Srp;';
     
     EXECUTE STATEMENT (SQL_);
     
     IF(:CLAVE != '')THEN
     BEGIN
          SQL_ = 'ALTER USER '||:USER_NAME||' PASSWORD '''||:CLAVE||'''';
          EXECUTE STATEMENT SQL_;
     END
     
     SQL_ = 'COMMENT ON USER '||:USER_NAME||' IS '''||:DESCRIPCION||'''';
     
     EXECUTE STATEMENT SQL_;
     
     POST_EVENT 'EVENT_USUARIO';
     
     WHEN GDSCODE dsql_error DO BEGIN
        INSERT INTO T_PRUEBA (VALOR)
        VALUES (:SQL_);
     END
END^
SET TERM ;^

/* SYSTEM_ENCRIPTAR */
SET TERM ^;
CREATE OR ALTER PROCEDURE SYSTEM_ENCRIPTAR (
	TCTEXTO D_VARCHAR_MAX,
	TCACCION CHAR(1),
	TCNUMEROENCRIPTACION D_VARCHAR_255,
	TCNUMEROREPETICION D_VARCHAR_255
) 
RETURNS (
	FTCNUEVOTEXTO D_VARCHAR_MAX
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE lnI          SMALLINT;
DECLARE VARIABLE lnJ          SMALLINT;
DECLARE VARIABLE lnK          SMALLINT;
DECLARE VARIABLE lcCaracter   CHAR(1);
DECLARE VARIABLE lnAscii      SMALLINT;
DECLARE VARIABLE lnValor1     SMALLINT;
DECLARE VARIABLE lnValor2     SMALLINT;
DECLARE VARIABLE lnNuevoAscii SMALLINT;
BEGIN 
   ftcNuevoTexto = '';     -- El texto que se devolverá
   lnI = 1;
   lnJ = 1;
   lnK = 1;
 
   WHILE (:lnI <= CHAR_LENGTH(:tcTexto)) DO BEGIN
      lcCaracter    = SUBSTRING(:tcTexto FROM lnI FOR 1);     -- Obtiene el caracter que está en la posición lnI
      
      lnAscii       = ASCII_VAL(:lcCaracter);                  -- Halla el código ASCII del caracter
      
      lnValor1      = CAST(SUBSTRING(:tcNumeroEncriptacion FROM :lnJ FOR 1) AS SMALLINT);
      
      lnValor2      = CAST(SUBSTRING(:tcNumeroRepeticion FROM :lnK FOR 1) AS SMALLINT);
      
      lnNuevoAscii  = MOD((:lnAscii + IIF(:tcAccion = 'E', 1, -1) * :lnValor1 * :lnValor2), 256);
      
      lnNuevoAscii  = :lnNuevoAscii + IIF(:lnNuevoAscii < 0, 256, 0);
      
      ftcNuevoTexto = :ftcNuevoTexto || ASCII_CHAR(:lnNuevoAscii);
      
      lnI = :lnI + 1;
      
      lnJ = :lnJ + 1;
      
      lnJ = IIF(:lnJ > CHAR_LENGTH(:tcNumeroEncriptacion), 1, :lnJ);
      
      lnK = :lnK + 1;
      
      lnK = IIF(:lnK > CHAR_LENGTH(:tcNumeroRepeticion), 1, :lnK);
   END
   SUSPEND;
 
END^
SET TERM ;^

/* TEST */
SET TERM ^;
CREATE OR ALTER PROCEDURE TEST
RETURNS (
	RESULTADO D_VARCHAR_255
)
SQL SECURITY DEFINER
AS
DECLARE VARIABLE ID_ALMACEN TYPE OF COLUMN ALMACENES.ID ;
DECLARE VARIABLE ID_TURNO TYPE OF COLUMN TURNOS.ID;
BEGIN
    --INSERTING
    Resultado = 'Test de Insercion.';
    SUSPEND;
    
    Resultado = '   Test de Insercion de Almacen.';
    SUSPEND;
    ID_ALMACEN = (SELECT O_ID FROM SP_I_ALMACEN ('Procedimiento Test', 'Prueba escrita.', TRUE));
    
    
    --UPDATING
    Resultado = 'Test de Modificacion.';
    SUSPEND;
    
    Resultado = '   Test de actualizacion de almacen.';
    SUSPEND;
    EXECUTE PROCEDURE SP_U_ALMACEN (:ID_ALMACEN, 'Procedimiento Actualizado', 'Ha sido desactivado', FALSE);
    
    
    --DELETING
    Resultado = 'Test de Eliminacion.';
    SUSPEND;
    
    Resultado = '   Eliminado registros de almacen.';
    SUSPEND;
    EXECUTE PROCEDURE SP_D_ALMACEN (:ID_ALMACEN);
    
    --Otro
END^
SET TERM ;^

/* ----- Creating Table Triggers ----- */

/* ALMACENES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER ALMACENES_BI FOR ALMACENES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_ALMACENES_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_ALMACENES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_ALMACENES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* ALMACENES_DISPONIBLE_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER ALMACENES_DISPONIBLE_BI FOR ALMACENES_DISPONIBLE
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_ALMACENES_DISPONIBLE_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_ALMACENES_DISPONIBLE_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_ALMACENES_DISPONIBLE_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* ANTECEDENTES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER ANTECEDENTES_BI FOR ANTECEDENTES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_ANTECEDENTES_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_ANTECEDENTES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_ANTECEDENTES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* ARS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER ARS_BI FOR ARS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_ARS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_ARS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_ARS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* ASEGURADOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER ASEGURADOS_BI FOR ASEGURADOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_ASEGURADOS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_ASEGURADOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_ASEGURADOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* CARTONES_BINGO_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CARTONES_BINGO_BI FOR CARTONES_BINGO
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_CARTONES_BINGO_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_CARTONES_BINGO_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_CARTONES_BINGO_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* CATEGORIAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CATEGORIAS_BI FOR CATEGORIAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_CATEGORIAS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_CATEGORIAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_CATEGORIAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* CONSULTAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CONSULTAS_BI FOR CONSULTAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_CONSULTAS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_CONSULTAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_CONSULTAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* CONTACTOS_DIRECCIONES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_DIRECCIONES_BI FOR CONTACTOS_DIRECCIONES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
    IF (NEW.ID IS NULL OR NEW.ID = 0) THEN
        NEW.ID = GEN_ID(SEQ_CONTACTOS_DIRECCIONES_ID,1);
    ELSE BEGIN
        tmp = GEN_ID(SEQ_CONTACTOS_DIRECCIONES_ID, 0);
        if (tmp < new.ID) then
        tmp = GEN_ID(SEQ_CONTACTOS_DIRECCIONES_ID, new.ID-tmp);
    END
END^
SET TERM ;^

/* CONTACTOS_EMAIL_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_EMAIL_BI FOR CONTACTOS_EMAIL
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_CONTACTOS_EMAIL_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_CONTACTOS_EMAIL_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_CONTACTOS_EMAIL_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* CONTACTOS_TEL_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTACTOS_TEL_BI FOR CONTACTOS_TEL
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
	IF (NEW.ID IS NULL) THEN
	    NEW.ID = GEN_ID(SEQ_CONTACTOS_TEL_ID, 1);
	  ELSE
	BEGIN
		tmp = GEN_ID(SEQ_CONTACTOS_TEL_ID, 0);
		if (tmp < new.ID) then
		 tmp = GEN_ID(SEQ_CONTACTOS_TEL_ID, new.ID-tmp);
	END
END^
SET TERM ;^

/* CONTROL_CONSULTA_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER CONTROL_CONSULTA_BI FOR CONTROL_CONSULTA
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_CONTROL_CONSULTA_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_CONTROL_CONSULTA_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_CONTROL_CONSULTA_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* D_ANALISIS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER D_ANALISIS_BI FOR D_ANALISIS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_D_ANALISIS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_D_ANALISIS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_D_ANALISIS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* D_DEUDAS_PAGAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER D_DEUDAS_PAGAS_BI FOR D_DEUDAS_PAGAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_D_DEUDAS_PAGAS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_D_DEUDAS_PAGAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_D_DEUDAS_PAGAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* D_FACTURAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER D_FACTURAS_BI FOR D_FACTURAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_D_FACTURAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_D_FACTURAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_D_FACTURAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* D_GUIA_VIGILANCIA_DESARROLLO_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER D_GUIA_VIGILANCIA_DESARROLLO_BI FOR D_GUIA_VIGILANCIA_DESARROLLO
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_D_GUIA_VIGILANCIA_DESARROLLO_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_D_GUIA_VIGILANCIA_DESARROLLO_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_D_GUIA_VIGILANCIA_DESARROLLO_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* D_RECETAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER D_RECETAS_BI FOR D_RECETAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_D_RECETAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_D_RECETAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_D_RECETAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* FOTO_PERSONA_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER FOTO_PERSONA_BI FOR FOTO_PERSONA
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_FOTO_PERSONA_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_FOTO_PERSONA_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_FOTO_PERSONA_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* FOTO_PRODUCTO_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER FOTO_PRODUCTO_BI FOR FOTO_PRODUCTO
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_FOTO_PRODUCTO_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_FOTO_PRODUCTO_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_FOTO_PRODUCTO_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* GENERALES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER GENERALES_BI FOR GENERALES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_GENERALES_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_GENERALES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_GENERALES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* HORARIOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER HORARIOS_BI FOR HORARIOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_HORARIOS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_HORARIOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_HORARIOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* HUELLAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER HUELLAS_BI FOR HUELLAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_HUELLAS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_HUELLAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_HUELLAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* INSCRIPCIONES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER INSCRIPCIONES_BI FOR INSCRIPCIONES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_INSCRIPCIONES_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_INSCRIPCIONES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_INSCRIPCIONES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* MENSAJES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER MENSAJES_BI FOR MENSAJES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_MENSAJES_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_MENSAJES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_MENSAJES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* METRICAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER METRICAS_BI FOR METRICAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_METRICAS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_METRICAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_METRICAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* MOVIES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER MOVIES_BI FOR MOVIES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_MOVIES_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_MOVIES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_MOVIES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* M_ANALISIS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER M_ANALISIS_BI FOR M_ANALISIS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_M_ANALISIS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_M_ANALISIS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_M_ANALISIS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* M_DEUDAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER M_DEUDAS_BI FOR M_DEUDAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_M_DEUDAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_M_DEUDAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_M_DEUDAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* M_ENTRADA_PRODUCTOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER M_ENTRADA_PRODUCTOS_BI FOR M_ENTRADA_PRODUCTOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_M_ENTRADA_PRODUCTOS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_M_ENTRADA_PRODUCTOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_M_ENTRADA_PRODUCTOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* M_FACTURAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER M_FACTURAS_BI FOR M_FACTURAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_M_FACTURAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_M_FACTURAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_M_FACTURAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* M_RECETAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER M_RECETAS_BI FOR M_RECETAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_M_RECETAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_M_RECETAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_M_RECETAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* PERSONAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER PERSONAS_BI FOR PERSONAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
    IF (NEW.ID IS NULL) THEN
        NEW.ID = GEN_ID(SEQ_PERSONAS_ID,1);
    ELSE
    BEGIN
        tmp = GEN_ID(SEQ_PERSONAS_ID, 0);
        if (tmp < new.ID) then
            tmp = GEN_ID(SEQ_PERSONAS_ID, new.ID-tmp);
    END
END^
SET TERM ;^

/* PRECIOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER PRECIOS_BI FOR PRECIOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_PRECIOS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_PRECIOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_PRECIOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* PRODUCTOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER PRODUCTOS_BI FOR PRODUCTOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_PRODUCTOS_ID,1);
ELSE
  BEGIN
    tmp = GEN_ID(SEQ_PRODUCTOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_PRODUCTOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* RELACION_PADRE_ESTUDIANTE_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER RELACION_PADRE_ESTUDIANTE_BI FOR RELACION_PADRE_ESTUDIANTE
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_RELACION_PADRE_ESTUDIANTE_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_RELACION_PADRE_ESTUDIANTE_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_RELACION_PADRE_ESTUDIANTE_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* RELACION_PADRE_PACIENTE_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER RELACION_PADRE_PACIENTE_BI FOR RELACION_PADRE_PACIENTE
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_RELACION_PADRE_PACIENTE_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_RELACION_PADRE_PACIENTE_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_RELACION_PADRE_PACIENTE_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* SINTOMAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER SINTOMAS_BI FOR SINTOMAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_SINTOMAS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_SINTOMAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_SINTOMAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* TANDAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER TANDAS_BI FOR TANDAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_TANDAS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_TANDAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_TANDAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* TURNOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER TURNOS_BI FOR TURNOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_TURNOS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_TURNOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_TURNOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_ANALISIS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_ANALISIS_BI FOR T_ANALISIS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
IF (NEW.ID IS NULL) THEN
NEW.ID = GEN_ID(SEQ_T_ANALISIS_ID,1);
  ELSE
  BEGIN
    tmp = GEN_ID(SEQ_T_ANALISIS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(SEQ_T_ANALISIS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_CODIGOS_POSTALES_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_CODIGOS_POSTALES_BI FOR T_CODIGOS_POSTALES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_CODIGOS_POSTALES_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_CODIGOS_POSTALES_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_CODIGOS_POSTALES_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_E_S_SYS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_E_S_SYS_BI FOR T_E_S_SYS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_E_S_SYS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_E_S_SYS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_E_S_SYS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_GUIA_VIGILANCIA_DESARROLLO_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_GUIA_VIGILANCIA_DESARROLLO_BI FOR T_GUIA_VIGILANCIA_DESARROLLO
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_GUIA_VIGILANCIA_DESARROLLO_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_GUIA_VIGILANCIA_DESARROLLO_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_GUIA_VIGILANCIA_DESARROLLO_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_IMPUESTOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_IMPUESTOS_BI FOR T_IMPUESTOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_IMPUESTOS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_IMPUESTOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_IMPUESTOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_MOTIVO_CONSULTA_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_MOTIVO_CONSULTA_BI FOR T_MOTIVO_CONSULTA
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_MOTIVO_CONSULTA_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_MOTIVO_CONSULTA_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_MOTIVO_CONSULTA_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_MUNICIPIOS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_MUNICIPIOS_BI FOR T_MUNICIPIOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_MUNICIPIOS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_MUNICIPIOS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_MUNICIPIOS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_PROVINCIAS_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_PROVINCIAS_BI FOR T_PROVINCIAS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_PROVINCIAS_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_PROVINCIAS_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_PROVINCIAS_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_PRUEBA_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_PRUEBA_BI FOR T_PRUEBA
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_PRUEBA_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_PRUEBA_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_PRUEBA_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* T_TIPOS_PRECIO_BI */
SET TERM ^;
CREATE OR ALTER TRIGGER T_TIPOS_PRECIO_BI FOR T_TIPOS_PRECIO
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID IS NULL) THEN
    NEW.ID = GEN_ID(GEN_T_TIPOS_PRECIO_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_T_TIPOS_PRECIO_ID, 0);
    if (tmp < new.ID) then
      tmp = GEN_ID(GEN_T_TIPOS_PRECIO_ID, new.ID-tmp);
  END
END^
SET TERM ;^

/* ----- Creating DB Triggers ----- */

/* AUTOROLE */
SET TERM ^;
CREATE OR ALTER TRIGGER AUTOROLE
ACTIVE ON CONNECT POSITION 1
AS 
DECLARE VARIABLE v_valor TYPE OF COLUMN VS_USUARIOS_TAGS.VALOR;
BEGIN
    IF(CURRENT_ROLE <> 'RRR_SOFTSURENA')THEN BEGIN
        --Consultar si el usuario contiene el atributo de auto_role en el sistema.
        FOR SELECT u.VALOR
        FROM VS_USUARIOS_TAGS u 
        WHERE TRIM(u.USUARIO) STARTING WITH TRIM(CURRENT_USER) AND
            TRIM(u.LLAVE) STARTING WITH TRIM('AUTO_ROLE') AND
            TRIM(u.VALOR) != '' AND
            TRIM(u.VALOR) IS NOT NULL
        INTO v_valor DO BEGIN
            --si lo tiene este decir cual es su auto role, para ponerlo set role nombreRole.
            IF((SELECT 1 FROM GET_ROLES WHERE ROL LIKE :v_valor) IS NULL)THEN
                EXCEPTION E_ROL_NO_ENCONTRADO;

            EXECUTE STATEMENT 'SET ROLE ' || :v_valor;
        END
    END
END^
SET TERM ;^

/* SYSTEM_SHAREWARE */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE
ACTIVE ON CONNECT POSITION 2
AS
DECLARE VARIABLE entrada D_BOOLEAN_T;
BEGIN    
    IF(CURRENT_ROLE NOT STARTING WITH 'RRR_SOFTSURENA')THEN
    BEGIN
        entrada = (SELECT F_CONEXION () FROM RDB$DATABASE);
                
        IF(entrada) THEN
            EXCEPTION E_EQUIPO_NO_REGISTRADO;
    END
END^
SET TERM ;^

/* SYSTEM_SHAREWARE2 */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE2
INACTIVE ON TRANSACTION START POSITION 0
AS
DECLARE VARIABLE entrada D_BOOLEAN_T;
BEGIN    
    IF(CURRENT_ROLE <> 'RRR_SOFTSURENA')THEN
    BEGIN
        entrada = (SELECT F_CONEXION () FROM RDB$DATABASE);
                
        IF(entrada) THEN
            EXCEPTION E_EQUIPO_NO_REGISTRADO;
    END
END^
SET TERM ;^

/* SYSTEM_SHAREWARE3 */
SET TERM ^;
CREATE OR ALTER TRIGGER SYSTEM_SHAREWARE3
INACTIVE ON TRANSACTION COMMIT POSITION 0
AS
DECLARE VARIABLE entrada D_BOOLEAN_T;
BEGIN    
    IF(CURRENT_ROLE <> 'RRR_SOFTSURENA')THEN
    BEGIN
        entrada = (SELECT F_CONEXION () FROM RDB$DATABASE);
                
        IF(entrada) THEN
            EXCEPTION E_EQUIPO_NO_REGISTRADO;
    END
END^
SET TERM ;^

/* ----- PRIMARY KEYs defining ----- */

/* ALMACENES.PK_ALMACENES_0 */
ALTER TABLE ALMACENES
	ADD CONSTRAINT PK_ALMACENES_0 PRIMARY KEY (ID);

/* ALMACENES_DISPONIBLE.PK_TURNO_ALMACENES_DISPONIBLE_0 */
ALTER TABLE ALMACENES_DISPONIBLE
	ADD CONSTRAINT PK_TURNO_ALMACENES_DISPONIBLE_0 PRIMARY KEY (ID);

/* ANTECEDENTES.PK_ANTECEDENTES_0 */
ALTER TABLE ANTECEDENTES
	ADD CONSTRAINT PK_ANTECEDENTES_0 PRIMARY KEY (ID);

/* ARS.PK_ARS_0 */
ALTER TABLE ARS
	ADD CONSTRAINT PK_ARS_0 PRIMARY KEY (ID);

/* ASEGURADOS.PK_ASEGURADOS_0 */
ALTER TABLE ASEGURADOS
	ADD CONSTRAINT PK_ASEGURADOS_0 PRIMARY KEY (ID);

/* CARGOS.PK_CARGOS_0 */
ALTER TABLE CARGOS
	ADD CONSTRAINT PK_CARGOS_0 PRIMARY KEY (ID);

/* CARTONES_BINGO.PK_CARTONES_BINGO_0 */
ALTER TABLE CARTONES_BINGO
	ADD CONSTRAINT PK_CARTONES_BINGO_0 PRIMARY KEY (ID);

/* CATEGORIAS.PK_CATEGORIAS_0 */
ALTER TABLE CATEGORIAS
	ADD CONSTRAINT PK_CATEGORIAS_0 PRIMARY KEY (ID);

/* CONSULTAS.PK_CONSULTAS_0 */
ALTER TABLE CONSULTAS
	ADD CONSTRAINT PK_CONSULTAS_0 PRIMARY KEY (ID);

/* CONTACTOS_DIRECCIONES.PK_CONTACTOS_DIRECCIONES_0 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT PK_CONTACTOS_DIRECCIONES_0 PRIMARY KEY (ID);

/* CONTACTOS_EMAIL.PK_CONTACTOS_EMAIL_0 */
ALTER TABLE CONTACTOS_EMAIL
	ADD CONSTRAINT PK_CONTACTOS_EMAIL_0 PRIMARY KEY (ID);

/* CONTACTOS_TEL.PK_CONTACTOS_TEL_0 */
ALTER TABLE CONTACTOS_TEL
	ADD CONSTRAINT PK_CONTACTOS_TEL_0 PRIMARY KEY (ID);

/* CONTROL_CONSULTA.PK_CONTROL_CONSULTA_0 */
ALTER TABLE CONTROL_CONSULTA
	ADD CONSTRAINT PK_CONTROL_CONSULTA_0 PRIMARY KEY (ID);

/* DEPARTAMENTOS.PK_DEPARTAMENTOS_0 */
ALTER TABLE DEPARTAMENTOS
	ADD CONSTRAINT PK_DEPARTAMENTOS_0 PRIMARY KEY (ID);

/* D_ANALISIS.PK_D_ANALISIS_0 */
ALTER TABLE D_ANALISIS
	ADD CONSTRAINT PK_D_ANALISIS_0 PRIMARY KEY (ID);

/* D_DEUDAS_PAGAS.PK_D_DEUDAS_PAGAS_0 */
ALTER TABLE D_DEUDAS_PAGAS
	ADD CONSTRAINT PK_D_DEUDAS_PAGAS_0 PRIMARY KEY (ID);

/* D_ENTRADA_PRODUCTOS.PK_D_ENTRADA_PRODUCTOS_0 */
ALTER TABLE D_ENTRADA_PRODUCTOS
	ADD CONSTRAINT PK_D_ENTRADA_PRODUCTOS_0 PRIMARY KEY (ID);

/* D_FACTURAS.PK_D_FACTURAS_0 */
ALTER TABLE D_FACTURAS
	ADD CONSTRAINT PK_D_FACTURAS_0 PRIMARY KEY (ID);

/* D_GUIA_VIGILANCIA_DESARROLLO.PK_D_GUIA_VIGILANCIA_DESARROLLO_0 */
ALTER TABLE D_GUIA_VIGILANCIA_DESARROLLO
	ADD CONSTRAINT PK_D_GUIA_VIGILANCIA_DESARROLLO_0 PRIMARY KEY (ID);

/* D_MOTIVO_CONSULTA.PK_D_MOTIVO_CONSULTA_0 */
ALTER TABLE D_MOTIVO_CONSULTA
	ADD CONSTRAINT PK_D_MOTIVO_CONSULTA_0 PRIMARY KEY (ID);

/* D_RECETAS.PK_D_RECETAS_0 */
ALTER TABLE D_RECETAS
	ADD CONSTRAINT PK_D_RECETAS_0 PRIMARY KEY (ID);

/* ERRORES.PK_ERRORES */
ALTER TABLE ERRORES
	ADD CONSTRAINT PK_ERRORES PRIMARY KEY (ID);

/* FOTO_CATEGORIA.PK_FOTO_CATEGORIA_0 */
ALTER TABLE FOTO_CATEGORIA
	ADD CONSTRAINT PK_FOTO_CATEGORIA_0 PRIMARY KEY (ID);

/* FOTO_PERSONA.PK_FOTO_PERSONA_0 */
ALTER TABLE FOTO_PERSONA
	ADD CONSTRAINT PK_FOTO_PERSONA_0 PRIMARY KEY (ID);

/* FOTO_PRODUCTO.PK_FOTO_PRODUCTO_0 */
ALTER TABLE FOTO_PRODUCTO
	ADD CONSTRAINT PK_FOTO_PRODUCTO_0 PRIMARY KEY (ID);

/* GENERALES.PK_GENERALES_0 */
ALTER TABLE GENERALES
	ADD CONSTRAINT PK_GENERALES_0 PRIMARY KEY (ID);

/* HORARIOS.PK_HORARIOS_0 */
ALTER TABLE HORARIOS
	ADD CONSTRAINT PK_HORARIOS_0 PRIMARY KEY (ID);

/* HUELLAS.PK_HUELLAS_0 */
ALTER TABLE HUELLAS
	ADD CONSTRAINT PK_HUELLAS_0 PRIMARY KEY (ID);

/* INSCRIPCIONES.PK_INSCRIPCIONES_0 */
ALTER TABLE INSCRIPCIONES
	ADD CONSTRAINT PK_INSCRIPCIONES_0 PRIMARY KEY (ID);

/* MENSAJES.PK_MENSAJES_0 */
ALTER TABLE MENSAJES
	ADD CONSTRAINT PK_MENSAJES_0 PRIMARY KEY (ID);

/* METRICAS.PK_METRICAS_0 */
ALTER TABLE METRICAS
	ADD CONSTRAINT PK_METRICAS_0 PRIMARY KEY (ID);

/* MOVIES.PK_MOVIES_0 */
ALTER TABLE MOVIES
	ADD CONSTRAINT PK_MOVIES_0 PRIMARY KEY (ID);

/* M_ANALISIS.PK_M_ANALISIS_0 */
ALTER TABLE M_ANALISIS
	ADD CONSTRAINT PK_M_ANALISIS_0 PRIMARY KEY (ID);

/* M_DEUDAS.PK_M_DEUDAS_0 */
ALTER TABLE M_DEUDAS
	ADD CONSTRAINT PK_M_DEUDAS_0 PRIMARY KEY (ID);

/* M_ENTRADA_PRODUCTOS.PK_M_ENTRADA_PRODUCTOS_0 */
ALTER TABLE M_ENTRADA_PRODUCTOS
	ADD CONSTRAINT PK_M_ENTRADA_PRODUCTOS_0 PRIMARY KEY (ID);

/* M_FACTURAS.PK_M_FACTURAS_0 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT PK_M_FACTURAS_0 PRIMARY KEY (ID);

/* M_RECETAS.PK_M_RECETAS_0 */
ALTER TABLE M_RECETAS
	ADD CONSTRAINT PK_M_RECETAS_0 PRIMARY KEY (ID);

/* PERSONAS.PK_PERSONAS_0 */
ALTER TABLE PERSONAS
	ADD CONSTRAINT PK_PERSONAS_0 PRIMARY KEY (ID);

/* PERSONAS_CLIENTES.PK_PERSONAS_CLIENTES_0 */
ALTER TABLE PERSONAS_CLIENTES
	ADD CONSTRAINT PK_PERSONAS_CLIENTES_0 PRIMARY KEY (ID);

/* PERSONAS_CLIENTES_ATR.PK_PERSONAS_CLIENTES_ATR_0 */
ALTER TABLE PERSONAS_CLIENTES_ATR
	ADD CONSTRAINT PK_PERSONAS_CLIENTES_ATR_0 PRIMARY KEY (ID);

/* PERSONAS_EMPLEADOS.PK_PERSONAS_EMPLEADOS_0 */
ALTER TABLE PERSONAS_EMPLEADOS
	ADD CONSTRAINT PK_PERSONAS_EMPLEADOS_0 PRIMARY KEY (ID);

/* PERSONAS_EMPLEADOS_ATR.PK_PERSONAS_EMPLEADOS_ATR_0 */
ALTER TABLE PERSONAS_EMPLEADOS_ATR
	ADD CONSTRAINT PK_PERSONAS_EMPLEADOS_ATR_0 PRIMARY KEY (ID);

/* PERSONAS_ESTUDIANTES.PK_PERSONAS_ESTUDIANTES_0 */
ALTER TABLE PERSONAS_ESTUDIANTES
	ADD CONSTRAINT PK_PERSONAS_ESTUDIANTES_0 PRIMARY KEY (ID);

/* PERSONAS_ESTUDIANTES_ATR.PK_PERSONAS_ESTUDIANTES_ATR_0 */
ALTER TABLE PERSONAS_ESTUDIANTES_ATR
	ADD CONSTRAINT PK_PERSONAS_ESTUDIANTES_ATR_0 PRIMARY KEY (ID);

/* PERSONAS_PACIENTES.PK_PERSONAS_PACIENTES_0 */
ALTER TABLE PERSONAS_PACIENTES
	ADD CONSTRAINT PK_PERSONAS_PACIENTES_0 PRIMARY KEY (ID);

/* PERSONAS_PACIENTES_ATR.PK_PERSONAS_PACIENTES_ATR_0 */
ALTER TABLE PERSONAS_PACIENTES_ATR
	ADD CONSTRAINT PK_PERSONAS_PACIENTES_ATR_0 PRIMARY KEY (ID);

/* PERSONAS_PADRES.PK_PERSONAS_PADRES_0 */
ALTER TABLE PERSONAS_PADRES
	ADD CONSTRAINT PK_PERSONAS_PADRES_0 PRIMARY KEY (ID);

/* PERSONAS_PROVEEDORES.PK_PERSONAS_PROVEEDORES_0 */
ALTER TABLE PERSONAS_PROVEEDORES
	ADD CONSTRAINT PK_PERSONAS_PROVEEDORES_0 PRIMARY KEY (ID);

/* PERSONAS_PROVEEDORES_ATR.PK_PERSONAS_PROVEEDORES_ATR_0 */
ALTER TABLE PERSONAS_PROVEEDORES_ATR
	ADD CONSTRAINT PK_PERSONAS_PROVEEDORES_ATR_0 PRIMARY KEY (ID);

/* PRECIOS.PK_PRECIOS_0 */
ALTER TABLE PRECIOS
	ADD CONSTRAINT PK_PRECIOS_0 PRIMARY KEY (ID);

/* PRODUCTOS.PK_PRODUCTOS_0 */
ALTER TABLE PRODUCTOS
	ADD CONSTRAINT PK_PRODUCTOS_0 PRIMARY KEY (ID);

/* RELACION_PADRE_ESTUDIANTE.PK_RELACION_PADRE_ESTUDIANTE_0 */
ALTER TABLE RELACION_PADRE_ESTUDIANTE
	ADD CONSTRAINT PK_RELACION_PADRE_ESTUDIANTE_0 PRIMARY KEY (ID);

/* RELACION_PADRE_PACIENTE.PK_RELACION_PADRE_PACIENTE_0 */
ALTER TABLE RELACION_PADRE_PACIENTE
	ADD CONSTRAINT PK_RELACION_PADRE_PACIENTE_0 PRIMARY KEY (ID);

/* SINTOMAS.PK_SINTOMAS_0 */
ALTER TABLE SINTOMAS
	ADD CONSTRAINT PK_SINTOMAS_0 PRIMARY KEY (ID);

/* TANDAS.PK_TANDAS_0 */
ALTER TABLE TANDAS
	ADD CONSTRAINT PK_TANDAS_0 PRIMARY KEY (ID);

/* TURNOS.PK_TURNOS_0 */
ALTER TABLE TURNOS
	ADD CONSTRAINT PK_TURNOS_0 PRIMARY KEY (ID);

/* T_ANALISIS.PK_T_ANALISIS_0 */
ALTER TABLE T_ANALISIS
	ADD CONSTRAINT PK_T_ANALISIS_0 PRIMARY KEY (ID);

/* T_CODIGOS_POSTALES.PK_T_CODIGOS_POSTALES_0 */
ALTER TABLE T_CODIGOS_POSTALES
	ADD CONSTRAINT PK_T_CODIGOS_POSTALES_0 PRIMARY KEY (ID);

/* T_DISTRITOS_MUNICIPALES.PK_T_DISTRITOS_MUNICIPALES_0 */
ALTER TABLE T_DISTRITOS_MUNICIPALES
	ADD CONSTRAINT PK_T_DISTRITOS_MUNICIPALES_0 PRIMARY KEY (ID);

/* T_E_S_SYS.PK_T_E_S_SYS_0 */
ALTER TABLE T_E_S_SYS
	ADD CONSTRAINT PK_T_E_S_SYS_0 PRIMARY KEY (ID);

/* T_GUIA_VIGILANCIA_DESARROLLO.PK_T_GUIA_VIGILANCIA_DESARROLLO_0 */
ALTER TABLE T_GUIA_VIGILANCIA_DESARROLLO
	ADD CONSTRAINT PK_T_GUIA_VIGILANCIA_DESARROLLO_0 PRIMARY KEY (ID);

/* T_IMPUESTOS.PK_T_IMPUESTOS_0 */
ALTER TABLE T_IMPUESTOS
	ADD CONSTRAINT PK_T_IMPUESTOS_0 PRIMARY KEY (ID);

/* T_MOTIVO_CONSULTA.PK_T_MOTIVO_CONSULTA_0 */
ALTER TABLE T_MOTIVO_CONSULTA
	ADD CONSTRAINT PK_T_MOTIVO_CONSULTA_0 PRIMARY KEY (ID);

/* T_MUNICIPIOS.PK_T_MUNICIPIOS_0 */
ALTER TABLE T_MUNICIPIOS
	ADD CONSTRAINT PK_T_MUNICIPIOS_0 PRIMARY KEY (ID);

/* T_PLAN_CUENTA_CONTABLE.PK_T_PLAN_CUENTA_CONTABLE_0 */
ALTER TABLE T_PLAN_CUENTA_CONTABLE
	ADD CONSTRAINT PK_T_PLAN_CUENTA_CONTABLE_0 PRIMARY KEY (ID);

/* T_PROVINCIAS.PK_T_PROVINCIAS_0 */
ALTER TABLE T_PROVINCIAS
	ADD CONSTRAINT PK_T_PROVINCIAS_0 PRIMARY KEY (ID);

/* T_PRUEBA.PK_T_PRUEBA_0 */
ALTER TABLE T_PRUEBA
	ADD CONSTRAINT PK_T_PRUEBA_0 PRIMARY KEY (ID);

/* T_TIPOS_PRECIO.PK_T_TIPOS_PRECIO_0 */
ALTER TABLE T_TIPOS_PRECIO
	ADD CONSTRAINT PK_T_TIPOS_PRECIO_0 PRIMARY KEY (ID);

/* T_TIPOS_SANGRE.PK_T_TIPOS_SANGRE_0 */
ALTER TABLE T_TIPOS_SANGRE
	ADD CONSTRAINT PK_T_TIPOS_SANGRE_0 PRIMARY KEY (ID);

/* HTE_MOVIES.PK_HTE_MOVIES_0 */
ALTER TABLE HTE_MOVIES
	ADD CONSTRAINT PK_HTE_MOVIES_0 PRIMARY KEY ("YEAR");

/* ----- UNIQUE KEYs defining ----- */

/* ALMACENES.UNQ_ALMACENES_0 */
ALTER TABLE ALMACENES
	ADD CONSTRAINT UNQ_ALMACENES_0 UNIQUE (NOMBRE);

/* ARS.UNQ_ARS_0 */
ALTER TABLE ARS
	ADD CONSTRAINT UNQ_ARS_0 UNIQUE (DESCRIPCION);

/* ASEGURADOS.UNQ_ASEGURADOS_0 */
ALTER TABLE ASEGURADOS
	ADD CONSTRAINT UNQ_ASEGURADOS_0 UNIQUE (NO_NSS);

/* CARGOS.UNQ_CARGOS_0 */
ALTER TABLE CARGOS
	ADD CONSTRAINT UNQ_CARGOS_0 UNIQUE (NOMBRE);

/* CARTONES_BINGO.UNQ_CARTONES_BINGO_0 */
ALTER TABLE CARTONES_BINGO
	ADD CONSTRAINT UNQ_CARTONES_BINGO_0 UNIQUE (CARTON_HASH);

/* CATEGORIAS.UNQ_CATEGORIAS_0 */
ALTER TABLE CATEGORIAS
	ADD CONSTRAINT UNQ_CATEGORIAS_0 UNIQUE (DESCRIPCION);

/* CONTACTOS_EMAIL.UNQ_CONTACTOS_EMAIL_0 */
ALTER TABLE CONTACTOS_EMAIL
	ADD CONSTRAINT UNQ_CONTACTOS_EMAIL_0 UNIQUE (ID_PERSONA, EMAIL);

/* CONTACTOS_EMAIL.UNQ_CONTACTOS_EMAIL_1 */
ALTER TABLE CONTACTOS_EMAIL
	ADD CONSTRAINT UNQ_CONTACTOS_EMAIL_1 UNIQUE (EMAIL);

/* CONTACTOS_TEL.UNQ_CONTACTOS_TEL_0 */
ALTER TABLE CONTACTOS_TEL
	ADD CONSTRAINT UNQ_CONTACTOS_TEL_0 UNIQUE (ID_PERSONA, TELEFONO);

/* DEPARTAMENTOS.UNQ_DEPARTAMENTOS_0 */
ALTER TABLE DEPARTAMENTOS
	ADD CONSTRAINT UNQ_DEPARTAMENTOS_0 UNIQUE (NOMBRE);

/* GENERALES.UNQ_GENERALES_0 */
ALTER TABLE GENERALES
	ADD CONSTRAINT UNQ_GENERALES_0 UNIQUE (CEDULA);

/* GENERALES.UNQ_GENERALES_1 */
ALTER TABLE GENERALES
	ADD CONSTRAINT UNQ_GENERALES_1 UNIQUE (ID_PERSONA);

/* PERSONAS_ESTUDIANTES_ATR.UNQ_PERSONAS_ESTUDIANTES_0 */
ALTER TABLE PERSONAS_ESTUDIANTES_ATR
	ADD CONSTRAINT UNQ_PERSONAS_ESTUDIANTES_0 UNIQUE (MATRICULA);

/* PERSONAS_PROVEEDORES_ATR.UNQ_PERSONAS_PROVEEDORES_ATR_0 */
ALTER TABLE PERSONAS_PROVEEDORES_ATR
	ADD CONSTRAINT UNQ_PERSONAS_PROVEEDORES_ATR_0 UNIQUE (CODIGO);

/* PRODUCTOS.UNQ_PRODUCTOS_0 */
ALTER TABLE PRODUCTOS
	ADD CONSTRAINT UNQ_PRODUCTOS_0 UNIQUE (CODIGO);

/* PRODUCTOS.UNQ_PRODUCTOS_1 */
ALTER TABLE PRODUCTOS
	ADD CONSTRAINT UNQ_PRODUCTOS_1 UNIQUE (DESCRIPCION);

/* RELACION_PADRE_ESTUDIANTE.UNQ_RELACION_PADRE_ESTUDIANTE_0 */
ALTER TABLE RELACION_PADRE_ESTUDIANTE
	ADD CONSTRAINT UNQ_RELACION_PADRE_ESTUDIANTE_0 UNIQUE (ID_PADRE_O_MADRE, ID_ESTUDIANTE);

/* RELACION_PADRE_PACIENTE.UNQ_RELACION_PADRE_PACIENTE_0 */
ALTER TABLE RELACION_PADRE_PACIENTE
	ADD CONSTRAINT UNQ_RELACION_PADRE_PACIENTE_0 UNIQUE (ID_PADRE_O_MADRE, ID_PACIENTE);

/* T_ANALISIS.UNQ_T_ANALISIS_0 */
ALTER TABLE T_ANALISIS
	ADD CONSTRAINT UNQ_T_ANALISIS_0 UNIQUE (NOMBRE_CORTO_ANALISIS);

/* T_ANALISIS.UNQ_T_ANALISIS_1 */
ALTER TABLE T_ANALISIS
	ADD CONSTRAINT UNQ_T_ANALISIS_1 UNIQUE (NOMBRE_ANALISIS);

/* T_MOTIVO_CONSULTA.UNQ_T_MOTIVO_CONSULTA_0 */
ALTER TABLE T_MOTIVO_CONSULTA
	ADD CONSTRAINT UNQ_T_MOTIVO_CONSULTA_0 UNIQUE (DESCRIPCION);

/* T_PLAN_CUENTA_CONTABLE.UNQ_T_PLAN_CUENTA_CONTABLE_0 */
ALTER TABLE T_PLAN_CUENTA_CONTABLE
	ADD CONSTRAINT UNQ_T_PLAN_CUENTA_CONTABLE_0 UNIQUE (PAIS, CODIGO_CUENTA_CONTABLE);

/* T_TIPOS_PRECIO.UNQ_T_TIPOS_PRECIO_0 */
ALTER TABLE T_TIPOS_PRECIO
	ADD CONSTRAINT UNQ_T_TIPOS_PRECIO_0 UNIQUE (NOMBRE);

/* ----- FOREIGN KEYs defining ----- */

/* ALMACENES_DISPONIBLE.FK_ALMACENES_DISPONIBLE_0 */
ALTER TABLE ALMACENES_DISPONIBLE
	ADD CONSTRAINT FK_ALMACENES_DISPONIBLE_0 FOREIGN KEY (ID_TURNO) REFERENCES TURNOS (ID);

/* ALMACENES_DISPONIBLE.FK_ALMACENES_DISPONIBLE_1 */
ALTER TABLE ALMACENES_DISPONIBLE
	ADD CONSTRAINT FK_ALMACENES_DISPONIBLE_1 FOREIGN KEY (ID_ALMACEN) REFERENCES ALMACENES (ID);

/* ANTECEDENTES.FK_ANTECEDENTES_0 */
ALTER TABLE ANTECEDENTES
	ADD CONSTRAINT FK_ANTECEDENTES_0 FOREIGN KEY (ID_CONSULTA) REFERENCES CONSULTAS (ID);

/* ASEGURADOS.FK_ASEGURADOS_0 */
ALTER TABLE ASEGURADOS
	ADD CONSTRAINT FK_ASEGURADOS_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID);

/* ASEGURADOS.FK_ASEGURADOS_1 */
ALTER TABLE ASEGURADOS
	ADD CONSTRAINT FK_ASEGURADOS_1 FOREIGN KEY (ID_ARS) REFERENCES ARS (ID);

/* CARGOS.FK_CARGOS_0 */
ALTER TABLE CARGOS
	ADD CONSTRAINT FK_CARGOS_0 FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES DEPARTAMENTOS (ID);

/* CONSULTAS.FK_CONSULTAS_0 */
ALTER TABLE CONSULTAS
	ADD CONSTRAINT FK_CONSULTAS_0 FOREIGN KEY (ID_CONTROL_CONSULTA) REFERENCES CONTROL_CONSULTA (ID);

/* CONSULTAS.FK_CONSULTAS_1 */
ALTER TABLE CONSULTAS
	ADD CONSTRAINT FK_CONSULTAS_1 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* CONTACTOS_DIRECCIONES.FK_CONTACTOS_DIRECCIONES_0 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT FK_CONTACTOS_DIRECCIONES_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* CONTACTOS_DIRECCIONES.FK_CONTACTOS_DIRECCIONES_1 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT FK_CONTACTOS_DIRECCIONES_1 FOREIGN KEY (ID_PROVINCIA) REFERENCES T_PROVINCIAS (ID);

/* CONTACTOS_DIRECCIONES.FK_CONTACTOS_DIRECCIONES_2 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT FK_CONTACTOS_DIRECCIONES_2 FOREIGN KEY (ID_MUNICIPIO) REFERENCES T_MUNICIPIOS (ID);

/* CONTACTOS_DIRECCIONES.FK_CONTACTOS_DIRECCIONES_3 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT FK_CONTACTOS_DIRECCIONES_3 FOREIGN KEY (ID_DISTRITO_MUNICIPAL) REFERENCES T_DISTRITOS_MUNICIPALES (ID);

/* CONTACTOS_DIRECCIONES.FK_CONTACTOS_DIRECCIONES_4 */
ALTER TABLE CONTACTOS_DIRECCIONES
	ADD CONSTRAINT FK_CONTACTOS_DIRECCIONES_4 FOREIGN KEY (ID_CODIGO_POSTAL) REFERENCES T_CODIGOS_POSTALES (ID);

/* CONTACTOS_EMAIL.FK_CONTACTOS_EMAIL_0 */
ALTER TABLE CONTACTOS_EMAIL
	ADD CONSTRAINT FK_CONTACTOS_EMAIL_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* CONTACTOS_TEL.FK_CONTACTOS_TEL_0 */
ALTER TABLE CONTACTOS_TEL
	ADD CONSTRAINT FK_CONTACTOS_TEL_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* D_ANALISIS.FK_D_ANALISIS_0 */
ALTER TABLE D_ANALISIS
	ADD CONSTRAINT FK_D_ANALISIS_0 FOREIGN KEY (ID_M_ANALISIS) REFERENCES M_ANALISIS (ID);

/* D_ANALISIS.FK_D_ANALISIS_1 */
ALTER TABLE D_ANALISIS
	ADD CONSTRAINT FK_D_ANALISIS_1 FOREIGN KEY (ID_T_ANALITICA) REFERENCES T_ANALISIS (ID);

/* D_DEUDAS_PAGAS.FK_D_DEUDAS_PAGAS_0 */
ALTER TABLE D_DEUDAS_PAGAS
	ADD CONSTRAINT FK_D_DEUDAS_PAGAS_0 FOREIGN KEY (ID_DEUDAS) REFERENCES M_DEUDAS (ID);

/* D_ENTRADA_PRODUCTOS.FK_D_ENTRADA_PRODUCTOS_0 */
ALTER TABLE D_ENTRADA_PRODUCTOS
	ADD CONSTRAINT FK_D_ENTRADA_PRODUCTOS_0 FOREIGN KEY (ID_M_ENTRADA_PRODUCTO) REFERENCES M_ENTRADA_PRODUCTOS (ID);

/* D_ENTRADA_PRODUCTOS.FK_D_ENTRADA_PRODUCTOS_1 */
ALTER TABLE D_ENTRADA_PRODUCTOS
	ADD CONSTRAINT FK_D_ENTRADA_PRODUCTOS_1 FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS (ID);

/* D_ENTRADA_PRODUCTOS.FK_D_ENTRADA_PRODUCTOS_2 */
ALTER TABLE D_ENTRADA_PRODUCTOS
	ADD CONSTRAINT FK_D_ENTRADA_PRODUCTOS_2 FOREIGN KEY (ID_ALMACEN) REFERENCES ALMACENES (ID);

/* D_FACTURAS.FK_D_FACTURAS_0 */
ALTER TABLE D_FACTURAS
	ADD CONSTRAINT FK_D_FACTURAS_0 FOREIGN KEY (ID_FACTURA) REFERENCES M_FACTURAS (ID);

/* D_FACTURAS.FK_D_FACTURAS_1 */
ALTER TABLE D_FACTURAS
	ADD CONSTRAINT FK_D_FACTURAS_1 FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS (ID);

/* D_FACTURAS.FK_D_FACTURAS_2 */
ALTER TABLE D_FACTURAS
	ADD CONSTRAINT FK_D_FACTURAS_2 FOREIGN KEY (ID_PRECIO) REFERENCES PRECIOS (ID);

/* D_GUIA_VIGILANCIA_DESARROLLO.FK_D_GUIA_VIGILANCIA_DESARROLLO_0 */
ALTER TABLE D_GUIA_VIGILANCIA_DESARROLLO
	ADD CONSTRAINT FK_D_GUIA_VIGILANCIA_DESARROLLO_0 FOREIGN KEY (ID_GVD) REFERENCES T_GUIA_VIGILANCIA_DESARROLLO (ID);

/* D_GUIA_VIGILANCIA_DESARROLLO.FK_D_GUIA_VIGILANCIA_DESARROLLO_1 */
ALTER TABLE D_GUIA_VIGILANCIA_DESARROLLO
	ADD CONSTRAINT FK_D_GUIA_VIGILANCIA_DESARROLLO_1 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* D_MOTIVO_CONSULTA.FK_D_MOTIVO_CONSULTA_0 */
ALTER TABLE D_MOTIVO_CONSULTA
	ADD CONSTRAINT FK_D_MOTIVO_CONSULTA_0 FOREIGN KEY (ID_CONSULTA) REFERENCES CONSULTAS (ID);

/* D_MOTIVO_CONSULTA.FK_D_MOTIVO_CONSULTA_1 */
ALTER TABLE D_MOTIVO_CONSULTA
	ADD CONSTRAINT FK_D_MOTIVO_CONSULTA_1 FOREIGN KEY (ID_MOTIVO_CONSULTA) REFERENCES T_MOTIVO_CONSULTA (ID);

/* D_RECETAS.FK_D_RECETAS_0 */
ALTER TABLE D_RECETAS
	ADD CONSTRAINT FK_D_RECETAS_0 FOREIGN KEY (ID_RECETA) REFERENCES M_RECETAS (ID);

/* D_RECETAS.FK_D_RECETAS_1 */
ALTER TABLE D_RECETAS
	ADD CONSTRAINT FK_D_RECETAS_1 FOREIGN KEY (ID_MEDICAMENTO) REFERENCES PRODUCTOS (ID);

/* FOTO_CATEGORIA.FK_FOTO_CATEGORIA_0 */
ALTER TABLE FOTO_CATEGORIA
	ADD CONSTRAINT FK_FOTO_CATEGORIA_0 FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIAS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* FOTO_PERSONA.FK_FOTO_PERSONA_0 */
ALTER TABLE FOTO_PERSONA
	ADD CONSTRAINT FK_FOTO_PERSONA_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* FOTO_PRODUCTO.FK_FOTO_PRODUCTO_0 */
ALTER TABLE FOTO_PRODUCTO
	ADD CONSTRAINT FK_FOTO_PRODUCTO_0 FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* GENERALES.FK_GENERALES_0 */
ALTER TABLE GENERALES
	ADD CONSTRAINT FK_GENERALES_0 FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* GENERALES.FK_GENERALES_1 */
ALTER TABLE GENERALES
	ADD CONSTRAINT FK_GENERALES_1 FOREIGN KEY (ID_TIPO_SANGRE) REFERENCES T_TIPOS_SANGRE (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* HUELLAS.FK_HUELLAS_0 */
ALTER TABLE HUELLAS
	ADD CONSTRAINT FK_HUELLAS_0 FOREIGN KEY (ID_PERSONAL) REFERENCES PERSONAS (ID);

/* INSCRIPCIONES.FK_INSCRIPCIONES_0 */
ALTER TABLE INSCRIPCIONES
	ADD CONSTRAINT FK_INSCRIPCIONES_0 FOREIGN KEY (ID_ESTUDIANTE) REFERENCES PERSONAS (ID);

/* INSCRIPCIONES.FK_INSCRIPCIONES_1 */
ALTER TABLE INSCRIPCIONES
	ADD CONSTRAINT FK_INSCRIPCIONES_1 FOREIGN KEY (ID_TANDA) REFERENCES TANDAS (ID);

/* MENSAJES.FK_MENSAJES_0 */
ALTER TABLE MENSAJES
	ADD CONSTRAINT FK_MENSAJES_0 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* METRICAS.FK_METRICAS_0 */
ALTER TABLE METRICAS
	ADD CONSTRAINT FK_METRICAS_0 FOREIGN KEY (ID_CONSULTA) REFERENCES CONSULTAS (ID);

/* M_ANALISIS.FK_M_ANALISIS_0 */
ALTER TABLE M_ANALISIS
	ADD CONSTRAINT FK_M_ANALISIS_0 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* M_DEUDAS.FK_M_DEUDAS_0 */
ALTER TABLE M_DEUDAS
	ADD CONSTRAINT FK_M_DEUDAS_0 FOREIGN KEY (ID_CLIENTE) REFERENCES PERSONAS (ID);

/* M_ENTRADA_PRODUCTOS.FK_M_ENTRADA_PRODUCTOS_0 */
ALTER TABLE M_ENTRADA_PRODUCTOS
	ADD CONSTRAINT FK_M_ENTRADA_PRODUCTOS_0 FOREIGN KEY (ID_PROVEEDOR) REFERENCES PERSONAS (ID);

/* M_ENTRADA_PRODUCTOS.FK_M_ENTRADA_PRODUCTOS_1 */
ALTER TABLE M_ENTRADA_PRODUCTOS
	ADD CONSTRAINT FK_M_ENTRADA_PRODUCTOS_1 FOREIGN KEY (ID_ALMACEN) REFERENCES ALMACENES (ID);

/* M_FACTURAS.FK_M_FACTURAS_0 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT FK_M_FACTURAS_0 FOREIGN KEY (ID_CLIENTE) REFERENCES PERSONAS (ID);

/* M_FACTURAS.FK_M_FACTURAS_1 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT FK_M_FACTURAS_1 FOREIGN KEY (ID_CONTACTOS_TEL) REFERENCES CONTACTOS_TEL (ID);

/* M_FACTURAS.FK_M_FACTURAS_2 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT FK_M_FACTURAS_2 FOREIGN KEY (ID_CONTACTOS_DIRECCIONES) REFERENCES CONTACTOS_DIRECCIONES (ID);

/* M_FACTURAS.FK_M_FACTURAS_3 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT FK_M_FACTURAS_3 FOREIGN KEY (ID_CONTACTOS_EMAIL) REFERENCES CONTACTOS_EMAIL (ID);

/* M_FACTURAS.FK_M_FACTURAS_4 */
ALTER TABLE M_FACTURAS
	ADD CONSTRAINT FK_M_FACTURAS_4 FOREIGN KEY (ID_TURNO) REFERENCES TURNOS (ID);

/* M_RECETAS.FK_M_RECETAS_0 */
ALTER TABLE M_RECETAS
	ADD CONSTRAINT FK_M_RECETAS_0 FOREIGN KEY (ID_CONSULTA) REFERENCES CONSULTAS (ID);

/* PERSONAS_CLIENTES.FK_PERSONAS_CLIENTES_0 */
ALTER TABLE PERSONAS_CLIENTES
	ADD CONSTRAINT FK_PERSONAS_CLIENTES_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* PERSONAS_CLIENTES_ATR.FK_PERSONAS_CLIENTES_ATR_0 */
ALTER TABLE PERSONAS_CLIENTES_ATR
	ADD CONSTRAINT FK_PERSONAS_CLIENTES_ATR_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* PERSONAS_EMPLEADOS.FK_PERSONAS_EMPLEADOS_0 */
ALTER TABLE PERSONAS_EMPLEADOS
	ADD CONSTRAINT FK_PERSONAS_EMPLEADOS_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID);

/* PERSONAS_EMPLEADOS_ATR.FK_PERSONAS_EMPLEADOS_ATR_0 */
ALTER TABLE PERSONAS_EMPLEADOS_ATR
	ADD CONSTRAINT FK_PERSONAS_EMPLEADOS_ATR_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID);

/* PERSONAS_EMPLEADOS_ATR.FK_PERSONAS_EMPLEADOS_ATR_1 */
ALTER TABLE PERSONAS_EMPLEADOS_ATR
	ADD CONSTRAINT FK_PERSONAS_EMPLEADOS_ATR_1 FOREIGN KEY (ID_CARGO) REFERENCES CARGOS (ID);

/* PERSONAS_EMPLEADOS_ATR.FK_PERSONAS_EMPLEADOS_ATR_2 */
ALTER TABLE PERSONAS_EMPLEADOS_ATR
	ADD CONSTRAINT FK_PERSONAS_EMPLEADOS_ATR_2 FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES DEPARTAMENTOS (ID);

/* PERSONAS_ESTUDIANTES.FK_PERSONAS_ESTUDIANTES_0 */
ALTER TABLE PERSONAS_ESTUDIANTES
	ADD CONSTRAINT FK_PERSONAS_ESTUDIANTES_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* PERSONAS_ESTUDIANTES_ATR.FK_PERSONAS_ESTUDIANTES_ATR_0 */
ALTER TABLE PERSONAS_ESTUDIANTES_ATR
	ADD CONSTRAINT FK_PERSONAS_ESTUDIANTES_ATR_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* PERSONAS_PACIENTES.FK_PERSONAS_PACIENTES_0 */
ALTER TABLE PERSONAS_PACIENTES
	ADD CONSTRAINT FK_PERSONAS_PACIENTES_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* PERSONAS_PACIENTES_ATR.FK_PERSONAS_PACIENTES_ATR_0 */
ALTER TABLE PERSONAS_PACIENTES_ATR
	ADD CONSTRAINT FK_PERSONAS_PACIENTES_ATR_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* PERSONAS_PADRES.FK_PERSONAS_PADRES_0 */
ALTER TABLE PERSONAS_PADRES
	ADD CONSTRAINT FK_PERSONAS_PADRES_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* PERSONAS_PROVEEDORES.FK_PERSONAS_PROVEEDORES_0 */
ALTER TABLE PERSONAS_PROVEEDORES
	ADD CONSTRAINT FK_PERSONAS_PROVEEDORES_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE NO ACTION ON DELETE NO ACTION;

/* PERSONAS_PROVEEDORES_ATR.FK_PERSONAS_PROVEEDORES_ATR_0 */
ALTER TABLE PERSONAS_PROVEEDORES_ATR
	ADD CONSTRAINT FK_PERSONAS_PROVEEDORES_ATR_0 FOREIGN KEY (ID) REFERENCES PERSONAS (ID) ON UPDATE CASCADE ON DELETE CASCADE;

/* PRECIOS.FK_PRECIOS_0 */
ALTER TABLE PRECIOS
	ADD CONSTRAINT FK_PRECIOS_0 FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS (ID) ON UPDATE CASCADE ON DELETE NO ACTION;

/* PRECIOS.FK_PRECIOS_1 */
ALTER TABLE PRECIOS
	ADD CONSTRAINT FK_PRECIOS_1 FOREIGN KEY (ID_TIPO_PRECIO) REFERENCES T_TIPOS_PRECIO (ID);

/* PRECIOS.FK_PRECIOS_2 */
ALTER TABLE PRECIOS
	ADD CONSTRAINT FK_PRECIOS_2 FOREIGN KEY (ID_TIPO_IMPUESTO) REFERENCES T_IMPUESTOS (ID);

/* PRODUCTOS.FK_PRODUCTOS_0 */
ALTER TABLE PRODUCTOS
	ADD CONSTRAINT FK_PRODUCTOS_0 FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIAS (ID);

/* RELACION_PADRE_ESTUDIANTE.FK_RELACION_PADRE_ESTUDIANTE_0 */
ALTER TABLE RELACION_PADRE_ESTUDIANTE
	ADD CONSTRAINT FK_RELACION_PADRE_ESTUDIANTE_0 FOREIGN KEY (ID_PADRE_O_MADRE) REFERENCES PERSONAS (ID);

/* RELACION_PADRE_ESTUDIANTE.FK_RELACION_PADRE_ESTUDIANTE_1 */
ALTER TABLE RELACION_PADRE_ESTUDIANTE
	ADD CONSTRAINT FK_RELACION_PADRE_ESTUDIANTE_1 FOREIGN KEY (ID_ESTUDIANTE) REFERENCES PERSONAS (ID);

/* RELACION_PADRE_PACIENTE.FK_RELACION_PADRE_PACIENTE_0 */
ALTER TABLE RELACION_PADRE_PACIENTE
	ADD CONSTRAINT FK_RELACION_PADRE_PACIENTE_0 FOREIGN KEY (ID_PADRE_O_MADRE) REFERENCES PERSONAS (ID);

/* RELACION_PADRE_PACIENTE.FK_RELACION_PADRE_PACIENTE_1 */
ALTER TABLE RELACION_PADRE_PACIENTE
	ADD CONSTRAINT FK_RELACION_PADRE_PACIENTE_1 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* SINTOMAS.FK_SINTOMAS_0 */
ALTER TABLE SINTOMAS
	ADD CONSTRAINT FK_SINTOMAS_0 FOREIGN KEY (ID_PACIENTE) REFERENCES PERSONAS (ID);

/* T_CODIGOS_POSTALES.FK_T_CODIGOS_POSTALES_0 */
ALTER TABLE T_CODIGOS_POSTALES
	ADD CONSTRAINT FK_T_CODIGOS_POSTALES_0 FOREIGN KEY (ID_PROVINCIA) REFERENCES T_PROVINCIAS (ID);

/* T_DISTRITOS_MUNICIPALES.FK_T_DISTRITOS_MUNICIPALES_0 */
ALTER TABLE T_DISTRITOS_MUNICIPALES
	ADD CONSTRAINT FK_T_DISTRITOS_MUNICIPALES_0 FOREIGN KEY (ID_MUNICIPIO) REFERENCES T_MUNICIPIOS (ID);

/* T_MUNICIPIOS.FK_T_MUNICIPIOS_0 */
ALTER TABLE T_MUNICIPIOS
	ADD CONSTRAINT FK_T_MUNICIPIOS_0 FOREIGN KEY (ID_PROVINCIA) REFERENCES T_PROVINCIAS (ID);
