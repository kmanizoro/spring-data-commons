package org.springframework.data.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic {@code Page} builder.
 *
 * @param <T> the type of which the page consists.
 * @author Mani Kasi
 */
public class PageBuilder<T> {

	private List<T> elements = new ArrayList<>();
	private Pageable pageRequest;
	private int totalElements;

	/**
	 * Constructor of {@code PageBuilder}.
	 * @param elements content of page, must not be {@literal null}.
	 */
	public PageBuilder(List<T> elements) {
		this.elements = elements;
	}

	/**
	 * Elements method - content of page
	 * @param elements content of page, must not be {@literal null}.
	 * @return {@link PageBuilder}
	 */
	public PageBuilder<T> elements(List<T> elements) {
		this.elements = elements;
		return this;
	}

	/**
	 * pageRequest of page
	 * @param pageRequest Pageable of page.
	 * @return {@link PageBuilder}
	 */
	public PageBuilder<T> pageRequest(Pageable pageRequest) {
		this.pageRequest = pageRequest;
		return this;
	}

	/**
	 * totalElements of page
	 * @param totalElements no of elements in page.
	 * @return {@link PageBuilder}
	 */
	public PageBuilder<T> totalElements(int totalElements) {
		this.totalElements = totalElements;
		return this;
	}

	/**
	 * To build the PageImpl object.
	 * @return {@link PageImpl}
	 */
	public Page<T> build() {
		return new PageImpl<>(elements, pageRequest, totalElements);
	}
}
