package com.ipgg.ipgg_os.service;

public interface Command<ParamType, ReturnType> {

	public ReturnType execute(ParamType param) throws Exception;

}
