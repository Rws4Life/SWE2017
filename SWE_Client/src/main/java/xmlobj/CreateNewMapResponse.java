package xmlobj;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class CreateNewMapResponse {
	String fullMap;

	public String getFullMap() {
		return fullMap;
	}
	@XmlElement
	public void setFullMap(String fullMap) {
		this.fullMap = fullMap;
	}
}
