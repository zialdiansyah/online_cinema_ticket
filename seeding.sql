-- =============================
-- SEEDING DATA
-- =============================

-- Cities
INSERT INTO cities (name) VALUES
('Jakarta'), ('Bandung'), ('Surabaya'), ('Medan'), ('Makassar'),
('Yogyakarta'), ('Semarang'), ('Palembang'), ('Denpasar'), ('Balikpapan');

-- Cinemas
INSERT INTO cinemas (name, city_id) VALUES
('Plaza Indonesia XXI', 1), ('Ciwalk XXI', 2), ('Tunjungan Plaza XXI', 3),
('Centre Point XXI', 4), ('Panakkukang XXI', 5), ('Empire XXI', 6),
('DP Mall XXI', 7), ('PIM XXI', 8), ('Level 21 XXI', 9), ('E-Walk XXI', 10);

-- Studios
INSERT INTO studios (name, cinema_id) VALUES
('Studio 1', 1), ('Studio 2', 1),
('Studio 1', 2), ('Studio 2', 2),
('Studio 1', 3), ('Studio 2', 3),
('Studio 1', 4), ('Studio 1', 5),
('Studio 1', 6), ('Studio 1', 7);

-- Seats
INSERT INTO seats (studio_id, seat_row, seat_number, is_accessible) VALUES
(1, 'A', 1, FALSE), (1, 'A', 2, FALSE), (1, 'A', 3, FALSE), (1, 'B', 1, TRUE), (1, 'B', 2, FALSE),
(2, 'A', 1, FALSE), (2, 'A', 2, FALSE), (2, 'A', 3, FALSE), (2, 'B', 1, TRUE), (2, 'B', 2, FALSE);

-- Movies
INSERT INTO movies (title, description, duration_minutes, release_date, end_date, genre) VALUES
('Mission: Impossible - The Final Reckoning', 'A thrilling action-packed mission.', 169, '2025-05-01', '2025-06-30', 'Action'),
('Lilo & Stitch', 'An animated tale of friendship.', 108, '2025-05-01', '2025-06-30', 'Animation'),
('Gundik', 'A dramatic Indonesian story.', 112, '2025-05-01', '2025-06-30', 'Drama'),
('Home Sweet Home: Rebirth', 'A horror sequel.', 93, '2025-05-01', '2025-06-30', 'Horror'),
('The Red Envelope', 'A suspenseful thriller.', 128, '2025-05-01', '2025-06-30', 'Thriller'),
('Angel Pol', 'An upcoming romantic drama.', 110, '2025-06-01', '2025-07-31', 'Romance'),
('Assalamualaikum Beijing 2: Lost in Ningxia', 'A sequel to the romantic journey.', 115, '2025-06-01', '2025-07-31', 'Romance'),
('Bad Genius', 'A Thai heist thriller.', 130, '2025-06-01', '2025-07-31', 'Thriller'),
('Ballerina', 'An inspiring dance story.', 95, '2025-06-01', '2025-07-31', 'Drama'),
('Bambi: A Tale of Life in the Woods', 'A classic animated story.', 89, '2025-06-01', '2025-07-31', 'Animation');

-- Users
INSERT INTO users (name, email, password, role) VALUES
('Guest User 1', 'guest1@example.com', 'guestpass1', 'GUEST'),
('Guest User 2', 'guest2@example.com', 'guestpass2', 'GUEST'),
('Customer 1', 'cust1@example.com', 'custpass1', 'CUSTOMER'),
('Customer 2', 'cust2@example.com', 'custpass2', 'CUSTOMER'),
('Admin 1', 'admin1@example.com', 'adminpass1', 'ADMIN'),
('Admin 2', 'admin2@example.com', 'adminpass2', 'ADMIN'),
('Customer 3', 'cust3@example.com', 'custpass3', 'CUSTOMER'),
('Customer 4', 'cust4@example.com', 'custpass4', 'CUSTOMER'),
('Guest User 3', 'guest3@example.com', 'guestpass3', 'GUEST'),
('Customer 5', 'cust5@example.com', 'custpass5', 'CUSTOMER');

-- Schedules
INSERT INTO schedules (studio_id, movie_id, start_time, price) VALUES
(1, 1, '2025-05-21 10:00:00', 45000),
(1, 2, '2025-05-21 13:00:00', 45000),
(1, 3, '2025-05-21 15:30:00', 45000),
(2, 4, '2025-05-21 10:00:00', 50000),
(2, 5, '2025-05-21 13:00:00', 50000),
(2, 6, '2025-05-21 15:30:00', 50000),
(3, 7, '2025-05-21 17:30:00', 48000),
(3, 8, '2025-05-21 20:00:00', 48000),
(4, 9, '2025-05-21 18:00:00', 47000),
(4, 10, '2025-05-21 21:00:00', 47000);

-- Bookings
INSERT INTO bookings (user_id, booked_at, status, expires_at) VALUES
(3, NOW(), 'PENDING', NOW() + INTERVAL '15 minutes'),
(4, NOW(), 'PAID', NOW() + INTERVAL '15 minutes'),
(5, NOW(), 'EXPIRED', NOW()),
(6, NOW(), 'PENDING', NOW() + INTERVAL '15 minutes'),
(7, NOW(), 'PAID', NOW() + INTERVAL '15 minutes'),
(8, NOW(), 'PENDING', NOW() + INTERVAL '15 minutes'),
(9, NOW(), 'PAID', NOW() + INTERVAL '15 minutes'),
(10, NOW(), 'EXPIRED', NOW()),
(2, NOW(), 'PENDING', NOW() + INTERVAL '15 minutes'),
(1, NOW(), 'PAID', NOW() + INTERVAL '15 minutes');

-- Tickets
INSERT INTO tickets (booking_id, schedule_id, seat_id) VALUES
(1, 1, 1), (2, 2, 2), (3, 3, 3),
(4, 4, 4), (5, 5, 5), (6, 6, 6),
(7, 7, 7), (8, 8, 8), (9, 9, 9), (10, 10, 10);