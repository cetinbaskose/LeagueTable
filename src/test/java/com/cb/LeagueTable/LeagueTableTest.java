package com.cb.LeagueTable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cb.leaguetable.LeagueTable;
import com.cb.leaguetable.LeagueTableEntry;
import com.cb.leaguetable.Match;
import com.cb.leaguetable.Teams;


class LeagueTableTest {

	@Test
	void oneMatchShouldReturnTwoLinesLeagueTable() {

		List<Match> matchList = new ArrayList<>();
		matchList.add(new Match(Teams.Crystal_Palace.name(), Teams.Southampton.name(), 0, 2));

		LeagueTableEntry[] expectedLeagueTableEntry = new LeagueTableEntry[] {
				new LeagueTableEntry(Teams.Southampton.name(), 1, 1, 0, 0, 2, 0, 2, 3),
				new LeagueTableEntry(Teams.Crystal_Palace.name(), 1, 0, 0, 1, 0, 2, -2, 0)
		};

		assertArrayEquals(expectedLeagueTableEntry, new LeagueTable(matchList).getTableEntries().toArray());

	}

	@Test
	void twoMatchSameTeamMustBeSummarized() {

		List<Match> matchList = new ArrayList<>();
		matchList.add(new Match(Teams.Crystal_Palace.name(), Teams.Southampton.name(), 0, 2));
		matchList.add(new Match(Teams.Southampton.name(), Teams.Arsenal.name(), 3, 2));

		LeagueTableEntry[] expectedLeagueTableEntry = new LeagueTableEntry[] {
				new LeagueTableEntry(Teams.Southampton.name(), 2, 2, 0, 0, 5, 2, 3, 6),
				new LeagueTableEntry(Teams.Arsenal.name(), 1, 0, 0, 1, 2, 3, -1, 0),
				new LeagueTableEntry(Teams.Crystal_Palace.name(), 1, 0, 0, 1, 0, 2, -2, 0) };

		assertArrayEquals(expectedLeagueTableEntry, new LeagueTable(matchList).getTableEntries().toArray());
	}

	@Test
	void emptyMatchListShouldReturnEmptyLeagueTable() {

		List<Match> matchList = new ArrayList<>();

		LeagueTableEntry[] expectedLeagueTableEntry = new LeagueTableEntry[] {};

		assertArrayEquals(expectedLeagueTableEntry, new LeagueTable(matchList).getTableEntries().toArray());
	}

	@Test
	void oneWeekShouldReturnTwentyTeam() {
		List<Match> matchList = new ArrayList<>();
		matchList.add(new Match(Teams.Crystal_Palace.name(), Teams.Southampton.name(), 0, 2));
		matchList.add(new Match(Teams.Sheffield_United.name(), Teams.Manchester_City.name(), 0, 1));
		matchList.add(new Match(Teams.Everton.name(), Teams.Newcastle_United.name(), 2, 2));
		matchList.add(new Match(Teams.Aston_Villa.name(), Teams.Watford.name(), 2, 1));
		matchList.add(new Match(Teams.AFC_Bournemouth.name(), Teams.Brighton_Hove_Albion.name(), 3, 1));
		matchList.add(new Match(Teams.Chelsea.name(), Teams.Arsenal.name(), 2, 2));
		matchList.add(new Match(Teams.Tottenham_Hotspur.name(), Teams.Norwich_City.name(), 2, 1));
		matchList.add(new Match(Teams.Leicester_City.name(), Teams.West_Ham_United.name(), 4, 1));
		matchList.add(new Match(Teams.Manchester_United.name(), Teams.Burnley.name(), 0, 2));
		matchList.add(new Match(Teams.Wolverhampton.name(), Teams.Liverpool.name(), 1, 2));

   
		LeagueTable  leagueTable= new LeagueTable(matchList);
		
		List <LeagueTableEntry> actualLeagueTable = leagueTable.getTableEntries();
		
		assertEquals(actualLeagueTable.size(), 20);
		assertEquals(actualLeagueTable.get(0).getTeamName(),"Leicester_City");
		assertEquals(actualLeagueTable.get(0).getGoalsFor(),4);
		assertEquals(actualLeagueTable.get(0).getGoalsAgainst(),1);
		assertEquals(actualLeagueTable.get(0).getGoalDifference(),3);
		assertEquals(actualLeagueTable.get(0).getPoints(),3);
		assertEquals(actualLeagueTable.get(19).getTeamName(),"West_Ham_United");
		assertEquals(actualLeagueTable.get(19).getPoints(),0);

	}

}
