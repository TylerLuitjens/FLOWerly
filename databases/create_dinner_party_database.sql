/*
DROP DATABASE IF EXISTS DinnerParty;
CREATE DATABASE DinnerParty; 
/* */
USE DinnerParty;
DROP TABLE IF EXISTS UserGamesFavorites;
DROP TABLE IF EXISTS UserGamesRating;
DROP TABLE IF EXISTS UserGames;
DROP TABLE IF EXISTS GamesGenres;
DROP TABLE IF EXISTS Genres;
DROP TABLE IF EXISTS UserInformation;
DROP TABLE IF EXISTS Games;

CREATE TABLE Genres(
	genre_id INT AUTO_INCREMENT,
    genre_name NVARCHAR(30) NOT NULL,
    
    PRIMARY KEY (genre_id)
);

CREATE TABLE Games(

	game_id INT NOT NULL AUTO_INCREMENT,
    game_name NVARCHAR(45) NOT NULL,
    min_players INT,
    max_players INT,
    min_age INT,
    
	game_duration NVARCHAR(15),
    game_description NVARCHAR(250),
    game_price DECIMAL (4,2),
    game_publisher NVARCHAR(25),
    game_release_date DATE,
    
    game_img_url varchar(30), -- may want to make this into a linking table as well if I end up using multiple images per game
    num_pieces INT,
    game_instructions_url NVARCHAR(30),
    
    PRIMARY KEY (game_id)
);

CREATE TABLE UserInformation(
	user_id INT AUTO_INCREMENT,
    username NVARCHAR(30),
    password NVARCHAR(30),
    user_creation_date DATE,
    
    PRIMARY KEY (user_id)
);

CREATE TABLE GamesGenres(
	game_id INT NOT NULL,
    genre_id INT NOT NULL,
    
    PRIMARY KEY (game_id, genre_id),
    FOREIGN KEY(game_id) REFERENCES Games(game_id),
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);

CREATE TABLE UserGames(
	user_id INT,
    game_id INT,
    
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES UserInformation (user_id),
    FOREIGN KEY (game_id) REFERENCES Games (game_id)
);

CREATE TABLE UserGamesFavorites(
	user_id INT,
    game_id INT,
    
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES UserInformation (user_id),
    FOREIGN KEY (game_id) REFERENCES Games (game_id)
);

CREATE TABLE UserGamesRating(
	user_id INT,
    game_id INT,
    rating INT,
    
    PRIMARY KEY (user_id, game_id),
	FOREIGN KEY (user_id) REFERENCES UserInformation (user_id),
    FOREIGN KEY (game_id) REFERENCES Games (game_id)
);