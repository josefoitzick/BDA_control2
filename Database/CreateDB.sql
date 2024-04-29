-- Crear tabla institution
CREATE TABLE userTask (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL
);

-- Crear tabla emergency
CREATE TABLE Task (
    id BIGSERIAL PRIMARY KEY,
    id_usertask BIGINT,
    title TEXT,
    description TEXT,
    due_date DATE,
    FOREIGN KEY (id_userTask) REFERENCES userTask(id)
);
