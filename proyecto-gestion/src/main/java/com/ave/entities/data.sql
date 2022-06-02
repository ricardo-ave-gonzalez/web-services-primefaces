drop database if exists proyecto;
create database proyecto;
use proyecto;

drop table if exists usuarios;

CREATE TABLE usuarios (
  id varchar(250) NOT NULL,
  username varchar(250) NOT NULL,
  password varchar(250) NOT NULL,
  producto_id varchar(250)
);

ALTER TABLE usuarios
  ADD PRIMARY KEY (`id`);  
  
INSERT INTO usuarios (`id`, `username`, `password`) VALUES
('556a84e7-1f90-4996-8fa2-f5d86a461e63', 'richard', '$2a$10$MbHtGVKOtPEWvps6tEw2z.8soQwm5VULNqQ2BiZg/LPxBV2YQPy7W'),
('8f8efa39-fffb-40e8-acab-fea2a5cd7ef2', 'admin', 'admin'),
('8db1716e-6189-4b61-bd91-a9323abfba0e', 'simplelogin', 'simplelogin');


CREATE TABLE productos (
  id varchar(250) NOT NULL,
  descripcion varchar(250) NOT NULL,
  precio double NOT NULL
);

ALTER TABLE productos
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE usuarios
  ADD CONSTRAINT FK_productos_usuarios
  FOREIGN key(producto_id)
  REFERENCES productos(id);

  