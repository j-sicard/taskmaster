-- Data for tests

-- findTasksTest --

-- findAllByUserIdForUser1Test --
INSERT INTO user_data (user_name) VALUES ('User 1');
INSERT INTO task (user_id, description, deadline) VALUES (1, 'Description N°1 For Test findAllByUserIdTest', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (1, 'Description N°2 For Test findAllByUserIdTest', '2025-01-16 11:00:00');

-- findAllByUserIdForUser2Test --
INSERT INTO user_data (user_name) VALUES ('User 2');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°1 For Test findAllByUserIdTest', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°2 For Test findAllByUserIdTest', '2025-01-16 11:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°3 For Test findAllByUserIdTest', '2025-01-16 11:00:00');


-- shouldReturnTaskWithGivenDescription_whenFindAllByUserIdIndex_0_ListTest --
INSERT INTO user_data (user_name) VALUES ('User 3');
INSERT INTO task (user_id, description, deadline) VALUES (3, 'Return description N°1', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (3, 'Return description N°2', '2025-01-16 11:00:00');

-- shouldReturnTaskswithGivenDeadLine_WhenFindAllByUserIdIndex_0_ListTest --
INSERT INTO user_data (user_name) VALUES ('User 4');
INSERT INTO task (user_id, description, deadline) VALUES (4, 'Return description N°1', '2011-11-11 11:11:00');
INSERT INTO task (user_id, description, deadline) VALUES (4, 'Return description N°2', '2025-01-16 11:00:00');

-- shouldReturnTaskswithGivenUserName_WhenFindAllByUserIdIndex_0_ListTest --
INSERT INTO user_data (user_name) VALUES ('User 5');
INSERT INTO task (user_id, description, deadline) VALUES (5, 'Return description N°1', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (5, 'Return description N°2', '2025-01-16 11:00:00');

-- deleteTaskById --

-- deleteTaskByIdTest --
INSERT INTO user_data (user_name) VALUES ('User 6');
INSERT INTO task (user_id, description, deadline) VALUES (6, 'Return description N°1 for User 6', '2025-01-15 10:00:00');

-- createTask --

-- createTask_shouldPersistTaskInRepository --
INSERT INTO user_data (user_name) VALUES ('User 7');




