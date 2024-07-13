-- H2 데이터베이스 시퀀스 재설정
ALTER TABLE enrollment ALTER COLUMN enrollment_id RESTART WITH 1;
