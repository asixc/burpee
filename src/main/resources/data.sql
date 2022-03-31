INSERT INTO burpee.burpee_users (password,username) VALUES
	 ('$2a$10$ho9OP5EZEY3H3dSi8D7tWeo3Iaf8pKX5jBmxO6IjHX9v2KPhSYVoK','user1');

INSERT INTO burpee.burpee_users (password,username) VALUES
    ('$2a$10$ho9OP5EZEY3H3dSi8D7tWeo3Iaf8pKX5jBmxO6IjHX9v2KPhSYVoK','user2');


INSERT INTO burpee.user_authorities (user_id,authorities) VALUES
	 (1,'READ');
INSERT INTO burpee.user_authorities (user_id,authorities) VALUES
	 (2,'WRITE');
