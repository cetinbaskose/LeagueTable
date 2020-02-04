package com.cb.leaguetable;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		final List<Match> matchList = new ArrayList<>();

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
		LeagueTable leagueTable = new LeagueTable(matchList);

		System.out.println(leagueTable.getTableEntries().toString());
	}
}
