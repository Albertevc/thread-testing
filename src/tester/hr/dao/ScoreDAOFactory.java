package tester.hr.dao;

import java.util.Map;

import tester.hr.Score;

/**
 * @author alber
 *
 */
public class ScoreDAOFactory {

	public static IScoreDAO createWith(Map<String, Score> data) {
		return new ScoreDAO(data);
	}
}
