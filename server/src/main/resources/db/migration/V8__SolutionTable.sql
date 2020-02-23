CREATE TABLE solution (
    id SERIAL NOT NULL,
    questionId INT NOT NULL,
    assignmentId INT NOT NULL,
    userId INT NOT NULL,
    content VARCHAR NOT NULL,
    correct BOOLEAN NOT NULL DEFAULT FALSE,
    submitted BOOLEAN NOT NULL DEFAULT FALSE
)