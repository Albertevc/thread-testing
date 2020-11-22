package tester.hr;

import java.util.List;

import tester.hr.dao.IScoreDAO;
import tester.hr.interfaces.IScore;
import tester.hr.interfaces.IScoreService;

/**
 * @author alber
 *
 */
class ScoreService implements IScoreService {

	private final IScoreDAO scoreDAO;

	public ScoreService(IScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}

	@Override
	public void postScore(String userId, long points) {
		this.scoreDAO.insertOrUpdateUserScore(userId, points);
		System.out.println(String.format("Added %s points to %s ", points, userId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends IScore> S retrieveScore(String userId) {
		System.out.println(String.format("Retrieving score of %s.", userId));
		return (S) this.scoreDAO.findScoreAndPositionByUserId(userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends IScore> List<S> retrieveRanking() {
		return (List<S>) this.scoreDAO.listAllOrdenedByPosition();
	}

}
