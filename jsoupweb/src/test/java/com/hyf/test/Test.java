package com.hyf.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.miniinthebox.com/solid-color-with-touch-screen-full-body-case-for-iphone-4-4s-assorted-color_p1266944.html?pos=ultimately_buy_10").get();

		String title = doc.select(".widget").select(".prod-info-title").select("h1").text();

		System.out.println(title);
		System.out.println();

		String jpg = doc.select(".item").select(".current").select("a").select("img").attr("data-normal");
		System.out.println(jpg);
		System.out.println();

		Elements sx = doc.select(".table").select(".table-condensed").select("tbody").select("tr");

		for (Element e : sx) {
			System.out.print(e.select(".strong-title").text() + " : ");
			System.out.println(e.select("span").text());
		}

	}

}
