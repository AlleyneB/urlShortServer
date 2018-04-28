package com.alleyne.service.impl;

import com.alleyne.dao.UrlDao;
import com.alleyne.service.IConvertService;
import com.alleyne.utils.NumConverter;

public class ConvertServiceImpl implements IConvertService {
	
	UrlDao dao = new UrlDao();
	
	public String getUrl(String shortUrl) {
		int id = NumConverter._62To10(shortUrl);
		return dao.getUrl(id);
	}

	public String setUrl(String longUrl) {
		return NumConverter._10To62(dao.addUrl(longUrl));
	}

}
