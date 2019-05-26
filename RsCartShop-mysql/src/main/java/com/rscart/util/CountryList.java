package com.rscart.util;

import java.util.List;

public class CountryList {
   private List<Country> conlist;

public List<Country> getConlist() {
	return conlist;
}

public void setConlist(List<Country> conlist) {
	this.conlist = conlist;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CountryList [conlist=");
	builder.append(conlist);
	builder.append("]");
	return builder.toString();
}
   
}
