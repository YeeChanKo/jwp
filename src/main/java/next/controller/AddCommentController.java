package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class AddCommentController extends AbstractController {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AnswerDao answerDao = new AnswerDao();
		QuestionDao questionDao = new QuestionDao();
		long questionId = Long.parseLong(request.getParameter("questionId"));

		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		Answer answer = new Answer(writer, contents, questionId);
		answerDao.insert(answer);
		questionDao.increaseCommentCount(questionId);

		return null;
	}
}
