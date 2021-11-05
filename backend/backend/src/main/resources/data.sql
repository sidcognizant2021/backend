DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks(
  id IDENTITY PRIMARY KEY,
  title VARCHAR(255),
  details VARCHAR(255),
  when VARCHAR(255),
  deadline VARCHAR(255),
  is_project BOOLEAN,
  parent INT,
  done BOOLEAN
); 

INSERT INTO tasks (title, details, when, deadline, is_project, parent, done) VALUES
	('Staff meeting', '', '', '9/10/2021', true, -1, true),
	('App2 Development', '', '', '9/10/2021', true, -1, false),
	('Lunch with friends.', '', '', '9/9/2021', false, -1, false),
	('Finish coding App2', '', '', '9/9/2021', false, 2, false),
	('Run tests on App2', '', '', '9/9/2021', false, -1, false),
	('Put up testing environment', '', '', '9/10/2021', false, 2, true),
	('Submit last month''s expenses', '', '', '9/9/2021', false, -1, false),
	('Get $ for weekend from ATM', '', '', '9/9/2021', false, -1, false),
	('Call Cindy in Accounting', '', '', '9/9/2021', false, -1, false),
	('Schedule doctor visit', 'Maecenas leo odio,', '', '9/9/2021', false, -1, false),
	('Pick up kids after soccer practice', '', '', '9/9/2021', false, -1, false),
	('Personal Tasks', 'details', '', '9/9/2021', true, -1, false),
	('New task', '', '', '9/9/2021', false, -1, false);