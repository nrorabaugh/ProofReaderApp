CREATE TABLE question (
    id SERIAL NOT NULL PRIMARY KEY,
    assignmentId INT NOT NULL,
    number INT NOT NULL,
    content VARCHAR NOT NULL,
    solution VARCHAR NOT NULL
)