Alter TABLE user 

MODIFY COLUMN  role ENUM('admin', 'standard', 'author') DEFAULT 'standard'
   


CREATE VIEW show_books_300_more_pages
AS
SELECT * FROM book
WHERE page_count > 300;

SELECT * FROM show_books_300_more_pages


DELIMITER $$

CREATE PROCEDURE GetUserActivity(IN input_user_id INT)
BEGIN
    SELECT 
        u.id_user,
        u.full_name,
        u.email,
        u.username,
        u.role,
        -- Count purchases
        (SELECT COUNT(*) FROM purchase p WHERE p.id_user = u.id_user) AS total_purchases,
        -- Count comments
        (SELECT COUNT(*) FROM comment c WHERE c.id_user = u.id_user) AS total_comments,
        -- Average rating given by user
        (SELECT IFNULL(ROUND(AVG(r.score),2), 0) FROM rating r WHERE r.id_user = u.id_user) AS avg_rating
    FROM user u
    WHERE u.id_user = input_user_id;
END$$

DELIMITER ;



DELIMITER $$
CREATE PROCEDURE UserComments(IN user_id INT)
BEGIN
	SELECT u.id_user, u.full_name, u.email, u.`role`, u.preferred_language,
	(SELECT COUNT(*) FROM comment c WHERE c.id_user = u.id_user) AS total_comments
FROM user u
WHERE u.id_user = user_id;
END$$

DELIMITER ;


CALL UserComments(5);

CALL GetUserActivity(5);

