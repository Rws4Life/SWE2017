package xmlobj;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class CreateNewMapRequest {
	int ID; String mapHalf;
	
	public int getID() {
		return ID;
	}
	@XmlElement
	public void setID(int iD) {
		ID = iD;
	}
	public String getMapHalf() {
		return mapHalf;
	}
	@XmlElement
	public void setMapHalf(String mapHalf) {
		this.mapHalf = mapHalf;
	}
}
