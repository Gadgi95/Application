INSERT INTO users (name, email, password) VALUES ('John Doe', 'johndoe@example.com', 'admin');
INSERT INTO users (name, email, password) VALUES ('Jane Smith', 'janesmith@example.com', 'user');

INSERT INTO tickets (user_id, name, creationDate, status) VALUES (1, 'App 1', '2021-01-01', 'pending');
INSERT INTO tickets (user_id, name, creationDate, status) VALUES (1, 'App 2', '2021-02-01', 'approved');

INSERT INTO tickets_archive (name, creationDate, closingDate, closedBy) VALUES ('Archive 1', '2021-01-01', '2021-02-01', 1);
INSERT INTO tickets_archive (name, creationDate, closingDate, closedBy) VALUES ('Archive 2', '2021-03-01', '2021-04-01', 2);