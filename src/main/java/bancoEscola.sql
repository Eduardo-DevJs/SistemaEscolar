CREATE TABLE usuarios (
id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
senha VARCHAR(50) NOT NULL,
perfil VARCHAR(100) NOT NULL
);

INSERT INTO usuarios (nome,senha,perfil) VALUES ("admin","admin","administrador");

CREATE TABLE professores (
id_professor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
disciplina VARCHAR(50) NOT NULL,
telefone VARCHAR(20) NOT NULL,
email VARCHAR(45) NOT NULL
);

CREATE TABLE alunos (
 id_aluno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 idade int(10) NOT NULL,
 matricula VARCHAR(100) NOT NULL,
 telefone VARCHAR(20) NOT NULL,
 endereco VARCHAR(100) NOT NULL
);

CREATE TABLE turmas (
    id_turma INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sala VARCHAR(10) NOT NULL,
    id_professor INT,
    id_aluno INT,
    CONSTRAINT fk_turma_professor FOREIGN KEY (id_professor) REFERENCES professores(id_professor),
    CONSTRAINT fk_turma_aluno FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno)
);
