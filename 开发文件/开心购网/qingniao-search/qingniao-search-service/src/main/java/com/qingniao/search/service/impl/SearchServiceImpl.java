package com.qingniao.search.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.search.service.SearchService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class SearchServiceImpl implements SearchService {

}
