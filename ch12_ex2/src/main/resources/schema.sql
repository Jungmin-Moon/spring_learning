CREATE TABLE IF NOT EXISTS purchases.purchase (
	id INT AUTO_INCREMENT PRIMARY KEY,
    product varchar(50) NOT NULL,
    price double NOT NULL
);