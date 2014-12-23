package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class SaveController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuestionDao questionDao = new QuestionDao();

		logger.debug("SaveController", "success");

		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		Question question = new Question(writer, title, contents);

		questionDao.insert(question);
		response.sendRedirect("/");
		return null;
	}
}
