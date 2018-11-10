CREATE TABLE users (
  id int auto_increment PRIMARY KEY,
  username varchar(126),
  password varchar(126),	
  superu BOOLEAN,
  puntos int,
  created_at DATETIME,
  updated_at DATETIME
  );
