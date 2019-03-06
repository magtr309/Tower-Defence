import java.util.Comparator;

public class SequenceComparator implements Comparator<Checkpoint>{
public int compare(Checkpoint o1, Checkpoint o2) {
	return o1.getSequence() + (-o2.getSequence());
}
}
