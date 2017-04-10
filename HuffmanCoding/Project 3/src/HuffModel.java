import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class HuffModel implements IHuffModel {
	//viewer object for communication between GUI and Model
	protected HuffViewer viewer;

	//Character counter object used for establishing weights/frequency of each chunk/char.
	private CharCounter cc = new CharCounter();
	@Override
	public void showCodings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCounts() {
		// updates the gui 'char count' 
		// by passing the collection of chunk - frequencies to the viewer
		viewer.update(cc.getFreqCollection());				
	}

	@Override
	public void initialize(InputStream stream) {
		//viewer calls and passes filestream
		
		try{
		cc.countAll(stream);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void write(InputStream stream, File file, boolean force) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setViewer(HuffViewer viewer) {
		// TODO Auto-generated method stub
		this.viewer = viewer;
	}

	@Override
	public void uncompress(InputStream in, OutputStream out) {
		// TODO Auto-generated method stub

	}

}
