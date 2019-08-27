package com.jk.mapper;

import java.util.List;
import java.util.Map;

public interface HighDao {

    List<Map<String, Object>> queryColu();

    List<Map<String, Object>> queryline();
}
