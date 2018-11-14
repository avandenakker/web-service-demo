package nl.ilionx.webservicedemo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import nl.ilionx.webservicedemo.model.DemoObject;

public class RestPageImpl extends PageImpl<DemoObject> {

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RestPageImpl(@JsonProperty("content") List<DemoObject> content,
	                        @JsonProperty("number") int number,
	                        @JsonProperty("size") int size,
	                        @JsonProperty("totalElements") Long totalElements,
	                        @JsonProperty("pageable") JsonNode pageable,
	                        @JsonProperty("last") boolean last,
	                        @JsonProperty("totalPages") int totalPages,
	                        @JsonProperty("sort") JsonNode sort,
	                        @JsonProperty("first") boolean first,
	                        @JsonProperty("numberOfElements") int numberOfElements) {

	        super(content, PageRequest.of(number, size), totalElements);
	}

	public RestPageImpl(List<DemoObject> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public RestPageImpl(List<DemoObject> content) {
		super(content);
	}
	
	public RestPageImpl() {
		super(new ArrayList());
	}
	
	
}