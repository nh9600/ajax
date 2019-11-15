package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface ColorService {
	List<Map<String,String>> selectColorList(Map<String,String> color);

}
