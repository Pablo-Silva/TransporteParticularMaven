INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'Maria','Garcia da Silva','10/08/1985','F','123.456.789-00','999887766','garcia@com.br');

INSERT INTO CLIENTE_TABLE(ID_CLIENTE,ID_PESSOA,BANDEIRA_CARTAO,NUMERO_CARTAO) 
VALUES(CLIENTE_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'VISA',12345678);

--MOTORISTA

INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'João','Da Silva','11/11/1972','M','987.654.321-00','99998888','joao@com.br');

INSERT INTO MOTORISTA_TABLE(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) 
VALUES(MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'18/06/2018','A', '46061554699');


INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'Maria','Da Costa','13/01/1980','F','987.654.321-00','99998888','maria@com.br');

INSERT INTO MOTORISTA_TABLE(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) 
VALUES(MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'18/06/2018','A', '46061554699');

INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'Paulo','Da Silva','11/11/1972','M','987.654.321-00','99998888','paulo@com.br');

INSERT INTO MOTORISTA_TABLE(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) 
VALUES(MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'18/06/2018','A', '46061554699');

INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'Ana','Da Silva','11/11/1972','M','987.654.321-00','99998888','ana@com.br');

INSERT INTO MOTORISTA_TABLE(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) 
VALUES(MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'18/06/2018','A', '46061554699');

INSERT INTO PESSOA_TABLE(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) 
VALUES(PESSOA_SEQUENCE.NEXTVAL,'Karen','Da Silva','11/11/1972','M','987.654.321-00','99998888','karen@com.br');

INSERT INTO MOTORISTA_TABLE(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) 
VALUES(MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL,'18/06/2018','A', '46061554699');


-- VEICULO

INSERT INTO VEICULO_TABLE(ID_VEICULO,ID_MOTORISTA,PLACA_VEICULO,MODELO_VEICULO,MARCA_VEICULO,COR_VEICULO,ACENTOS_VEICULO) 
VALUES(VEICULO_SEQUENCE.NEXTVAL,MOTORISTA_SEQUENCE.CURRVAL,'HQK-2206','GOL','Volkswagen','VERMELHO',4);

INSERT INTO VIAGEM_TABLE(ID_VIAGEM,ID_VEICULO,ID_MOTORISTA,ID_CLIENTE,ENDERECO_SAIDA,ENDERECO_CHEGADA,DATA_INICIO,DATA_FIM) 
VALUES(VIAGEM_SEQUENCE.NEXTVAL,VEICULO_SEQUENCE.CURRVAL,MOTORISTA_SEQUENCE.CURRVAL,CLIENTE_SEQUENCE.CURRVAL,'Av. Pres. Getúlio Vargas, 892 - Rebouças, Curitiba',
'R. Nilo Peçanha, 1635 - Bom Retiro, Curitiba','18/06/2018','18/06/2018');

COMMIT;

SELECT * FROM PESSOA_TABLE;

SELECT * FROM CLIENTE_TABLE;

SELECT * FROM MOTORISTA_TABLE;

SELECT * FROM VEICULO_TABLE;

SELECT * FROM VIAGEM_TABLE;