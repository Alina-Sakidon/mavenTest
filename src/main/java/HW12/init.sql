CREATE TABLE IF NOT EXISTS Homework
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) UNIQUE  NOT NULL,
    description VARCHAR(255)  NOT NULL
    );

CREATE TABLE IF NOT EXISTS Lesson
(
    id          serial PRIMARY KEY,
    homework_id INTEGER,
    name        VARCHAR(50) UNIQUE  NOT NULL,
    updatedAt TIMESTAMP  NOT NULL ,
    FOREIGN KEY (homework_id) REFERENCES Homework (id)
    );

CREATE TABLE IF NOT EXISTS Schedule
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    updatedAt TIMESTAMP  NOT NULL ,
    lesson_id INTEGER,
    FOREIGN KEY (lesson_id) REFERENCES Lesson (id)
    );

DROP TABLE IF EXISTS Schedule
    CASCADE;

INSERT INTO Homework (name, description)
VALUES (?, ?);

INSERT INTO Lesson (name, updatedAt, homework_id )
VALUES ('Lesson 2', CURRENT_TIMESTAMP, 1);

INSERT INTO Schedule (name, updatedAt, lesson_id )
VALUES ('Monday', CURRENT_TIMESTAMP, 1);

UPDATE Schedule SET name = 'Friday' WHERE lesson_id=1;

ALTER TABLE Lesson add column if not exists test_column  VARCHAR(10);
ALTER TABLE Lesson drop column if exists test_column;