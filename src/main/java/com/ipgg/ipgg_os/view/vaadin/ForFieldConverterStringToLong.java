package com.ipgg.ipgg_os.view.vaadin;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;

public class ForFieldConverterStringToLong implements Converter<String,Long> {

	@Override
	public Result<Long> convertToModel(String value, ValueContext context) {
		try {
			return Result.ok(Long.valueOf(value));
		}catch (NumberFormatException e) {
			return Result.error("Favor entrar com um Número");
		}		
	}

	@Override
	public String convertToPresentation(Long value, ValueContext context) {
		return String.valueOf(value);
	}

}
