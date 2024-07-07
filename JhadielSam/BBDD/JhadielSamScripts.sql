--CREANDO DOMINIOS
CREATE DOMAIN d_nombres
AS varchar(30) NOT NULL;

CREATE DOMAIN d_login
AS varchar(15) NOT NULL;

CREATE DOMAIN d_password
AS varchar(15) NOT NULL;

CREATE DOMAIN d_apellidos
AS varchar(30) NOT NULL;

CREATE DOMAIN d_campo50
AS varchar(50) NOT NULL;

CREATE DOMAIN d_campo15
AS varchar(15) NOT NULL;
/*012-0022344-8*/
CREATE DOMAIN d_cedula
 AS Char(13) NOT NULL
 CHECK (char_length(value) = 13);
/*(809) 557-2015*/
CREATE DOMAIN d_telefono
AS char(14) NOT NULL
CHECK (char_length(value) = 14);

CREATE DOMAIN d_id
AS integer NOT NULL;

CREATE DOMAIN d_sexo
AS char(1) NOT NULL CHECK (value in('M', 'H'));

CREATE DOMAIN d_estado
AS char(1) NOT NULL CHECK (value in('1', '0'));

CREATE DOMAIN d_estadoSam
AS char(1) NOT NULL CHECK (value in('A', 'I', 'C', 'S', 'D'));

create domain d_fecha
date not null;

create domain d_fechaNull
date;

create domain d_hora
time;
--FIN DE DOMINIOS

CREATE GENERATOR Generador;

create table Permisos--Begin
(
    idPermiso d_id,
    Usuarios d_estado,
    Clientes d_estado,
    CrearSam d_estado,
    PagoSam d_estado,
    ConsultaSam d_estado,
    InformesEco d_estado,
    
    primary key (idPermiso)
);

SET TERM !! ;
CREATE TRIGGER PERMISOS_BI FOR PERMISOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDPERMISO IS NULL) THEN
    NEW.IDPERMISO = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDPERMISO) then
      tmp = GEN_ID(Generador, new.IDPERMISO-tmp);
  END
END!!
SET TERM ; !!--End



create table usuarios--Begin
(
    idUsuario d_id,
    idPermiso d_id,
    nombres d_nombres,
    apellidos d_apellidos,
    login d_login,
    clave d_password,
    estado d_estado,
    
    primary key (idUsuario),
    unique(login),
    foreign key (idPermiso) references Permisos(idPermiso)    
);
SET TERM !! ;
CREATE TRIGGER USUARIOS_BI FOR USUARIOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDUSUARIO IS NULL) THEN
    NEW.IDUSUARIO = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDUSUARIO) then
      tmp = GEN_ID(Generador, new.IDUSUARIO-tmp);
  END
END!!
SET TERM ; !!--END




create table turnos --Begin
(
    idTurnos d_id,
    idUsuario d_id,
    fechaCreado d_fecha,
    horaCreado d_hora,
    autoCrear d_estado,
    fechaCierre d_fechaNull,
    horaCierre d_hora,
    estado d_estado,
    
    PRIMARY KEY (idTurnos),
    foreign key (idUsuario) references Usuarios (idUsuario)
);
SET TERM !! ;
CREATE TRIGGER TURNOS_BI FOR TURNOS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDTURNOS IS NULL) THEN
    NEW.IDTURNOS = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDTURNOS) then
      tmp = GEN_ID(Generador, new.IDTURNOS-tmp);
  END
END!!
SET TERM ; !!--END





CREATE TABLE Clientes --Begin
(
    idCliente d_id,
    idTurno d_id,
    cedula d_cedula,
    nombres d_nombres,
    apellidos d_apellidos,
    direccion d_campo50,
    telefono d_telefono,
    telefono2 d_telefono,
    correo d_campo50,
    fechaNacimiento d_fecha,
    fechaIngreso d_fecha default current_date,
    estado d_estado,    
    
    PRIMARY KEY (idCliente),
    UNIQUE      (cedula),
    FOREIGN KEY (idTurno) REFERENCES Turnos (idTurnos)
);
SET TERM !! ;
CREATE TRIGGER CLIENTES_BI FOR CLIENTES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDCLIENTE IS NULL) THEN
    NEW.IDCLIENTE = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDCLIENTE) then
      tmp = GEN_ID(Generador, new.IDCLIENTE-tmp);
  END
END!!
SET TERM ; !!--END





create table Colores --Begin
(
    idColor d_id,
    descripcion d_campo15,
    codColor1 int not null,
    codColor2 int not null,
    codColor3 int not null,
    primary key (idColor)
);

SET TERM !! ;
CREATE TRIGGER COLORES_BI FOR COLORES
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDCOLOR IS NULL) THEN
    NEW.IDCOLOR = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDCOLOR) then
      tmp = GEN_ID(Generador, new.IDCOLOR-tmp);
  END
END!!
SET TERM ; !!--End






create table PlanSam--Begin
(
    idPlanSam d_id,
    descripcion d_campo50,
    hasta int not null,
    porciento numeric(2,2) not null,
    penalidadFechaIncumplimiento numeric(2,2) not null,
    penalidad numeric(2,2) not null,
    estado d_estado,    
    
    PRIMARY KEY (idPlanSam),
    UNIQUE      (descripcion)
);
SET TERM !! ;
CREATE TRIGGER PLANSAM_BI FOR PLANSAM
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDPLANSAM IS NULL) THEN
    NEW.IDPLANSAM = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDPLANSAM) then
      tmp = GEN_ID(Generador, new.IDPLANSAM-tmp);
  END
END!!
SET TERM ; !!--End






create table Sams--Begin
(
    idSam d_id,
    idCliente d_id,
    idPlanSam d_id,
    idTurno d_id,
    fecha_creado d_fecha default current_date,
    hora d_hora default current_time,
    fechaCumplimiento COMPUTED BY(dateadd((SELECT p.hasta FROM PlanSam p WHERE p.idPlanSam = idPlanSam) day to CURRENT_DATE)),
    estado d_estadoSam,
    
    primary key (idSam),
    unique (idCliente, idPlanSam, idTurno),
    foreign key (idCliente) references Clientes (idCliente),
    foreign key (idPlanSam) references PlanSam (idPlanSam),
    foreign key (idTurno) references Turnos (idTurnos)
);
SET TERM !! ;
CREATE TRIGGER SAMS_BI FOR SAMS
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.IDSAM IS NULL) THEN
    NEW.IDSAM = GEN_ID(Generador, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(Generador, 0);
    if (tmp < new.IDSAM) then
      tmp = GEN_ID(Generador, new.IDSAM-tmp);
  END
END!!
SET TERM ; !!--end





create table DetalleSam--Begin
(
    idSam d_id,
    linea int not null,
    numero int not null,
    idTurno d_id,
    fechaPago d_fecha default current_date,
    hora d_hora default current_time,
    estado d_estado,
    
    primary key (idSam, linea),
    foreign key (idSam) references Sams (idSam)
);--end























