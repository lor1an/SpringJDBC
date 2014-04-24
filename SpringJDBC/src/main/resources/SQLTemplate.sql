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