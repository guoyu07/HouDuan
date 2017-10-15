package com.soecode.lyf.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Collections;
import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.service.CollectionService;
import com.soecode.lyf.service.CorderService;
import com.soecode.lyf.utils.JsonOperator;

@Controller
public class CollectionController {

	@Autowired
	CollectionService collectionService;
	
	@Autowired
	CorderService corderService;
	
	
	@RequestMapping(value = "/addCollections", method = RequestMethod.POST)
	private String addCollections(@RequestParam("oid") int oid,@RequestParam("uid") int uid) {
		collectionService.addCollection(oid,uid);
		corderService.updateNum("coll_num", oid);
		return "corder/collectionListJsp";
	}
	
	@RequestMapping(value = "/deleteCollections", method = RequestMethod.GET)
	private String deleteCollections(@RequestParam("cid") int cid) {
		collectionService.delCollection(cid);
		return "corder/collectionListJsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/findCollectionByUid", method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	private String findCollectionByUid(@RequestParam("uid") int uid) {
		JsonCode<Collections> jsonCode = new JsonCode<Collections>();
		List<Collections> collectionList = collectionService.findByUid(uid);
		if(collectionList.size() != 0) {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(collectionList);
		} else {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		return JsonOperator.toJson(jsonCode);
	}
		
}
