package com.gtb.manager.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gtb.pojo.TbBrand;
import com.gtb.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService bService;

	Log logger = LogFactory.getLog(BrandController.class);

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {

		return bService.findAll();
	}

	@RequestMapping("/findPage")
	public PageResult findPageResult(int page, int size) {

		return bService.findPage(page, size);
	}

	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand) {
		try {
			bService.add(tbBrand);
			logger.info("add brand success");
			return new Result(true, "新增品牌成功");
		} catch (Exception e) {
			logger.warn("process fail", e);
			return new Result(false, "新增品牌失败");
		}
	}

	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return bService.findOne(id);
	}

	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand) {
		try {
			bService.update(tbBrand);
			return new Result(true, "修改品牌成功");
		} catch (Exception e) {
			logger.warn("process fail", e);
			return new Result(false, "修改品牌失败");
		}
	}

	@RequestMapping("/delete")
	public Result delete(Long[] longs) {
		try {
			bService.delete(longs);
			return new Result(true, "删除品牌成功");
		} catch (Exception e) {
			logger.warn("delete fail", e);
			return new Result(false, "删除品牌失败");
		}
	}

	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand, int page, int size) {
		return bService.findPage(tbBrand, page, size);
	}

}
