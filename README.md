2014년 개발 경험 프로젝트
=========

# 질문 목록 보이기까지의 설명
1. next.WebServerLauncher를 java application으로 실행시킨다. tomcat 서블릿 컨테이너가 서버와 연동이 되어 실행된다.
2. 클라이언트가 처음 http://localhost:8080/list.next에 접근하면, @WebServlet("*.next")으로 요청을 받는 FrontController의 인스턴스가 생성되어 실행된다.
3. 처음에 init() 실행되고 request mapping 해주는 rm 값을 ServletContextLoader에 담겨있는 DEFAULT_REQUEST_MAPPING으로 초기화해준다. ServletContextLoader의 contextInitialized()가 실행되면서 request mapping의 initMapping()을 해준다. JwpContextLoaderListender의 contextInitialized()도 실행되면서 데이터베이스 설정을 초기화해준다.
4. FrontController의 service()에서 rm에 들어있는 요청 URL을 서블릿에 맵핑한 후 해당되는 컨트롤러를 찾아 controller 변수에 넣어준다. controller를 execute()하면 구현 컨트롤러의 execute() 메서드가 필요한 ModelAndView 클래스를 리턴해준다.
5. 리턴된 view를 받아 render()를 호출해 클라이언트에 view를 그려준다.
6. http://localhost:8080/list.next에 접근하는 경우엔 list.next는 ListController에 맵핑되므로 execute()해주면 QuestionDao에서 질문들을 다 찾아와 jstlView("list.jsp")를 호출해 list.jsp에 forward해준다.
7. 클라이언트는 jstl이 questions 모델이 resolved된 list.jsp를 보게 된다.