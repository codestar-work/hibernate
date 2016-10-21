package web;
import java.util.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import org.hibernate.*;
import javax.transaction.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class MyController {

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/test")
	String test() {
		return "test.jsp";
	}

	@RequestMapping("/list") @ResponseBody
	List showCoffee() {
		Session database = factory.openSession();
		Query query = database.createQuery("from Coffee");
		List list = query.list();
		database.close();
		return list;
	}

	@Autowired
	SessionFactory factory;
}
