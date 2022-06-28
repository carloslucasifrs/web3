INSERT INTO users (id, cpf, name) VALUES ('bf79fbcd-9464-48e4-840b-16d6d55d5301', '05891913739', 'Beltrano de Tal');
INSERT INTO users (id, cpf, name) VALUES ('fe409e5b-2bd4-4889-8160-8c31d19bf575', '16536078748', 'Fulano de Tal');
INSERT INTO users (id, cpf, name) VALUES ('7a46e484-0cce-4ac1-a53b-8534ecb06368', '67384572606', 'Ciclano de Tal');


INSERT INTO roles (role) VALUES ('admin');
INSERT INTO roles (role) VALUES ('supervisor');
INSERT INTO roles (role) VALUES ('usuario');

INSERT INTO permissions (permission, model) VALUES ('create', 'users');
INSERT INTO permissions (permission, model) VALUES ('read', 'users');
INSERT INTO permissions (permission, model) VALUES ('update', 'users');
INSERT INTO permissions (permission, model) VALUES ('delete', 'users');

INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (1,1);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (1,2);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (1,3);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (1,4);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (2,1);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (2,2);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (2,3);
INSERT INTO roles_has_permissions (role_id, permission_id) VALUES (3,1);