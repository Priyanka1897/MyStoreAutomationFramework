package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver ldriver;
	//Constructor
	public SearchResultPage(WebDriver rdriver) {
		
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement Searchbox;
	
	@FindBy(name ="submit_search")
	WebElement submit_search;
	
	@FindBy(xpath ="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']//a[@title='Printed Dress'][normalize-space()='Printed Dress']")
	WebElement searchResultProduct;

	@FindBy(xpath ="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']//div[@class='product-image-container']")
	WebElement ClickOnSearchResult;
	
	@FindBy(id="color_24")
	WebElement ClickOnPinkColor;
	
	public void search(String searchkey) {
		Searchbox.sendKeys(searchkey);
	}
	
	public void ClickOnSearchButton()
	{
		submit_search.click();

	}
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
		
	}
	
	
	public void ClickOnResult() {
		ClickOnSearchResult.click();
	}
	
	public void ClickOnColor() {
		ClickOnPinkColor.click();
	}
	
	
}
