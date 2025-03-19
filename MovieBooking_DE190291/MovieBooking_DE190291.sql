CREATE TABLE Users (
    ID INT PRIMARY KEY IDENTITY(1, 1),
    Username VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Movies (
    ID INT PRIMARY KEY IDENTITY(1, 1),
    Title VARCHAR(100) NOT NULL,
    Director VARCHAR(100) NOT NULL,
    ReleaseDate DATE NOT NULL,
    Duration INT NOT NULL,
    TicketPrice DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Bookings (
    ID INT PRIMARY KEY IDENTITY(1, 1),
    UserID INT NOT NULL,
    MovieID INT NOT NULL,
    BookingDate DATE NOT NULL,
    ShowTime TIME NOT NULL,
    SeatCount INT NOT NULL,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (UserID) REFERENCES Users(ID),
    FOREIGN KEY (MovieID) REFERENCES Movies(ID)
);

CREATE TRIGGER CalculateTotalAmount
ON Bookings
AFTER INSERT, UPDATE
AS
BEGIN
    UPDATE B
    SET B.TotalAmount = B.SeatCount * M.TicketPrice
    FROM Bookings B
    JOIN Movies M ON B.MovieID = M.ID
    WHERE B.ID IN (SELECT ID FROM inserted);
END;

INSERT INTO Users (Username, Password, Email) VALUES
('John Doe', '123', 'johndoe@example.com'),
('Jane Smith', '456', 'janesmith@example.com');

INSERT INTO Movies (Title, Director, ReleaseDate, Duration, TicketPrice) VALUES
('Inception', 'Christopher Nolan', '2010-07-16', 148, 10.50),
('The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31', 136, 8.75),
('Interstellar', 'Christopher Nolan', '2014-11-07', 169, 12.00);

INSERT INTO Bookings (UserID, MovieID, BookingDate, ShowTime, SeatCount) VALUES
(1, 1, '2025-03-20', '18:30:00', 2),
(2, 2, '2025-03-21', '20:00:00', 3);
