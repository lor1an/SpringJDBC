CREATE TABLE Genres(
   ID INTEGER IDENTITY not null,
   name varchar(30),
 );

CREATE TABLE Authors (
    ID INTEGER IDENTITY,
    Name VARCHAR (30) NOT NULL,
    Surname VARCHAR(30) NOT NULL,
);

CREATE TABLE books (
     ID INTEGER IDENTITY,
     Title VARCHAR (70) NOT NULL,
     Author INT NOT NULL, Genre INT NOT NULL,
     Stock INT,
     CONSTRAINT AuthorForeign FOREIGN KEY (Author) REFERENCES authors ,
     CONSTRAINT GenreForeign FOREIGN KEY (Genre) REFERENCES genres
);
