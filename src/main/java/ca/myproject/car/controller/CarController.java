package ca.myproject.car.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ca.myproject.car.dao.CarAdDao;
import ca.myproject.car.model.CarAd;
import ca.myproject.helper.AjaxResponseBody;
import ca.myproject.helper.CarService;
import ca.myproject.helper.SearchCriteria;
import ca.myproject.search.CarSearch;

@Controller
public class CarController {
	private Path path;
	@Autowired
	CarAdDao carAdDao;

	CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	};

	@RequestMapping("/car/addCarAd")
	String getAddCarad(Model model) {
		CarAd carAd = new CarAd();

		Map<String, String> carMakeList = new HashMap<>();
		carMakeList = carService.getCarModelMap();
		model.addAttribute("carAd", carAd);
		model.addAttribute("carMake", carMakeList);

		return "/car/addCarAd";
	}

	@RequestMapping(value = "/car/getModel", method = RequestMethod.POST)
	@ResponseBody
	// @RequestBody CarMake carMakeVal Map<String, String>
	public AjaxResponseBody getSubcatList(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		// Map resultMap=dataList.get(search.getName());
		Map resultMap = carService.getCarMakeModelMap(search.getName());
		// return dataList.get(str);
		result.setMapResult(resultMap);
		// return new ResponseEntity<String>(str,HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/car/addCarAd", method = RequestMethod.POST)
	String getAddCaradPost(@ModelAttribute("carad") CarAd carad, HttpServletRequest request) throws IOException {
	    UUID idOne = UUID.randomUUID();

		carad.setFirstImageId(idOne.toString());
		carAdDao.addCarAd(carad);
		MultipartFile productImage = carad.getCarImage();
		String root = request.getSession().getServletContext().getRealPath("/");
		path = Paths
				.get(root + "\\WEB-INF\\resources\\images\\" + carad.getId() + "\\" + carad.getFirstImageId() + ".jpg");
		Files.createDirectories(path.getParent());

		if (productImage != null && !productImage.isEmpty())

		{
			try {
				File test = new File(path.toString());
				productImage.transferTo(test);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(" File failed to upload", e);
			}

		}

		return "/car/carSuccess";
	}

	@RequestMapping("/car/addList")
	String getAdList(Model model) {
		Map<String, String> carMakeList = new HashMap<>();
		carMakeList = carService.getCarModelMap();
		CarSearch carSearch = new CarSearch();
		List<CarAd> carAdList = carAdDao.getListAllCarAd();
		model.addAttribute("caradlist", carAdList);
		model.addAttribute("carMake", carMakeList);
		model.addAttribute("carSearch",carSearch );
		
		return "/car/carAdList";
	}
}
