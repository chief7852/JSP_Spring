package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"alId"})
public class AlbaVO {
	
	@NotBlank(groups=UpdateGroup.class)
	private String alId;
	@NotBlank
	private String alName; 
	private Integer alAge; 
	@NotBlank
	private String alZip; 
	@NotBlank
	private String alAdd1; 
	@NotBlank
	private String alAdd2; 
	@NotBlank
	private String alHp; 
	
	@NotBlank
	private String grCode;
	private String grName;
	
	@NotBlank
	private String alGen;
	@NotBlank
	private String alMail; 
	private String alSpec; 
	private String alDesc;
	
	
	private String alImg;
}
