DELETE FROM user_roles;
DELETE FROM tickets_archive;
DELETE FROM tickets_materials;
DELETE FROM materials;
DELETE FROM tickets;
DELETE FROM users;

INSERT INTO users (name, email, password)
VALUES ('Alexander', 'alexander@example.com', 'admin'),
       ('Pavel', 'pavel@example.com', 'user1'),
       ('Ilgiz', 'ilgiz@example.com', 'user2');

INSERT INTO user_roles (role, user_id)
VALUES ('ADMIN', 1),
       ('SUPPLIER', 1),
       ('USER', 2),
       ('FOREMAN', 2),
       ('USER', 3),
       ('FOREMAN', 3);

INSERT INTO tickets (user_id, objectName, name, status, deliveryDate)
VALUES (1, 'Рига', 'App 1', 'pending', null),
       (2, 'Наследие', 'App 2', 'approved', '2023-06-25'),
       (2, 'Наследие', 'App 3', 'approved', NOW());

INSERT INTO materials (ticket_id, name, quantity, characteristics, hasFactoryMarriage, marriageDetectionDate, marriageDescription, marriagePhotoUrl)
VALUES (1, 'Краска', '2', 'черная', false, null, null, null),
       (2, 'Кирпич', '1000', 'синий', false, null, null, null),
       (3, 'Кирпич', '1000', 'синий', true, NOW(), 'Сколы на кирпиче', 'https://stackoverflow.com/1/'),
       (3, 'Доски', '500', 'лакированные', true, NOW(), 'Трещины сверху', 'https://stackoverflow.com/2/');

INSERT INTO tickets_archive (name, creationDate, closingDate, closedBy)
VALUES ('Archive 1', '2021-01-01', '2021-02-01', 1),
       ('Archive 2', '2021-03-01', NOW(), 2);

INSERT INTO tickets_materials (ticket_id, material_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4);

