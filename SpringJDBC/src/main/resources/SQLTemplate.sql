CREATE TABLE Genres(
   id INTEGER IDENTITY not null,
   name varchar(30),

 );

insert into Genres (name)
values ('sci-fi');
    --CALL IDENTITY();

insert into Genres (name) 
values ('fantasy');
--     CALL IDENTITY();

-- CREATE TABLE authors (ID INT AUTO_INCREMENT, Name VARCHAR (35) NOT NULL,Surname VARCHAR(35) NOT NULL, CONSTRAINT authorsPrimary PRIMARY KEY (ID));
-- 
-- CREATE TABLE genres (ID INT AUTO_INCREMENT, Name VARCHAR (35) NOT NULL, CONSTRAINT genresPrimary PRIMARY KEY (ID));
-- 
-- CREATE TABLE books (ID INT AUTO_INCREMENT, Title VARCHAR (70) NOT NULL, Author INT NOT NULL, Genre INT NOT NULL, Stock INT, CONSTRAINT booksPrimary PRIMARY KEY (ID), CONSTRAINT AuthorForeign FOREIGN KEY (Author) REFERENCES authors, CONSTRAINT GenreForeign FOREIGN KEY (Genre) REFERENCES genres);
-- 
-- ---------------------------------------------------------------
-- 
-- ALTER TABLE books ADD CONSTRAINT genresForeign FOREIGN KEY (Genre)  REFERENCES genres(ID);
-- 
-- ---------------------------------------------------------------
-- 
-- INSERT INTO authors (Name, Surname) values ('John', 'Tolkien');
-- INSERT INTO authors (Name, Surname) values ('George', 'Martin');
-- INSERT INTO authors (Name, Surname) values ('Roger', 'Zelazny');
-- INSERT INTO authors (Name, Surname) values ('Ray', 'Bradbury');
-- INSERT INTO authors (Name, Surname) values ('Isak', 'Asimov');
-- INSERT INTO authors (Name, Surname) values ('Douglas', 'Adams');
-- INSERT INTO authors (Name, Surname) values ('Neil', 'Gaiman');
-- 
-- ---------------------------------------------------------------
-- 
-- INSERT INTO genres (Name) values ('Fantasy'); 
-- INSERT INTO genres (Name) values ('Sci-Fi');
-- 
-- -----------------------------------------------------------------
-- 
-- INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Fellowship of the Ring', 1, 1 , 5);
-- INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Two Tower', 1, 1 , 5);
-- INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Return of the King', 1, 1 , 5);
-- INSERT INTO books(Title, Author, Genre, Stock) values ('The Hobbit, or There and Back Again', 1, 1 , 5);
-- INSERT INTO books(Title, Author, Genre, Stock) values ('A Game of Thrones', 2, 1 , 3);INSERT INTO books(Title, Author, Genre, Stock) values ('A Clash of Kings', 2, 1 , 3); INSERT INTO books(Title, Author, Genre, Stock) values ('A Storm of Swords', 2, 1 , 3); INSERT INTO books(Title, Author, Genre, Stock) values ('A Feast for Crows', 2, 1 , 3); INSERT INTO books(Title, Author, Genre, Stock) values ('A Dance with Dragons', 2, 1 , 3); 
-- INSERT INTO books(Title, Author, Genre, Stock) values ('The Chronicles of Amber', 3, 1 , 10); INSERT INTO books(Title, Author, Genre, Stock) values ('The Martian Chronicles', 4, 2 , 2); INSERT INTO books(Title, Author, Genre, Stock) values ('Fahrenheit 451', 4, 2 , 2); INSERT INTO books(Title, Author, Genre, Stock) values ('The End of Eternity', 5, 2 , 3); INSERT INTO books(Title, Author, Genre, Stock) values ('Profession', 5, 2 , 2); INSERT INTO books(Title, Author, Genre, Stock) values ('Nightfall', 5, 2 , 1); INSERT INTO books(Title, Author, Genre, Stock) values ('The Hitchhikers Guide to the Galaxy', 6, 2 , 4);
-- INSERT INTO books(Title, Author, Genre, Stock) values ('American Gods', 7, 1, 4); INSERT INTO books(Title, Author, Genre, Stock) values ('Anansi Boys', 7, 1, 2); INSERT INTO books(Title, Author, Genre, Stock) values ('Newerhere', 7, 1, 4); 
--  INSERT INTO books(Title, Author, Genre, Stock) values ('The Graveyard Book', 7, 1, 3);
-- 
--  -----------------------------------------------------------------
