package com.flp.fms.domain;

public class Language {

		//Private Fields
		private int language_Id;
		private String languageName;

	//No Argument Constructor	
	public Language(){}

	//Argument Constructor	
	public Language(int language_Id,String languageName){
		super();
			this.language_Id=language_Id;
			this.languageName=languageName;
	}

	//Getters And Setters
	public int getLanguage_Id() {
		return language_Id;
	}

	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Language [language_Id=" + language_Id + ", languageName=" + languageName + "]";
	}

	
	
}
