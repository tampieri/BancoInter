CREATE SCHEMA DATABASE;
CREATE TABLE DATABASE.JOB(
	ID INT AUTO_INCREMENT, 
	NAME VARCHAR(50), 
	ACTIVE BOOLEAN,
	IDJOB INT, 
	IDTASK INT
);
CREATE TABLE DATABASE.PARENT_JOB(
	ID INT AUTO_INCREMENT, 
	NAME VARCHAR(50), 
	ACTIVE BOOLEAN,
	IDJOB INT, 
	IDTASK INT
);
CREATE TABLE DATABASE.TASK(
	ID INT AUTO_INCREMENT, 
	NAME VARCHAR(50), 
	WEIGHT INT, 
	COMPLETED BOOLEAN, 
	CREATED_AT DATE
);

--DROP TABLE DATABASE.JOB;
--DROP TABLE DATABASE.PARENT_JOB;
--DROP TABLE DATABASE.TASK;