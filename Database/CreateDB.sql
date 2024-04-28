-- Crear tabla institution
CREATE TABLE userTask (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
);

-- Crear tabla emergency
CREATE TABLE Task (
    id BIGSERIAL PRIMARY KEY,
    id_userTask BIGINT,
    title TEXT,
    description TEXT,
    due_date DATE,
    
    FOREIGN KEY (id_userTask) REFERENCES userTask(id)
);
