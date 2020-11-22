package tester.hr.dao;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import tester.hr.Score;

/**
 * @author alber
 *
 */
class ScoreDAO implements IScoreDAO {

	private final Map<String, Score> scores;

	public ScoreDAO(Map<String, Score> scores) {
		this.scores = scores;
	}

	@Override
	public void insertOrUpdateUserScore(String userId, long points) {
		this.scores.merge(userId, new Score(userId, points), Score::addScore);
	}

	@Override
	public Score findScoreAndPositionByUserId(String userId) {
		List<Score> collect = this.scores.entrySet().stream().sorted(comparing(Entry::getValue))
				.map(e -> new Score(e.getValue().getUserId(), e.getValue().getScore())).collect(toList());
		return collect.stream().filter(e -> e.getUserId().equals(userId)).findFirst().map(e -> {
			e.setPosition(collect.indexOf(e) + 1);
			return e;
		}).orElse(null);
	}

	@Override
	public List<Score> listAllOrdenedByPosition() {
		List<Score> collect = this.scores.entrySet().stream().sorted(comparing(Entry::getValue))
				.map(e -> new Score(e.getValue().getUserId(), e.getValue().getScore())).collect(toList());
		return collect.stream().map(e -> {
			e.setPosition(collect.indexOf(e) + 1);
			return e;
		}).collect(toList());
	}

}
