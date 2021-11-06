
/*WORKING SQL TO CREATE TABLES START*/
CREATE TABLE UserTable (
                           userID VARCHAR(16) NOT NULL,
                           userPassword VARCHAR(16) NOT NULL,
                           userDateCreated VARCHAR(25) NOT NULL,
                           PRIMARY KEY (userID)
);
CREATE TABLE UserFriends (
                             userID VARCHAR(16) NOT NULL,
                             friendUserID VARCHAR(16),
                             FOREIGN KEY (userID) REFERENCES UserTable(userID)
);
CREATE TABLE Portfolio (
                           userID VARCHAR(16) NOT NULL,
                           portfolioBalance INT NOT NULL,
                           portfolioTotalReturns INT NOT NULL,
                           FOREIGN KEY (userID) REFERENCES UserTable(userID)
);
CREATE TABLE Bet (
                     betID INT NOT NULL,
                     betStatus INT NOT NULL,
                     betDateTime VARCHAR(25) NOT NULL,
                     betDescription VARCHAR(100),
                     betTitle VARCHAR(16) NOT NULL,
                     betAmount INT NOT NULL,
                     betWinner VARCHAR(16),
                     betSenderUserID VARCHAR(16) NOT NULL,
                     betTargetUserID VARCHAR(16) NOT NULL,
                     betSenderResult INT NOT NULL,
                     betTargetResult INT NOT NULL,
                     betSenderStatus INT NOT NULL,
                     betTargetStatus INT NOT NULL,
                     betIsPrivate BOOLEAN NOT NULL,
                     betIsPaidOut BOOLEAN NOT NULL
);

SELECT * FROM
/*WORKING SQL TO CREATE TABLES END*/
/*
Bet
betID	betStatus	betDateTime	betDescription	betTitle	betAmount	betWinner	betSenderUserID	betTargetUserID	betSenderResult	betTargetResult	betSenderStatus	betTargetStatus	betIsPrivate	betIsPaidOut
INSERT INTO Portfolio (betID, betStatus, betDateTime, betDescription, betTitle, betAmount, betWinner, betSenderUserID, betTargetUserID, betSenderResult, betTargetResult, betSenderStatus, betTargetStatus, betIsPrivate, betIsPaidOut)
VALUES (Ashton, 3, '03/16/2001 08:42:09', 'I bet Jacob that it will rain tomorrow', 'Rain Bet', 5, Ashton, Ashton, Jacob, 1, 0, 2, 2, False, True);
VALUES (Jacob, 2, '11/17/2000 08:42:09', 'I bet Chase I have a better computer', 'Better Computer', 10, null, Jacob, Chase, 2, 2, 2, 2, False, False);
VALUES (Chase, 1, '06/28/2021 08:42:09', 'I bet Bruh I have more formal education', 'Bruh is Dumb', 15, Chase, Chase, Bruh, 1, 0, 2, 2, True, True);
VALUES (Bruh, 0, '12/25/2020 08:42:09', 'I bet Ashton that I will go on a 4 day bender', '4-Days of Parties', 20, Ashton, Bruh, Ashton, 0, 1, 2, 2, True, True);

Portfolio
userID	portfolioBalance	portfolioTotalReturns
INSERT INTO Portfolio (userID, portfolioBalance, portfolioTotalReturns)
VALUES (Ashton, 80, 40);
VALUES (Jacob, 30, 15);
VALUES (Chase, 10, 90);
VALUES (Bruh, 60, -25);

UserFriends
userID	friendUserID
INSERT INTO UserFriends (userID, friendUserID)
VALUES (Ashton, Jacob);
VALUES (Jacob, Chase);
VALUES (Chase, Ashton);
VALUES (Bruh, Jacob);

UserTable
userID	userPassword	userDateCreated
INSERT INTO UserTable (userID, userPassword, userDateCreated)
VALUES (Ashton, 'password1', '02/23/2001 06:12:30');
VALUES (Jacob, 'password2', '11/17/2000 01:17:59');
VALUES (Chase, 'password3', '08/06/2021 10:34:19');
VALUES (Bruh, 'password4', '12/25/2020 07:56:23');
*/

/*
INSERT INTO UserTable (UserID, User_Name, Password)
VALUES (Ashton, 'UserAshton', 'ashtonpassword'),(Jacob, 'UserJacob', 'jacobpassword'),(Chase, 'UserChase', 'chasepassword'),(Bruh, 'UserBruh', 'bruhpassword');










/*
CREATE TABLE UserTable (
userID VARCHAR(16) NOT NULL,
userPassword VARCHAR(16) NOT NULL,
userDateCreated VARCHAR(25) NOT NULL,
PRIMARY KEY (userID)
);

CREATE TABLE UserFriends (
userID VARCHAR(16) NOT NULL,
friendUserID VARCHAR(16),
FOREIGN KEY (userID) REFERENCES User(userID)
);

CREATE TABLE Portfolio (
userID VARCHAR(16) NOT NULL,
portfolioBalance INT NOT NULL,
portfolioTotalReturns INT NOT NULL,
);

/*Don't think this is needed. */
/*
CREATE TABLE PortfolioBets (
userID VARCHAR(16) NOT NULL,
betID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES User(userID)
);
*/
/*
CREATE TABLE Bet (
betID INT NOT NULL,
betStatus INT NOT NULL,
betDateTime VARCHAR(25) NOT NULL,
betDescription VARCHAR(100),
betTitle VARCHAR(16) NOT NULL,
betAmount INT NOT NULL,
betWinner VARCHAR(16),
betSenderUserID VARCHAR(16) NOT NULL,
betTargetUserID VARCHAR(16) NOT NULL,
betSenderResult INT NOT NULL,
betTargetResult INT NOT NULL,
betSenderStatus INT NOT NULL,
betTargetStatus INT NOT NULL,
betIsPrivate BOOLEAN NOT NULL,
betIsPaidOut BOOLEAN NOT NULL,

);
*/
