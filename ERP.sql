  -----------------------------------------------------------------------------------------------------------------------------
  --------------------------------------------------------ROJA-------------------------------------------------------------
  -----------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TIPOUSUARIO(
    IDTIPOUSUARIO INTEGER NOT NULL,
    NOMBRE VARCHAR(80) NOT NULL,
    ESTATUS CHAR NOT NULL,
    CONSTRAINT PK_TIPOS PRIMARY KEY(IDTIPOUSUARIO)
);
insert into ERP.tipousuario values (2,'admin','A');
insert into "ERP"."USUARIOS" values('juan','erp','A','1','1');
select * from ERP.usuarios;
CREATE TABLE "ERP"."USUARIOS" 
   (	"NOMBRE" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"CONTRASEŅA" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	"IDEMPLEADO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDTIPOUSUARIO" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "USUARIOS_PK" PRIMARY KEY ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK_TIPO_USUARIO" FOREIGN KEY ("IDTIPOUSUARIO")
	  REFERENCES "ERP"."TIPOUSUARIO" ("IDTIPOUSUARIO") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
  drop table ERP.usuarios;
    ---------------------------------------------------------------------------------------------------------------------------
  --------------------------------------------------------FIN ROJA-------------------------------------------------------------
  -----------------------------------------------------------------------------------------------------------------------------
  
  
  
  -----------------------------------------------------------------------------------------------------------------------------
  --------------------------------------------------------AMARILLA-------------------------------------------------------------
  -----------------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "ERP"."DEDUCCIONES"(
    IDDEDUCCION INTEGER NOT NULL,
    NOMBRE VARCHAR2(30) NOT NULL,
    DESCRIPCION VARCHAR(80) NOT NULL,
    PORCENTAJE FLOAT NOT NULL,
    
    CONSTRAINT PK_IDDEDUCCION PRIMARY KEY(IDDEDUCCION)
  );
  
  CREATE TABLE ERP.EMPLEADOS(
    IDEMPLEADO INTEGER NOT NULL,
    NOMBRE VARCHAR2(30) NOT NULL,
    APARTERNO VARCHAR2(30) NOT NULL,
    AMATERNO VARCHAR2(30) NOT NULL,
    SEXO CHAR NOT NULL,
    FECHACONTRATACION DATE NOT NULL,
    FECHANACIMIENTO DATE NOT NULL,
    SALARIO FLOAT NOT NULL,
    NSS VARCHAR2(10) NOT NULL,
    ESTADOCIVIL VARCHAR2(20) NOT NULL,
    DIASVACACIONES INTEGER NOT NULL,
    DIASPERMISO INTEGER NOT NULL,
    FOTOGRAFIA BLOB NOT NULL,
    DIRECCION VARCHAR2(80) NOT NULL,
    COLONIA VARCHAR2(50) NOT NULL,
    CODIGOPOSTAL VARCHAR2(5) NOT NULL,
    ESCOLARIDAD VARCHAR2(50) NOT NULL,
    PORCENTAJECOMISION FLOAT NOT NULL,
    ESTATUS CHAR NOT NULL,
    IDDEPARTAMENTO INTEGER NOT NULL,
    IDPUESTO INTEGER NOT NULL,
    IDCIUDAD INTEGER NOT NULL,
    IDSUCURSAL INTEGER NOT NULL,
    
    CONSTRAINT PF_IDEMPLEADO PRIMARY KEY(IDEMPLEADO),
    
    CONSTRAINT FK_IDDEPARTAMENTO FOREIGN KEY(IDDEPARTAMENTO)
    REFERENCES ERP.DEPARTAMENTOS (IDDEPARTAMENTO) ENABLE,
    
    CONSTRAINT FK_IDPUESTO FOREIGN KEY(IDPUESTO)
    REFERENCES ERP.PUESTOS (IDPUESTO) ENABLE,
    
    CONSTRAINT FK_IDCIUDAD FOREIGN KEY(IDCIUDAD)
    REFERENCES ERP.CIUDADES (IDCIUDAD) ENABLE,
    
    ---FK DE TABLAS VERDES
    CONSTRAINT FK_IDSUCURSAL FOREIGN KEY(IDSUCURSAL)
    REFERENCES ERP.SUCURSALES (IDSUCURSAL) ENABLE
  );
  
  CREATE TABLE AUSENCIASJUSTIFICADAS(
    IDAUSENCIA INTEGER NOT NULL,
    FECHASOLICITUD DATE NOT NULL,
    FECHAINICIO DATE NOT NULL,
    FECHAFIN DATE NOT NULL,
    TIPO CHAR NOT NULL,
    IDEMPLEADOS INTEGER  NOT NULL,
    --SOLICITA
    IDEMPLEADOA INTEGER NOT NULL,
    --AUTORIZA
    CONSTRAINT PK_IDAUSENCIA PRIMARY KEY(IDAUSENCIA),
    
    CONSTRAINT FK_IDEMPLEADOSAUSENCIAS FOREIGN KEY(IDEMPLEADOS)
    REFERENCES ERP.EMPLEADOS (IDEMPLEADO) ENABLE,
    
    CONSTRAINT FK_IDEMPLEADOAAUSENCIAS FOREIGN KEY(IDEMPLEADOA)
    REFERENCES ERP.EMPLEADOS (IDEMPLEADO) ENABLE
  );
  
  CREATE TABLE ERP.DEPARTAMENTOS(
    IDDEPARTAMENTO INTEGER NOT NULL,
    NOMBRE VARCHAR2(50) NOT NULL,
    ESTATUS CHAR NOT NULL,
    
    CONSTRAINT PK_IDDEPARTAMENTO PRIMARY KEY(IDDEPARTAMENTO)
  );
  
  CREATE TABLE ERP.HISTORIALPUESTOS(
    IDEMPLEADO INTEGER NOT NULL,
    IDPUESTO INTEGER NOT NULL,
    IDDEPARTAMENTO INTEGER NOT NULL,
    FECHAINICIO DATE NOT NULL,
    FECHAFIN DATE NOT NULL,
    SALARIO FLOAT NOT NULL,
    
    CONSTRAINT PK_HISTORIALPUESTOS PRIMARY KEY(IDEMPLEADO, IDPUESTO,
    IDDEPARTAMENTO, FECHAINICIO),
    
    CONSTRAINT FK_IDEMPLEADOHISTORIAL FOREIGN KEY(IDEMPLEADO)
    REFERENCES ERP.EMPLEADOS(IDEMPLEADO) ENABLE,
    
    CONSTRAINT FK_IDPUESTOHISTORIAL FOREIGN KEY(IDPUESTO)
    REFERENCES ERP.PUESTOS(IDPUESTO) ENABLE,
    
    CONSTRAINT FK_IDDEPARTAMENTOHISTORIAL FOREIGN KEY(IDDEPARTAMENTO)
    REFERENCES ERP.DEPARTAMENTOS(IDDEPARTAMENTO) ENABLE
  );
  
  CREATE TABLE ERP.PERCEPCIONES(
    IDPERCEPCION INTEGER NOT NULL,
    NOMBRE VARCHAR2(30) NOT NULL,
    DESCRIPCION VARCHAR2(80) NOT NULL,
    DIASPAGAR INTEGER NOT NULL,
    
    CONSTRAINT PK_IDPERCEPCION PRIMARY KEY(IDPERCEPCION)
  );
  
  CREATE TABLE ERP.INCAPACIDADES(
    IDINCAPACIDAD INTEGER NOT NULL,
    FECHAINICIO DATE NOT NULL,
    FECHAFIN DATE NOT NULL,
    ENFERMEDAD VARCHAR2(150) NOT NULL,
    EVIDENCIA BLOB NOT NULL,
    IDEMPLEADO INTEGER NOT NULL,
    
    CONSTRAINT PK_IDINCAPACIDAD PRIMARY KEY(IDINCAPACIDAD),
    
    CONSTRAINT FK_IDEMPLEADO FOREIGN KEY(IDEMPLEADO)
    REFERENCES ERP.EMPLEADOS(IDEMPLEADO) ENABLE
  );
  
  CREATE TABLE ERP.NOMINASPERCEPCIONES(
    IDNOMINA INTEGER NOT NULL,
    IDPERCEPCION INTEGER NOT NULL,
    IMPORTE FLOAT NOT NULL,
    
    CONSTRAINT PK_NOMINASPERCEPCIONES PRIMARY KEY(IDNOMINA, IDPERCEPCION),
    
    CONSTRAINT FK_IDNOMINANOMINAS FOREIGN KEY(IDNOMINA)
    REFERENCES ERP.NOMINAS(IDNOMINA) ENABLE,
    
    CONSTRAINT FK_IDPERCEPCIONNOMINAS FOREIGN KEY(IDPERCEPCION)
    REFERENCES ERP.PERCEPCIONES(IDPERCEPCION) ENABLE
  );
  
  CREATE TABLE ERP.PUESTOS(
    IDPUESTO INTEGER NOT NULL,
    NOMBRE VARCHAR2(60) NOT NULL,
    SALARIOMINIMO FLOAT NOT NULL,
    SALARIOMAXIMO FLOAT NOT NULL,
    ESTATUS CHAR NOT NULL,
    
    CONSTRAINT PK_IDPUESTO PRIMARY KEY(IDPUESTO)
  );
  
  CREATE TABLE ERP.DOCUMENTACIONEMPLEADO(
    IDDOCUMENTO INTEGER NOT NULL,
    NOMBREDOCUMENTO VARCHAR2(80) NOT NULL,
    FECHAENTREGA DATE NOT NULL,
    DOCUMENTO BLOB NOT NULL,
    IDEMPLEADO INTEGER NOT NULL,
    
    CONSTRAINT PK_IDDOCUMENTO PRIMARY KEY(IDDOCUMENTO)
  );
  
  CREATE TABLE ERP.FORMASPAGO(
    IDFORMAPAGO INTEGER NOT NULL,
    NOMBRE VARCHAR2(50) NOT NULL,
    ESTATUS CHAR NOT NULL,
    
    CONSTRAINT PK_IDFORMAPAGO PRIMARY KEY(IDFORMAPAGO)
  );
  
  CREATE TABLE ERP.HORARIOS(
    IDHORARIO INTEGER NOT NULL,
    HORAINICIO DATE NOT NULL,
    HORAFIN DATE NOT NULL,
    DIAS VARCHAR2(30) NOT NULL,
    IDEMPLEADO INTEGER NOT NULL,
    
    CONSTRAINT PK_IDHORARIO PRIMARY KEY(IDHORARIO),
    
    CONSTRAINT FK_IDEMPLEADOHORARIOS FOREIGN KEY(IDEMPLEADO)
    REFERENCES ERP.EMPLEADOS (IDEMPLEADO) ENABLE
  );
  
  
  CREATE TABLE ERP.NOMINAS(
    IDNOMINA INTEGER NOT NULL,
    FECHAPAGO DATE NOT NULL,
    TOTALP FLOAT NOT NULL,
    TOTALD FLOAT NOT NULL,
    CANTIDADNETA FLOAT NOT NULL,
    DIASTRABAJADOS INTEGER NOT NULL,
    FALTAS INTEGER NOT NULL,
    FECHAINICIO DATE NOT NULL,
    FECHAFIN DATE NOT NULL,
    IDEMPLEADO INTEGER NOT NULL,
    IDFORMAPAGO INTEGER NOT NULL, 
    
    CONSTRAINT PF_IDNOMINA PRIMARY KEY(IDNOMINA),
    
    CONSTRAINT FK_IDEMPLEADONOMINAS FOREIGN KEY(IDEMPLEADO)
    REFERENCES ERP.EMPLEADOS (IDEMPLEADO) ENABLE,
    CONSTRAINT FK_IDFORMAPAGONOMINAS FOREIGN KEY(IDFORMAPAGO)
    REFERENCES ERP.FORMASPAGO (IDFORMAPAGO) ENABLE
  );
  
  CREATE TABLE ERP.NOMINASDEDUCCIONES(
    IDNOMINA INTEGER NOT NULL,
    IDDEDUCCION INTEGER NOT NULL,
    IMPORTE FLOAT NOT NULL,
    
    CONSTRAINT PK_NOMINASDEDUCCIONES PRIMARY KEY(IDNOMINA, IDDEDUCCION),
    
    CONSTRAINT FK_IDNOMINANOMINASDEDUCCIONES FOREIGN KEY(IDNOMINA)
    REFERENCES ERP.NOMINAS (IDNOMINA) ENABLE,
    
    CONSTRAINT FK_DEDUCCIONNOMINASDEDUCCION FOREIGN KEY(IDDEDUCCION)
    REFERENCES ERP.DEDUCCIONES (IDDEDUCCION) ENABLE
  );
  
  CREATE TABLE ERP.ESTADOS(
    IDESTADO INTEGER NOT NULL,
    NOMBRE VARCHAR2(60) NOT NULL,
    SIGLAS VARCHAR2(10) NOT NULL,
    ESTATUS CHAR NOT NULL,
    
    CONSTRAINT PK_IDESTADO PRIMARY KEY(IDESTADO)
  );
  
  CREATE TABLE ERP.CIUDADES(
    IDCIUDAD INTEGER NOT NULL,
    NOMBRE VARCHAR2(80) NOT NULL,
    IDESTADO INTEGER NOT NULL,
    ESTATUS CHAR NOT NULL,
    
    CONSTRAINT PK_IDCIUDAD PRIMARY KEY(IDCIUDAD),
    
    CONSTRAINT FK_IDESTADO FOREIGN KEY(IDESTADO)
    REFERENCES ERP.ESTADOS (IDESTADO) ENABLE
  );
  
select count (*) from sys.all_tables where owner = 'ERP';
  ----------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------FIN AMARRILLA-----------------------------------------------------------
  ---------------------------------------------------------------------------------------------------------------------------
  
  
  
   ----------------------------------------------------------------------------------------------------------------------------
  ---------------------------------------------------------AZUL---------------------------------------------------------------
  ---------------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "ERP"."VENTAS" 
   (	"IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHA" DATE NOT NULL ENABLE, 
	"TOTALPAGAR" FLOAT(126) NOT NULL ENABLE, 
	"CANTPAGADA" FLOAT(126) NOT NULL ENABLE, 
	"COMENTARIOS" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	"TIPO" CHAR(1 BYTE) NOT NULL ENABLE, 
	"IDCLIENTE" NUMBER(*,0), 
	"IDSUCURSAL" NUMBER(*,0), 
	"IDEMPLEADO" NUMBER(*,0), 
	 CONSTRAINT "VENTAS_PK" PRIMARY KEY ("IDVENTA"),
     
	 CONSTRAINT "FK_IDCLIENTE" FOREIGN KEY ("IDCLIENTE")
	  REFERENCES "ERP"."CLIENTES" ("IDCLIENTE") ENABLE, 
      
	 CONSTRAINT "FK_IDSUCURSAL" FOREIGN KEY ("IDSUCURSAL")
	  REFERENCES "ERP"."SUCURSALES" ("IDSUCURSAL") ENABLE
   ) 
 
CREATE TABLE ERP.PEDIDODETALLE(
    IDPEDIDODETALLE INTEGER NOT NULL,
    CANTPEDIDA INTEGER NOT NULL,
    PRECIOCOMPRA FLOAT NOT NULL,
    SUBTOTAL FLOAT NOT NULL,
    CANTRECIBIDA INTEGER NOT NULL,
    CANTRECHAZADA INTEGER NOT NULL,
    CANTACEPTADA FLOAT NOT NULL,
    IDPEDIDO INTEGER NOT NULL,
    IDPRESENTACION INTEGER NOT NULL,
    
    CONSTRAINT PEDIDODETALLE_PK PRIMARY KEY(IDPEDIDODETALLE),
    
    CONSTRAINT FK_IDPEDIDO FOREIGN KEY(IDPEDIDO)
    REFERENCES ERP.PEDIDOS(IDPEDIDO) ENABLE,
    
    CONSTRAINT FK_IDPRESENTACION FOREIGN KEY(IDPRESENTACION)
    REFERENCES ERP.PRESENTACIONESPRODUCTO(IDPRESENTACION) ENABLE
);

create table UnidadesTransporte
(
  IdUnidadTransporte integer not null,
  Placas varchar2(10) not null,
  Marca varchar2(80) not null,
  Modelo varchar2(80) not null,
  Anio integer not null,
  Capacidad integer not null,
  constraint UnidadesTransporte_PK primary key(IdUnidadTransporte)
);

create table ERP.Cultivos
(
    IdCultivo integer not null,
    Nombre varchar2(100) not null,
    CostoAsesoria float not null,
    Estatus char not null,
    constraint Cultivos_PK primary key(IdCultivo)
);

create table Asociaciones
(
IdAsociacion integer not null,
Nombre varchar2(100) not null,
Estatus char not null,
constraint Asociaciones_PK primary key(IdAsociacion)
);


CREATE TABLE "ERP"."OFERTASASOCIACION" 
   (	"IDASOCIACION" NUMBER(*,0) NOT NULL ENABLE, 
	"IDOFERTA" NUMBER(*,0) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "OFERTASASOCIACION_PK" PRIMARY KEY ("IDASOCIACION", "IDOFERTA"),
	 CONSTRAINT "OFERTASASOCIACION_ASOCIA_FK" FOREIGN KEY ("IDASOCIACION")
        REFERENCES "ERP"."ASOCIACIONES" ("IDASOCIACION") ENABLE, 
	 CONSTRAINT "OFERTASASOCIACION_OFERTAS_FK" FOREIGN KEY ("IDOFERTA")
        REFERENCES "ERP"."OFERTAS" ("IDOFERTA") ENABLE
   );  
  


 CREATE TABLE "ERP"."ASOCIACIONES" 
   (	"IDASOCIACION" NUMBER(*,0) NOT NULL ENABLE, 
	"NOMBRE" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "ASOCIACIONES_PK" PRIMARY KEY ("IDASOCIACION")
   )  ;
  



 CREATE TABLE "ERP"."MIEMBROS" 
   (	"IDCLIENTE" NUMBER(*,0) NOT NULL ENABLE, 
	"IDASOCIACION" NUMBER(*,0) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	"FECHAINCORPORACION" DATE NOT NULL ENABLE, 
	 CONSTRAINT "MIEMBROS_PK" PRIMARY KEY ("IDCLIENTE", "IDASOCIACION"),
	 CONSTRAINT "MIEMBROS_ASOCIACIONES_FK" FOREIGN KEY ("IDASOCIACION")
	  REFERENCES "ERP"."ASOCIACIONES" ("IDASOCIACION") ENABLE, 
	 CONSTRAINT "MIEMBROS_CLIENTES_FK" FOREIGN KEY ("IDCLIENTE")
	  REFERENCES "ERP"."CLIENTES" ("IDCLIENTE") ENABLE
   );
  


 CREATE TABLE "ERP"."VENTASDETALLE" 
   (	"IDVENTADETALLE" NUMBER(*,0) NOT NULL ENABLE, 
	"PRECIOVENTA" FLOAT(126) NOT NULL ENABLE, 
	"CANTIDAD" FLOAT(126) NOT NULL ENABLE, 
	"SUBTOTAL" FLOAT(126) NOT NULL ENABLE, 
	"IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	"IDPRESENTACION" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "VENTASDETALLE_PK" PRIMARY KEY ("IDVENTADETALLE"),
	 CONSTRAINT "VENTASDETALLE_VENTAS_FK" FOREIGN KEY ("IDVENTA")
	  REFERENCES "ERP"."VENTAS" ("IDVENTA") ENABLE
   )  
  



 CREATE TABLE "ERP"."CLIENTES" 
   (	"IDCLIENTE" NUMBER(*,0) NOT NULL ENABLE, 
	"NOMBRE" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"RAZONSOCIAL" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"LIMITECREDITO" FLOAT(126) NOT NULL ENABLE, 
	"DIRECCION" VARCHAR2(80 BYTE) NOT NULL ENABLE, 
	"CODIGOPOSTAL" CHAR(5 BYTE) NOT NULL ENABLE, 
	"RFC" CHAR(13 BYTE) NOT NULL ENABLE, 
	"TELEFONO" CHAR(12 BYTE) NOT NULL ENABLE, 
	"EMAIL" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"TIPO" CHAR(1 BYTE) NOT NULL ENABLE, 
	"IDCIUDAD" NUMBER(*,0), 
	 CONSTRAINT "CLIENTES_PK" PRIMARY KEY ("IDCLIENTE")
   )  
 




  CREATE TABLE "ERP"."CLIENTESCULTIVOS" 
   (	"IDCLIENTECULTIVO" NUMBER(*,0) NOT NULL ENABLE, 
	"EXTENSION" FLOAT(126) NOT NULL ENABLE, 
	"UBICACION" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"IDCLIENTE" NUMBER(*,0) NOT NULL ENABLE, 
	"IDCULTIVO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDCIUDAD" NUMBER(*,0), 
	 CONSTRAINT "CLIENTESCULTIVOS_PK" PRIMARY KEY ("IDCLIENTECULTIVO"),
	 CONSTRAINT "CLIENTESCULTIVOS_CULTIVOS_FK" FOREIGN KEY ("IDCULTIVO")
	  REFERENCES "ERP"."CULTIVOS" ("IDCULTIVO") ENABLE, 
	 CONSTRAINT "CLIENTESCULTIVOS_CLIENTES_FK" FOREIGN KEY ("IDCLIENTE")
	  REFERENCES "ERP"."CLIENTES" ("IDCLIENTE") ENABLE
   );
 

 CREATE TABLE "ERP"."VENTAS" 
   (	
    "IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHA" DATE NOT NULL ENABLE, 
	"TOTALPAGAR" FLOAT(126) NOT NULL ENABLE, 
	"CANTPAGADA" FLOAT(126) NOT NULL ENABLE, 
	"COMENTARIOS" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	"TIPO" CHAR(1 BYTE) NOT NULL ENABLE, 
	"IDCLIENTE" NUMBER(*,0), 
	"IDSUCURSAL" NUMBER(*,0), 
	"IDEMPLEADO" NUMBER(*,0), 
    
	 CONSTRAINT "VENTAS_PK" PRIMARY KEY ("IDVENTA"),
     
	 CONSTRAINT "FK_IDCLIENTEVENTAS" FOREIGN KEY ("IDCLIENTE")
	  REFERENCES "ERP"."CLIENTES" ("IDCLIENTE") ENABLE, 
      
	 CONSTRAINT "FK_IDSUCURSALVENTAS" FOREIGN KEY ("IDSUCURSAL")
	  REFERENCES "ERP"."SUCURSALES" ("IDSUCURSAL") ENABLE
   );
  



CREATE TABLE "ERP"."FACTURAS" 
   (	"FOLIO" CHAR(1 BYTE) NOT NULL ENABLE, 
	"SUBTOTAL" FLOAT(126) NOT NULL ENABLE, 
	"IVA" FLOAT(126) NOT NULL ENABLE, 
	"NOMBREDOCXML" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"DOCUMENTOXML" BLOB NOT NULL ENABLE, 
	"NOMBRECOCPDF" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"DOCUMENTOPDF" BLOB NOT NULL ENABLE, 
	"IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "FACTURAS_PK" PRIMARY KEY ("FOLIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FACTURAS_VENTAS_FK1" FOREIGN KEY ("IDVENTA")
	  REFERENCES "ERP"."VENTAS" ("IDVENTA") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("DOCUMENTOXML") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) 
 LOB ("DOCUMENTOPDF") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;


  CREATE TABLE "ERP"."VISITAS" 
   (	"IDVISITA" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHAPLANEADA" DATE NOT NULL ENABLE, 
	"FECHAREAL" DATE NOT NULL ENABLE, 
	"COMENTARIOS" VARCHAR2(200 BYTE) NOT NULL ENABLE, 
	"ESTATUS" CHAR(1 BYTE) NOT NULL ENABLE, 
	"COSTO" FLOAT(126) NOT NULL ENABLE, 
	"IDCLIENTECULTIVO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDEMPLEADO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDUNIDADTRANSPORTE" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "VISITAS_PK" PRIMARY KEY ("IDVISITA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "VISITAS_CLIENTESCULTIVOS_FK" FOREIGN KEY ("IDCLIENTECULTIVO")
	  REFERENCES "ERP"."CLIENTESCULTIVOS" ("IDCLIENTECULTIVO") ENABLE, 
	 CONSTRAINT "VISITAS_UNIDADESTRANSPORTE_FK" FOREIGN KEY ("IDUNIDADTRANSPORTE")
	  REFERENCES "ERP"."UNIDADESTRANSPORTE" ("IDUNIDADTRANSPORTE") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


 CREATE TABLE "ERP"."TRIPULACION" 
   (	
   "IDEMPLEADO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDENVIO" NUMBER(*,0) NOT NULL ENABLE, 
	"ROL" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
    
	 CONSTRAINT "TRIPULACION_PK" PRIMARY KEY ("IDEMPLEADO", "IDENVIO", "ROL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
  
	 CONSTRAINT "TRIPULACION_ENVIOS_FK" FOREIGN KEY ("IDENVIO")
	  REFERENCES "ERP"."ENVIOS" ("IDENVIO") ENABLE
      
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


 CREATE TABLE "ERP"."COBROS" 
   (	
    "IDCOBRO" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHA" DATE NOT NULL ENABLE, 
	"IMPORTE" FLOAT(126) NOT NULL ENABLE, 
	"IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	"IDFORMAPAGO" NUMBER(*,0) NOT NULL ENABLE, 
    
	 CONSTRAINT "COBROS_PK" PRIMARY KEY ("IDCOBRO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
  
	 CONSTRAINT "COBROS_VENTAS_FK" FOREIGN KEY ("IDVENTA")
	  REFERENCES "ERP"."VENTAS" ("IDVENTA") ENABLE
      
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

 CREATE TABLE "ERP"."UNIDADESTRANSPORTE" 
   (	
    "IDUNIDADTRANSPORTE" NUMBER(*,0) NOT NULL ENABLE, 
	"PLACAS" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
	"MARCA" VARCHAR2(80 BYTE) NOT NULL ENABLE, 
	"MODELO" VARCHAR2(80 BYTE) NOT NULL ENABLE, 
	"ANIO" NUMBER(*,0) NOT NULL ENABLE, 
	"CAPACIDAD" NUMBER(*,0) NOT NULL ENABLE, 
    
	 CONSTRAINT "UNIDADESTRANSPORTE_PK" PRIMARY KEY ("IDUNIDADTRANSPORTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
  
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


 CREATE TABLE "ERP"."MANTENIMIENTOS" 
   (	"IDMANTENIMIENTO" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHA" DATE NOT NULL ENABLE, 
	"TALLER" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"COSTO" FLOAT(126) NOT NULL ENABLE, 
	"COMENTARIOS" VARCHAR2(200 BYTE) NOT NULL ENABLE, 
	"TIPO" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"IDUNIDADTRANSPORTE" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "MANTENIMIENTOS_PK" PRIMARY KEY ("IDMANTENIMIENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "MANTENIMIENTOS_UNIDADETRANS_FK" FOREIGN KEY ("IDUNIDADTRANSPORTE")
	  REFERENCES "ERP"."UNIDADESTRANSPORTE" ("IDUNIDADTRANSPORTE") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


 CREATE TABLE "ERP"."ENVIOS" 
   (	
    "IDENVIO" NUMBER(*,0) NOT NULL ENABLE, 
	"FECHAENTREGAPLANEADA" DATE NOT NULL ENABLE, 
	"FECHAENTREGAREAL" DATE NOT NULL ENABLE, 
	"DIRECCION" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"CODIGOPOSTAL" VARCHAR2(5 BYTE) NOT NULL ENABLE, 
	"IDVENTA" NUMBER(*,0) NOT NULL ENABLE, 
	"IDUNIDADTRANSPORTE" NUMBER(*,0) NOT NULL ENABLE, 
	"IDCIUDAD" NUMBER(*,0) NOT NULL ENABLE, 
    
	 CONSTRAINT "ENVIOS_PK" PRIMARY KEY ("IDENVIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
  
	 CONSTRAINT "ENVIOS_UNIDADTRANSPORTE_FK" FOREIGN KEY ("IDUNIDADTRANSPORTE")
	  REFERENCES "ERP"."UNIDADESTRANSPORTE" ("IDUNIDADTRANSPORTE") ENABLE, 
      
	 CONSTRAINT "ENVIOS_VENTAS_FK" FOREIGN KEY ("IDVENTA")
	  REFERENCES "ERP"."VENTAS" ("IDVENTA") ENABLE
      
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


   ---------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------FIN AZUL----------------------------------------------------------------
  ----------------------------------------------------------------------------------------------------------------------------
  
  
  
   ----------------------------------------------------------------------------------------------------------------------------
  ------------------------------------------------------------VERDE-----------------------------------------------------------
  -----------------------------------------------------------------------------------------------------------------------------
create table ERP.Laboratorios(
    idLaboratorio integer not null primary key,
    nombre varchar2(50),
    origen varchar2(30),
    estatus char
);

alter table ERP.Laboratorios add constraint status check (estatus in ('A','B'));
--insert into laboratorios values(1,'laboratorio1','origen1','A');
create sequence ERP.LabID increment by 1 start with 1 nocache;
create sequence ERP.EmpID increment by 1 start with 1 nocache;
create sequence ERP.UniID increment by 1 start with 1 nocache;
insert into Empaques values(ERP.EmpID.nextval,'nombre',500,'A',1);
create table ERP.Categorias(
    idCategoria integer not null primary key,
    nombre varchar2(30),
    estatus char
);
--------------------Restricciones-----------------------------------------------
alter table ERP.Categorias add constraint status check (estatus in('A','B'));
create sequence ERP.CatID increment by 1 start with 1 nocache;

 create table ERP.Productos(
     idProducto integer not null primary key,
     nombre varchar2(50),
     descripcion varchar2(100),
     puntoReorden integer not null,
     precioCompra float not null,
     precioVenta float not null,
     ingredienteActivo varchar2(100) not null,
     bandaToxicologica varchar2(80) not null,
     aplicacion varchar2(200) not null,
     uso varchar(200) not null,
     estatus char not null,
     idLaboratorio integer not null, foreign key(idLaboratorio)
     references Laboratorios(idLaboratorio),
     idCategoria integer not null, foreign key (idCategoria) 
     references Categorias(idCategoria)
 );
 --------------------Restricciones-----------------------------------------------
 alter table ERP.Productos add constraint status check (estatus in ('A','B'));

 create table ERP.ImagenesProducto(
     idImagen integer not null primary key,
     nombreImagen varchar2(100) not null,
     imagen blob not null,
     principal char not null,
     idProducto integer not null, foreign key (idProducto) 
     references Productos(idProducto)
 );

 create table ERP.Proveedores(
     idProveedor integer not null primary key,
     nombre varchar2(80) not null,
     telefono char(12) not null,
     email varchar2(100) not null,
     direccion varchar2(80)not null,
     colonia varchar2(50) not null,
     codigoPostal varchar(5) not null
 );

 create table ERP.ContactosProveedor(
     idContacto integer not null primary key,
     nombre varchar2(80) not null,
     telefono char(12) not null,
     email varchar2(100),
     idProveedor integer not null, foreign key(idProveedor)
     references Proveedores(idProveedor)
 );

 create table ERP.CuentasProveedor(
     idCuentaProveedor integer not null primary key,
     idProveedor integer not null, foreign key(idProveedor) 
     references Proveedores(idProveedor),
     noCuenta varchar2(10) not null,
     banco varchar2(30) not null
 );
 
  create table ERP.Pagos(
      idPago integer not null primary key,
      fecha date not null,
      importe float not null,
      
      idPedido integer not null,foreign key (idPedido) 
      references Pedidos(idPedido),
      
      idFormaPago integer not null, foreign key(idFormaPago)
      references FormaSPago(idFormaPago),
      
      idCuentaProveedor integer not null, foreign key (idCuentaProveedor)
      references CuentasProveedor(idCuentaProveedor)
  );

   create table ERP.Pedidos(
       idPedido integer not null primary key,
       fechaRegistro date not null,
       fechaRecepcion date not null,
       totalPagar float not null,
       cantidadPagada float not null,
       estatus char not null,
       
       idProveedor integer not null, foreign key(idProveedor)
       references Proveedores(idProveedor),
       
       idSucursal integer not null, foreign key(idSucursal)
       references Sucursales(idSucursal),
       
       idEmpleado integer not null, foreign key(idEmpleado)
       references Empleados(idEmpleado)
   );
    
    create table ERP.PedidoDetalle (
        idPedidoDetalle integer not null primary key,
        cantPedida integer not null,
        precioCompra float not null,
        subtotal float not null,
        cantRecibida integer not null,
        cantRechazada integer not null,
        cantAceptada float not null,
        
        idPedido integer not null, foreign key (idPedido)
        references Pedidos(idPedido),
        
        idPresentacion integer not null, foreign key(idPresentacion)
        references PresentacionesProducto(idPresentacion)
    );

create table ERP.PresentacionesProducto(
    idPresentacion Integer not null primary key,
    precioCompra float not null,
    precioVenta float not null,
    puntoReorden float not null,
    idProducto integer not null, foreign key(idProducto)
    references Productos(idProducto),
    idEmpaque integer not null, foreign key(idEmpaque)
    references Empaques(idEmpaque)
);
alter table ERP.PresentacionesProducto

create table ERP.UnidadMedida(
    idUnidad Integer not null primary key,
    nombre varchar2(80)not null,
    siglas varchar2(20)not null,
    estatus char not null
);
 
create table ERP.Empaques(
    idEmpaque Integer not null primary key,
    nombre varchar2(80),
    capacidad float not null,
    estatus char not null,
    idUnidad integer not null, foreign key (idUnidad)
    references UnidadMedida (idUnidad)
);
insert into ERP.Empaques values (ERP.EmpID.nextval,'nombre',500,'A',1);
create table ERP.ProductosProveedor(
    diasRetardo INTEGER not null,
    precioEstandar FLOAT not null, 
    precioUltimaCompra FLOAT not null,
    cantMinPerdir INTEGER not null,
    cantMaxPedir INTEGER not null,
     idProveedor integer not null, foreign key(idProveedor)
     references Proveedores(idProveedor),
     
     idPresentacion integer not null, foreign key(idPresentacion)
     references PresentacionesProducto(idPresentacion)
);

create table ERP.ExistenciasSucursal(
        idPresentacion INTEGER NOT NULL, FOREIGN KEY (idPresentacion) references PresentacionesProducto (idPresentacion),
        idSucursal INTEGER NOT NULL, FOREIGN KEY (idSucursal) references Sucursales (idSucursal),
        cantidad FLOAT not null
);

create table ERP.Sucursales(
        idSucursal INTEGER NOT NULL PRIMARY KEY,
        nombre VARCHAR2(50) not null,
        telefono VARCHAR2(15) not null,
        direccion VARCHAR2(80) not null,
        colonia VARCHAR2(50) not null,
        codigoPostal VARCHAR2(5) not null,
        presupuesto FLOAT not null,
        estatus CHAR not null,
        idCiudad INTEGER NOT NULL, FOREIGN KEY (idCiudad)
        references Ciudades (idCiudad)
);

select count (*) from sys.all_tables where owner = 'ERP';
    ----------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------FIN VERDE-----------------------------------------------------------
  ---------------------------------------------------------------------------------------------------------------------------