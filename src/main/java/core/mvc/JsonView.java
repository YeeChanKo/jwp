package core.mvc;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonView implements View {

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Gson gson = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(gson.toJson(model));
		out.print(gson.toJson(model));
	}

}
