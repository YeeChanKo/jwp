package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class ShowController extends AbstractController {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 인스턴스 변수를 지역 변수로 만들어 thread-safe하게 해준다.
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		Question question;
		List<Answer> answers;
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");

		question = questionDao.findById(questionId);
		answers = answerDao.findAllByQuestionId(questionId);
		ModelAndView mav = jstlView("show.jsp");
		mav.addObject("question", question);
		mav.addObject("answers", answers);

		return mav;
	}
}
