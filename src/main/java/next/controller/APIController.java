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

public class APIController extends AbstractController {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		Question question;
		List<Answer> answers;
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");

		question = questionDao.findById(questionId);
		answers = answerDao.findAllByQuestionId(questionId);
		ModelAndView mav = jsonView();
		mav.addObject("question", question);
		mav.addObject("answers", answers);

		return mav;
	}
}
