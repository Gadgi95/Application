CREATE TABLE users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255)           NOT NULL,
    email      VARCHAR(255)           NOT NULL,
    password   VARCHAR(255)           NOT NULL,
    registered DATETIME DEFAULT NOW() NOT NULL
);

CREATE TABLE tickets
(
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    user_id               INT                    NOT NULL,
    name                  VARCHAR(255)           NOT NULL,
    creationDate          DATETIME DEFAULT NOW() NOT NULL,
    status                VARCHAR(255)           NOT NULL,
    responsibleSupplier   VARCHAR(255),
    deliveryDate          DATE,
    statusChangeDate      DATE,
    isClosed              BOOLEAN,
    closingDate           DATE,
    closedBy              VARCHAR(255),
    hasFactoryMarriage    BOOLEAN,
    marriageDetectionDate DATE,
    marriageDetectedBy    VARCHAR(255),
    marriageDescription   VARCHAR(255),
    marriagePhotoUrl      VARCHAR(255),
    objectName            VARCHAR(255)
);

CREATE TABLE tickets_archive
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255)           NOT NULL,
    creationDate DATETIME DEFAULT NOW() NOT NULL,
    closingDate  DATE                   NOT NULL,
    closedBy     INT,
    FOREIGN KEY (closedBy) REFERENCES users (id)
);

CREATE TABLE materials
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255),
    quantity        INT,
    characteristics VARCHAR(255),
    cost            INT
);
CREATE TABLE user_roles
(
    user_id INT,
    role    VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
CREATE TABLE tickets_materials
(
    ticket_id   INT,
    material_id INT,
    FOREIGN KEY (ticket_id) REFERENCES tickets (id),
    FOREIGN KEY (material_id) REFERENCES materials (id)
);

SELECT *
FROM tickets
ORDER BY objectName;
SELECT *
FROM tickets
ORDER BY user_id;
SELECT *
FROM tickets
ORDER BY creationDate;

SELECT tickets.id, tickets.name, materials.name
FROM tickets
         JOIN tickets_materials ON tickets.id = tickets_materials.ticket_id
         JOIN materials ON tickets_materials.material_id = materials.id
ORDER BY materials.name;