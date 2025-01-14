-- findTasksTest --

-- User integration --
INSERT INTO user_data (user_name) VALUES ('Test User');
INSERT INTO task (user_id, description, deadline) VALUES (1, 'Test task description', '2025-01-15 10:00:00');
