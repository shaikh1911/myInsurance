
public class CyclicRotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicRotation Cr=new CyclicRotation();
		int A[]= {1,2,3,4,5};
		int ans=Cr.solution(A,4);
	}

}
 class CyclicRotation {
	  public int[] solution(int[] A, int K) {
	    int [] rotatedA = new int[A.length];
	   
	    for(int i=0; i<A.length; i++) {
	      //rotated index needs to "wrap" around end of array
	      int rotatedIndex = (i + K) % A.length;

	      rotatedA[rotatedIndex] = A[i];
	    }
	    return rotatedA;
	  }
	}