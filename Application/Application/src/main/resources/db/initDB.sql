CREATE TABLE User (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      mail VARCHAR(255) NOT NULL,
                      ROLE ENUM('admin', 'user') NOT NULL
);

CREATE TABLE Ticket (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             user_id INT NOT NULL,
                             name VARCHAR(255) NOT NULL,
                             creationDate DATE NOT NULL,
                             status ENUM('NEW', 'IN_PROGRESS', 'CLOSED') NOT NULL
);

CREATE TABLE archive (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         creationDate DATE NOT NULL,
                         closingDate DATE NOT NULL,
                         closedBy INT,
                         FOREIGN KEY (closedBy) REFERENCES User(id)
);