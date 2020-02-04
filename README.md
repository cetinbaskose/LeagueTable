"# LeagueTable" 

     
             League Table

Build
 mvn clean install
Execute for sample matches
 mvn exec:java -Dexec.mainClass="com.cb.leaguetable.Main"

Documentation

Created leagueTableEntryList as list of leagueTableEntry and initialized leagueTableEntryList in Instance Initialization Block. 
Created new list homeAndAwayMatchList for holding matchs both home team point of view and  away team point of view.
Created new match for every match with replacing home and away team names and scores and added homeAndAwayMatchList 
After all matches added original match list.

looping on matches with both sides( home and away) checking if the home team is exists in LeagueTable.
If the home team exists we send this record to applyMatch method for add the match scores on it.
applyMatch method checks scores and sets related fields of leagueTableEntry object and then returns it back.
And then We are replacing LeagueTableEntry on leagueTableEntryList via leagueTableEntry which is returned from  applyMatch method.

if the home team doesn't exist on leagueTableEntryList we create a new LeagueTableEntry and sent it to applyMatch for applying the match scores.
And then we are adding LeagueTableEntry which returned from applyMatch method.

When all matches applied we are going to sort the leagueTableEntryList.
leagueComparator created for sorting leagueTableEntryList in order points, goalDifference, goalsFor and teamName.
leagueTableEntryList.sort method called in reverse order for ordering.

Sorting process have made in constructor method to ensure for making sorting once. 
if we have sorting in getTableEntries method when getTableEntries every time called we need to make sort again and again.
To avoiding sorting cost for getTableEntries method kept simple just returning current leagueTableEntryList 

Teams Enum created with Premier League teams for avoiding misspelling and see available teams.

LeagueTableEntry equals method overridden for to easy of use in JUnit test, in this way we can compare two LeagueTableEntry variables by variable.

Four different test cases writed.
1- One match between [(Crystal_Palace Southampton  0- 2)]
   expected return
   [(Southampton   , 1, 1, 0, 0, 2, 0, 2, 3),
   (Crystal_Palace, 1, 0, 0, 1, 0, 2, -2, 0)]

2- Two match of one team with two different team, we are expecting her summirizing result of team which made two match.
     [(Crystal_Palace, Southampton, 0, 2)
     (Southampton, Arsenal , 3, 2)]

   expected return
        [(Southampton   , 2, 2, 0, 0, 5, 2, 3, 6),
	 (Arsenal       , 1, 0, 0, 1, 2, 3, -1, 0),
	 (Crystal_Palace, 1, 0, 0, 1, 0, 2, -2, 0)]

3- If we send empty match list should return empty LeagueTable
     matchList []
   expected return
      LeagueTableEntry[]

4- One week all matches will check return count leader and looser team check
 
   [(Crystal_Palace, Southampton, 0, 2),
    (Sheffield_United, Manchester_City, 0, 1),
    (Everton, Newcastle_United, 2, 2),
    (Aston_Villa, Watford, 2, 1),
    (AFC_Bournemouth, Brighton_Hove_Albion, 3, 1),
    (Chelsea, Arsenal, 2, 2),
    (Tottenham_Hotspur, Norwich_City, 2, 1),
    (Leicester_City, West_Ham_United, 4, 1),
    (Manchester_United, Burnley, 0, 2),
    (Wolverhampton, Liverpool, 1, 2)]

  Expecting
  - 20 Teams in LeagueTable
  - First Team is Leicester_City
  - First team goalsFor = 4
  - First team goalsAgainst = 1
  - First team goalsDifference = 3
  - First team points =3
  - Last team name is West_Ham_United
  - Last team points =0





