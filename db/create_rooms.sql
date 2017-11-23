CREATE TABLE rooms (
  room_number varchar(5) NOT NULL PRIMARY KEY,
  type varchar(100),
  price decimal(15,2),
  booked varchar(5)
);
CREATE INDEX rooms_room_number ON rooms(room_number);