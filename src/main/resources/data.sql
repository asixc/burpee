
INSERT INTO burpee_users(username, password)
VALUES ('user1', '$2a$10$h.f4SDgzkyUUEjA2r9DEiu1vQTI1ElrroSCUrGGpLuvcGeYsObYRi');

INSERT INTO burpee_users(username, password)
VALUES ('user2', '$2a$10$os.XOwaLS.8gLAAlQCHIoevU41SMKkqgS.8od7A4Ab0ZzEZRkVCQ.');

INSERT INTO authorities(name, id_user) VALUES ('read', 1);
INSERT INTO authorities(name, id_user) VALUES ('read', 2);

INSERT INTO burpee.burpee
(id, amount, create_date, modify_date, burpee_type, id_user)
VALUES(1, 10, '2022-03-16 00:32:58.000', '2022-03-16 00:32:58.000', NULL, 1);
INSERT INTO burpee.burpee
(id, amount, create_date, modify_date, burpee_type, id_user)
VALUES(2, 13, '2022-03-16 00:33:04.000', '2022-03-16 00:33:04.000', NULL, 1);

