package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginateServiceImpl;
@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginateServiceImpl paginateService;
	private int totalPage=9;
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		
		int totalData = categoryService.GetAllProductById(Integer.parseInt(id)).size();
		PaginatesDto paginatecInfo = paginateService.GetInfoPaginates(totalData, 9, 1);
		_mvShare.addObject("paginatecInfo", paginatecInfo);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("ProductsPanigate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginatecInfo.getStart(), totalPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		
		int totalData = categoryService.GetAllProductById(Integer.parseInt(id)).size();
		PaginatesDto paginatecInfo = paginateService.GetInfoPaginates(totalData, 9, Integer.parseInt(currentPage));
		_mvShare.addObject("paginatecInfo", paginatecInfo);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("ProductsPanigate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginatecInfo.getStart(), totalPage));
		return _mvShare;
	}
	
}