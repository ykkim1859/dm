package com.sdk.dm.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("page")
public class PAGE_DTO {
	private int page;			// 페이지
	private int maxPage;		// 한 페이지 내 마지막 글
	private int startPage;		// 시작 페이지
	private int endPage;		// 마지막 페이지
	private int startRow;		// 시작 게시글 번호
	private int endRow;			// 마지막 게시글 번호
	private int limit;			// 한 페이지당 보여줄 게시글 갯수
}
