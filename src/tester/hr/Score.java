package tester.hr;

import tester.hr.interfaces.IScore;

/**
 * @author alber
 *
 */
public class Score implements IScore, Comparable<Score> {

	private final String userId;
	private Long score;
	private Integer position;

	public Score(String userId, long score) {
		super();
		this.userId = userId;
		this.score = score;
	}

	@Override
	public String getUserId() {
		return this.userId;
	}

	@Override
	public long getScore() {
		return this.score;
	}

	public Score addScore(Score delta) {
		Long newScore = this.score + delta.getScore();
		return new Score(userId, newScore);
	}

	@Override
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public int compareTo(Score o) {
		return Long.valueOf(o.getScore()).compareTo(this.getScore());
	}

	@Override
	public String toString() {
		return "Score [userId=" + userId + ", score=" + score + ", position=" + position + "]";
	}

}
