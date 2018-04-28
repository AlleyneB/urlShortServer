package com.alleyne.service;

public interface IConvertService {
	/**
	 * shortUrl to longUrl
	 * @param shortUrl
	 * @return longUrl
	 */
	String getUrl(String shortUrl);
	/**
	 * longUrl to shortUrl
	 * @param longUrl
	 * @return shortUrl
	 */
	String setUrl(String longUrl);
}
