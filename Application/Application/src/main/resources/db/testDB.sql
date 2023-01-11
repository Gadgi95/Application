INSERT INTO User (name, mail, ROLE) VALUES ('John Doe', 'johndoe@example.com', 'admin');
INSERT INTO User (name, mail, ROLE) VALUES ('Jane Smith', 'janesmith@example.com', 'user');

INSERT INTO Application (name, creationDate, status) VALUES ('App 1', '2021-01-01', 'pending');
INSERT INTO Application (name, creationDate, status) VALUES ('App 2', '2021-02-01', 'approved');

INSERT INTO archive (name, creationDate, closingDate, closedBy) VALUES ('Archive 1', '2021-01-01', '2021-02-01', 1);
INSERT INTO archive (name, creationDate, closingDate, closedBy) VALUES ('Archive 2', '2021-03-01', '2021-04-01', 2);