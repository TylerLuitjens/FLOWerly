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

CREATE TABLE Ingredient_Classes (
        IngredientClassID smallint NOT NULL DEFAULT 0 ,
        IngredientClassDescription nvarchar (255) NULL 
);

CREATE TABLE Ingredients (
        IngredientID int NOT NULL DEFAULT 0 ,
        IngredientName nvarchar (255) NULL ,
        IngredientClassID smallint NULL DEFAULT 0 ,
        MeasureAmountID smallint NULL DEFAULT 0 
);

CREATE TABLE Measurements (
        MeasureAmountID smallint NOT NULL DEFAULT 0 ,
        MeasurementDescription nvarchar (255) NULL 
);

CREATE TABLE Recipe_Classes (
        RecipeClassID smallint NOT NULL DEFAULT 0 ,
        RecipeClassDescription nvarchar (255) NULL 
);

CREATE TABLE Recipe_Ingredients (
        RecipeID int NOT NULL DEFAULT 0 ,
        RecipeSeqNo smallint NOT NULL DEFAULT 0 ,
        IngredientID int NULL DEFAULT 0 ,
        MeasureAmountID smallint NULL DEFAULT 0 ,
        Amount real NULL DEFAULT 0
);

CREATE TABLE Recipes (
        RecipeID int NOT NULL DEFAULT 0 ,
        RecipeTitle nvarchar (255) NULL ,
        RecipeClassID smallint NULL DEFAULT 0 ,
        Preparation text NULL ,
        Notes text NULL
);

ALTER TABLE Ingredient_Classes 
        ADD CONSTRAINT Ingredient_Classes_PK PRIMARY KEY 
        (
                IngredientClassID
        );

ALTER TABLE Ingredients 
        ADD CONSTRAINT Ingredients_PK PRIMARY KEY 
        (
                IngredientID
        );

CREATE  INDEX Ingredient_ClassesIngredients ON Ingredients(IngredientClassID);

CREATE  INDEX MeasurementsIngredients ON Ingredients(MeasureAmountID);

ALTER TABLE Measurements 
        ADD CONSTRAINT Measurements_PK PRIMARY KEY 
        (
                MeasureAmountID
        );

ALTER TABLE Recipe_Classes 
        ADD CONSTRAINT Recipe_Classes_PK PRIMARY KEY 
        (
               RecipeClassID
        );

ALTER TABLE Recipe_Ingredients 
        ADD CONSTRAINT Recipe_Ingredients_PK PRIMARY KEY 
        (
                RecipeID, 
                RecipeSeqNo
        );

CREATE  INDEX IngredientID ON Recipe_Ingredients(IngredientID);

CREATE  INDEX MeasureAmountID ON Recipe_Ingredients(MeasureAmountID);

CREATE  INDEX RecipeID ON Recipe_Ingredients(RecipeID);

ALTER TABLE Recipes 
        ADD CONSTRAINT Recipes_PK PRIMARY KEY 
        (
                RecipeID
        );

CREATE  INDEX Recipe_ClassesRecipes ON Recipes(RecipeClassID);

ALTER TABLE Ingredients 
        ADD CONSTRAINT Ingredients_FK00 FOREIGN KEY 
        (
                IngredientClassID
        ) REFERENCES Ingredient_Classes 
        (
                IngredientClassID
        ),
        ADD CONSTRAINT Ingredients_FK01 FOREIGN KEY 
        (
                MeasureAmountID
        ) REFERENCES Measurements (
                MeasureAmountID
        );

ALTER TABLE Recipes 
        ADD CONSTRAINT Recipes_FK00 FOREIGN KEY 
        (
                RecipeClassID
        ) REFERENCES Recipe_Classes (
                RecipeClassID
        );

ALTER Table Recipe_Ingredients 
	ADD CONSTRAINT Recipe_Ingredients_FK00 FOREIGN KEY
	(
		RecipeID
	) REFERENCES Recipes (
		RecipeID
	),
	ADD CONSTRAINT Recipe_Ingredients_FK01 FOREIGN KEY
	(
		IngredientID
	) REFERENCES Ingredients (
		IngredientID
	),
	ADD CONSTRAINT Recipe_Ingredients_FK02 FOREIGN KEY
	(
		MeasureAmountID
	) REFERENCES Measurements (
		MeasureAmountID
	);