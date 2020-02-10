CREATE TABLE calculation (
    id SERIAL NOT NULL PRIMARY KEY,
    solutionId INT NOT NULL,
    expression VARCHAR(100) NOT NULL,
    comment VARCHAR(250)
)