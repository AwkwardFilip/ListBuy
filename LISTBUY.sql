/*   CRIANDO TABELAS    */

/* -- DROP TABLE --
	DROP TABLE PESSOALISTACOMPRA;
	DROP TABLE LISTACOMPRA;
	DROP TABLE CATEGORIAPRODUTO;
	DROP TABLE PRODUTOLOJA;
	DROP TABLE ITEM;
	DROP TABLE PESSOA;
	DROP TABLE LOJA;
	DROP TABLE PRODUTO;
	DROP TABLE CATEGORIA;
*/

CREATE TABLE CATEGORIA(
	IDCATEGORIA INT NOT NULL PRIMARY KEY,
	NOME VARCHAR2(45)
);

CREATE TABLE LOJA(
	IDLOJA INT NOT NULL PRIMARY KEY,
	NOME VARCHAR2(45),
	SITE VARCHAR2(150),
	LOGOMARCA VARCHAR2(45)
);

CREATE TABLE PRODUTO(
	IDPRODUTO INT NOT NULL PRIMARY KEY,
	DESCRICAO VARCHAR2(150),
	IMAGEM VARCHAR2(150),
	NOME VARCHAR2(100),
	FABRICANTE VARCHAR2(100)
);

CREATE TABLE PESSOA(
	EMAIL VARCHAR2(150) NOT NULL PRIMARY KEY,
	SENHA VARCHAR(45),
	NOME VARCHAR2(200),
	DTNASC DATE,
	TELEFONE VARCHAR2(20),
	PRIVILEGIO VARCHAR(30)
);

CREATE TABLE LISTACOMPRA(
	IDLISTACOMPRA INT PRIMARY KEY,
	DATALISTACOMPRA DATE
);

CREATE TABLE PESSOALISTACOMPRA(
PESSOA_EMAIL VARCHAR2(150),
LISTACOMPRA_ID INT,
CONSTRAINT FK_PESSOA FOREIGN KEY (PESSOA_EMAIL) REFERENCES PESSOA(EMAIL),
CONSTRAINT FK_LISTACOMPRA FOREIGN KEY (LISTACOMPRA_ID) REFERENCES LISTACOMPRA(IDLISTACOMPRA)
);

CREATE TABLE PRODUTOLOJA(
	PRODUTO_ID INT,
	LOJA_ID INT,
	CONSTRAINT FK_PRODUTO FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(IDPRODUTO),
	CONSTRAINT FK_LOJA FOREIGN KEY (LOJA_ID) REFERENCES LOJA(IDLOJA)
);

CREATE TABLE ITEM(
	IDITEM INT PRIMARY KEY,
	PRODUTO_ID INT,
	LOJA_ID INT,
	LISTACOMPRA_ID INT,
	PRECO DECIMAL,
	DESCONTO DECIMAL,
	QUANTIDADE INT,
	CONSTRAINT FK_PRODITEM FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(IDPRODUTO),
	CONSTRAINT FK_LOJAITEM FOREIGN KEY (LOJA_ID) REFERENCES LOJA(IDLOJA),
	CONSTRAINT FK_LC_ITEM FOREIGN KEY (LISTACOMPRA_ID) REFERENCES LISTACOMPRA(IDLISTACOMPRA)
);


CREATE TABLE CATEGORIAPRODUTO(
	CATEGORIA_ID INT,
	PRODUTO_ID INT,
	CONSTRAINT PK_CHASP PRIMARY KEY(CATEGORIA_ID,PRODUTO_ID),
	CONSTRAINT FK_CATEGORIA FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(IDCATEGORIA),
	CONSTRAINT FK_PROD FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(IDPRODUTO)
);



/* -- CRIANDO SEQUENCES -- */

/*  --  DROP SEQUENCES  --
DROP SEQUENCE ITEM_SEQ;
DROP SEQUENCE CATEGORIA_SEQ;
DROP SEQUENCE LOJA_SEQ;
DROP SEQUENCE PRODUTO_SEQ;
DROP SEQUENCE LISTACOMPRA_SEQ;
*/

CREATE SEQUENCE CATEGORIA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
 CREATE SEQUENCE ITEM_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
 
CREATE SEQUENCE LISTACOMPRA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
 
CREATE SEQUENCE LOJA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
  
CREATE SEQUENCE PRODUTO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


/* -- INSERT ON TABLES -- */

commit;
