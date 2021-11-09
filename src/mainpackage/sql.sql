
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
/*WORKING SQL TO CREATE TABLES END*/


/*QUERIES: */

/*mainPage.fxml, bets.fxml*/
/*returning bet objects of finished bets for specific user */
SELECT * FROM Bet WHERE betStatus = 3 AND betIsPaidOut AND betSenderUserID = 'your userid' OR betTargetUserID = 'your userid';

/*Used for mainPage.fxml, where we show friend bets in the list. */
/*query for getting Bet objects that involved a friend.*/
SELECT * FROM UserFriends JOIN Bet ON UserFriends.friendUserID = Bet.betTargetUserID OR UserFriends.friendUserID = Bet.betSenderUserID WHERE UserFriends.userID = 'bruh' OR UserFriends.userID = 'bruh';


/**/
/*query for getting bet objects for a specific userID*/
SELECT * FROM Bet WHERE Bet.betTargetUserID = 'bruh' OR Bet.betSenderUserID = 'bruh';


/*createAccountFXML.fxml*/

/*query for checking if username exists*/
SELECT * FROM UserTable WHERE userID = 'inputUserID';
/*query for inserting a new User into the UserTable*/
/*You will insert the values the user provided into this query*/
INSERT INTO User (userID, userPassword, userDateCreated)
VALUES ('ashton', 'ashtonpassword', '03/16/2001 08:42:09');
/*This inserts a new Portfolio for the new user.*/
INSERT INTO Portfolio (userID, portfolioBalance, portfolioTotalReturns)


/*WORKING SQL TO POPULATE TABLES START*/
/*
INSERT INTO Bet (betID, betStatus, betDateTime, betDescription, betTitle, betAmount, betWinner, betSenderUserID, betTargetUserID, betSenderResult, betTargetResult, betSenderStatus, betTargetStatus, betIsPrivate, betIsPaidOut)
VALUES (1, 3, '03/16/2001 08:42:09', 'I bet Jacob that it will rain tomorrow', 'Rain Bet', 5, 'Ashton', 'Ashton', 'Jacob', 1, 0, 2, 2, False, True), (2, 2, '11/17/2000 08:42:09', 'I bet Chase I have a better computer', 'Better Computer', 10, null, 'Jacob', 'Chase', 2, 2, 2, 2, False, False), (3, 1, '06/28/2021 08:42:09', 'I bet Bruh I have more formal education', 'Bruh is Dumb', 15, 'Chase', 'Chase', 'Bruh', 1, 0, 2, 2, True, True), (4, 0, '12/25/2020 08:42:09', 'I bet Ashton that I will go on a 4 day bender', '4-Days of Parties', 20, 'Ashton', 'Bruh', 'Ashton', 0, 1, 2, 2, True, True);


SELECT * FROM Bet WHERE betStatus = 1 AND betIsPaidOut = 1 AND (betSenderUserID = 'ashton' OR betTargetUserID = 'jacob');
*/
/*WORKING SQL TO POPULATE TABLES END*/