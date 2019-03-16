CREATE TABLE categoria
(
  codigo SERIAL      NOT NULL,
  nome   VARCHAR(50) NOT NULL,

  CONSTRAINT pk_categoria PRIMARY KEY (codigo)
);

INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Supermercado');
INSERT INTO categoria (nome) VALUES ('Farmácia');
INSERT INTO categoria (nome) VALUES ('Outros');