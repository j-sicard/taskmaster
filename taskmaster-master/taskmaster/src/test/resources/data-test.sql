-- Data for tests

-- findTasksTest --

-- findAllByUserIdForUser1Test TaskRepository --
INSERT INTO user_data (user_id, user_name) VALUES (1L, 'User 1');
INSERT INTO task (user_id, description, deadline) VALUES (1, 'Description N°1 For Test findAllByUserIdTest', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (1, 'Description N°2 For Test findAllByUserIdTest', '2025-01-16 11:00:00');

-- findAllByUserIdForUser2Test TaskRepository --
INSERT INTO user_data (user_id, user_name) VALUES (2L, 'User 2');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°1 For Test findAllByUserIdTest', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°2 For Test findAllByUserIdTest', '2025-01-16 11:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (2, 'Description N°3 For Test findAllByUserIdTest', '2025-01-16 11:00:00');


-- shouldReturnTaskWithGivenDescription_whenFindAllByUserIdIndex_0_ListTest TaskService --
INSERT INTO user_data (user_id, user_name) VALUES (3L, 'User 3');
INSERT INTO task (user_id, description, deadline) VALUES (3, 'Return description N°1', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (3, 'Return description N°2', '2025-01-16 11:00:00');

-- shouldReturnTaskWithGivenDeadLine_WhenFindAllByUserIdIndex_0_ListTest TaskService --
INSERT INTO user_data (user_name) VALUES ('User 4');
INSERT INTO task (user_id, description, deadline) VALUES (4, 'Return description N°1', '2011-11-11 11:11:00');
INSERT INTO task (user_id, description, deadline) VALUES (4, 'Return description N°2', '2025-01-16 11:00:00');

-- shouldReturnTaskWithGivenUserName_WhenFindAllByUserIdIndex_0_ListTest TaskService --
INSERT INTO user_data (user_id, user_name) VALUES (5l, 'User 5');
INSERT INTO task (user_id, description, deadline) VALUES (5, 'Return description N°1', '2025-01-15 10:00:00');
INSERT INTO task (user_id, description, deadline) VALUES (5, 'Return description N°2', '2025-01-16 11:00:00');

-- deleteTaskById TaskService --

-- deleteTaskByIdTest TaskService --
INSERT INTO user_data (user_id, user_name) VALUES (6L, 'User 6');
INSERT INTO task (user_id, description, deadline) VALUES (6, 'Return description N°1 for User 6', '2025-01-15 10:00:00');

-- createTask TaskService --

-- createTask_shouldPersistTaskInRepository --
INSERT INTO user_data (user_id, user_name) VALUES (7L, 'User 7');

-- createTask BusinessTask --

INSERT INTO user_data (user_id, user_name) VALUES (8L, 'User 8');

--deleteTask BusinessTask --
INSERT INTO user_data (user_id, user_name) VALUES (10L, 'User 10');
INSERT INTO task (user_id, description, deadline) VALUES (10L,  'Return description N°1 for User 10', '2025-01-15 10:00:00');




