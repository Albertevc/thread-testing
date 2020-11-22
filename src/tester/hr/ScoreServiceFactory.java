package tester.hr;

import java.util.concurrent.ConcurrentHashMap;

import tester.hr.dao.ScoreDAOFactory;
import tester.hr.interfaces.IScoreService;

/**
 * @author alber
 *
 */
public class ScoreServiceFactory {

	public static IScoreService createConcurrentScoreService() {
		return new ScoreService(ScoreDAOFactory.createWith(new ConcurrentHashMap<>()));
	}
}
