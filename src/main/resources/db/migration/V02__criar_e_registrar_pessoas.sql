CREATE TABLE pessoa
(
  codigo      SERIAL                NOT NULL,
  nome        CHARACTER VARYING(50) NOT NULL,
  logradouro  CHARACTER VARYING(50),
  numero      CHARACTER VARYING(10),
  complemento CHARACTER VARYING(30),
  bairro      CHARACTER VARYING(30),
  cep         CHARACTER VARYING(15),
  cidade      CHARACTER VARYING(50),
  estado      CHARACTER VARYING(2),
  ativo       BOOLEAN               NOT NULL,

  CONSTRAINT pk_pessoa PRIMARY KEY (codigo)
);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Rômulo Göelzer Portolann', 'Rua Osvaldo Minella', '2029', 'Bloco J, Ap 403', 'Cedro', '88.341-780', 'Camboriú', 'SC', TRUE);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Natália de Oliveira Vacariano Göelzer', 'Rua Osvaldo Minella', '2029', 'Bloco J, Ap 403', 'Cedro', '88.341-780', 'Camboriú', 'SC', TRUE);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Marisa Göelzer', 'Rua Amsterdã', '105', NULL, 'Santa Regina', '88.345-605', 'Camboriú', 'SC', TRUE);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Paulo Ricardo Coutinho Gomes', 'Rua Amsterdã', '105', NULL, 'Santa Regina', '88.345-605', 'Camboriú', 'SC', TRUE);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('João Silva', 'Rua do Abacaxi', '10', NULL, 'Brasil', '38.400-12', 'Uberlândia', 'MG', TRUE);