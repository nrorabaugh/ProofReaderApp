CREATE TABLE message (
    id SERIAL NOT NULL PRIMARY KEY,
    senderId INT NOT NULL,
    assignmentId INT NOT NULL,
    content VARCHAR NOT NULL,
    eq VARCHAR(150)
)