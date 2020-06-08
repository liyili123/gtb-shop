package com.gtb.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.gtb.pojo.TbSpecification;
import com.gtb.pojo.TbSpecificationOption;

public class GtbSpecification implements Serializable{

	private TbSpecification specification;

	private List<TbSpecificationOption> specificationOptionList;

	public TbSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}

	public List<TbSpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}

	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}

}
