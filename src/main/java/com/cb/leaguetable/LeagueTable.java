package com.cb.leaguetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeagueTable {
	private final List<LeagueTableEntry> leagueTableEntryList;

	{
		leagueTableEntryList = new ArrayList<>();
	}

	public LeagueTable(final List<Match> matches) {

		List<Match> homeAndAwayMatchList = matches.stream()
				.map(f -> new Match(f.getAwayTeam(), f.getHomeTeam(), f.getAwayScore(), f.getHomeScore()))
				.collect(Collectors.toList());

		homeAndAwayMatchList.addAll(matches);

		for (Match match : homeAndAwayMatchList) {

			LeagueTableEntry existingLeagueTableEntry = leagueTableEntryList.stream()
					.filter(x -> match.getHomeTeam().equals(x.getTeamName())).findAny().orElse(null);

			if (existingLeagueTableEntry != null) {

				leagueTableEntryList.set(leagueTableEntryList.indexOf(existingLeagueTableEntry),
						applyMatch(existingLeagueTableEntry, match));
			} else {

				leagueTableEntryList
						.add(applyMatch(new LeagueTableEntry(match.getHomeTeam(), 0, 0, 0, 0, 0, 0, 0, 0), match));
			}

		}

		Comparator<LeagueTableEntry> leagueComparator = Comparator.comparing(LeagueTableEntry::getPoints)
				.thenComparing(LeagueTableEntry::getGoalDifference).thenComparing(LeagueTableEntry::getGoalsFor)
				.thenComparing(LeagueTableEntry::getTeamName);

		leagueTableEntryList.sort(leagueComparator.reversed());

	}

	private LeagueTableEntry applyMatch(LeagueTableEntry leagueTableEntry, Match match) {

		leagueTableEntry.setPlayed(leagueTableEntry.getPlayed() + 1);

		if (match.getHomeScore() > match.getAwayScore()) {
			leagueTableEntry.setWon(leagueTableEntry.getWon() + 1);
			leagueTableEntry.setPoints(leagueTableEntry.getPoints() + 3);
		}

		if (match.getHomeScore() == match.getAwayScore()) {
			leagueTableEntry.setDrawn(leagueTableEntry.getDrawn() + 1);
			leagueTableEntry.setPoints(leagueTableEntry.getPoints() + 1);
		}

		if (match.getHomeScore() < match.getAwayScore()) {
			leagueTableEntry.setLost(leagueTableEntry.getLost() + 1);
		}

		if (match.getHomeScore() > 0) {
			leagueTableEntry.setGoalsFor(leagueTableEntry.getGoalsFor() + match.getHomeScore());
		}

		if (match.getAwayScore() > 0) {
			leagueTableEntry.setGoalsAgainst(leagueTableEntry.getGoalsAgainst() + match.getAwayScore());
		}

		if (match.getHomeScore() > 0 || match.getAwayScore() > 0) {
			leagueTableEntry.setGoalDifference(leagueTableEntry.getGoalsFor() - leagueTableEntry.getGoalsAgainst());
		}


		return leagueTableEntry;
	}

	/**
	 * Get the ordered list of league table entries for this league table.
	 *
	 * @return
	 */
	public List<LeagueTableEntry> getTableEntries() {

		return leagueTableEntryList;
	}

}
