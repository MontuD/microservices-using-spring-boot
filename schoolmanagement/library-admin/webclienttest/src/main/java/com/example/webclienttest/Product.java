package com.example.webclienttest;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Integer id;
	private String title;
	private String description;
	private Integer price;
	private Double discountPercentage;
	private Double rating;
	private Integer stock;
	private String brand;
	private String category;
	private String thumbnail;
	private List<String> images;

}
