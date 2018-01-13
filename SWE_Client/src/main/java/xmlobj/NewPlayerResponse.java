package xmlobj;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class NewPlayerResponse {
	int ID;

	public int getID() {
		return ID;
	}
	@XmlElement
	public void setID(int iD) {
		ID = iD;
	}
}
