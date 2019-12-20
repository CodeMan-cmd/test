package controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pojo.Books;
import service.BookService;
import utils.Page;

@Controller
public class BookController {
	@Resource
	private BookService bookService;
	private Page page;

	@RequestMapping(value = "/indexBook", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		page = new Page() {
			@Override
			public void init() {
				this.setPagesCount(bookService.selectCountByBook(0, null));
				this.setNowPageNumber(1);
			}
		};
		modelAndView.addObject("type", 0);
		modelAndView.addObject("list", bookService.selectAll(page, 0, null));
		modelAndView.addObject("page", page);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/indexBook", method = RequestMethod.POST)
	public ModelAndView showBookAll(ModelAndView modelAndView,
			@RequestParam("type") String type,
			@RequestParam("text") String text,
			@RequestParam("nowPageNumber") String nowPageNumber) {
		page.setPagesCount(bookService.selectCountByBook(
				Integer.parseInt(type), text));
		page.setNowPageNumber(Integer.parseInt(nowPageNumber));
		modelAndView.addObject("type", Integer.parseInt(type));
		modelAndView.addObject("text", text);
		modelAndView.addObject("page", page);
		modelAndView.addObject("list",
				bookService.selectAll(page, Integer.parseInt(type), text));
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(@ModelAttribute Books books) {
		return "addBook";
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public String success(@ModelAttribute("books") Books books,
			HttpServletRequest request) {
		books.setCreateDate(new Date());
		bookService.addBook(books);
		return "redirect:/indexBook";
	}
}
