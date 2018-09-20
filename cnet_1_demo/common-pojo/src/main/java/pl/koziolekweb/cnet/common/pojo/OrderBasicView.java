package pl.koziolekweb.cnet.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderBasicView implements Serializable {

	private final String subject;
	private final String customer;
}
