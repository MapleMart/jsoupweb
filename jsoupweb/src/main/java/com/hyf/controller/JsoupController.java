package com.hyf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsoupController {
	
	@RequestMapping("/jsoup.do")
	public String jsoup(String href,Model model){
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("href", href);
			Document doc = Jsoup.connect(href).get();
			String title = doc.select(".widget").select(".prod-info-title").select("h1").text();
			map.put("title", title);
			String jpg = doc.select(".item").select(".current").select("a").select("img").attr("data-normal");
			map.put("jpg", jpg);
			String productDetails = doc.select(".title").text();
			map.put("productDetails", productDetails);
			String keyFeatures = doc.select(".widget").select("h2").text();
			map.put("keyFeatures", keyFeatures);
			String keyFeaturesText = doc.select(".pull-left").select("p").text();
			map.put("keyFeaturesText", keyFeaturesText);
			Elements es = doc.select(".table").select(".table-condensed").select("tbody").select("tr");
			List<String> list = new ArrayList<String>();
			for (Element e : es) {
				list.add(e.select(".strong-title").text() + "  :  " + e.select("span").text());
			}
			map.put("list", list);
			model.addAttribute("map", map);
			return "index";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
