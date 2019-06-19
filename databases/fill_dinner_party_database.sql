USE DinnerParty;

INSERT INTO Genres
  (genre_name)
  VALUES ('Card Game');
INSERT INTO Genres
  (genre_name)
  VALUES ('Board Game');
INSERT INTO Genres
  (genre_name)
  VALUES ('Puzzle');
INSERT INTO Genres
  (genre_name)
  VALUES ('Strategy');
INSERT INTO Genres
  (genre_name)
  VALUES ('Family');
INSERT INTO Genres
  (genre_name)
  VALUES ('Adult');
INSERT INTO Genres
  (genre_name)
  VALUES ('Co-op');
INSERT INTO Genres
  (genre_name)
  VALUES ('Deck Building');
INSERT INTO Genres
  (genre_name)
  VALUES ('Acting');
INSERT INTO Genres
  (genre_name)
  VALUES ('Art');
INSERT INTO Genres
  (genre_name)
  VALUES ('Memory');
INSERT INTO Genres
  (genre_name)
  VALUES ('World Building');
INSERT INTO Genres
  (genre_name)
  VALUES ('Worker Placement');
INSERT INTO Genres
  (genre_name)
  VALUES ('Teams');
INSERT INTO Genres
  (genre_name)
  VALUES ('Diplomacy');
INSERT INTO Genres
  (genre_name)
  VALUES ('Fast-Paced');
INSERT INTO Genres
  (genre_name)
  VALUES ('Easy to learn, Hard to Master');
INSERT INTO Games
	(game_name, min_players, max_players, min_age, game_duration, game_description, game_price, game_publisher, game_release_date, num_pieces)
    VALUES 
    ('Settlers of Catan',
    3, 4, 10,'60-120 minutes',
    'Trade, Build, Settle',
    45.00,'Catan Studios', '1995-01-01', 
    277
    );
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Board Game'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Strategy'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Worker Placement'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Family'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Diplomacy'));

INSERT INTO Games
	(game_name, min_players, max_players, min_age, game_duration, game_description, game_price, game_publisher, game_release_date, num_pieces)
    VALUES 
    ('Monopoly', 2, 10, 8,'60-240 minutes',
    'The Fast-Dealing Property Trading Game', 20.00,
    'Hasbro','1935-01-01', 126
    );
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Board Game'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Strategy'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Family'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Diplomacy'));


INSERT INTO Games
	(game_name, min_players, max_players, min_age, game_duration, game_description, game_price, game_publisher, num_pieces)
    VALUES 
    ('Sorry!', 2, 4, 6,'10-30 minutes',
    'The Game of Sweet Revenge', 15.00,
    'Hasbro', 58
    );
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Board Game'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Strategy'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Family'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Card Game'));
    
INSERT INTO Games
	(game_name, min_players, max_players, min_age, game_duration, game_description, game_price, game_publisher, num_pieces)
    VALUES 
    ('Dutch Blitz', 2, 4, 8,'5-10 minutes',
    'A Vonderful Goot Game', 20.00,
    'Dutch Blitz', 160
    );
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Card Game'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Fast-Paced'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Family'));
    
INSERT INTO Games
	(game_name, min_players, max_players, min_age, game_duration, game_description, game_price, game_publisher, num_pieces)
    VALUES 
    ('Tak', 2, 2, 12,'15-20 minutes',
    'A Beautiful Game', 45.00,
    'Cheapass Games', 42
    );
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Board Game'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Easy to learn, Hard to Master'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Family'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Strategy'));
INSERT INTO GamesGenres(game_id, genre_id)
	VALUES
    ((SELECT MAX(game_id) FROM Games), 
    (SELECT genre_id FROM Genres WHERE genre_name = 'Worker Placement'));
