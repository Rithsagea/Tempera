package tempera.graphics;

import java.util.Comparator;

public class RenderedObjectComparator implements Comparator<RenderedObject> {

	@Override
	public int compare(RenderedObject o1, RenderedObject o2) {
		int comp = o1.getRenderLevel() - o2.getRenderLevel();
		if(comp == 0)
			return o1.getDrawLevel() - o2.getDrawLevel();
		return comp;
	}

}
