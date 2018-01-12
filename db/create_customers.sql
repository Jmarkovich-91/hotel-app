CREATE TABLE customers (
  customer_id varchar(5) NOT NULL PRIMARY KEY,
  last_name varchar(100),
  first_name varchar(100),
  email varchar(100),
  phone_number char(10)
);
CREATE INDEX customers_customer_id ON customers(customer_id);