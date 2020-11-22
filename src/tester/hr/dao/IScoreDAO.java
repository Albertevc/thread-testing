package tester.hr.dao;

import java.util.List;

import tester.hr.Score;

/**
 * @author alber
 *
 */
public interface IScoreDAO {

	List<Score> listAllOrdenedByPosition();

	Score findScoreAndPositionByUserId(String userId);

	void insertOrUpdateUserScore(String userId, long points);

}
