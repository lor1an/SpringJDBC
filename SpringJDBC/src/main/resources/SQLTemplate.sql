CREATE TABLE Genres(
   id INTEGER IDENTITY not null,
   name varchar(30),
 );

CREATE TABLE authors (
    ID INTEGER IDENTITY,
    Name VARCHAR (30) NOT NULL,
    Surname VARCHAR(30) NOT NULL,
);

CREATE TABLE books (
     ID INTEGER IDENTITY,
     Title VARCHAR (70) NOT NULL,
     Author INT NOT NULL, Genre INT NOT NULL,
     Stock INT,
     CONSTRAINT AuthorForeign FOREIGN KEY (Author) REFERENCES authors,
     CONSTRAINT GenreForeign FOREIGN KEY (Genre) REFERENCES genres
);

INSERT INTO authors (Name, Surname) values ('John', 'Tolkien');
INSERT INTO authors (Name, Surname) values ('George', 'Martin');
INSERT INTO authors (Name, Surname) values ('Roger', 'Zelazny');
INSERT INTO authors (Name, Surname) values ('Ray', 'Bradbury');
INSERT INTO authors (Name, Surname) values ('Isak', 'Asimov');
INSERT INTO authors (Name, Surname) values ('Douglas', 'Adams');
INSERT INTO authors (Name, Surname) values ('Neil', 'Gaiman');

INSERT INTO genres (Name) values ('Fantasy'); 
INSERT INTO genres (Name) values ('Sci-Fi');

INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Fellowship of the Ring', 0, 0 , 5);
INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Two Tower', 0, 0 , 5);
INSERT INTO books(Title, Author, Genre, Stock) values ('The Lord of the Rings: The Return of the King', 0, 0 , 5);
INSERT INTO books(Title, Author, Genre, Stock) values ('The Hobbit, or There and Back Again', 0, 0 , 5);
INSERT INTO books(Title, Author, Genre, Stock) values ('A Game of Thrones', 1, 0 , 3);
INSERT INTO books(Title, Author, Genre, Stock) values ('A Clash of Kings', 1, 0 , 3);
INSERT INTO books(Title, Author, Genre, Stock) values ('A Storm of Swords', 1, 0 , 3);
INSERT INTO books(Title, Author, Genre, Stock) values ('A Feast for Crows', 1, 0 , 3);
INSERT INTO books(Title, Author, Genre, Stock) values ('A Dance with Dragons', 1, 0 , 3); 
INSERT INTO books(Title, Author, Genre, Stock) values ('The Chronicles of Amber', 2, 0 , 10);
INSERT INTO books(Title, Author, Genre, Stock) values ('The Martian Chronicles', 3, 1 , 2);
INSERT INTO books(Title, Author, Genre, Stock) values ('Fahrenheit 451', 3, 1 , 2);
 INSERT INTO books(Title, Author, Genre, Stock) values ('The End of Eternity', 4, 1 , 3);
 INSERT INTO books(Title, Author, Genre, Stock) values ('Profession', 4, 1 , 2);
 INSERT INTO books(Title, Author, Genre, Stock) values ('Nightfall', 4, 1 , 1);
 INSERT INTO books(Title, Author, Genre, Stock) values ('The Hitchhikers Guide to the Galaxy', 5, 1 , 4);
 INSERT INTO books(Title, Author, Genre, Stock) values ('American Gods', 6, 0, 4);
INSERT INTO books(Title, Author, Genre, Stock) values ('Anansi Boys', 6, 0, 2);
 INSERT INTO books(Title, Author, Genre, Stock) values ('Newerhere', 6, 0, 4); 
 INSERT INTO books(Title, Author, Genre, Stock) values ('The Graveyard Book', 6, 0, 3);
