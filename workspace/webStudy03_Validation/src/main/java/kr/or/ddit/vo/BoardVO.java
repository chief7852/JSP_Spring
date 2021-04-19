package kr.or.ddit.vo;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.mvc.filter.wrapper.MultipartFile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * 
 * 공지글/ 게시글을 공통으로 관리할 domain layer
 *
 */
@Data
@EqualsAndHashCode(of="bo_no")
@ToString(exclude= {"attatchList","replyList"})
public class BoardVO implements Serializable{
	
	private Integer bo_sort;
	private String bo_type;
	private Integer bo_no;
	@NotBlank
	private String bo_title;
	private String bo_writer;
	private String bo_pass;
	private String bo_content;
	private String bo_date;
	private Integer bo_hit;
	private Integer bo_rec;
	private Integer bo_rep;
	private String bo_sec;
	private Integer bo_parent;
	
	private int startAttNo;
	private List<AttatchVO> attatchList;
	private List<Reply2VO> replyList;
}
