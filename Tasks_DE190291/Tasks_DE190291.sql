CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL,
    Email NVARCHAR(100) NOT NULL UNIQUE,
    Password NVARCHAR(255) NOT NULL,
    RegistrationDate DATE NOT NULL DEFAULT GETDATE()
);

CREATE TABLE Tasks (
    TaskID INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(100) NOT NULL,
    Description NVARCHAR(500),
    CreatedDate DATE NOT NULL DEFAULT GETDATE(),
    DueDate DATE,
    Status NVARCHAR(20) NOT NULL CHECK (status IN ('Pending', 'In Progress', 'Completed'))
);
GO

CREATE TABLE TaskAssignments (
    AssignmentID INT PRIMARY KEY IDENTITY(1,1),
    TaskID INT NOT NULL,
    UserID INT NOT NULL,
    AssignedDate DATE NOT NULL,
    CompleteDate DATE NULL,
    FOREIGN KEY (TaskID) REFERENCES Tasks(TaskID) ON DELETE CASCADE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

INSERT INTO Users (Username, Email, Password, RegistrationDate)
VALUES 
    ('John Doe', 'john.doe@example.com', '123', '2024-01-10'),
    ('Jane Smith', 'jane.smith@example.com', '456', '2024-02-05');
    
INSERT INTO Tasks (Title, Description, CreatedDate, DueDate, Status)
VALUES 
    ('Project Proposal', 'Prepare and submit the project proposal document.', '2024-03-01', '2024-03-15', 'Pending'),
    ('Code Review', 'Conduct a thorough code review for the new feature.', '2024-03-05', '2024-03-20', 'In Progress');

INSERT INTO TaskAssignments (TaskID, UserID, AssignedDate, CompleteDate)
VALUES 
    (1, 1, '2024-03-02', NULL),   
    (2, 2, '2024-03-06', NULL);   

