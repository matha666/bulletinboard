CREATE DATABASE bulletin_titles;
CREATE DATABASE bulletin_contents;

USE bulletin_titles;
CREATE TABLE titles (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL
);

USE bulletin_contents;
CREATE TABLE contents (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          post_id INT NOT NULL,
                          content TEXT NOT NULL
);
