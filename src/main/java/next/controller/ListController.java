package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class ListController extends AbstractController {
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 인스턴스 변수를 지역 변수로 만들어 thread-safe하게 해준다.
		QuestionDao questionDao = new QuestionDao();
		List<Question> questions;
		questions = questionDao.findAll();
		ModelAndView mav = jstlView("list.jsp");
		mav.addObject("questions", questions);
		return mav;
	}
}
