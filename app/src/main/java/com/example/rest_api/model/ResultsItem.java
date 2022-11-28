package com.example.rest_api.model;

public class ResultsItem{
	private String difficulty;
	private String times;
	private String thumb;
	private String title;
	private String key;
	private String serving;

	public void setDifficulty(String difficulty){
		this.difficulty = difficulty;
	}

	public String getDifficulty(){
		return difficulty;
	}

	public void setTimes(String times){
		this.times = times;
	}

	public String getTimes(){
		return times;
	}

	public void setThumb(String thumb){
		this.thumb = thumb;
	}

	public String getThumb(){
		return thumb;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setServing(String serving){
		this.serving = serving;
	}

	public String getServing(){
		return serving;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"difficulty = '" + difficulty + '\'' + 
			",times = '" + times + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",title = '" + title + '\'' + 
			",key = '" + key + '\'' + 
			",serving = '" + serving + '\'' + 
			"}";
		}
}
