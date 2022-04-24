-- DDL for MySQL

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS author;

CREATE TABLE author
(
    author_id  INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100),
    birth_date DATE
);

DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(255),
    isbn    VARCHAR(255)
);

DROP TABLE IF EXISTS book_author;

CREATE TABLE book_author
(
    author_id INT,
    book_id   INT,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author (author_id),
    FOREIGN KEY (book_id) REFERENCES book (book_id)
);

SET FOREIGN_KEY_CHECKS = 1;
