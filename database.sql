CREATE TABLE cities (
    city_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE cinemas (
    cinema_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    city_id INT NOT NULL REFERENCES cities(city_id) ON DELETE CASCADE
);

CREATE TABLE studios (
    studio_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    cinema_id INT NOT NULL REFERENCES cinemas(cinema_id) ON DELETE CASCADE
);

CREATE TABLE seats (
    seat_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    studio_id INT NOT NULL REFERENCES studios(studio_id) ON DELETE CASCADE,
    seat_row CHAR(2) NOT NULL,
    seat_col INT NOT NULL,
    row_position INT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    UNIQUE (studio_id, seat_row, seat_col)
);

CREATE TABLE users (
    user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT,
    email TEXT UNIQUE,
    password TEXT,
    role TEXT CHECK (role IN ('customer', 'admin')) DEFAULT 'customer'
);

CREATE TABLE movies (
    movie_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    duration_minutes INT CHECK (duration_minutes > 0),
    release_date DATE
);

CREATE TABLE schedules (
    schedule_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    movie_id INT NOT NULL REFERENCES movies(movie_id) ON DELETE CASCADE,
    studio_id INT NOT NULL REFERENCES studios(studio_id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    price NUMERIC(10,2) NOT NULL CHECK (price >= 0)
);

CREATE TABLE tickets (
    ticket_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT REFERENCES users(user_id) ON DELETE SET NULL,
    schedule_id INT NOT NULL REFERENCES schedules(schedule_id) ON DELETE CASCADE,
    seat_id INT NOT NULL REFERENCES seats(seat_id) ON DELETE RESTRICT,
    booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (schedule_id, seat_id)
);

CREATE TABLE genres (
    genre_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE movie_genres (
    movie_id INT NOT NULL REFERENCES movies(movie_id) ON DELETE CASCADE,
    genre_id INT NOT NULL REFERENCES genres(genre_id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, genre_id)
);