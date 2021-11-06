
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

/*returning bet objects of finished bets for specific user */
SELECT * FROM Bet WHERE betStatus = 3 AND betIsPaidOut AND betSenderUserID = 'your userid' OR betTargetUserID = 'your userid';



/*WORKING SQL TO CREATE TABLES END*/
/*Bet
betID	betStatus	betDateTime	betDescription	betTitle	betAmount	betWinner	betSenderUserID	betTargetUserID	betSenderResult	betTargetResult	betSenderStatus	betTargetStatus	betIsPrivate	betIsPaidOut

Portfolio
userID	portfolioBalance	portfolioTotalReturns

UserFriends
userID	friendUserID

UserTable
userID	userPassword	userDateCreated
INSERT INTO UserTable (userID, userPassword, userDateCreated)
VALUES (1, 'password1', '02/23/2001 01:12:30');
 */

              /*
INSERT INTO UserTable (UserID, User_Name, Password)
VALUES (1, 'UserBob', 'bobpassword'),(2, 'UserSarah', 'sarahpassword'),(3, 'UserBilly', 'billypassword'),(4, 'UserAlex', 'alexpassword');









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
