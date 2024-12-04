CREATE TABLE categoria (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo_categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE videos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    url VARCHAR(100) NOT NULL,
    categoria_id BIGINT,
    PRIMARY KEY (id),

    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id) 
        ON DELETE SET NULL
        ON UPDATE CASCADE
);